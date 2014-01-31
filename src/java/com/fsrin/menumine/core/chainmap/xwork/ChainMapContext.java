/*
 * Created on Jul 19, 2005
 *
 * 
 */
package com.fsrin.menumine.core.chainmap.xwork;

import java.util.Collection;


/**
 * @author Nick
 * 
 *  
 */
public class ChainMapContext {

    //2006-01-17 RSC Target chain counts.
    private Collection chainStateCounts;

    //2006-01-17 RSC Benchmark chain counts.
    private Collection chainStateCountsBase;

    public ChainMapContext() {
        super();

    }

    public Collection getChainStateCounts() {
        return chainStateCounts;
    }

    public void setChainStateCounts(Collection chainStateCounts) {
        this.chainStateCounts = chainStateCounts;
    }

    public Collection getChainStateCountsBase() {
        return chainStateCountsBase;
    }

    public void setChainStateCountsBase(Collection chainStateCountsBase) {
        this.chainStateCountsBase = chainStateCountsBase;
    }
}