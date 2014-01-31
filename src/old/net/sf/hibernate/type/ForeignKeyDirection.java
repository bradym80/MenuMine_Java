//$Id: ForeignKeyDirection.java,v 1.2 2005/04/03 06:29:03 nick Exp $
package net.sf.hibernate.type;

import java.io.Serializable;

import net.sf.hibernate.engine.Cascades;

/**
 * Represents directionality of the foreign key constraint
 * 
 * @author Gavin King
 */
public abstract class ForeignKeyDirection implements Serializable {
    protected ForeignKeyDirection() {
    }

    /**
     * Should we cascade at this cascade point?
     * 
     * @see net.sf.hibernate.engine.Cascades
     */
    public abstract boolean cascadeNow(int cascadePoint);

    /**
     * A foreign key from child to parent
     */
    public static final ForeignKeyDirection FOREIGN_KEY_TO_PARENT = new ForeignKeyDirection() {
        public boolean cascadeNow(int cascadePoint) {
            return cascadePoint != Cascades.CASCADE_BEFORE_INSERT_AFTER_DELETE;
        }
    };

    /**
     * A foreign key from parent to child
     */
    public static final ForeignKeyDirection FOREIGN_KEY_FROM_PARENT = new ForeignKeyDirection() {
        public boolean cascadeNow(int cascadePoint) {
            return cascadePoint != Cascades.CASCADE_AFTER_INSERT_BEFORE_DELETE;
        }
    };
}