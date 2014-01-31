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
import com.fsrin.menumine.core.menumine.masterfood.MasterFoodServiceDelegate;
import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableElementIF;
import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableIF;
import com.fsrin.menumine.core.menumine.util.ExcelSupportFactory;
import com.opensymphony.xwork.Action;
import com.opensymphony.xwork.ActionContext;
import com.opensymphony.xwork.util.OgnlValueStack;

/**
 * @author Nick
 * 
 *  
 */
public class ViewMedianTrendExcelAction extends AbstractMenuMineSessionContextAwareAction {

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

        StatisticalTableIF stats = (StatisticalTableIF) stack
                .findValue("statisticalTableResults");

        Collection results = stats.getRows();
        // Collection results = this.getStatisticalTableResults2();

        workbook = new HSSFWorkbook();

        HSSFSheet sheet = workbook.createSheet("Median Price Trend Table");

        HSSFRow headerRow = sheet.createRow((short) 0);

        HSSFCell cell1 = headerRow.createCell((short) 0);
        cell1.setCellValue("Name");

        HSSFCell cell3 = headerRow.createCell((short) 1);
        cell3.setCellValue("Number");
        
        // MJB 11-12-2009 Added 2010
        HSSFCell cell4f = headerRow.createCell((short) 2);
        cell4f.setCellValue("Median 2011");
        HSSFCell cell4e = headerRow.createCell((short) 3);
        cell4e.setCellValue("Median 2010");
        // DBB 1-20-2009 Add 2008, 2009
        HSSFCell cell4d = headerRow.createCell((short) 4);
        cell4d.setCellValue("Median 2009");
        
        HSSFCell cell4c = headerRow.createCell((short) 5);
        cell4d.setCellValue("Median 2008");
        
        //JDL 10-5-07
        HSSFCell cell4b = headerRow.createCell((short) 6);
        cell4b.setCellValue("Median 2007");
        
        HSSFCell cell4a = headerRow.createCell((short) 7);
        cell4a.setCellValue("Median 2006");
        
        HSSFCell cell4 = headerRow.createCell((short) 8);
        cell4.setCellValue("Median 2005");
        
        HSSFCell cell5 = headerRow.createCell((short) 9);
        cell5.setCellValue("Median 2004");

        HSSFCell cell6 = headerRow.createCell((short) 10);
        cell6.setCellValue("Median 2003");

        HSSFCell cell7 = headerRow.createCell((short) 11);
        cell7.setCellValue("Median 2002");

        HSSFCell cell8 = headerRow.createCell((short) 12);
        cell8.setCellValue("Median 2001");

        HSSFCell cell9 = headerRow.createCell((short) 13);
        cell9.setCellValue("Median 2000");

        HSSFCell cell10 = headerRow.createCell((short) 14);
        cell10.setCellValue("Median 1999");

        HSSFCell cell11 = headerRow.createCell((short) 15);
        cell11.setCellValue("Median 1998");

        HSSFCell cell12 = headerRow.createCell((short) 16);
        cell12.setCellValue("Median 1997");

        HSSFCell cell13 = headerRow.createCell((short) 17);
        cell13.setCellValue("Median 1996");

        int j = 1;

        /*
         * nick 2005-2-18 DataFormat 8 = 8, "($#,##0.00_);[Red]($#,##0.00)"
         * http://jakarta.apache.org/poi/apidocs/org/apache/poi/hssf/usermodel/HSSFDataFormat.html
         */
        HSSFCellStyle style = workbook.createCellStyle();
        style.setDataFormat((short) 8);
        HSSFCellStyle percentStyle = workbook.createCellStyle();
        percentStyle.setDataFormat((short) 4);

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

            HSSFCell cellR3 = row.createCell((short) 1);
            cellR3.setCellValue(element.getNumberInSample().longValue());
            
            // DBB 1-20-2009 Add 2008, 2009
            HSSFCell cellR4f = row.createCell((short) 2);
            cellR4f.setCellValue(element.getPriceData().getMedianPrice2011()
                    .doubleValue());
            cellR4f.setCellStyle(style);
            HSSFCell cellR4e = row.createCell((short) 3);
            cellR4e.setCellValue(element.getPriceData().getMedianPrice2010()
                    .doubleValue());
            cellR4e.setCellStyle(style);
            // DBB 1-20-2009 Add 2008, 2009
            HSSFCell cellR4d = row.createCell((short) 4);
            cellR4d.setCellValue(element.getPriceData().getMedianPrice2009()
                    .doubleValue());
            cellR4d.setCellStyle(style);
            
            HSSFCell cellR4c = row.createCell((short) 5);
            cellR4c.setCellValue(element.getPriceData().getMedianPrice2008()
                    .doubleValue());
            cellR4c.setCellStyle(style);
       
            //JDL 10-5-07
            HSSFCell cellR4b = row.createCell((short) 6);
            cellR4b.setCellValue(element.getPriceData().getMedianPrice2007()
                    .doubleValue());
            cellR4b.setCellStyle(style);
            
            HSSFCell cellR4a = row.createCell((short) 7);
            cellR4a.setCellValue(element.getPriceData().getMedianPrice2006()
                    .doubleValue());
            cellR4a.setCellStyle(style);
            
            HSSFCell cellR4 = row.createCell((short) 8);
            cellR4.setCellValue(element.getPriceData().getMedianPrice2005()
                    .doubleValue());
            cellR4.setCellStyle(style);
            
           
            HSSFCell cellR5 = row.createCell((short) 9);
            cellR5.setCellValue(element.getPriceData().getMedianPrice2004()
                    .doubleValue());
            cellR5.setCellStyle(style);

            HSSFCell cellR6 = row.createCell((short) 10);
            cellR6.setCellValue(element.getPriceData().getMedianPrice2003()
                    .doubleValue());
            cellR6.setCellStyle(style);

