/*
 * Created on Jan 24, 2006
 *
 */
package com.fsrin.menumine.core.menumine.express.xwork;

import com.fsrin.menumine.context.MenuMineSessionContext;
import com.fsrin.menumine.context.webwork.MenuMineSessionContextWrapper;
import com.fsrin.menumine.core.minefields.MineFieldsFactory;
import com.fsrin.menumine.testutil.AbstractNonInitializingMenuMineTestCase;
import com.opensymphony.xwork.Action;

public class MenuMineExpressActionV2Test extends
        AbstractNonInitializingMenuMineTestCase {

    public void testBasic() throws Exception {

        MenuMineExpressActionV2 action = new MenuMineExpressActionV2();
        action
                .setMenuMineSessionContextWrapper(new MenuMineSessionContextWrapper(
                        MenuMineSessionContext.factory.buildMock()));
        
        String s = action.execute();
        
        assertEquals(Action.INPUT,s);

    }
    
    public void testWithQuery() throws Exception {
        
        MenuMineExpressActionV2 action = new MenuMineExpressActionV2();
        action
                .setMenuMineSessionContextWrapper(new MenuMineSessionContextWrapper(
                        MenuMineSessionContext.factory.buildMock()));
        
        action.setSubmit("submit");
        
        action.setSearchString("chicken");
        
        String s = action.execute();
        
        assertEquals(Action.SUCCESS,s);
        
        assertNotNull(action.getMenuMineSessionContextWrapper().getLastFilterWrapper());
        assertEquals(1,action.getMenuMineSessionContextWrapper().getLastFilterWrapper().getItemDescription().getFilterParameter().getAndValues().size());
        
        assertNotNull(action.getMenuMineSessionContextWrapper().getLastFieldsToDisplay());
        
    }
    
    public void testWith_SwitchingMines_Ingredient() throws Exception {
        
        MenuMineExpressActionV2 action = new MenuMineExpressActionV2();
        action
                .setMenuMineSessionContextWrapper(new MenuMineSessionContextWrapper(
                        MenuMineSessionContext.factory.buildMock()));
        
        action.setSubmit("submit");
        
        action.setExpressMine(MineFieldsFactory.MINE_TYPE_INGREDIENT);
        
        action.setSearchString("chicken");
        
        String s = action.execute();
        
        assertEquals(Action.SUCCESS,s);
        
        assertNotNull(action.getMenuMineSessionContextWrapper().getLastFilterWrapper());
        assertEquals(1,action.getMenuMineSessionContextWrapper().getLastFilterWrapper().getItemDescription().getFilterParameter().getAndValues().size());
        assertNotNull(action.getMenuMineSessionContextWrapper().getLastFieldsToDisplay());
        
        assertEquals(action.getMenuMineSessionContextWrapper().getMineFields().getMineType(), MineFieldsFactory.MINE_TYPE_INGREDIENT);
        
        
    }
}
