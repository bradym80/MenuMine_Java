/*
 * Created on May 15, 2006 by Reid
 * MJB 11-12-2009 Changed to 2004 vs 2009
 */
package com.fsrin.menumine.core.menumine.webwork;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableElementIF;
import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableIF;
import com.fsrin.menumine.core.menumine.util.ExcelSupport;
import com.fsrin.menumine.core.menumine.util.ExcelSupportFactory;

public abstract class AbstractTrendTableAction extends
        AbstractMenuMineDisplayAction {

    //private StatisticalTableIF trend2001;
    //private StatisticalTableIF trend2005;
	private StatisticalTableIF trend2006;
    private StatisticalTableIF trend2011;
    
    private boolean sideBySide;

    public boolean isSideBySide() {
        return sideBySide;
    }

    public void setSideBySide(boolean sideBySide) {
        this.sideBySide = sideBySide;
    }

    /*public StatisticalTableIF getTrend2001() {
        return trend2001;
    }*/
    
    // DBB 1-20-2009 Change 2002 to 2003, and 2007 to 2008 in many places
    public StatisticalTableIF getTrend2006() {
        return trend2006;
    }

    /*public StatisticalTableIF getTrend2005() {
        return trend2005;
    }*/
    
    public StatisticalTableIF getTrend2011() {
        return trend2011;
    }

    /*public void setTrend2001(StatisticalTableIF bottomView) {
        this.trend2001 = bottomView;
    }*/
    
    public void setTrend2006(StatisticalTableIF bottomView) {
        this.trend2006 = bottomView;
    }

    /*public void setTrend2005(StatisticalTableIF topView) {
        this.trend2005 = topView;
    }*/
    
    public void setTrend2011(StatisticalTableIF topView) {
        this.trend2011 = topView;
    }
    
    public abstract String getTrendType();

    protected HSSFWorkbook buildWorkbook() throws Exception {
        
        List l = new ArrayList();

        // workbook = new HSSFWorkbook();

        ExcelSupport excelSupport = new ExcelSupportFactory().build();

        excelSupport.addNewSheet(this.getTrendType() + " Same Store Trend");

        // HSSFSheet sheet = workbook
        // .createSheet("MenuMine Chain Same Store Trend");

        HSSFRow headerRowTop = excelSupport.addRow(0);
        /*excelSupport.decorateRowWithCell(0, headerRowTop, this.getTrend2001()
                .getFieldEnum().getFriendlyName()
                + " MenuMine " + this.getTrendType() + " Same Store Trend");*/
        
        excelSupport.decorateRowWithCell(0, headerRowTop, this.getTrend2006()
                .getFieldEnum().getFriendlyName()
                + " MenuMine " + this.getTrendType() + " Same Store Trend");

        HSSFRow headerRow = excelSupport.addRow(1);
        /*excelSupport.decorateRowWithCell(0, headerRow, "2005");
        excelSupport.decorateRowWithCell(5, headerRow, "2001");*/
        
        excelSupport.decorateRowWithCell(0, headerRow, "2011");
        excelSupport.decorateRowWithCell(5, headerRow, "2006");

        HSSFRow headerRow2 = excelSupport.addRow(2);
        excelSupport.decorateRowWithCell(0, headerRow2, "Item");
        excelSupport.decorateRowWithCell(1, headerRow2, "Name");
        excelSupport.decorateRowWithCell(2, headerRow2, "Percent");
        excelSupport.decorateRowWithCell(3, headerRow2, "Number");

        excelSupport.decorateRowWithCell(5, headerRow2, "Item");
        excelSupport.decorateRowWithCell(6, headerRow2, "Name");
        excelSupport.decorateRowWithCell(7, headerRow2, "Percent");
        excelSupport.decorateRowWithCell(8, headerRow2, "Number");

        int j = 3;

        excelSupport.getSheet().setColumnWidth((short) 0, (short) 1000);
        excelSupport.getSheet().setColumnWidth((short) 1, (short) 5000);
        excelSupport.getSheet().setColumnWidth((short) 2, (short) 4100);
        excelSupport.getSheet().setColumnWidth((short) 3, (short) 3600);

        excelSupport.getSheet().setColumnWidth((short) 5, (short) 1000);
        excelSupport.getSheet().setColumnWidth((short) 6, (short) 5000);
        excelSupport.getSheet().setColumnWidth((short) 7, (short) 4100);
        excelSupport.getSheet().setColumnWidth((short) 8, (short) 3600);

        /*for (Iterator iter = this.getTrend2005().getRows().iterator(); iter
                .hasNext();) {
            StatisticalTableElementIF element = (StatisticalTableElementIF) iter
                    .next();

            HSSFRow row = excelSupport.addRow(j);
            l.add(row);
            excelSupport.decorateRowWithNumericCell(0, row, new Integer(j - 2));
            excelSupport.decorateRowWithCell(1, row, element.getName());
            excelSupport.decorateRowWithPercentageCell(2, row, element
                    .getPercent());
            excelSupport.decorateRowWithNumericCell(3, row, element.getCount());

            j++;
        }

        j = 3;*/
        
        for (Iterator iter = this.getTrend2011().getRows().iterator(); iter.hasNext();) {
        	StatisticalTableElementIF element = (StatisticalTableElementIF) iter.next();

        	HSSFRow row = excelSupport.addRow(j);
        	l.add(row);
        	excelSupport.decorateRowWithNumericCell(0, row, new Integer(j - 2));
        	excelSupport.decorateRowWithCell(1, row, element.getName());
        	excelSupport.decorateRowWithPercentageCell(2, row, element.getPercent());
        	excelSupport.decorateRowWithNumericCell(3, row, element.getCount());

        	j++;
        }

        j = 3;
        
        /*for (Iterator iter = this.getTrend2001().getRows().iterator(); iter
                .hasNext();) {
            StatisticalTableElementIF element = (StatisticalTableElementIF) iter
                    .next();

            HSSFRow row = null;
            
            if (l.size() > 0 && l.toArray().length >= j -2) {
                row = (HSSFRow) l.toArray()[j-3];
            } else {
                row = excelSupport.addRow(j);
            }
           
            excelSupport.decorateRowWithNumericCell(5, row, new Integer(j - 2));
            excelSupport.decorateRowWithCell(6, row, element.getName());
            excelSupport.decorateRowWithPercentageCell(7, row, element
                    .getPercent());
            excelSupport.decorateRowWithNumericCell(8, row, element.getCount());

            j++;
        }*/
        
        for (Iterator iter = this.getTrend2006().getRows().iterator(); iter.hasNext();) {
        	StatisticalTableElementIF element = (StatisticalTableElementIF) iter.next();

        	HSSFRow row = null;
    
        	if (l.size() > 0 && l.toArray().length >= j -2) {
        		row = (HSSFRow) l.toArray()[j-3];
        	} else {
        		row = excelSupport.addRow(j);
        	}
   
        	excelSupport.decorateRowWithNumericCell(5, row, new Integer(j - 2));
        	excelSupport.decorateRowWithCell(6, row, element.getName());
        	excelSupport.decorateRowWithPercentageCell(7, row, element.getPercent());
        	excelSupport.decorateRowWithNumericCell(8, row, element.getCount());

        	j++;
        }

        excelSupport.write(this.getMenuMineSessionContextWrapper().getAuthenticatedUser().getUsername());
        
        return excelSupport.getWorkbook();
    }
}
