/*
 * Created on Jul 14, 2005
 *
 * 
 */
package com.fsrin.menumine.common.crud.xwork;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author Nick
 * 
 *  
 */
public class ErrorContext {

    Collection errors = new ArrayList();

    public void addError(String errorMessage) {
        MenuMineError error = new MenuMineError(errorMessage);
        errors.add(error);

    }

    public boolean hasErrors() {
        return this.errors.size() > 0;
    }

    public Collection getErrors() {
        Collection temp = this.errors;
        this.errors = new ArrayList();
        return temp;
    }

    public void addErrors(Collection actionErrors) {
        for (Iterator iter = actionErrors.iterator(); iter.hasNext();) {
            Object o = iter.next();
            this.addError(o.toString());
        }

    }
}