/*
 * Created on Jan 31, 2006 by Reid
 */
package com.fsrin.menumine.core.incidence;

public interface IncidenceTotals {

    public int getRecordCount();
    
    public int getNumberOfChainsInSector();

    public int getNumberOfChainsMenuingItems();

    public double getCategoryIncidence();

    public double getNumberOfItemsPerChainMenued();

    public int getNumberOfItemsBeingMenued();

}