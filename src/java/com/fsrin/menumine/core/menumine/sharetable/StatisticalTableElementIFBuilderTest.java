/*
 * Created on Feb 3, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.sharetable;

import junit.framework.TestCase;

import com.fsrin.menumine.core.menumine.FieldEnum;
import com.fsrin.menumine.core.menumine.sharetable.filters.FilteredTable;

public class StatisticalTableElementIFBuilderTest extends TestCase {

    public void testBasic() throws Exception {
        
        FilteredTable t = new FilteredTable();
        t.setSizeOfSample(new Long(5000));
        
        StatisticalTableElementAggregationImpl one = new StatisticalTableElementAggregationImpl();
        one.setFieldEnum(FieldEnum.BASIC_PROTEIN);
        one.setNumberInSample(new Long(2000));
        one.setSizeOfSample(new Long(5000));
        one.setPercent(new Double(40.0));
        one.setParentTable(t);
        
        
        
        StatisticalTableElementAggregationImpl two = new StatisticalTableElementAggregationImpl();
        two.setNumberInSample(new Long(1000));
        two.setSizeOfSample(new Long(5000));
        two.setPercent(new Double(20.0));
        two.setParentTable(t);
        
        StatisticalTableElementIF three = new StatisticalTableElementIFBuilder().buildCombined("combined name", one, two);
        
        assertEquals(three.getName(),"combined name");
        assertEquals(three.getNumberInSample().longValue(),3000);
        assertEquals(three.getSizeOfSample().longValue(), 5000);
        assertEquals(three.getPercent().doubleValue(), 60.0, 0.1);

        
        
    }
}
