/*
 * Created on 2005-1-18
 *
 */
package com.fsrin.menumine.core.menumine.webwork;

import java.util.Collection;

import ognl.Ognl;
import ognl.OgnlException;

import com.fsrin.menumine.core.menumine.FieldEnum;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParametersImpl;
import com.fsrin.menumine.core.menumine.masterfood.MasterFoodSearchException;
import com.fsrin.menumine.core.menumine.masterfood.MasterFoodServiceDelegateFactory;
import com.fsrin.menumine.core.menumine.masterfood.hql.MasterFoodQueryBuilder;
import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableBuilder;
import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableIF;

/**
 * @author Nick
 * @version 1
 */

public class MenuMineDisplayMedianPriceTrendAction extends
        AbstractPriceTrendAction {

    private static final String MEDIAN_PRICE_TREND = "Median Price Trend";

    private static final String VIEW_MEDIAN_TRENDLINE = "View Median Trendline";

    private static final String VIEW_TRENDLINE_GRAPH = "Trendline Graph";

    private static final String DOWNLOAD_MEDIAN_PRICE_TREND_AS_EXCEL = "Download Median Price Trend As Excel";

    private StatisticalTableIF table;
    
    
    
    

    public String execute() throws Exception {
        super.execute();
        
        this.setSubmitOptions(this.getSubmitOptionsMedian());
        
        if (this.getSubmitOptionsMedian() != null
                && this.getSubmitOptionsMedian().equals(VIEW_TRENDLINE_GRAPH)) {
            this.getMenuMineDisplayOptions().setDisplayType(
                    VIEW_MEDIAN_TRENDLINE);

            this.buildTrendLine();
        } else {
            this.getMenuMineDisplayOptions().setDisplayType(MEDIAN_PRICE_TREND);
        }

        this.getMenuMineSessionContextWrapper().setLastGraphOptions(
                this.getMenuMineGraphOptions());
        return SUCCESS;

    }

    public StatisticalTableIF getStatisticalTableResults() {


        if (table == null) {
            MasterFoodFilterParameters prices = new MasterFoodFilterParametersImpl();

            prices.getPrice1996().setSelect(true);
            prices.getPrice1997().setSelect(true);
            prices.getPrice1998().setSelect(true);
            prices.getPrice1999().setSelect(true);
            prices.getPrice2000().setSelect(true);
            prices.getPrice2001().setSelect(true);
            prices.getPrice2002().setSelect(true);
            prices.getPrice2003().setSelect(true);
            prices.getPrice2004().setSelect(true);
            prices.getPrice2005().setSelect(true);
            prices.getPrice2006().setSelect(true);
            //JDL 10-5-07
            prices.getPrice2007().setSelect(true);
            
            // DBB 1-20-2009 Add 2008, 2009
            prices.getPrice2008().setSelect(true);
            prices.getPrice2009().setSelect(true);
            // MJB 11-12-2009 Added 2010
            prices.getPrice2010().setSelect(true);
            prices.getPrice2011().setSelect(true);

            try {
                Ognl.setValue(this.getMenuMineGraphOptions().getGraphByField()
                        + ".select", prices, Boolean.TRUE);
            } catch (OgnlException e) {
                throw new RuntimeException("failed in price setup.", e);
            }

            StringBuffer sb = new MasterFoodQueryBuilder().getQueryForCrossTab(
                    prices, this.getMenuMineSessionContextWrapper()
                            .getLastFilterWrapper()
                            .getMasterFoodFilterParameters());



            Collection c;
            try {
                c = MasterFoodServiceDelegateFactory.factory.build()
                        .searchMasterFoodByHQL(sb.toString(), prices);
            } catch (MasterFoodSearchException e) {
                throw new RuntimeException("query failed dramatically.");
            }

            try {
                table = new StatisticalTableBuilder()
                        .buildStatisticalTableFromCollection_WithoutAggregation(c, this
                                        .getMenuMineGraphOptions(), this
                                        .getMenuMineSessionContextWrapper()
                                        .getRollUpOptions());

            } catch (Exception r) {
                r.printStackTrace();
                log.info(r.getStackTrace());
                return null;
            }
        }
        
        return table;
    }
    
//    private void buildTrendLine() {
//        /*
//         * nick 2005-2-18 We chain here through the
//         * menuMineDisplayAveragePriceTrendAction. This way it will be on the
//         * stack and we can use it as a datasource for the stat tables as it
//         * already handle the code to build a table.
//         */
//
////        OgnlValueStack stack = ActionContext.getContext().getActionInvocation()
////                .getStack();
////
////        StatisticalTableIF stats = (StatisticalTableIF) stack
////                .findValue("statisticalTableResults");
//
//        Statis
//        //  Collection results = stats.getRows();
//
//        String number = "numberInSample";
//        String label = "name";
//        String titleString = getTitle();
//
//        JFreeChart chart = new ChartBuilder().buildMedianPriceTrendLine(stats,
//                titleString, 5);
//    }

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

        StringBuffer titleString = new StringBuffer();

        titleString.append("MenuMine Median Price Trendline");
        if (title == null || title.equals("")) {
            titleString.append(" - ").append(title);
        }

        return titleString.toString();

    }







}