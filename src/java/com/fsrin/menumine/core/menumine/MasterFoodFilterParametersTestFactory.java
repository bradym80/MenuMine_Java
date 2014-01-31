/*
 * Created on Jan 30, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine;

import com.fsrin.menumine.core.menumine.webwork.MasterFoodFilterParametersWrapper;
import com.fsrin.menumine.core.menumine.webwork.MasterFoodFilterParametersWrapperImpl;

public class MasterFoodFilterParametersTestFactory {

    public static void decorateWithCommonSelect(MasterFoodFilterParameters masterFoodFilterParameters) {
        masterFoodFilterParameters.getItemDescription().setSelect(true);
        masterFoodFilterParameters.getGenMenuPart().setSelect(true);
        masterFoodFilterParameters.getBasicProtein().setSelect(true);
        
    }
    public static MasterFoodFilterParameters getItemDescriptionWithBacon() {
        MasterFoodFilterParametersImpl ret = new MasterFoodFilterParametersImpl();
        ret.getItemDescription().getAndValues().add("bacon");
        decorateWithCommonSelect(ret);
        return ret;
    }
    
    public static MasterFoodFilterParameters getEmtpy() {
        MasterFoodFilterParametersImpl ret = new MasterFoodFilterParametersImpl();
        
        decorateWithCommonSelect(ret);
        return ret;
    }
    
    public static MasterFoodFilterParametersWrapper getItemDescriptionWithBaconInWrapper() {
        return new MasterFoodFilterParametersWrapperImpl(getItemDescriptionWithBacon());
    }
    
    public static MasterFoodFilterParameters getItemDescriptionWithChicken() {
        MasterFoodFilterParametersImpl ret = new MasterFoodFilterParametersImpl();
        ret.getItemDescription().getAndValues().add("chicken");
        decorateWithCommonSelect(ret);
        return ret;
    }
    
    public static MasterFoodFilterParameters getKeywordsWithChicken() {
        MasterFoodFilterParametersImpl ret = new MasterFoodFilterParametersImpl();
        ret.getKeywords().getAndValues().add("chicken");
        decorateWithCommonSelect(ret);
        return ret;
    }
    
    public static MasterFoodFilterParametersWrapper getItemDescriptionWithChickenInWrapper() {
        return new MasterFoodFilterParametersWrapperImpl(getItemDescriptionWithChicken());
    }    
    
}
