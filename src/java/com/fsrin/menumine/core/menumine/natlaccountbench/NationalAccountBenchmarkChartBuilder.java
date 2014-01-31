/*
 * Created on Jul 5, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.natlaccountbench;

import java.awt.Color;
import java.util.Iterator;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryAxis3D;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.data.category.DefaultCategoryDataset;

import com.fsrin.menumine.core.menumine.natlaccountbench.xwork.ChartBuilder;

/**
 * @author Nick
 * 
 *  
 */
public class NationalAccountBenchmarkChartBuilder implements ChartBuilder {

    public NationalAccountBenchmarkChartBuilder() {
        super();

    }

    public JFreeChart build(Object results, String titleString, int i) {

        return this.build((NationalAccountBenchmarkTable) results, titleString,
                i);
    }

    public JFreeChart build(NationalAccountBenchmarkTable results,
            String titleString, int limit) {

        if (results == null || results.getRows() == null) {
            return null;
        }
        if (limit > 10) {
            limit = 10;
        }

        DefaultCategoryDataset dataSeries1 = new DefaultCategoryDataset();

        DefaultCategoryDataset dataSeries2 = new DefaultCategoryDataset();

        int i = 0;
        double otherTotal = 0;
        for (Iterator iter = results.getRows().iterator(); iter.hasNext()
                && i < limit; i++) {

            NationalAccountBenchmarkElement element = (NationalAccountBenchmarkElement) iter
                    .next();

            dataSeries1.addValue(element.getPercentOfTarget(), "Target "
                    + element.getName(), element.getName());

            dataSeries2.addValue(element.getPercentOfBenchmark(), "Benchmark "
                    + element.getName(), element.getName());

        }

        JFreeChart chart = ChartFactory.createBarChart3D(titleString,
                "Elements", "Share", dataSeries1, PlotOrientation.VERTICAL,
                true, true, true);
        CategoryAxis catAxis = new CategoryAxis3D("Elements");
        catAxis.setCategoryLabelPositions(CategoryLabelPositions.DOWN_45);

        ((CategoryPlot) chart.getPlot()).setDomainAxis(catAxis);
        chart.setBackgroundPaint(java.awt.Color.white);

        double xOffset = ((BarRenderer3D) ((CategoryPlot) chart.getPlot())
                .getRenderer()).getXOffset();
        double yOffset = ((BarRenderer3D) ((CategoryPlot) chart.getPlot())
                .getRenderer()).getYOffset();

        /*
         * We need to add the benchmark series
         */
        BarRenderer3D ibr = new BarRenderer3D(xOffset + 10.0, yOffset + 5.0);

        ((CategoryPlot) chart.getPlot()).setRenderer(2, ibr);
        ((CategoryPlot) chart.getPlot()).setDataset(2, dataSeries2);

        ((CategoryPlot) chart.getPlot()).getRenderer().setSeriesPaint(0,
                Color.RED);
        ((CategoryPlot) chart.getPlot()).getRenderer(2).setSeriesPaint(0,
                Color.RED.darker().darker());

        ((CategoryPlot) chart.getPlot()).getRenderer().setSeriesPaint(1,
                Color.BLUE);
        ((CategoryPlot) chart.getPlot()).getRenderer(2).setSeriesPaint(1,
                Color.BLUE.darker().darker());

        ((CategoryPlot) chart.getPlot()).getRenderer().setSeriesPaint(2,
                Color.GREEN);
        ((CategoryPlot) chart.getPlot()).getRenderer(2).setSeriesPaint(2,
                Color.GREEN.darker().darker());

        ((CategoryPlot) chart.getPlot()).getRenderer().setSeriesPaint(3,
                Color.CYAN);
        ((CategoryPlot) chart.getPlot()).getRenderer(2).setSeriesPaint(3,
                Color.CYAN.darker().darker());

        ((CategoryPlot) chart.getPlot()).getRenderer().setSeriesPaint(4,
                Color.ORANGE);
        ((CategoryPlot) chart.getPlot()).getRenderer(2).setSeriesPaint(4,
                Color.ORANGE.darker().darker());

        ((CategoryPlot) chart.getPlot()).getRenderer().setSeriesPaint(5,
                Color.MAGENTA);
        ((CategoryPlot) chart.getPlot()).getRenderer(2).setSeriesPaint(5,
                Color.MAGENTA.darker().darker());

        ((CategoryPlot) chart.getPlot()).getRenderer().setSeriesPaint(6,
                Color.PINK);
        ((CategoryPlot) chart.getPlot()).getRenderer(2).setSeriesPaint(6,
                Color.PINK.darker().darker());

        ((CategoryPlot) chart.getPlot()).getRenderer().setSeriesPaint(7,
                Color.YELLOW);
        ((CategoryPlot) chart.getPlot()).getRenderer(2).setSeriesPaint(7,
                Color.YELLOW.darker().darker());

        ((CategoryPlot) chart.getPlot()).getRenderer().setSeriesPaint(8,
                Color.RED.darker());
        ((CategoryPlot) chart.getPlot()).getRenderer(2).setSeriesPaint(8,
                Color.RED.darker().darker().darker());

        ((CategoryPlot) chart.getPlot()).getRenderer().setSeriesPaint(9,
                Color.BLUE.darker());
        ((CategoryPlot) chart.getPlot()).getRenderer(2).setSeriesPaint(9,
                Color.BLUE.darker().darker().darker());

        ((CategoryPlot) chart.getPlot()).getRenderer().setSeriesPaint(10,
                Color.GREEN.darker());
        ((CategoryPlot) chart.getPlot()).getRenderer(2).setSeriesPaint(10,
                Color.GREEN.darker().darker().darker());

        ((CategoryPlot) chart.getPlot()).getRenderer().setSeriesPaint(11,
                Color.CYAN.darker());
        ((CategoryPlot) chart.getPlot()).getRenderer(2).setSeriesPaint(11,
                Color.CYAN.darker().darker().darker());

        ((CategoryPlot) chart.getPlot()).getRenderer().setSeriesPaint(12,
                Color.ORANGE.darker());
        ((CategoryPlot) chart.getPlot()).getRenderer(2).setSeriesPaint(12,
                Color.ORANGE.darker().darker().darker());

        ((CategoryPlot) chart.getPlot()).getRenderer().setSeriesPaint(13,
                Color.MAGENTA.darker());
        ((CategoryPlot) chart.getPlot()).getRenderer(2).setSeriesPaint(13,
                Color.MAGENTA.darker().darker().darker());

        ((CategoryPlot) chart.getPlot()).getRenderer().setSeriesPaint(14,
                Color.PINK.darker());
        ((CategoryPlot) chart.getPlot()).getRenderer(2).setSeriesPaint(14,
                Color.PINK.darker().darker().darker());

        ((CategoryPlot) chart.getPlot()).getRenderer().setSeriesPaint(15,
                Color.YELLOW.darker());
        ((CategoryPlot) chart.getPlot()).getRenderer(2).setSeriesPaint(15,
                Color.YELLOW.darker().darker().darker());

        return chart;
    }

}