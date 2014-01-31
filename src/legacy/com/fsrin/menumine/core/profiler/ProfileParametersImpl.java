/*
 * Created on Apr 5, 2005
 *
 * 
 */
package com.fsrin.menumine.core.profiler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author Nick
 * 
 *  
 */
public class ProfileParametersImpl implements ProfileParameters {

    private Collection params = new ArrayList();

    public void setSearchString(String searchString) {
        params = new ArrayList();

        String[] parts = searchString.split(" ");
        for (int i = 0; i < parts.length; i++) {
            String string = parts[i];
            if (string.trim().length() > 0) {
                params.add(string.trim());
            }

        }
    }

    public String getSearchString() {
        StringBuffer buffer = new StringBuffer();
        for (Iterator iter = params.iterator(); iter.hasNext();) {
            String element = (String) iter.next();
            buffer.append(element).append(" ");

        }
        return buffer.toString();
    }

    public Collection getParams() {
        return params;
    }

    public void setParams(Collection params) {
        this.params = params;
    }
}