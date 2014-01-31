/*
 * Created on Jul 7, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.natlaccountbench;

import org.jfree.chart.JFreeChart;

import com.fsrin.menumine.core.minefields.MineField;

/**
 * @author Nick
 * 
 *  
 */
public class NationalAccountBenchmarkCan {

    private MineField field;

    private NationalAccountBenchmarkTable benchmark;

    private NationalAccountBenchmarkTrendTable benchmarkTrend;

    private JFreeChart chart;

    public NationalAccountBenchmarkCan() {
        super();

    }

    public NationalAccountBenchmarkTable getBenchmark() {
        return benchmark;
    }

    public void setBenchmark(NationalAccountBenchmarkTable benchmark) {
        this.benchmark = benchmark;
    }

    public NationalAccountBenchmarkTrendTable getBenchmarkTrend() {
        return benchmarkTrend;
    }

    public void setBenchmarkTrend(
            NationalAccountBenchmarkTrendTable benchmarkTrend) {
        this.benchmarkTrend = benchmarkTrend;
    }

    public MineField getField() {
        return field;
    }

    public void setField(MineField field) {
        this.field = field;
    }

    public JFreeChart getChart() {
        return chart;
    }

    public void setChart(JFreeChart chart) {
        this.chart = chart;
    }
}