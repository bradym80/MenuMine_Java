/*
 * Created on May 18, 2005
 *
 * 
 */
package com.fsrin.menumine.common.webwork;

import java.util.ArrayList;

import org.springframework.context.ApplicationEvent;

import com.fsrin.menumine.common.event.MenuMineSpringApplicationEvent;
import com.fstx.stdlib2.authen.AuthenticatedUser;

/**
 * @author Nick
 * 
 *  
 */
public class UserLogoutEvent extends MenuMineSpringApplicationEvent {

    private AuthenticatedUser authenticatedUser;

    public UserLogoutEvent(Object arg0) {
        super(arg0);

    }

    public UserLogoutEvent(Object arg0, ApplicationEvent event) {
        super(new ArrayList());
        if (event instanceof UserLogoutEvent) {
            authenticatedUser = ((UserLogoutEvent) event)
                    .getAuthenticatedUser();
        }

    }

    public AuthenticatedUser getAuthenticatedUser() {
        return authenticatedUser;
    }

    public void setAuthenticatedUser(AuthenticatedUser authenticatedUser) {
        this.authenticatedUser = authenticatedUser;
    }
}