/*
 * Created on Jun 28, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.natlaccountbench;

import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableElementIF;

/**
 * @author Nick
 * 
 *  
 */
public class NationalAccountBenchmarkElement {

    private StatisticalTableElementIF target;

    private StatisticalTableElementIF benchmark;

    public NationalAccountBenchmarkElement() {
        super();

    }

    public String getName() {
        /*
         * First see if target has a a name. Target will be null if this element
         * was merged from the bench.
         *  
         */
        if (target != null) {
            return target.getName();
        }

        if (benchmark != null) {
            return benchmark.getName();
        }

        return "";
    }

    public Double getPercentOfTarget() {
        if (target == null) {
            return new Double(0);
        }
        return target.getPercent();
    }

    public Double getPercentOfBenchmark() {
        if (benchmark == null) {
            return new Double(0);
        }
        return benchmark.getPercent();
    }

    public Double getIndex() {
        if (this.getPercentOfBenchmark().doubleValue() == 0.0) {
            return new Double(0);
        }

        double d = (this.getPercentOfTarget().doubleValue() / this
                .getPercentOfBenchmark().doubleValue()) * 100;

        if (d > 9999.0) {
            return new Double(9999.0);
        }

        return new Double(d);
    }

    public StatisticalTableElementIF getBenchmark() {
        return benchmark;
    }

    public void setBenchmark(StatisticalTableElementIF benchmark) {
        this.benchmark = benchmark;
    }

    public StatisticalTableElementIF getTarget() {
        return target;
    }

    public void setTarget(StatisticalTableElementIF target) {
        this.target = target;
    }

}