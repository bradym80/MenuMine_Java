/*
 * Created on Jul 25, 2006
 *
 */
package com.fsrin.menumine.core.menumine.marketsize.xwork;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.jfree.chart.JFreeChart;

import com.fsrin.menumine.core.menumine.marketsize.MarketSizeIncidenceTable;
import com.fsrin.menumine.core.menumine.webwork.ChartBuilder;
import com.fsrin.menumine.core.menumine.webwork.util.GraphWriterUtilFactory;
import com.opensymphony.xwork.Action;

public class DisplayMarketSizeProjectorGraphAction extends
        AbstractMarketSizeAction {

    public static final String CHART_TYPE_PIE = "pie";

    public static final String CHART_TYPE_BAR = "bar";

    private String submitMarketSizeBar;

    private String submitMarketSizePie;

    private String imagePath;

    public String execute() throws Exception {

        String chartType = getChartType();

        JFreeChart chart = null;

        if (chartType != null && chartType.indexOf(CHART_TYPE_PIE) > -1) {
            chart = this.getPieChart(this.getMarketSizeProjectorContext()
                    .getMarketSizeIncidenceTable());
        } else {
            chart = this.getBarChart(this.getMarketSizeProjectorContext()
                    .getMarketSizeIncidenceTable());
        }

        String fileName = new GraphWriterUtilFactory().build().write(chart);

        this.setImagePath(fileName);

        return Action.SUCCESS;

    }

    private String getChartType() {

        String ret = CHART_TYPE_PIE;

        if (this.getSubmitMarketSizePie() != null) {

        } else {
            ret = CHART_TYPE_BAR;
        }

        return ret;

    }

    private String getTitle() {

        NumberFormat nf = new DecimalFormat("#,##0");

        String ret = "Category Size: ";

        ret += ""
                + nf.format(this.getMarketSizeProjectorContext()
                        .getMarketSizeIncidenceTable().getMarketSizeTotals()
                        .getProjectedMarketSize());

        ret += " "
                + this.getMarketSizeProjectorContext().getMarketSizeOptions()
                        .getResultLabel();

        return ret;
    }

    private JFreeChart getPieChart(
            MarketSizeIncidenceTable marketSizeIncidenceTable) throws Exception {

        JFreeChart chart = new ChartBuilder().buildPieChart(
                marketSizeIncidenceTable.getIncidenceSectors(),
                "projectedMarketSize", "name", getTitle(), 23);

        return chart;
    }

    private JFreeChart getBarChart(
            MarketSizeIncidenceTable marketSizeIncidenceTable) {

        JFreeChart chart = new ChartBuilder().buildBarChart(
                marketSizeIncidenceTable.getIncidenceSectors(),
                "projectedMarketSize", "name", getTitle(), 18,
                "Market Size ("
                        + this.getMarketSizeProjectorContext()
                                .getMarketSizeOptions().getResultLabel() + ")",
                "Sectors");

        return chart;
    }

    public String getSubmitMarketSizeBar() {
        return submitMarketSizeBar;
    }

    public void setSubmitMarketSizeBar(String submitMarketSizeBar) {
        this.submitMarketSizeBar = submitMarketSizeBar;
    }

    public String getSubmitMarketSizePie() {
        return submitMarketSizePie;
    }

    public void setSubmitMarketSizePie(String submitMarketSizePie) {
        this.submitMarketSizePie = submitMarketSizePie;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

}
