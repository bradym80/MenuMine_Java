/*
 * Created on Jan 27, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.sharetable;

import java.util.ArrayList;
import java.util.Collection;

import com.fsrin.menumine.core.menumine.rollup.RollUpOptions;
import com.fsrin.menumine.core.menumine.webwork.MenuMineGraphOptions;
import com.fsrin.menumine.testutil.AbstractNonInitializingMenuMineTestCase;
import com.fsrin.menumine.util.GroupCounterVO;

public class StatisticalTableAggregationImplTest extends
        AbstractNonInitializingMenuMineTestCase {

    /*
     * just does a test on the basic method of building.
     */
    public void testBasic() throws Exception {

        GroupCounterVO one = new GroupCounterVO(new Integer(5), "one");
        GroupCounterVO two = new GroupCounterVO(new Integer(15), "two");

        Collection c = new ArrayList();
        c.add(one);
        c.add(two);

        MenuMineGraphOptions graphOptions = new MenuMineGraphOptions();

        RollUpOptions rollUpOptions = new RollUpOptions();

        StatisticalTableIF t = new StatisticalTableBuilder()
                .buildStatisticalTable_FromAggregation(c, graphOptions,
                        rollUpOptions);

        assertEquals(20,t.getTotal().getSizeOfSample().intValue());
        
        Collection table = t.getRows();
        
        assertEquals("two",((StatisticalTableElementIF)table.toArray()[1]).getName());
        assertEquals(15, ((StatisticalTableElementIF)table.toArray()[1]).getNumberInSample().intValue());
        assertEquals(20, ((StatisticalTableElementIF)table.toArray()[1]).getSizeOfSample().intValue());
        assertEquals(75.0, ((StatisticalTableElementIF)table.toArray()[1]).getPercent().doubleValue(),0.01);
        

        assertEquals("one",((StatisticalTableElementIF)table.toArray()[0]).getName());
        assertEquals(5, ((StatisticalTableElementIF)table.toArray()[0]).getNumberInSample().intValue());
        assertEquals(20, ((StatisticalTableElementIF)table.toArray()[0]).getSizeOfSample().intValue());
        assertEquals(25.0, ((StatisticalTableElementIF)table.toArray()[0]).getPercent().doubleValue(),0.01);
    }
}
