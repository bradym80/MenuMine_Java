/*
 * Created on Apr 5, 2005
 *
 * 
 */
package com.fsrin.menumine.core.profiler.dessert;

import com.fsrin.menumine.core.menumine.FieldEnum;

/**
 * @author Nick
 * 
 * 
 */
public class IceCreamIngredientDessertProfile extends AbstractDessertProfile {

    private FieldEnum fieldEnum = FieldEnum.ICE_CREAM_INGREDIENT;

    protected String getValue(Object testObject) {

        return ((DessertProfileBean) testObject).getIceCreamIngredient();

    }

    public FieldEnum getFieldEnum() {
        return fieldEnum;
    }

}