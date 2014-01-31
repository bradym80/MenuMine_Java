// $Id: ListType.java,v 1.2 2005/04/03 06:29:03 nick Exp $
package net.sf.hibernate.type;

import java.io.Serializable;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.collection.CollectionPersister;
import net.sf.hibernate.collection.List;
import net.sf.hibernate.collection.PersistentCollection;
import net.sf.hibernate.engine.SessionImplementor;

public class ListType extends PersistentCollectionType {

    public ListType(String role) {
        super(role);
    }

    public PersistentCollection instantiate(SessionImplementor session,
            CollectionPersister persister) {
        return new List(session);
    }

    public Class getReturnedClass() {
        return java.util.List.class;
    }

    public PersistentCollection wrap(SessionImplementor session,
            Object collection) {
        return new List(session, (java.util.List) collection);
    }

    public PersistentCollection assembleCachedCollection(
            SessionImplementor session, CollectionPersister persister,
            Serializable disassembled, Object owner) throws HibernateException {

        return new List(session, persister, disassembled, owner);
    }

}

