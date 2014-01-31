/*
 * Created on Jan 22, 2006
 *
 */
package com.fsrin.menumine.core.menumine.util;

/**
 * 2006-01-22 RSC These are refactored from for example the express query 
 * builder.
 * 
 */
public class QueryTermValidator {

    public boolean isValid(String term) {

        if (term == null)
            return false;
        
        if (term.length() < 2)
            return false;
        
        return true;
    }
}
