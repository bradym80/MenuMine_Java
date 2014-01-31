/*
 * Created on Aug 14, 2006 by Reid
 */
package com.fsrin.menumine.core.flavortrak.xwork;

import com.fivesticks.common.json.AbstractJSONAction;

public class AbstractFlavorTrakContextAwareJSONAction extends AbstractJSONAction implements FlavorTrakContextAware {

    private FlavorTrakContext flavorTrakContext;

    public FlavorTrakContext getFlavorTrakContext() {
        return flavorTrakContext;
    }

    public void setFlavorTrakContext(FlavorTrakContext flavorTrakContext) {
        this.flavorTrakContext = flavorTrakContext;
    }
    
    
}
