//$Id: SettingsFactory.java,v 1.3 2005/04/03 06:29:05 nick Exp $
package net.sf.hibernate.cfg;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.cache.CacheProvider;
import net.sf.hibernate.connection.ConnectionProvider;
import net.sf.hibernate.connection.ConnectionProviderFactory;
import net.sf.hibernate.dialect.Dialect;
import net.sf.hibernate.dialect.GenericDialect;
import net.sf.hibernate.transaction.TransactionFactory;
import net.sf.hibernate.transaction.TransactionFactoryFactory;
import net.sf.hibernate.transaction.TransactionManagerLookup;
import net.sf.hibernate.transaction.TransactionManagerLookupFactory;
import net.sf.hibernate.util.PropertiesHelper;
import net.sf.hibernate.util.ReflectHelper;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Reads configuration properties and configures a <tt>Settings</tt> instance.
 * 
 * @author Gavin King
 */
public final class SettingsFactory {

    private static final Log log = LogFactory.getLog(SettingsFactory.class);

    public static Settings buildSettings(Properties properties)
            throws HibernateException {

        Settings settings = new Settings();

        Dialect dialect;
        try {
            dialect = Dialect.getDialect(properties);
            Properties temp = new Properties();
            //temp.putAll( Environment.getProperties() );
            temp.putAll(dialect.getDefaultProperties());
            temp.putAll(properties);
            properties = temp; // add the dialects default properties
        } catch (HibernateException he) {
            log.warn("No dialect set - using GenericDialect: "
                    + he.getMessage());
            dialect = new GenericDialect();
        }

        Integer statementFetchSize = PropertiesHelper.getInteger(
                Environment.STATEMENT_FETCH_SIZE, properties);
        if (statementFetchSize != null)
            log.info("JDBC result set fetch size: " + statementFetchSize);

        Integer maxFetchDepth = PropertiesHelper.getInteger(
                Environment.MAX_FETCH_DEPTH, properties);
        if (maxFetchDepth != null)
            log.info("Maximim outer join fetch depth: " + maxFetchDepth);

        //deprecated:
        boolean useOuterJoin = PropertiesHelper.getBoolean(
                Environment.USE_OUTER_JOIN, properties);
        log.info("Use outer join fetching: " + useOuterJoin);

        ConnectionProvider connections = ConnectionProviderFactory
                .newConnectionProvider(properties);
        TransactionFactory transactionFactory = TransactionFactoryFactory
                .buildTransactionFactory(properties);
        TransactionManagerLookup transactionManagerLookup = TransactionManagerLookupFactory
                .getTransactionManagerLookup(properties);

        boolean metaSupportsScrollable = false;
        int batchSize = PropertiesHelper.getInt(
                Environment.STATEMENT_BATCH_SIZE, properties, 0);
        try {
            Connection conn = connections.getConnection();
            try {
                DatabaseMetaData meta = conn.getMetaData();
                metaSupportsScrollable = meta
                        .supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE);
                if ((batchSize > 0) && !meta.supportsBatchUpdates())
                    batchSize = 0;
            } finally {
                connections.closeConnection(conn);
            }
        } catch (SQLException sqle) {
            log.warn("Could not obtain connection metadata", sqle);
        } catch (UnsupportedOperationException uoe) {
            // user supplied JDBC connections
        }

        boolean useScrollableResultSets = PropertiesHelper.getBoolean(
                Environment.USE_SCROLLABLE_RESULTSET, properties,
                metaSupportsScrollable);
        log.info("Use scrollable result sets: " + useScrollableResultSets);
        if (batchSize > 0)
            log.info("JDBC 2 max batch size: " + batchSize);

        String defaultSchema = properties
                .getProperty(Environment.DEFAULT_SCHEMA);
        if (defaultSchema != null)
            log.info("Default schema set to: " + defaultSchema);

        boolean showSql = PropertiesHelper.getBoolean(Environment.SHOW_SQL,
                properties);
        if (showSql)
            log.info("echoing all SQL to stdout");

        Map querySubstitutions = PropertiesHelper.toMap(
                Environment.QUERY_SUBSTITUTIONS, " ,=;:\n\t\r\f", properties);
        log.info("Query language substitutions: " + querySubstitutions);

        String autoSchemaExport = properties
                .getProperty(Environment.HBM2DDL_AUTO);
        if ("update".equals(autoSchemaExport))
            settings.setAutoUpdateSchema(true);
        if ("create".equals(autoSchemaExport))
            settings.setAutoCreateSchema(true);
        if ("create-drop".equals(autoSchemaExport)) {
            settings.setAutoCreateSchema(true);
            settings.setAutoDropSchema(true);
        }

        String cacheClassName = PropertiesHelper.getString(
                Environment.CACHE_PROVIDER, properties,
                "net.sf.ehcache.hibernate.Provider");
        log.info("cache provider: " + cacheClassName);
        try {
            settings.setCacheProvider((CacheProvider) ReflectHelper
                    .classForName(cacheClassName).newInstance());
        } catch (Exception cnfe) {
            throw new HibernateException(
                    "could not instantiate CacheProvider: " + cacheClassName,
                    cnfe);
        }

        boolean useQueryCache = PropertiesHelper.getBoolean(
                Environment.USE_QUERY_CACHE, properties);

        String sessionFactoryName = properties
                .getProperty(Environment.SESSION_FACTORY_NAME);

        settings.setStatementFetchSize(statementFetchSize);
        settings.setScrollableResultSetsEnabled(useScrollableResultSets);
        settings.setJdbcBatchSize(batchSize);
        settings.setDefaultSchemaName(defaultSchema);
        settings.setShowSqlEnabled(showSql);
        settings.setDialect(dialect);
        settings.setConnectionProvider(connections);
        settings.setQuerySubstitutions(querySubstitutions);
        settings.setTransactionFactory(transactionFactory);
        settings.setTransactionManagerLookup(transactionManagerLookup);
        settings.setSessionFactoryName(sessionFactoryName);
        settings.setOuterJoinFetchEnabled(useOuterJoin);
        settings.setMaximumFetchDepth(maxFetchDepth);
        settings.setQueryCacheEnabled(useQueryCache);

        return settings;

    }

    private SettingsFactory() {
    }

}