/*
 * Created on Apr 5, 2005
 *
 * 
 */
package com.fsrin.menumine.core.profiler.healthy;

import com.fsrin.menumine.core.menumine.FieldEnum;

/**
 * @author Nick
 * 
 *  
 */
public class HealthySymbolHealthyProfile extends AbstractHealthyProfile {

    private FieldEnum fieldEnum = FieldEnum.HEALTHY_SYMBOL;
    

    public FieldEnum getFieldEnum() {
        return fieldEnum;
    }


    protected String getValue(Object testObject) {

        return ((HealthyProfileBean) testObject).getHealthySymbol();

    }

}