/*
 * Created on Mar 29, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.sharetable.legacy;

import com.fsrin.menumine.core.menumine.masterfood.MasterFood;
import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableKeyFinder;

/**
 * @author Nick
 * 
 *  
 */
public class StatisticalTableFlavEnhancSeasBrdgDesIngredMMKeyFinder implements
        StatisticalTableKeyFinder {

    public StatisticalTableFlavEnhancSeasBrdgDesIngredMMKeyFinder() {
        super();

    }

    public Object getKey(MasterFood masterFood) {
        Object result;
        result = masterFood.getFlavEnhancSeasBrdgDesIngredMM();
        //        try {
        //            result = Ognl.getValue(this.fieldEnum.getOgnlName(), masterFood);
        //        } catch (OgnlException e) {
        //
        //            e.printStackTrace();
        //            return "Not On Menu";
        //        }

        if (result == null) {
            return "Not On Menu";
        }
        return result;
    }

}