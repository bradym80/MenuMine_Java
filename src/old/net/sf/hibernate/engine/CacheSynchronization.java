//$Id: CacheSynchronization.java,v 1.2 2005/04/03 06:29:04 nick Exp $
package net.sf.hibernate.engine;

import javax.transaction.Status;
import javax.transaction.Synchronization;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author Gavin King
 */
public final class CacheSynchronization implements Synchronization {

    private static final Log log = LogFactory
            .getLog(CacheSynchronization.class);

    private final SessionImplementor session;

    public CacheSynchronization(SessionImplementor session) {
        this.session = session;
    }

    public void beforeCompletion() {
        log.trace("transaction before completion callback");
    }

    public void afterCompletion(int status) {
        if (log.isTraceEnabled())
            log.trace("transaction after completion callback, status: "
                    + status);
        session.afterTransactionCompletion(status == Status.STATUS_COMMITTED);
    }

}