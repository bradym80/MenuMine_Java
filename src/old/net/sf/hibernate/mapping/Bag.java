//$Id: Bag.java,v 1.2 2005/04/03 06:29:03 nick Exp $
package net.sf.hibernate.mapping;

import net.sf.hibernate.type.PersistentCollectionType;
import net.sf.hibernate.type.TypeFactory;

/**
 * A bag permits duplicates, so it has no primary key
 * 
 * @author Gavin King
 */
public class Bag extends Collection {

    public Bag(PersistentClass owner) {
        super(owner);
    }

    public PersistentCollectionType getCollectionType() {
        return TypeFactory.bag(getRole());
    }

    void createPrimaryKey() {
        //create an index on the key columns??
    }

}

