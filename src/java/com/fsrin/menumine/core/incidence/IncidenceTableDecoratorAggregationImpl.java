/*
 * Created on Jul 25, 2006
 *
 */
package com.fsrin.menumine.core.incidence;

public class IncidenceTableDecoratorAggregationImpl extends
        AbstractIncidenceTableDecorator {

    @Override
    public IncidenceSectorAggregationImpl getIncidenceSector() {
        return new IncidenceSectorAggregationImpl();
    }

    @Override
    public IncidenceSegmentAggregationImpl getIncidenceSegment() {
        return new IncidenceSegmentAggregationImpl();
    }

}
