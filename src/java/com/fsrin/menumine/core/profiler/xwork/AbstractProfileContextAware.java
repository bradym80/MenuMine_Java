/*
 * Created on Apr 21, 2006 by Reid
 */
package com.fsrin.menumine.core.profiler.xwork;

import com.fsrin.menumine.context.webwork.AbstractMenuMineSessionContextAwareAction;

public abstract class AbstractProfileContextAware extends
        AbstractMenuMineSessionContextAwareAction implements
        ProfileContextAware {

    private ProfileContext profileContext;

    public ProfileContext getProfileContext() {
        return profileContext;
    }

    public void setProfileContext(ProfileContext profileContext) {
        this.profileContext = profileContext;
    }
    
    
    
}
