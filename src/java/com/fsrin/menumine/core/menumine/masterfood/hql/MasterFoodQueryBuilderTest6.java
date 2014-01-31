/*
 * Created on Feb 8, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.masterfood.hql;

import java.util.Collection;
import java.util.Iterator;

import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParametersTestFactory;
import com.fsrin.menumine.core.menumine.masterfood.MasterFood;
import com.fsrin.menumine.core.menumine.masterfood.MasterFoodServiceDelegateFactory;
import com.fsrin.menumine.testutil.AbstractNonInitializingMenuMineTestCase;

public class MasterFoodQueryBuilderTest6 extends
        AbstractNonInitializingMenuMineTestCase {

    public void testBasicWithIsNotNull() throws Exception {
        
        MasterFoodFilterParameters f = MasterFoodFilterParametersTestFactory.getItemDescriptionWithBacon();
        
        f.getBasicProtein().setSelect(true);
        f.getBrand().setSelect(true);
        
        f.getBrand().setEmpty(Boolean.FALSE);
        
        Collection r = MasterFoodServiceDelegateFactory.factory.build().searchMasterFoodByHQLConjunction(f);
        
        assertNotNull(r);
        /*
         * benchmark number comes from 2006-02-08 live database.
         * 2006-03-11 RSC These numbers change with different database versions.  Original
         * was 200.
         */
        log.info("r size is " + r.size());
        assertTrue(r.size() > 40);
        
        for (Iterator iter = r.iterator(); iter.hasNext();) {
            MasterFood element = (MasterFood) iter.next();
            
            assertNotNull(element.getBrand());
            
        }
        
    }
    
    public void testBasicWithIsNull() throws Exception {
        
        MasterFoodFilterParameters f = MasterFoodFilterParametersTestFactory.getItemDescriptionWithBacon();
        
        f.getBasicProtein().setSelect(true);
        f.getBrand().setSelect(true);
        
        f.getBrand().setEmpty(Boolean.TRUE);
        
        Collection r = MasterFoodServiceDelegateFactory.factory.build().searchMasterFoodByHQLConjunction(f);
        
        assertNotNull(r);
        /*
         * benchmark number comes from 2006-02-08 live database.
         */
        assertTrue(r.size() > 3500);
        
        for (Iterator iter = r.iterator(); iter.hasNext();) {
            MasterFood element = (MasterFood) iter.next();
            
            assertNull(element.getBrand());
            
        }
        
    }
    
    
    public void testBasicWithYearPutIntoDatabase() throws Exception {
        
        MasterFoodFilterParameters f = MasterFoodFilterParametersTestFactory.getItemDescriptionWithBacon();
        
        f.getBasicProtein().setSelect(true);
        f.getBrand().setSelect(true);
        
        f.getYearPutInDatabaseSameStore().getAndValues().add("2004");
        
        Collection r = MasterFoodServiceDelegateFactory.factory.build().searchMasterFoodByHQLConjunction(f);
        
        assertNotNull(r);

        /*
         * 2006-08-17 reid changes from time to time.
         */
        log.info("result size " + r.size());
        
        assertTrue(r.size() > 3900);
        assertTrue(r.size() < 4000);
        
    }
    
    public void testDisjunctiveStatement() throws Exception {
        
        MasterFoodFilterParameters f = MasterFoodFilterParametersTestFactory.getItemDescriptionWithBacon();
        
        f.getBasicProtein().setSelect(true);
        f.getBrand().setSelect(true);
        f.getBasicProtein().getAndValues().add("chicken");
        f.getBrand().getAndValues().add("sara");
        
        StringBuffer b = new MasterFoodQueryBuilder().getDisjunctiveQueryWithSelectedFields(f);
        
        log.info(b);
        
        Collection r = MasterFoodServiceDelegateFactory.factory.build().searchMasterFoodByHQLDisjunction(f);
        
        assertNotNull(r);

        log.info("result size " + r.size());
        
        assertTrue(r.size() > 19000 && r.size() < 20000);

        
    }    
}
