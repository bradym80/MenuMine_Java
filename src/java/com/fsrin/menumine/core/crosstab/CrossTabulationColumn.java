/*
 * Created on Mar 10, 2005
 *
 * 
 */
package com.fsrin.menumine.core.crosstab;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Nick
 * 
 *  
 */
public class CrossTabulationColumn {

    private int count = 0;

    private String name;

    private Collection cells = new ArrayList();

    private CrossTabulationCellTotal total = new CrossTabulationCellTotal();

    public CrossTabulationColumn(String name) {
        this.name = name;
    }

    public Double getRowPercentage() {

        double percent = (double) count / (double) this.getTotal().getCount();
        percent *= 100.0;
        return new Double(percent);
    }

    public Double getColumnPercentage() {

        return new Double(100.00);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void incrementCount() {
        this.count++;
    }

    public int getCount() {

        return count;
    }

    public void addCell(CrossTabulationCell cell) {
        this.cells.add(cell);
    }

    public Collection getCells() {
        return cells;
    }

    public CrossTabulationCellTotal getTotal() {
        return total;
    }

    public void setTotal(CrossTabulationCellTotal total) {
        this.total = total;
    }

    public void setCount(int count) {
        this.count = count;
    }
}