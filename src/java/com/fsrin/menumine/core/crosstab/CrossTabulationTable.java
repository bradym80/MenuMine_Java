/*
 * Created on Mar 10, 2005
 *
 * 
 */
package com.fsrin.menumine.core.crosstab;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

import org.apache.commons.logging.LogFactory;

import com.fsrin.menumine.common.webwork.MMSorter;
import com.fsrin.menumine.core.menumine.FieldEnum;
import com.fsrin.menumine.core.menumine.masterfood.MasterFood;
import com.fsrin.menumine.core.menumine.rollup.RollUpOptions;
import com.fsrin.menumine.core.menumine.rollup.util.RollUpHandler;
import com.fsrin.menumine.core.menumine.rollup.util.RollUpMatchAllHandler;
import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableKeyFinder;
import com.fsrin.menumine.core.menumine.webwork.MenuMineCrossTabulationOptions;

/**
 * 2006-02-03 RSC Modified the key and roll up provisions below.
 * 
 * @author Nick
 * 
 * 
 */
public class CrossTabulationTable {

    private String rowField;

    private StatisticalTableKeyFinder rowKeyFinder;

    private String columnField;

    private StatisticalTableKeyFinder columnKeyFinder;

    private MenuMineCrossTabulationOptions crossTabulationOptions;

    private HashMap cells = new HashMap();

    private HashMap rows = new HashMap();

    private HashMap columns = new HashMap();

    private RollUpHandler rowRollUpHandler;

    private RollUpHandler colunmRollUpHandler;

    private CrossTabulationColumn rollUpColumn = new CrossTabulationColumn(
            "All Other");

    private CrossTabulationCellTotal total = new CrossTabulationCellTotal();

    public CrossTabulationTable(
            MenuMineCrossTabulationOptions crossTabulationOptions) {
        this.rowField = crossTabulationOptions.getVerticalField();
        FieldEnum rowFieldEnum = FieldEnum.getByOgnlName(this.rowField);
        this.rowKeyFinder = StatisticalTableKeyFinder.factory
                .build(rowFieldEnum);

        this.columnField = crossTabulationOptions.getHorizontalField();
        FieldEnum columnFieldEnum = FieldEnum.getByOgnlName(this.columnField);
        this.columnKeyFinder = StatisticalTableKeyFinder.factory
                .build(columnFieldEnum);

        /*
         * Set Up roll up handlers
         */
        RollUpOptions hRollUp = crossTabulationOptions
                .getHorizontalRollUpOptions();

        RollUpOptions vRollUp = crossTabulationOptions
                .getVerticalRollUpOptions();

        if (vRollUp != null) {
            this.rowRollUpHandler = new RollUpMatchAllHandler(vRollUp);
        }

        if (hRollUp != null) {
            this.colunmRollUpHandler = new RollUpMatchAllHandler(hRollUp);
        }

        this.crossTabulationOptions = crossTabulationOptions;
    }

    public void addMasterFood(MasterFood element) {
        /*
         * 2006-02-03 RSC changed from Object to String
         */
        // Object result1 = null;
        // Object result2 = null;
        String result1 = null;
        String result2 = null;
        result1 = this.findResult(element, this.rowKeyFinder);
        result2 = this.findResult(element, this.columnKeyFinder);

        Object resultRollUp1 = result1;
        Object resultRollUp2 = result2;

        /*
         * If we have a handler, see what the new result is. handleRollUp return
         * a list values this should map to. For now we only do a 1-1 mapping,
         * so it is not to important anymore.
         */
        if (this.rowRollUpHandler != null) {
            // resultRollUp1 = this.rowRollUpHandler.getRollUpKey(result1)[0];
            resultRollUp1 = this.rowRollUpHandler.getRollUpKey(result1);
        }
        if (this.colunmRollUpHandler != null) {
            // resultRollUp2 =
            // this.colunmRollUpHandler.getRollUpKey(result2)[0];
            resultRollUp2 = this.colunmRollUpHandler.getRollUpKey(result2);
        }

        updateTable(resultRollUp1, resultRollUp2);
        total.incrementCount();

    }

