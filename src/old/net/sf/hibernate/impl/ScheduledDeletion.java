// $Id: ScheduledDeletion.java,v 1.2 2005/04/03 06:29:04 nick Exp $
package net.sf.hibernate.impl;

import java.io.Serializable;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.cache.CacheConcurrencyStrategy.SoftLock;
import net.sf.hibernate.engine.SessionImplementor;
import net.sf.hibernate.persister.ClassPersister;

final class ScheduledDeletion extends ScheduledEntityAction implements
        SessionImpl.Executable {

    private final Object version;

    private SoftLock lock;

    public ScheduledDeletion(Serializable id, Object version, Object instance,
            ClassPersister persister, SessionImplementor session) {
        super(session, id, instance, persister);
        this.version = version;
    }

    public void execute() throws HibernateException {
        Serializable id = getId();
        ClassPersister persister = getPersister();
        SessionImplementor session = getSession();
        Object instance = getInstance();

        if (persister.hasCache())
            lock = persister.getCache().lock(id);

        persister.delete(id, version, instance, session);
        session.postDelete(instance);

        if (persister.hasCache())
            persister.getCache().evict(id);
    }

    public void afterTransactionCompletion(boolean success)
            throws HibernateException {
        if (getPersister().hasCache())
            getPersister().getCache().release(getId(), lock);
    }

}

