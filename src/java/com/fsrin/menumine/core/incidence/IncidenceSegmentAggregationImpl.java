/*
 * Created on Jan 30, 2006 by Reid
 */
package com.fsrin.menumine.core.incidence;

import java.util.Collection;

public class IncidenceSegmentAggregationImpl extends AbstractIncidenceTableElement implements IncidenceSegment {

    
    private Collection incidenceChains;
    
    public Collection getIncidenceChains() {
        return incidenceChains;
    }
    public void setIncidenceChains(Collection incidenceChains) {
        this.incidenceChains = incidenceChains;
    }

    
    
    
}
