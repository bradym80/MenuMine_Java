//$Id: Setter.java,v 1.2 2005/04/03 06:29:05 nick Exp $
package net.sf.hibernate.property;

import java.lang.reflect.Method;

import net.sf.hibernate.HibernateException;

/**
 * Sets values to a particular property
 * 
 * @author Gavin King
 */
public interface Setter {
    /**
     * Set the property value from the given instance
     */
    public void set(Object target, Object value) throws HibernateException;

    /**
     * Optional operation (return null)
     */
    public String getMethodName();

    /**
     * Optional operation (return null)
     */
    public Method getMethod();
}