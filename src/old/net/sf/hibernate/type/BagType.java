// $Id: BagType.java,v 1.2 2005/04/03 06:29:03 nick Exp $
package net.sf.hibernate.type;

import java.io.Serializable;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.collection.Bag;
import net.sf.hibernate.collection.CollectionPersister;
import net.sf.hibernate.collection.PersistentCollection;
import net.sf.hibernate.engine.SessionImplementor;

public class BagType extends PersistentCollectionType {

    public BagType(String role) {
        super(role);
    }

    public PersistentCollection instantiate(SessionImplementor session,
            CollectionPersister persister) throws HibernateException {

        return new Bag(session);
    }

    public Class getReturnedClass() {
        return java.util.Collection.class;
    }

    public PersistentCollection wrap(SessionImplementor session,
            Object collection) {
        return new Bag(session, (java.util.Collection) collection);
    }

    public PersistentCollection assembleCachedCollection(
            SessionImplementor session, CollectionPersister persister,
            Serializable disassembled, Object owner) throws HibernateException {

        return new Bag(session, persister, disassembled, owner);
    }

}

