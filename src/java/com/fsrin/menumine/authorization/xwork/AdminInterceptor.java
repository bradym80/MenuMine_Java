/*
 * Created on 2005-1-14
 *
 */
package com.fsrin.menumine.authorization.xwork;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fsrin.menumine.authorization.AuthorizationManager;
import com.fsrin.menumine.context.webwork.MenuMineSessionContextWrapper;
import com.fsrin.menumine.context.webwork.MenuMineSessionContextWrapperAware;
import com.fstx.stdlib2.authen.AuthenticatedUser;
import com.fstx.stdlib2.authen.users.UserRole;
import com.opensymphony.xwork.ActionInvocation;
import com.opensymphony.xwork.interceptor.Interceptor;
import com.opensymphony.xwork.interceptor.component.ComponentManager;

/**
 * @author Nick This interceptor makes sure we have the current rights in
 *         session.
 */
public class AdminInterceptor implements Interceptor {

    private Log log = LogFactory.getLog(AdminInterceptor.class);

    private AuthorizationManager authorizationManager;

    /*
     * (non-Javadoc)
     * 
     * @see com.opensymphony.xwork.interceptor.Interceptor#intercept(com.opensymphony.xwork.ActionInvocation)
     */
    public String intercept(ActionInvocation arg0) throws Exception {
        ComponentManager cm = (ComponentManager) arg0.getInvocationContext()
                .getSession().get("DefaultComponentManager");

        MenuMineSessionContextWrapper sc = (MenuMineSessionContextWrapper) cm
                .getComponent(MenuMineSessionContextWrapperAware.class);

        AuthenticatedUser user = sc.getAuthenticatedUser();

        String ret = null;
        if (user.getUser().getRole() == UserRole.ADMIN) {

            ret = arg0.invoke();
        }
        return ret;

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.opensymphony.xwork.interceptor.Interceptor#destroy()
     */
    public void destroy() {
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.opensymphony.xwork.interceptor.Interceptor#init()
     */
    public void init() {
    }

    public AuthorizationManager getAuthorizationManager() {
        return authorizationManager;
    }

    public void setAuthorizationManager(
            AuthorizationManager authorizationManager) {
        this.authorizationManager = authorizationManager;
    }
}