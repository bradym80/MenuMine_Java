/*
 * Created on 2005-1-14
 *
 */
package com.fsrin.menumine.authorization.xwork;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fsrin.menumine.authorization.AuthorizationManager;
import com.fstx.stdlib2.author.SecuredAction;
import com.fstx.stdlib2.author.SecuredActionEnum;
import com.opensymphony.xwork.ActionInvocation;
import com.opensymphony.xwork.interceptor.Interceptor;

/**
 * @author Nick
 * 
 * 2006-04-04 RSC Deprecating.
 *  
 */
public class AuthorizerInterceptor implements Interceptor {

    private Log log = LogFactory.getLog(AuthorizerInterceptor.class);

    private AuthorizationManager authorizationManager;

    private SecuredAction token;

    /*
     * (non-Javadoc)
     * 
     * @see com.opensymphony.xwork.interceptor.Interceptor#intercept(com.opensymphony.xwork.ActionInvocation)
     */
    public String intercept(ActionInvocation arg0) throws Exception {
        /*
        ComponentManager cm = (ComponentManager) arg0.getInvocationContext()
                .getSession().get("DefaultComponentManager");

        MenuMineSessionContextWrapper sc = (MenuMineSessionContextWrapper) cm
                .getComponent(MenuMineSessionContextWrapperAware.class);

        UserGroup group = sc.getUserGroup();

        boolean test = this.getAuthorizationManager().isAuthorized(group,
                this.getToken());

        if (test) {
        */
            String ret = null;
            ret = arg0.invoke();

            return ret;
//        } else {
//           
//            return "access-error";
//        }

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

    public SecuredAction getToken() {
        return token;
    }

    public void setTokenKey(String tokenKey) {
        this.token = SecuredActionEnum.getByName(tokenKey);
    }

    public AuthorizationManager getAuthorizationManager() {
        return authorizationManager;
    }

    public void setAuthorizationManager(
            AuthorizationManager authorizationManager) {
        this.authorizationManager = authorizationManager;
    }
}