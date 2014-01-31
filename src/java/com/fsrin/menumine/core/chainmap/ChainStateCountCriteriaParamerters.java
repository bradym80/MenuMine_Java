/*
 * Created on Jul 13, 2005
 *
 * 
 */
package com.fsrin.menumine.core.chainmap;

import java.util.Collection;

import com.fsrin.menumine.common.dao.CriteriaParameters;

/**
 * @author Nick
 * 
 *  
 */
public class ChainStateCountCriteriaParamerters implements CriteriaParameters {

    private String chain;

    private Collection chains;

    public String getChain() {
        return chain;
    }

    public void setChain(String chain) {
        this.chain = chain;
    }

    public Collection getChains() {
        return chains;
    }

    public void setChains(Collection chains) {
        this.chains = chains;
    }
}