//$Id: TransactionManagerLookup.java,v 1.3 2005/04/03 06:29:03 nick Exp $
package net.sf.hibernate.transaction;

import java.util.Properties;

import javax.transaction.TransactionManager;

import net.sf.hibernate.HibernateException;

/**
 * Concrete implementations locate and return the JTA
 * <tt>TransactionManager</tt>.
 * 
 * @author Gavin King
 */
public interface TransactionManagerLookup {

    /**
     * Obtain the JTA <tt>TransactionManager</tt>
     */
    public TransactionManager getTransactionManager(Properties props)
            throws HibernateException;

    /**
     * Return the JNDI name of the JTA <tt>UserTransaction</tt> or
     * <tt>null</tt> (optional operation).
     */
    public String getUserTransactionName();

}

