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
public class OtherToppingsVeggieProfile extends AbstractVeggieProfile {

    private FieldEnum fieldEnum = FieldEnum.OTHER_TOPPINGS;

    protected String getValue(Object testObject) {

        return ((VeggieProfileBean) testObject).getOtherToppings();

    }

    public FieldEnum getFieldEnum() {
        return fieldEnum;
    }

}