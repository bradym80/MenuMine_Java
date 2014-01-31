/*
 * Created on Mar 30, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.sharetable;

import com.fsrin.menumine.core.menumine.masterfood.MasterFood;

/**
 * @author Nick
 * 
 *  
 */
public abstract class AbstractStatisticalTableKeyFinder implements
        StatisticalTableKeyFinder {

    public AbstractStatisticalTableKeyFinder() {
        super();

    }

    public Object getKey(MasterFood masterFood) {
        Object result;
        result = findKey(masterFood);

        if (result == null) {
            return NOT_ON_MENU;
        }
        return result;
    }

    protected abstract Object findKey(MasterFood masterFood);
}