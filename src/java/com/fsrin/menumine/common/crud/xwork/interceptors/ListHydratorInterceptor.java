/*
 * Created on 2005-1-14
 *
 */
package com.fsrin.menumine.common.crud.xwork.interceptors;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fsrin.menumine.common.crud.xwork.ListAction;
import com.fsrin.menumine.common.dao.CriteriaParameters;
import com.fsrin.menumine.testutil.TimerUtil;
import com.opensymphony.xwork.ActionInvocation;
import com.opensymphony.xwork.interceptor.Interceptor;

/**
 * @author Nick This interceptor abstracts the persistance from the actions.
 */
public class ListHydratorInterceptor implements Interceptor {

    private Log log = LogFactory.getLog(ListHydratorInterceptor.class);

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

        TimerUtil ict = TimerUtil.getInstanceAndStart("ListHydratorInterceptor");
        
        if (arg0.getAction() instanceof ListAction) {
            
            
            ListAction action = (ListAction) arg0.getAction();
            CriteriaParameters params = action.getCriteriaParameters();
            
            log.debug("intercepting ListAction " + action.getClass().getName() + " paramType " + params.getClass().getName());
            Collection instances = action.getServiceDelegate().search(params);
            action.setList(instances);
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