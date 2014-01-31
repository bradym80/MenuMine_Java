//$Id: AbstractComponentType.java,v 1.2 2005/04/03 06:29:03 nick Exp $
package net.sf.hibernate.type;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.engine.Cascades;
import net.sf.hibernate.engine.SessionImplementor;

/**
 * Enables other Component-like types to hold collections and have cascades,
 * etc.
 * 
 * @see ComponentType
 * @see ObjectType
 * @author Gavin King
 */
public interface AbstractComponentType extends Type {
    public Type[] getSubtypes();

    public String[] getPropertyNames();

    public Object[] getPropertyValues(Object component,
            SessionImplementor session) throws HibernateException;

    /**
     * Optional operation
     */
    public Object[] getPropertyValues(Object component)
            throws HibernateException;

    /**
     * Optional operation
     */
    public void setPropertyValues(Object component, Object[] values)
            throws HibernateException;

    public Object getPropertyValue(Object component, int i,
            SessionImplementor session) throws HibernateException;

    //public Object instantiate(Object parent, SessionImplementor session)
    // throws HibernateException;
    public Cascades.CascadeStyle cascade(int i);

    public int enableJoinedFetch(int i);
}

