// $Id: SortedSetType.java,v 1.2 2005/04/03 06:29:03 nick Exp $
package net.sf.hibernate.type;

import java.io.Serializable;
import java.util.Comparator;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.collection.CollectionPersister;
import net.sf.hibernate.collection.PersistentCollection;
import net.sf.hibernate.collection.SortedSet;
import net.sf.hibernate.engine.SessionImplementor;

public class SortedSetType extends SetType {

    private final Comparator comparator;

    public SortedSetType(String role, Comparator comparator) {
        super(role);
        this.comparator = comparator;
    }

    public PersistentCollection instantiate(SessionImplementor session,
            CollectionPersister persister) {
        SortedSet set = new SortedSet(session);
        set.setComparator(comparator);
        return set;
    }

    public Class getReturnedClass() {
        return java.util.SortedSet.class;
    }

    public PersistentCollection wrap(SessionImplementor session,
            Object collection) {
        return new SortedSet(session, (java.util.SortedSet) collection);
    }

    public PersistentCollection assembleCachedCollection(
            SessionImplementor session, CollectionPersister persister,
            Serializable disassembled, Object owner) throws HibernateException {

        return new SortedSet(session, persister, comparator, disassembled,
                owner);
    }

}

