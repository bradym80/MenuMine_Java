/*
 * Created on Sep 14, 2006 by Reid
 */
package com.fsrin.menumine.core.incidence;

import java.util.Collection;

public class IncidenceTableBuildOptionsWithChains extends
        IncidenceTableBuildOptions {

    private Collection results;
    private Collection baseChains;

    public Collection getBaseChains() {
        return baseChains;
    }

    public void setBaseChains(Collection baseChains) {
        this.baseChains = baseChains;
    }

    public Collection getResults() {
        return results;
    }

    public void setResults(Collection results) {
        this.results = results;
    }

}
