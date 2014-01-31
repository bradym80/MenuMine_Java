/*
 * Created on Mar 30, 2005
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
public class StatisticalTableSectorNameKeyFinder implements
        StatisticalTableKeyFinder {

    public StatisticalTableSectorNameKeyFinder() {
        super();

    }

    public Object getKey(MasterFood masterFood) {
        Object result;
        if (masterFood.getChain() == null) {
            return NOT_ON_MENU;
        }
        result = masterFood.getChain().getSectorName();

        if (result == null) {
            return NOT_ON_MENU;
        }
        return result;
    }

}