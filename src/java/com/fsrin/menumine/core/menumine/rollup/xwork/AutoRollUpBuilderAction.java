/*
 * Created on 2005-1-18
 *
 */
package com.fsrin.menumine.core.menumine.rollup.xwork;

import com.fsrin.menumine.core.menumine.rollup.AutoRollUpBuilder;
import com.fsrin.menumine.core.menumine.rollup.RollUpOptions;
import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableIF;
import com.fsrin.menumine.core.menumine.webwork.MenuMineDisplayStatisticalTableAction;

/**
 * @author Nick
 * @version 1
 */

public class AutoRollUpBuilderAction extends
        MenuMineDisplayStatisticalTableAction  {

    private int rollUpIntencity = AutoRollUpBuilder.INTENSITY_HIGH;
    
    public String execute() throws Exception {

        super.execute();
       
        this.getMenuMineSessionContextWrapper().resetRollUpOptions();

        StatisticalTableIF table = this.getStatisticalTableResults();

        AutoRollUpBuilder autoRollUpBuilder = new AutoRollUpBuilder(table, this.getRollUpIntencity());

        RollUpOptions rollUp = autoRollUpBuilder.getProposedRollUp();

        this.getMenuMineSessionContextWrapper().setRollUpOptions(rollUp);

        return SUCCESS;
    }

    
    public int getRollUpIntencity() {
        return rollUpIntencity;
    }
    public void setRollUpIntencity(int rollUpIntencity) {
        this.rollUpIntencity = rollUpIntencity;
    }
}