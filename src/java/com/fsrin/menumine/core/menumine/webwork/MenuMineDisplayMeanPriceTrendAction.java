/*
 * Created on 2005-1-18
 *
 */
package com.fsrin.menumine.core.menumine.webwork;

import org.springframework.util.StringUtils;

import com.fsrin.menumine.core.menumine.FieldEnum;
import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableBuilder;
import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableIF;

/**
 * @author Nick
 * @version 1
 */

public class MenuMineDisplayMeanPriceTrendAction extends
        AbstractPriceTrendAction {

    private StatisticalTableIF table;

    public String execute() throws Exception {
        super.execute();
        if (this.getSubmitOptions() != null
                && this.getSubmitOptions().equals(
                        AbstractPriceTrendAction.VIEW_TRENDLINE_GRAPH)) {
            this.getMenuMineDisplayOptions().setDisplayType(
                    AbstractPriceTrendAction.VIEW_MEAN_TRENDLINE);

            this.buildTrendLine();
            
        } else if (StringUtils.hasText(this.getSubmitOptionsMedian())) {
            return SUCCESS + "-median";
            
        } else {
            this.getMenuMineDisplayOptions().setDisplayType(
                    AbstractPriceTrendAction.MEAN_PRICE_TREND);
            
        }

        this.getMenuMineSessionContextWrapper().setLastGraphOptions(
                this.getMenuMineGraphOptions());

        return SUCCESS;

    }

    public StatisticalTableIF getStatisticalTableResults() {


        if (table == null) {


            try {
                table = new StatisticalTableBuilder()
                        .buildStatisticalTable_FromAggregation_WithPriceData(
                                this.getMenuMineSessionContextWrapper()
                                        .getLastFilterWrapper()
                                        .getMasterFoodFilterParameters(), this
                                        .getMenuMineGraphOptions(), this
                                        .getMenuMineSessionContextWrapper()
                                        .getRollUpOptions());

            } catch (Exception r) {
                r.printStackTrace();
                log.info(r.getStackTrace());
                return null;
            }
        }

        /*
         * We don't want this to hang out for too long.
         */
        this.getMenuMineSessionContextWrapper().getLastGraphOptions()
                .setSimpleFilter(null);
        /*
         * Cache the table;
         */
        this.getMenuMineSessionContextWrapper().setLastShareTable(table);
        return table;
    }



    public String getTitle() {
        String title = this.getMenuMineSessionContextWrapper()
                .getLastGraphOptions().getGraphTitle();

        if (title == null || title.equals("")) {
            String key = this.getMenuMineSessionContextWrapper()
                    .getLastGraphOptions().getGraphByField();

            FieldEnum f = FieldEnum.getByOgnlName(key);
            if (f != null) {

                title = f.getFriendlyName();
            }
        }
        String titleString = "MenuMine Mean Price Trendline - " + title;
        //  + " - % Distribution - Base: " + getResults().size();
        return titleString;

    }
    
}