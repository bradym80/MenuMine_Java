/*
 * Created on Jan 28, 2005
 *
 * 
 */
package com.fsrin.menumine.core.chainstat;

import java.io.Serializable;

/**
 * @author Nick
 * 
 *  
 */
public class ChainStatFilterParameters extends ChainStat implements
        Serializable {

    private Boolean includeChainStateCount;

    public Boolean getIncludeChainStateCount() {
        return includeChainStateCount;
    }

    public void setIncludeChainStateCount(Boolean includeChainStateCount) {
        this.includeChainStateCount = includeChainStateCount;
    }
}