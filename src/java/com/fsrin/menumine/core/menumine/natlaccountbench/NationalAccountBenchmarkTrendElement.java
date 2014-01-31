/*
 * Created on Jun 30, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.natlaccountbench;

/**
 * @author Nick
 * 
 *  
 */
public class NationalAccountBenchmarkTrendElement {

    /*
     * We init with a NULLImpl. The NULLImpl will return 0s. When we build, we
     * only set the benchmarks that exist, so we don't want an actual null
     * returned.
     *  
     */
    private NationalAccountBenchmarkElement benchmarkRecent = new NationalAccountBenchmarkElementNullImpl();

    private NationalAccountBenchmarkElement benchmarkMiddle = new NationalAccountBenchmarkElementNullImpl();

    private NationalAccountBenchmarkElement benchmarkOldest = new NationalAccountBenchmarkElementNullImpl();

    public NationalAccountBenchmarkTrendElement() {
        super();

    }

    public String getName() {
        /*
         * One of these shouldhave a name!
         *  
         */
        if (benchmarkRecent != null && benchmarkRecent.getName() != null
                && benchmarkRecent.getName().length() > 0) {
            return benchmarkRecent.getName();
        }

        if (benchmarkMiddle != null && benchmarkMiddle.getName() != null
                && benchmarkMiddle.getName().length() > 0) {
            return benchmarkMiddle.getName();
        }

        if (benchmarkOldest != null && benchmarkOldest.getName() != null
                && benchmarkOldest.getName().length() > 0) {
            return benchmarkOldest.getName();
        }
        return "";
    }

    public NationalAccountBenchmarkElement getBenchmarkOldest() {
        return benchmarkOldest;
    }

    public void setBenchmarkOldest(NationalAccountBenchmarkElement benchmark1998) {
        this.benchmarkOldest = benchmark1998;
    }

    public NationalAccountBenchmarkElement getBenchmarkMiddle() {
        return benchmarkMiddle;
    }

    public void setBenchmarkMiddle(NationalAccountBenchmarkElement benchmark2001) {
        this.benchmarkMiddle = benchmark2001;
    }

    public NationalAccountBenchmarkElement getBenchmarkRecent() {
        return benchmarkRecent;
    }

    public void setBenchmarkRecent(NationalAccountBenchmarkElement benchmark2004) {
        this.benchmarkRecent = benchmark2004;
    }
}