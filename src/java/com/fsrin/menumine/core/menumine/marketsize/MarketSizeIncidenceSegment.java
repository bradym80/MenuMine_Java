/*
 * Created on Jul 25, 2006
 *
 */
package com.fsrin.menumine.core.menumine.marketsize;

import com.fsrin.menumine.core.incidence.IncidenceSegmentAggregationImpl;

public class MarketSizeIncidenceSegment extends IncidenceSegmentAggregationImpl {

    private int unitsInUniverse;
    
    private int servingsPerDay;
    
    private double ouncesPerServing;
    
    private int menuCycle;
    
    private double projectedMarketSize; //already converted
    
    private double overallShare;
    
    private double conversionConstant; //need to have for the spreadsheet

    /**
     * @return Returns the conversionConstant.
     */
    public double getConversionConstant() {
        return conversionConstant;
    }

    /**
     * @param conversionConstant The conversionConstant to set.
     */
    public void setConversionConstant(double conversionConstant) {
        this.conversionConstant = conversionConstant;
    }

    /**
     * @return Returns the menuCycle.
     */
    public int getMenuCycle() {
        return menuCycle;
    }

    /**
     * @param menuCycle The menuCycle to set.
     */
    public void setMenuCycle(int menuCycle) {
        this.menuCycle = menuCycle;
    }

    /**
     * @return Returns the ouncesPerServing.
     */
    public double getOuncesPerServing() {
        return ouncesPerServing;
    }

    /**
     * @param ouncesPerServing The ouncesPerServing to set.
     */
    public void setOuncesPerServing(double ouncesPerServing) {
        this.ouncesPerServing = ouncesPerServing;
    }

    /**
     * @return Returns the overallShare.
     */
    public double getOverallShare() {
        return overallShare;
    }

    /**
     * @param overallShare The overallShare to set.
     */
    public void setOverallShare(double overallShare) {
        this.overallShare = overallShare;
    }

    /**
     * @return Returns the projectedMarketSize.
     */
    public double getProjectedMarketSize() {
        return projectedMarketSize;
    }

    /**
     * @param projectedMarketSize The projectedMarketSize to set.
     */
    public void setProjectedMarketSize(double projectedMarketSize) {
        this.projectedMarketSize = projectedMarketSize;
    }

    /**
     * @return Returns the servingsPerDay.
     */
    public int getServingsPerDay() {
        return servingsPerDay;
    }

    /**
     * @param servingsPerDay The servingsPerDay to set.
     */
    public void setServingsPerDay(int servingsPerDay) {
        this.servingsPerDay = servingsPerDay;
    }

    /**
     * @return Returns the unitsInUniverse.
     */
    public int getUnitsInUniverse() {
        return unitsInUniverse;
    }

    /**
     * @param unitsInUniverse The unitsInUniverse to set.
     */
    public void setUnitsInUniverse(int unitsInUniverse) {
        this.unitsInUniverse = unitsInUniverse;
    }
    
    
    
}
