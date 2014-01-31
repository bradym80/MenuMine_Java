/*
 * Created on Feb 3, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.webwork;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fsrin.menumine.context.MenuMineSessionContextFactory;
import com.fsrin.menumine.core.menumine.FieldEnum;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParametersTestFactory;
import com.fsrin.menumine.testutil.AbstractNonInitializingMenuMineTestCase;
import com.opensymphony.xwork.Action;

public class MenuMineDisplayCrossTabulationActionTest extends
        AbstractNonInitializingMenuMineTestCase {

    private static Log log = LogFactory
            .getLog(MenuMineDisplayCrossTabulationActionTest.class);

    public void testBasicWithRollUp() throws Exception {

        MenuMineDisplayCrossTabulationAction action = new MenuMineDisplayCrossTabulationAction();

        action.setMenuMineSessionContextWrapper(MenuMineSessionContextFactory
                .getMockWrapper("mbrady"));

        action.getMenuMineSessionContextWrapper().setLastFilterWrapper(
                MasterFoodFilterParametersTestFactory
                        .getItemDescriptionWithBaconInWrapper());
        
        action.setMenuMineCrossTabulationOptions(new MenuMineCrossTabulationOptions());
        
        action.getMenuMineCrossTabulationOptions().setHorizontalField(FieldEnum.CUISINE_FAMILY.getOgnlName());
        
        action.getMenuMineCrossTabulationOptions().setHorizontalRollUpName("Reid1");
        
        action.getMenuMineCrossTabulationOptions().setVerticalField(FieldEnum.BASIC_PROTEIN.getOgnlName());
        
        String s = action.execute();
        
        assertEquals(Action.SUCCESS,s);
        
        assertNotNull(action.getCrossTabulationResults());
    }
}
