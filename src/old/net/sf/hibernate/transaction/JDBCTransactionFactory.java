//$Id: JDBCTransactionFactory.java,v 1.3 2005/04/03 06:29:03 nick Exp $
package net.sf.hibernate.transaction;

import java.util.Properties;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Transaction;
import net.sf.hibernate.engine.SessionImplementor;

/**
 * Factory for <tt>JDBCTransaction</tt>.
 * 
 * @see JDBCTransaction
 * @author Anton van Straaten
 */
public final class JDBCTransactionFactory implements TransactionFactory {

    public Transaction beginTransaction(SessionImplementor session)
            throws HibernateException {
        JDBCTransaction tx = new JDBCTransaction(session);
        tx.begin();
        return tx;
    }

    public void configure(Properties props) throws HibernateException {
    }

}

