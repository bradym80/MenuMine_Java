/*
 * Created on Apr 5, 2005
 *
 * 
 */
package com.fsrin.menumine.core.profiler.market;

import com.fsrin.menumine.core.menumine.FieldEnum;

/**
 * @author Nick
 * 
 *  
 */
public class MenuItemMarketProfile extends AbstractMarketProfile {

    private FieldEnum fieldEnum = FieldEnum.MENU_ITEM_NAME;

    public FieldEnum getFieldEnum() {
        return fieldEnum;
    }

    protected String getValue(Object testObject) {

        return ((MarketProfileBean) testObject).getMenuItem();

    }

}