/*
 * Created on Jul 12, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.natlaccountbench.cannedschematic.xwork;

import com.fsrin.menumine.common.crud.xwork.WebParameters;

/**
 * @author Nick Since checkboxes don't return false, we need to catch the params
 *         separate from the main object.
 *  
 */
public class CannedSchematicWebParameters implements WebParameters {

    private Boolean includeBenchmark = Boolean.FALSE;

    private Boolean includeBenchmarkTrend = Boolean.FALSE;

    private Boolean includeBenchmarkGraph = Boolean.FALSE;

    public Boolean getIncludeBenchmark() {
        return includeBenchmark;
    }

    public void setIncludeBenchmark(Boolean includeBenchmark) {
        this.includeBenchmark = includeBenchmark;
    }

    public Boolean getIncludeBenchmarkGraph() {
        return includeBenchmarkGraph;
    }

    public void setIncludeBenchmarkGraph(Boolean includeBenchmarkGraph) {
        this.includeBenchmarkGraph = includeBenchmarkGraph;
    }

    public Boolean getIncludeBenchmarkTrend() {
        return includeBenchmarkTrend;
    }

    public void setIncludeBenchmarkTrend(Boolean includeBenchmarkTrend) {
        this.includeBenchmarkTrend = includeBenchmarkTrend;
    }
}