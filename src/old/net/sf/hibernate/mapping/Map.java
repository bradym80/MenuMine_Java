//$Id: Map.java,v 1.2 2005/04/03 06:29:03 nick Exp $
package net.sf.hibernate.mapping;

import net.sf.hibernate.type.PersistentCollectionType;
import net.sf.hibernate.type.TypeFactory;

/**
 * A map has a primary key consisting of the key columns + index columns.
 */
public class Map extends IndexedCollection {

    public Map(PersistentClass owner) {
        super(owner);
    }

    public PersistentCollectionType getCollectionType() {
        return isSorted() ? TypeFactory.sortedMap(getRole(), getComparator())
                : TypeFactory.map(getRole());
    }

    public void createAllKeys() {
        super.createAllKeys();
        if (!isInverse())
            getIndex().createForeignKey();
    }

}

