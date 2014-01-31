/*
 * Created on Jan 20, 2006
 *
 */
package com.fsrin.menumine.core.menumine.masterfood;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fsrin.menumine.testutil.AbstractNonInitializingMenuMineTestCase;

/**
 * mostly just wanted to look at memory and time consumption.  Not too bad on either..
 * 
 * @author Reid
 *
 */
public class DistinctQueryBuilderTest extends
        AbstractNonInitializingMenuMineTestCase {

    private Log log = LogFactory.getLog(DistinctQueryBuilderTest.class);
    
    public void testSize() throws Exception {
        
        Runtime r = Runtime.getRuntime();
        
        long before = r.freeMemory();
        
        DistinctQueryBuilder distinctQueryBuilder = new DistinctQueryBuilder();
        distinctQueryBuilder.setMasterFoodDao(MasterFoodDao.factory.build());
        
        long after = r.freeMemory();
        
        log.info("memory change " + ((before - after)/1024));
        
    }
}
