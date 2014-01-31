/*
 * Created on Jan 31, 2006 by Reid
 */
package com.fsrin.menumine.core.incidence;

import java.util.Collection;

public class IncidenceTableAggregationImpl implements IncidenceTable {

    private Collection incidenceSectors;

    private Integer year;

    private IncidenceTotals totals;

    public Collection getIncidenceSectors() {
        return incidenceSectors;
    }

    public void setIncidenceSectors(Collection incidenceSectors) {
        this.incidenceSectors = incidenceSectors;
    }

    public IncidenceTotals getTotals() {
        return totals;
    }

    public void setTotals(IncidenceTotals incidenceTotals) {
        this.totals = incidenceTotals;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
