/*
 * Created on 2005-1-18
 *
 */
package com.fsrin.menumine.core.menumine.webwork;

import java.util.Collection;

import com.fsrin.menumine.core.menumine.webwork.util.MenuMineResultsDisplayWrapperBuilder;
import com.fsrin.menumine.core.menumine.webwork.util.MenuMineResultsDisplayWrapperHeader;

/**
 * @author Nick
 * @version 1
 */

public class MenuMineDisplaySpreadsheetAction extends
        AbstractMenuMineDisplayAction {

    public static final String SPRING_BEAN_NAME = "menuMineDisplaySpreadSheetAction";

    private MenuMineResultsDisplayWrapperHeader displayWrapperHeader;

    public String execute() throws Exception {
        super.execute();
        if (this.getSubmitOptions() != null
                && this.getSubmitOptions().equals("Download Excel")) {
            this.getMenuMineDisplayOptions().setDisplayType("Download Excel");

        } else {
            this.getMenuMineDisplayOptions().setDisplayType(
                    "Display Spreadsheet");
        }
        this.getMenuMineSessionContextWrapper().setLastGraphOptions(
                this.getMenuMineGraphOptions());

        return SUCCESS;
    }

    /*
     * 2006-01-24 RSC These are the display fields.
     */
    public Collection getWrappedResults() {
        /*
         * We want to ignore the cache
         */
        // 2006-02-06 RSC Removed.
        // this.setCompletedQueryManager(null);
        Collection re = this.getResults();

        if (re == null) {
            this.getMenuMineSessionContextWrapper().getErrorContext().addError(
                    "Unable to retrieve your results. (Results is null)");
            return null;
        }

        Collection wrapped = MenuMineResultsDisplayWrapperBuilder.singleton
                .buildCollection(re, this.getLastFieldsToDisplay(), this
                        .getMenuMineSessionContextWrapper().getMineFields());

        this.dumpResults();
        return wrapped;
    }

    /*
     * 2006-01-24 RSC These are the headers.
     */
    public MenuMineResultsDisplayWrapperHeader getResultHeader() {
        if (displayWrapperHeader == null) {
            this.displayWrapperHeader = MenuMineResultsDisplayWrapperBuilder.singleton
                    .buildHeader(this.getLastFieldsToDisplay(), this
                            .getMenuMineSessionContextWrapper().getMineFields());
        }
        return displayWrapperHeader;
    }

}