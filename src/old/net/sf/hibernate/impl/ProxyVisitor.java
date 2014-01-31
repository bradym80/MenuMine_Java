//$Id: ProxyVisitor.java,v 1.2 2005/04/03 06:29:04 nick Exp $
package net.sf.hibernate.impl;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.type.EntityType;

/**
 * Reassociates uninitialized proxies with the session
 * 
 * @author Gavin King
 */
abstract class ProxyVisitor extends AbstractVisitor {

    public ProxyVisitor(SessionImpl session) {
        super(session);
    }

    Object processEntity(Object value, EntityType entityType)
            throws HibernateException {

        if (value != null) {
            getSession().reassociateIfUninitializedProxy(value);
            // if it is an initialized proxy, let cascade
            // handle it later on
        }

        return null;
    }

}