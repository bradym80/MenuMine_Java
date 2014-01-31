/*
 * Created on Jul 25, 2006
 *
 */
package com.fsrin.menumine.core.incidence;

public abstract class AbstractIncidenceTableElement {

    private String name;
    private int numberOfChains;
    private int numberOfChainsMenuingItems;
    private int numberOfItemsBeingMenued;
    private double numberOfItemsPerChainMenued;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCategoryIncidence() {
        return 100.0 * ((double)this.getNumberOfChainsMenuingItems()) / ((double)this.getNumberOfChains());
    }

    public int getNumberOfChains() {
        return numberOfChains;
    }

    public int getNumberOfChainsMenuingItems() {
        return numberOfChainsMenuingItems;
    }

    public int getNumberOfItemsBeingMenued() {
        return numberOfItemsBeingMenued;
    }

    public double getNumberOfItemsPerChainMenued() {
        return ((double) this.getNumberOfItemsBeingMenued())/((double) this.getNumberOfChainsMenuingItems());
    }

    public void setNumberOfChains(int numberOfChainsInSector) {
        this.numberOfChains = numberOfChainsInSector;
    }

    public void setNumberOfChainsMenuingItems(int numberOfChainsMenuingItems) {
        this.numberOfChainsMenuingItems = numberOfChainsMenuingItems;
    }

    public void setNumberOfItemsBeingMenued(int numberOfItemsBeingMenued) {
        this.numberOfItemsBeingMenued = numberOfItemsBeingMenued;
    }

}
