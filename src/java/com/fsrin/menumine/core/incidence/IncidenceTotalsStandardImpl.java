/*
 * Created on Mar 14, 2005
 *
 * 
 */
package com.fsrin.menumine.core.incidence;

import java.util.Iterator;

/**
 * @author Nick
 * 
 *  
 */
public class IncidenceTotalsStandardImpl extends AbstractIncidenceTotals {

    private IncidenceTable table;

    public IncidenceTotalsStandardImpl(IncidenceTable table) {
        super();
        this.table = table;
    }

    public int getNumberOfChainsInSector() {
        int count = 0;
        for (Iterator iter = this.table.getIncidenceSectors().iterator(); iter
                .hasNext();) {
            IncidenceSector element = (IncidenceSector) iter.next();
            count += element.getNumberOfChains();
        }
        return count;
    }

    public int getNumberOfChainsMenuingItems() {
        int count = 0;
        for (Iterator iter = this.table.getIncidenceSectors().iterator(); iter
                .hasNext();) {
            IncidenceSector element = (IncidenceSector) iter.next();
            count += element.getNumberOfChainsMenuingItems();
        }
        return count;
    }

    public double getCategoryIncidence() {
        double menuing = this.getNumberOfChainsMenuingItems();
        double chains = this.getNumberOfChainsInSector();
        return (menuing / chains) * 100.0;
    }

    public double getNumberOfItemsPerChainMenued() {

        double items = this.getNumberOfItemsBeingMenued();
        double chains = this.getNumberOfChainsMenuingItems();

        if (chains == 0.0) {
            return 0.0;
        }
        return items / chains;
    }

    public int getNumberOfItemsBeingMenued() {

        int count = 0;
        for (Iterator iter = this.table.getIncidenceSectors().iterator(); iter
                .hasNext();) {
            IncidenceSector element = (IncidenceSector) iter.next();
            count += element.getNumberOfItemsBeingMenued();
        }

        return count;
    }

}