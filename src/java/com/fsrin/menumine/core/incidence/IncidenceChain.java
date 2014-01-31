/*
 * Created on Mar 14, 2005
 *
 * 
 */
package com.fsrin.menumine.core.incidence;

/**
 * @author Nick
 * 
 *  
 */
public class IncidenceChain {

    private String name;

    private int numberOfItemsMenued;

    public boolean isMenuingItems() {
        return numberOfItemsMenued > 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfItemsMenued() {
        return numberOfItemsMenued;
    }

    public void incrementCount() {
        numberOfItemsMenued++;
    }

}