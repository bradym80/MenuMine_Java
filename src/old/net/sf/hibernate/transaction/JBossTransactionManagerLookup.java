//$Id: JBossTransactionManagerLookup.java,v 1.2 2005/04/03 06:29:03 nick Exp $
package net.sf.hibernate.transaction;

/**
 * A <tt>TransactionManager</tt> lookup strategy for JBoss
 * 
 * @author Gavin King
 */
public final class JBossTransactionManagerLookup extends
        JNDITransactionManagerLookup {

    protected String getName() {
        return "java:/TransactionManager";
    }

    public String getUserTransactionName() {
        return "UserTransaction";
    }

}