    private void updateTable(Object result1, Object result2) {

        if (cells.containsKey(this.buildKey(result1, result2))) {
            CrossTabulationCell cell = (CrossTabulationCell) cells.get(this
                    .buildKey(result1, result2));
            cell.incrementCount();
        } else {

            /*
             * Make sure rows and cells are complete
             */
            this.findRow(result1);
            this.findColumn(result2);
            for (Iterator iter = rows.values().iterator(); iter.hasNext();) {
                CrossTabulationRow element = (CrossTabulationRow) iter.next();

                if (!cells.containsKey(this
                        .buildKey(element.getName(), result2))) {

                    CrossTabulationCell cell = new CrossTabulationCell(element,
                            this.findColumn(result2));
                    element.addCell(cell);
                    this.findColumn(result2).addCell(cell);
                    cells.put(this.buildKey(element.getName(), result2), cell);
                }
            }

            for (Iterator iter = columns.values().iterator(); iter.hasNext();) {
                CrossTabulationColumn element = (CrossTabulationColumn) iter
                        .next();

                if (!cells.containsKey(this
                        .buildKey(result1, element.getName()))) {

                    CrossTabulationCell cell = new CrossTabulationCell(this
                            .findRow(result1), element);
                    element.addCell(cell);
                    this.findRow(result1).addCell(cell);
                    cells.put(this.buildKey(result1, element.getName()), cell);

                }
            }

            CrossTabulationCell cell = (CrossTabulationCell) cells.get(this
                    .buildKey(result1, result2));

            // CrossTabulationCell cell = new CrossTabulationCell(this
            // .findRow(result1), this.findColumn(result2));
            //            
            // this.findRow(result1).addCell(cell);
            // this.findColumn(result2).addCell(cell);

            if (cell == null) {
                LogFactory.getLog(this.getClass()).debug(
                        "Cell is Null:" + this.buildKey(result1, result2));
            } else {
                cell.incrementCount();
            }
            // cells.put(this.buildKey(result1, result2), cell);

        }

    }

    private CrossTabulationColumn findColumn(Object result2) {

        CrossTabulationColumn column = null;
        if (columns.containsKey(result2)) {
            column = (CrossTabulationColumn) columns.get(result2);
        } else {
            column = new CrossTabulationColumn(result2.toString());
            column.setTotal(total);
            columns.put(result2, column);
        }

        return column;
    }

    private CrossTabulationRow findRow(Object result1) {

        CrossTabulationRow row = null;
        if (rows.containsKey(result1)) {
            row = (CrossTabulationRow) rows.get(result1);
        } else {
            row = new CrossTabulationRow(result1.toString());
            row.setTotal(total);
            /*
             * This is rolling up the all other, so we don't have a huge table.
             */
            CrossTabulationCell rollUpCell = new CrossTabulationCell(row,
                    this.rollUpColumn);
            row.setRollUpCell(rollUpCell);
            rows.put(result1, row);
        }

        return row;
    }

    private Object buildKey(Object result1, Object result2) {
        return result1 + "::" + result2;
    }

    private String findResult(MasterFood element,
            StatisticalTableKeyFinder keyFinder) {
        String result1 = null;

        Object o = keyFinder.getKey(element);

        if (o != null) {
            if (o instanceof String)
                result1 = (String) o;
            else if (o instanceof Integer)
                result1 = ((Integer) o).toString();
            else if (o instanceof Long)
                result1 = ((Long) o).toString();
            else if (o instanceof Double)
                result1 = ((Double) o).toString();
            else
                throw new RuntimeException(
                        "invalid key object for cross tab key");
        }
        // result1 = (String) keyFinder.getKey(element);

        if (result1 == null) {
            result1 = "Not On Menu";
        }

        return result1;
    }

    public Collection getRows() {
        TreeSet sorted = new TreeSet(new MMSorter().getDescending("count",
                "name"));
        sorted.addAll(rows.values());
        return sorted;
    }

    public Collection getColumns() {
        TreeSet sorted = new TreeSet(new MMSorter().getDescending("count",
                "name"));
        sorted.addAll(columns.values());
        return sorted;
    }

    public Collection getColumnsWithRollUp() {
        Collection columnsWithRollUp = new ArrayList();
        int i = 0;
        for (Iterator iter = this.getColumns().iterator(); iter.hasNext(); i++) {
            CrossTabulationColumn element = (CrossTabulationColumn) iter.next();
            if (i < 8) {
                columnsWithRollUp.add(element);
            }
        }
        if (i > 8) {
            columnsWithRollUp.add(this.getRollUp());
        }

        return columnsWithRollUp;
    }

    private CrossTabulationColumn getRollUp() {
        int i = 0;
        int count = 0;
        for (Iterator iter = this.getColumns().iterator(); iter.hasNext(); i++) {
            CrossTabulationColumn element = (CrossTabulationColumn) iter.next();
            if (i > 7) {
                count += element.getCount();
            }
        }

        this.rollUpColumn.setCount(count);
        this.rollUpColumn.setTotal(this.getTotal());
        return rollUpColumn;
    }

    public CrossTabulationCellTotal getTotal() {
        return total;
    }

    public MenuMineCrossTabulationOptions getCrossTabulationOptions() {
        return crossTabulationOptions;
    }
}