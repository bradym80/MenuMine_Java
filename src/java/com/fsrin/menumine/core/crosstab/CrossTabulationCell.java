/*
 * Created on Mar 11, 2005
 *
 * 
 */
package com.fsrin.menumine.core.crosstab;

/**
 * @author Nick
 * 
 *  
 */
public class CrossTabulationCell {

    private CrossTabulationRow row;

    private CrossTabulationColumn column;

    private int count;

    public Double getRowPercentage() {
        double percent = (double) count / (double) this.getRow().getCount();
        percent *= 100.0;
        return new Double(percent);
    }

    public Double getColumnPercentage() {
        double percent = (double) count / (double) this.getColumn().getCount();
        percent *= 100.0;
        return new Double(percent);
    }

    public int getCount() {
        return count;
    }

    public CrossTabulationRow getRow() {
        return row;
    }

    public CrossTabulationColumn getColumn() {
        return column;
    }

    public CrossTabulationCell(CrossTabulationRow row,
            CrossTabulationColumn column) {
        super();
        this.row = row;
        this.column = column;
    }

    public void incrementCount() {
        this.count++;
        this.row.incrementCount();

        this.column.incrementCount();

    }

    public void setCount(int count) {
        this.count = count;
    }
}