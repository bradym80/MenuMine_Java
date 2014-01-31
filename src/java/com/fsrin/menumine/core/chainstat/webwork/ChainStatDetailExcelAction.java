/*
 * Created on 2005-1-18
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.fsrin.menumine.core.chainstat.webwork;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.fsrin.menumine.context.webwork.AbstractMenuMineSessionContextAwareAction;
import com.fsrin.menumine.core.chainstat.ChainStat;
import com.fsrin.menumine.core.chainstat.ChainStatServiceDelegate;
import com.opensymphony.xwork.ActionContext;
import com.opensymphony.xwork.util.OgnlValueStack;

/**
 * @author Nick
 * @version 1
 */

public class ChainStatDetailExcelAction extends AbstractMenuMineSessionContextAwareAction {

//    private MenuMineSessionContextWrapper menuMineSessionContextWrapper;

    private ChainStatServiceDelegate chainStatServiceDelegate;

    private HSSFWorkbook workbook = null;

    // private Collection files = new ArrayList();

    public static final String SPRING_BEAN_NAME = "chainStatDetailAction";

    public String execute() throws Exception {
        OgnlValueStack stack = ActionContext.getContext().getActionInvocation()
                .getStack();

        ChainStat chainStat = (ChainStat) stack.findValue("chainStat");

        if (chainStat == null) {
            return ERROR;
        }

        workbook = new HSSFWorkbook();

        HSSFSheet sheet = workbook.createSheet(chainStat.getOperationName());

        HSSFRow titlerow = this.newRow(sheet);
        titlerow.createCell((short) 2).setCellValue("Chain Stat");

        HSSFRow segmentSectorHeaderRow = this.newRow(sheet);
        segmentSectorHeaderRow.createCell((short) 1).setCellValue("Segment");
        segmentSectorHeaderRow.createCell((short) 3).setCellValue("Sector");

        HSSFRow segmentSectorValueRow = this.newRow(sheet);
        segmentSectorValueRow.createCell((short) 1).setCellValue(
                chainStat.getSegment());
        segmentSectorValueRow.createCell((short) 3).setCellValue(
                chainStat.getSectorName());

        HSSFRow chainAddressHeader1Row = this.newRow(sheet);
        chainAddressHeader1Row.createCell((short) 1).setCellValue("Chain");
        chainAddressHeader1Row.createCell((short) 2).setCellValue(
                "Street Address");
        chainAddressHeader1Row.createCell((short) 4).setCellValue("City");

        HSSFRow chainAddressValue1Row = this.newRow(sheet);
        chainAddressValue1Row.createCell((short) 1).setCellValue(
                chainStat.getOperationName());
        chainAddressValue1Row.createCell((short) 2).setCellValue(
                chainStat.getHqAddress());
        chainAddressValue1Row.createCell((short) 4).setCellValue(
                chainStat.getHqCity());

        HSSFRow chainAddressHeader2Row = this.newRow(sheet);
        chainAddressHeader2Row.createCell((short) 1).setCellValue("State");
        chainAddressHeader2Row.createCell((short) 2).setCellValue("Phone");
        chainAddressHeader2Row.createCell((short) 3).setCellValue("Fax");
        chainAddressHeader2Row.createCell((short) 4).setCellValue("Web Site");

        HSSFRow chainAddressValue2Row = this.newRow(sheet);
        chainAddressValue2Row.createCell((short) 1).setCellValue(
                chainStat.getHqState());
        chainAddressValue2Row.createCell((short) 2).setCellValue(
                chainStat.getPhone());
        chainAddressValue2Row.createCell((short) 3).setCellValue(
                chainStat.getFax());
        chainAddressValue2Row.createCell((short) 4).setCellValue(
                chainStat.getWebSite());

        HSSFRow chainAddressHeader3Row = this.newRow(sheet);
        chainAddressHeader3Row.createCell((short) 1).setCellValue("Zip");

        HSSFRow chainAddressValue3Row = this.newRow(sheet);
        chainAddressValue3Row.createCell((short) 1).setCellValue(
                chainStat.getHqZip());

        HSSFRow unitsSalesHeaderRow = this.newRow(sheet);
        unitsSalesHeaderRow.createCell((short) 1).setCellValue(
                "# Operating Units");
        unitsSalesHeaderRow.createCell((short) 3).setCellValue("Sales, MM");

        HSSFRow unitsSalesYearHeaderRow = this.newRow(sheet);
        unitsSalesYearHeaderRow.createCell((short) 1).setCellValue("2003");
        unitsSalesYearHeaderRow.createCell((short) 2).setCellValue("2004");

        unitsSalesYearHeaderRow.createCell((short) 3).setCellValue("2003");
        unitsSalesYearHeaderRow.createCell((short) 4).setCellValue("2004");

        HSSFRow unitsSalesYearValueRow = this.newRow(sheet);
        unitsSalesYearValueRow.createCell((short) 1).setCellValue(
                chainStat.getUnits2003());
        unitsSalesYearValueRow.createCell((short) 2).setCellValue(
                chainStat.getUnits2004());

        unitsSalesYearValueRow.createCell((short) 3).setCellValue(
                chainStat.getSales2003());
        unitsSalesYearValueRow.createCell((short) 4).setCellValue(
                chainStat.getSales2004());

        HSSFRow industryRankHeaderRow = this.newRow(sheet);

        industryRankHeaderRow.createCell((short) 1).setCellValue(
                "Industry Rank");
        industryRankHeaderRow.createCell((short) 3).setCellValue(
                "Industry Rank");

        HSSFRow industryRankYearHeaderRow = this.newRow(sheet);
        industryRankYearHeaderRow.createCell((short) 1).setCellValue("2003");
        industryRankYearHeaderRow.createCell((short) 2).setCellValue("2004");

        industryRankYearHeaderRow.createCell((short) 3).setCellValue("2003");
        industryRankYearHeaderRow.createCell((short) 4).setCellValue("2004");

        HSSFRow industryRankYearValueRow = this.newRow(sheet);
        industryRankYearValueRow.createCell((short) 1).setCellValue(
                chainStat.getIndusRankUnits03());
        industryRankYearValueRow.createCell((short) 2).setCellValue(
                chainStat.getIndusRankUnits04());

        industryRankYearValueRow.createCell((short) 3).setCellValue(
                chainStat.getIndusRankDoll03());
        industryRankYearValueRow.createCell((short) 4).setCellValue(
                chainStat.getIndusRankDoll04());

        HSSFRow segmentRankHeaderRow = this.newRow(sheet);
        segmentRankHeaderRow.createCell((short) 1).setCellValue("Segment Rank");
        segmentRankHeaderRow.createCell((short) 3).setCellValue("Segment Rank");

        HSSFRow segmentRankYearHeaderRow = this.newRow(sheet);
        segmentRankYearHeaderRow.createCell((short) 1).setCellValue("2003");
        segmentRankYearHeaderRow.createCell((short) 2).setCellValue("2004");

        segmentRankYearHeaderRow.createCell((short) 3).setCellValue("2003");
        segmentRankYearHeaderRow.createCell((short) 4).setCellValue("2004");

        HSSFRow segmentRankYearValueRow = this.newRow(sheet);
        segmentRankYearValueRow.createCell((short) 1).setCellValue(
                chainStat.getSegRankUnits03());
        segmentRankYearValueRow.createCell((short) 2).setCellValue(
                chainStat.getSegRankUnits04());

        segmentRankYearValueRow.createCell((short) 3).setCellValue(
                chainStat.getSegRankDoll03());
        segmentRankYearValueRow.createCell((short) 4).setCellValue(
                chainStat.getSegRankDoll03());

        HSSFRow parentHeaderRow = this.newRow(sheet);
        parentHeaderRow.createCell((short) 1).setCellValue("Parent");
        parentHeaderRow.createCell((short) 2).setCellValue("Address");
        parentHeaderRow.createCell((short) 3).setCellValue("City");
        parentHeaderRow.createCell((short) 4).setCellValue("State");
        parentHeaderRow.createCell((short) 5).setCellValue("Zip");

        HSSFRow parentValuesRow = this.newRow(sheet);

        parentValuesRow.createCell((short) 1).setCellValue(
                chainStat.getParentCo());
        parentValuesRow.createCell((short) 2).setCellValue(
                chainStat.getParentAddress());
        parentValuesRow.createCell((short) 3).setCellValue(
                chainStat.getParentCity());
        parentValuesRow.createCell((short) 4).setCellValue(
                chainStat.getParentState());
        parentValuesRow.createCell((short) 5).setCellValue(
                chainStat.getParentZip());
        return SUCCESS;
    }

    private short rowNumber = 0;

    private HSSFRow newRow(HSSFSheet sheet) {
        HSSFRow row = sheet.createRow((short) rowNumber++);
        return row;
    }

//    public MenuMineSessionContextWrapper getMenuMineSessionContextWrapper() {
//        return menuMineSessionContextWrapper;
//    }
//
//    public void setMenuMineSessionContextWrapper(
//            MenuMineSessionContextWrapper menuMineSessionContextWrapper) {
//        this.menuMineSessionContextWrapper = menuMineSessionContextWrapper;
//    }

    public HSSFWorkbook getWorkbook() {
        return workbook;
    }

    public void setWorkbook(HSSFWorkbook workbook) {
        this.workbook = workbook;
    }
}