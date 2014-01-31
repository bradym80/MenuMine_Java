/*
 * Created on Apr 6, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.sharetable.filters;

import java.util.Iterator;

import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableElementIF;
import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableIF;

public class CombinationRecordFilterTest extends AbstractFilterTest {

    public void testBasicCombine() throws Exception {

        log.info("Table size is " + table.getRows().size());

        log.info("Total count is " + table.getSizeOfSample());

        assertTrue(table.getSizeOfSample().intValue() > 4000);

        CombinationRecordFilter filter = new CombinationRecordFilter();
        
        filter.execute(table);

        StatisticalTableIF result = filter.getResults();

        log.info("result row size is " + result.getRows().size());
        assertTrue(result.getRows().size() < table.getRows().size());

        assertEquals(result.getTotal().getSizeOfSample(), table.getTotal()
                .getSizeOfSample());

        for (Iterator iter = result.getRows().iterator(); iter.hasNext();) {
            StatisticalTableElementIF element = (StatisticalTableElementIF) iter
                    .next();
            log.info(element.getName() + " size and percent is " + element.getNumberInSample()
                    + " or " + element.getPercent());
            if (element.getName().indexOf(filter.getCombinedName()) == -1)
                assertTrue(element.getName().indexOf("/") == -1);

        }
    }
    
    public void testBasicEliminate() throws Exception {

        log.info("Table size is " + table.getRows().size());

        log.info("Total count is " + table.getSizeOfSample());

        assertTrue(table.getSizeOfSample().intValue() > 4000);

        CombinationRecordFilter filter = new CombinationRecordFilter();
        filter.setEliminate(true);
        filter.execute(table);

        StatisticalTableIF result = filter.getResults();

        log.info("result row size is " + result.getRows().size());
        assertTrue(result.getRows().size() < table.getRows().size());

        assertTrue(result.getTotal().getSizeOfSample() < table.getTotal()
                .getSizeOfSample());

        for (Iterator iter = result.getRows().iterator(); iter.hasNext();) {
            StatisticalTableElementIF element = (StatisticalTableElementIF) iter
                    .next();
            log.info("size and percent is " + element.getNumberInSample()
                    + " or " + element.getPercent());
            
                assertTrue(element.getName().indexOf("/") == -1);

                assertTrue(!element.getName().equals(filter.getCombinedName()));
        }
    }
    
}
