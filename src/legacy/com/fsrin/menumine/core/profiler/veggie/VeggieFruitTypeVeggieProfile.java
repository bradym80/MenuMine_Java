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
public class VeggieFruitTypeVeggieProfile extends AbstractVeggieProfile {

    private FieldEnum fieldEnum = FieldEnum.VEGGIE_FRUIT_TYPE;

    protected String getValue(Object testObject) {

        return ((VeggieProfileBean) testObject).getVeggieFruitType();

    }

    public FieldEnum getFieldEnum() {
        return fieldEnum;
    }

}