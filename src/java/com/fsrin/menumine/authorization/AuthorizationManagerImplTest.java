/*
 * Created on Jan 16, 2006
 *
 */
package com.fsrin.menumine.authorization;

import com.fsrin.menumine.common.SpringBeanBroker;
import com.fsrin.menumine.common.webwork.WebLoginAction;
import com.fsrin.menumine.context.webwork.MenuMineSessionContextWrapper;
import com.fsrin.menumine.testutil.AbstractNonInitializingMenuMineTestCase;
import com.fsrin.menumine.testutil.MockApplicationContext;
import com.fstx.stdlib2.authen.users.UserGroup;

/**
 * see superclass for database specifications.
 * 
 * @author Reid
 * 
 */
public class AuthorizationManagerImplTest extends
        AbstractNonInitializingMenuMineTestCase {

    public void testBasic() throws Exception {

        WebLoginAction action = new WebLoginAction();
        action.setApplicationContext(new MockApplicationContext());
        action
                .setMenuMineSessionContextWrapper(new MenuMineSessionContextWrapper());

        action.setUsername("mbrady");
        action.setPassword("miufri4g");
        action.setSubmit("submit");

        String s = action.execute();

        assertEquals(WebLoginAction.SUCCESS_ADMIN, s);

        /*
         * 2006-01-16 Here are the details.
         * 
         * 
         */

        UserGroup group = action.getMenuMineSessionContextWrapper()
                .getUserGroup();

        AuthorizationManager am = (AuthorizationManager) SpringBeanBroker
                .getBeanFactory()
                .getBean(AuthorizationManager.SPRING_BEAN_NAME);
        AuthorizationBean bean = am
                .prepareAuthorizationBean(group);

    }

}
