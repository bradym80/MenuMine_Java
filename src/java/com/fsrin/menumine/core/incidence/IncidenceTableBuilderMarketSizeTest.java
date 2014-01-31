/*
 * Created on Jan 31, 2006 by Reid
 */
package com.fsrin.menumine.core.incidence;

import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParametersTestFactory;
import com.fsrin.menumine.core.menumine.marketsize.MarketSizeIncidenceSector;
import com.fsrin.menumine.core.menumine.marketsize.MarketSizeIncidenceSegment;
import com.fsrin.menumine.core.menumine.marketsize.MarketSizeOptions;
import com.fsrin.menumine.testutil.AbstractNonInitializingMenuMineTestCase;

public class IncidenceTableBuilderMarketSizeTest extends
        AbstractNonInitializingMenuMineTestCase {

    private static Log log = LogFactory.getLog(IncidenceTableBuilderMarketSizeTest.class);
    
   
    public void testCategoryIncidenceTable() throws Exception {
        MasterFoodFilterParameters p = MasterFoodFilterParametersTestFactory.getKeywordsWithChicken();
        
        IncidenceTableBuildOptions option = new IncidenceTableBuildOptions();
        
        option.setParams(p);
        option.setYear(new Integer(2005));
        
        MarketSizeOptions marketSizeOptions = new MarketSizeOptions();
        
        /*
         * 2006-07-25 reid@fivesticks.com these numbers come from Joe's example
         */
        marketSizeOptions.getChainOptions().setMenuCycle(365);
        marketSizeOptions.getChainOptions().setOuncesPerServing(1);
        marketSizeOptions.getChainOptions().setServingsPerDay(75);
        
        marketSizeOptions.getNonCommercialOptions().setMenuCycle(100);
        marketSizeOptions.getNonCommercialOptions().setOuncesPerServing(1);
        marketSizeOptions.getNonCommercialOptions().setServingsPerDay(200);

        marketSizeOptions.getIndependentOptions().setMenuCycle(365);
        marketSizeOptions.getIndependentOptions().setOuncesPerServing(1);
        marketSizeOptions.getIndependentOptions().setServingsPerDay(50);

        IncidenceTable r = new IncidenceTableBuilder().buildMarketSizeProjectorTable(option, marketSizeOptions);

        assertNotNull(r);
        
        for (Iterator iter = r.getIncidenceSectors().iterator(); iter.hasNext();) {
            MarketSizeIncidenceSector sector = (MarketSizeIncidenceSector) iter.next();
            
            for (Iterator iterator = sector.getIncidenceSegments().iterator(); iterator.hasNext();) {
                MarketSizeIncidenceSegment segment = (MarketSizeIncidenceSegment) iterator.next();
                log.info("** Segment: " + segment.getName() + ", Chains " + segment.getNumberOfChainsMenuingItems() + ", CI " + segment.getCategoryIncidence() + ", Universe " + segment.getUnitsInUniverse() + ", Market Size " + segment.getProjectedMarketSize());
                
            }
            
            log.info("SECTOR SUM " + sector.getName() + ", MenuItems " + sector.getNumberOfItemsBeingMenued() + ", Chains " + sector.getNumberOfChainsMenuingItems() + ", items per " + sector.getNumberOfItemsPerChainMenued());
        }
        
        assertTrue(r.getTotals().getCategoryIncidence() > 0.0);
        
    }

 
}
