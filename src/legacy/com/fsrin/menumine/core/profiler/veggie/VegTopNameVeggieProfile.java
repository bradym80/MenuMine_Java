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
public class VegTopNameVeggieProfile extends AbstractVeggieProfile {

    private FieldEnum fieldEnum = FieldEnum.VEG_TOP_NAME;

    protected String getValue(Object testObject) {

        return ((VeggieProfileBean) testObject).getVegTopName();

    }

    public FieldEnum getFieldEnum() {
        return fieldEnum;
    }

}