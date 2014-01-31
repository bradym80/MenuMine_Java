/*
 * Created on Apr 10, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.sharetable.filters;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.fsrin.menumine.core.menumine.FieldEnum;
import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableElementIF;
import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableElementIFBuilder;
import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableIF;
import com.fsrin.menumine.testutil.AbstractNonInitializingMenuMineTestCase;

/**
 * this is a little more detailed test with a manually created table 
 * to ensure that things are working as planned.
 * 
 * @author Reid
 */
public class CommonTermsFilterTest2 extends AbstractNonInitializingMenuMineTestCase {

    /**
     * tests to be sure just terms are filtered out.
     * @throws Exception
     */
    public void testBasic() throws Exception {
        FilteredTable t = new FilteredTable();
        Collection rows = new ArrayList();
        t.setRows(rows);
        t.setFieldEnum(FieldEnum.BASIC_PROTEIN);
        t.setSizeOfSample(new Long(10));
        
        rows.add(StatisticalTableElementIFBuilder.build(t, "beef steak", 5));
        rows.add(StatisticalTableElementIFBuilder.build(t, "ribeye steak", 2));
        
        assertEquals(2, t.getRows().size());
        
        CommonTermsFilter filter = new CommonTermsFilter();
        filter.setKeywords("steak");
        filter.execute(t);
        
        StatisticalTableIF results = filter.getResults();
        
        log.info("results size " + results.getRows().size());
        
        log.info("one name " + ((StatisticalTableElementIF) results.getRows().toArray()[0]).getName()); 
        assertTrue(results.getRows().size() == 2);
    }
    
    public void testCombinationRecords() throws Exception {
        FilteredTable t = new FilteredTable();
        Collection rows = new ArrayList();
        t.setRows(rows);
        t.setFieldEnum(FieldEnum.BASIC_PROTEIN);
        t.setSizeOfSample(new Long(10));
        
        rows.add(StatisticalTableElementIFBuilder.build(t, "beef/pork/turkey", 5));
        
        
        CommonTermsFilter filter = new CommonTermsFilter();
        filter.setKeywords("beef");
        filter.execute(t);
        
        StatisticalTableIF results = filter.getResults();
        
        log.info("results size " + results.getRows().size());
        
        assertTrue(results.getRows().size() == 1);
        
        StatisticalTableElementIF one = (StatisticalTableElementIF) rows.toArray()[0];
        
        assertEquals("pork/turkey", one.getName());
        
    }
    
    /*
     * 2006-04-13 RSC Was leaving trailing slashes.
     */
    public void testCombinationRecordsRemoveEndTerm() throws Exception {
        FilteredTable t = new FilteredTable();
        Collection rows = new ArrayList();
        t.setRows(rows);
        t.setFieldEnum(FieldEnum.BASIC_PROTEIN);
        t.setSizeOfSample(new Long(10));
        
        rows.add(StatisticalTableElementIFBuilder.build(t, "beef/pork/turkey", 5));
        
        
        CommonTermsFilter filter = new CommonTermsFilter();
        filter.setKeywords("turkey");
        filter.execute(t);
        
        StatisticalTableIF results = filter.getResults();
        
        log.info("results size " + results.getRows().size());
        
        assertTrue(results.getRows().size() == 1);
        
        StatisticalTableElementIF one = (StatisticalTableElementIF) rows.toArray()[0];
        
        log.info("one's name is " + one.getName());
        
        assertEquals("beef/pork", one.getName());
        
    }
    
    public void testCombinationRecordsRemoveEndTerms() throws Exception {
        FilteredTable t = new FilteredTable();
        Collection rows = new ArrayList();
        t.setRows(rows);
        t.setFieldEnum(FieldEnum.BASIC_PROTEIN);
        t.setSizeOfSample(new Long(10));
        
        rows.add(StatisticalTableElementIFBuilder.build(t, "beef/pork/turkey", 5));
        
        
        CommonTermsFilter filter = new CommonTermsFilter();
        filter.setKeywords("turkey, pork");
        filter.execute(t);
        
        StatisticalTableIF results = filter.getResults();
        
        log.info("results size " + results.getRows().size());
        
        assertTrue(results.getRows().size() == 1);
        
        StatisticalTableElementIF one = (StatisticalTableElementIF) rows.toArray()[0];
        
        log.info("one's name is " + one.getName());
        
        assertEquals("beef", one.getName());
        
    }
    
