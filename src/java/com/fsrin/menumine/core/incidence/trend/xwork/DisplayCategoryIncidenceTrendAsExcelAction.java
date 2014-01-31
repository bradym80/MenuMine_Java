/*
 * Created on Sep 14, 2006 by Reid
 */
package com.fsrin.menumine.core.incidence.trend.xwork;

import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.fsrin.menumine.core.incidence.trend.IncidenceTableTrend;
import com.fsrin.menumine.core.incidence.trend.IncidenceTrendItem;
import com.fsrin.menumine.core.incidence.trend.IncidenceTrendItemHeader;
import com.fsrin.menumine.core.menumine.util.ExcelSupport;
import com.fsrin.menumine.core.menumine.util.ExcelSupportFactory;
import com.opensymphony.xwork.Action;

public class DisplayCategoryIncidenceTrendAsExcelAction extends
        AbstractIncidenceTrendAction {

    private HSSFWorkbook workbook;

    public String execute() throws Exception {

        if (this.getIncidenceTrendContext().getIncidenceTableTrend() != null)
            this.handleCreateSpreadsheet();

        return Action.SUCCESS;
    }

    private void handleCreateSpreadsheet() throws Exception {

        IncidenceTableTrend trendTable = this.getIncidenceTrendContext()
                .getIncidenceTableTrend();

        ExcelSupport excelSupport = new ExcelSupportFactory().build();

        HSSFRow header = excelSupport.addRow();

        excelSupport.decorateRowWithHeadlineCell(0, header,
                "Category Incidence Trend");

        header = excelSupport.addRow();
        excelSupport.decorateRowWithCell(0, header,
                "Copyright (c) Food Service Research Institute, Inc.");

        excelSupport.addRow();

        HSSFRow years = excelSupport.addRow();
        //JDL 10-5-07
        excelSupport.decorateRowWithCell(0, years, "");
        excelSupport.decorateRowWithCell(1, years, "2011");
        excelSupport.decorateRowWithCell(2, years, "2010");
        excelSupport.decorateRowWithCell(3, years, "2009");
        excelSupport.decorateRowWithCell(4, years, "2008");
        excelSupport.decorateRowWithCell(5, years, "2007");
        excelSupport.decorateRowWithCell(6, years, "2006");
        excelSupport.decorateRowWithCell(7, years, "2005");
        excelSupport.decorateRowWithCell(8, years, "2004");
        excelSupport.decorateRowWithCell(9, years, "2003");
        excelSupport.decorateRowWithCell(10, years, "2002");
        excelSupport.decorateRowWithCell(11, years, "2001");
        excelSupport.decorateRowWithCell(12, years, "2000");
        excelSupport.decorateRowWithCell(13, years, "1999");
        excelSupport.decorateRowWithCell(14, years, "1998");
        excelSupport.decorateRowWithCell(15, years, "1997");
        excelSupport.decorateRowWithCell(16, years, "1996");
        HSSFRow recordCount = excelSupport.addRow();

        excelSupport.decorateRowWithCell(0, recordCount, "# Records");
        excelSupport.decorateRowWithCell(1, recordCount, trendTable
                .getTrendTotals().getTotal2011().getRecordCount());
        excelSupport.decorateRowWithCell(2, recordCount, trendTable
                .getTrendTotals().getTotal2010().getRecordCount());
        excelSupport.decorateRowWithCell(3, recordCount, trendTable
                .getTrendTotals().getTotal2009().getRecordCount());
        excelSupport.decorateRowWithCell(4, recordCount, trendTable
                .getTrendTotals().getTotal2008().getRecordCount());
        excelSupport.decorateRowWithCell(5, recordCount, trendTable
                .getTrendTotals().getTotal2007().getRecordCount());
        excelSupport.decorateRowWithCell(6, recordCount, trendTable
                .getTrendTotals().getTotal2006().getRecordCount());
        excelSupport.decorateRowWithCell(7, recordCount, trendTable
                .getTrendTotals().getTotal2005().getRecordCount());
        excelSupport.decorateRowWithCell(8, recordCount, trendTable
                .getTrendTotals().getTotal2004().getRecordCount());
        excelSupport.decorateRowWithCell(9, recordCount, trendTable
                .getTrendTotals().getTotal2003().getRecordCount());
        excelSupport.decorateRowWithCell(10, recordCount, trendTable
                .getTrendTotals().getTotal2002().getRecordCount());
        excelSupport.decorateRowWithCell(11, recordCount, trendTable
                .getTrendTotals().getTotal2001().getRecordCount());        
        excelSupport.decorateRowWithCell(12, recordCount, trendTable
                .getTrendTotals().getTotal2000().getRecordCount());
        excelSupport.decorateRowWithCell(13, recordCount, trendTable
                .getTrendTotals().getTotal1999().getRecordCount());
        excelSupport.decorateRowWithCell(14, recordCount, trendTable
                .getTrendTotals().getTotal1998().getRecordCount());
        excelSupport.decorateRowWithCell(15, recordCount, trendTable
                .getTrendTotals().getTotal1997().getRecordCount());
        excelSupport.decorateRowWithCell(16, recordCount, trendTable
                .getTrendTotals().getTotal1996().getRecordCount());

        HSSFRow operatorCount = excelSupport.addRow();

        excelSupport.decorateRowWithCell(0, operatorCount, "# Operators");
        excelSupport.decorateRowWithCell(1, operatorCount, trendTable
                .getTrendTotals().getTotal2011().getNumberOfChainsInSector());
        excelSupport.decorateRowWithCell(2, operatorCount, trendTable
                .getTrendTotals().getTotal2010().getNumberOfChainsInSector());
        excelSupport.decorateRowWithCell(3, operatorCount, trendTable
                .getTrendTotals().getTotal2009().getNumberOfChainsInSector());
        excelSupport.decorateRowWithCell(4, operatorCount, trendTable
                .getTrendTotals().getTotal2008().getNumberOfChainsInSector());
        excelSupport.decorateRowWithCell(5, operatorCount, trendTable
                .getTrendTotals().getTotal2007().getNumberOfChainsInSector());
        excelSupport.decorateRowWithCell(6, operatorCount, trendTable
                .getTrendTotals().getTotal2006().getNumberOfChainsInSector());
        excelSupport.decorateRowWithCell(7, operatorCount, trendTable
                .getTrendTotals().getTotal2005().getNumberOfChainsInSector());
        excelSupport.decorateRowWithCell(8, operatorCount, trendTable
                .getTrendTotals().getTotal2004().getNumberOfChainsInSector());
        excelSupport.decorateRowWithCell(9, operatorCount, trendTable
                .getTrendTotals().getTotal2003().getNumberOfChainsInSector());
        excelSupport.decorateRowWithCell(10, operatorCount, trendTable
                .getTrendTotals().getTotal2002().getNumberOfChainsInSector());
        excelSupport.decorateRowWithCell(11, operatorCount, trendTable
                .getTrendTotals().getTotal2001().getNumberOfChainsInSector());
        excelSupport.decorateRowWithCell(12, operatorCount, trendTable
                .getTrendTotals().getTotal2000().getNumberOfChainsInSector());
        excelSupport.decorateRowWithCell(13, operatorCount, trendTable
                .getTrendTotals().getTotal1999().getNumberOfChainsInSector());
        excelSupport.decorateRowWithCell(14, operatorCount, trendTable
                .getTrendTotals().getTotal1998().getNumberOfChainsInSector());
        excelSupport.decorateRowWithCell(15, operatorCount, trendTable
                .getTrendTotals().getTotal1997().getNumberOfChainsInSector());
        excelSupport.decorateRowWithCell(16, operatorCount, trendTable
                .getTrendTotals().getTotal1996().getNumberOfChainsInSector());
        
        HSSFRow menuingItem = excelSupport.addRow();

        excelSupport.decorateRowWithCell(0, menuingItem, "# Menuing Item");
        excelSupport.decorateRowWithCell(1, menuingItem, trendTable
                .getTrendTotals().getTotal2011()
                .getNumberOfChainsMenuingItems());
        excelSupport.decorateRowWithCell(2, menuingItem, trendTable
                .getTrendTotals().getTotal2010()
                .getNumberOfChainsMenuingItems());
        excelSupport.decorateRowWithCell(3, menuingItem, trendTable
                .getTrendTotals().getTotal2009()
                .getNumberOfChainsMenuingItems());
        excelSupport.decorateRowWithCell(4, menuingItem, trendTable
                .getTrendTotals().getTotal2008()
                .getNumberOfChainsMenuingItems());
        excelSupport.decorateRowWithCell(5, menuingItem, trendTable
                .getTrendTotals().getTotal2007()
                .getNumberOfChainsMenuingItems());
        excelSupport.decorateRowWithCell(6, menuingItem, trendTable
                .getTrendTotals().getTotal2006()
                .getNumberOfChainsMenuingItems());
        excelSupport.decorateRowWithCell(7, menuingItem, trendTable
                .getTrendTotals().getTotal2005()
                .getNumberOfChainsMenuingItems());
        excelSupport.decorateRowWithCell(8, menuingItem, trendTable
                .getTrendTotals().getTotal2004()
                .getNumberOfChainsMenuingItems());
        excelSupport.decorateRowWithCell(9, menuingItem, trendTable
                .getTrendTotals().getTotal2003()
                .getNumberOfChainsMenuingItems());
        excelSupport.decorateRowWithCell(10, menuingItem, trendTable
                .getTrendTotals().getTotal2002()
                .getNumberOfChainsMenuingItems());
        excelSupport.decorateRowWithCell(11, menuingItem, trendTable
                .getTrendTotals().getTotal2001()
                .getNumberOfChainsMenuingItems());
        excelSupport.decorateRowWithCell(12, menuingItem, trendTable
                .getTrendTotals().getTotal2000()
                .getNumberOfChainsMenuingItems());
        excelSupport.decorateRowWithCell(13, menuingItem, trendTable
                .getTrendTotals().getTotal1999()
                .getNumberOfChainsMenuingItems());
        excelSupport.decorateRowWithCell(14, menuingItem, trendTable
                .getTrendTotals().getTotal1998()
                .getNumberOfChainsMenuingItems());
        excelSupport.decorateRowWithCell(15, menuingItem, trendTable
                .getTrendTotals().getTotal1997()
                .getNumberOfChainsMenuingItems());
        excelSupport.decorateRowWithCell(16, menuingItem, trendTable
                .getTrendTotals().getTotal1996()
                .getNumberOfChainsMenuingItems());

        HSSFRow operatorIncidence = excelSupport.addRow();

        excelSupport.decorateRowWithCellGrey(0, operatorIncidence,
                "Operator Incidence");
        excelSupport.decorateRowWithPercentageCellGrey(1, operatorIncidence,
                trendTable.getTrendTotals().getTotal2011()
                        .getCategoryIncidence() * 100.0);
        excelSupport.decorateRowWithPercentageCellGrey(2, operatorIncidence,
                trendTable.getTrendTotals().getTotal2010()
                        .getCategoryIncidence() * 100.0);
        excelSupport.decorateRowWithPercentageCellGrey(3, operatorIncidence,
                trendTable.getTrendTotals().getTotal2009()
                        .getCategoryIncidence() * 100.0);
        excelSupport.decorateRowWithPercentageCellGrey(4, operatorIncidence,
                trendTable.getTrendTotals().getTotal2008()
                        .getCategoryIncidence() * 100.0);
        excelSupport.decorateRowWithPercentageCellGrey(5, operatorIncidence,
                trendTable.getTrendTotals().getTotal2007()
                        .getCategoryIncidence() * 100.0);
        excelSupport.decorateRowWithPercentageCellGrey(6, operatorIncidence,
                trendTable.getTrendTotals().getTotal2006()
                        .getCategoryIncidence() * 100.0);
        excelSupport.decorateRowWithPercentageCellGrey(7, operatorIncidence,
                trendTable.getTrendTotals().getTotal2005()
                        .getCategoryIncidence() * 100.0);
        excelSupport.decorateRowWithPercentageCellGrey(8, operatorIncidence,
                trendTable.getTrendTotals().getTotal2004()
                        .getCategoryIncidence() * 100.0);
        excelSupport.decorateRowWithPercentageCellGrey(9, operatorIncidence,
                trendTable.getTrendTotals().getTotal2003()
                        .getCategoryIncidence() * 100.0);
        excelSupport.decorateRowWithPercentageCellGrey(10, operatorIncidence,
                trendTable.getTrendTotals().getTotal2002()
                        .getCategoryIncidence() * 100.0);
        excelSupport.decorateRowWithPercentageCellGrey(11, operatorIncidence,
                trendTable.getTrendTotals().getTotal2001()
                        .getCategoryIncidence() * 100.0);
        excelSupport.decorateRowWithPercentageCellGrey(12, operatorIncidence,
                trendTable.getTrendTotals().getTotal2000()
                        .getCategoryIncidence() * 100.0);
        excelSupport.decorateRowWithPercentageCellGrey(13, operatorIncidence,
                trendTable.getTrendTotals().getTotal1999()      
                        .getCategoryIncidence() * 100.0);
        excelSupport.decorateRowWithPercentageCellGrey(14, operatorIncidence,
                trendTable.getTrendTotals().getTotal1998()
                        .getCategoryIncidence() * 100.0);
        excelSupport.decorateRowWithPercentageCellGrey(15, operatorIncidence,
                trendTable.getTrendTotals().getTotal1997()
                        .getCategoryIncidence() * 100.0);
        excelSupport.decorateRowWithPercentageCellGrey(16, operatorIncidence,
                trendTable.getTrendTotals().getTotal1996()
                        .getCategoryIncidence() * 100.0);
        
        for (Iterator iter = trendTable.getSortedTrendHeaders().iterator(); iter
                .hasNext();) {
            IncidenceTrendItemHeader itemHeader = (IncidenceTrendItemHeader) iter
                    .next();

            for (Iterator iterator = itemHeader.getSortedTrendItems()
                    .iterator(); iterator.hasNext();) {
                IncidenceTrendItem trendItem = (IncidenceTrendItem) iterator
                        .next();

                HSSFRow trendItemRow = excelSupport.addRow();

                excelSupport.decorateRowWithCell(0, trendItemRow, trendItem
                        .getName());
                if (trendItem.getIncidence2011() > 0.0)
                    excelSupport.decorateRowWithNumericCell(1, trendItemRow,
                            trendItem.getIncidence2011());
                if (trendItem.getIncidence2010() > 0.0)
                    excelSupport.decorateRowWithNumericCell(2, trendItemRow,
                            trendItem.getIncidence2010());
                if (trendItem.getIncidence2009() > 0.0)
                    excelSupport.decorateRowWithNumericCell(3, trendItemRow,
                            trendItem.getIncidence2009());
                if (trendItem.getIncidence2008() > 0.0)
                    excelSupport.decorateRowWithNumericCell(4, trendItemRow,
                            trendItem.getIncidence2008());
                if (trendItem.getIncidence2007() > 0.0)
                    excelSupport.decorateRowWithNumericCell(5, trendItemRow,
                            trendItem.getIncidence2007());
                if (trendItem.getIncidence2006() > 0.0)
                    excelSupport.decorateRowWithNumericCell(6, trendItemRow,
                            trendItem.getIncidence2006());
                if (trendItem.getIncidence2005() > 0.0)
                    excelSupport.decorateRowWithNumericCell(7, trendItemRow,
                            trendItem.getIncidence2005());
                if (trendItem.getIncidence2004() > 0.0)
                    excelSupport.decorateRowWithNumericCell(8, trendItemRow,
                            trendItem.getIncidence2004());
                if (trendItem.getIncidence2003() > 0.0)
                    excelSupport.decorateRowWithNumericCell(9, trendItemRow,
                            trendItem.getIncidence2003());
                if (trendItem.getIncidence2002() > 0.0)
                    excelSupport.decorateRowWithNumericCell(10, trendItemRow,
                            trendItem.getIncidence2002());
                if (trendItem.getIncidence2001() > 0.0)
                    excelSupport.decorateRowWithNumericCell(11, trendItemRow,
                            trendItem.getIncidence2001());
                if (trendItem.getIncidence2000() > 0.0)
                    excelSupport.decorateRowWithNumericCell(12, trendItemRow,
                            trendItem.getIncidence2000());
                if (trendItem.getIncidence1999() > 0.0)
                    excelSupport.decorateRowWithNumericCell(13, trendItemRow,
                            trendItem.getIncidence1999());
                if (trendItem.getIncidence1998() > 0.0)
                    excelSupport.decorateRowWithNumericCell(14, trendItemRow,
                            trendItem.getIncidence1998());
                if (trendItem.getIncidence1997() > 0.0)
                    excelSupport.decorateRowWithNumericCell(15, trendItemRow,
                            trendItem.getIncidence1997());
                if (trendItem.getIncidence1996() > 0.0)
                    excelSupport.decorateRowWithNumericCell(16, trendItemRow,
                            trendItem.getIncidence1996());

            }

            HSSFRow headerItemRow = excelSupport.addRow();

            excelSupport.decorateRowWithCellGrey(0, headerItemRow, itemHeader
                    .getName());
            excelSupport.decorateRowWithNumericCellGrey(1, headerItemRow,
                    itemHeader.getIncidence2011());
            excelSupport.decorateRowWithNumericCellGrey(2, headerItemRow,
                    itemHeader.getIncidence2010());
            excelSupport.decorateRowWithNumericCellGrey(3, headerItemRow,
                    itemHeader.getIncidence2009());
            excelSupport.decorateRowWithNumericCellGrey(4, headerItemRow,
                    itemHeader.getIncidence2008());
            excelSupport.decorateRowWithNumericCellGrey(5, headerItemRow,
                    itemHeader.getIncidence2007());
            excelSupport.decorateRowWithNumericCellGrey(6, headerItemRow,
                    itemHeader.getIncidence2006());
            excelSupport.decorateRowWithNumericCellGrey(7, headerItemRow,
                    itemHeader.getIncidence2005());
            excelSupport.decorateRowWithNumericCellGrey(8, headerItemRow,
                    itemHeader.getIncidence2004());
            excelSupport.decorateRowWithNumericCellGrey(9, headerItemRow,
                    itemHeader.getIncidence2003());
            excelSupport.decorateRowWithNumericCellGrey(10, headerItemRow,
                    itemHeader.getIncidence2002());
            excelSupport.decorateRowWithNumericCellGrey(11, headerItemRow,
                    itemHeader.getIncidence2001());
            excelSupport.decorateRowWithNumericCellGrey(12, headerItemRow,
                    itemHeader.getIncidence2000());
            excelSupport.decorateRowWithNumericCellGrey(13, headerItemRow,
                    itemHeader.getIncidence1999());
            excelSupport.decorateRowWithNumericCellGrey(14, headerItemRow,
                    itemHeader.getIncidence1998());
            excelSupport.decorateRowWithNumericCellGrey(15, headerItemRow,
                    itemHeader.getIncidence1997());
            excelSupport.decorateRowWithNumericCellGrey(16, headerItemRow,
                    itemHeader.getIncidence1996());

        }

        excelSupport.setColumnWidth(0, 10000);
        excelSupport.setColumnWidth(1, 3000);
        excelSupport.setColumnWidth(2, 3000);
        excelSupport.setColumnWidth(3, 3000);
        excelSupport.setColumnWidth(4, 3000);
        excelSupport.setColumnWidth(5, 3000);
        excelSupport.setColumnWidth(6, 3000);
        excelSupport.setColumnWidth(7, 3000);
        excelSupport.setColumnWidth(8, 3000);
        excelSupport.setColumnWidth(9, 3000);
        excelSupport.setColumnWidth(10, 3000);
        excelSupport.setColumnWidth(11, 3000);
        excelSupport.setColumnWidth(12, 3000);
        excelSupport.setColumnWidth(13, 3000);
        excelSupport.setColumnWidth(14, 3000);
        excelSupport.setColumnWidth(15, 3000);
        excelSupport.setColumnWidth(16, 3000);

        excelSupport.write(this.getMenuMineSessionContextWrapper()
                .getAuthenticatedUser().getUsername());

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
