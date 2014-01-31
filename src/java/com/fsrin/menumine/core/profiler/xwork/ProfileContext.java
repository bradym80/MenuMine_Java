/*
 * Created on May 9, 2005
 *
 * 
 */
package com.fsrin.menumine.core.profiler.xwork;

import java.io.Serializable;

import com.fsrin.menumine.core.profiler.aggregation.ProfileFieldListProvider;

/**
 * @author Nick
 * 
 *  
 */
public class ProfileContext implements Serializable {

    private ProfileFieldListProvider fieldListProvider;
    
    private String searchString;
    
    private String applicationFocus;

    public ProfileFieldListProvider getFieldListProvider() {
        return fieldListProvider;
    }

    public void setFieldListProvider(ProfileFieldListProvider fieldListProvider) {
        this.fieldListProvider = fieldListProvider;
    }

    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

    public String getApplicationFocus() {
        return applicationFocus;
    }

    public void setApplicationFocus(String applicationFocus) {
        this.applicationFocus = applicationFocus;
    }
    
    
    
    
}