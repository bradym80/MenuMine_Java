//$Id: TypedValue.java,v 1.2 2005/04/03 06:29:04 nick Exp $
package net.sf.hibernate.engine;

import net.sf.hibernate.type.Type;

/**
 * An ordered pair of a value and its Hibernate type.
 * 
 * @see net.sf.hibernate.type.Type
 * @author Gavin King
 */
public final class TypedValue {
    private Type type;

    private Object value;

    public TypedValue(Type t, Object o) {
        setType(t);
        value = o;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

}

