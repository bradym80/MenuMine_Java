/*
 * Created on Feb 7, 2006 by Reid
 */
package com.fsrin.menumine.core.chainstat.webwork;

import com.fsrin.menumine.common.SpringBeanBroker;
import com.fsrin.menumine.context.MenuMineSessionContextFactory;
import com.fsrin.menumine.testutil.AbstractNonInitializingMenuMineTestCase;
import com.opensymphony.xwork.Action;

public class ChainStatListActionTest2 extends
        AbstractNonInitializingMenuMineTestCase {

    public void testBasic() throws Exception {

        ChainStatListAction action = (ChainStatListAction) SpringBeanBroker
                .getBeanFactory().getBean(ChainStatListAction.SPRING_BEAN_NAME);

        action.setMenuMineSessionContextWrapper(MenuMineSessionContextFactory.getMockWrapper());
        
        action.getChainStatFilterParameters().setOperationName("wendys");
        
        action.setSubmit("submit");
        
        String s = action.execute();
        
        assertEquals(Action.SUCCESS, s);
        
        assertNotNull(action.getList());
        
        assertEquals(1, action.getList().size());
    }
}
