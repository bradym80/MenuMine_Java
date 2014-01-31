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
import com.fsrin.menumine.core.menumine.natlaccountbench.NationalAccountBenchmarkElement;
import com.fsrin.menumine.core.menumine.natlaccountbench.NationalAccountBenchmarkTable;
import com.opensymphony.xwork.ActionContext;
import com.opensymphony.xwork.ActionSupport;
import com.opensymphony.xwork.util.OgnlValueStack;

/**
 * @author Nick
 * 
 *  
 */
public class NationalAccountBenchmarkExcelAction extends ActionSupport
        implements MenuMineSessionContextWrapperAware {

    private HSSFWorkbook workbook = null;

    private MenuMineSessionContextWrapper menuMineSessionContextWrapper;

    private MasterFoodServiceDelegate masterFoodServiceDelegate;

    public String execute() throws Exception {

        OgnlValueStack stack = ActionContext.getContext().getActionInvocation()
                .getStack();

        NationalAccountBenchmarkTable stats = (NationalAccountBenchmarkTable) stack
                .findValue("nationalAccountBenchmarkTableResults");

        Collection results = stats.getRows();
        // Collection results = this.getStatisticalTableResults2();

        workbook = new HSSFWorkbook();

        HSSFSheet sheet = workbook.createSheet("National Account Benchmark");

        HSSFRow headerRow = this.newRow(sheet);

        HSSFCell cell1 = headerRow.createCell((short) 0);
        cell1.setCellValue("Name");

        HSSFCell cell2 = headerRow.createCell((short) 1);
        cell2.setCellValue("Percent Target (%) "
                + stats.getShareTableA().getSizeOfSample());

        HSSFCell cell3 = headerRow.createCell((short) 2);
        cell3.setCellValue("Percent Benchmark (%) "
                + stats.getShareTableB().getSizeOfSample());

        HSSFCell cell4 = headerRow.createCell((short) 3);
        cell4.setCellValue("Index");

        /*
         * nick 2005-2-18 DataFormat 4 = 4, "#,##0.00"
         * http://jakarta.apache.org/poi/apidocs/org/apache/poi/hssf/usermodel/HSSFDataFormat.html
         */
        HSSFCellStyle style = workbook.createCellStyle();
        style.setDataFormat((short) 4);

        sheet.setColumnWidth((short) 0, (short) 10000);
        sheet.setColumnWidth((short) 1, (short) 5000);
        sheet.setColumnWidth((short) 2, (short) 6000);
        sheet.setColumnWidth((short) 3, (short) 3600);

        for (Iterator iter = results.iterator(); iter.hasNext();) {
            NationalAccountBenchmarkElement element = (NationalAccountBenchmarkElement) iter

            .next();

            HSSFRow row = this.newRow(sheet);

            HSSFCell cellR1 = row.createCell((short) 0);
            cellR1.setCellValue(element.getName());

            HSSFCell cellR2 = row.createCell((short) 1);
            cellR2.setCellValue(element.getPercentOfTarget().doubleValue());
            cellR2.setCellStyle(style);
            HSSFCell cellR3 = row.createCell((short) 2);
            cellR3.setCellValue(element.getPercentOfBenchmark().doubleValue());
            cellR3.setCellStyle(style);
            HSSFCell cellR4 = row.createCell((short) 3);
            cellR4.setCellValue(element.getIndex().doubleValue());
            cellR4.setCellStyle(style);
        }

        return ActionSupport.SUCCESS;
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