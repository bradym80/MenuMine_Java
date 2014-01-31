/*
 * Created on May 15, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.webwork;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/*
 * 2006-05-15 RSC Chain Trend
 * 
 * Two tables, graphs.
 * 
 * Top: same store, 2001-2005 chain in market sector on menu 2005
 * 
 * Bottom same store, 2001-2005 chain in market sector on menu 2001
 * 
 */
public class MenuMineTableChainTrendExcelAction extends
        AbstractChainTableTrendAction {

    private Log log = LogFactory
            .getLog(MenuMineTableChainTrendExcelAction.class);

    private HSSFWorkbook workbook = null;

    public String execute() throws Exception {
        log.debug("starting MenuMineTableChainTrendActionExcel");

        super.execute();

        workbook = this.buildWorkbook();

        return SUCCESS;
    }

    public HSSFWorkbook getWorkbook() {
        return workbook;
    }

}
