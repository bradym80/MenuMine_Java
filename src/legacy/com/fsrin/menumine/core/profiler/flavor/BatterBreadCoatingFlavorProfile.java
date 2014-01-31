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
public class BatterBreadCoatingFlavorProfile extends AbstractProfile {

    private FieldEnum fieldEnum = FieldEnum.BATTER_BREADING_COATING;
    
    public BatterBreadCoatingFlavorProfile() {
        super();
    }

    protected String getValue(Object testObject) {

        return ((MasterFood) testObject).getBatterBreadingCoating();

    }



    public FieldEnum getFieldEnum() {
        return fieldEnum;
    }

}