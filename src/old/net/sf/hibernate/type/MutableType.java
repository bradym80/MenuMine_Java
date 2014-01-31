//$Id: MutableType.java,v 1.2 2005/04/03 06:29:03 nick Exp $
package net.sf.hibernate.type;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.engine.SessionImplementor;

/**
 * Superclass for mutable nullable types
 * 
 * @author Gavin King
 */
public abstract class MutableType extends NullableType {

    public final boolean isMutable() {
        return true;
    }

    public boolean hasNiceEquals() {
        return false; //default ... may be overridden
    }

    public Object copy(Object original, Object target,
            SessionImplementor session, Object owner) throws HibernateException {
        return deepCopy(original);
    }

}

