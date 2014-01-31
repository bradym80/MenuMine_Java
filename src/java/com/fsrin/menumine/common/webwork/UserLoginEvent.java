/*
 * Created on May 17, 2005
 *
 * 
 */
package com.fsrin.menumine.common.webwork;

import java.util.ArrayList;

import org.springframework.context.ApplicationEvent;

import com.fsrin.menumine.common.event.MenuMineSpringApplicationEvent;
import com.fsrin.menumine.common.util.PromoNotificationAlert;
import com.fstx.stdlib2.authen.AuthenticatedUser;
import com.fstx.stdlib2.authen.users.UserRole;

/**
 * @author Nick
 * 
 *  
 */
public class UserLoginEvent extends MenuMineSpringApplicationEvent {
    private AuthenticatedUser authenticatedUser;

    public UserLoginEvent(Object arg0) {
        super(arg0);

    }

    public UserLoginEvent(Object arg0, ApplicationEvent event) {
        super(new ArrayList());
        if (event instanceof UserLoginEvent) {
            authenticatedUser = ((UserLoginEvent) event).getAuthenticatedUser();
            
        }

    }

    public AuthenticatedUser getAuthenticatedUser() {
        return authenticatedUser;
    }

    public void setAuthenticatedUser(AuthenticatedUser authenticatedUser) {
        this.authenticatedUser = authenticatedUser;
    }
}