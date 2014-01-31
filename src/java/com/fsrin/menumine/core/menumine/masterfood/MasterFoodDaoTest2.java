/*
 * Created on Jan 16, 2006
 *
 */
package com.fsrin.menumine.core.menumine.masterfood;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fsrin.menumine.common.FilterParameter;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParametersImpl;
import com.fsrin.menumine.testutil.AbstractNonInitializingMenuMineTestCase;

public class MasterFoodDaoTest2 extends AbstractNonInitializingMenuMineTestCase {

    private static Log log = LogFactory.getLog(MasterFoodDaoTest2.class);
    
    /*
     * 2006-01-16 RSC the only goal here is to make sure we're basically
     * up and running.
     */
//    public void testBasic() throws Exception {
//        
//        MasterFoodDao dao = MasterFoodDao.factory.build();
//        
//        MasterFoodFilterParametersImpl params = new MasterFoodFilterParametersImpl();
//        
//        FilterParameter fp = new FilterParameter(FieldEnum.BASIC_PROTEIN);
//        fp.getAndValues().add("chicken");
//        
//        params.setBasicProtein(fp);
//        
//        Collection c = dao.findUsingCriteria(params);
//        
//        log.info("result size is " + c.size());
//        
//    }
//    
    public void testCount() throws Exception {
        
        MasterFoodDao dao = MasterFoodDao.factory.build();
        
        MasterFoodFilterParametersImpl params = new MasterFoodFilterParametersImpl();
        
        FilterParameter fp = params.getItemDescription();
        fp.getAndValues().add("feta");
        fp.getAndValues().add("bacon");
        fp.setSelect(true);
        params.getBrand().setSelect(true);
        
        /*
         * taking too long.
         */
//        Collection c = dao.findUsingCriteria(params);
        
        Collection c = dao.findUsingHQLConjunction(params);
        
        log.info("result size is " + c.size());
        
        Long count = dao.getCount(params);
        
        assertNotNull(count);
        
        assertEquals(c.size(), count.longValue());
        
    }
    
    /*
     * 2006-02-08 RSC
     * uses the criteria, which we don't use any more.
     */
//    public void testExpressSearch() throws Exception {
//        
//        MasterFoodDao dao = MasterFoodDao.factory.build();
//        
//        MasterFoodFilterParametersImpl params = new MasterFoodFilterParametersImpl();
//        
//        FilterParameter fp = new FilterParameter(FieldEnum.DESCRIPTION);
//        fp.getAndValues().add("carrots");
//        
//        params.setItemDescription(fp);
//        
//        Collection c = dao.findExpressUsingCriteria(params);
//        
//        assertNotNull(c);
//        
//        assertTrue(c.size() > 0);
//    }
    
//    public void testExpressSearch_chicken() throws Exception {
//        
//        MasterFoodDao dao = MasterFoodDao.factory.build();
//        
//        MasterFoodFilterParametersImpl params = new MasterFoodFilterParametersImpl();
//        
//        FilterParameter fp = new FilterParameter(FieldEnum.DESCRIPTION);
//        fp.getAndValues().add("chicken");
//        
//        params.setItemDescription(fp);
//        
//        Collection c = dao.findExpressUsingCriteria(params);
//        
//        assertNotNull(c);
//        
//        assertTrue(c.size() > 0);
//    }
}
