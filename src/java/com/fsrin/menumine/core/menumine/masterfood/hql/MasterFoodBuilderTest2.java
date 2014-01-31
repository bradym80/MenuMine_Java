/*
 * Created on Jan 23, 2006
 *
 */
package com.fsrin.menumine.core.menumine.masterfood.hql;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fsrin.menumine.common.dao.GenericDAO;
import com.fsrin.menumine.common.dao.GenericDAOFactory;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParametersImpl;
import com.fsrin.menumine.testutil.AbstractNonInitializingMenuMineTestCase;

/**
 * largely for performance testing and experimentation on the run.
 * 
 * Not part of a detailed testing suite.
 * 
 * @author Reid
 *
 */
public class MasterFoodBuilderTest2 extends
        AbstractNonInitializingMenuMineTestCase {

    private static Log log = LogFactory.getLog(MasterFoodBuilderTest2.class);
    
    /*
     * test a quick query.  Execution time for query and object population
     * is about 3 seconds.
     */
    public void testBasicWithQuery() throws Exception {
        
        MasterFoodFilterParameters p = new MasterFoodFilterParametersImpl();
        p.setLimit(new Long(5000));
        Collection and = new ArrayList();
        and.add("chicken");
        
        p.getBasicProtein().setAndValues(and);
        p.getBasicProtein().setSelect(true);
        
        /*
         * 2006-
         */
        p.getItemDescription().setSelect(true);
        
        StringBuffer q = new MasterFoodQueryBuilder().getConjunctiveQueryWithSelectedFields(p);
        
        GenericDAO dao = GenericDAOFactory.factory.buildData();
        
        log.info("Query " + q.toString());
        
        Collection c = dao.find(q.toString(), p.getLimit().intValue());
        
        assertNotNull(c);
        
        log.info("results size is " + c.size());
        
        Collection built = new MasterFoodBuilder().buildFromObjectCollection(c,p);
        
        assertEquals(c.size(),built.size());
        
        
    }
    
    public void testBasicWithQuery_SingleFieldSelected() throws Exception {
        
        MasterFoodFilterParameters p = new MasterFoodFilterParametersImpl();
        p.setLimit(new Long(5000));
        Collection and = new ArrayList();
        and.add("chicken");
        
        p.getBasicProtein().setAndValues(and);
        p.getBasicProtein().setSelect(true);
        

        
        StringBuffer q = new MasterFoodQueryBuilder().getConjunctiveQueryWithSelectedFields(p);
        
        GenericDAO dao = GenericDAOFactory.factory.buildData();
        
        log.info("Query " + q.toString());
        
        Collection c = dao.find(q.toString(), p.getLimit().intValue());
        
        assertNotNull(c);
        
        log.info("results size is " + c.size());
        
        Collection built = new MasterFoodBuilder().buildFromObjectCollection(c,p);
        
        assertEquals(c.size(),built.size());
        
        
    }
    /*
     * basic benchmark is that with 6 fields it takes 13 seconds and 17mb.
     * 
     * note that if you remove item description, total query time drops by 2 seconds
     * and space consumptions also drops.  Dramatically.
     */
    public void testWithLargerQueryAndMoreResults() throws Exception {
        
        Runtime r = Runtime.getRuntime();
        
        r.gc();
        
        long before = r.freeMemory();
        long totalBefore = r.totalMemory();
        
        MasterFoodFilterParameters p = new MasterFoodFilterParametersImpl();
        
        p.getBasicProtein().setSelect(true);
        p.getMenuItem().setSelect(true);
        p.getBrand().setSelect(true);
        p.getCarboMM().setSelect(true);
        p.getCheeseMM().setSelect(true);
        p.getItemDescription().setSelect(true);
        
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
         * 2006-01-23 RSC now lets do the object conversion
         * 
         */
        Collection objects = new MasterFoodBuilder().buildFromObjectCollection(c, p);
        
        
        r.gc();
        
        long after = r.freeMemory();
        long totalAfter = r.totalMemory();
        
        log.info("memory consumed " + ((before - after)/1024));
        log.info("freeafter is " + (after/1024/1024) + " totalafter is " + (totalAfter/1024/1024));
        log.info("freebefore is " + (before/1024/1024) + "totalbefore is " + (totalBefore/1024/1024));           
    }
}
