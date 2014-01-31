/*
 * Created on Jun 14, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.rollup.xwork.test;

import junit.framework.TestCase;

import com.fsrin.menumine.context.MenuMineSessionContextFactory;
import com.fsrin.menumine.context.webwork.MenuMineSessionContextWrapper;
import com.fsrin.menumine.core.menumine.rollup.xwork.MenuMineDeleteRollUpAction;
import com.opensymphony.xwork.ActionSupport;

/**
 * @author Nick
 * 
 *  
 */
public class MenuMineDeleteRollUpActionTest extends TestCase {

    public MenuMineDeleteRollUpActionTest() {
        super();

    }

    public void testDelete() throws Exception {
        MenuMineSessionContextWrapper context = MenuMineSessionContextFactory.getMockWrapper();
        RollUpServiceDelegateMockImpl sd = new RollUpServiceDelegateMockImpl();

        context.getRollUpOptions().setName("Test");
        MenuMineDeleteRollUpAction action = new MenuMineDeleteRollUpAction();
        action.setSubmitDelete("Delete");
        action.setRollUpServiceDelegate(sd);
        action.setMenuMineSessionContextWrapper(context);

        assertEquals(ActionSupport.SUCCESS, action.execute());

        assertNotNull(context.getRollUpOptions());

        assertNull(context.getRollUpOptions().getName());

        assertEquals(1, sd.getDeletedRollUps().size());
    }

    protected void setUp() throws Exception {
        super.setUp();
//        JunitSettings.initilizeTestSystem();
    }
}