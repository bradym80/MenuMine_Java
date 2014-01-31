/*
 * Created on 2005-1-14
 *
 */
package com.fsrin.menumine.common.crud.xwork.interceptors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fsrin.menumine.testutil.TimerUtil;
import com.opensymphony.xwork.ActionInvocation;
import com.opensymphony.xwork.interceptor.Interceptor;

/**
 * 2006-02-02 RSC This was basically only for the canned schematic reports.  
 * Removed.
 * 
 * @author Nick This interceptor checks the target, looks up the instance, and
 *         injects it into the action.
 */
public class PersisterInterceptor implements Interceptor {

    private Log log = LogFactory.getLog(PersisterInterceptor.class);

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

        /*
         * 2006-02-02 Removed.
         */
//        if (arg0.getAction() instanceof EditAction) {
//            EditAction action = (EditAction) arg0.getAction();
//            action.validate();
//            action.applyWebParameters();
//            if (!action.hasActionErrors()) {
//                Object instance = action.getTargetInstance();
//                action.getServiceDelegate().save(instance);
//            }
//        }
        
        TimerUtil ict = TimerUtil.getInstanceAndStart("PersisterInterceptor");
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