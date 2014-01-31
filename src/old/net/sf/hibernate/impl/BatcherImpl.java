//$Id: BatcherImpl.java,v 1.3 2005/04/03 06:29:04 nick Exp $
package net.sf.hibernate.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;

import net.sf.hibernate.AssertionFailure;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.JDBCException;
import net.sf.hibernate.engine.Batcher;
import net.sf.hibernate.engine.SessionFactoryImplementor;
import net.sf.hibernate.engine.SessionImplementor;
import net.sf.hibernate.util.JDBCExceptionReporter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Manages prepared statements and batching.
 * 
 * @author Gavin King
 */
public abstract class BatcherImpl implements Batcher {

    private static int openPreparedStatements;

    private static int openResultSetCount;

    protected static final Log log = LogFactory.getLog(BatcherImpl.class);

    protected static final Log sqlLog = LogFactory
            .getLog("net.sf.hibernate.SQL");

    private final SessionImplementor session;

    private final SessionFactoryImplementor factory;

    private PreparedStatement batchUpdate;

    private String batchUpdateSQL;

    private HashSet statementsToClose = new HashSet();

    private HashSet resultSetsToClose = new HashSet();

    private PreparedStatement lastQuery;

    public BatcherImpl(SessionImplementor session) {
        this.session = session;
        this.factory = session.getFactory();
    }

    protected PreparedStatement getStatement() {
        return batchUpdate;
    }

    public PreparedStatement prepareStatement(String sql) throws SQLException,
            HibernateException {
        executeBatch();
        logOpenPreparedStatement();
        return getPreparedStatement(session.connection(), sql, false);
    }

    public PreparedStatement prepareQueryStatement(String sql,
            boolean scrollable) throws SQLException, HibernateException {
        logOpenPreparedStatement();
        PreparedStatement ps = getPreparedStatement(session.connection(), sql,
                scrollable);
        setStatementFetchSize(ps);
        statementsToClose.add(ps);
        lastQuery = ps;
        return ps;
    }

    public void abortBatch(SQLException sqle) {
        //JDBCExceptionReporter.logExceptions(sqle);
        final PreparedStatement ps = batchUpdate;
        batchUpdate = null;
        batchUpdateSQL = null;
        try {
            closeStatement(ps);
        } catch (SQLException e) {
            //noncritical, swallow and let the other propagate!
            JDBCExceptionReporter.logExceptions(e);
        }
    }

    public ResultSet getResultSet(PreparedStatement ps) throws SQLException {
        ResultSet rs = ps.executeQuery();
        resultSetsToClose.add(rs);
        logOpenResults();
        return rs;
    }

    public void closeQueryStatement(PreparedStatement ps, ResultSet rs)
            throws SQLException {
        statementsToClose.remove(ps);
        if (rs != null)
            resultSetsToClose.remove(rs);
        try {
            if (rs != null) {
                logCloseResults();
                rs.close();
            }
        } finally {
            closeQueryStatement(ps);
        }
    }

    public PreparedStatement prepareBatchStatement(String sql)
            throws SQLException, HibernateException {
        if (!sql.equals(batchUpdateSQL)) {
            batchUpdate = prepareStatement(sql); // calls executeBatch()
            batchUpdateSQL = sql;
        }
        return batchUpdate;
    }

    public void executeBatch() throws HibernateException {
        if (batchUpdate != null) {
            final PreparedStatement ps = batchUpdate;
            batchUpdate = null;
            batchUpdateSQL = null;
            try {
                try {
                    doExecuteBatch(ps);
                } finally {
                    closeStatement(ps);
                }
            } catch (SQLException sqle) {
                throw new JDBCException("Could not execute JDBC batch update",
                        sqle);
            }
        }
    }

    public void closeStatement(PreparedStatement ps) throws SQLException {
        logClosePreparedStatement();
        closePreparedStatement(ps);
    }

    private void closeQueryStatement(PreparedStatement ps) throws SQLException {

        try {
            //work around a bug in all known connection pools....
            if (ps.getMaxRows() != 0)
                ps.setMaxRows(0);
            if (ps.getQueryTimeout() != 0)
                ps.setQueryTimeout(0);
        } catch (Exception e) {
            log.warn("exception clearing maxRows/queryTimeout", e);
            ps.close(); //just close it; do NOT try to return it to the pool!
            return; //NOTE: early exit!
        }

        closeStatement(ps);
    }

