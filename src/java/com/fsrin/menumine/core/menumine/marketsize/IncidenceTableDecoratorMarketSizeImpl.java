/*
 * Created on Jul 25, 2006
 *
 */
package com.fsrin.menumine.core.menumine.marketsize;

import com.fsrin.menumine.core.incidence.AbstractIncidenceTableDecorator;
import com.fsrin.menumine.core.incidence.IncidenceSectorAggregationImpl;
import com.fsrin.menumine.core.incidence.IncidenceSegmentAggregationImpl;

public class IncidenceTableDecoratorMarketSizeImpl extends
        AbstractIncidenceTableDecorator {

    @Override
    public IncidenceSectorAggregationImpl getIncidenceSector() {
        
        return new MarketSizeIncidenceSector();
    }

    @Override
    public IncidenceSegmentAggregationImpl getIncidenceSegment() {
        
        return new MarketSizeIncidenceSegment();
    }

}
