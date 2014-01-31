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
public class OtherTopIngredDessertProfile extends AbstractDessertProfile {

    private FieldEnum fieldEnum = FieldEnum.OTHER_TOP_INGREDIENT;

    protected String getValue(Object testObject) {

        return ((DessertProfileBean) testObject).getOtherTopIngred();

    }

    public FieldEnum getFieldEnum() {
        return fieldEnum;
    }

}