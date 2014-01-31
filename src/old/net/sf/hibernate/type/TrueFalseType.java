//$Id: TrueFalseType.java,v 1.2 2005/04/03 06:29:03 nick Exp $
package net.sf.hibernate.type;

/**
 * <tt>true_false</tt>: A type that maps an SQL CHAR(1) to a Java Boolean.
 * 
 * @author Gavin King
 */
public class TrueFalseType extends CharBooleanType {

    protected final String getTrueString() {
        return "T";
    }

    protected final String getFalseString() {
        return "F";
    }

    public String getName() {
        return "true_false";
    }

}