    public void closeStatements() {
        try {
            if (batchUpdate != null)
                batchUpdate.close();
        } catch (SQLException sqle) {
            //no big deal
            log.warn("Could not close a JDBC prepared statement", sqle);
        }
        batchUpdate = null;
        batchUpdateSQL = null;

        Iterator iter = resultSetsToClose.iterator();
        while (iter.hasNext()) {
            try {
                logCloseResults();
                ((ResultSet) iter.next()).close();
            } catch (SQLException e) {
                // no big deal
                log.warn("Could not close a JDBC result set", e);
            }
        }
        resultSetsToClose.clear();

        iter = statementsToClose.iterator();
        while (iter.hasNext()) {
            try {
                closeQueryStatement((PreparedStatement) iter.next());
            } catch (SQLException e) {
                // no big deal
                log.warn("Could not close a JDBC statement", e);
            }
        }
        statementsToClose.clear();
    }

    protected abstract void doExecuteBatch(PreparedStatement ps)
            throws SQLException, HibernateException;

    private static void logOpenPreparedStatement() {
        if (log.isTraceEnabled()) {
            log.trace("about to open: " + openPreparedStatements
                    + " open PreparedStatements, " + openResultSetCount
                    + " open ResultSets");
            openPreparedStatements++;
        }
    }

    private static void logClosePreparedStatement() {
        if (log.isTraceEnabled())
            openPreparedStatements--;
        log.trace("done closing: " + openPreparedStatements
                + " open PreparedStatements, " + openResultSetCount
                + " open ResultSets");
    }

    private static void logOpenResults() {
        if (log.isTraceEnabled())
            openResultSetCount++;
    }

    private static void logCloseResults() {
        if (log.isTraceEnabled())
            openResultSetCount--;
    }

    protected SessionImplementor getSession() {
        return session;
    }

    protected SessionFactoryImplementor getFactory() {
        return factory;
    }

    private PreparedStatement getPreparedStatement(final Connection conn,
            final String sql, boolean scrollable) throws SQLException {

        if (scrollable && !factory.isScrollableResultSetsEnabled()) {
            throw new AssertionFailure(
                    "Hibernate tried to grab a scrollable result set");
        }

        sqlLog.debug(sql);
        if (factory.isShowSqlEnabled())
            System.out.println("Hibernate: " + sql);

        try {
            log.trace("preparing statement");
            return scrollable ? conn.prepareStatement(sql,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY) : conn.prepareStatement(sql);
        } catch (SQLException sqle) {
            JDBCExceptionReporter.logExceptions(sqle);
            throw sqle;
        }
    }

    private void closePreparedStatement(PreparedStatement ps)
            throws SQLException {
        try {
            log.trace("closing statement");
            if (ps != null)
                ps.close(); //null check not absolutely necessary!
        } catch (SQLException sqle) {
            JDBCExceptionReporter.logExceptions(sqle);
            throw sqle;
        }

    }

    private void setStatementFetchSize(PreparedStatement statement)
            throws SQLException {
        Integer statementFetchSize = factory.getJdbcFetchSize();
        if (statementFetchSize != null)
            statement.setFetchSize(statementFetchSize.intValue());
    }

    public Connection openConnection() throws HibernateException {
        try {
            return factory.getConnectionProvider().getConnection();
        } catch (SQLException sqle) {
            throw new JDBCException("Cannot open connection", sqle);
        }
    }

    public void closeConnection(Connection conn) throws HibernateException {
        try {
            if (!conn.isClosed()) {
                JDBCExceptionReporter.logWarnings(conn.getWarnings());
                conn.clearWarnings();
            }
            factory.getConnectionProvider().closeConnection(conn);
        } catch (SQLException sqle) {
            throw new JDBCException("Cannot close connection", sqle);
        }
    }

    public void cancelLastQuery() throws HibernateException {
        try {
            if (lastQuery != null)
                lastQuery.cancel();
        } catch (SQLException sqle) {
            throw new JDBCException("Could not cancel query", sqle);
        }
    }

}

