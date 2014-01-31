/*
 * Created on Sep 14, 2006 by Reid
 */
package com.fsrin.menumine.core.incidence.trend;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class IncidenceTableTrend {

    private IncidenceTrendTotals trendTotals = new IncidenceTrendTotals();

    private Map incidenceTrendHeaders = new HashMap();

    public IncidenceTrendTotals getTrendTotals() {
        return trendTotals;
    }

    public void setTrendTotals(
            IncidenceTrendTotals incidenceTableTrendTotals) {
        this.trendTotals = incidenceTableTrendTotals;
    }

    public Map getIncidenceTrendHeaders() {
        return incidenceTrendHeaders;
    }

    public void setIncidenceTrendHeaders(Map incidenceTrendHeaders) {
        this.incidenceTrendHeaders = incidenceTrendHeaders;
    }
    
    public Collection getSortedTrendHeaders() {
        
        Collection ret = new TreeSet();
        
        ret.addAll(this.getIncidenceTrendHeaders().values());
        
        return ret;
    }
    
    
}
