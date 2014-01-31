/*
 * Created on Jan 16, 2006
 *
 */
package com.fsrin.menumine.common.webwork;

import com.fsrin.menumine.context.webwork.MenuMineSessionContextWrapper;
import com.fsrin.menumine.testutil.AbstractNonInitializingMenuMineTestCase;
import com.fsrin.menumine.testutil.MockApplicationContext;
import com.opensymphony.xwork.Action;

/**
 * see abstract for info on which database version to use.
 * 
 * 2006-01-16
 * 
 * @author Reid
 *
 */
public class WebLoginActionTest extends AbstractNonInitializingMenuMineTestCase {

    public void testLogin_Input() throws Exception {
        
        WebLoginAction action = new WebLoginAction();
        
        action.setMenuMineSessionContextWrapper(new MenuMineSessionContextWrapper());
        
        String s = action.execute();
        
        assertEquals(Action.INPUT, s);
    }
    
    public void testLogin_Success() throws Exception {
        
        WebLoginAction action = new WebLoginAction();
        action.setApplicationContext(new MockApplicationContext());
        action.setMenuMineSessionContextWrapper(new MenuMineSessionContextWrapper());
        
        action.setUsername("mbrady");
        action.setPassword("miufri4g");
        action.setSubmit("submit");
        
        String s = action.execute();
        
        assertEquals(WebLoginAction.SUCCESS_ADMIN, s);
        
    }
}
