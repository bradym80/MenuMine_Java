// $Id: IdentifierBagType.java,v 1.2 2005/04/03 06:29:03 nick Exp $
package net.sf.hibernate.type;

import java.io.Serializable;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.collection.CollectionPersister;
import net.sf.hibernate.collection.IdentifierBag;
import net.sf.hibernate.collection.PersistentCollection;
import net.sf.hibernate.engine.SessionImplementor;

public class IdentifierBagType extends PersistentCollectionType {

    public IdentifierBagType(String role) {
        super(role);
    }

    public PersistentCollection instantiate(SessionImplementor session,
            CollectionPersister persister) throws HibernateException {

        return new IdentifierBag(session);
    }

    public Class getReturnedClass() {
        return java.util.Collection.class;
    }

    public PersistentCollection wrap(SessionImplementor session,
            Object collection) {
        return new IdentifierBag(session, (java.util.Collection) collection);
    }

    public PersistentCollection assembleCachedCollection(
            SessionImplementor session, CollectionPersister persister,
            Serializable disassembled, Object owner) throws HibernateException {

        return new IdentifierBag(session, persister, disassembled, owner);
    }

}

