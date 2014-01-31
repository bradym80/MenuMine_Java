/*
 * Created on Feb 3, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.sharetable;

import junit.framework.TestCase;

public class StatisticalTablePriceDataBuilderTest extends TestCase {

    public void testBasic() throws Exception {
        
        StatisticalTablePriceDataAggregationImpl p1 = new StatisticalTablePriceDataAggregationImpl();
        p1.setAveragePrice1996(new Double(5.0));
        
        StatisticalTablePriceDataAggregationImpl p2 = new StatisticalTablePriceDataAggregationImpl();
        p1.setAveragePrice1996(new Double(10.0));
        
        StatisticalTablePriceDataIF p3 = new StatisticalTablePriceDataBuilder().buildCombined(p1,10,p2,5);
        
        assertEquals(p3.getAveragePrice1996().doubleValue(),6.67, 0.2);
    }
}
