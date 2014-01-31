/*
 * Created on Jul 5, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.natlaccountbench.xwork;

import org.jfree.chart.JFreeChart;

/**
 * @author Nick
 * 
 *  
 */
public interface ChartBuilder {

    JFreeChart build(Object results, String titleString, int i);

}