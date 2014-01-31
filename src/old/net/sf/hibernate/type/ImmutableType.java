//$Id: ImmutableType.java,v 1.2 2005/04/03 06:29:03 nick Exp $
package net.sf.hibernate.type;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.engine.SessionImplementor;

/**
 * Superclass of nullable immutable types.
 * 
 * @author Gavin King
 */
public abstract class ImmutableType extends NullableType {

    public final Object deepCopyNotNull(Object value) throws HibernateException {
        return value;
    }

    public final boolean isMutable() {
        return false;
    }

    public boolean hasNiceEquals() {
        return true;
    }

    public Object copy(Object original, Object target,
            SessionImplementor session, Object owner) throws HibernateException {

        return original;
    }

}

