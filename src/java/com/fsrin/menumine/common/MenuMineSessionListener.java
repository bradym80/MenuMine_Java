/*
 * Created on May 20, 2005
 *
 * 
 */
package com.fsrin.menumine.common;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.fsrin.menumine.common.webwork.UserLogoutEvent;
import com.fsrin.menumine.context.webwork.MenuMineSessionContextWrapper;
import com.fsrin.menumine.context.webwork.MenuMineSessionContextWrapperAware;
import com.fstx.stdlib2.authen.AuthenticatedUser;
import com.opensymphony.xwork.interceptor.component.ComponentManager;

/**
 * @author Nick
 * 
 *  
 */
public class MenuMineSessionListener implements HttpSessionListener {

    public MenuMineSessionListener() {
        super();

    }

    public void sessionCreated(HttpSessionEvent arg0) {
    }

    /*
     * I would like to know when the session is destroyed. The session doesn't
     * seem to be reading. (non-Javadoc)
     * 
     * @see javax.servlet.http.HttpSessionListener#sessionDestroyed(javax.servlet.http.HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0) {

        ComponentManager dcm = (ComponentManager) arg0.getSession()
                .getAttribute("DefaultComponentManager");

        MenuMineSessionContextWrapper session = (MenuMineSessionContextWrapper) dcm
                .getComponent(MenuMineSessionContextWrapperAware.class);

        AuthenticatedUser user = session.getAuthenticatedUser();

        UserLogoutEvent event = new UserLogoutEvent(this);
        event.setAuthenticatedUser(user);

        /*
         * 2006-02-01 Spring Throwing an exception with this.
         */
//        SpringEventPublisher.build().publish(event);
    }

}