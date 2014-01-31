/*
 * Created on Apr 5, 2005
 *
 * 
 */
package com.fsrin.menumine.core.profiler.veggie;

import com.fsrin.menumine.core.menumine.FieldEnum;

/**
 * @author Nick
 * 
 *  
 */
public class MenuItemVeggieProfile extends AbstractVeggieProfile {

    private FieldEnum fieldEnum = FieldEnum.MENU_ITEM_NAME;

    protected String getValue(Object testObject) {

        return ((VeggieProfileBean) testObject).getMenuItem();

    }

    public FieldEnum getFieldEnum() {
        return fieldEnum;
    }

}