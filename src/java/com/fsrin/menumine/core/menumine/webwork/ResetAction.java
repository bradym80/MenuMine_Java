/*
 * Created on 2005-1-18
 *
 */
package com.fsrin.menumine.core.menumine.webwork;

import com.fsrin.menumine.context.webwork.MenuMineSessionContextWrapper;
import com.fsrin.menumine.context.webwork.MenuMineSessionContextWrapperAware;
import com.fsrin.menumine.core.menumine.FieldsToDisplayBean;
import com.opensymphony.xwork.ActionSupport;

/**
 * @author Nick
 * @version 1
 * 
 * Probably won't use.
 */

public class ResetAction extends ActionSupport implements
        MenuMineSessionContextWrapperAware {

    private MenuMineSessionContextWrapper menuMineSessionContextWrapper;

    private String submit;

    public String execute() throws Exception {

        if (this.getSubmit() != null && this.getSubmit().equals("RESET")) {
            this.handleReset();

            return SUCCESS;

        }

        return SUCCESS;

    }

    private void handleReset() {

        this.getMenuMineSessionContextWrapper().setLastFilterWrapper(
                new MasterFoodFilterParametersWrapperImpl());
        // this.getMenuMineSessionContextWrapper().setLastFilter(null);
        this.getMenuMineSessionContextWrapper().setLastFieldsToDisplay(
                new FieldsToDisplayBean());

        /*
         * Nick 2005-6-1 Since we are resetting we want to reset the roll up
         * stuff as well.
         * 
         * We should refactor the reset to its own action, that chains to the
         * RollupReset.
         */
        this.getMenuMineSessionContextWrapper().resetRollUpOptions();

    }

    public MenuMineSessionContextWrapper getMenuMineSessionContextWrapper() {
        return menuMineSessionContextWrapper;
    }

    public void setMenuMineSessionContextWrapper(
            MenuMineSessionContextWrapper menuMineSessionContextWrapper) {
        this.menuMineSessionContextWrapper = menuMineSessionContextWrapper;
    }

    public String getSubmit() {
        return submit;
    }

    public void setSubmit(String submit) {
        this.submit = submit;
    }
}