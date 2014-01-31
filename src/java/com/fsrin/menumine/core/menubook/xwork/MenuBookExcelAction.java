/*
 * Created on 2005-3-18
 *
 */
package com.fsrin.menumine.core.menubook.xwork;

import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;

import com.fsrin.menumine.common.webwork.MenuMineExcelAction;
import com.fsrin.menumine.context.webwork.MenuMineSessionContextWrapperAware;
import com.fsrin.menumine.core.menubook.MenuBook;
import com.fsrin.menumine.core.menubook.MenuBookMenuPart;
import com.fsrin.menumine.core.menumine.masterfood.MasterFood;
import com.fsrin.menumine.core.menumine.util.ExcelSupport;
import com.fsrin.menumine.core.menumine.util.ExcelSupportFactory;

/**
 * @author Nick
 * @version 1
 */

public class MenuBookExcelAction extends MenuMineExcelAction implements
        MenuMineSessionContextWrapperAware {

//    private MenuMineSessionContextWrapper menuMineSessionContextWrapper;

    public String execute() throws Exception {
        
        ExcelSupport limitedExcelSupport = new ExcelSupportFactory().build();
        
        this.resetRowCount();
        MenuBook menuBook = (MenuBook) this.getDataSource("menuBook");
        HSSFSheet sheet = this.getSheet("MenuBook");

        sheet.setColumnWidth((short) 0, (short) 3000);
        sheet.setColumnWidth((short) 1, (short) 6000);
        sheet.setColumnWidth((short) 2, (short) 4500);
        sheet.setColumnWidth((short) 3, (short) 3600);
        sheet.setColumnWidth((short) 4, (short) 3600);

        HSSFRow chainRow = this.newRow(sheet);
        chainRow.createCell((short) 0).setCellValue("MenuBook");
        chainRow.createCell((short) 1).setCellValue(
                menuBook.getChain().getOperationName());

        this.newRow(sheet);

        HSSFRow sectorRow = this.newRow(sheet);
        sectorRow.createCell((short) 0).setCellValue("Sector");
        sectorRow.createCell((short) 1).setCellValue(
                menuBook.getChain().getSectorName());

        HSSFRow segmentRow = this.newRow(sheet);
        segmentRow.createCell((short) 0).setCellValue("Segment");
        segmentRow.createCell((short) 1).setCellValue(
                menuBook.getChain().getSegment());

        HSSFRow blankRow = this.newRow(sheet);

        //  int rowNum = 0;
        for (Iterator iter = menuBook.getMenuParts().iterator(); iter.hasNext();) {

            HSSFRow headerRow = this.newRow(sheet);
            // rowNum = headerRow.getRowNum();
            MenuBookMenuPart menuPart1 = (MenuBookMenuPart) iter.next();
            headerRow.createCell((short) 1).setCellValue(menuPart1.getName());

            HSSFRow headerRow2 = this.newRow(sheet);
            headerRow2.createCell((short) 1).setCellValue("Name");
            headerRow2.createCell((short) 2).setCellValue("Type");
            headerRow2.createCell((short) 3).setCellValue("Price");

            int i = 1;
            for (Iterator iterator = menuPart1.getMenuItems().iterator(); iterator
                    .hasNext();) {
                HSSFRow dataRow = this.newRow(sheet);
                //  HSSFRow dataRow = sheet.createRow((short)i);
                MasterFood menuItem = (MasterFood) iterator.next();

                dataRow.createCell((short) 0).setCellValue(i);
                dataRow.createCell((short) 1).setCellValue(
                        menuItem.getMenuItem());
                dataRow.createCell((short) 2).setCellValue(
                        menuItem.getMenuItemType());
                
                /*
                 * 2006-03-10 RSC Just for formatting.
                 */
                limitedExcelSupport.decorateRowWithNumericCell(3,dataRow,menuItem.getPriceCurrent());
                
//                dataRow.createCell((short) 3).setCellValue(
//                        menuItem.getPriceCurrent().doubleValue());
                i++;
            }


            HSSFRow blankRow2 = this.newRow(sheet);
        }
        
        limitedExcelSupport.write(this.getMenuMineSessionContextWrapper().getAuthenticatedUser().getUsername(), this.getWorkbook());

        return SUCCESS;
    }


}