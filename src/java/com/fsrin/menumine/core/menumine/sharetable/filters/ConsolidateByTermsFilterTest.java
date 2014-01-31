/*
 * Created on Apr 10, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.sharetable.filters;

import java.util.ArrayList;
import java.util.Collection;

import com.fsrin.menumine.core.menumine.FieldEnum;
import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableElementIF;
import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableElementIFBuilder;
import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableIF;

public class ConsolidateByTermsFilterTest extends
        AbstractFilterTest {

    public void testBasic() throws Exception {
        
        
            FilteredTable t = new FilteredTable();
            Collection rows = new ArrayList();
            t.setRows(rows);
            t.setFieldEnum(FieldEnum.BASIC_PROTEIN);
            t.setSizeOfSample(new Long(10));
            
            rows.add(StatisticalTableElementIFBuilder.build(t, "beef steak", 5));
            rows.add(StatisticalTableElementIFBuilder.build(t, "ribeye steak", 2));
            rows.add(StatisticalTableElementIFBuilder.build(t, "pork chop", 2));
            
            assertEquals(3, t.getRows().size());
            
            ConsolidateByTermsFilter filter = new ConsolidateByTermsFilter();
            filter.setKeywords("steak");
            filter.execute(t);
            
            StatisticalTableIF results = filter.getResults();
            
            log.info("results size " + results.getRows().size());
            
            log.info("one name " + ((StatisticalTableElementIF) results.getRows().toArray()[0]).getName()); 
            assertTrue(results.getRows().size() == 2);
            
            StatisticalTableElementIF first = (StatisticalTableElementIF) results.getRows().toArray()[0];
        
            assertEquals(new Long(7),first.getNumberInSample());
        
    }
    
    public void testSimpleTableTotals() throws Exception {
        
        assertNotNull(this.simpleTable);
        
        int totalBefore = this.simpleTable.getTotal().getNumberInSample().intValue();
        
        
        ConsolidateByTermsFilter filter = new ConsolidateByTermsFilter();
        filter.setKeywords("Beef, Chicken, Pork");
        filter.execute(simpleTable);
        
        StatisticalTableIF results = filter.getResults();
        
        log.info("results size " + results.getRows().size());
        
        assertEquals(totalBefore, results.getTotal().getNumberInSample().intValue());
    }
}
