/*
 * Created on Feb 7, 2006 by Reid
 */
package com.fsrin.menumine.core.chainstat.webwork;

import com.fsrin.menumine.common.SpringBeanBroker;
import com.fsrin.menumine.context.MenuMineSessionContextFactory;
import com.fsrin.menumine.testutil.AbstractNonInitializingMenuMineTestCase;
import com.opensymphony.xwork.Action;

public class ChainStatDetailActionTest2 extends
        AbstractNonInitializingMenuMineTestCase {

    public void testBasicWithWendys() throws Exception {
        
        ChainStatDetailAction action = (ChainStatDetailAction) SpringBeanBroker.getBeanFactory().getBean(ChainStatDetailAction.SPRING_BEAN_NAME);
        
        assertNotNull(action);
        
        action.setMenuMineSessionContextWrapper(MenuMineSessionContextFactory.getMockWrapper());
        
        /*
         * 2006-02-07 RSC This is mostly testing to identify
         * a bug in the JSP. NOTE: Problem was menuRSS link.
         */
        //wendy's
        action.setTarget(new Long(222));
        
        String s = action.execute();
        
        assertEquals(Action.SUCCESS, s);
        
        assertNotNull(action.getChainStat());
        
        assertNotNull(action.getChainStat().getChainStateCount());
        
        assertNotNull(action.getChainStat().getSegment());
        

        
        
    }
}
