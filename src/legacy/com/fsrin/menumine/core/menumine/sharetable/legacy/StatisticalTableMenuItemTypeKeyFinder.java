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
public class StatisticalTableMenuItemTypeKeyFinder implements
        StatisticalTableKeyFinder {

    public StatisticalTableMenuItemTypeKeyFinder() {
        super();

    }

    public Object getKey(MasterFood masterFood) {
        Object result;
        result = masterFood.getMenuItemType();

        if (result == null) {
            return "Not On Menu";
        }
        return result;
    }

}