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
public class StuffNameCarboProfile extends AbstractCarboProfile {

    private FieldEnum fieldEnum = FieldEnum.STUFF_NAME;
    

    public FieldEnum getFieldEnum() {
        return fieldEnum;
    }


    protected String getValue(Object testObject) {
        return ((CarboProfileBean) testObject).getStuffName();
    }

}