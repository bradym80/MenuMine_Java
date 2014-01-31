/*
 * Created on 2005-1-14
 *
 */
package com.fsrin.menumine.common.crud.xwork.interceptors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fsrin.menumine.common.crud.xwork.SelectAction;
import com.fsrin.menumine.testutil.TimerUtil;
import com.opensymphony.xwork.ActionInvocation;
import com.opensymphony.xwork.interceptor.Interceptor;

/**
 * @author Nick This interceptor checks the target, looks up the instance, and
 *         injects it into the action.
 */
public class HydratorInterceptor implements Interceptor {

    private Log log = LogFactory.getLog(HydratorInterceptor.class);

    /*
     * (non-Javadoc)
     * 
     * @see com.opensymphony.xwork.interceptor.Interceptor#intercept(com.opensymphony.xwork.ActionInvocation)
     */
    public String intercept(ActionInvocation arg0) throws Exception {
        //        ComponentManager cm = (ComponentManager) arg0.getInvocationContext()
        //                .getSession().get("DefaultComponentManager");
        //
        //        MenuMineSessionContextWrapper sc = (MenuMineSessionContextWrapper) cm
        //                .getComponent(MenuMineSessionContextWrapperAware.class);

        TimerUtil ict = TimerUtil.getInstanceAndStart("HydratorInterceptor");
        
        if (arg0.getAction() instanceof SelectAction) {
            SelectAction action = (SelectAction) arg0.getAction();
            Long target = action.getTarget();
            Object instance = action.getServiceDelegate().find(target);
            action.setTargetInstance(instance);
        }
        String ret = null;
        ret = arg0.invoke();

        ict.stop();
        
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

}