/*
 * Created on Jun 2, 2005
 *
 * 
 */
package com.fsrin.menumine.loginHistory;

import junit.framework.TestCase;

import com.fsrin.menumine.common.webwork.AuthenticatedUserMockImpl;
import com.fsrin.menumine.common.webwork.UserLoginEvent;
import com.fsrin.menumine.common.webwork.UserLogoutEvent;
import com.fstx.stdlib2.authen.LoginHistoryBD;

/**
 * @author Nick
 * 
 *  
 */
public class LoginHistoryEventListenerTest extends TestCase {

    public void testEvent() throws Exception {
        LoginHistoryBD bd = new LoginHistoryBDMockImpl();

        LoginHistoryEventListener listener = new LoginHistoryEventListener();
        listener.setLoginHistoryBD(bd);

        UserLoginEvent login = new UserLoginEvent(this);
        login.setAuthenticatedUser(new AuthenticatedUserMockImpl());
        listener.onApplicationEvent(login);

        UserLogoutEvent logout = new UserLogoutEvent(this);
        logout.setAuthenticatedUser(new AuthenticatedUserMockImpl());
        listener.onApplicationEvent(logout);

        /*
         * Since we logged 2, we expect 2.
         */
        assertEquals(2, bd.list().size());
    }

}