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
public class WhippedToppingIngredDessertProfile extends AbstractDessertProfile {

    private FieldEnum fieldEnum = FieldEnum.WHIPPED_TOPPING_INGRED;

    public FieldEnum getFieldEnum() {
        return fieldEnum;
    }

    protected String getValue(Object testObject) {
        return ((DessertProfileBean) testObject).getWhippedToppingIngred();
    }

}