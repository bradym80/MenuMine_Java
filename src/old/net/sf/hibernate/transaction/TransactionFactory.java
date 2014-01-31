//$Id: TransactionFactory.java,v 1.2 2005/04/03 06:29:03 nick Exp $
package net.sf.hibernate.transaction;

import java.util.Properties;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Transaction;
import net.sf.hibernate.engine.SessionImplementor;

/**
 * An abstract factory for <tt>Transaction</tt> instances. Concrete
 * implementations are specified by <tt>hibernate.transaction.factory_class</tt>.
 * <br>
 * <br>
 * Implementors must be threadsafe and should declare a public default
 * constructor.
 * 
 * @see Transaction
 * @author Anton van Straaten, Gavin King
 */
public interface TransactionFactory {
    /**
     * Begin a transaction and return the associated <tt>Transaction</tt>
     * instance.
     * 
     * @param session
     *            the session
     * @return Transaction
     * @throws HibernateException
     */
    public Transaction beginTransaction(SessionImplementor session)
            throws HibernateException;

    /**
     * Configure from the given properties.
     * 
     * @param props
     * @throws HibernateException
     */
    public void configure(Properties props) throws HibernateException;
}

