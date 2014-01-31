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
public class CarboAccompNameCarboProfile extends AbstractCarboProfile {

    private FieldEnum fieldEnum = FieldEnum.CARBO_ACCOMP_NAME;

    public FieldEnum getFieldEnum() {
        return fieldEnum;
    }

    protected String getValue(Object testObject) {

        return ((CarboProfileBean) testObject).getCarboAccompName();

    }

}