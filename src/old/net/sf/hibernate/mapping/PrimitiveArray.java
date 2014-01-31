//$Id: PrimitiveArray.java,v 1.2 2005/04/03 06:29:03 nick Exp $
package net.sf.hibernate.mapping;

/**
 * A primitive array has a primary key consisting of the key columns + index
 * column.
 */
public class PrimitiveArray extends Array {

    public PrimitiveArray(PersistentClass owner) {
        super(owner);
    }

    public boolean isPrimitiveArray() {
        return true;
    }

}

