/*
 * Created on Jan 20, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.webwork;

import java.util.Collection;

import ognl.OgnlException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jfree.chart.JFreeChart;

import com.fsrin.menumine.context.util.BuildStatisticalTableFromActionDelegate;
import com.fsrin.menumine.context.webwork.AbstractMenuMineSessionContextAwareAction;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;
import com.fsrin.menumine.core.menumine.masterfood.MasterFoodSearchException;
import com.fsrin.menumine.core.menumine.masterfood.MasterFoodServiceDelegate;
import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableBuilder;
import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableIF;
import com.opensymphony.xwork.Action;

/**
 * 2006-01-27 Refactored to use different total generator.
 * 
 * @author Reid
 * @author Nick
 * 
 * 
 */
public class ViewGraphAction extends AbstractMenuMineSessionContextAwareAction {

    private static Log log = LogFactory.getLog(ViewGraphAction.class);

    public static final String CHART_TYPE_PIE = "pie";

    private JFreeChart chart;

    // private MenuMineSessionContextWrapper menuMineSessionContextWrapper;

    private MasterFoodServiceDelegate masterFoodServiceDelegate;

    // private String chartType;
    //
    // public String getChartType() {
    // return chartType;
    // }
    //
    // public void setChartType(String chartType) {
    // this.chartType = chartType;
    // }

    public String execute() throws Exception {

//        StatisticalTableIF table = new StatisticalTableBuilder()
//                .buildStatisticalTable_FromAggregation(
//                        this.getMenuMineSessionContextWrapper()
//                                .getLastFilterWrapper()
//                                .getMasterFoodFilterParameters(), this
//                                .getMenuMineSessionContextWrapper()
//                                .getLastGraphOptions(), this
//                                .getMenuMineSessionContextWrapper()
//                                .getRollUpOptions());

        StatisticalTableIF table = new BuildStatisticalTableFromActionDelegate().build(this);
        
        String chartType = this.getMenuMineSessionContextWrapper()
                .getLastGraphOptions().getGraphByType().toLowerCase();

        if (chartType != null && chartType.indexOf(CHART_TYPE_PIE) > -1) {
            this.getPieChart(table);
        } else {
            this.getBarChart(table);
        }
        
        
        return Action.SUCCESS;
    }

    /*
     * 2006-01-27 RSC Refactored out so it can be used elsewhere.
     */
    // private Collection getGraphItems() {
    // /*
    // * get the parameters
    // */
    // StringBuffer s = new MasterFoodQueryBuilder()
    // .getQueryForCountWithGroupBy(
    // this.getMenuMineSessionContextWrapper()
    // .getLastFilterWrapper()
    // .getMasterFoodFilterParameters(), this
    // .getMenuMineSessionContextWrapper()
    // .getLastGraphOptions().getGraphByField());
    //        
    // log.info("query: " + s);
    //        
    // Collection items = GenericDAOFactory.factory.build().find(s.toString());
    //        
    // return items;
    // }
    private void getPieChart(StatisticalTableIF table) throws Exception {

        // Collection items = new StatisticalTableSupport()
        // .getStatisticalTable(this.getMenuMineSessionContextWrapper());
        //        
        // chart = new ChartBuilder().buildPieChart(items, "count", "group",
        // this
        // .getTitle(items), 23);

        chart = new ChartBuilder().buildPieChart(table.getRows(), "numberInSample",
                "name", this.getTitle(table.getSizeOfSample()), 23);

    }

    /*
     * this is the original get pie chart.
     */
    // private void getPieChart_original() {
    // Collection col = this.getStatisticalTableResults().getRows();
    //
    // // String number = "percent";
    // String number = "numberInSample";
    // String label = "name";
    // String titleString = getTitle();
    //
    // /*
    // * The chart builder uses OGNL to build find the values. number and
    // * label must be getters for the object in the collection.
    // *
    // */
    // chart = new ChartBuilder().buildPieChart(col, number, label,
    // titleString, 23);
    //
    // }
    private void getBarChart(StatisticalTableIF table) {
        /*
         * 2006-01-27 RSC This was the original
         */
        // Collection col = this.getStatisticalTableResults().getRows();
        // String number = "percent";
        // String label = "name";
        //
        // String titleString = getTitle();
        // chart = new ChartBuilder().buildBarChart(col, number, label,
        // titleString, 18);
        // Collection items = new StatisticalTableSupport()
        // .getStatisticalTable(this.getMenuMineSessionContextWrapper());
        //
        // chart = new ChartBuilder().buildBarChart(items, "count", "group",
        // this
        // .getTitle(items), 18);
        chart = new ChartBuilder().buildBarChart(table.getRows(), "percent",
                "name", this.getTitle(table.getSizeOfSample()), 18);
    }

    private String getTitle(Long sizeOfSample) {
        String title = this.getMenuMineSessionContextWrapper()
                .getLastGraphOptions().getGraphTitle();

        if (title == null || title.equals("")) {
            String key = this.getMenuMineSessionContextWrapper()
                    .getLastGraphOptions().getGraphByField();

            // title = (String) FieldListBuilder.singleton.buildFieldList().get(
            // key);
        }
        // String titleString = "MenuMine - " + title
        // + " - % Distribution - Base: " + getResults().size();

        /*
         * 2006-03-09 RSC
         */
        // String titleString = "MenuMine - " + title
        // + " - % Distribution - Base: "
        // + new GroupCounterTotaller().getTotal(items);
        String base = null;

        if (sizeOfSample == null)
            base = "(unknown)";
        else
            base = sizeOfSample.toString();

        String titleString = "MenuMine - " + title
                + " - % Distribution - Base:  " + base;

        return titleString;

    }

    public JFreeChart getChart() {
        return chart;
    }

    // public MenuMineSessionContextWrapper getMenuMineSessionContextWrapper() {
    // return menuMineSessionContextWrapper;
    // }
    //
    // public void setMenuMineSessionContextWrapper(
    // MenuMineSessionContextWrapper menuMineSessionContextWrapper) {
    // this.menuMineSessionContextWrapper = menuMineSessionContextWrapper;
    // }

    private Collection results;

    public Collection getResults() {
        MasterFoodFilterParameters filter = this
                .getMenuMineSessionContextWrapper().getLastFilterWrapper()
                .getMasterFoodFilterParameters();

        if (filter == null) {
            return null;
        }
        if (results == null) {

            try {
                // filter.setLimit(new Long(1000));

                results = this.getMasterFoodServiceDelegate().searchMasterFood(
                        filter);

            } catch (MasterFoodSearchException e) {
                this.addActionError("Unknown error encountered during query.");
                results = null;
            }

        }
        return results;
    }

    public StatisticalTableIF getStatisticalTableResults() {

        if (this.getResults() == null) {
            return null;
        }
        try {
            return new StatisticalTableBuilder()
                    .buildStatisticalTableFromCollection_WithoutAggregation(
                            this.getResults(), this
                                    .getMenuMineSessionContextWrapper()
                                    .getLastGraphOptions(), this
                                    .getMenuMineSessionContextWrapper()
                                    .getRollUpOptions());
        } catch (OgnlException e) {

            e.printStackTrace();
            return null;
        }
    }

    public MasterFoodServiceDelegate getMasterFoodServiceDelegate() {
        return masterFoodServiceDelegate;
    }

    public void setMasterFoodServiceDelegate(
            MasterFoodServiceDelegate masterFoodServiceDelegate) {
        this.masterFoodServiceDelegate = masterFoodServiceDelegate;
    }
}