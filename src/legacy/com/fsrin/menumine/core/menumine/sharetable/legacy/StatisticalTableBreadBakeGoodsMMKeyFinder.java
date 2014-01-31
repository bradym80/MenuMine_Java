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
public class StatisticalTableBreadBakeGoodsMMKeyFinder implements
        StatisticalTableKeyFinder {

    public StatisticalTableBreadBakeGoodsMMKeyFinder() {
        super();

    }

    public Object getKey(MasterFood masterFood) {

        Object result;
        result = masterFood.getBreadBakeGoodsMM();
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