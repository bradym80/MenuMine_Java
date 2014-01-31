/*
 * Created on May 19, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.savedquery;

import org.springframework.context.ApplicationEvent;


/**
 * @author Nick
 * 
 *  
 */
public class SavedQueryModificationEvent extends ApplicationEvent {

    private SavedQuery savedQuery;

    public SavedQueryModificationEvent(Object arg0, SavedQuery savedQuery) {
        super(arg0);
        this.savedQuery = savedQuery;
    }

    public SavedQuery getSavedQuery() {
        return savedQuery;
    }

    public void setSavedQuery(SavedQuery savedQuery) {
        this.savedQuery = savedQuery;
    }
}