/*
 * Created on Feb 3, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.sharetable;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fsrin.menumine.core.menumine.FieldEnum;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParametersTestFactory;
import com.fsrin.menumine.core.menumine.rollup.RollUpOptions;
import com.fsrin.menumine.core.menumine.rollup.RollUpOptionsTestFactory;
import com.fsrin.menumine.core.menumine.webwork.MenuMineGraphOptions;
import com.fsrin.menumine.testutil.AbstractNonInitializingMenuMineTestCase;

public class StatisticalTableRollUpTest extends
        AbstractNonInitializingMenuMineTestCase {

    private static Log log = LogFactory.getLog(StatisticalTableRollUpTest.class);
    
    public void testBasic() throws Exception {

        MasterFoodFilterParameters p = MasterFoodFilterParametersTestFactory
                .getItemDescriptionWithBacon();

        MenuMineGraphOptions graphOptions = new MenuMineGraphOptions();
        
        graphOptions.setGraphByField(FieldEnum.CUISINE_FAMILY.getOgnlName());

        StatisticalTableIF statisticalTableIF = new StatisticalTableBuilder()
                .buildStatisticalTable_FromAggregation(p, graphOptions, null);

        RollUpOptions options = RollUpOptionsTestFactory.buildTestAmericanRollUpOthers();

        int beforeRowSize = statisticalTableIF.getRows().size();
        
        log.info("before: " + beforeRowSize);
        
        new StatisticalTableRollUp().filter(
                statisticalTableIF, options);
        
        int afterRowSize = statisticalTableIF.getRows().size();
        
        log.info("after: " + afterRowSize);
        
        assertEquals(beforeRowSize-1,afterRowSize);
    }
}
