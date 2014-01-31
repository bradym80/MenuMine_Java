/*
 * Created on Jan 24, 2006
 *
 */
package com.fsrin.menumine.core.menumine.express.xwork;

import com.fsrin.menumine.common.SpringBeanBroker;
import com.fsrin.menumine.context.MenuMineSessionContext;
import com.fsrin.menumine.context.webwork.MenuMineSessionContextWrapper;
import com.fsrin.menumine.core.menumine.webwork.MenuMineDisplaySpreadsheetAction;
import com.fsrin.menumine.testutil.AbstractNonInitializingMenuMineTestCase;
import com.opensymphony.xwork.Action;

/**
 * links test through to the MenuMineDisplaySpreadsheetAction
 * 
 * @author Reid
 * 
 */
public class MenuMineExpressActionV2Test2 extends
        AbstractNonInitializingMenuMineTestCase {

    public void testBasic() throws Exception {

        MenuMineExpressActionV2 action = new MenuMineExpressActionV2();
        action
                .setMenuMineSessionContextWrapper(new MenuMineSessionContextWrapper(
                        MenuMineSessionContext.factory.buildMock()));

        action.setSubmit("submit");

        action.setSearchString("chicken");

        String s = action.execute();

        assertEquals(Action.SUCCESS, s);

        assertNotNull(action.getMenuMineSessionContextWrapper()
                .getLastFilterWrapper());
        assertEquals(1, action.getMenuMineSessionContextWrapper()
                .getLastFilterWrapper().getItemDescription()
                .getFilterParameter().getAndValues().size());

        assertNotNull(action.getMenuMineSessionContextWrapper()
                .getLastFieldsToDisplay());

        /*
         * now let's get the display spreadsheet action.
         */

        MenuMineDisplaySpreadsheetAction displayAction = (MenuMineDisplaySpreadsheetAction) SpringBeanBroker
                .getBeanFactory().getBean(
                        MenuMineDisplaySpreadsheetAction.SPRING_BEAN_NAME);
        
        displayAction.setMenuMineSessionContextWrapper(action.getMenuMineSessionContextWrapper());
        
        
        String displayS1 = displayAction.execute();
        
        assertEquals(Action.SUCCESS, displayS1);
        
        assertNotNull(displayAction.getResults());

    }
    
    public void testEnsureFirstQueryIsSent() throws Exception {

        MenuMineExpressActionV2 action = new MenuMineExpressActionV2();
        action
                .setMenuMineSessionContextWrapper(new MenuMineSessionContextWrapper(
                        MenuMineSessionContext.factory.buildMock()));

        action.setSubmit("submit");

        action.setSearchString("chicken");

        String s = action.execute();

        assertEquals(Action.SUCCESS, s);

        assertNotNull(action.getMenuMineSessionContextWrapper()
                .getLastFilterWrapper());
        assertEquals(1, action.getMenuMineSessionContextWrapper()
                .getLastFilterWrapper().getItemDescription()
                .getFilterParameter().getAndValues().size());

        assertNotNull(action.getMenuMineSessionContextWrapper()
                .getLastFieldsToDisplay());

        assertTrue(action.getMenuMineSessionContextWrapper().isFirstQuerySent());
        

    }
}
