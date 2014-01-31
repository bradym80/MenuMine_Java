// $Id: ScheduledCollectionUpdate.java,v 1.2 2005/04/03 06:29:04 nick Exp $
package net.sf.hibernate.impl;

import java.io.Serializable;

import net.sf.hibernate.AssertionFailure;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.collection.CollectionPersister;
import net.sf.hibernate.collection.PersistentCollection;
import net.sf.hibernate.engine.SessionImplementor;

final class ScheduledCollectionUpdate extends ScheduledCollectionAction
        implements SessionImpl.Executable {

    private final PersistentCollection collection;

    private final boolean emptySnapshot;

    public ScheduledCollectionUpdate(PersistentCollection collection,
            CollectionPersister persister, Serializable id,
            boolean emptySnapshot, SessionImplementor session) {
        super(persister, id, session);
        this.collection = collection;
        this.emptySnapshot = emptySnapshot;
    }

    public void execute() throws HibernateException {
        Serializable id = getId();
        SessionImplementor session = getSession();
        CollectionPersister persister = getPersister();

        if (persister.hasCache())
            setLock(persister.getCache().lock(id));

        if (!collection.wasInitialized()) {
            if (!collection.hasQueuedAdditions())
                throw new AssertionFailure("bug processing queued adds");
            //do nothing - we only need to notify the cache...
        } else if (collection.empty()) {
            if (!emptySnapshot)
                persister.remove(id, session);
        } else if (collection.needsRecreate(getPersister())) {
            if (!emptySnapshot)
                persister.remove(id, session);
            persister.recreate(collection, id, session);
        } else {
            persister.deleteRows(collection, id, session);
            persister.updateRows(collection, id, session);
            persister.insertRows(collection, id, session);
        }

        if (persister.hasCache())
            persister.getCache().evict(id);
    }

}

