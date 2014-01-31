/*
 * Created on Jan 20, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.webwork;

import java.util.Collection;
import java.util.Iterator;

import ognl.OgnlException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.fsrin.menumine.core.menumine.FieldEnum;
import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableBuilder;
import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableIF;
import com.fsrin.menumine.core.menumine.util.ExcelSupport;
import com.fsrin.menumine.core.menumine.util.ExcelSupportFactory;
import com.fsrin.menumine.core.menumine.webwork.util.MenuMineResultsDisplayWrapper;
import com.fsrin.menumine.core.menumine.webwork.util.MenuMineResultsDisplayWrapperBuilder;
import com.fsrin.menumine.core.menumine.webwork.util.MenuMineResultsDisplayWrapperHeader;
import com.opensymphony.xwork.Action;

/**
 * 2006-03-10 RSC Refactored to use ExcelSupport.
 * 
 * @author Nick
 * 
 * 
 */
public class ViewExcelAction extends AbstractMenuMineDisplayAction {

    private HSSFWorkbook workbook = null;
    
    private String excelPath;

    public String execute() throws Exception {

        Collection results = this.getWrappedResults();
        
        if (results == null) {
            this.getMenuMineSessionContextWrapper().getErrorContext().addError("Unable to generate results -- export to spreadsheet aborted.");
            return Action.INPUT;
        }

        ExcelSupport excelSupport = new ExcelSupportFactory().build();

        excelSupport.addNewSheet("MenuMine");

        MenuMineResultsDisplayWrapperHeader header = getResultHeader();

        HSSFRow headerRow = excelSupport.addRow(0);

        this.decorateHeader(excelSupport, headerRow, 0, header.getValue1());
        this.decorateHeader(excelSupport, headerRow, 1, header.getValue2());
        this.decorateHeader(excelSupport, headerRow, 2, header.getValue3());
        this.decorateHeader(excelSupport, headerRow, 3, header.getValue4());
        this.decorateHeader(excelSupport, headerRow, 4, header.getValue5());
        this.decorateHeader(excelSupport, headerRow, 5, header.getValue6());
        this.decorateHeader(excelSupport, headerRow, 6, header.getValue7());
        this.decorateHeader(excelSupport, headerRow, 7, header.getValue8());
        this.decorateHeader(excelSupport, headerRow, 8, header.getValue9());
        this.decorateHeader(excelSupport, headerRow, 9, header.getValue10());
        this.decorateHeader(excelSupport, headerRow, 10, header.getValue11());
        this.decorateHeader(excelSupport, headerRow, 11, header.getValue12());
        this.decorateHeader(excelSupport, headerRow, 12, header.getValue13());
        this.decorateHeader(excelSupport, headerRow, 13, header.getValue14());
        this.decorateHeader(excelSupport, headerRow, 14, header.getValue15());
        

        int j = 1;

        for (Iterator iter = results.iterator(); iter.hasNext();) {
            MenuMineResultsDisplayWrapper element = (MenuMineResultsDisplayWrapper) iter
                    .next();

            HSSFRow row = excelSupport.addRow(j);

            excelSupport.decorateRowWithCell((short) 0, row, element
                    .getValue1Clean());
            excelSupport.decorateRowWithCell((short) 1, row, element
                    .getValue2Clean());
            excelSupport.decorateRowWithCell((short) 2, row, element
                    .getValue3Clean());
            excelSupport.decorateRowWithCell((short) 3, row, element
                    .getValue4Clean());
            excelSupport.decorateRowWithCell((short) 4, row, element
                    .getValue5Clean());
            excelSupport.decorateRowWithCell((short) 5, row, element
                    .getValue6Clean());
            excelSupport.decorateRowWithCell((short) 6, row, element
                    .getValue7Clean());
            excelSupport.decorateRowWithCell((short) 7, row, element
                    .getValue8Clean());
            excelSupport.decorateRowWithCell((short) 8, row, element
                    .getValue9Clean());
            excelSupport.decorateRowWithCell((short) 9, row, element
                    .getValue10Clean());       
            excelSupport.decorateRowWithCell((short) 10, row, element
                    .getValue11Clean());
            excelSupport.decorateRowWithCell((short) 11, row, element
                    .getValue12Clean());  
            excelSupport.decorateRowWithCell((short) 12, row, element
                    .getValue13Clean());  
            excelSupport.decorateRowWithCell((short) 13, row, element
                    .getValue14Clean());  
            excelSupport.decorateRowWithCell((short) 14, row, element
                    .getValue15Clean());  
            j++;
        }

        workbook = excelSupport.getWorkbook();

        excelSupport.write(this.getMenuMineSessionContextWrapper().getAuthenticatedUser().getUsername());
        
        return Action.SUCCESS;
    }

    private void decorateHeader(ExcelSupport excelSupport, HSSFRow row,
            int cellId, FieldEnum fieldEnum) {
        if (fieldEnum != null) {
            excelSupport.decorateRowWithCell(cellId, row, fieldEnum
                    .getFriendlyName());
        }
    }

    public MenuMineResultsDisplayWrapperHeader getResultHeader() {
        return MenuMineResultsDisplayWrapperBuilder.singleton.buildHeader(this
                .getMenuMineSessionContextWrapper().getLastFieldsToDisplay(),
                this.getMenuMineSessionContextWrapper().getMineFields());
    }

    public Collection getWrappedResults() {

        if (this.getResults() == null) {
            this.getMenuMineSessionContextWrapper().getErrorContext().addError(
                    "Unable to display current spreadsheet. (Results is null)");
            return null;
        }

        return MenuMineResultsDisplayWrapperBuilder.singleton.buildCollection(
                this.getResults(), this.getMenuMineSessionContextWrapper()
                        .getLastFieldsToDisplay(), this
                        .getMenuMineSessionContextWrapper().getMineFields());
    }

    public StatisticalTableIF getStatisticalTableResults() {

        if (this.getResults() == null) {
            return null;
        }
        try {
            return new StatisticalTableBuilder()
                    .buildStatisticalTableFromCollection_WithoutAggregation(
                            this.getResults(), this
                                    .getMenuMineSessionContextWrapper()
                                    .getLastGraphOptions(), this
                                    .getMenuMineSessionContextWrapper()
                                    .getRollUpOptions());
        } catch (OgnlException e) {

            e.printStackTrace();
            return null;
        }
    }

    public HSSFWorkbook getWorkbook() {
        return workbook;
    }

    public String getExcelPath() {
        return excelPath;
    }

    public void setExcelPath(String excelPath) {
        this.excelPath = excelPath;
    }
}