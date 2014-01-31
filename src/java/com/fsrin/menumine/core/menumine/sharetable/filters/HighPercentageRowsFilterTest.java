/*
 * Created on Mar 24, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.sharetable.filters;

import java.util.Iterator;

import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableElementIF;
import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableIF;

public class HighPercentageRowsFilterTest extends AbstractFilterTest {

    public void testBasicCombine() throws Exception {

        log.info("Table size is " + table.getRows().size());

        log.info("Total count is " + table.getSizeOfSample());

        assertTrue(table.getSizeOfSample().intValue() > 4000);

        HighPercentageRowsFilter filter = new HighPercentageRowsFilter();
        filter.setCombinationThreshhold(3.0);
        filter.execute(table);

        StatisticalTableIF result = filter.getResults();

        log.info("result row size is " + result.getRows().size());
        assertTrue(result.getRows().size() < table.getRows().size());

        assertEquals(result.getTotal().getSizeOfSample(), table.getTotal()
                .getSizeOfSample());

        for (Iterator iter = result.getRows().iterator(); iter.hasNext();) {
            StatisticalTableElementIF element = (StatisticalTableElementIF) iter
                    .next();
            log.info("size and percent is " + element.getNumberInSample()
                    + " or " + element.getPercent());
            if (element.getName().indexOf("Threshold") == -1)
                assertTrue(element.getPercent().doubleValue() < 3.0);

        }
    }

    // public void testBasicEliminate() throws Exception {
    //        
    // log.info("Table size is " + table.getRows().size());
    // log.info("Total count is " + table.getSizeOfSample());
    //        
    // assertTrue(table.getSizeOfSample().intValue() > 4000);
    //        
    // LowPercentageRowsFilter filter = new LowPercentageRowsFilter();
    // filter.setCombinationThreshhold(1.0);
    // filter.setEliminate(true);
    // filter.execute(table);
    //        
    // StatisticalTableIF result = filter.getResults();
    //        
    // assertTrue(result.getRows().size() < table.getRows().size());
    // log.info("result row size is " + result.getRows().size());
    //        
    // assertTrue(result.getTotal().getSizeOfSample() <
    // table.getTotal().getSizeOfSample());
    //        
    // for (Iterator iter = result.getRows().iterator(); iter.hasNext();) {
    // StatisticalTableElementIF element = (StatisticalTableElementIF)
    // iter.next();
    // assertTrue(element.getPercent().doubleValue() > 1.0);
    // log.info("size and percent is " + element.getNumberInSample() + " or " +
    // element.getPercent() );
    //            
    // }
    // }

}
