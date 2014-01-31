/*
 * Created on Jan 31, 2006 by Reid
 */
package com.fsrin.menumine.core.incidence;

import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParametersTestFactory;
import com.fsrin.menumine.testutil.AbstractNonInitializingMenuMineTestCase;

public class IncidenceTableBuilderTest extends
        AbstractNonInitializingMenuMineTestCase {

    private static Log log = LogFactory.getLog(IncidenceTableBuilderTest.class);
    
    public void testItemsPerChainIncidenceTable() throws Exception {
        
        MasterFoodFilterParameters p = MasterFoodFilterParametersTestFactory.getItemDescriptionWithBacon();
        
        IncidenceTableBuildOptions option = new IncidenceTableBuildOptions();
        
        option.setParams(p);
        option.setYear(new Integer(2005));
        
        IncidenceTable r = new IncidenceTableBuilder().buildItemsPerChainIncidence(option);
        
        /*
         * 2006-01-31 RSC Based on current live data.
         * note that this number may change if you change the year in options.
         */
        assertTrue(r.getIncidenceSectors().size() == 9);
        
        for (Iterator iter = r.getIncidenceSectors().iterator(); iter.hasNext();) {
            IncidenceSector sector = (IncidenceSector) iter.next();
            
            for (Iterator iterator = sector.getIncidenceSegments().iterator(); iterator.hasNext();) {
                IncidenceSegment segment = (IncidenceSegment) iterator.next();
                log.info("** Segment: " + segment.getName() + ", MenuItems " + segment.getNumberOfItemsBeingMenued() + ", Chains " + segment.getNumberOfChainsMenuingItems() + ", items per " + segment.getNumberOfItemsPerChainMenued());
                
            }
            
            log.info("SECTOR SUM " + sector.getName() + ", MenuItems " + sector.getNumberOfItemsBeingMenued() + ", Chains " + sector.getNumberOfChainsMenuingItems() + ", items per " + sector.getNumberOfItemsPerChainMenued());
        }
        
        assertNotNull(r.getTotals());
        
        
        
    }
    
    public void testCategoryIncidenceTable() throws Exception {
        MasterFoodFilterParameters p = MasterFoodFilterParametersTestFactory.getKeywordsWithChicken();
        
        IncidenceTableBuildOptions option = new IncidenceTableBuildOptions();
        
        option.setParams(p);
        option.setYear(new Integer(2005));
        
        IncidenceTable r = new IncidenceTableBuilder().buildCategoryIncidenceTable(option);

        assertNotNull(r);
        
        for (Iterator iter = r.getIncidenceSectors().iterator(); iter.hasNext();) {
            IncidenceSector sector = (IncidenceSector) iter.next();
            
            for (Iterator iterator = sector.getIncidenceSegments().iterator(); iterator.hasNext();) {
                IncidenceSegment segment = (IncidenceSegment) iterator.next();
                log.info("** Segment: " + segment.getName() +  ", Chains " + segment.getNumberOfChainsMenuingItems() + ", CI " + segment.getCategoryIncidence());
                
            }
            
            log.info("SECTOR SUM " + sector.getName() + ", MenuItems " + sector.getNumberOfItemsBeingMenued() + ", Chains " + sector.getNumberOfChainsMenuingItems() + ", items per " + sector.getNumberOfItemsPerChainMenued());
        }
        
        assertTrue(r.getTotals().getCategoryIncidence() > 0.0);
        
    }

    public void testCategoryIncidenceTable_testOperatorCount() throws Exception {
        MasterFoodFilterParameters p = MasterFoodFilterParametersTestFactory.getItemDescriptionWithBacon();
        
        IncidenceTableBuildOptions option = new IncidenceTableBuildOptions();
        
        option.setParams(p);
        option.setYear(new Integer(2005));
        
        IncidenceTable r = new IncidenceTableBuilder().buildCategoryIncidenceTable(option);
    
        assertNotNull(r);
        
        int count = 0;
        
        for (Iterator iter = r.getIncidenceSectors().iterator(); iter.hasNext();) {
            IncidenceSector sector = (IncidenceSector) iter.next();
            
            for (Iterator iterator = sector.getIncidenceSegments().iterator(); iterator.hasNext();) {
                IncidenceSegment segment = (IncidenceSegment) iterator.next();
                log.info("** Segment: " + segment.getName() + ", MenuItems " + segment.getNumberOfItemsBeingMenued() + ", Chains " + segment.getNumberOfChainsMenuingItems() + ", items per " + segment.getNumberOfItemsPerChainMenued());
                count+=segment.getNumberOfChains();
            }
            
            log.info("SECTOR SUM " + sector.getName() + ", MenuItems " + sector.getNumberOfItemsBeingMenued() + ", Chains " + sector.getNumberOfChainsMenuingItems() + ", items per " + sector.getNumberOfItemsPerChainMenued());
        }
        
        assertTrue(count < 1100);
    }
    
    public void testCategoryIncidenceTable_testOperatorCount_YearOverYear() throws Exception {
        MasterFoodFilterParameters p = MasterFoodFilterParametersTestFactory.getItemDescriptionWithBacon();
        
        IncidenceTableBuildOptions option = new IncidenceTableBuildOptions();
        
        option.setParams(p);
        option.setYear(new Integer(1996));
        
        IncidenceTable r1996 = new IncidenceTableBuilder().buildCategoryIncidenceTable(option);

        option.setYear(new Integer(2005));
        IncidenceTable r2005 = new IncidenceTableBuilder().buildCategoryIncidenceTable(option);

        assertNotNull(r1996);
        assertNotNull(r2005);
        
        int count1996 = 0;
        
        for (Iterator iter = r1996.getIncidenceSectors().iterator(); iter.hasNext();) {
            IncidenceSector sector = (IncidenceSector) iter.next();
            
            for (Iterator iterator = sector.getIncidenceSegments().iterator(); iterator.hasNext();) {
                IncidenceSegment segment = (IncidenceSegment) iterator.next();
                log.info("** Segment: " + segment.getName() + ", MenuItems " + segment.getNumberOfItemsBeingMenued() + ", Chains " + segment.getNumberOfChainsMenuingItems() + ", items per " + segment.getNumberOfItemsPerChainMenued());
                count1996+=segment.getNumberOfChains();
            }
            
            log.info("SECTOR SUM " + sector.getName() + ", MenuItems " + sector.getNumberOfItemsBeingMenued() + ", Chains " + sector.getNumberOfChainsMenuingItems() + ", items per " + sector.getNumberOfItemsPerChainMenued());
        }
        
        int count2005 = 0;
        
        for (Iterator iter = r2005.getIncidenceSectors().iterator(); iter.hasNext();) {
            IncidenceSector sector = (IncidenceSector) iter.next();
            
            for (Iterator iterator = sector.getIncidenceSegments().iterator(); iterator.hasNext();) {
                IncidenceSegment segment = (IncidenceSegment) iterator.next();
                log.info("** Segment: " + segment.getName() + ", MenuItems " + segment.getNumberOfItemsBeingMenued() + ", Chains " + segment.getNumberOfChainsMenuingItems() + ", items per " + segment.getNumberOfItemsPerChainMenued());
                count2005+=segment.getNumberOfChains();
            }
            
            log.info("SECTOR SUM " + sector.getName() + ", MenuItems " + sector.getNumberOfItemsBeingMenued() + ", Chains " + sector.getNumberOfChainsMenuingItems() + ", items per " + sector.getNumberOfItemsPerChainMenued());
        }
        
        assertTrue(count1996 < count2005);
    }
}
