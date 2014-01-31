/*
 * Created on Feb 17, 2006 by Reid
 */
package com.fsrin.menumine.context.webwork;

import com.fsrin.menumine.context.MenuMineSessionContextFactory;
import com.fsrin.menumine.testutil.AbstractNonInitializingMenuMineTestCase;

public class MenuMineSessionContextWrapperTest extends AbstractNonInitializingMenuMineTestCase {

    public void testBasicRollUpOptions() throws Exception {
        
        MenuMineSessionContextWrapper wrapper = MenuMineSessionContextFactory.getMockWrapper();
        
        assertTrue(wrapper.getRollUpOptions() != null);
        
        /*
         * just need to make sure it's not getting and NPE.
         */
        assertTrue(wrapper.getRollUpOptions() != null);
        
    }
    
}
