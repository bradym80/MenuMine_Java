/*
 * Created on 2005-1-14
 *
 */
package com.fsrin.menumine.authorization.xwork;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fsrin.menumine.authorization.AuthorizationManager;
import com.opensymphony.xwork.ActionInvocation;
import com.opensymphony.xwork.interceptor.Interceptor;

/**
 * @author Nick This interceptor makes sure we have the current rights in
 *         session.
 *         
 * 2006-04-04 RSC This isn't needed any more since we're eliminating group specific rights.  Rights are now
 * just done by role.
 */
public class AuthorizationBeanInterceptor implements Interceptor {

    private Log log = LogFactory.getLog(AuthorizationBeanInterceptor.class);

    private AuthorizationManager authorizationManager;

    /*
     * (non-Javadoc)
     * 
     * @see com.opensymphony.xwork.interceptor.Interceptor#intercept(com.opensymphony.xwork.ActionInvocation)
     */
    public String intercept(ActionInvocation arg0) throws Exception {
        
        /*
         * 2006-04-04 leaving this in the stram for now.
         */
//        ComponentManager cm = (ComponentManager) arg0.getInvocationContext()
//                .getSession().get("DefaultComponentManager");
//
//        MenuMineSessionContextWrapper sc = (MenuMineSessionContextWrapper) cm
//                .getComponent(MenuMineSessionContextWrapperAware.class);
//
//        
//        UserGroup group = sc.getUserGroup();
//
//        AuthorizationBean bean = this.getAuthorizationManager()
//                .prepareAuthorizationBean(group);
//
//        sc.setAuthorizationBean(bean);

        String ret = null;
        ret = arg0.invoke();

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