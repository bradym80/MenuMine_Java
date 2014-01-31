/*
 * Created on Mar 24, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.sharetable;

import com.fsrin.menumine.util.GroupCounterTotaller;

public class StatisticalTableTotalDecorator {

    public static final String TOTALS = "Totals";

    public void decorateWithTotal(StatisticalTableIF input) {

        StatisticalTableElementAggregationImpl totals = new StatisticalTableElementAggregationImpl();
        
        totals.setPercent(new Double(100.0));
        totals.setNumberInSample(new Long(new GroupCounterTotaller().getTotal(
                input.getRows()).longValue()));
        totals.setSizeOfSample(totals.getNumberInSample());
        totals.setName(TOTALS);
        input.setTotal(totals);
        
        
        
    }

}
