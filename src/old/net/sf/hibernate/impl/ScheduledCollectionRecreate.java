// $Id: ScheduledCollectionRecreate.java,v 1.2 2005/04/03 06:29:04 nick Exp $
package net.sf.hibernate.impl;

import java.io.Serializable;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.collection.CollectionPersister;
import net.sf.hibernate.collection.PersistentCollection;
import net.sf.hibernate.engine.SessionImplementor;

final class ScheduledCollectionRecreate extends ScheduledCollectionAction
        implements SessionImpl.Executable {

    private final PersistentCollection collection;

    public ScheduledCollectionRecreate(PersistentCollection collection,
            CollectionPersister persister, Serializable id,
            SessionImplementor session) {
        super(persister, id, session);
        this.collection = collection;
    }

    public void execute() throws HibernateException {
        CollectionPersister persister = getPersister();
        if (persister.hasCache())
            setLock(persister.getCache().lock(getId()));
        persister.recreate(collection, getId(), getSession());
        if (persister.hasCache())
            persister.getCache().evict(getId());
    }

}

