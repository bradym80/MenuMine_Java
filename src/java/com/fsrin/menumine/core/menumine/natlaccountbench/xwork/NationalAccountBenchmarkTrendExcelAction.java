/*
 * Created on Jan 20, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.natlaccountbench.xwork;

import java.util.Collection;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.fsrin.menumine.context.webwork.MenuMineSessionContextWrapper;
import com.fsrin.menumine.context.webwork.MenuMineSessionContextWrapperAware;
import com.fsrin.menumine.core.menumine.masterfood.MasterFoodServiceDelegate;
import com.fsrin.menumine.core.menumine.natlaccountbench.NationalAccountBenchmarkTrendElement;
import com.fsrin.menumine.core.menumine.natlaccountbench.NationalAccountBenchmarkTrendTable;
import com.opensymphony.xwork.Action;
import com.opensymphony.xwork.ActionContext;
import com.opensymphony.xwork.ActionSupport;
import com.opensymphony.xwork.util.OgnlValueStack;

/**
 * @author Nick
 * 
 *  
 */
public class NationalAccountBenchmarkTrendExcelAction extends ActionSupport
        implements MenuMineSessionContextWrapperAware {

    private HSSFWorkbook workbook = null;

    private MenuMineSessionContextWrapper menuMineSessionContextWrapper;

    private MasterFoodServiceDelegate masterFoodServiceDelegate;

    public String execute() throws Exception {

        OgnlValueStack stack = ActionContext.getContext().getActionInvocation()
                .getStack();

        NationalAccountBenchmarkTrendTable stats = (NationalAccountBenchmarkTrendTable) stack
                .findValue("nationalAccountBenchmarkTrendTableResults");
        workbook = new HSSFWorkbook();

        Collection results = stats.getRows();
        // Collection results = this.getStatisticalTableResults2();

        if (stats == null) {
            return ERROR;
        }

        HSSFSheet sheet = workbook
                .createSheet("Nat'l Account Benchmark Trends");

        HSSFRow headerRow = this.newRow(sheet);

        HSSFCell cell1 = headerRow.createCell((short) 0);
        cell1.setCellValue("Name");

        HSSFCell cell2 = headerRow.createCell((short) 1);
        cell2.setCellValue("2004");

        HSSFCell cell3 = headerRow.createCell((short) 3);
        cell3.setCellValue("2001");
        HSSFCell cell4 = headerRow.createCell((short) 5);
        cell4.setCellValue("1998");

        HSSFRow headerRow2 = this.newRow(sheet);
        HSSFRow headerRow3 = this.newRow(sheet);

        HSSFCell cell2_1 = headerRow2.createCell((short) 1);
        cell2_1.setCellValue("Target (%)");

        HSSFCell cell3_1 = headerRow3.createCell((short) 1);
        cell3_1.setCellValue(stats.getDataRecent().getShareTableA()
                .getSizeOfSample().doubleValue());

        HSSFCell cell2_2 = headerRow2.createCell((short) 2);
        cell2_2.setCellValue("Benchmark  (%)");

        HSSFCell cell3_2 = headerRow3.createCell((short) 2);
        cell3_2.setCellValue(stats.getDataRecent().getShareTableB()
                .getSizeOfSample().doubleValue());

        HSSFCell cell2_3 = headerRow2.createCell((short) 3);
        cell2_3.setCellValue("Target (%)");

        HSSFCell cell3_3 = headerRow3.createCell((short) 3);
        cell3_3.setCellValue(stats.getDataMiddle().getShareTableA()
                .getSizeOfSample().doubleValue());

        HSSFCell cell2_4 = headerRow2.createCell((short) 4);
        cell2_4.setCellValue("Benchmark  (%)");

        HSSFCell cell3_4 = headerRow3.createCell((short) 4);
        cell3_4.setCellValue(stats.getDataMiddle().getShareTableB()
                .getSizeOfSample().doubleValue());

        HSSFCell cell2_5 = headerRow2.createCell((short) 5);
        cell2_5.setCellValue("Target (%)");

        HSSFCell cell3_5 = headerRow3.createCell((short) 5);
        cell3_5.setCellValue(stats.getDataOldest().getShareTableA()
                .getSizeOfSample().doubleValue());

        HSSFCell cell2_6 = headerRow2.createCell((short) 6);
        cell2_6.setCellValue("Benchmark  (%)");

        HSSFCell cell3_6 = headerRow3.createCell((short) 6);
        cell3_6.setCellValue(stats.getDataOldest().getShareTableB()
                .getSizeOfSample().doubleValue());

        /*
         * nick 2005-2-18 DataFormat 4 = 4, "#,##0.00"
         * http://jakarta.apache.org/poi/apidocs/org/apache/poi/hssf/usermodel/HSSFDataFormat.html
         */
        HSSFCellStyle style = workbook.createCellStyle();
        style.setDataFormat((short) 4);

        sheet.setColumnWidth((short) 0, (short) 10000);
        sheet.setColumnWidth((short) 1, (short) 5000);
        sheet.setColumnWidth((short) 2, (short) 4100);
        sheet.setColumnWidth((short) 3, (short) 3600);

        for (Iterator iter = results.iterator(); iter.hasNext();) {
            NationalAccountBenchmarkTrendElement element = (NationalAccountBenchmarkTrendElement) iter

            .next();

            HSSFRow row = this.newRow(sheet);

            HSSFCell cellR1 = row.createCell((short) 0);
            cellR1.setCellValue(element.getName());

            HSSFCell cellR2 = row.createCell((short) 1);
            cellR2.setCellValue(element.getBenchmarkRecent().getPercentOfTarget()
                    .doubleValue());
            cellR2.setCellStyle(style);
            HSSFCell cellR3 = row.createCell((short) 2);
            cellR3.setCellValue(element.getBenchmarkRecent()
                    .getPercentOfBenchmark().doubleValue());
            cellR3.setCellStyle(style);
            HSSFCell cellR4 = row.createCell((short) 3);
            cellR4.setCellValue(element.getBenchmarkMiddle().getPercentOfTarget()
                    .doubleValue());
            cellR4.setCellStyle(style);
            HSSFCell cellR5 = row.createCell((short) 4);
            cellR5.setCellValue(element.getBenchmarkMiddle()
                    .getPercentOfBenchmark().doubleValue());
            cellR5.setCellStyle(style);
            HSSFCell cellR6 = row.createCell((short) 5);
            cellR6.setCellValue(element.getBenchmarkOldest().getPercentOfTarget()
                    .doubleValue());
            cellR6.setCellStyle(style);
            HSSFCell cellR7 = row.createCell((short) 6);
            cellR7.setCellValue(element.getBenchmarkOldest()
                    .getPercentOfBenchmark().doubleValue());
            cellR7.setCellStyle(style);

            HSSFRow rowIndex = this.newRow(sheet);

            HSSFCell cellRI3 = rowIndex.createCell((short) 2);
            cellRI3.setCellValue(element.getBenchmarkRecent().getIndex()
                    .doubleValue());
            cellRI3.setCellStyle(style);
            HSSFCell cellRI5 = rowIndex.createCell((short) 4);
            cellRI5.setCellValue(element.getBenchmarkMiddle().getIndex()
                    .doubleValue());
            cellRI5.setCellStyle(style);

            HSSFCell cellRI7 = rowIndex.createCell((short) 6);
            cellRI7.setCellValue(element.getBenchmarkOldest().getIndex()
                    .doubleValue());
            cellRI7.setCellStyle(style);
            //            HSSFCell cellR4 = row.createCell((short) 3);
            //            cellR4.setCellValue(element.getIndex().doubleValue());

        }

        return Action.SUCCESS;
    }

    private short rowNumber = 0;

    private HSSFRow newRow(HSSFSheet sheet) {
        HSSFRow row = sheet.createRow((short) rowNumber++);
        return row;
    }

    public MenuMineSessionContextWrapper getMenuMineSessionContextWrapper() {
        return menuMineSessionContextWrapper;
    }

    public void setMenuMineSessionContextWrapper(
            MenuMineSessionContextWrapper menuMineSessionContextWrapper) {
        this.menuMineSessionContextWrapper = menuMineSessionContextWrapper;
    }

    public HSSFWorkbook getWorkbook() {
        return workbook;
    }
}