/*
 * Created on Jan 30, 2006 by Reid
 */
package com.fsrin.menumine.core.incidence;

import java.util.Collection;

/*
 * 2006-07-25 reid@fivesticks.com refactored to use the incidence table element
 */
public class IncidenceSectorAggregationImpl extends
        AbstractIncidenceTableElement implements IncidenceSector {

    private Collection incidenceSegments;

    public Collection getIncidenceSegments() {
        return incidenceSegments;
    }

    public void setIncidenceSegments(Collection incidenceSegments) {
        this.incidenceSegments = incidenceSegments;
    }

}
