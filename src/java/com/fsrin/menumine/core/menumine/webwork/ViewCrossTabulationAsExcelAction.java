/*
 * Created on Jan 20, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.webwork;

import java.util.Collection;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.fsrin.menumine.context.webwork.AbstractMenuMineSessionContextAwareAction;
import com.fsrin.menumine.core.crosstab.CrossTabulationCell;
import com.fsrin.menumine.core.crosstab.CrossTabulationColumn;
import com.fsrin.menumine.core.crosstab.CrossTabulationRow;
import com.fsrin.menumine.core.crosstab.CrossTabulationTable;
import com.opensymphony.xwork.Action;
import com.opensymphony.xwork.ActionContext;
import com.opensymphony.xwork.util.OgnlValueStack;

/**
 * @author Nick
 * 
 *  
 */
public class ViewCrossTabulationAsExcelAction extends AbstractMenuMineSessionContextAwareAction {

    private HSSFWorkbook workbook = null;

//    private MenuMineSessionContextWrapper menuMineSessionContextWrapper;

//    private MasterFoodServiceDelegate masterFoodServiceDelegate;

    public String execute() throws Exception {

        /*
         * nick 2005-2-18 We chain here through the ViewGraphAction. This way it
         * will be on the stack and we can use it as a datasource for the stat
         * tables as it already handle the code to build a table.
         */

        OgnlValueStack stack = ActionContext.getContext().getActionInvocation()
                .getStack();

        CrossTabulationTable stats = (CrossTabulationTable) stack
                .findValue("crossTabulationResults");

        // Collection results = this.getStatisticalTableResults2();

        Collection columns = stats.getColumnsWithRollUp();

        workbook = new HSSFWorkbook();

        HSSFSheet sheet = workbook.createSheet("MenuMine Statistical Table");

        HSSFRow headerRow = sheet.createRow((short) 0);
        int i = 0;
        HSSFCell cellBlank = headerRow.createCell((short) i++);
        cellBlank.setCellValue("");

        for (Iterator iter = columns.iterator(); iter.hasNext();) {
            CrossTabulationColumn element = (CrossTabulationColumn) iter.next();
            HSSFCell cell1 = headerRow.createCell((short) i++);
            cell1.setCellValue(element.getName());
            HSSFCell cell2 = headerRow.createCell((short) i++);
            cell2.setCellValue("");

        }

        HSSFCell cellTotal1 = headerRow.createCell((short) i++);
        cellTotal1.setCellValue("Total");

        HSSFRow headerRow2 = sheet.createRow((short) 1);

        i = 0;
        HSSFCell cellBlank2 = headerRow2.createCell((short) i++);
        cellBlank.setCellValue("");

        for (Iterator iter = columns.iterator(); iter.hasNext();) {
            CrossTabulationColumn element = (CrossTabulationColumn) iter.next();
            HSSFCell cell1 = headerRow2.createCell((short) i++);
            cell1.setCellValue("#");
            HSSFCell cell2 = headerRow2.createCell((short) i++);
            cell2.setCellValue("%");

        }

        HSSFCell cellTotal21 = headerRow2.createCell((short) i++);
        cellTotal21.setCellValue("#");

        HSSFCell cellTotal22 = headerRow2.createCell((short) i++);
        cellTotal22.setCellValue("%");

        int j = 2;

        /*
         * nick 2005-2-18 DataFormat 8 = 8, "($#,##0.00_);[Red]($#,##0.00)"
         * http://jakarta.apache.org/poi/apidocs/org/apache/poi/hssf/usermodel/HSSFDataFormat.html
         */
        //        HSSFCellStyle style = workbook.createCellStyle();
        //        style.setDataFormat((short) 8);
        HSSFCellStyle percentStyle = workbook.createCellStyle();
        percentStyle.setDataFormat((short) 4);
        //
        //        sheet.setColumnWidth((short) 0, (short) 10000);
        //        sheet.setColumnWidth((short) 1, (short) 5000);
        //        sheet.setColumnWidth((short) 2, (short) 4100);
        //        sheet.setColumnWidth((short) 3, (short) 3600);
        Collection results = stats.getRows();

        for (Iterator iter = results.iterator(); iter.hasNext();) {
            CrossTabulationRow ctrow = (CrossTabulationRow) iter.next();

            HSSFRow row = sheet.createRow((short) j++);
            /*
             * Add name of the row
             */
            int k = 0;
            HSSFCell cellR1 = row.createCell((short) k++);
            cellR1.setCellValue(ctrow.getName());

            /*
             * Add each of the cells
             */
            for (Iterator iterator = ctrow.getCellsWithRollUp().iterator(); iterator
                    .hasNext();) {
                CrossTabulationCell ctcell = (CrossTabulationCell) iterator
                        .next();

                HSSFCell cellR1a = row.createCell((short) k++);
                cellR1a.setCellValue(ctcell.getCount());
                HSSFCell cellR12a = row.createCell((short) k++);
                if (ctcell.getRowPercentage() != null) {
                    cellR12a.setCellStyle(percentStyle);
                    cellR12a.setCellValue(ctcell.getColumnPercentage()
                            .doubleValue());

                }
            }

            /*
             * Add totals
             */
            HSSFCell cellR1a = row.createCell((short) k++);
            cellR1a.setCellValue(ctrow.getCount());
            HSSFCell cellR12a = row.createCell((short) k++);
            cellR12a.setCellStyle(percentStyle);
            cellR12a.setCellValue(ctrow.getColumnPercentage().doubleValue());

            HSSFRow row2 = sheet.createRow((short) j++);
            k = 0;
            HSSFCell cellR12 = row2.createCell((short) k++);
            cellR12.setCellValue("%");

            for (Iterator iterator = ctrow.getCellsWithRollUp().iterator(); iterator
                    .hasNext();) {
                CrossTabulationCell ctcell = (CrossTabulationCell) iterator
                        .next();

                HSSFCell cellR1b = row2.createCell((short) k++);
                if (ctcell.getRowPercentage() != null) {
                    cellR1b.setCellStyle(percentStyle);
                    cellR1b.setCellValue(ctcell.getRowPercentage()
                            .doubleValue());
                }
                HSSFCell cellR12b = row2.createCell((short) k++);
                cellR12b.setCellValue("");
            }

            HSSFCell cellR123 = row2.createCell((short) k++);
            cellR123.setCellStyle(percentStyle);
            cellR123.setCellValue(ctrow.getRowPercentage().doubleValue());
        }

        int l = 0;

        HSSFRow totalRow = sheet.createRow((short) ++j);
        HSSFCell cellHead = totalRow.createCell((short) l++);
        cellHead.setCellValue("Total");

        for (Iterator iter = columns.iterator(); iter.hasNext();) {
            CrossTabulationColumn element = (CrossTabulationColumn) iter.next();
            HSSFCell cell2 = totalRow.createCell((short) l++);
            cell2.setCellValue(element.getCount());

            HSSFCell cell1 = totalRow.createCell((short) l++);
            Double cp = element.getColumnPercentage();
            if (element.getColumnPercentage() != null) {
                cell1.setCellStyle(percentStyle);
                cell1.setCellValue(element.getColumnPercentage().doubleValue());
            }

        }

        HSSFCell cell2 = totalRow.createCell((short) l++);

        cell2.setCellValue(stats.getTotal().getCount());

        HSSFCell cell1 = totalRow.createCell((short) l++);
        if (stats.getTotal().getColumnPercentage() != null) {
            cell1.setCellStyle(percentStyle);
            cell1.setCellValue(stats.getTotal().getRowPercentage()
                    .doubleValue());
        }

        l = 0;

        HSSFRow totalRow2 = sheet.createRow((short) ++j);
        HSSFCell cellHead2 = totalRow2.createCell((short) l++);
        cellHead2.setCellValue("%");

        for (Iterator iter = columns.iterator(); iter.hasNext();) {
            CrossTabulationColumn element = (CrossTabulationColumn) iter.next();
            HSSFCell cell3 = totalRow2.createCell((short) l++);
            cell3.setCellStyle(percentStyle);
            cell3.setCellValue(element.getRowPercentage().doubleValue());

            HSSFCell cell4 = totalRow2.createCell((short) l++);
            cell4.setCellStyle(percentStyle);
            cell4.setCellValue("");

        }

        HSSFCell cell3 = totalRow2.createCell((short) l++);
        if (stats.getTotal().getRowPercentage() != null) {
            cell3.setCellStyle(percentStyle);
            cell3.setCellValue(stats.getTotal().getRowPercentage()
                    .doubleValue());
        }

        return Action.SUCCESS;
    }

//    public MenuMineSessionContextWrapper getMenuMineSessionContextWrapper() {
//        return menuMineSessionContextWrapper;
//    }
//
//    public void setMenuMineSessionContextWrapper(
//            MenuMineSessionContextWrapper menuMineSessionContextWrapper) {
//        this.menuMineSessionContextWrapper = menuMineSessionContextWrapper;
//    }

    public HSSFWorkbook getWorkbook() {
        return workbook;
    }
}