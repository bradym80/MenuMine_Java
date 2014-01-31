/*
 * Created on Sep 10, 2004 by Reid
 */
package com.fsrin.menumine.common.webwork;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.fsrin.menumine.context.webwork.AbstractMenuMineSessionContextAwareAction;
import com.opensymphony.webwork.WebWorkStatics;
import com.opensymphony.xwork.ActionContext;

/**
 * @author Reid
 */
public class LogoutAction extends AbstractMenuMineSessionContextAwareAction implements
        ApplicationContextAware {

//    private MenuMineSessionContextWrapper menuMineSessionContextWrapper;

    public String execute() throws Exception {

        ActionContext context = ActionContext.getContext();

        HttpServletRequest request = (HttpServletRequest) context
                .get(WebWorkStatics.HTTP_REQUEST);

        /*
         * generally only happens in a test environment
         */

        if (request != null) {
            HttpSession session = request.getSession();
            session.invalidate();
        }

        UserLogoutEvent event = new UserLogoutEvent(this);
        event.setAuthenticatedUser(this.getMenuMineSessionContextWrapper()
                .getAuthenticatedUser());
        this.getApplicationContext().publishEvent(event);

        this.getMenuMineSessionContextWrapper().setAuthenticatedUser(null);

        //     return SUCCESS;
        return "global-login";
    }

//    public MenuMineSessionContextWrapper getMenuMineSessionContextWrapper() {
//        return menuMineSessionContextWrapper;
//    }
//
//    public void setMenuMineSessionContextWrapper(
//            MenuMineSessionContextWrapper menuMineSessionContextWrapper) {
//        this.menuMineSessionContextWrapper = menuMineSessionContextWrapper;
//    }

    private ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext arg0)
            throws BeansException {
        applicationContext = arg0;
    }

    protected ApplicationContext getApplicationContext() {
        return applicationContext;
    }

}