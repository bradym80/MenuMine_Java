/*
 * Created on Apr 5, 2005
 *
 * 
 */
package com.fsrin.menumine.core.profiler;

import java.util.Collection;

/**
 * @author Nick
 * 
 *  
 */
public interface ProfileParameters {

    public void setSearchString(String searchString);

    public String getSearchString();

    public Collection getParams();

    public void setParams(Collection params);

}