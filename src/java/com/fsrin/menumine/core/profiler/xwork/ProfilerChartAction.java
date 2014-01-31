/*
 * Created on Apr 5, 2005
 *
 * 
 */
package com.fsrin.menumine.core.profiler.xwork;

import java.util.Collection;

import org.jfree.chart.JFreeChart;

import com.fsrin.menumine.core.profiler.aggregation.AggregatedProfileBuilder;

/**
 * @author Nick
 * 
 * 
 */

public class ProfilerChartAction extends AbstractProfileContextAware {

    // private MenuMineSessionContextWrapper menuMineSessionContextWrapper;

    private JFreeChart chart;

    public String execute() throws Exception {

        Collection applications = new AggregatedProfileBuilder()
                .buildApplications(this.getProfileContext()
                        .getFieldListProvider(), this.getProfileContext()
                        .getSearchString());

        String titleString = "Profiler: "
                + this.getProfileContext().getSearchString();

        int maxLines = 15;

        chart = ProfilerChartBuilder.singleton.buildApplicationChart(
                applications, titleString, maxLines);

        return SUCCESS;

    }

    public JFreeChart getChart() {
        return chart;
    }

}