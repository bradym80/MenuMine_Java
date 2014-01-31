/*
 * Created on Aug 12, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.fstx.stdlib2.authen.webwork;

import com.opensymphony.xwork.ActionContext;

/**
 * @author Nick
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public class UserModifyContextFactory {

    /**
     * @return
     */
    public UserModifyContext getContext() {
        UserModifyContext context = null;

        context = (UserModifyContext) ActionContext.getContext().getSession()
                .get(UserModifyContext.KEY);

        if (context == null) {
            context = new UserModifyContext();
            ActionContext.getContext().getSession().put(UserModifyContext.KEY,
                    context);
        }

        return context;
    }

}