/*
 * Created on Sep 16, 2005
 *
 * 
 */
package com.fsrin.menumine.core.incidence;


import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;

/**
 * @author Nick
 *
 * 
 */
public class IncidenceTableBuildOptions {

    private Integer year;
    private MasterFoodFilterParameters params;
    
    
 

    public Integer getYear() {
        return year;
    }
    public void setYear(Integer year) {
        this.year = year;
    }
    public MasterFoodFilterParameters getParams() {
        return params;
    }
    public void setParams(MasterFoodFilterParameters params) {
        this.params = params;
    }
}
