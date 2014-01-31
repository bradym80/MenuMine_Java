// $Id: Range.java,v 1.2 2005/04/03 06:29:04 nick Exp $
package net.sf.hibernate.util;

public final class Range {

    public static int[] range(int begin, int length) {
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = begin + i;
        }
        return result;
    }

    private Range() {
    }
}

