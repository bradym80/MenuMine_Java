//$Id: IdentifierBag.java,v 1.2 2005/04/03 06:29:03 nick Exp $
package net.sf.hibernate.mapping;

import net.sf.hibernate.type.PersistentCollectionType;
import net.sf.hibernate.type.TypeFactory;

/**
 * An <tt>IdentifierBag</tt> has a primary key consisting of just the
 * identifier column
 */
public class IdentifierBag extends IdentifierCollection {

    public IdentifierBag(PersistentClass owner) {
        super(owner);
    }

    public PersistentCollectionType getCollectionType() {
        return TypeFactory.idbag(getRole());
    }

}

