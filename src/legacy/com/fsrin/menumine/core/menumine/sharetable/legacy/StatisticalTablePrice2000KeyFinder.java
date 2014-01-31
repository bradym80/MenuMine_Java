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
public class StatisticalTablePrice2000KeyFinder implements
        StatisticalTableKeyFinder {

    public StatisticalTablePrice2000KeyFinder() {
        super();

    }

    public Object getKey(MasterFood masterFood) {
        Object result;
        result = masterFood.getPrice2000();

        if (result == null) {
            return "Not On Menu";
        }
        return result;
    }

}