            HSSFCell cellR7 = row.createCell((short) 11);
            cellR7.setCellValue(element.getPriceData().getMedianPrice2002()
                    .doubleValue());
            cellR7.setCellStyle(style);

            HSSFCell cellR8 = row.createCell((short) 12);
            cellR8.setCellValue(element.getPriceData().getMedianPrice2001()
                    .doubleValue());
            cellR8.setCellStyle(style);

            HSSFCell cellR9 = row.createCell((short) 13);
            cellR9.setCellValue(element.getPriceData().getMedianPrice2000()
                    .doubleValue());
            cellR9.setCellStyle(style);

            HSSFCell cellR10 = row.createCell((short) 14);
            cellR10.setCellValue(element.getPriceData().getMedianPrice1999()
                    .doubleValue());
            cellR10.setCellStyle(style);

            HSSFCell cellR11 = row.createCell((short) 15);
            cellR11.setCellValue(element.getPriceData().getMedianPrice1998()
                    .doubleValue());
            cellR11.setCellStyle(style);

            HSSFCell cellR12 = row.createCell((short) 16);
            cellR12.setCellValue(element.getPriceData().getMedianPrice1997()
                    .doubleValue());
            cellR12.setCellStyle(style);

            HSSFCell cellR13 = row.createCell((short) 17);
            cellR13.setCellValue(element.getPriceData().getMedianPrice1996()
                    .doubleValue());
            cellR13.setCellStyle(style);

            j++;
        }

        HSSFRow row = sheet.createRow((short) ++j);

        HSSFCell cellR1 = row.createCell((short) 0);
        cellR1.setCellValue(stats.getTotal().getName());

        HSSFCell cellR3 = row.createCell((short) 1);
        cellR3.setCellValue(stats.getTotal().getNumberInSample().longValue());

        // DBB 1-20-2009
        HSSFCell cellR4f = row.createCell((short) 2);
        cellR4f.setCellValue(stats.getTotal().getPriceData()
                .getMedianPrice2011().doubleValue());
        cellR4f.setCellStyle(style);
        
        HSSFCell cellR4e = row.createCell((short) 3);
        cellR4e.setCellValue(stats.getTotal().getPriceData()
                .getMedianPrice2010().doubleValue());
        cellR4e.setCellStyle(style);
        
        HSSFCell cellR4d = row.createCell((short) 4);
        cellR4d.setCellValue(stats.getTotal().getPriceData()
                .getMedianPrice2009().doubleValue());
        cellR4d.setCellStyle(style);
        
        HSSFCell cellR4c = row.createCell((short) 5);
        cellR4c.setCellValue(stats.getTotal().getPriceData()
                .getMedianPrice2008().doubleValue());
        cellR4c.setCellStyle(style);
        
        //JDL 10-5-07
        HSSFCell cellR4b = row.createCell((short) 6);
        cellR4b.setCellValue(stats.getTotal().getPriceData()
                .getMedianPrice2007().doubleValue());
        cellR4b.setCellStyle(style);
        
        
        HSSFCell cellR4a = row.createCell((short) 7);
        cellR4a.setCellValue(stats.getTotal().getPriceData()
                .getMedianPrice2006().doubleValue());
        cellR4a.setCellStyle(style);
        
        HSSFCell cellR4 = row.createCell((short) 8);
        cellR4.setCellValue(stats.getTotal().getPriceData()
                .getMedianPrice2005().doubleValue());
        cellR4.setCellStyle(style);
        
        HSSFCell cellR5 = row.createCell((short) 9);
        cellR5.setCellValue(stats.getTotal().getPriceData()
                .getMedianPrice2004().doubleValue());
        cellR5.setCellStyle(style);

        HSSFCell cellR6 = row.createCell((short) 10);
        cellR6.setCellValue(stats.getTotal().getPriceData()
                .getMedianPrice2003().doubleValue());
        cellR6.setCellStyle(style);

        HSSFCell cellR7 = row.createCell((short) 11);
        cellR7.setCellValue(stats.getTotal().getPriceData()
                .getMedianPrice2002().doubleValue());
        cellR7.setCellStyle(style);

        HSSFCell cellR8 = row.createCell((short) 12);
        cellR8.setCellValue(stats.getTotal().getPriceData()
                .getMedianPrice2001().doubleValue());
        cellR8.setCellStyle(style);

        HSSFCell cellR9 = row.createCell((short) 13);
        cellR9.setCellValue(stats.getTotal().getPriceData()
                .getMedianPrice2000().doubleValue());
        cellR9.setCellStyle(style);

        HSSFCell cellR10 = row.createCell((short) 12);
        cellR10.setCellValue(stats.getTotal().getPriceData()
                .getMedianPrice1999().doubleValue());
        cellR10.setCellStyle(style);

        HSSFCell cellR11 = row.createCell((short) 13);
        cellR11.setCellValue(stats.getTotal().getPriceData()
                .getMedianPrice1998().doubleValue());
        cellR11.setCellStyle(style);

        HSSFCell cellR12 = row.createCell((short) 14);
        cellR12.setCellValue(stats.getTotal().getPriceData()
                .getMedianPrice1997().doubleValue());
        cellR12.setCellStyle(style);

        HSSFCell cellR13 = row.createCell((short) 15);
        cellR13.setCellValue(stats.getTotal().getPriceData()
                .getMedianPrice1996().doubleValue());
        cellR13.setCellStyle(style);

        new ExcelSupportFactory().build().write(
                this.getMenuMineSessionContextWrapper().getAuthenticatedUser()
                        .getUsername(), workbook);
        
        return Action.SUCCESS;
    }

    public HSSFWorkbook getWorkbook() {
        return workbook;
    }
}