/*
 * Created on Jul 12, 2005
 *
 * 
 */
package com.fsrin.menumine.core.chainmap.xwork;

import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;

import com.fsrin.menumine.common.webwork.MenuMineExcelAction;
import com.fsrin.menumine.core.chainmap.ChainMapTable;
import com.fsrin.menumine.core.chainmap.ChainMapTableLineItem;

/**
 * @author Nick
 * 
 *  
 */
public class ChainMapExcelAction extends MenuMineExcelAction implements
        ChainMapContextAware {

    private ChainMapContext chainMapContext;

    public String execute() throws Exception {

        ChainMapTable chainMapTable = (ChainMapTable) this
                .getDataSource("chainMapTable");

        HSSFSheet regionSheet = this.getSheet("Regional Breakdown");
        this.buildRegionSheet(regionSheet, chainMapTable);

        HSSFSheet stateSheet = this.getSheet("State Breakdown");
        this.buildStateSheet(stateSheet, chainMapTable);

        return super.execute();
    }

    private void buildStateSheet(HSSFSheet stateSheet,
            ChainMapTable chainMapTable) {
        this.resetRowCount();

        stateSheet.setColumnWidth((short) 0, (short) 3600);
        stateSheet.setColumnWidth((short) 1, (short) 3600);
        stateSheet.setColumnWidth((short) 2, (short) 3600);
        stateSheet.setColumnWidth((short) 3, (short) 3600);
        stateSheet.setColumnWidth((short) 4, (short) 3600);

        HSSFCellStyle style = this.getWorkbook().createCellStyle();
        style.setDataFormat((short) 4);

        HSSFRow titlerow = this.newRow(stateSheet);
        titlerow.createCell((short) 2)
                .setCellValue("Chain Map State Breakdown");

        HSSFRow chainsRow = this.newRow(stateSheet);

        int i = 0;
        for (Iterator iter = chainMapTable.getTargetChains().iterator(); iter
                .hasNext();) {
            String chainName = (String) iter.next();
            chainsRow.createCell((short) i++).setCellValue(chainName);
        }

        HSSFRow headerRow = this.newRow(stateSheet);

        headerRow.createCell((short) 0).setCellValue("State");

        headerRow.createCell((short) 1).setCellValue("Chain Count");
        headerRow.createCell((short) 2).setCellValue("Chain Share (%)");

        for (Iterator iter = chainMapTable.getStates().iterator(); iter
                .hasNext();) {
            ChainMapTableLineItem lineItem = (ChainMapTableLineItem) iter
                    .next();
            HSSFRow dataRow = this.newRow(stateSheet);

            dataRow.createCell((short) 0).setCellValue(lineItem.getName());

            dataRow.createCell((short) 1).setCellValue(
                    lineItem.getChainCount().longValue());
            dataRow.createCell((short) 2).setCellValue(
                    lineItem.getChainPercent().doubleValue());

            dataRow.getCell((short) 2).setCellStyle(style);

        }

    }

    private void buildRegionSheet(HSSFSheet regionSheet,
            ChainMapTable chainMapTable) {
        this.resetRowCount();

        HSSFCellStyle style = this.getWorkbook().createCellStyle();
        style.setDataFormat((short) 4);

        regionSheet.setColumnWidth((short) 0, (short) 3600);
        regionSheet.setColumnWidth((short) 1, (short) 3600);
        regionSheet.setColumnWidth((short) 2, (short) 3600);
        regionSheet.setColumnWidth((short) 3, (short) 3600);
        regionSheet.setColumnWidth((short) 4, (short) 3600);
        regionSheet.setColumnWidth((short) 5, (short) 3600);

        HSSFRow titlerow = this.newRow(regionSheet);
        titlerow.createCell((short) 2).setCellValue(
                "Chain Map Regional Breakdown");

        HSSFRow chainsRow = this.newRow(regionSheet);

        int i = 0;
        for (Iterator iter = chainMapTable.getTargetChains().iterator(); iter
                .hasNext();) {
            String chainName = (String) iter.next();
            chainsRow.createCell((short) i++).setCellValue(chainName);
        }

        HSSFRow headerRow = this.newRow(regionSheet);

        headerRow.createCell((short) 0).setCellValue("Census Region");
        headerRow.createCell((short) 1).setCellValue("All Chain Count");
        headerRow.createCell((short) 2).setCellValue("All Chain Share");
        headerRow.createCell((short) 3).setCellValue("Chain Count");
        headerRow.createCell((short) 4).setCellValue("Chain Share (%)");
        headerRow.createCell((short) 5).setCellValue("Index");

        for (Iterator iter = chainMapTable.getRegions().iterator(); iter
                .hasNext();) {
            ChainMapTableLineItem lineItem = (ChainMapTableLineItem) iter
                    .next();
            HSSFRow dataRow = this.newRow(regionSheet);

            dataRow.createCell((short) 0).setCellValue(lineItem.getName());
            dataRow.createCell((short) 1).setCellValue(
                    lineItem.getAllChainCount().longValue());
            dataRow.createCell((short) 2).setCellValue(
                    lineItem.getAllChainPercent().doubleValue());
            dataRow.getCell((short) 2).setCellStyle(style);
            dataRow.createCell((short) 3).setCellValue(
                    lineItem.getChainCount().longValue());
            dataRow.createCell((short) 4).setCellValue(
                    lineItem.getChainPercent().doubleValue());
            dataRow.getCell((short) 4).setCellStyle(style);
            dataRow.createCell((short) 5).setCellValue(
                    lineItem.getIndex().longValue());
        }

    }

    public ChainMapContext getChainMapContext() {
        return chainMapContext;
    }

    public void setChainMapContext(ChainMapContext chainMapContext) {
        this.chainMapContext = chainMapContext;
    }

}