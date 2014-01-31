/*
 * Created on May 16, 2006 by Reid
 * MJB 11-12-2009 Increased by one year to 2009 vs 5 years ago.
 */
package com.fsrin.menumine.core.menumine.webwork;

import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;
import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableBuilder;

public abstract class AbstractChainTableTrendAction extends
        AbstractTrendTableAction {

    private String trendType = "Chain";

    public String getTrendType() {
        return trendType;
    }
    
    public String execute() throws Exception {
        super.execute();

        MasterFoodFilterParameters p = this.getMenuMineSessionContextWrapper()
                .getLastFilterWrapper().getMasterFoodFilterParameters().clone();

        p.getYearPutInDatabaseSameStore().getAndValues().clear();
        // p.getYearPutInDatabaseSameStore().getAndValues().add("2001");
        // DBB 1-20-2009 Use 2003 rather than 2002
        p.getYearPutInDatabaseSameStore().getAndValues().add("2006");
        //p.getPrice2005().setEmpty(Boolean.FALSE);
        
        // DBB 1-20-2009 Use 2008 rather than 2007 
        p.getPrice2011().setEmpty(Boolean.FALSE);
        p.getSectorName().getOrValues().clear();
        p.getSectorName().getOrValues().add("chain");

        /*this
                .setTrend2005(new StatisticalTableBuilder()
                        .buildStatisticalTable_FromAggregation(p, this
                                .getMenuMineGraphOptions(), this
                                .getMenuMineSessionContextWrapper()
                                .getRollUpOptions()));*/
        
        this
        .setTrend2011(new StatisticalTableBuilder()
                .buildStatisticalTable_FromAggregation(p, this
                        .getMenuMineGraphOptions(), this
                        .getMenuMineSessionContextWrapper()
                        .getRollUpOptions()));

        //p.getPrice2005().setEmpty(null);
        p.getPrice2011().setEmpty(null);
        //p.getPrice2001().setEmpty(Boolean.FALSE);
        p.getPrice2006().setEmpty(Boolean.FALSE);

        /*thisAbstractChainTableTrendAction
                .setTrend2001(new StatisticalTableBuilder()
                        .buildStatisticalTable_FromAggregation(p, this
                                .getMenuMineGraphOptions(), this
                                .getMenuMineSessionContextWrapper()
                                .getRollUpOptions()));*/
        
        this
        .setTrend2006(new StatisticalTableBuilder()
                .buildStatisticalTable_FromAggregation(p, this
                        .getMenuMineGraphOptions(), this
                        .getMenuMineSessionContextWrapper()
                        .getRollUpOptions()));
        
        return SUCCESS;

    }
}
