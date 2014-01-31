/*
 * Created on Mar 2, 2006
 *
 */
package com.fsrin.menumine.core.chainmap;

import java.util.Collection;

import com.fsrin.menumine.testutil.AbstractNonInitializingMenuMineTestCase;

public class ChainStateCountServiceDelegateImplTest extends
        AbstractNonInitializingMenuMineTestCase {

    public void testBasicSearch() throws Exception {
        
        ChainStateCountCriteriaParamerters p = new ChainStateCountCriteriaParamerters();
        
        ChainStateCountServiceDelegate sd = ChainStateCountServiceDelegate.factory
        .build();
        
        Collection c = sd.search(p);
        
        assertNotNull(c);
        
        assertTrue(c.size() > 0);
    }
}
