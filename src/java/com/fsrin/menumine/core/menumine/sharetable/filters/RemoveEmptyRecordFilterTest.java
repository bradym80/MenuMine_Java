/*
 * Created on Mar 24, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.sharetable.filters;

import java.util.Iterator;

import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableElementIF;
import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableIF;

/**
 * <p>relies on the database.
 * 
 * @author Reid
 */
public class RemoveEmptyRecordFilterTest extends AbstractFilterTest {

    public void testBasic() throws Exception {

        log.info("Table size is " + table.getRows().size());
        log.info("Total count is " + table.getSizeOfSample());

        assertTrue(table.getSizeOfSample().intValue() > 4000);

        RemoveEmptyRecordFilter filter = new RemoveEmptyRecordFilter();
        filter.execute(table);

        StatisticalTableIF results = filter.getResults();

        log.info("total results count is " + results.getSizeOfSample());

        assertTrue(results.getRows().size() == table.getRows().size() - 1);

        /*
         * make sure the element specific rows have the correct new count for
         * the table
         * 
         * 
         */

        for (Iterator iter = results.getRows().iterator(); iter.hasNext();) {
            StatisticalTableElementIF element = (StatisticalTableElementIF) iter
                    .next();
            log.info("element size is " + element.getSizeOfSample());

            assertEquals(element.getSizeOfSample(), results.getSizeOfSample());
        }
    }
}
