/*
 * Created on Jan 19, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.webwork;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author Nick
 * 
 *  
 */
public abstract class FilterWrapper {

    protected String returnAsString(Collection like) {
        StringBuffer buffer = new StringBuffer();

        for (Iterator iter = like.iterator(); iter.hasNext();) {
            String element = (String) iter.next();

            int commaIndex = element.indexOf(",");
            String s = "1";
            if (commaIndex > -1) {
                s = element.replaceAll(",", "\\\\,");
                element = s;
            }

            if (buffer.length() > 0) {
                buffer.append(", ");
            }
            buffer.append(element);
        }
        return buffer.toString();
    }

    protected Collection parseToCollection(String like) {
        /*
         * Using a set will clean up the collection if we have the same value
         * entered twice.
         */
        Collection col = new ArrayList();
        String[] strings = like.split(",");

        /*
         * We need handle the case where we have a comma in the quoted string.
         */
        for (int i = 0; i < strings.length; i++) {
            String string = strings[i];
            if (string.trim().length() > 0) {

                /*
                 * We are looking to terms that end in a \\.
                 *  
                 */
                if (string.endsWith("\\")) {
                    /*
                     * By placing the new string in the i+1 list we account for
                     * multiple commas in one search param.
                     */
                    if (i + 1 < strings.length) {
                        strings[i + 1] = string.substring(0,
                                string.length() - 1)
                                + "," + strings[i + 1];
                        strings[i] = "";
                    } else {
                        strings[i] = string.substring(0, string.length() - 1)
                                + ",";
                    }

                }
            }
        }

        for (int i = 0; i < strings.length; i++) {
            String string = strings[i];
            if (string.trim().length() > 0) {
                col.add(string.trim());
            }

        }
        return col;
    }

}