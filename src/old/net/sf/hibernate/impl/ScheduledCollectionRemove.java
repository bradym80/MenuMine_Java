// $Id: ScheduledCollectionRemove.java,v 1.2 2005/04/03 06:29:04 nick Exp $
package net.sf.hibernate.impl;

import java.io.Serializable;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.collection.CollectionPersister;
import net.sf.hibernate.engine.SessionImplementor;

final class ScheduledCollectionRemove extends ScheduledCollectionAction
        implements SessionImpl.Executable {

    private boolean emptySnapshot;

    public ScheduledCollectionRemove(CollectionPersister persister,
            Serializable id, boolean emptySnapshot, SessionImplementor session) {
        super(persister, id, session);
        this.emptySnapshot = emptySnapshot;
    }

    public void execute() throws HibernateException {
        CollectionPersister persister = getPersister();
        if (persister.hasCache())
            setLock(persister.getCache().lock(getId()));
        if (!emptySnapshot)
            persister.remove(getId(), getSession());
        if (persister.hasCache())
            persister.getCache().evict(getId());
    }

}

