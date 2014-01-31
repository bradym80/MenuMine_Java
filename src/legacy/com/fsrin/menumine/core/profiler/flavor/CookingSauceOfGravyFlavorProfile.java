/*
 * Created on Apr 5, 2005
 *
 * 
 */
package com.fsrin.menumine.core.profiler.flavor;

import com.fsrin.menumine.core.menumine.FieldEnum;
import com.fsrin.menumine.core.menumine.masterfood.MasterFood;
import com.fsrin.menumine.core.profiler.AbstractProfile;

/**
 * @author Nick
 * 
 *  
 */
public class CookingSauceOfGravyFlavorProfile extends AbstractProfile {

    private FieldEnum fieldEnum = FieldEnum.COOKING_SAUCE_OR_GRAVY;

    public FieldEnum getFieldEnum() {
        return fieldEnum;
    }

    protected String getValue(Object testObject) {
        return ((MasterFood) testObject).getCookingSauceOrGravy();
    }



}