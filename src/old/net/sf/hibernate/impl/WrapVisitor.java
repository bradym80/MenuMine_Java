//$Id: WrapVisitor.java,v 1.3 2005/04/03 06:29:04 nick Exp $
package net.sf.hibernate.impl;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.collection.ArrayHolder;
import net.sf.hibernate.collection.PersistentCollection;
import net.sf.hibernate.persister.ClassPersister;
import net.sf.hibernate.type.AbstractComponentType;
import net.sf.hibernate.type.PersistentCollectionType;
import net.sf.hibernate.type.Type;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Wrap collections in a Hibernate collection wrapper.
 * 
 * @author Gavin King
 */
class WrapVisitor extends ProxyVisitor {

    private static final Log log = LogFactory.getLog(WrapVisitor.class);

    boolean substitute = false;

    boolean isSubstitutionRequired() {
        return substitute;
    }

    WrapVisitor(SessionImpl session) {
        super(session);
    }

    Object processCollection(Object collection,
            PersistentCollectionType collectionType) throws HibernateException {

        if (collection != null && (collection instanceof PersistentCollection)) {

            final SessionImpl session = getSession();
            PersistentCollection coll = (PersistentCollection) collection;
            if (coll.setCurrentSession(session)) {
                session.reattachCollection(coll, coll.getCollectionSnapshot());
            }
            return null;

        } else {
            return processArrayOrNewCollection(collection, collectionType);
        }

    }

    final Object processArrayOrNewCollection(Object collection,
            PersistentCollectionType collectionType) {

        final SessionImpl session = getSession();

        if (collection == null) {
            //do nothing
            return null;
        } else if (collectionType.isArrayType()) {

            ArrayHolder ah = session.getArrayHolder(collection);
            if (ah == null) {
                ah = new ArrayHolder(session, collection);
                session.addNewCollection(ah);
                session.addArrayHolder(ah);
            }
            return null;
        } else {

            PersistentCollection persistentCollection = collectionType.wrap(
                    session, collection);
            session.addNewCollection(persistentCollection);

            if (log.isTraceEnabled())
                log.trace("Wrapped collection in role: "
                        + collectionType.getRole());

            return persistentCollection; //Force a substitution!

        }

    }

    void processValues(Object[] values, Type[] types) throws HibernateException {
        for (int i = 0; i < types.length; i++) {
            Object result = processValue(values[i], types[i]);
            if (result != null) {
                substitute = true;
                values[i] = result;
            }
        }
    }

    Object processComponent(Object component,
            AbstractComponentType componentType) throws HibernateException {

        if (component != null) {
            Object[] values = componentType.getPropertyValues(component,
                    getSession());
            Type[] types = componentType.getSubtypes();
            boolean substituteComponent = false;
            for (int i = 0; i < types.length; i++) {
                Object result = processValue(values[i], types[i]);
                if (result != null) {
                    values[i] = result;
                    substituteComponent = true;
                }
            }
            if (substituteComponent) {
                componentType.setPropertyValues(component, values);
            }
        }

        return null;
    }

    void process(Object object, ClassPersister persister)
            throws HibernateException {
        Object[] values = persister.getPropertyValues(object);
        Type[] types = persister.getPropertyTypes();
        processValues(values, types);
        if (isSubstitutionRequired())
            persister.setPropertyValues(object, values);
    }

}