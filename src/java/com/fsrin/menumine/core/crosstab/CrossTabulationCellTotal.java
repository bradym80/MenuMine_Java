/*
 * Created on Mar 14, 2005
 *
 * 
 */
package com.fsrin.menumine.core.crosstab;

/**
 * @author Nick
 * 
 *  
 */
public class CrossTabulationCellTotal {

    private int count = 0;

    public void incrementCount() {
        count++;
    }

    public Double getColumnPercentage() {

        return new Double(100.00);
    }

    public Double getRowPercentage() {

        return new Double(100.00);
    }

    public int getCount() {
        return count;
    }
}