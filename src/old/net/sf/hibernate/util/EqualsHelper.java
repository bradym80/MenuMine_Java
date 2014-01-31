//$Id: EqualsHelper.java,v 1.2 2005/04/03 06:29:04 nick Exp $
package net.sf.hibernate.util;

/**
 * @author Gavin King
 */
public final class EqualsHelper {

    public static boolean equals(Object x, Object y) {
        return x == null ? y == null : x == y || x.equals(y);
    }

    private EqualsHelper() {
    }

}