//$Id: List.java,v 1.2 2005/04/03 06:29:03 nick Exp $
package net.sf.hibernate.mapping;

import net.sf.hibernate.type.PersistentCollectionType;
import net.sf.hibernate.type.TypeFactory;

/**
 * A list mapping has a primary key consisting of the key columns + index
 * column.
 * 
 * @author Gavin King
 */
public class List extends IndexedCollection {

    public List(PersistentClass owner) {
        super(owner);
    }

    public PersistentCollectionType getCollectionType() {
        return TypeFactory.list(getRole());
    }

}

