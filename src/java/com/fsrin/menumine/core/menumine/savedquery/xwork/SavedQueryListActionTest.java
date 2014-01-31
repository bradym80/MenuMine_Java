/*
 * Created on Feb 7, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.savedquery.xwork;

import com.fsrin.menumine.common.SpringBeanBroker;
import com.fsrin.menumine.context.MenuMineSessionContextFactory;
import com.fsrin.menumine.testutil.AbstractNonInitializingMenuMineTestCase;
import com.opensymphony.xwork.Action;

public class SavedQueryListActionTest extends
        AbstractNonInitializingMenuMineTestCase {

    public void testBasicList() throws Exception {

        SavedQueryListAction action = (SavedQueryListAction) SpringBeanBroker
                .getBeanFactory().getBean("wwSavedQueryAction");

        action.setMenuMineSessionContextWrapper(MenuMineSessionContextFactory
                .getMockWrapper());

        String s = action.execute();

        assertEquals(Action.SUCCESS, s);

        assertNotNull(action.getSavedQueries());

    }

    public void testDelete() throws Exception {

        SavedQueryListAction action = (SavedQueryListAction) SpringBeanBroker
                .getBeanFactory().getBean("wwSavedQueryAction");

        action.setMenuMineSessionContextWrapper(MenuMineSessionContextFactory
                .getMockWrapper());

        
    }
}
