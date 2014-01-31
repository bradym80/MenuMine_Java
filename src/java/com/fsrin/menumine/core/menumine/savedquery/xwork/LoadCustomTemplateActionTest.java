/*
 * Created on Sep 6, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.savedquery.xwork;

import java.util.Collection;

import com.fsrin.menumine.context.MenuMineSessionContextFactory;
import com.fsrin.menumine.context.webwork.MenuMineSessionContextWrapper;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParametersTestFactory;
import com.fsrin.menumine.core.menumine.savedquery.SavedQuery;
import com.fsrin.menumine.core.menumine.savedquery.SavedQueryServiceDelegate;
import com.fsrin.menumine.core.menumine.savedquery.SavedQueryTestFactory;
import com.fsrin.menumine.testutil.AbstractNonInitializingMenuMineTestCase;
import com.opensymphony.xwork.Action;

public class LoadCustomTemplateActionTest extends
        AbstractNonInitializingMenuMineTestCase {

    SavedQueryServiceDelegate sd;

    SavedQuery s;

    MasterFoodFilterParameters p;

    Collection pre;

    @Override
    protected void setUp() throws Exception {

        super.setUp();

        sd = SavedQueryServiceDelegate.factory.build();
        pre = sd.getSimpleTemplates();

        p = MasterFoodFilterParametersTestFactory.getItemDescriptionWithBacon();
        s = SavedQueryTestFactory.getBasicUnpersisted(p);
        s.setPermission(SavedQuery.CUSTOM_TEMPLATE_PERMISSION.intValue());
        sd.saveNew(s);
    }

    public void testBasic() throws Exception {

        Collection c = sd.getSimpleTemplates();
        assertNotNull(c);
        assertEquals(pre.size() + 1, c.size());

        MenuMineSessionContextWrapper sessionContextWrapper = MenuMineSessionContextFactory
                .getMockWrapperWithChicken(SAMPLE_USERNAME);
        LoadCustomTemplateAction action = new LoadCustomTemplateAction();
        action.setMenuMineSessionContextWrapper(sessionContextWrapper);
        action.setTarget(s.getId());

        String s = action.execute();
        assertEquals(Action.SUCCESS, s);

        // make sure chicken is gone
        assertFalse(action.getMenuMineSessionContextWrapper()
                .getLastFilterWrapper().getItemDescription().getAndValues()
                .contains("chicken"));

        //make sure bacon is here.
        assertTrue(action.getMenuMineSessionContextWrapper()
                .getLastFilterWrapper().getItemDescription().getAndValues()
                .contains("bacon"));
        
        //make sure any database id's are gone.
        assertNull(action.getMenuMineSessionContextWrapper().getLastFilterWrapper().getMasterFoodFilterParameters().getId());
        
        assertNull(action.getMenuMineSessionContextWrapper().getLastFieldsToDisplay().getId());
    }

    @Override
    protected void tearDown() throws Exception {

        super.tearDown();
        sd.delete(s);
    }
}
