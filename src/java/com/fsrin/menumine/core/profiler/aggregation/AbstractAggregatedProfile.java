/*
 * Created on Apr 20, 2006 by Reid
 */
package com.fsrin.menumine.core.profiler.aggregation;


public abstract class AbstractAggregatedProfile implements Profile {

    private long numberOfApplications;
    private long numberOfOperationsUsing;
    private long totalApplications;

//    public void profile(Object element, Collection params) {
//        throw new RuntimeException("should never be here. profile");
//    }
    
//    public void setProfiler(Profiler profiler) {
//        throw new RuntimeException("should never be here setProfiler");
//    }

    public double getApplicationShare() {
        if (this.getTotalApplications() == 0) {
            return 0.0;
        }
        return ((double) this.getNumberOfApplications())
                / ((double) this.getTotalApplications());
    }

    public long getNumberOfApplications() {
        return numberOfApplications;
    }

    public double getNumberOfApplicationsPerOperator() {
    
        if (this.getNumberOfOperationsUsing() == 0) 
            return 0.0;
        
        return ((double) this.getNumberOfApplications())
                / ((double) this.getNumberOfOperationsUsing());
    }

    public long getNumberOfOperationsUsing() {
        return numberOfOperationsUsing;
    }

    public double getOperationPenetration() {
        
        return ((double) this.getNumberOfOperationsUsing())
                / 1409.0;
    }
    
    public long getTotalApplications() {
        return totalApplications;
    }

    public void setNumberOfApplications(long numberOfApplications) {
        this.numberOfApplications = numberOfApplications;
    }

    public void setNumberOfOperationsUsing(long numberOfOperationsUsing) {
        this.numberOfOperationsUsing = numberOfOperationsUsing;
    }

    public void setTotalApplications(long totalApplications) {
        this.totalApplications = totalApplications;
    }
    
}