    public void testBasicWithThree() throws Exception {
        FilteredTable t = new FilteredTable();
        Collection rows = new ArrayList();
        t.setRows(rows);
        t.setFieldEnum(FieldEnum.BASIC_PROTEIN);
        t.setSizeOfSample(new Long(10));
        
        rows.add(StatisticalTableElementIFBuilder.build(t, "beef steak", 5));
        rows.add(StatisticalTableElementIFBuilder.build(t, "ribeye steak", 2));
        rows.add(StatisticalTableElementIFBuilder.build(t, "ribeye steak one", 2));
        
        assertEquals(3, t.getRows().size());
        
        CommonTermsFilter filter = new CommonTermsFilter();
        filter.setKeywords("steak one");
        filter.execute(t);
        
        StatisticalTableIF results = filter.getResults();
        
        log.info("results size " + results.getRows().size());
        
        log.info("one name " + ((StatisticalTableElementIF) results.getRows().toArray()[0]).getName()); 
        assertTrue(results.getRows().size() == 2);
    }
    
    public void testWithCombinationRecords() throws Exception {
        FilteredTable t = new FilteredTable();
        Collection rows = new ArrayList();
        t.setRows(rows);
        t.setFieldEnum(FieldEnum.BASIC_PROTEIN);
        t.setSizeOfSample(new Long(10));
        
        rows.add(StatisticalTableElementIFBuilder.build(t, "beef", 5));
        rows.add(StatisticalTableElementIFBuilder.build(t, "pork/beef", 2));
        rows.add(StatisticalTableElementIFBuilder.build(t, "fish/beef", 2));
        
        assertEquals(3, t.getRows().size());
        
        CommonTermsFilter filter = new CommonTermsFilter();
        filter.setKeywords("pork");
        filter.execute(t);
        
        StatisticalTableIF results = filter.getResults();
        
        log.info("results size " + results.getRows().size());
        
        log.info("one name " + ((StatisticalTableElementIF) results.getRows().toArray()[0]).getName()); 
        assertTrue(results.getRows().size() == 2);
        
        for (Iterator iter = results.getRows().iterator(); iter.hasNext();) {
            StatisticalTableElementIF element = (StatisticalTableElementIF) iter.next();
            log.info(element.getName());
        }
    }
    
    public void testWithCombinationRecordsDoubleKeywords() throws Exception {
        FilteredTable t = new FilteredTable();
        Collection rows = new ArrayList();
        t.setRows(rows);
        t.setFieldEnum(FieldEnum.BASIC_PROTEIN);
        t.setSizeOfSample(new Long(10));
        
        rows.add(StatisticalTableElementIFBuilder.build(t, "beef", 5));
        rows.add(StatisticalTableElementIFBuilder.build(t, "pork/beef", 2));
        rows.add(StatisticalTableElementIFBuilder.build(t, "fish/beef", 2));
        
        assertEquals(3, t.getRows().size());
        
        CommonTermsFilter filter = new CommonTermsFilter();
        filter.setKeywords("pork, fish");
        filter.execute(t);
        
        StatisticalTableIF results = filter.getResults();
        
        log.info("results size " + results.getRows().size());
        
         
        assertTrue(results.getRows().size() == 1);
        
        for (Iterator iter = results.getRows().iterator(); iter.hasNext();) {
            StatisticalTableElementIF element = (StatisticalTableElementIF) iter.next();
            assertEquals(element.getSizeOfSample(),new Long(9));
            log.info(element.getName());
        }
    }
}
