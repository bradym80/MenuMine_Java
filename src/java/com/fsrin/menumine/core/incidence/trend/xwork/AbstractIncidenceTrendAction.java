/*
 * Created on Sep 14, 2006 by Reid
 */
package com.fsrin.menumine.core.incidence.trend.xwork;

import com.fsrin.menumine.core.menumine.webwork.AbstractMenuMineDisplayAction;

public abstract class AbstractIncidenceTrendAction extends
        AbstractMenuMineDisplayAction implements IncidenceTrendContextAware {

    private IncidenceTrendContext incidenceTrendContext;

    public IncidenceTrendContext getIncidenceTrendContext() {
        return incidenceTrendContext;
    }

    public void setIncidenceTrendContext(IncidenceTrendContext incidenceTrendContext) {
        this.incidenceTrendContext = incidenceTrendContext;
    }
    
    
}
