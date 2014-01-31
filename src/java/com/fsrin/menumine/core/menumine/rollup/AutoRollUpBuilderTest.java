/*
 * Created on Aug 17, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.rollup;

import java.util.Collection;

import junit.framework.TestCase;

import com.fsrin.menumine.core.menumine.FieldEnum;
import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableBuilder;
import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableIF;
import com.fsrin.menumine.core.menumine.webwork.MenuMineGraphOptions;

/**
 * @author Nick
 * 
 *  
 */
public class AutoRollUpBuilderTest extends TestCase {

    public AutoRollUpBuilderTest() {
        super();

    }

    public void testAutoRollUpVeryHigh() throws Exception {
        MasterFoodServiceDelegateMockAutoRollUpImpl sd = new MasterFoodServiceDelegateMockAutoRollUpImpl();

        Collection results = sd.getResults();

        MenuMineGraphOptions menuMineGraphOptions = new MenuMineGraphOptions();
        menuMineGraphOptions.setGraphByField(FieldEnum.COOKING_METHOD
                .getOgnlName());

        RollUpOptions rollUpOptions = new RollUpOptions();

        StatisticalTableIF menuShare = new StatisticalTableBuilder()
                .buildStatisticalTableFromCollection_WithoutAggregation(results,
                        menuMineGraphOptions, rollUpOptions);

        assertEquals(140, menuShare.getRows().size());

        AutoRollUpBuilder builder = new AutoRollUpBuilder(menuShare,
                AutoRollUpBuilder.INTENSITY_VERY_HIGH);
        RollUpOptions proposedRollUp = builder.getProposedRollUp();
        assertNotNull(proposedRollUp);

        assertEquals(120, proposedRollUp.getRollUpElements().size());
    }

}