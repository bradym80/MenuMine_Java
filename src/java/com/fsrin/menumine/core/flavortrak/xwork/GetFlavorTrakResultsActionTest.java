/*
 * Created on Aug 14, 2006 by Reid
 */
package com.fsrin.menumine.core.flavortrak.xwork;

import com.fsrin.menumine.testutil.AbstractNonInitializingMenuMineTestCase;

public class GetFlavorTrakResultsActionTest extends
        AbstractNonInitializingMenuMineTestCase {

    public void testBasic() throws Exception {
        
        GetFlavorTrakResultsAction action = new GetFlavorTrakResultsAction();
        
        action.setFlavorTrakContext(new FlavorTrakContext());
        
        action.getFlavorTrakContext().setQuery("chicken");
        
        action.getFlavorTrakContext().setCuisineFamily("American");
        
        action.execute();
        
        assertTrue(action.getJsonObjectResult().getInt("recordCount") > 0);
        //assertTrue(action.getJsonObjectResult().getInt("wordCount") > 0);
        
    }
}
