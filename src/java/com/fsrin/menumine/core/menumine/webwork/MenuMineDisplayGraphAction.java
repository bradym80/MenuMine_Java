/*
 * Created on 2005-1-18
 *
 */
package com.fsrin.menumine.core.menumine.webwork;

import org.jfree.chart.JFreeChart;

import com.fsrin.menumine.context.util.BuildStatisticalTableFromActionDelegate;
import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableIF;
import com.fsrin.menumine.core.menumine.webwork.util.GraphWriterUtilFactory;

/**
 * @author Nick
 * @version 1
 */

public class MenuMineDisplayGraphAction extends AbstractMenuMineDisplayAction {

    public static final String CHART_TYPE_PIE = "pie";

    

    private String imagePath;

    

    /**
     * 2006-05-08 RSC Note that when we get here from the quick links on the field names, 
     * it keeps the last used graph type.  So if the last graph type was a bar graph, 
     * that's what it does.
     */
    public String execute() throws Exception {
        super.execute();

        // this.getMenuMineSessionContextWrapper().setLastGraphOptions(
        // this.getMenuMineGraphOptions());

        this.getMenuMineDisplayOptions().setDisplayType(MenuMineDisplayOptions.DISPLAY_TYPE_GRAPH);

        handleBuild();

        return SUCCESS;

    }

    public void handleBuild() throws Exception {

        StatisticalTableIF table = new BuildStatisticalTableFromActionDelegate()
                .build(this);

        String chartType = this.getMenuMineSessionContextWrapper()
                .getLastGraphOptions().getGraphByType().toLowerCase();

        JFreeChart chart = null;

        if (chartType != null && chartType.indexOf(CHART_TYPE_PIE) > -1) {
            chart = this.getPieChart(table);
        } else {
            chart = this.getBarChart(table);
        }

        String fileName = new GraphWriterUtilFactory().build().write(chart);

        this.setImagePath(fileName);

    }

    private JFreeChart getPieChart(StatisticalTableIF table) throws Exception {

        JFreeChart chart = new ChartBuilder().buildPieChart(table.getRows(),
                "numberInSample", "name", this
                        .getTitle(table.getSizeOfSample()), 23);

        return chart;
    }

    private JFreeChart getBarChart(StatisticalTableIF table) {

        JFreeChart chart = new ChartBuilder().buildBarChart(table.getRows(),
                "percent", "name", this.getTitle(table.getSizeOfSample()), 18);

        return chart;
    }

    private String getTitle(Long sizeOfSample) {
        String title = this.getMenuMineSessionContextWrapper()
                .getLastGraphOptions().getGraphTitle();

        if (title == null || title.equals("")) {
            String key = this.getMenuMineSessionContextWrapper()
                    .getLastGraphOptions().getGraphByField();

        }

        String base = null;

        if (sizeOfSample == null)
            base = "(unknown)";
        else
            base = sizeOfSample.toString();

        String titleString = "MenuMine - " + title
                + " - % Distribution - Base:  " + base;

        return titleString;

    }





    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

}