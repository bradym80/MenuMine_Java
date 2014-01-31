/*
 * Created on Jun 27, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.natlaccountbench;

import java.util.ArrayList;
import java.util.Collection;

import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableOptions;

/**
 * @author Nick
 * 
 *  
 */
public class NationalAccountBenchmarkOptions extends StatisticalTableOptions {

    private Collection chainsA = new ArrayList();

    private Collection chainsB = new ArrayList();

    public NationalAccountBenchmarkOptions() {
        super();

    }

    public Collection getChainsA() {
        return chainsA;
    }

    public void setChainsA(Collection chainsA) {
        this.chainsA = chainsA;
    }

    public Collection getChainsB() {
        return chainsB;
    }

    public void setChainsB(Collection chainsB) {
        this.chainsB = chainsB;
    }
}