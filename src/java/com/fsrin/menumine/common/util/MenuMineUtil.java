/*
 * Created on Aug 16, 2005
 *
 * 
 */
package com.fsrin.menumine.common.util;

import java.util.StringTokenizer;

/**
 * @author Nick
 * 
 *  
 */
public class MenuMineUtil {

    public MenuMineUtil() {
        super();

    }

    /*
     * This makes sure that the string has a value. Often an empty string and a
     * null are undesired, this util just simplifies the check.
     */
    public static boolean isEmpty(String string) {
        if (string != null && string.length() > 0) {
            return false;
        }

        return true;
    }

    /*
     * This will remove the s from the end of each trem in a string. If the term
     * ends with a comma we can handle that as well.
     * 
     * NOTE This doesn't know the terms true roots Asparagus will be returned as
     * Asparagu.
     */

    public static String stringRootifyer(String result) {
        if (result instanceof String) {
            StringBuffer buffer = new StringBuffer();
            StringTokenizer tokenizer = new StringTokenizer((String) result);
            while (tokenizer.hasMoreTokens()) {
                String tok = tokenizer.nextToken();
                if (tok.endsWith("s") || tok.endsWith(",") || tok.endsWith("/")) {
                    int index = tok.lastIndexOf('s');
                    char[] array = tok.toCharArray();

                    if (index < array.length && index >= array.length - 2
                            && index > -1) {
                        array[index] = ' ';
                        while (index < array.length) {
                            if (index + 1 < array.length) {
                                array[index] = array[index + 1];
                            } else {
                                array[index] = ' ';
                            }
                            index++;
                        }
                    }

                    tok = new String(array);
                }
                buffer.append(tok.trim()).append(" ");

            }

            result = buffer.toString();
        }

        return result.trim();
    }

}