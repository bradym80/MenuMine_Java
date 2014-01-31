//$Id: EvictVisitor.java,v 1.2 2005/04/03 06:29:04 nick Exp $
package net.sf.hibernate.impl;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.type.PersistentCollectionType;

/**
 * Evict any collections referenced by the object from the session cache. This
 * will NOT pick up any collections that were dereferenced, so they will be
 * deleted (suboptimal but not exactly incorrect).
 * 
 * @author Gavin King
 */
class EvictVisitor extends AbstractVisitor {

    EvictVisitor(SessionImpl session) {
        super(session);
    }

    Object processCollection(Object collection, PersistentCollectionType type)
            throws HibernateException {

        if (collection != null)
            getSession().evictCollection(collection, type);

        return null;
    }

}