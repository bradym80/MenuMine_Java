/*
 * Created on Apr 6, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.sharetable.filters;

import java.util.Iterator;

import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableElementIF;
import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableIF;

public class CommonTermsFilterTest extends AbstractFilterTest {

    public void testBasic() throws Exception {

        table = simpleTable;
        
        log.info("Table size is " + table.getRows().size());

        log.info("Total count is " + table.getSizeOfSample());

        assertTrue(table.getSizeOfSample().intValue() > 4000);

        for (Iterator iter = table.getRows().iterator(); iter.hasNext();) {
            StatisticalTableElementIF element = (StatisticalTableElementIF) iter.next();
            log.info(element.getName() + " (" + element.getNumberInSample() + ")");
            
        }
        CommonTermsFilter filter = new CommonTermsFilter();

        filter.setKeywords("fish,seafood");
        filter.execute(table);

        StatisticalTableIF result = filter.getResults();

        log.info("=====SPLIT=====");
        
        
        
        for (Iterator iter = result.getRows().iterator(); iter.hasNext();) {
            StatisticalTableElementIF element = (StatisticalTableElementIF) iter.next();
            log.info(element.getName()  + " (" + element.getNumberInSample() + ")");
            assertTrue(element.getName().toLowerCase().indexOf("fish") == -1);
            assertTrue(element.getName().toLowerCase().indexOf("seafood") == -1);
            
        }
        
        assertEquals(table.getSizeOfSample(), result.getSizeOfSample());

        assertTrue(result.getRows().size() <= table.getRows().size());
    }
}
