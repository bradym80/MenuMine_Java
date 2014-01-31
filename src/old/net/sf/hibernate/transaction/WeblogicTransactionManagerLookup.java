//$Id: WeblogicTransactionManagerLookup.java,v 1.2 2005/04/03 06:29:03 nick Exp $
package net.sf.hibernate.transaction;

/**
 * TransactionManager lookup strategy for WebLogic
 * 
 * @author Gavin King
 */
public final class WeblogicTransactionManagerLookup extends
        JNDITransactionManagerLookup {

    /**
     * @see net.sf.hibernate.transaction.JNDITransactionManagerLookup#getName()
     */
    protected String getName() {
        return "javax.transaction.TransactionManager";
    }

    public String getUserTransactionName() {
        return "javax.transaction.UserTransaction";
    }

}

