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
public class VegAccompNameVeggieProfile extends AbstractVeggieProfile {

    private FieldEnum fieldEnum = FieldEnum.VEG_ACCOMP_NAME;

    protected String getValue(Object testObject) {

        return ((VeggieProfileBean) testObject).getVegAccompName();

    }

    public FieldEnum getFieldEnum() {
        return fieldEnum;
    }

}