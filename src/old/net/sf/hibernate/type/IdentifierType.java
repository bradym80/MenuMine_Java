//$Id: IdentifierType.java,v 1.2 2005/04/03 06:29:03 nick Exp $
package net.sf.hibernate.type;

/**
 * A <tt>Type</tt> that may be used as an identifier.
 * 
 * @author Gavin King
 */
public interface IdentifierType extends Type {

    /**
     * Convert the value from the mapping file to a Java object.
     * 
     * @param xml
     *            the value of <tt>discriminator-value</tt> or
     *            <tt>unsaved-value</tt> attribute
     * @return Object
     * @throws Exception
     */
    public Object stringToObject(String xml) throws Exception;

}

