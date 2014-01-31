/*
 * Created on Jul 12, 2005
 *
 * 
 */
package com.fsrin.menumine.common.webwork;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.fsrin.menumine.context.webwork.AbstractMenuMineSessionContextAwareAction;
import com.opensymphony.xwork.ActionContext;
import com.opensymphony.xwork.util.OgnlValueStack;

/**
 * @author Nick
 * 
 *  
 */
public class MenuMineExcelAction extends AbstractMenuMineSessionContextAwareAction {

//    private MenuMineSessionContextWrapper menuMineSessionContextWrapper;

    private HSSFWorkbook workbook = new HSSFWorkbook();

    public String execute() throws Exception {

        return super.execute();
    }

    /*
     * This method will use the OgnlValueStack to find the data associated with
     * the given key.
     * 2006-03-10 RSC Corrected Spelling.
     */
    public Object getDataSource(String ognlKey)

    {
        OgnlValueStack stack = ActionContext.getContext().getActionInvocation()
                .getStack();

        Object data = stack.findValue(ognlKey);

        return data;
    }

    public HSSFWorkbook getWorkbook() {
        return workbook;
    }

    public HSSFSheet getSheet(String name) {
        HSSFSheet sheet = null;

        sheet = workbook.getSheet(name);

        if (sheet == null) {
            sheet = workbook.createSheet(name);

        }

        return sheet;
    }

    /*
     * Convienience methods for getting new rows.
     */
    private short rowNumber = 0;

    protected HSSFRow newRow(HSSFSheet sheet) {
        HSSFRow row = sheet.createRow((short) rowNumber++);
        return row;
    }

    /*
     * We need to be able to reset the count if we have multiple sheets built by
     * this action.
     *  
     */
    protected void resetRowCount() {
        this.rowNumber = 0;
    }

}