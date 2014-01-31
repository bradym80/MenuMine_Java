//$Id: LiteralType.java,v 1.2 2005/04/03 06:29:03 nick Exp $
package net.sf.hibernate.type;

/**
 * A type that may appear as an SQL literal
 * 
 * @author Gavin King
 */
public interface LiteralType {
    /**
     * String representation of the value, suitable for embedding in an SQL
     * statement.
     * 
     * @param value
     * @return String
     * @throws Exception
     */
    public String objectToSQLString(Object value) throws Exception;

}

