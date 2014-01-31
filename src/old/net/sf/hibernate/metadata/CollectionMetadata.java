//$Id: CollectionMetadata.java,v 1.2 2005/04/03 06:29:05 nick Exp $
package net.sf.hibernate.metadata;

import net.sf.hibernate.type.Type;

/**
 * Exposes collection metadata to the application
 * 
 * @author Gavin King
 */
public interface CollectionMetadata {
    /**
     * The collection key type
     */
    public Type getKeyType();

    /**
     * The collection element type
     */
    public Type getElementType();

    /**
     * The collection index type (or null if the collection has no index)
     */
    public Type getIndexType();

    /**
     * Is this collection indexed?
     */
    public boolean hasIndex();

    /**
     * The name of this collection role
     */
    public String getRole();

    /**
     * Is the collection an array?
     */
    public boolean isArray();

    /**
     * Is the collection a primitive array?
     */
    public boolean isPrimitiveArray();

    /**
     * Is the collection lazily initialized?
     */
    public boolean isLazy();
}

