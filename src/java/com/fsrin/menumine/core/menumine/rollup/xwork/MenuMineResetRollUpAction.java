/*
 * Created on 2005-1-18
 *
 */
package com.fsrin.menumine.core.menumine.rollup.xwork;


/**
 * @author Nick
 * @version 1
 */

public class MenuMineResetRollUpAction extends AbstractRollUpAction  {

    public String execute() throws Exception {
        super.execute();
        this.getMenuMineSessionContextWrapper().resetRollUpOptions();

        return SUCCESS;
    }

}