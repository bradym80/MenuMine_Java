/*
 * Created on Jan 20, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.webwork;

import org.jfree.chart.JFreeChart;

import com.fsrin.menumine.context.webwork.AbstractMenuMineSessionContextAwareAction;
import com.fsrin.menumine.core.menumine.FieldEnum;
import com.fsrin.menumine.core.menumine.masterfood.MasterFoodServiceDelegate;
import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableIF;
import com.opensymphony.xwork.Action;
import com.opensymphony.xwork.ActionContext;
import com.opensymphony.xwork.util.OgnlValueStack;

/**
 * @author Nick
 * 
 *  
 */
public class ViewMedianPriceTrendlineGraphAction extends AbstractMenuMineSessionContextAwareAction {

    private JFreeChart chart;



    private MasterFoodServiceDelegate masterFoodServiceDelegate;

    public String execute() throws Exception {

        buildTrendLine();
        return Action.SUCCESS;
    }

    private void buildTrendLine() {
        /*
         * nick 2005-2-18 We chain here through the
         * menuMineDisplayAveragePriceTrendAction. This way it will be on the
         * stack and we can use it as a datasource for the stat tables as it
         * already handle the code to build a table.
         */

        OgnlValueStack stack = ActionContext.getContext().getActionInvocation()
                .getStack();

        StatisticalTableIF stats = (StatisticalTableIF) stack
                .findValue("statisticalTableResults");

        //  Collection results = stats.getRows();

        String number = "numberInSample";
        String label = "name";
        String titleString = getTitle();

        chart = new ChartBuilder().buildMedianPriceTrendLine(stats,
                titleString, 5);
    }

    private String getTitle() {
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

    public JFreeChart getChart() {
        return chart;
    }

//    public MenuMineSessionContextWrapper getMenuMineSessionContextWrapper() {
//        return menuMineSessionContextWrapper;
//    }
//
//    public void setMenuMineSessionContextWrapper(
//            MenuMineSessionContextWrapper menuMineSessionContextWrapper) {
//        this.menuMineSessionContextWrapper = menuMineSessionContextWrapper;
//    }

    //    private Collection results;
    //
    //    public Collection getResults() {
    //        MasterFoodFilterParameters filter = this
    //                .getMenuMineSessionContextWrapper().getLastFilter();
    //
    //        if (filter == null) {
    //            return null;
    //        }
    //        if (results == null) {
    //
    //            try {
    //                //filter.setLimit(new Long(1000));
    //
    //                results = this.getMasterFoodServiceDelegate().searchMasterFood(
    //                        filter);
    //
    //            } catch (MasterFoodSearchException e) {
    //                this.addActionError("Unknown error encountered during query.");
    //                results = null;
    //            }
    //
    //        }
    //        return results;
    //    }
    //
    //    public StatisticalTable getStatisticalTableResults() {
    //
    //        if (this.getResults() == null) {
    //            return null;
    //        }
    //        try {
    //            return MenuMineResultsDisplayWrapperBuilder.singleton
    //                    .buildStatisticalTableFromCollection(this.getResults(),
    //                            this.getMenuMineSessionContextWrapper()
    //                                    .getLastGraphOptions());
    //        } catch (OgnlException e) {
    //
    //            e.printStackTrace();
    //            return null;
    //        }
    //    }

    //    public MasterFoodServiceDelegate getMasterFoodServiceDelegate() {
    //        return masterFoodServiceDelegate;
    //    }
    //
    //    public void setMasterFoodServiceDelegate(
    //            MasterFoodServiceDelegate masterFoodServiceDelegate) {
    //        this.masterFoodServiceDelegate = masterFoodServiceDelegate;
    //    }
}