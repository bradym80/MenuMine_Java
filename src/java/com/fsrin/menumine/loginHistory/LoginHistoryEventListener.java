/*
 * Created on 2005-6-2
 *
 * 
 */
package com.fsrin.menumine.loginHistory;

import java.util.Date;

import org.apache.commons.logging.LogFactory;

import com.fsrin.menumine.common.event.MenuMineGenericSpringEventListener;
import com.fsrin.menumine.common.webwork.UserLoginEvent;
import com.fsrin.menumine.common.webwork.UserLogoutEvent;
import com.fsrin.menumine.users.UserPreferenceKeys;
import com.fsrin.menumine.users.UserPreferenceServiceDelegate;
import com.fsrin.menumine.users.UserPreferenceServiceDelegateFactory;
import com.fstx.stdlib2.authen.LoginHistoryBD;
import com.fstx.stdlib2.authen.LoginHistoryException;

/**
 * @author Nick
 * 
 * This class listens for Application Events from the Spring Context. When it
 * sees a LoginEvent we log it in the login history.
 * 
 * 2006-04-06 RSC Modified to skip posting to login history if we're
 * arriving here via a timeout or something similar.
 * 
 */
public class LoginHistoryEventListener extends
        MenuMineGenericSpringEventListener {

    private LoginHistoryBD loginHistoryBD = null;

    public void handleEvent(UserLogoutEvent event) {
        if (event.getAuthenticatedUser() == null
                || event.getAuthenticatedUser().getUsername() == null) {
            LogFactory.getLog(this.getClass()).error(
                    "No Authenticated included with event");
        } else {
            try {
                this.getLoginHistoryBD().recordLogout(
                        event.getAuthenticatedUser().getUsername(), new Date());
            } catch (LoginHistoryException e) {
                e.printStackTrace();
            }
        }
    }

    public void handleEvent(UserLoginEvent event) {
        if (event.getAuthenticatedUser() == null
                || event.getAuthenticatedUser().getUsername() == null) {
            LogFactory.getLog(this.getClass()).error(
                    "No Authenticated included with event");
        }

        try {
            this.getLoginHistoryBD().recordLogin(
                    event.getAuthenticatedUser().getUsername(), new Date());
            
            /*
             * 2006-04-19 Also update some user prefs.
             */
            UserPreferenceServiceDelegate sd = UserPreferenceServiceDelegateFactory.build();
            sd.incrementUserPreference(event.getAuthenticatedUser().getUsername(), UserPreferenceKeys.LOGIN_COUNT);
            sd.updateUserPreference(event.getAuthenticatedUser().getUsername(), UserPreferenceKeys.LAST_LOGIN, new Date().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public LoginHistoryBD getLoginHistoryBD() {
        return loginHistoryBD;
    }

    public void setLoginHistoryBD(LoginHistoryBD loginHistoryBD) {
        this.loginHistoryBD = loginHistoryBD;
    }
}