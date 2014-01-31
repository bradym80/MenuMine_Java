/*
 * Created on Mar 10, 2005
 *
 * 
 */
package com.fsrin.menumine.core.crosstab;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;

import com.fsrin.menumine.common.webwork.MMSorter;

/**
 * @author Nick
 * 
 *  
 */
public class CrossTabulationRow {

    private int count = 0;

    private String name;

    private Collection cells = new ArrayList();

    private CrossTabulationCellTotal total = new CrossTabulationCellTotal();

    private CrossTabulationCell rollUpCell;

    public CrossTabulationRow(String name) {
        this.name = name;
    }

    public Double getRowPercentage() {

        return new Double(100.00);
    }

    public Double getColumnPercentage() {
        double percent = (double) count / (double) this.getTotal().getCount();
        percent *= 100.0;
        return new Double(percent);
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
        TreeSet sorted = new TreeSet(new MMSorter().getDescending(
                "column.count", "column.name"));

        sorted.addAll(cells);
        return sorted;

    }

    public Collection getCellsWithRollUp() {
        Collection rolled = new ArrayList();

        Collection sorted = this.getCells();
        int i = 0;

        for (Iterator iter = sorted.iterator(); iter.hasNext(); i++) {
            CrossTabulationCell element = (CrossTabulationCell) iter.next();

            if (i < 8) {
                rolled.add(element);
            } else {

            }
        }
        if (i > 8) {
            rolled.add(this.getRollUpCell());
        }

        return rolled;

    }

    public CrossTabulationCellTotal getTotal() {
        return total;
    }

    public void setTotal(CrossTabulationCellTotal total) {
        this.total = total;
    }

    public CrossTabulationCell getRollUpCell() {
        int i = 0;
        int count = 0;

        Collection sorted = this.getCells();

        for (Iterator iter = sorted.iterator(); iter.hasNext(); i++) {
            CrossTabulationCell element = (CrossTabulationCell) iter.next();

            if (i > 7) {
                count += element.getCount();
            } else {

            }
        }
        rollUpCell.setCount(count);
        return rollUpCell;

    }

    public void setRollUpCell(CrossTabulationCell rollUpCell) {
        this.rollUpCell = rollUpCell;
    }
}