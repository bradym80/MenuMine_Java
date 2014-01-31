/*
 * Created on Apr 5, 2005
 *
 * 
 */
package com.fsrin.menumine.core.profiler;

/**
 * @author Nick
 * 
 *  
 */
public class ProfileOperationAggregation {

    private long numberOfOperatorsInMenuMine;

    private long numberOfOperatorsUsingIngredient;

    private long totalApplications;

    public ProfileOperationAggregation(long numberOfOperatorsInMenuMine,
            long numberOfOperatorsUsingIngredient, long totalApplications) {
        super();
        this.numberOfOperatorsInMenuMine = numberOfOperatorsInMenuMine;
        this.numberOfOperatorsUsingIngredient = numberOfOperatorsUsingIngredient;
        this.totalApplications = totalApplications;
    }

    public long getNumberOfOperatorsInMenuMine() {

        return numberOfOperatorsInMenuMine;
    }

    public long getNumberOfOperatorsUsingIngredient() {

        return numberOfOperatorsUsingIngredient;
    }

    public double getIngredientPenetration() {

        return (double) numberOfOperatorsUsingIngredient
                / (double) numberOfOperatorsInMenuMine;
    }

    public long getTotalApplications() {

        return totalApplications;
    }

    public double getApplicationsPerOperator() {

        return ((double) this.getTotalApplications())
                / ((double) this.getNumberOfOperatorsUsingIngredient());
    }

}