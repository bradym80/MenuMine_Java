//$Id: VersionType.java,v 1.2 2005/04/03 06:29:03 nick Exp $
package net.sf.hibernate.type;

/**
 * A <tt>Type</tt> that may be used to version data.
 * 
 * @author Gavin King
 */
public interface VersionType extends Type {
    /**
     * Generate an initial version.
     * 
     * @return an instance of the type
     */
    public Object seed();

    /**
     * Increment the version.
     * 
     * @param current
     *            the current version
     * @return an instance of the type
     */
    public Object next(Object current);
}

