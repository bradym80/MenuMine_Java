// $Id: ScheduledEntityAction.java,v 1.2 2005/04/03 06:29:04 nick Exp $
package net.sf.hibernate.impl;

import java.io.Serializable;

import net.sf.hibernate.engine.SessionImplementor;
import net.sf.hibernate.impl.SessionImpl.Executable;
import net.sf.hibernate.persister.ClassPersister;

abstract class ScheduledEntityAction implements Executable {

    private final SessionImplementor session;

    private final Serializable id;

    private final ClassPersister persister;

    private final Object instance;

    protected ScheduledEntityAction(SessionImplementor session,
            Serializable id, Object instance, ClassPersister persister) {
        this.session = session;
        this.id = id;
        this.persister = persister;
        this.instance = instance;
    }

    public final Serializable[] getPropertySpaces() {
        return persister.getPropertySpaces();
    }

    protected final SessionImplementor getSession() {
        return session;
    }

    protected final Serializable getId() {
        return id;
    }

    protected final ClassPersister getPersister() {
        return persister;
    }

    protected final Object getInstance() {
        return instance;
    }

}

