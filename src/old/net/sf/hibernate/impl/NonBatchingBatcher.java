//$Id: NonBatchingBatcher.java,v 1.2 2005/04/03 06:29:04 nick Exp $
package net.sf.hibernate.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.engine.SessionImplementor;

/**
 * An implementation of the <tt>Batcher</tt> interface that does no batching
 * 
 * @author Gavin King
 */
public class NonBatchingBatcher extends BatcherImpl {

    public NonBatchingBatcher(SessionImplementor session) {
        super(session);
    }

    public void addToBatch(int expectedRowCount) throws SQLException,
            HibernateException {
        int rowCount = getStatement().executeUpdate();
        //negative expected row count means we don't know how many rows to
        // expect
        if (expectedRowCount > 0 && expectedRowCount != rowCount)
            throw new HibernateException(
                    "SQL update or deletion failed (row not found)");
    }

    protected void doExecuteBatch(PreparedStatement ps) throws SQLException,
            HibernateException {
    }

}

