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
import com.fstx.stdlib2.author.AuthorizerFailedException;
import com.opensymphony.webwork.WebWorkStatics;
import com.opensymphony.xwork.ActionContext;
import com.opensymphony.xwork.ActionInvocation;
import com.opensymphony.xwork.ActionSupport;
import com.opensymphony.xwork.interceptor.Interceptor;
import com.opensymphony.xwork.interceptor.component.ComponentManager;

/**
 * @author Nick
 * 
 */
public class SessionValidatorInterceptor implements Interceptor {

    private Log log = LogFactory.getLog(SessionValidatorInterceptor.class);

    /*
     * (non-Javadoc)
     * 
     * @see com.opensymphony.xwork.interceptor.Interceptor#intercept(com.opensymphony.xwork.ActionInvocation)
     */
    public String intercept(ActionInvocation arg0) throws Exception {

        HttpServletRequest request = (HttpServletRequest) ActionContext
                .getContext().get(WebWorkStatics.HTTP_REQUEST);
        HttpSession session = request.getSession();

        String sessionId = session.getId();

        if (request.getRemoteAddr() != null)
            sessionId += " Remote Address: " + request.getRemoteAddr();

        if (request.getRemoteHost() != null)
            sessionId += " Remote Host: " + request.getRemoteHost();

        if (request.getHeader("User-Agent") != null)
            sessionId += " User Agent: " + request.getHeader("User-Agent");

        // log.info("trying to get the component manager");

        ComponentManager cm = (ComponentManager) arg0.getInvocationContext()
                .getSession().get("DefaultComponentManager");

        MenuMineSessionContextWrapper sc = (MenuMineSessionContextWrapper) cm
                .getComponent(MenuMineSessionContextWrapperAware.class);

        // log.info("is the sc valid? " + sc.isValid());

        if (!sc.isValid()) {
            /*
             * 2006-02-03 Reid Invalid Session
             */
            new FatalErrorAlert().sendFatalErrorAlert(sessionId,
                    new RuntimeException("session invalid, going to login"), sc
                            .getMenuMineSessionContext());

            return "global-login"; // global login page.
        }

        // log.info("trying to return the next invoke.");
        String ret = null;
        try {
            ret = arg0.invoke();
        } catch (Exception e) {
            e.printStackTrace();
            Throwable t = e.getCause();
            while (t != null) {
                if (t instanceof AuthorizerFailedException) {
                    return "global-login";
                }
                t = t.getCause();
            }
            ((ActionSupport) arg0.getAction()).addActionError(e.getMessage());
            // return "global-error";
            // return "error";

            /*
             * 2006-03-02 Reid to troubleshoot session death.
             */
            log.fatal("=====FATAL (START)=====");
            log.fatal("user: " + sc.getAuthenticatedUser().getUsername());
            log
                    .fatal("FATAL - FATAL - FATAL -- Caught exception that causes session death. "
                            + e.getMessage());
            log.fatal("xwork action:" + arg0.getAction().getClass());
            e.printStackTrace();
            log.fatal("=====FATAL (END)=====");

            new FatalErrorAlert().sendFatalErrorAlert(sessionId, e, sc
                    .getMenuMineSessionContext());
            throw e;
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