/*
 * Created on Jan 21, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.webwork;

import java.text.DecimalFormat;
import java.util.Collection;
import java.util.Iterator;

import ognl.Ognl;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryAxis3D;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.chart.urls.StandardPieURLGenerator;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import com.fsrin.menumine.core.incidence.IncidenceSector;
import com.fsrin.menumine.core.incidence.IncidenceTable;
import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableElementIF;
import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableIF;

/**
 * @author Nick
 * 
 * 
 */
public class ChartBuilder {

    /*
     * 2006-01-24 RSC Why a singleton?
     */
    // public static ChartBuilder singleton = new ChartBuilder();

    public JFreeChart buildPieChart(Collection data, String number,
            String label, String title, int numberOfSliceLimit) {
        // TreeSet treeSet = new TreeSet(new MMSorter().getAscending(label,
        // number));
        // treeSet.addAll(data);

        DefaultPieDataset pieDataset = new DefaultPieDataset();

        /*
         * Seed Other first. This help when we rotate the pie, we split the
         * smaller slices, so half of the lables are on each side.
         */
        if (data.size() > numberOfSliceLimit) {
            pieDataset.setValue("Other", new Double(0));
        }

        /*
         * We assume that the data is sorted already.
         */
        try {
            int i = 0;
            /*
             * We have to record the total of the types not included in the
             * first numberOfSliceLimit.
             */
            double otherTotal = 0;
            for (Iterator iter = data.iterator(); iter.hasNext(); i++) {
                Object element = iter.next();
                if (i < numberOfSliceLimit) {

                    Number numberObject = new Long(0);
                    Comparable labelObject = "Not on Menu";

                    if (Ognl.getValue(number, element) instanceof Number) {
                        numberObject = (Number) Ognl.getValue(number, element);
                    }

                    if (Ognl.getValue(label, element) instanceof Comparable) {
                        labelObject = (Comparable) Ognl
                                .getValue(label, element);
                    }
                    /*
                     * If we have an "Other" lable we need it rolled with the
                     * Other after the numberOfSliceLimit.
                     */
                    if (labelObject.equals("Other")) {
                        otherTotal += numberObject.doubleValue();
                    } else {
                        pieDataset.setValue(labelObject, numberObject);
                    }
                } else {

                    Number numberObject = new Long(0);
                    if (Ognl.getValue(number, element) instanceof Number) {
                        Object o = Ognl.getValue(number, element);
                        numberObject = (Number) o;
                        otherTotal += numberObject.doubleValue();
                    }
                }
            }

            if (otherTotal > 0) {
                pieDataset.setValue("Other", new Double(otherTotal));
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        /*
         * Nick {0} = {1} ({2}) tells JFree Chart how to build the label {0} is
         * the text lable {1} is the Count {2} is the percent of the graph this
         * slice take up calculated as a decimal. Adding the % to the Decimal
         * Format displays .01 as 1%.
         */
        PiePlot3D plot = new PiePlot3D(pieDataset);
        StandardPieSectionLabelGenerator labelGen = new StandardPieSectionLabelGenerator(
                "{0} = {2}", new DecimalFormat("#,##0;(#,##0)"),
                new DecimalFormat("#,##0.0%;(#,##0.0)"));

        StandardPieToolTipGenerator toolTipGen = new StandardPieToolTipGenerator(
                "{0} = {1} ({2})", new DecimalFormat("#,##0;(#,##0)"),
                new DecimalFormat("#,##0.0%;(#,##0.0)"));
        // StandardPieItemLabelGenerator("{0} = %{1}", new
        // DecimalFormat("#,##0.0;(#,##0.0)"),new
        // DecimalFormat("#,##0.0;(#,##0.0)"));

        plot.setURLGenerator(new StandardPieURLGenerator());
        plot.setToolTipGenerator(toolTipGen);
        plot.setLabelGenerator(labelGen);
        plot.setDepthFactor(0.1);
        plot.setCircular(true);

        PieSectionLabelGenerator test = plot.getLabelGenerator();
        /*
         * nick 2004-2-18 Since we have the data sorted, all the small % are
         * together, putting all the labels close and when we have a lot they
         * begin the overlap. By rotating to 315 degrees we split the small
         * items so about half of the labels end up on the left and half on the
         * right. This of course will depend the the data, but this will make
         * most look neater.
         */
        plot.setStartAngle(55);

        JFreeChart chart = new JFreeChart(title, JFreeChart.DEFAULT_TITLE_FONT,
                plot, true);

        chart.setBackgroundPaint(java.awt.Color.white);

        return chart;

    }

    public JFreeChart buildBarChart(Collection data, String number,
            String label, String title, int numberOfSliceLimit) {
        
        return buildBarChart(data,number,label,title,numberOfSliceLimit,"Percent (%)", "Categories");
        
    }
    public JFreeChart buildBarChart(Collection data, String number,
            String label, String title, int numberOfSliceLimit, String yAxisLabel, String xAxisLabel) {

        // chart creation logic...
        DefaultCategoryDataset dataSeries = new DefaultCategoryDataset();

        try {
            int i = 0;
            double otherTotal = 0;
            for (Iterator iter = data.iterator(); iter.hasNext(); i++) {
                Object element = (Object) iter.next();
                if (i < numberOfSliceLimit) {
                    Number numberObject = new Long(0);
                    Comparable labelObject = "Not on Menu";
                    if (Ognl.getValue(number, element) instanceof Number) {
                        numberObject = (Number) Ognl.getValue(number, element);
                    }

                    if (Ognl.getValue(label, element) instanceof Comparable) {
                        labelObject = (Comparable) Ognl
                                .getValue(label, element);
                    }

                    if (labelObject.equals("Other")) {
                        otherTotal += numberObject.doubleValue();
                    } else {
                        dataSeries.addValue(numberObject, "r", labelObject);
                    }

                } else {

                    Number numberObject = new Long(0);
                    if (Ognl.getValue(number, element) instanceof Number) {
                        Object o = Ognl.getValue(number, element);
                        numberObject = (Number) o;
                        otherTotal += numberObject.doubleValue();
                    }
                }
            }
            /*
        dataSeries2.addValue(total.getPriceData().getMedianPrice2007
             * Add the summed other catagory.
             */
            if (otherTotal > 0) {
                dataSeries.addValue(new Double(otherTotal), "r", "Other");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        CategoryAxis catAxis = new CategoryAxis3D(xAxisLabel);

        catAxis.setCategoryLabelPositions(CategoryLabelPositions.DOWN_45);
        ValueAxis yAxis = new NumberAxis(yAxisLabel);

        // catAxis.setVerticalCategoryLabels(true);

        // set my chart variable
        BarRenderer3D renderer = new BarRenderer3D(5, 3);

        // renderer.setPaint( Color.BLUE);

        JFreeChart chart = new JFreeChart(title, JFreeChart.DEFAULT_TITLE_FONT,
                new CategoryPlot(dataSeries, catAxis, yAxis, renderer), false);

        chart.setBackgroundPaint(java.awt.Color.white);
        // chart.addSubtitle(new ImageTitle( ));

        return chart;
    }

    
    public JFreeChart buildMedianPriceTrendLine(StatisticalTableIF data,
            String title, int numberOfSliceLimit) {
        // chart creation logic...
        DefaultCategoryDataset dataSeries2 = new DefaultCategoryDataset();

        try {
            int i = 0;
            double otherTotal = 0;
            for (Iterator iter = data.getRows().iterator(); iter.hasNext()
                    && i < numberOfSliceLimit; i++) {

                StatisticalTableElementIF element = (StatisticalTableElementIF) iter
                        .next();
                
                // MJB 11-12-2009 ADDED 2010
                dataSeries2.addValue(element.getPriceData()
                        .getMedianPrice2011(), element.getName(), "2011");
                dataSeries2.addValue(element.getPriceData()
                        .getMedianPrice2010(), element.getName(), "2010");
                // DBB 1-20-2009 Add 2008, 2009
                dataSeries2.addValue(element.getPriceData()
                        .getMedianPrice2009(), element.getName(), "2009");
                dataSeries2.addValue(element.getPriceData()
                        .getMedianPrice2008(), element.getName(), "2008");
                //JDL 10-5-07
                dataSeries2.addValue(element.getPriceData()
                        .getMedianPrice2007(), element.getName(), "2007");
                dataSeries2.addValue(element.getPriceData()
                        .getMedianPrice2006(), element.getName(), "2006");
                dataSeries2.addValue(element.getPriceData()
                        .getMedianPrice2005(), element.getName(), "2005");
                dataSeries2.addValue(element.getPriceData()
                        .getMedianPrice2004(), element.getName(), "2004");
                dataSeries2.addValue(element.getPriceData()
                        .getMedianPrice2003(), element.getName(), "2003");
                dataSeries2.addValue(element.getPriceData()
                        .getMedianPrice2002(), element.getName(), "2002");
                dataSeries2.addValue(element.getPriceData()
                        .getMedianPrice2001(), element.getName(), "2001");
                dataSeries2.addValue(element.getPriceData()
                        .getMedianPrice2000(), element.getName(), "2000");
                dataSeries2.addValue(element.getPriceData()
                        .getMedianPrice1999(), element.getName(), "1999");
                dataSeries2.addValue(element.getPriceData()
                        .getMedianPrice1998(), element.getName(), "1998");
                dataSeries2.addValue(element.getPriceData()
                        .getMedianPrice1997(), element.getName(), "1997");
                dataSeries2.addValue(element.getPriceData()
                        .getMedianPrice1996(), element.getName(), "1996");

            }
            // /*
            // * Add the summed other catagory.
            // */
            // if (otherTotal > 0) {
            // dataSeries2.addValue(new Double(otherTotal), "r", "Other");
            //
            // }
            //
        } catch (Exception e) {
            e.printStackTrace();
        }

        StatisticalTableElementIF total = data.getTotal();
        
        // MJB 11-12-2009 Add 2008, 2009
        dataSeries2.addValue(total.getPriceData().getMedianPrice2011(), total
                .getName(), "2011");
        dataSeries2.addValue(total.getPriceData().getMedianPrice2010(), total
                .getName(), "2010");
        // DBB 1-20-2009 Add 2008, 2009
        dataSeries2.addValue(total.getPriceData().getMedianPrice2009(), total
                .getName(), "2009");
        dataSeries2.addValue(total.getPriceData().getMedianPrice2008(), total
                .getName(), "2008");
        
        //JDL 10-5-07
        dataSeries2.addValue(total.getPriceData().getMedianPrice2007(), total
                .getName(), "2007");
        dataSeries2.addValue(total.getPriceData().getMedianPrice2006(), total
                .getName(), "2006");
        dataSeries2.addValue(total.getPriceData().getMedianPrice2005(), total
                .getName(), "2005");
        dataSeries2.addValue(total.getPriceData().getMedianPrice2004(), total
                .getName(), "2004");
        dataSeries2.addValue(total.getPriceData().getMedianPrice2003(), total
                .getName(), "2003");
        dataSeries2.addValue(total.getPriceData().getMedianPrice2002(), total
                .getName(), "2002");
        dataSeries2.addValue(total.getPriceData().getMedianPrice2001(), total
                .getName(), "2001");
        dataSeries2.addValue(total.getPriceData().getMedianPrice2000(), total
                .getName(), "2000");
        dataSeries2.addValue(total.getPriceData().getMedianPrice1999(), total
                .getName(), "1999");
        dataSeries2.addValue(total.getPriceData().getMedianPrice1998(), total
                .getName(), "1998");
        dataSeries2.addValue(total.getPriceData().getMedianPrice1997(), total
                .getName(), "1997");
        dataSeries2.addValue(total.getPriceData().getMedianPrice1996(), total
                .getName(), "1996");

        JFreeChart chart = ChartFactory.createLineChart(title, "Year", "Price",
                dataSeries2, PlotOrientation.VERTICAL, true, false, false);

        chart.setBackgroundPaint(java.awt.Color.white);
        // chart.addSubtitle(new ImageTitle( ));

        return chart;
    }

    public JFreeChart buildMeanPriceTrendLine(StatisticalTableIF data,
            String title, int numberOfSliceLimit) {
        // chart creation logic...
        DefaultCategoryDataset dataSeries2 = new DefaultCategoryDataset();

        try {
            int i = 0;
            double otherTotal = 0;
            for (Iterator iter = data.getRows().iterator(); iter.hasNext()
                    && i < numberOfSliceLimit; i++) {

                StatisticalTableElementIF element = (StatisticalTableElementIF) iter
                        .next();

                dataSeries2.addValue(element.getPriceData()
                        .getAveragePrice1996(), element.getName(), "1996");
                dataSeries2.addValue(element.getPriceData()
                        .getAveragePrice1997(), element.getName(), "1997");
                dataSeries2.addValue(element.getPriceData()
                        .getAveragePrice1998(), element.getName(), "1998");
                dataSeries2.addValue(element.getPriceData()
                        .getAveragePrice1999(), element.getName(), "1999");
                dataSeries2.addValue(element.getPriceData()
                        .getAveragePrice2000(), element.getName(), "2000");
                dataSeries2.addValue(element.getPriceData()
                        .getAveragePrice2001(), element.getName(), "2001");
                dataSeries2.addValue(element.getPriceData()
                        .getAveragePrice2002(), element.getName(), "2002");
                dataSeries2.addValue(element.getPriceData()
                        .getAveragePrice2003(), element.getName(), "2003");
                dataSeries2.addValue(element.getPriceData()
                        .getAveragePrice2004(), element.getName(), "2004");

                dataSeries2.addValue(element.getPriceData()
                        .getAveragePrice2005(), element.getName(), "2005");

                dataSeries2.addValue(element.getPriceData()
                        .getAveragePrice2006(), element.getName(), "2006");
                //JDL 10-5-07
                dataSeries2.addValue(element.getPriceData()
                        .getAveragePrice2007(), element.getName(), "2007");
                
                // DBB 1-20-2009 Add 2008, 2009
                dataSeries2.addValue(element.getPriceData()
                        .getAveragePrice2008(), element.getName(), "2008");
                dataSeries2.addValue(element.getPriceData()
                        .getAveragePrice2009(), element.getName(), "2009");
                // MJB 11-12-2009 Added 2010
                dataSeries2.addValue(element.getPriceData()
                        .getAveragePrice2010(), element.getName(), "2010");
                dataSeries2.addValue(element.getPriceData()
                        .getAveragePrice2011(), element.getName(), "2011");
                
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        StatisticalTableElementIF total = data.getTotal();

        dataSeries2.addValue(total.getPriceData().getAveragePrice1996(), total
                .getName(), "1996");
        dataSeries2.addValue(total.getPriceData().getAveragePrice1997(), total
                .getName(), "1997");
        dataSeries2.addValue(total.getPriceData().getAveragePrice1998(), total
                .getName(), "1998");
        dataSeries2.addValue(total.getPriceData().getAveragePrice1999(), total
                .getName(), "1999");
        dataSeries2.addValue(total.getPriceData().getAveragePrice2000(), total
                .getName(), "2000");
        dataSeries2.addValue(total.getPriceData().getAveragePrice2001(), total
                .getName(), "2001");
        dataSeries2.addValue(total.getPriceData().getAveragePrice2002(), total
                .getName(), "2002");
        dataSeries2.addValue(total.getPriceData().getAveragePrice2003(), total
                .getName(), "2003");
        dataSeries2.addValue(total.getPriceData().getAveragePrice2004(), total
                .getName(), "2004");
        dataSeries2.addValue(total.getPriceData().getAveragePrice2005(), total
                .getName(), "2005");
        dataSeries2.addValue(total.getPriceData().getAveragePrice2006(), total
                .getName(), "2006");
        //JDL 10-5-07
        dataSeries2.addValue(total.getPriceData().getAveragePrice2007(), total
                .getName(), "2007");
        
        // DBB 1-20-2009 Add 2008, 2009
        dataSeries2.addValue(total.getPriceData().getAveragePrice2008(), total
                .getName(), "2008");
        dataSeries2.addValue(total.getPriceData().getAveragePrice2009(), total
                .getName(), "2009");
        // MJB 11-12-2009 Added 2010
        dataSeries2.addValue(total.getPriceData().getAveragePrice2010(), total
                .getName(), "2010");
        dataSeries2.addValue(total.getPriceData().getAveragePrice2011(), total
                .getName(), "2011");

        JFreeChart chart = ChartFactory.createLineChart(title, "Year", "Price",
                dataSeries2, PlotOrientation.VERTICAL, true, false, false);

        chart.setBackgroundPaint(java.awt.Color.white);
        // chart.addSubtitle(new ImageTitle( ));

        return chart;
    }

    public JFreeChart buildCategoryIncidenceGraph(
            IncidenceTable incidenceTable, String titleString,
            int numberOfSliceLimit) {

        DefaultCategoryDataset dataSeries2 = new DefaultCategoryDataset();

        int i = 0;
        double otherTotal = 0;
        for (Iterator iter = incidenceTable.getIncidenceSectors().iterator(); iter
                .hasNext(); i++) {

            IncidenceSector element = (IncidenceSector) iter.next();

            dataSeries2.addValue(element.getCategoryIncidence(), element
                    .getName(), element.getName());

        }

        JFreeChart chart = ChartFactory.createBarChart3D(titleString,
                "Chains Menuing", "Incidence", dataSeries2,
                PlotOrientation.VERTICAL, true, true, true);
        CategoryAxis catAxis = new CategoryAxis3D("Sector");
        catAxis.setCategoryLabelPositions(CategoryLabelPositions.DOWN_45);

        ((CategoryPlot) chart.getPlot()).setDomainAxis(catAxis);
        chart.setBackgroundPaint(java.awt.Color.white);

        return chart;
    }

    public JFreeChart buildItemsPerChainMenuingGraph(
            IncidenceTable incidenceTable, String titleString,
            int numberOfSliceLimit) {

        DefaultCategoryDataset dataSeries2 = new DefaultCategoryDataset();

        int i = 0;
        double otherTotal = 0;
        for (Iterator iter = incidenceTable.getIncidenceSectors().iterator(); iter
                .hasNext(); i++) {

            IncidenceSector element = (IncidenceSector) iter.next();

            dataSeries2.addValue(element.getNumberOfItemsPerChainMenued(),
                    element.getName(), element.getName());

        }

        JFreeChart chart = ChartFactory.createBarChart3D(titleString,
                "Chains Menuing", "Items/Chain", dataSeries2,
                PlotOrientation.VERTICAL, true, true, true);
        CategoryAxis catAxis = new CategoryAxis3D("Sector");
        catAxis.setCategoryLabelPositions(CategoryLabelPositions.DOWN_45);

        ((CategoryPlot) chart.getPlot()).setDomainAxis(catAxis);
        chart.setBackgroundPaint(java.awt.Color.white);

        return chart;
    }

}