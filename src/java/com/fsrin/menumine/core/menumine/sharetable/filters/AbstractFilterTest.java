/*
 * Created on Mar 24, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.sharetable.filters;

import com.fsrin.menumine.core.menumine.FieldEnum;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParametersImpl;
import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableBuilder;
import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableIF;
import com.fsrin.menumine.core.menumine.webwork.MenuMineGraphOptions;
import com.fsrin.menumine.testutil.AbstractNonInitializingMenuMineTestCase;

public class AbstractFilterTest extends AbstractNonInitializingMenuMineTestCase {

    StatisticalTableIF table;
    
    StatisticalTableIF simpleTable;
    
    @Override
    protected void setUp() throws Exception {
        log.info( "In setup");
        
        super.setUp();
        
        MenuMineGraphOptions graphOptions = new MenuMineGraphOptions();
        
        /*
         * 2006-04-20 RSC have to do this or several tests fail
         */
        graphOptions.setFilterBelowPercentage(false);
        
        graphOptions.setGraphByField(FieldEnum.BREAD_BAKED_GOOD.getOgnlName());
        graphOptions.setFilterNone(false); //default is true.
        
        MasterFoodFilterParameters p = new MasterFoodFilterParametersImpl();
        p.getItemDescription().getOrValues().add("bacon");
        
        table = new StatisticalTableBuilder().buildStatisticalTable_FromAggregation(p,graphOptions,null);
        
        assertNotNull(table);
        
        log.info("Setup table size is " + table.getSizeOfSample());

        
        MenuMineGraphOptions graphOptions2 = new MenuMineGraphOptions();
        
        graphOptions2.setGraphByField(FieldEnum.BASIC_PROTEIN.getOgnlName());
        graphOptions2.setFilterNone(false); //default is true.
        
        MasterFoodFilterParameters p2 = new MasterFoodFilterParametersImpl();
        p2.getItemDescription().getOrValues().add("bacon");
        
        simpleTable = new StatisticalTableBuilder().buildStatisticalTable_FromAggregation(p2,graphOptions2,null);
        
        assertNotNull(simpleTable);
        
        log.info("Setup simpleTable size is " + simpleTable.getSizeOfSample());
        
    }

        
            

}