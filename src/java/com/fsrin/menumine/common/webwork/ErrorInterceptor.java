/*
 * Created on 2005-1-14
 *
 */
package com.fsrin.menumine.common.webwork;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fsrin.menumine.common.util.FatalErrorAlert;
import com.fsrin.menumine.context.webwork.MenuMineSessionContextWrapper;
import com.fsrin.menumine.context.webwork.MenuMineSessionContextWrapperAware;
import com.opensymphony.webwork.WebWorkStatics;
import com.opensymphony.xwork.ActionContext;
import com.opensymphony.xwork.ActionInvocation;
import com.opensymphony.xwork.ActionSupport;
import com.opensymphony.xwork.interceptor.Interceptor;
import com.opensymphony.xwork.interceptor.component.ComponentManager;

/**
 * 2006-03-02 RSC
 * 
 * @author Reid
 * 
 */
public class ErrorInterceptor implements Interceptor {

    private Log log = LogFactory.getLog(ErrorInterceptor.class);

    /*
     * (non-Javadoc)
     * 
     * @see com.opensymphony.xwork.interceptor.Interceptor#intercept(com.opensymphony.xwork.ActionInvocation)
     */
    public String intercept(ActionInvocation arg0) throws Exception {

        // log.info("trying to get the component manager");

        HttpServletRequest request = (HttpServletRequest) ActionContext
                .getContext().get(WebWorkStatics.HTTP_REQUEST);

        HttpSession session = request.getSession();

        if (session == null) {
            new FatalErrorAlert().sendFatalErrorAlert("unknown",
                    new RuntimeException("Session is null"), null);
            return "global-error";
        }
        if (arg0 == null) {
            new FatalErrorAlert()
                    .sendFatalErrorAlert(session.getId(), new RuntimeException(
                            "ActionInvocation arg0 is null"), null);
            return "global-error";
        }

        ComponentManager cm = (ComponentManager) arg0.getInvocationContext()
                .getSession().get("DefaultComponentManager");

        if (cm == null) {
            new FatalErrorAlert().sendFatalErrorAlert(session.getId(),
                    new RuntimeException("ComponentManager is null"), null);
            return "global-error";
        }

        MenuMineSessionContextWrapper sc = (MenuMineSessionContextWrapper) cm
                .getComponent(MenuMineSessionContextWrapperAware.class);

        if (sc == null) {
            new FatalErrorAlert().sendFatalErrorAlert("unknown",
                    new RuntimeException("SessionContext is null"), null);
            return "global-error";
        }

        // log.info("trying to return the next invoke.");
        String ret = null;
        try {
            ret = arg0.invoke();
        } catch (Exception e) {
            e.printStackTrace();
            Throwable t = e.getCause();

            ((ActionSupport) arg0.getAction()).addActionError(e.getMessage());
            // return "global-error";
            // return "error";

            /*
             * 2006-03-02 Reid to troubleshoot session death.
             */
            log.fatal("=====FATAL (START)=====");
            if (sc.getAuthenticatedUser() != null)
                log.fatal("user: " + sc.getAuthenticatedUser().getUsername());
            else
                log.fatal("unknown user!");

            log
                    .fatal("FATAL - FATAL - FATAL -- Caught exception that causes session death. "
                            + e.getMessage());
            log.fatal("xwork action:" + arg0.getAction().getClass());
            e.printStackTrace();
            log.fatal("=====FATAL (END)=====");

            if (session == null)
                return "global-error";

            String sessionId = session.getId();
            
            if (request.getRemoteAddr() != null)
                sessionId += " Remote Address: " + request.getRemoteAddr();
            
            if (request.getRemoteHost() != null)
                sessionId += " Remote Host: " + request.getRemoteHost();
            
            if (request.getHeader("User-Agent") != null) 
                sessionId += " User Agent: " + request.getHeader("User-Agent");

            new FatalErrorAlert().sendFatalErrorAlert(sessionId, e, sc
                    .getMenuMineSessionContext());
            
            ret = "global-error";
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

}