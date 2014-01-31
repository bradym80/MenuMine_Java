/*
 * Created on Apr 5, 2005
 *
 * 
 */
package com.fsrin.menumine.core.profiler.protein;

import com.fsrin.menumine.core.menumine.FieldEnum;

/**
 * @author Nick
 * 
 *  
 */
public class MenuItemProteinProfile extends AbstractProteinProfile {

    private FieldEnum fieldEnum = FieldEnum.MENU_ITEM_NAME;
    
    public MenuItemProteinProfile() {
        super();
    }

    protected String getValue(Object testObject) {

        return ((ProteinProfileBean) testObject).getMenuItem();

    }

    public FieldEnum getFieldEnum() {
        
        return fieldEnum;
    }

}