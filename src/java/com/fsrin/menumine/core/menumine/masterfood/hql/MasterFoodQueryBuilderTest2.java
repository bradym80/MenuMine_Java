/*
 * Created on Jan 21, 2006
 *
 */
package com.fsrin.menumine.core.menumine.masterfood.hql;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fsrin.menumine.common.dao.GenericDAO;
import com.fsrin.menumine.common.dao.GenericDAOFactory;
import com.fsrin.menumine.core.menumine.FieldEnum;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParametersImpl;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParametersTestFactory;
import com.fsrin.menumine.testutil.AbstractNonInitializingMenuMineTestCase;
import com.fsrin.menumine.testutil.TimerUtil;

/**
 * this test is more with the database and the rest of the infrastructure,
 * not just concatenation.
 * @author Reid
 *
 */
public class MasterFoodQueryBuilderTest2 extends
        AbstractNonInitializingMenuMineTestCase {

    private static final Log log = LogFactory.getLog(MasterFoodQueryBuilderTest2.class);
    
    /*
     * this query should take about 5 seconds
     */
    public void testBasicQuery() throws Exception {
        
        Runtime r = Runtime.getRuntime();
        
        r.gc();
        
        long before = r.freeMemory();
        long totalBefore = r.totalMemory();
        
        MasterFoodFilterParameters p = new MasterFoodFilterParametersImpl();
        
        Collection and = new ArrayList();
        and.add("chicken");
        
        p.getBasicProtein().setAndValues(and);
        
        StringBuffer q = new MasterFoodQueryBuilder().getConjunctiveQueryWithSelectedFields(p);
        
        GenericDAO dao = GenericDAOFactory.factory.buildData();
        
        log.info("Query " + q.toString());
        
        Collection c = dao.find(q.toString());
        
        assertNotNull(c);
        
        log.info("results size is " + c.size());
        
        /*
         * 2006-01-21 RSC there are tons of these.
         */
        assertTrue(c.size() > 14000);
        
        r.gc();
        
        long after = r.freeMemory();
        long totalAfter = r.totalMemory();
        
        log.info("memory consumed " + ((before - after)/1024));
        log.info("freeafter is " + (after/1024/1024) + " totalafter is " + (totalAfter/1024/1024));
        log.info("freebefore is " + (before/1024/1024) + "totalbefore is " + (totalBefore/1024/1024));        
    }
    
    public void testBasicQuery_WithMoreSelections() throws Exception {
        
        Runtime r = Runtime.getRuntime();
        
        r.gc();
        
        long before = r.freeMemory();
        long totalBefore = r.totalMemory();
        
        MasterFoodFilterParameters p = new MasterFoodFilterParametersImpl();
        
        p.getBasicProtein().setSelect(true);
        p.getMenuItem().setSelect(true);
        p.getBrand().setSelect(true);
        p.getCarboMM().setSelect(true);
        
        Collection and = new ArrayList();
        and.add("chicken");
        
        p.getBasicProtein().setAndValues(and);
        
        StringBuffer q = new MasterFoodQueryBuilder().getConjunctiveQueryWithSelectedFields(p);
        
        GenericDAO dao = GenericDAOFactory.factory.buildData();
        
        log.info("Query " + q.toString());
        
        Collection c = dao.find(q.toString());
        
        assertNotNull(c);
        
        log.info("results size is " + c.size());
        
        /*
         * 2006-01-21 RSC there are tons of these.
         */
        assertTrue(c.size() > 14000);
        
        r.gc();
        
        long after = r.freeMemory();
        long totalAfter = r.totalMemory();
        
        log.info("memory consumed " + ((before - after)/1024));
        log.info("freeafter is " + (after/1024/1024) + " totalafter is " + (totalAfter/1024/1024));
        log.info("freebefore is " + (before/1024/1024) + "totalbefore is " + (totalBefore/1024/1024));        
    }    
    
    public void testCountyQuery() throws Exception {
        
        Runtime r = Runtime.getRuntime();
        
        r.gc();
        
        long before = r.freeMemory();
        long totalBefore = r.totalMemory();
        
        MasterFoodFilterParameters p = new MasterFoodFilterParametersImpl();
        
        p.getBasicProtein().setSelect(true);
        p.getMenuItem().setSelect(true);
        p.getBrand().setSelect(true);
        p.getCarboMM().setSelect(true);
        
        Collection and = new ArrayList();
        and.add("chicken");
        
        p.getBasicProtein().setAndValues(and);
        
        StringBuffer q = new MasterFoodQueryBuilder().getConjunctiveQueryWithSelectedFields(p);
        
        GenericDAO dao = GenericDAOFactory.factory.buildData();
        
        log.info("Query " + q.toString());
        
        Collection c = dao.find(q.toString());
        
        assertNotNull(c);
        
        log.info("results size is " + c.size());
        
/*
 * now do a get count.
 */
        
        StringBuffer count = new MasterFoodQueryBuilder().getQueryForCount(p);
        
        log.info("count query " + count);
        
        Collection cCount = dao.find(count.toString());
        
        assertEquals(1, cCount.size());
        
        log.info("counted size is " + cCount.toArray()[0]);
        
        assertEquals(c.size(), ((Integer) cCount.toArray()[0]).intValue());
        
        r.gc();
        
        long after = r.freeMemory();
        long totalAfter = r.totalMemory();
        
        log.info("memory consumed " + ((before - after)/1024));
        log.info("freeafter is " + (after/1024/1024) + " totalafter is " + (totalAfter/1024/1024));
        log.info("freebefore is " + (before/1024/1024) + "totalbefore is " + (totalBefore/1024/1024));        
    }        
    
    public void testBasicQuery_WithMoreSelections_TwoQueries() throws Exception {
        
        Runtime r = Runtime.getRuntime();
        
        r.gc();
        
        long before = r.freeMemory();
        long totalBefore = r.totalMemory();
        
        MasterFoodFilterParameters p = new MasterFoodFilterParametersImpl();
        
        p.getBasicProtein().setSelect(true);
        p.getMenuItem().setSelect(true);
        p.getBrand().setSelect(true);
        p.getCarboMM().setSelect(true);
        
        Collection and = new ArrayList();
        and.add("chicken");
        
        p.getBasicProtein().setAndValues(and);
        
        StringBuffer q = new MasterFoodQueryBuilder().getConjunctiveQueryWithSelectedFields(p);
        
        GenericDAO dao = GenericDAOFactory.factory.buildData();
        
        log.info("Query " + q.toString());
        
        Collection c = dao.find(q.toString());
        
        assertNotNull(c);
        
        log.info("results size is " + c.size());
        
        /*
         * 2006-01-21 RSC there are tons of these.
         */
        assertTrue(c.size() > 14000);
        
        /*
         * second query
         */
        
        MasterFoodFilterParameters p2 = new MasterFoodFilterParametersImpl();
        
        p2.getBasicProtein().setSelect(true);
        p2.getMenuItem().setSelect(true);
        p2.getBrand().setSelect(true);
        p2.getCarboMM().setSelect(true);
        
        Collection and2 = new ArrayList();
        and2.add("beef");
        
        p2.getBasicProtein().setAndValues(and2);
        
        StringBuffer q2 = new MasterFoodQueryBuilder().getConjunctiveQueryWithSelectedFields(p2);
        
        GenericDAO dao2 = GenericDAOFactory.factory.buildData();
        
        log.info("Query " + q2.toString());
        
        Collection c2 = dao2.find(q2.toString());
        
        assertNotNull(c2);
        
        log.info("results size is " + c2.size());        
        
        r.gc();
        
        long after = r.freeMemory();
        long totalAfter = r.totalMemory();
        
        log.info("memory consumed " + ((before - after)/1024));
        log.info("freeafter is " + (after/1024/1024) + " totalafter is " + (totalAfter/1024/1024));
        log.info("freebefore is " + (before/1024/1024) + "totalbefore is " + (totalBefore/1024/1024));        
    }        
    
    /*
     * this query with full records will take about 45 seconds.
     * 
     * routinely runs out of memory.
     * 
     * how about memory?
     */
//    public void testBasicQuery_WithFullRecords() throws Exception {
//        
//        Runtime r = Runtime.getRuntime();
//        
//        r.gc();
//        
//        long before = r.freeMemory();
//        long totalBefore = r.totalMemory();
//        
//        MasterFoodFilterParameters p = new MasterFoodFilterParametersImpl();
//        
//        Collection and = new ArrayList();
//        and.add("chicken");
//        
//        p.getBasicProtein().setAndValues(and);
//        
//        StringBuffer q = new MasterFoodQueryBuilder().getQueryWithAllFields(p);
//        
//        GenericDAO dao = GenericDAOFactory.factory.buildData();
//        
//        log.info("Query " + q.toString());
//        
//        Collection c = dao.find(q.toString());
//        
//        assertNotNull(c);
//        
//        log.info("results size is " + c.size());
//        
//        /*
//         * 2006-01-21 RSC there are tons of these.
//         */
//        assertTrue(c.size() > 14000);
//        
//        r.gc();
//        
//        long after = r.freeMemory();
//        long totalAfter = r.totalMemory();
//        
//        log.info("memory consumed " + ((before - after)/1024));
//        log.info("freeafter is " + (after/1024/1024) + " totalafter is " + (totalAfter/1024/1024));
//        log.info("freebefore is " + (before/1024/1024) + "totalbefore is " + (totalBefore/1024/1024));
//        
//    }
    
    /*
     * 2006-02-08 RSC Routinely runs out of memory.
     */

//    public void testBasicQuery_WithFullRecords_TwoQueries() throws Exception {
//        
//        Runtime r = Runtime.getRuntime();
//        
//        r.gc();
//        
//        long before = r.freeMemory();
//        long totalBefore = r.totalMemory();
//        
//        MasterFoodFilterParameters p = new MasterFoodFilterParametersImpl();
//        
//        Collection and = new ArrayList();
//        and.add("chicken");
//        
//        p.getBasicProtein().setAndValues(and);
//        
//        StringBuffer q = new MasterFoodQueryBuilder().getQueryWithAllFields(p);
//        
//        GenericDAO dao = GenericDAOFactory.factory.buildData();
//        
//        log.info("Query " + q.toString());
//        
//        Collection c = dao.find(q.toString());
//        
//        assertNotNull(c);
//        
//        log.info("results size is " + c.size());
//        
//        /*
//         * 2006-01-21 RSC there are tons of these.
//         */
//        assertTrue(c.size() > 14000);
//        
//        /*
//         * 2006-01-23 Now Do Query Two
//         */
//        MasterFoodFilterParameters p2 = new MasterFoodFilterParametersImpl();
//        
//        Collection and2 = new ArrayList();
//        and2.add("beef");
//        
//        p2.getBasicProtein().setAndValues(and2);
//        
//        StringBuffer q2 = new MasterFoodQueryBuilder().getQueryWithAllFields(p2);
//        
//        GenericDAO dao2 = GenericDAOFactory.factory.buildData();
//        
//        log.info("Query " + q2.toString());
//        
//        Collection c2 = dao2.find(q2.toString());
//        
//        assertNotNull(c2);        
//        
//        
//        r.gc();
//        
//        long after = r.freeMemory();
//        long totalAfter = r.totalMemory();
//        
//        log.info("TWO Queries." +
//                "memory consumed " + ((before - after)/1024));
//        log.info("freeafter is " + (after/1024/1024) + " totalafter is " + (totalAfter/1024/1024));
//        log.info("freebefore is " + (before/1024/1024) + "totalbefore is " + (totalBefore/1024/1024));
//        
//    }
    
    public void testBasicQueryWithLimit() throws Exception {
        
        MasterFoodFilterParameters p = new MasterFoodFilterParametersImpl();
        p.setLimit(new Long(5000));
        Collection and = new ArrayList();
        and.add("chicken");
        
        p.getBasicProtein().setAndValues(and);
        
        StringBuffer q = new MasterFoodQueryBuilder().getConjunctiveQueryWithSelectedFields(p);
        
        GenericDAO dao = GenericDAOFactory.factory.buildData();
        
        log.info("Query " + q.toString());
        
        Collection c = dao.find(q.toString(), p.getLimit().intValue());
        
        assertNotNull(c);
        
        log.info("results size is " + c.size());
        
        /*
         * 2006-01-21 RSC there are tons of these.
         */
        assertTrue(c.size()== 5000);
        
    }
    

    
    public void testWithMultipleTerms_ItemDescription() throws Exception {

        MasterFoodFilterParameters p = new MasterFoodFilterParametersImpl();

        Collection and = new ArrayList();
        and.add("chicken");
        and.add("cheese");
        and.add("tarragon");
        
        p.getItemDescription().setAndValues(and);
        p.getBasicProtein().setSelect(true);
        p.getItemDescription().setSelect(true);
        p.getGenMenuPart().setSelect(true);
        
        StringBuffer q = new MasterFoodQueryBuilder().getConjunctiveQueryWithSelectedFields(p);
        
        GenericDAO dao = GenericDAOFactory.factory.buildData();
        
        log.info("Query " + q.toString());
        
        TimerUtil query = TimerUtil.getInstanceAndStart("query");
        Collection c = dao.find(q.toString());
        query.stop();
        
        assertNotNull(c);
        
        log.info("results size is " + c.size());
        assertTrue(c.size() > 0);
        
        Object[] first = (Object[]) c.toArray()[0];

        assertEquals(3,first.length);
    }
    
    public void testWithMultipleTerms_ItemDescription_2() throws Exception {

        MasterFoodFilterParameters p = new MasterFoodFilterParametersImpl();

        Collection and = new ArrayList();
        and.add("cheese");        
        p.getItemDescription().setAndValues(and);
        
        Collection or = new ArrayList();
        or.add("beef");
        or.add("chicken");
        p.getItemDescription().setOrValues(or);

        Collection not = new ArrayList();
        not.add("onion");
        not.add("shrimp");
        p.getItemDescription().setNotValues(not);
        
        p.getBasicProtein().setSelect(true);
        p.getItemDescription().setSelect(true);
        p.getGenMenuPart().setSelect(true);
        
        StringBuffer q = new MasterFoodQueryBuilder().getConjunctiveQueryWithSelectedFields(p);
        
        GenericDAO dao = GenericDAOFactory.factory.buildData();
        
        log.info("Query " + q.toString());
        
        TimerUtil query = TimerUtil.getInstanceAndStart("query");
        Collection c = dao.find(q.toString());
        query.stop();
        
        assertNotNull(c);
        
        log.info("results size is " + c.size());
        assertTrue(c.size() > 0);
        
        Object[] first = (Object[]) c.toArray()[0];

        assertEquals(3,first.length);
    }
    
    public void testQueryForMeanPriceTrend() throws Exception {
        
        MasterFoodFilterParameters p = MasterFoodFilterParametersTestFactory.getItemDescriptionWithBacon();
        
        StringBuffer q = new MasterFoodQueryBuilder().getQueryForMeanPriceTrend(FieldEnum.BASIC_PROTEIN, p);
        
        assertTrue(q.indexOf("GROUP BY") > -1);
        
        Collection raw = GenericDAOFactory.factory.buildData().find(q.toString());
        
        assertNotNull(raw);
        
        Object[] one = (Object[]) raw.toArray()[0];
        
        /*
         * 2006-08-17 reid@fivesticks.com increases whenever we add a year.
         */
        assertEquals(13,one.length);
        
        assertTrue(one[2] instanceof Double);
       
    }
    

}
