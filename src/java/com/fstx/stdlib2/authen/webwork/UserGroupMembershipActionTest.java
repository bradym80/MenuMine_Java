/*
 * Created on Mar 13, 2006 by Reid
 */
package com.fstx.stdlib2.authen.webwork;

import java.util.Collection;

import com.fsrin.menumine.common.SpringBeanBroker;
import com.fsrin.menumine.context.MenuMineSessionContextFactory;
import com.fsrin.menumine.testutil.AbstractNonInitializingMenuMineTestCase;
import com.fstx.stdlib2.authen.users.UserGroup;
import com.fstx.stdlib2.authen.users.UserGroupServiceDelegate;
import com.opensymphony.xwork.Action;

public class UserGroupMembershipActionTest extends
        AbstractNonInitializingMenuMineTestCase {

    public void testBasic() throws Exception {

        Collection groups = UserGroupServiceDelegate.factory.build().getAll();
        
        UserGroup g = (UserGroup) groups.toArray()[0];
        
        UserGroupMembershipAction action = (UserGroupMembershipAction) SpringBeanBroker
                .getBeanFactory().getBean(
                        UserGroupMembershipAction.SPRING_BEAN_NAME);

        action.setMenuMineSessionContextWrapper(MenuMineSessionContextFactory
                .getMockWrapperWithBacon("mbrady"));

        action.setTarget(g.getId());

        action.setUserModifyContext(new UserModifyContext());
        
        String s = action.execute();

        
        /*
         * 2006-03-13 RSC This really only has input.
         */
        assertEquals(Action.INPUT, s);
        
        assertNotNull(action.getMembers());
        
        assertNotNull(action.getNonMembers());

    }
}
