/*
 * Created on Jul 25, 2006
 *
 */
package com.fsrin.menumine.core.menumine.marketsize;

import com.fsrin.menumine.core.incidence.IncidenceTableAggregationImpl;

public class MarketSizeIncidenceTable extends IncidenceTableAggregationImpl {

    public MarketSizeIncidenceTotals getMarketSizeTotals() {
        return (MarketSizeIncidenceTotals) this.getTotals();
    }
}
