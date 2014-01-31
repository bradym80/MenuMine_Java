/*
 * Created on Jan 20, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.webwork;

import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
public class ViewMeanTrendExcelAction extends
        AbstractMenuMineSessionContextAwareAction {

    private Log log = LogFactory.getLog(ViewMeanTrendExcelAction.class);

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


        
        this.createAndPopulateCell(headerRow,0,"Name");


        
        this.createAndPopulateCell(headerRow,1,"Number");


        // MJB 11-12-2009 Added 2010
        this.createAndPopulateCell(headerRow, 2, "Mean 2011");
        this.createAndPopulateCell(headerRow, 3, "Mean 2010");
        // DBB 1-20-2009 Add 2008, 2009
        this.createAndPopulateCell(headerRow, 4, "Mean 2009");
        this.createAndPopulateCell(headerRow, 5, "Mean 2008");
        
        //JDL 10-5-07
        this.createAndPopulateCell(headerRow, 6, "Mean 2007");
        this.createAndPopulateCell(headerRow, 7, "Mean 2006");
        this.createAndPopulateCell(headerRow, 8, "Mean 2005");
        this.createAndPopulateCell(headerRow, 9, "Mean 2004");
        this.createAndPopulateCell(headerRow, 10, "Mean 2003");
        this.createAndPopulateCell(headerRow, 11, "Mean 2002");
        this.createAndPopulateCell(headerRow, 12, "Mean 2001");
        this.createAndPopulateCell(headerRow, 13, "Mean 2000");
        this.createAndPopulateCell(headerRow, 14, "Mean 1999");
        this.createAndPopulateCell(headerRow, 15, "Mean 1998");
        this.createAndPopulateCell(headerRow, 16, "Mean 1997");
        this.createAndPopulateCell(headerRow, 17, "Mean 1996");



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

            
            this.createAndPopulateCell(row,0,element.getName());


            this.createAndPopulateCell(row,1,element.getNumberInSample().toString());
            
            // MJB 11-12-2009 Added 2010
            this.createAndPopulateCell(row,2,element.getPriceData().getAveragePrice2011(), style);
            this.createAndPopulateCell(row,3,element.getPriceData().getAveragePrice2010(), style); 
            // DBB 1-20-2009 Add 2008, 2009
            this.createAndPopulateCell(row,4,element.getPriceData().getAveragePrice2009(), style);
            this.createAndPopulateCell(row,5,element.getPriceData().getAveragePrice2008(), style);
            
            //JDL 10-5-07
            this.createAndPopulateCell(row,6,element.getPriceData().getAveragePrice2007(), style);
            this.createAndPopulateCell(row,7,element.getPriceData().getAveragePrice2006(), style);
            this.createAndPopulateCell(row,8,element.getPriceData().getAveragePrice2005(), style);
            this.createAndPopulateCell(row,9,element.getPriceData().getAveragePrice2004(), style);
            this.createAndPopulateCell(row,10,element.getPriceData().getAveragePrice2003(), style);
            this.createAndPopulateCell(row,11,element.getPriceData().getAveragePrice2002(), style);
            this.createAndPopulateCell(row,12,element.getPriceData().getAveragePrice2001(), style);
            this.createAndPopulateCell(row,13,element.getPriceData().getAveragePrice2000(), style);
            this.createAndPopulateCell(row,14,element.getPriceData().getAveragePrice1999(), style);
            this.createAndPopulateCell(row,15,element.getPriceData().getAveragePrice1998(), style);
            this.createAndPopulateCell(row,16,element.getPriceData().getAveragePrice1997(), style);
            this.createAndPopulateCell(row,17,element.getPriceData().getAveragePrice1996(), style);
            


            j++;
        }

        HSSFRow row = sheet.createRow((short) ++j);

        HSSFCell cellR1 = row.createCell((short) 0);
        cellR1.setCellValue(stats.getTotal().getName());

        HSSFCell cellR3 = row.createCell((short) 1);
        cellR3.setCellValue(stats.getTotal().getNumberInSample().longValue());
        
        // MJB 11-12-2009 Added 2010
        this.createAndPopulateCell(row,2,stats.getTotal().getPriceData().getAveragePrice2011(), style);
        this.createAndPopulateCell(row,3,stats.getTotal().getPriceData().getAveragePrice2010(), style);
        // DBB 1-20-2009 Add 2008, 2009
        this.createAndPopulateCell(row,4,stats.getTotal().getPriceData().getAveragePrice2009(), style);
        this.createAndPopulateCell(row,5,stats.getTotal().getPriceData().getAveragePrice2008(), style);
        
        //JDL 10-5-07
        this.createAndPopulateCell(row,6,stats.getTotal().getPriceData().getAveragePrice2007(), style);
        this.createAndPopulateCell(row,7,stats.getTotal().getPriceData().getAveragePrice2006(), style);
        this.createAndPopulateCell(row,8,stats.getTotal().getPriceData().getAveragePrice2005(), style);
        this.createAndPopulateCell(row,9,stats.getTotal().getPriceData().getAveragePrice2004(), style);
        this.createAndPopulateCell(row,10,stats.getTotal().getPriceData().getAveragePrice2003(), style);
        this.createAndPopulateCell(row,11,stats.getTotal().getPriceData().getAveragePrice2002(), style);
        this.createAndPopulateCell(row,12,stats.getTotal().getPriceData().getAveragePrice2001(), style);
        this.createAndPopulateCell(row,13,stats.getTotal().getPriceData().getAveragePrice2000(), style);
        this.createAndPopulateCell(row,14,stats.getTotal().getPriceData().getAveragePrice1999(), style);
        this.createAndPopulateCell(row,15,stats.getTotal().getPriceData().getAveragePrice1998(), style);
        this.createAndPopulateCell(row,16,stats.getTotal().getPriceData().getAveragePrice1997(), style);
        this.createAndPopulateCell(row,17,stats.getTotal().getPriceData().getAveragePrice1996(), style);

        new ExcelSupportFactory().build().write(
                this.getMenuMineSessionContextWrapper().getAuthenticatedUser()
                        .getUsername(), workbook);

        return Action.SUCCESS;
    }

    
    private void createAndPopulateCell(HSSFRow row, int id,
            String label) {

        short cellId = (short) id;
        
        HSSFCell cell = row.createCell(cellId);

        try {
            cell.setCellValue(label);
            
        } catch (Exception e) {
            log.warn("failed to populate a cell properly", e);
        }
    }
    
    private void createAndPopulateCell(HSSFRow row, int id,
            Double number, HSSFCellStyle style) {

        short cellId = (short) id;
        
        HSSFCell cell = row.createCell(cellId);

        try {
            cell.setCellValue(number.doubleValue());
            cell.setCellStyle(style);
        } catch (Exception e) {
            log.warn("failed to populate a cell properly", e);
        }
    }


    public HSSFWorkbook getWorkbook() {
        return workbook;
    }
}