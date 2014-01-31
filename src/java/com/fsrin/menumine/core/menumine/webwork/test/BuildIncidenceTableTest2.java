package com.fsrin.menumine.core.menumine.webwork.test;

import java.util.Collection;
import java.util.Iterator;

import com.fsrin.menumine.core.incidence.IncidenceSector;
import com.fsrin.menumine.core.incidence.IncidenceSegment;
import com.fsrin.menumine.core.incidence.IncidenceTable;
import com.fsrin.menumine.core.incidence.IncidenceTableBuildOptions;
import com.fsrin.menumine.core.incidence.IncidenceTableBuildOptionsWithChains;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParametersTestFactory;
import com.fsrin.menumine.core.menumine.chain.ChainFilterParameters;
import com.fsrin.menumine.core.menumine.chain.ChainServiceDelegateFactory;
import com.fsrin.menumine.core.menumine.masterfood.MasterFoodServiceDelegateFactory;
import com.fsrin.menumine.core.menumine.webwork.util.MenuMineResultsDisplayWrapperBuilder;
import com.fsrin.menumine.testutil.AbstractNonInitializingMenuMineTestCase;

/**
 * @author Reid
 */
public class BuildIncidenceTableTest2 extends
        AbstractNonInitializingMenuMineTestCase {

    public void testIncidenceBuildTable() throws Exception {

        MasterFoodFilterParameters filter = MasterFoodFilterParametersTestFactory.getItemDescriptionWithBacon();
        filter.getMenuItem().setSelect(true);
        filter.getBasicProtein().setSelect(true);
        
        filter.getOperationName().setSelect(true);
        filter.getSegment().setSelect(true);
        filter.getSectorName().setSelect(true);

        Collection results = MasterFoodServiceDelegateFactory.factory.build()
                .searchMasterFoodByHQLConjunction(filter);

        IncidenceTableBuildOptionsWithChains options = new IncidenceTableBuildOptionsWithChains();

        options.setResults(results);
        options.setBaseChains(ChainServiceDelegateFactory.factory.build()
                .search(new ChainFilterParameters()));
        options.setYear(new Integer(2005));
        
        IncidenceTable table = null;
        try { // just here for testing.
         table = MenuMineResultsDisplayWrapperBuilder.singleton
                .buildIncidenceTable(options);
        } catch (Exception e) {
            throw e;
        }

        assertEquals(10, table.getIncidenceSectors().size());
        for (Iterator iter = table.getIncidenceSectors().iterator(); iter
                .hasNext();) {

            IncidenceSector element = (IncidenceSector) iter.next();

            /*
             * 2006-01-28 every sector has bacon.
             */
            
            log.info("Chains menuing " + element.getNumberOfChainsMenuingItems());
            
//            assertTrue(element.getNumberOfChainsMenuingItems() > 0);
            
            for (Iterator iterator = element.getIncidenceSegments().iterator(); iterator
                    .hasNext();) {
                IncidenceSegment segmentEle = (IncidenceSegment) iterator
                        .next();

            }
        }
    }
}