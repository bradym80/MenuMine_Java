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
public class ItemDescriptionVeggieProfile extends AbstractVeggieProfile {

    private FieldEnum fieldEnum = FieldEnum.DESCRIPTION;

    public FieldEnum getFieldEnum() {
        return fieldEnum;
    }

    protected String getValue(Object testObject) {

        return ((VeggieProfileBean) testObject).getItemDescription();

    }

}