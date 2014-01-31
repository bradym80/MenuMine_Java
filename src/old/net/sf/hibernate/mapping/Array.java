//$Id: Array.java,v 1.2 2005/04/03 06:29:03 nick Exp $
package net.sf.hibernate.mapping;

import net.sf.hibernate.type.PersistentCollectionType;
import net.sf.hibernate.type.TypeFactory;

/**
 * An array mapping has a primary key consisting of the key columns + index
 * column.
 * 
 * @author Gavin King
 */
public class Array extends List {

    private Class elementClass;

    /**
     * Constructor for Array.
     * 
     * @param owner
     */
    public Array(PersistentClass owner) {
        super(owner);
    }

    public Class getElementClass() {
        return elementClass;
    }

    public PersistentCollectionType getCollectionType() {
        return TypeFactory.array(getRole(), getElementClass());
    }

    public boolean isArray() {
        return true;
    }

    /**
     * Sets the elementClass.
     * 
     * @param elementClass
     *            The elementClass to set
     */
    public void setElementClass(Class elementClass) {
        this.elementClass = elementClass;
    }

}

