/*
 * Created on 2005-1-18
 *
 */
package com.fsrin.menumine.core.menumine.rollup.xwork;


/**
 * 
 * 2006-02-03 RSC "Filter" should take any simple term and match it to the 
 * element labels.  If it matches, those should be grouped together.
 * 
 * @author Nick
 * @version 1
 */

public class MenuMineFilterRollUpAction extends AbstractRollUpAction  {

    private String rollUpFilter;

    public String execute() throws Exception {

        super.execute();
        
        this.getMenuMineSessionContextWrapper().getLastGraphOptions()
                .setSimpleFilter(rollUpFilter);
        // this.getMenuMineSessionContextWrapper().setRollUpFilter(rollUpFilter);
        return SUCCESS;
    }

    public String getRollUpFilter() {
        return rollUpFilter;
    }

    public void setRollUpFilter(String rollUpFilter) {
        this.rollUpFilter = rollUpFilter;
    }
}