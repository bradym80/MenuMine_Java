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
public class CarboTopNameCarboProfile extends AbstractCarboProfile {

    private FieldEnum fieldEnum = FieldEnum.CARBO_TOP_NAME;
    

    protected String getValue(Object testObject) {

        return ((CarboProfileBean) testObject).getCarboTopName();

    }


    public FieldEnum getFieldEnum() {
        return fieldEnum;
    }

}