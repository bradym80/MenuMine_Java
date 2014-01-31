/*
 * Created on Jan 20, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.webwork;

import java.text.DecimalFormat;
import java.util.Collection;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.fsrin.menumine.context.webwork.AbstractMenuMineSessionContextAwareAction;
import com.fsrin.menumine.core.menumine.masterfood.MasterFoodServiceDelegate;
import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableElementIF;
import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableIF;
import com.fsrin.menumine.core.menumine.util.ExcelSupport;
import com.fsrin.menumine.core.menumine.util.ExcelSupportFactory;
import com.opensymphony.xwork.Action;
import com.opensymphony.xwork.ActionContext;
import com.opensymphony.xwork.util.OgnlValueStack;

/**
 * @author Nick
 * 
 * 
 */
public class ViewStatisticalTableExcelAction extends
        AbstractMenuMineSessionContextAwareAction {

    private HSSFWorkbook workbook = null;

    // private MenuMineSessionContextWrapper menuMineSessionContextWrapper;

    private MasterFoodServiceDelegate masterFoodServiceDelegate;

    public String execute() throws Exception {

        /*
         * nick 2005-2-18 We chain here through the ViewGraphAction. This way it
         * will be on the stack and we can use it as a datasource for the stat
         * tables as it already handle the code to build a table.
         */

        OgnlValueStack stack = ActionContext.getContext().getActionInvocation()
                .getStack();

        StatisticalTableIF stats = (StatisticalTableIF) stack
                .findValue("statisticalTableResults");

        Collection results = stats.getRows();
        // Collection results = this.getStatisticalTableResults2();

        workbook = new HSSFWorkbook();

        HSSFSheet sheet = workbook.createSheet("MenuMine Statistical Table");

        HSSFRow headerRow = sheet.createRow((short) 0);

        HSSFCell cell1 = headerRow.createCell((short) 0);
        cell1.setCellValue("Name");

        HSSFCell cell2 = headerRow.createCell((short) 1);
        cell2.setCellValue("Percent");

        HSSFCell cell3 = headerRow.createCell((short) 2);
        cell3.setCellValue("Number");

        HSSFCell cell4 = headerRow.createCell((short) 3);
        cell4.setCellValue("Size of Sample");

        int j = 1;

        /*
         * nick 2005-2-18 DataFormat 8 = 8, "($#,##0.00_);[Red]($#,##0.00)"
         * http://jakarta.apache.org/poi/apidocs/org/apache/poi/hssf/usermodel/HSSFDataFormat.html
         */
        HSSFCellStyle style = workbook.createCellStyle();
        style.setDataFormat((short) 8);
        HSSFCellStyle percentStyle = workbook.createCellStyle();
      //JDL 04-29-08 Bug #19 changing to % format
      //  percentStyle.setDataFormat((short) 4);
        percentStyle.setDataFormat((short) 0xa);

        sheet.setColumnWidth((short) 0, (short) 10000);
        sheet.setColumnWidth((short) 1, (short) 5000);
        sheet.setColumnWidth((short) 2, (short) 4100);
        sheet.setColumnWidth((short) 3, (short) 3600);

        for (Iterator iter = results.iterator(); iter.hasNext();) {
            StatisticalTableElementIF element = (StatisticalTableElementIF) iter
                    .next();

            HSSFRow row = sheet.createRow((short) j);

            HSSFCell cellR1 = row.createCell((short) 0);
            cellR1.setCellValue(element.getName());

            HSSFCell cellR2 = row.createCell((short) 1);
            //JDL 04-29-08 Bug #19 changing to % format
            DecimalFormat textFormat = new DecimalFormat("0.0%");
            cellR2.setCellValue(textFormat.format((element.getPercent()/100)));
            double gg = element.getPercent();
          //  cellR2.setCellValue(element.getPercent().doubleValue());
            //cellR2.setCellStyle(percentStyle);
            
            HSSFCell cellR3 = row.createCell((short) 2);
            cellR3.setCellValue(element.getNumberInSample().longValue());

            HSSFCell cellR4 = row.createCell((short) 3);
            cellR4.setCellValue(element.getSizeOfSample().longValue());

            j++;
        }

        new ExcelSupportFactory().build().write(
                this.getMenuMineSessionContextWrapper().getAuthenticatedUser()
                        .getUsername(), workbook);

        return Action.SUCCESS;
    }

    // public MenuMineSessionContextWrapper getMenuMineSessionContextWrapper() {
    // return menuMineSessionContextWrapper;
    // }
    //
    // public void setMenuMineSessionContextWrapper(
    // MenuMineSessionContextWrapper menuMineSessionContextWrapper) {
    // this.menuMineSessionContextWrapper = menuMineSessionContextWrapper;
    // }

    public HSSFWorkbook getWorkbook() {
        return workbook;
    }
}