/*
 * Created on Jul 25, 2006
 *
 */
package com.fsrin.menumine.core.incidence.trend.xwork;

import com.fsrin.menumine.core.incidence.trend.IncidenceTableTrend;
import com.fsrin.menumine.core.incidence.trend.IncidenceTableTrendBuilder;
import com.opensymphony.xwork.Action;

public class DisplayCategoryIncidenceTrendAction extends AbstractIncidenceTrendAction {

    private IncidenceTableTrend trendTable;
    
    public String execute() throws Exception {

        IncidenceTableTrendBuilder builder = new IncidenceTableTrendBuilder();

        IncidenceTableTrend incidenceTableTrend = builder.build(this
                .getMenuMineSessionContextWrapper().getLastFilterWrapper()
                .getMasterFoodFilterParameters());

        this.setTrendTable(incidenceTableTrend);
        
        this.getIncidenceTrendContext().setIncidenceTableTrend(incidenceTableTrend);
        
        return Action.SUCCESS;
    }

    public IncidenceTableTrend getTrendTable() {
        return trendTable;
    }

    public void setTrendTable(IncidenceTableTrend trendTable) {
        this.trendTable = trendTable;
    }

}
