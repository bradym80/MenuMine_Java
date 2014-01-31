/*
 * Created on Jan 21, 2005
 *
 * 
 */
package com.fsrin.menumine.core.profiler.xwork;

import java.util.Collection;
import java.util.Iterator;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryAxis3D;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import com.fsrin.menumine.core.profiler.aggregation.Profile;

/**
 * @author Nick
 * 
 *  
 */
public class ProfilerChartBuilder {

    public static ProfilerChartBuilder singleton = new ProfilerChartBuilder();

    private ProfilerChartBuilder() {
        super();

    }

    public JFreeChart buildApplicationChart(Collection data, String title,
            int numberOfSliceLimit) {
        // chart creation logic...
        DefaultCategoryDataset dataSeries2 = new DefaultCategoryDataset();

        try {
            int i = 0;
            double otherTotal = 0;
            for (Iterator iter = data.iterator(); iter
                    .hasNext()
                    && i < numberOfSliceLimit; i++) {

                Profile element = (Profile) iter.next();

                dataSeries2.addValue(element.getApplicationShare(), element
                        .getName(), element.getName());

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        JFreeChart chart = ChartFactory.createBarChart3D(title, "Application",
                "Share", dataSeries2, PlotOrientation.VERTICAL, false, false,
                false);

        CategoryAxis catAxis = new CategoryAxis3D("Sector");
        catAxis.setCategoryLabelPositions(CategoryLabelPositions.DOWN_45);

        ((CategoryPlot) chart.getPlot()).setDomainAxis(catAxis);
        chart.setBackgroundPaint(java.awt.Color.white);
        //  chart.addSubtitle(new ImageTitle( ));

        return chart;
    }

}