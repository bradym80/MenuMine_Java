//$Id: ReattachVisitor.java,v 1.2 2005/04/03 06:29:04 nick Exp $
package net.sf.hibernate.impl;

import java.io.Serializable;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.type.AbstractComponentType;
import net.sf.hibernate.type.Type;

/**
 * Abstract superclass of visitors that reattach collections
 * 
 * @author Gavin King
 */
abstract class ReattachVisitor extends ProxyVisitor {

    private final Serializable key;

    final Serializable getKey() {
        return key;
    }

    public ReattachVisitor(SessionImpl session, Serializable key) {
        super(session);
        this.key = key;
    }

    Object processComponent(Object component,
            AbstractComponentType componentType) throws HibernateException {

        Type[] types = componentType.getSubtypes();
        if (component == null) {
            processValues(new Object[types.length], types);
        } else {
            super.processComponent(component, componentType);
            //processValues( componentType.getPropertyValues( component,
            // getSession() ), types );
        }

        return null;
    }

}