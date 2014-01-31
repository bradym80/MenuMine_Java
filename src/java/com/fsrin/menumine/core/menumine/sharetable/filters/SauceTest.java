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

public class SauceTest extends AbstractNonInitializingMenuMineTestCase {

    public void testRawList() throws Exception {

        MenuMineGraphOptions graphOptions = new MenuMineGraphOptions();
        graphOptions.setGraphByField(FieldEnum.SAUCE_OR_CONDIMENT.getOgnlName());
        
        MasterFoodFilterParameters p = new MasterFoodFilterParametersImpl();
        p.getItemDescription().getOrValues().add("sauce");
        
        StatisticalTableIF table = new StatisticalTableBuilder().buildStatisticalTable_FromAggregation(p,graphOptions,null);
        
        assertNotNull(table);
        
        log.info("Table size is " + table.getRows().size());
        

    }
}
