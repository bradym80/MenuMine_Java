//$Id: ResinTransactionManagerLookup.java,v 1.2 2005/04/03 06:29:03 nick Exp $
package net.sf.hibernate.transaction;

/**
 * TransactionManager lookup strategy for Resin
 * 
 * @author Aapo Laakkonen
 */
public class ResinTransactionManagerLookup extends JNDITransactionManagerLookup {

    /**
     * @see net.sf.hibernate.transaction.JNDITransactionManagerLookup#getName()
     */
    protected String getName() {
        return "java:comp/TransactionManager";
    }

    public String getUserTransactionName() {
        return "java:comp/UserTransaction";
    }

}

