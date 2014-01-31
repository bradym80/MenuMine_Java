/*
 * Created on Apr 10, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.sharetable.filters;

import java.util.Iterator;

import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableElementAggregationImpl;
import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableElementIF;
import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableIF;

public class KeywordRowFilterTest extends AbstractFilterTest {

    /*
     * test the method that matches rows based on any keyword.
     */
    public void testBasicRowMatch() throws Exception {

        StatisticalTableElementAggregationImpl e = new StatisticalTableElementAggregationImpl();
        e.setName("name one two three");

        String[] shouldMatchA = { "two" };
        String[] shouldMatchB = { "fred", "george", "mundane", "name" };
        String[] shouldNotMatch = { "bubbles", "dog", "snarf" };

        assertTrue(new KeywordRowFilter().isKeywordMatch(e, shouldMatchA));
        assertTrue(new KeywordRowFilter().isKeywordMatch(e, shouldMatchB));
        assertTrue(!new KeywordRowFilter().isKeywordMatch(e, shouldNotMatch));
    }

    public void testBasicMatch() throws Exception {

        assertTrue(this.simpleTable != null);
        log.info("rows " + simpleTable.getRows().size());
        
        int beefCount = 0;
        
        for (Iterator iter = simpleTable.getRows().iterator(); iter.hasNext();) {
            StatisticalTableElementIF element = (StatisticalTableElementIF) iter.next();
            
            if (element.getName().toLowerCase().indexOf("beef") != -1) {
                beefCount++;
            }
        }
        
        log.info("beef count is " + beefCount);
        
        KeywordRowFilter filter = new KeywordRowFilter();
        filter.setCombinedName("name");
        filter.setEliminate(true);
        filter.setKeywords("beef");
        filter.execute(simpleTable);
        
        StatisticalTableIF r = filter.getResults();
        
        log.info("filter results rows " + r.getRows().size());
        
        assertEquals(simpleTable.getRows().size(), r.getRows().size() + beefCount);
        
    }
}
