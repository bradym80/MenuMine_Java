/*
 * Created on Jan 30, 2006 by Reid
 */
package com.fsrin.menumine.core.incidence;

import java.util.Collection;

public interface IncidenceSegment {

    public double getCategoryIncidence();

    public double getNumberOfItemsPerChainMenued();

    public int getNumberOfItemsBeingMenued();

    public int getNumberOfChainsMenuingItems();

    public int getNumberOfChains();

    public String getName();

    public Collection getIncidenceChains();

}