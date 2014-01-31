/*
 * Created on May 5, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.webwork;

import org.jfree.chart.JFreeChart;

import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableIF;
import com.fsrin.menumine.core.menumine.webwork.util.GraphWriterUtilFactory;

public abstract class AbstractPriceTrendAction extends
        MenuMineDisplayStatisticalTableAction {

    protected static final String MEAN_PRICE_TREND = "Mean Price Trend";
    protected static final String MEDIAN_PRICE_TREND = "Median Price Trend";
    protected static final String VIEW_MEAN_TRENDLINE = "View Mean Trendline";
    protected static final String VIEW_TRENDLINE_GRAPH = "Trendline Graph";
    protected static final String DOWNLOAD_MEAN_PRICE_TREND_AS_EXCEL = "Download Mean Price Trend As Excel";
    
    private String submitOptionsMedian;
    
    private String imagePath;

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getSubmitOptionsMedian() {
        return submitOptionsMedian;
    }

    public void setSubmitOptionsMedian(String submitOptionsMedian) {
        this.submitOptionsMedian = submitOptionsMedian;
    }

    public abstract StatisticalTableIF getStatisticalTableResults();
    
    public abstract String getTitle();
    
    protected void buildTrendLine() throws Exception {
        /*
         * nick 2005-2-18 We chain here through the
         * menuMineDisplayAveragePriceTrendAction. This way it will be on the
         * stack and we can use it as a datasource for the stat tables as it
         * already handle the code to build a table.
         * 
         * 2006-05-05 RSC Refactored out.
         */
//
//        OgnlValueStack stack = ActionContext.getContext().getActionInvocation()
//                .getStack();

        StatisticalTableIF stats = this.getStatisticalTableResults();

        //  Collection results = stats.getRows();

        String number = "numberInSample";
        String label = "name";
        String titleString = getTitle();

        JFreeChart chart = new ChartBuilder().buildMeanPriceTrendLine(stats,
                titleString, 5);
        
        String path = new GraphWriterUtilFactory().build().write(chart);
        
        this.setImagePath(path);
    }
}
