/*
 * Created on Apr 5, 2005
 *
 * 
 */
package com.fsrin.menumine.core.profiler.aggregation;


/**
 * @author Nick
 * 
 *  
 */
public interface Profile {

    public long getNumberOfApplications();

    public double getApplicationShare();

    public long getNumberOfOperationsUsing();
    
    public long getTotalApplications(); 
    
    public double getOperationPenetration();

    public double getNumberOfApplicationsPerOperator();

//    public void profile(Object element, Collection params);

    public String getName();
    
    

//    void setProfiler(Profiler profiler);
    
//    public FieldEnum getFieldEnum();

}