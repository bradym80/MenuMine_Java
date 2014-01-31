/*
 * Created on Mar 10, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

/**
 * 2006-03-10 RSC Helper class for all of the excel stuff we need to do.
 * 
 * @author Reid
 */
public class ExcelSupport {

    private String tempFilePath;
    
    private String webPrefix;
    
    private HSSFWorkbook workbook;
    
    private HSSFSheet activeSheet;
    
    public HSSFCellStyle numericCellStyle;

    public HSSFCellStyle numericCellStyleGrey;

    public HSSFCellStyle percentageCellStyle;
    
    public HSSFCellStyle decimalCellStyle;

    public HSSFCellStyle percentageCellStyleGrey;
    
    

    public HSSFDataFormat numericData;
   
    private HSSFCellStyle dollarStyle;
    
    private HSSFCellStyle headlineStyle;
    
    private HSSFCellStyle generalStyleGrey;
    
    private HSSFRow currentRow;
    
    private int nextRowId;
    
    private int cellCount;
    
    ExcelSupport() {
        super();
        workbook = new HSSFWorkbook();
 
        numericCellStyle = workbook.createCellStyle();
        numericData = workbook.createDataFormat();
        numericCellStyle.setDataFormat(numericData.getFormat("#,##0.00"));
        
        numericCellStyleGrey = workbook.createCellStyle();
        numericData = workbook.createDataFormat();
        numericCellStyleGrey.setDataFormat(numericData.getFormat("#,##0.00"));
        numericCellStyleGrey.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
        numericCellStyleGrey.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);        
        
        percentageCellStyle = workbook.createCellStyle();
        percentageCellStyle.setDataFormat((short) 4);
        
        percentageCellStyleGrey = workbook.createCellStyle();
        percentageCellStyleGrey.setDataFormat((short) 4);
        percentageCellStyleGrey.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
        percentageCellStyleGrey.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);        
        
        decimalCellStyle = workbook.createCellStyle();
        decimalCellStyle.setDataFormat(workbook.createDataFormat().getFormat("#,##0.0#####"));
        
        
        dollarStyle = workbook.createCellStyle();
        dollarStyle.setDataFormat((short) 8);
        
        headlineStyle = workbook.createCellStyle();
        
        HSSFFont headlineFont = workbook.createFont();
//      set font 1 to 12 point type
        headlineFont.setFontHeightInPoints((short) 24);

