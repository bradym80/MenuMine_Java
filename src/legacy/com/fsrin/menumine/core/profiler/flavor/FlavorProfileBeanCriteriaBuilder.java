/*
 * Created on Apr 5, 2005
 *
 * 
 */
package com.fsrin.menumine.core.profiler.flavor;

import com.fsrin.menumine.core.profiler.AbstractProfilerCriteriaBuilder;

/**
 * @author Nick
 * 
 *  
 */
public class FlavorProfileBeanCriteriaBuilder extends AbstractProfilerCriteriaBuilder {

    private String fields[] = { "menuItem", "itemDescription",
            "cookingSauceOrGravy", "marinade", "glaze", "condiments",
            "dressings", "dipSauceName", "seasoningName", "stuffName",
            "batterBreadingCoating", "fillingSaucesDressings", "otherToppings",
            "otherIngredName", "breadWrapChips", "cheese", "syrupTopping" };

    
    


    public Class getProfileClass() {
        return FlavorProfileBean.class;
    }

}