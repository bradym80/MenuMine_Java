/*
 * Created on Jan 21, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menubook.xwork;

import java.util.Iterator;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import com.fsrin.menumine.core.menubook.MenuBook;
import com.fsrin.menumine.core.menubook.MenuBookMenuPart;

/**
 * @author Nick
 * 
 *  
 */
public class MenuBookChartBuilder {

    public static MenuBookChartBuilder singleton = new MenuBookChartBuilder();

    private MenuBookChartBuilder() {
        super();

    }

    public JFreeChart buildTrendChart(MenuBook data, String title,
            int numberOfSliceLimit) {
        // chart creation logic...
        DefaultCategoryDataset dataSeries2 = new DefaultCategoryDataset();

        try {
            int i = 0;
            double otherTotal = 0;
            for (Iterator iter = data.getMenuParts().iterator(); iter.hasNext()
                    && i < numberOfSliceLimit; i++) {

                MenuBookMenuPart element = (MenuBookMenuPart) iter.next();
                
                // MJB 11-12-2009 Added 2010
                dataSeries2.addValue(element.getMedianPrice2011(), element
                        .getName(), "2011");
                // MJB 11-12-2009 Added 2010
                dataSeries2.addValue(element.getMedianPrice2010(), element
                        .getName(), "2010");
                // DBB 1-20-2009 Add 2008, 2009
                dataSeries2.addValue(element.getMedianPrice2009(), element
                        .getName(), "2009");
                
                dataSeries2.addValue(element.getMedianPrice2008(), element
                        .getName(), "2008");
                
                //JDL 10-5-07
                dataSeries2.addValue(element.getMedianPrice2007(), element
                        .getName(), "2007");
                
                dataSeries2.addValue(element.getMedianPrice2006(), element
                        .getName(), "2006");
                
                dataSeries2.addValue(element.getMedianPrice2005(), element
                        .getName(), "2005");
                
                dataSeries2.addValue(element.getMedianPrice2004(), element
                        .getName(), "2004");
                dataSeries2.addValue(element.getMedianPrice2003(), element
                        .getName(), "2003");
                dataSeries2.addValue(element.getMedianPrice2002(), element
                        .getName(), "2002");
                dataSeries2.addValue(element.getMedianPrice2001(), element
                        .getName(), "2001");
                dataSeries2.addValue(element.getMedianPrice2000(), element
                        .getName(), "2000");
                dataSeries2.addValue(element.getMedianPrice1999(), element
                        .getName(), "1999");
                dataSeries2.addValue(element.getMedianPrice1998(), element
                        .getName(), "1998");
                dataSeries2.addValue(element.getMedianPrice1997(), element
                        .getName(), "1997");
                dataSeries2.addValue(element.getMedianPrice1996(), element
                        .getName(), "1996");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        JFreeChart chart = ChartFactory.createLineChart(title, "Year", "Price",
                dataSeries2, PlotOrientation.VERTICAL, true, false, false);

        chart.setBackgroundPaint(java.awt.Color.white);
        //  chart.addSubtitle(new ImageTitle( ));

        return chart;
    }

}