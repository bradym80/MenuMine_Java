/*
 * Created on Mar 13, 2006 by Reid
 */
package com.fstx.stdlib2.authen.webwork;

import com.fsrin.menumine.context.webwork.AbstractMenuMineSessionContextAwareAction;

public abstract class AbstractUserModifyContextAwareAction extends
        AbstractMenuMineSessionContextAwareAction implements UserModifyContextAware {

    private UserModifyContext userModifyContext;

    public UserModifyContext getUserModifyContext() {
        return userModifyContext;
    }

    public void setUserModifyContext(UserModifyContext userModifyContext) {
        this.userModifyContext = userModifyContext;
    }
    
    
}
