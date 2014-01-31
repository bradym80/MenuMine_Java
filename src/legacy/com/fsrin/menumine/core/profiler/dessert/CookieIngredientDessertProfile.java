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
public class CookieIngredientDessertProfile extends AbstractDessertProfile {

    private FieldEnum fieldEnum = FieldEnum.COOKIE_INGREDIENT;

    public FieldEnum getFieldEnum() {
        return fieldEnum;
    }

    protected String getValue(Object testObject) {

        return ((DessertProfileBean) testObject).getCookieIngredient();

    }

}