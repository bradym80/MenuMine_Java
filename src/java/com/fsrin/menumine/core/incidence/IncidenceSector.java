/*
 * Created on Jan 30, 2006 by Reid
 */
package com.fsrin.menumine.core.incidence;

import java.util.Collection;

public interface IncidenceSector {

    public String getName();

    public Collection getIncidenceSegments();

    public int getNumberOfChains();

    public int getNumberOfChainsMenuingItems();

    public double getCategoryIncidence();

    public double getNumberOfItemsPerChainMenued();

    public int getNumberOfItemsBeingMenued();

}