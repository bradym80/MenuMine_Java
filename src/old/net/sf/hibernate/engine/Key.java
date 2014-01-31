//$Id: Key.java,v 1.2 2005/04/03 06:29:04 nick Exp $
package net.sf.hibernate.engine;

import java.io.Serializable;

import net.sf.hibernate.AssertionFailure;
import net.sf.hibernate.persister.ClassPersister;

/**
 * A globally unique identifier of an instance.
 * 
 * Consisting of the user-visible identifier and the identifier space (eg.
 * tablename).
 * 
 * @author Gavin King
 */
public final class Key implements Serializable {
    private final Serializable id;

    private final Serializable identifierSpace;

    private final Class clazz;

    private Key(Serializable id, Serializable identifierSpace, Class clazz) {
        if (id == null)
            throw new AssertionFailure("null identifier");
        this.id = id;
        this.identifierSpace = identifierSpace;
        this.clazz = clazz;
    }

    /**
     * Construct a unique identifier for an entity class instance
     */
    public Key(Serializable id, ClassPersister p) {
        this(id, p.getIdentifierSpace(), p.getMappedClass());
    }

    /**
     * Get the user-visible identifier
     */
    public Serializable getIdentifier() {
        return id;
    }

    public Class getMappedClass() {
        return clazz;
    }

    public boolean equals(Object other) {
        Key otherKey = (Key) other;
        return otherKey.identifierSpace.equals(this.identifierSpace)
                && otherKey.id.equals(this.id);
    }

    public int hashCode() {
        return id.hashCode();
    }

    public String toString() {
        return id.toString();
    }
}

