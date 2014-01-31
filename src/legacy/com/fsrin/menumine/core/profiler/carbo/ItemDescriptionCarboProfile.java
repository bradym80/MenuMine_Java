/*
 * Created on Apr 5, 2005
 *
 * 
 */
package com.fsrin.menumine.core.profiler.carbo;

import com.fsrin.menumine.core.menumine.FieldEnum;

/**
 * @author Nick
 * 
 *  
 */
public class ItemDescriptionCarboProfile extends AbstractCarboProfile {

    private FieldEnum fieldEnum = FieldEnum.DESCRIPTION;
    
    protected String getValue(Object testObject) {

        return ((CarboProfileBean) testObject).getItemDescription();

    }

    public FieldEnum getFieldEnum() {
        return fieldEnum;
    }

}