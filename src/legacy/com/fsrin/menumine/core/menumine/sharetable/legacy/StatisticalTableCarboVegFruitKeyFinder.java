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
public class StatisticalTableCarboVegFruitKeyFinder implements
        StatisticalTableKeyFinder {

    public StatisticalTableCarboVegFruitKeyFinder() {
        super();

    }

    public Object getKey(MasterFood masterFood) {

        Object result;
        result = masterFood.getCarboVegFruit();
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