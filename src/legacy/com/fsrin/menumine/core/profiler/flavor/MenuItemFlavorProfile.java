/*
 * Created on Apr 5, 2005
 *
 * 
 */
package com.fsrin.menumine.core.profiler.flavor;

import com.fsrin.menumine.core.menumine.FieldEnum;
import com.fsrin.menumine.core.menumine.masterfood.MasterFood;
import com.fsrin.menumine.core.profiler.AbstractProfile;

/**
 * @author Nick
 * 
 *  
 */
public class MenuItemFlavorProfile extends AbstractProfile {

    private FieldEnum fieldEnum = FieldEnum.MENU_ITEM_NAME;

    public FieldEnum getFieldEnum() {
        return fieldEnum;
    }

    protected String getValue(Object testObject) {
        return ((MasterFood) testObject).getMenuItem();
    }



}