//         make it bold
//        arial is the default font
        headlineFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        headlineStyle.setFont(headlineFont);
        
        generalStyleGrey = workbook.createCellStyle();
        generalStyleGrey.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
        generalStyleGrey.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);    
    }

    public HSSFWorkbook getWorkbook() {
        return workbook;
    }
    
    public HSSFSheet getSheet() {
        if (activeSheet == null)
            addNewSheet("MenuMine"); // default name
        
        return activeSheet;
    }
    
    
    public void addNewSheet(String name) {
        activeSheet = workbook.createSheet(name);
    }
    
    public HSSFRow addRow() {
        
        HSSFRow ret = this.addRow(nextRowId);
        nextRowId++;
        return ret;
    }
    
    public HSSFRow addRow(int i) {
        return this.addRow((short) i);
    }
    
    public HSSFRow addRow(short i) {
        return this.addRow(i, this.getSheet());
    }

    public HSSFRow addRow(short i, HSSFSheet sheet) {
        return sheet.createRow(i);
    }
    
    public HSSFCell getCell(int cellId, HSSFRow row) {
        HSSFCell ret = row.createCell((short)cellId);
        return ret;
    }
    public void decorateRowWithCell(int cellId, HSSFRow row, Object value) {
        this.decorateRowWithCell((short) cellId, row, value, null);
    }
    
    public void decorateRowWithCellGrey(int cellId, HSSFRow row, Object value) {
        this.decorateRowWithCell((short) cellId, row, value,generalStyleGrey);
    }
    
    public void decorateRowWithCell(short cellId, HSSFRow row, Object value, HSSFCellStyle cellStyle) {
        
        HSSFCell cell = row.createCell(cellId);
        
        if (value == null) {
        	//JDL 10-7-07
        } else if (value instanceof Float) {
            cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            cell.setCellValue(((Float)value).floatValue());    
        } else if (value instanceof Double) {
            cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            cell.setCellValue(((Double)value).doubleValue());
        } else if (value instanceof Integer) {
            cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            cell.setCellValue(((Integer)value).intValue());
        } else {
            cell.setCellType(HSSFCell.CELL_TYPE_STRING);
            cell.setCellValue(value.toString());
        }
        
        if (cellStyle != null) {
            cell.setCellStyle(cellStyle);
        }
        
    }
    
    public void decorateRowWithHeadlineCell(int cellId, HSSFRow row, Object value) {
        this.decorateRowWithCell((short) cellId, row, value, headlineStyle);
    }
    
   
    
    public void decorateRowWithNumericCell(int cellId, HSSFRow row, int value) {
        this.decorateRowWithCell((short) cellId, row, new Integer(value), numericCellStyle);
    }
    
    public void decorateRowWithNumericCell(int cellId, HSSFRow row, double value) {
        this.decorateRowWithCell((short) cellId, row, new Double(value), numericCellStyle);
    }
    
    public void decorateRowWithNumericCellGrey(int cellId, HSSFRow row, int value) {
        this.decorateRowWithCell((short) cellId, row, new Integer(value), numericCellStyleGrey);
    }
    
    public void decorateRowWithNumericCellGrey(int cellId, HSSFRow row, double value) {
        this.decorateRowWithCell((short) cellId, row, new Double(value), numericCellStyleGrey);
    }
    
    public void decorateRowWithPercentageCell(int cellId, HSSFRow row, Object value) {
        this.decorateRowWithCell((short) cellId, row, value,percentageCellStyle);
    }
    
    public void decorateRowWithPercentageCellGrey(int cellId, HSSFRow row, Object value) {
        this.decorateRowWithCell((short) cellId, row, value,percentageCellStyleGrey);
    }

    public void decorateRowWithDecimalCell(int cellId, HSSFRow row, double value) {
        this.decorateRowWithCell((short) cellId, row, new Double(value), decimalCellStyle);
    }

    public void decorateRowWithDecimalCell(int cellId, HSSFRow row, Object value) {
        this.decorateRowWithCell((short) cellId, row, value, decimalCellStyle);
    }

    /**
     * @return Returns the cellCount.
     */
    public int getCellCount() {
        return cellCount;
    }

    /**
     * @return Returns the currentRow.
     */
    public HSSFRow getCurrentRow() {
        return currentRow;
    }

    public void setColumnWidth(int col, int width) {
        this.getSheet().setColumnWidth((short) col, (short) width);
    }
    
    public String write(String filePrefix, HSSFWorkbook targetWorkbook) throws ExcelSupportException {
        
        Date create = new Date();

        Random r = new Random(create.getTime());

        String fileName = filePrefix + "-" + create.getTime() + ".xls";

        FileOutputStream out;
        try {
            out = new FileOutputStream( this.getTempFilePath() + fileName);
        } catch (FileNotFoundException e) {
            throw new ExcelSupportException(e);
        }
        
        try {
            targetWorkbook.write(out);
        } catch (IOException e) {
            throw new ExcelSupportException(e);
        }
        
        try {
            out.close();
        } catch (IOException e) {
            throw new ExcelSupportException(e);
        }
        
        return fileName;

        
    }
    public String write(String filePrefix) throws ExcelSupportException {
        
        return write(filePrefix, this.getWorkbook());
        
    }

    public String getTempFilePath() {
        return tempFilePath;
    }

    public void setTempFilePath(String tempFilePath) {
        this.tempFilePath = tempFilePath;
    }

    public void setWorkbook(HSSFWorkbook workbook) {
        this.workbook = workbook;
    }

    public String getWebPrefix() {
        return webPrefix;
    }

    public void setWebPrefix(String webPrefix) {
        this.webPrefix = webPrefix;
    }
}
