/*
 * Created on Jul 19, 2005
 *
 * 
 */
package com.fsrin.menumine.core.chainmap;

import java.util.Collection;
import java.util.Iterator;

/**
 * @author Nick
 * 
 *  
 */
public class ChainMapTableBuilder {

    public ChainMapTableBuilder() {
        super();

    }

    public ChainMapTable build(Collection targetChainStateCounts,
            Collection benchmarkChainStateCounts) {

        ChainMapTable table = new ChainMapTable();

        if (benchmarkChainStateCounts != null) {
            for (Iterator iter = benchmarkChainStateCounts.iterator(); iter.hasNext();) {
                ChainStateCount element = (ChainStateCount) iter.next();
                table.addAllChainStateCount(element);
            }
        }
        if (targetChainStateCounts != null) {
            for (Iterator iter = targetChainStateCounts.iterator(); iter.hasNext();) {
                ChainStateCount element = (ChainStateCount) iter.next();
                table.addChainStateCount(element);
            }
        }
        return table;
    }

}