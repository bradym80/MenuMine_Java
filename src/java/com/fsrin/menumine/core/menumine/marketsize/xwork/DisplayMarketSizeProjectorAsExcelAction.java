/*
 * Created on Jul 25, 2006
 *
 */
package com.fsrin.menumine.core.menumine.marketsize.xwork;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.fsrin.menumine.core.menumine.marketsize.MarketSizeIncidenceSector;
import com.fsrin.menumine.core.menumine.marketsize.MarketSizeIncidenceSegment;
import com.fsrin.menumine.core.menumine.marketsize.MarketSizeIncidenceTotals;
import com.fsrin.menumine.core.menumine.util.ExcelSupport;
import com.fsrin.menumine.core.menumine.util.ExcelSupportFactory;
import com.opensymphony.xwork.Action;

public class DisplayMarketSizeProjectorAsExcelAction extends
        AbstractMarketSizeAction {

    

    private HSSFWorkbook workbook;

    public String execute() throws Exception {

        this.handleCreateSpreadsheet();

        return Action.SUCCESS;

    }

    private void handleCreateSpreadsheet() throws Exception {

        ExcelSupport excelSupport = new ExcelSupportFactory().build();

        HSSFRow header = excelSupport.addRow();

        excelSupport.decorateRowWithHeadlineCell(0, header, "Market Size Projector");

        header = excelSupport.addRow();
        excelSupport.decorateRowWithCell(0, header, "Copyright (c) Food Service Research Institute, Inc.");
        
        header = excelSupport.addRow();

        excelSupport.decorateRowWithCell(0, header, "Basic forumla: (Category Incidence / 100) * Units in Universe * Servings Per Day * Ounces Per Serving * Menu Cycle * Conversion Constant = Projected Market Size");

        excelSupport.addRow();

        HSSFRow fields = excelSupport.addRow();
        
        Collection subtotalFields = new ArrayList();
        
        Collection rowsToDecorateWithCalculatedShare = new ArrayList();
        

        excelSupport.decorateRowWithCell(0, fields, "Sector/Segment");
        excelSupport.decorateRowWithCell(1, fields, "Operator Count");
        excelSupport.decorateRowWithCell(2, fields, "Operator Menuing Item");
        excelSupport.decorateRowWithCell(3, fields, "Category Incidence");
        excelSupport.decorateRowWithCell(4, fields, "Units in Universe");
        excelSupport.decorateRowWithCell(5, fields, "Servings per Day");
        excelSupport.decorateRowWithCell(6, fields, "Ounces per Serving");
        excelSupport.decorateRowWithCell(7, fields, "Menu Cycle");
        excelSupport.decorateRowWithCell(8, fields, "Conversion Constant");
        excelSupport.decorateRowWithCell(9, fields, "Projected Market (" + this.getMarketSizeProjectorContext().getMarketSizeOptions().getResultLabel() + ") (orig)");
        excelSupport.decorateRowWithCell(10, fields, "Volume Share (orig)");
        excelSupport.decorateRowWithCell(11, fields, "Projected Market (" + this.getMarketSizeProjectorContext().getMarketSizeOptions().getResultLabel() + ") (calc)");
        excelSupport.decorateRowWithCell(12, fields, "Volume Share (calc)");

        for (Iterator iter = this.getMarketSizeProjectorContext()
                .getMarketSizeIncidenceTable().getIncidenceSectors().iterator(); iter
                .hasNext();) {
            MarketSizeIncidenceSector sectorElement = (MarketSizeIncidenceSector) iter
                    .next();

            int sumRangeStart = 0;
            int sumRangeStop = 0;
            for (Iterator iterator = sectorElement.getIncidenceSegments()
                    .iterator(); iterator.hasNext();) {
                MarketSizeIncidenceSegment segmentElement = (MarketSizeIncidenceSegment) iterator
                        .next();

                HSSFRow segmentData = excelSupport.addRow();

                if (sumRangeStart == 0) {
                    sumRangeStart = segmentData.getRowNum() + 1;
                }
                sumRangeStop = segmentData.getRowNum() + 1;
                
                excelSupport.decorateRowWithCell(0, segmentData, segmentElement
                        .getName());
                excelSupport.decorateRowWithNumericCell(1, segmentData,
                        segmentElement.getNumberOfChains());
                excelSupport.decorateRowWithNumericCell(2, segmentData,
                        segmentElement.getNumberOfChainsMenuingItems());
                excelSupport.decorateRowWithPercentageCell(3, segmentData,
                        segmentElement.getCategoryIncidence());
                excelSupport.decorateRowWithNumericCell(4, segmentData,
                        segmentElement.getUnitsInUniverse());
                excelSupport.decorateRowWithNumericCell(5, segmentData,
                        segmentElement.getServingsPerDay());
                excelSupport.decorateRowWithNumericCell(6, segmentData,
                        segmentElement.getOuncesPerServing());
                excelSupport.decorateRowWithNumericCell(7, segmentData,
                        segmentElement.getMenuCycle());
                excelSupport.decorateRowWithDecimalCell(8, segmentData,
                        segmentElement.getConversionConstant());
                excelSupport.decorateRowWithNumericCell(9, segmentData,
                        segmentElement.getProjectedMarketSize());
                excelSupport.decorateRowWithPercentageCell(10, segmentData,
                        segmentElement.getOverallShare() * 100.0);
                
                //replaced with formula
                excelSupport.decorateRowWithNumericCell(9, segmentData,
                        segmentElement.getProjectedMarketSize());
                excelSupport.decorateRowWithPercentageCell(10, segmentData,
                        segmentElement.getOverallShare() * 100.0);

                HSSFCell f = excelSupport.getCell(11,segmentData);
                f.setCellStyle(excelSupport.numericCellStyle);
                String rowId = "" + (segmentData.getRowNum() +1);
                f.setCellFormula("(d" + rowId + " / 100) * e" + rowId + " * f" + rowId + " * g" + rowId + " * h" + rowId + " * i" + rowId + " ");

                f = excelSupport.getCell(12,segmentData);
                f.setCellStyle(excelSupport.percentageCellStyle);
                rowId = "" + (segmentData.getRowNum() +1);
                f.setCellFormula("(d" + rowId + " / 100) * e" + rowId + " * f" + rowId + " * g" + rowId + " * h" + rowId + " * i" + rowId + " ");
            
                rowsToDecorateWithCalculatedShare.add(new Integer(segmentData.getRowNum()));
            }

            HSSFRow sectorData = excelSupport.addRow();

            excelSupport.decorateRowWithCell(0, sectorData, sectorElement
                    .getName());
            excelSupport.decorateRowWithNumericCell(1, sectorData,
                    sectorElement.getNumberOfChains());
            excelSupport.decorateRowWithNumericCell(2, sectorData,
                    sectorElement.getNumberOfChainsMenuingItems());
            excelSupport.decorateRowWithPercentageCell(3, sectorData,
                    sectorElement.getCategoryIncidence());
// replaced with formula            
            excelSupport.decorateRowWithNumericCell(9, sectorData,
                    sectorElement.getProjectedMarketSize());

            HSSFCell f = excelSupport.getCell(11,sectorData);
            f.setCellStyle(excelSupport.numericCellStyle);
            
            f.setCellFormula("sum(l" + sumRangeStart + ":l" + sumRangeStop + ")");

            subtotalFields.add("L" + (sectorData.getRowNum()+1));
            
            excelSupport.decorateRowWithPercentageCell(10, sectorData,
                    sectorElement.getOverallShare() * 100.0);
            
            rowsToDecorateWithCalculatedShare.add(new Integer(sectorData.getRowNum()));

        }

        HSSFRow totals = excelSupport.addRow();

        MarketSizeIncidenceTotals totals2 = this
                .getMarketSizeProjectorContext().getMarketSizeIncidenceTable()
                .getMarketSizeTotals();

        excelSupport.decorateRowWithNumericCell(2, totals, totals2
                .getNumberOfChainsMenuingItems());
        excelSupport.decorateRowWithPercentageCell(3, totals, totals2
                .getCategoryIncidence() * 100.0);
        excelSupport.decorateRowWithNumericCell(9, totals, totals2
                .getProjectedMarketSize());
        excelSupport.decorateRowWithCell(10, totals, "(" + this.getMarketSizeProjectorContext().getMarketSizeOptions().getResultLabel() + ")");

        StringBuffer calculatedTotalFormula = new StringBuffer();
        
        for (Iterator iter = subtotalFields.iterator(); iter.hasNext();) {
            String element = (String) iter.next();
            if (calculatedTotalFormula.length() > 0) {
                calculatedTotalFormula.append(" + ");
            }
            calculatedTotalFormula.append(element);
        }
        
        HSSFCell f = excelSupport.getCell(11,totals);
        f.setCellStyle(excelSupport.numericCellStyle);
        
        f.setCellFormula(calculatedTotalFormula.toString());
        
        String totalCalculatedFieldId = "$L$" + (totals.getRowNum() + 1); 
        
        /*
         * set some extra widths
         */
        excelSupport.getSheet().setColumnWidth((short)0,(short)7500);
        excelSupport.getSheet().setColumnWidth((short)9,(short)5000);
        excelSupport.getSheet().setColumnWidth((short)11,(short)5000);
        
        /*
         * decorate with calculated overall share
         */
        for (Iterator iter = rowsToDecorateWithCalculatedShare.iterator(); iter
                .hasNext();) {
            Integer element = (Integer) iter.next();
            
            HSSFRow rowToDecorate = excelSupport.getSheet().getRow(element.intValue());
            
            HSSFCell rowShare = excelSupport.getCell(12,rowToDecorate);
            rowShare.setCellStyle(excelSupport.percentageCellStyle);
            rowShare.setCellFormula("L" + (element.intValue() + 1) + " / " + totalCalculatedFieldId + " * 100.0" );
            
            
        }
        
        excelSupport.write(this.getMenuMineSessionContextWrapper().getAuthenticatedUser().getUsername());
        
        this.setWorkbook(excelSupport.getWorkbook());
    }

    /**
     * @return Returns the workbook.
     */
    public HSSFWorkbook getWorkbook() {
        return workbook;
    }

    /**
     * @param workbook
     *            The workbook to set.
     */
    public void setWorkbook(HSSFWorkbook workbook) {
        this.workbook = workbook;
    }

}
