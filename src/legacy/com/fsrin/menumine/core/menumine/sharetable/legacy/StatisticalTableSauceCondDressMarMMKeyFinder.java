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
public class StatisticalTableSauceCondDressMarMMKeyFinder implements
        StatisticalTableKeyFinder {

    public StatisticalTableSauceCondDressMarMMKeyFinder() {
        super();

    }

    public Object getKey(MasterFood masterFood) {

        return masterFood.getSauceCondDressMarMM();
    }

}