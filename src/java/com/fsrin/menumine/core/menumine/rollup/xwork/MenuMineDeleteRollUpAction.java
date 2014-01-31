/*
 * Created on 2005-1-18
 *
 */
package com.fsrin.menumine.core.menumine.rollup.xwork;

import com.fsrin.menumine.core.menumine.rollup.RollUpOptions;
import com.fsrin.menumine.core.menumine.rollup.RollUpServiceDelegate;

/**
 * @author Nick
 * @version 1
 */

public class MenuMineDeleteRollUpAction extends AbstractRollUpAction  {

    private RollUpServiceDelegate rollUpServiceDelegate;

    private String submitDelete;

    public String execute() throws Exception {

        super.execute();
        
        if (this.isSubmitDelete()) {

            RollUpOptions rollUp = this.getMenuMineSessionContextWrapper()
                    .getRollUpOptions();

            this.getRollUpServiceDelegate().delete(rollUp);

            this.getMenuMineSessionContextWrapper().resetRollUpOptions();

        }

        return SUCCESS;
    }

    private boolean isSubmitDelete() {

        return this.getSubmitDelete() != null
                && this.getSubmitDelete().length() > 0;
    }

    public RollUpServiceDelegate getRollUpServiceDelegate() {
        return rollUpServiceDelegate;
    }

    public void setRollUpServiceDelegate(
            RollUpServiceDelegate rollUpServiceDelegate) {
        this.rollUpServiceDelegate = rollUpServiceDelegate;
    }

    public String getSubmitDelete() {
        return submitDelete;
    }

    public void setSubmitDelete(String submitDelete) {
        this.submitDelete = submitDelete;
    }
}