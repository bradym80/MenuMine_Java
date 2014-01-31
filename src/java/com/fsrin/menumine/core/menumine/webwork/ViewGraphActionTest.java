/*
 * Created on Jan 24, 2006
 *
 */
package com.fsrin.menumine.core.menumine.webwork;

import com.fsrin.menumine.context.MenuMineSessionContextFactory;
import com.fsrin.menumine.context.webwork.MenuMineSessionContextWrapper;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParametersImpl;
import com.fsrin.menumine.testutil.AbstractNonInitializingMenuMineTestCase;
import com.opensymphony.xwork.Action;

public class ViewGraphActionTest extends
        AbstractNonInitializingMenuMineTestCase {

    public void testBasic() throws Exception {

        ViewGraphAction action = new ViewGraphAction();

        action
                .setMenuMineSessionContextWrapper(new MenuMineSessionContextWrapper(
                        new MenuMineSessionContextFactory().buildMock()));

        MasterFoodFilterParameters p = new MasterFoodFilterParametersImpl();
        p.getItemDescription().getAndValues().add("bacon");
        
        action.getMenuMineSessionContextWrapper().setLastFilterWrapper(new MasterFoodFilterParametersWrapperImpl(p));
        
        action.getMenuMineSessionContextWrapper().getLastGraphOptions().setGraphByField(p.getGenMenuPart().getFieldName());
        
        action.getMenuMineSessionContextWrapper().getLastGraphOptions().setGraphByType(ViewGraphAction.CHART_TYPE_PIE);
        
        String s1 = action.execute();
        
        assertEquals(s1,Action.SUCCESS);
        
        
        
    }
}
