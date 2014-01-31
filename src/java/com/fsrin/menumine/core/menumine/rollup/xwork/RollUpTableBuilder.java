/*
 * Created on Sep 14, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.rollup.xwork;

import com.fsrin.menumine.core.menumine.rollup.RollUpOptions;
import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableIF;

/**
 * @author Nick
 *
 * 
 */
public class RollUpTableBuilder {

    public RollUpTableBuilder() {
        super();

    }

    public RollUpTable build(RollUpOptions rollUpOptions, StatisticalTableIF statisticalTableResults) {
        RollUpTable rollUpTable = new RollUpTable();
        rollUpTable.addStatisticalTable(statisticalTableResults);
       rollUpTable.addRollUpOptions(rollUpOptions);

        
        
        
        return rollUpTable;
    }

}
