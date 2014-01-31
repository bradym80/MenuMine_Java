/*
 * Created on Jul 25, 2006
 *
 */
package com.fsrin.menumine.core.menumine.marketsize;

import com.fsrin.menumine.core.incidence.IncidenceTotalsAggregationImpl;

public class MarketSizeIncidenceTotals extends IncidenceTotalsAggregationImpl {

    private int unitsInUniverse;
    
    private double projectedMarketSize;

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
