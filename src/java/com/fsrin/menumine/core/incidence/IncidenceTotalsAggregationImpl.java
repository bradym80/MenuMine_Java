/*
 * Created on Jan 31, 2006 by Reid
 */
package com.fsrin.menumine.core.incidence;

public class IncidenceTotalsAggregationImpl extends AbstractIncidenceTotals {

    private int numberOfChainsInSector;

    private int numberOfChainsMenuingItems;

    private int numberOfItemsBeingMenued;

    
    public int getNumberOfChainsInSector() {
        return numberOfChainsInSector;
    }

    public void setNumberOfChainsInSector(int numberOfChainsInSector) {
        this.numberOfChainsInSector = numberOfChainsInSector;
    }

    public int getNumberOfChainsMenuingItems() {
        return numberOfChainsMenuingItems;
    }

    public void setNumberOfChainsMenuingItems(int numberOfChainsMenuingItems) {
        this.numberOfChainsMenuingItems = numberOfChainsMenuingItems;
    }

    public int getNumberOfItemsBeingMenued() {
        return numberOfItemsBeingMenued;
    }

    public void setNumberOfItemsBeingMenued(int numberOfItemsBeingMenued) {
        this.numberOfItemsBeingMenued = numberOfItemsBeingMenued;
    }

    public double getCategoryIncidence() {

        if (this.getNumberOfChainsInSector() == 0)
            return 0.0;

        double ret = ((double) this.getNumberOfChainsMenuingItems())
                / ((double) this.getNumberOfChainsInSector());
        
        return ret;
    }

    public double getNumberOfItemsPerChainMenued() {
        if (this.getNumberOfChainsInSector() == 0)
            return 0.0;

        return ((double) this.getNumberOfItemsBeingMenued())
                / ((double) this.getNumberOfChainsInSector());
    }

}
