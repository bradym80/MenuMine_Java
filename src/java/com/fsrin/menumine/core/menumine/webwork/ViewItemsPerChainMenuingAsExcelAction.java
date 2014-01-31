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
import org.apache.poi.hssf.util.HSSFColor;

import com.fsrin.menumine.context.webwork.AbstractMenuMineSessionContextAwareAction;
import com.fsrin.menumine.core.incidence.IncidenceSector;
import com.fsrin.menumine.core.incidence.IncidenceSegment;
import com.fsrin.menumine.core.incidence.IncidenceTable;
import com.fsrin.menumine.core.menumine.masterfood.MasterFoodServiceDelegate;
import com.fsrin.menumine.core.menumine.util.ExcelSupportFactory;
import com.opensymphony.xwork.Action;
import com.opensymphony.xwork.ActionContext;
import com.opensymphony.xwork.util.OgnlValueStack;

/**
 * @author Nick
 * 
 *  
 */
public class ViewItemsPerChainMenuingAsExcelAction extends AbstractMenuMineSessionContextAwareAction {

    private HSSFWorkbook workbook = null;

//    private MenuMineSessionContextWrapper menuMineSessionContextWrapper;

    private MasterFoodServiceDelegate masterFoodServiceDelegate;

    public String execute() throws Exception {

        /*
         * nick 2005-2-18 We chain here through the ViewGraphAction. This way it
         * will be on the stack and we can use it as a datasource for the stat
         * tables as it already handle the code to build a table.
         */

        OgnlValueStack stack = ActionContext.getContext().getActionInvocation()
                .getStack();

        IncidenceTable incidenceTable = (IncidenceTable) stack
                .findValue("incidenceTableResults");

        workbook = new HSSFWorkbook();

        HSSFSheet sheet = workbook.createSheet("MenuMine Statistical Table");

        HSSFRow headerRow = sheet.createRow((short) 0);

        HSSFCell cell1 = headerRow.createCell((short) 0);
        cell1.setCellValue("");

        HSSFCell cell2 = headerRow.createCell((short) 1);
        cell2.setCellValue("# Chains Menuing Item");

        HSSFCell cell3 = headerRow.createCell((short) 2);
        cell3.setCellValue("# Items Being Menued");

        HSSFCell cell4 = headerRow.createCell((short) 3);
        cell4.setCellValue("# Items/Chain Menuing");

        int j = 1;

        /*
         * nick 2005-2-18 DataFormat 8 = 8, "($#,##0.00_);[Red]($#,##0.00)"
         * http://jakarta.apache.org/poi/apidocs/org/apache/poi/hssf/usermodel/HSSFDataFormat.html
         */
        HSSFCellStyle dollarStyle = workbook.createCellStyle();
        dollarStyle.setDataFormat((short) 8);

        HSSFCellStyle percentStyle = workbook.createCellStyle();
        percentStyle.setDataFormat((short) 4);

        HSSFCellStyle percentSectorStyle = workbook.createCellStyle();
        percentSectorStyle.setDataFormat((short) 4);
        percentSectorStyle
                .setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
        percentSectorStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

        HSSFCellStyle style = workbook.createCellStyle();
        style.setDataFormat((short) 2);
        style.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

        sheet.setColumnWidth((short) 0, (short) 10000);
        sheet.setColumnWidth((short) 1, (short) 5000);
        sheet.setColumnWidth((short) 2, (short) 4100);
        sheet.setColumnWidth((short) 3, (short) 3600);

        Collection results = incidenceTable.getIncidenceSectors();

        for (Iterator iter = results.iterator(); iter.hasNext();) {
            IncidenceSector currentIncidenceSector = (IncidenceSector) iter
                    .next();

            for (Iterator iter2 = currentIncidenceSector.getIncidenceSegments()
                    .iterator(); iter2.hasNext();) {

                IncidenceSegment currentIncidenceSegment = (IncidenceSegment) iter2
                        .next();

                HSSFRow segmentRow = sheet.createRow((short) j++);

                HSSFCell segmentNameCell = segmentRow.createCell((short) 0);
                segmentNameCell.setCellValue(currentIncidenceSegment.getName());

                HSSFCell segmentChainCountCell = segmentRow
                        .createCell((short) 1);
                segmentChainCountCell.setCellValue(currentIncidenceSegment
                        .getNumberOfChainsMenuingItems());

                HSSFCell segmentChainsMenuingCell = segmentRow
                        .createCell((short) 2);
                segmentChainsMenuingCell.setCellValue(currentIncidenceSegment
                        .getNumberOfItemsBeingMenued());

                HSSFCell segmentIncidenceCell = segmentRow
                        .createCell((short) 3);
                segmentIncidenceCell.setCellValue(currentIncidenceSegment
                        .getNumberOfItemsPerChainMenued());

                segmentIncidenceCell.setCellStyle(percentStyle);

            }
            HSSFRow row = sheet.createRow((short) j++);

            HSSFCell nameCell = row.createCell((short) 0);
            nameCell.setCellValue(currentIncidenceSector.getName());
            nameCell.setCellStyle(style);

            HSSFCell chainCountCell = row.createCell((short) 1);
            chainCountCell.setCellValue(currentIncidenceSector
                    .getNumberOfChainsMenuingItems());
            chainCountCell.setCellStyle(style);

            HSSFCell chainsMenuingCell = row.createCell((short) 2);
            chainsMenuingCell.setCellValue(currentIncidenceSector
                    .getNumberOfItemsBeingMenued());
            chainsMenuingCell.setCellStyle(style);

            HSSFCell incidenceCell = row.createCell((short) 3);
            incidenceCell.setCellValue(currentIncidenceSector
                    .getNumberOfItemsPerChainMenued());
            incidenceCell.setCellStyle(percentSectorStyle);
        }

        /*
         * Totals.
         */

        HSSFRow totalRow = sheet.createRow((short) j++);

        HSSFCell totalNameCell = totalRow.createCell((short) 0);
        totalNameCell.setCellValue("TOTAL");

        HSSFCell totalChainCountCell = totalRow.createCell((short) 1);
        totalChainCountCell.setCellValue(incidenceTable.getTotals()
                .getNumberOfChainsMenuingItems());

        HSSFCell totalChainsMenuingCell = totalRow.createCell((short) 2);
        totalChainsMenuingCell.setCellValue(incidenceTable.getTotals()
                .getNumberOfItemsBeingMenued());

        HSSFCell totalIncidenceCell = totalRow.createCell((short) 3);
        totalIncidenceCell.setCellValue(incidenceTable.getTotals()
                .getNumberOfItemsPerChainMenued());

        new ExcelSupportFactory().build().write(
                this.getMenuMineSessionContextWrapper().getAuthenticatedUser()
                        .getUsername(), workbook);
        
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