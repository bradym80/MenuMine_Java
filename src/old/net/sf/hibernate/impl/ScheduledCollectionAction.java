// $Id: ScheduledCollectionAction.java,v 1.2 2005/04/03 06:29:04 nick Exp $
package net.sf.hibernate.impl;

import java.io.Serializable;

import net.sf.hibernate.cache.CacheException;
import net.sf.hibernate.cache.CacheConcurrencyStrategy.SoftLock;
import net.sf.hibernate.collection.CollectionPersister;
import net.sf.hibernate.engine.SessionImplementor;
import net.sf.hibernate.impl.SessionImpl.Executable;

abstract class ScheduledCollectionAction implements Executable {

    private final CollectionPersister persister;

    private final Serializable id;

    private final SessionImplementor session;

    private SoftLock lock;

    protected void setLock(SoftLock lock) {
        this.lock = lock;
    }

    public ScheduledCollectionAction(CollectionPersister persister,
            Serializable id, SessionImplementor session) {
        this.persister = persister;
        this.session = session;
        this.id = id;
    }

    public void afterTransactionCompletion(boolean success)
            throws CacheException {
        if (persister.hasCache())
            persister.getCache().release(id, lock);
    }

    public Serializable[] getPropertySpaces() {
        return new Serializable[] { persister.getCollectionSpace() };
    }

    protected final CollectionPersister getPersister() {
        return persister;
    }

    protected final Serializable getId() {
        return id;
    }

    protected final SessionImplementor getSession() {
        return session;
    }

}

