//$Id: Getter.java,v 1.2 2005/04/03 06:29:05 nick Exp $
package net.sf.hibernate.property;

import java.lang.reflect.Method;

import net.sf.hibernate.HibernateException;

/**
 * Gets values of a particular property
 * 
 * @author Gavin King
 */
public interface Getter {
    /**
     * Get the property value from the given instance
     */
    public Object get(Object target) throws HibernateException;

    /**
     * Get the declared Java type
     */
    public Class getReturnType();

    /**
     * Optional operation (return null)
     */
    public String getMethodName();

    /**
     * Optional operation (return null)
     */
    public Method getMethod();
}