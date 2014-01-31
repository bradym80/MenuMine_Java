/*
 * Created on Apr 5, 2005
 *
 * 
 */
package com.fsrin.menumine.core.profiler.test;

import com.fsrin.menumine.core.menumine.FieldEnum;
import com.fsrin.menumine.core.menumine.masterfood.MasterFood;
import com.fsrin.menumine.core.profiler.AbstractProfile;

/**
 * @author Nick
 * 
 *  
 */
public class MasterFoodSeasoningProfile extends AbstractProfile {

    private FieldEnum fieldEnum = FieldEnum.SEASONING_NAME;
     

    public FieldEnum getFieldEnum() {
        return fieldEnum;
    }

    protected String getValue(Object testObject) {
        return ((MasterFood) testObject).getFlavEnhancSeasBrdgDesIngredMM();
    }

    protected boolean testInstanceOf(Object testObject) {

        return testObject instanceof MasterFood;
    }

}