/*
 * Created on Apr 10, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.sharetable.filters;

import com.fsrin.menumine.core.menumine.FieldEnum;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParametersImpl;
import com.fsrin.menumine.core.menumine.masterfood.MasterFoodServiceDelegateFactory;
import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableBuilder;
import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableIF;
import com.fsrin.menumine.core.menumine.webwork.MenuMineGraphOptions;
import com.fsrin.menumine.core.minefields.MineFields;
import com.fsrin.menumine.core.minefields.MineFieldsFactory;
import com.fsrin.menumine.testutil.AbstractNonInitializingMenuMineTestCase;

/**
 * 2006-04-10 Seeing some inconsistencies in counts -- has to do with applying the
 * hidden fields properly.
 * 
 * @author Reid
 */
public class ConsolidateByTermsFilterTest2 extends AbstractNonInitializingMenuMineTestCase {

    public void testTotalDoesntSkyrocket() throws Exception {

        MasterFoodFilterParameters pBase = new MasterFoodFilterParametersImpl();
        pBase.getKeywords().getOrValues().add("sauce");
        pBase.getHqRegion().getNotValues().add("UK");
        
        pBase.getDayPartCategory().getNotValues().add("Dessert");
        pBase.getDayPartCategory().getNotValues().add("Beverage");

        Long rawCount = MasterFoodServiceDelegateFactory.factory.build().getCount(pBase);
        log.info("raw count is " + rawCount);
        
        /*
         * here's stat table #1 unfiltered
         */

        MasterFoodFilterParameters p = new MasterFoodFilterParametersImpl();
        p.getKeywords().getOrValues().add("sauce");
        p.getHqRegion().getNotValues().add("UK");
        
        /*
         * this happens in a support action.
         */
        MineFields f = new MineFieldsFactory().getByKey(MineFieldsFactory.MINE_TYPE_MENU);
        f.applyHiddenParams(p);
        
        MenuMineGraphOptions graphOptions = new MenuMineGraphOptions();
        
        graphOptions.setGraphByField(FieldEnum.SAUCE_OR_CONDIMENT.getOgnlName());
        graphOptions.setFilterNone(false); //default is true.
        
        
        StatisticalTableIF unfilteredTable = new StatisticalTableBuilder().buildStatisticalTable_FromAggregation(p,graphOptions,null);
        
        assertNotNull(unfilteredTable);
        
        log.info("Unfiltered table size is " + unfilteredTable.getTotal().getSizeOfSample());
        
        /*
         * make sure these are equal
         */
        assertEquals(rawCount, unfilteredTable.getTotal().getSizeOfSample());
        
        
        /*
         * now try a filtered table.
         */
        
        MenuMineGraphOptions graphOptions2 = new MenuMineGraphOptions();
        
        graphOptions2.setGraphByField(FieldEnum.SAUCE_OR_CONDIMENT.getOgnlName());
        graphOptions2.setFilterNone(false); //default is true.
        
        graphOptions2.setFilterConsolidateByTerms(true);
        graphOptions2.setFilterConsolidateByTermsList("Beef,Chicken");
        
        StatisticalTableIF filteredTable = new StatisticalTableBuilder().buildStatisticalTable_FromAggregation(p,graphOptions2,null);
        
        assertNotNull(filteredTable);
        
        log.info("Filtered table size is " + filteredTable.getTotal().getSizeOfSample());
        
    }
}
