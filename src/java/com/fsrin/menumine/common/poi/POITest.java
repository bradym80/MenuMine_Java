/*
 * Created on Jan 25, 2005
 *
 * 
 */
package com.fsrin.menumine.common.poi;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import junit.framework.TestCase;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.fsrin.menumine.core.menumine.masterfood.MasterFood;

/**
 * @author Nick
 * 
 *  
 */
public class POITest extends TestCase {

    public POITest() {
        super();

    }

    public void testPoi() throws Exception {

        Collection results = new ArrayList();

        for (int i = 0; i < 100; i++) {

            MasterFood food = new MasterFood();
            food.setPrice2001(new Double(i));
            food.setCheeseMM("Blu" + i);
            food.setCuisine("Asian" + i);
            food.setCookMeth("Boiled" + i);
            results.add(food);
        }

        OutputStream os = new FileOutputStream("C:\\text.xls");

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Java Excels");

        int j = 0;
        for (Iterator iter = results.iterator(); iter.hasNext();) {
            MasterFood element = (MasterFood) iter.next();

            HSSFRow row = sheet.createRow((short) j);

            HSSFCell cell1 = row.createCell((short) 0);
            cell1.setCellValue(element.getPrice2001().doubleValue());

            HSSFCell cell2 = row.createCell((short) 1);
            cell2.setCellValue(element.getCheeseMM());

            HSSFCell cell3 = row.createCell((short) 2);
            cell3.setCellValue(element.getCuisine());

            HSSFCell cell4 = row.createCell((short) 3);
            cell4.setCellValue(element.getCookMeth());
            j++;
        }
        workbook.write(os);

    }
}