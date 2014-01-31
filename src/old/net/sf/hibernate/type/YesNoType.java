//$Id: YesNoType.java,v 1.2 2005/04/03 06:29:03 nick Exp $
package net.sf.hibernate.type;

/**
 * <tt>yes_no</tt>: A type that maps an SQL CHAR(1) to a Java Boolean.
 * 
 * @author Gavin King
 */
public class YesNoType extends CharBooleanType {

    protected final String getTrueString() {
        return "Y";
    }

    protected final String getFalseString() {
        return "N";
    }

    public String getName() {
        return "yes_no";
    }

}

