/*
 * Created on 2005-3-18
 *
 */
package com.fsrin.menumine.core.menubook.xwork;

import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;

import com.fsrin.menumine.common.webwork.MenuMineExcelAction;
import com.fsrin.menumine.core.menubook.MenuBook;
import com.fsrin.menumine.core.menubook.MenuBookMenuPart;
import com.fsrin.menumine.core.menumine.masterfood.MasterFood;
import com.fsrin.menumine.core.menumine.util.ExcelSupport;
import com.fsrin.menumine.core.menumine.util.ExcelSupportFactory;

/**
 * 2006-03-10 RSC Refactoring.
 * 
 * @author Nick
 * @version 1
 */

public class MenuBookTrendExcelAction extends MenuMineExcelAction {

    // private MenuMineSessionContextWrapper menuMineSessionContextWrapper;

    public String execute() throws Exception {

        ExcelSupport limitedExcelSupport = new ExcelSupportFactory().build();

        this.resetRowCount();
        MenuBook menuBook = (MenuBook) this.getDataSource("menuBook");
        HSSFSheet sheet = this.getSheet("Menu Book Trend");

        sheet.setColumnWidth((short) 0, (short) 3000);
        sheet.setColumnWidth((short) 1, (short) 6000);
        sheet.setColumnWidth((short) 2, (short) 3000);
        sheet.setColumnWidth((short) 3, (short) 3000);
        sheet.setColumnWidth((short) 4, (short) 3000);
        sheet.setColumnWidth((short) 5, (short) 3000);
        sheet.setColumnWidth((short) 6, (short) 3000);

        HSSFRow chainRow = this.newRow(sheet);
        chainRow.createCell((short) 0).setCellValue("MenuBook Trend");
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

        // int rowNum = 0;
        for (Iterator iter = menuBook.getMenuParts().iterator(); iter.hasNext();) {

            HSSFRow headerRow = this.newRow(sheet);
            // rowNum = headerRow.getRowNum();
            MenuBookMenuPart menuPart1 = (MenuBookMenuPart) iter.next();
            headerRow.createCell((short) 1).setCellValue(menuPart1.getName());
//JDL 10-5-07
            HSSFRow headerRow2 = this.newRow(sheet);
            headerRow2.createCell((short) 1).setCellValue("Name");
            
            headerRow2.createCell((short) 2).setCellValue("Price 2011");
            headerRow2.createCell((short) 3).setCellValue("Price 2010");
            // DBB 1-20-2009
            headerRow2.createCell((short) 4).setCellValue("Price 2009");
            headerRow2.createCell((short) 5).setCellValue("Price 2008");
            headerRow2.createCell((short) 6).setCellValue("Price 2007");
            headerRow2.createCell((short) 7).setCellValue("Price 2006");
            headerRow2.createCell((short) 8).setCellValue("Price 2005");
            headerRow2.createCell((short) 9).setCellValue("Price 2004");
            headerRow2.createCell((short) 10).setCellValue("Price 2003");
            headerRow2.createCell((short) 11).setCellValue("Price 2002");
            headerRow2.createCell((short) 12).setCellValue("Price 2001");
            headerRow2.createCell((short) 13).setCellValue("Price 2000");
            headerRow2.createCell((short) 14).setCellValue("Price 1999");
            headerRow2.createCell((short) 15).setCellValue("Price 1998");
            headerRow2.createCell((short) 16).setCellValue("Price 1997");
            headerRow2.createCell((short) 17).setCellValue("Price 1996");

            int i = 1;
            for (Iterator iterator = menuPart1.getMenuItems().iterator(); iterator
                    .hasNext();) {
                HSSFRow dataRow = this.newRow(sheet);
                // HSSFRow dataRow = sheet.createRow((short)i);
                MasterFood menuItem = (MasterFood) iterator.next();

                // dataRow.createCell((short) 0).setCellValue(i);
                // dataRow.createCell((short) 1).setCellValue(
                // menuItem.getMenuItem());
                //                

                try {
                    limitedExcelSupport.decorateRowWithNumericCell(0, dataRow,
                            new Integer(i));
                    limitedExcelSupport.decorateRowWithCell(1, dataRow,
                            menuItem.getMenuItem());
                    
                 // MJB 11-12-2009
                    if (menuItem.getPrice2011() != null)
                        limitedExcelSupport.decorateRowWithNumericCell(2,
                                dataRow, menuItem.getPrice2011());
                    
                    if (menuItem.getPrice2010() != null)
                        limitedExcelSupport.decorateRowWithNumericCell(2,
                                dataRow, menuItem.getPrice2010());
                    // DBB 1-20-2009
                    if (menuItem.getPrice2009() != null)
                        limitedExcelSupport.decorateRowWithNumericCell(2,
                                dataRow, menuItem.getPrice2009());
                    if (menuItem.getPrice2008() != null)
                        limitedExcelSupport.decorateRowWithNumericCell(2,
                                dataRow, menuItem.getPrice2008());
                    
                    //JDL 10-5-07
                    if (menuItem.getPrice2007() != null)
                        limitedExcelSupport.decorateRowWithNumericCell(2,
                                dataRow, menuItem.getPrice2007());
                    if (menuItem.getPrice2006() != null)
                        limitedExcelSupport.decorateRowWithNumericCell(3,
                                dataRow, menuItem.getPrice2006());
                    if (menuItem.getPrice2005() != null)
                        limitedExcelSupport.decorateRowWithNumericCell(4,
                                dataRow, menuItem.getPrice2005());
                    if (menuItem.getPrice2004() != null)
                        limitedExcelSupport.decorateRowWithNumericCell(5,
                                dataRow, menuItem.getPrice2004());
                    if (menuItem.getPrice2003() != null)
                        limitedExcelSupport.decorateRowWithNumericCell(6,
                                dataRow, menuItem.getPrice2003());
                    if (menuItem.getPrice2002() != null)
                        limitedExcelSupport.decorateRowWithNumericCell(7,
                                dataRow, menuItem.getPrice2002());
                    if (menuItem.getPrice2001() != null)
                        limitedExcelSupport.decorateRowWithNumericCell(8,
                                dataRow, menuItem.getPrice2001());
                    if (menuItem.getPrice2000() != null)
                        limitedExcelSupport.decorateRowWithNumericCell(9,
                                dataRow, menuItem.getPrice2000());
                    if (menuItem.getPrice1999() != null)
                        limitedExcelSupport.decorateRowWithNumericCell(10,
                                dataRow, menuItem.getPrice1999());
                    if (menuItem.getPrice1998() != null)
                        limitedExcelSupport.decorateRowWithNumericCell(11,
                                dataRow, menuItem.getPrice1998());
                    if (menuItem.getPrice1997() != null)
                        limitedExcelSupport.decorateRowWithNumericCell(12,
                                dataRow, menuItem.getPrice1997());
                    if (menuItem.getPrice1996() != null)
                        limitedExcelSupport.decorateRowWithNumericCell(13,
                                dataRow, menuItem.getPrice1996());
                } catch (RuntimeException e) {
                    e.printStackTrace();
                }

                i++;
            }

            HSSFRow blankRow2 = this.newRow(sheet);
        }

        limitedExcelSupport.write(this.getMenuMineSessionContextWrapper().getAuthenticatedUser().getUsername(), this.getWorkbook());
        
        return SUCCESS;
    }

}