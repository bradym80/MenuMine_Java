/*
 * Created on Nov 7, 2006 by Reid
 */
package com.fsrin.menumine.context.webwork;

import com.fsrin.menumine.context.MenuMineSessionContextFactory;
import com.fsrin.menumine.testutil.AbstractNonInitializingMenuMineTestCase;

public class GetCategoryTemplatesActionTest extends
        AbstractNonInitializingMenuMineTestCase {

    public void testBasic() throws Exception {
        
        GetCategoryTemplatesAction action = new GetCategoryTemplatesAction();
        action.setMenuMineSessionContextWrapper(MenuMineSessionContextFactory.getMockWrapper("mbrady"));
        
        action.execute();
        
        log.info(action.getJsonDataAsString());
        
        
    }
}
