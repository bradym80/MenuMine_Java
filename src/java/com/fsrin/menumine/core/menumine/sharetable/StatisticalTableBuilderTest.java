/*
 * Created on Feb 1, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.sharetable;

import java.util.Iterator;

import com.fsrin.menumine.core.menumine.FieldEnum;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParametersTestFactory;
import com.fsrin.menumine.core.menumine.rollup.RollUpOptions;
import com.fsrin.menumine.core.menumine.webwork.MenuMineGraphOptions;
import com.fsrin.menumine.testutil.AbstractNonInitializingMenuMineTestCase;

public class StatisticalTableBuilderTest extends
        AbstractNonInitializingMenuMineTestCase {

    public void testBasicAggregationWithPriceData() throws Exception {

        MasterFoodFilterParameters p = MasterFoodFilterParametersTestFactory
                .getItemDescriptionWithBacon();

        MenuMineGraphOptions options = new MenuMineGraphOptions();

        options.setGraphByField(FieldEnum.BASIC_PROTEIN.getOgnlName());

        RollUpOptions roll = new RollUpOptions();

        StatisticalTableIF table = new StatisticalTableBuilder()
                .buildStatisticalTable_FromAggregation_WithPriceData(p,
                        options, roll);

        assertTrue(table.getRows().size() > 8);

        assertNotNull(table.getTotal());

        assertNotNull(table.getTotal().getPriceData());

        assertNotNull(table.getTotal().getPriceData().getAveragePrice2005());

        assertTrue(table.getTotal().getPriceData().getAveragePrice2005()
                .doubleValue() > 0.0);

        for (Iterator iter = table.getRows().iterator(); iter.hasNext();) {
            StatisticalTableElementIF element = (StatisticalTableElementIF) iter
                    .next();
            assertNotNull(element.getSizeOfSample());
        }
    }

    public void testBasicAggregationWithPriceDataAndFilters() throws Exception {

        MasterFoodFilterParameters p = MasterFoodFilterParametersTestFactory
                .getItemDescriptionWithBacon();

        MenuMineGraphOptions options = new MenuMineGraphOptions();

        options.setGraphByField(FieldEnum.BASIC_PROTEIN.getOgnlName());

        options.setFilterNone(true);

        options.setFilterBelowPercentage(true);
        
        options.setFilterBelowPercentageValue(1.0);
        
        RollUpOptions roll = new RollUpOptions();

        StatisticalTableIF table = new StatisticalTableBuilder()
                .buildStatisticalTable_FromAggregation_WithPriceData(p,
                        options, roll);

        log.info("row count is " + table.getRows().size());
        
        assertTrue(table.getRows().size() > 5);

        assertNotNull(table.getTotal());

        assertNotNull(table.getTotal().getPriceData());

        assertNotNull(table.getTotal().getPriceData().getAveragePrice2005());

        assertTrue(table.getTotal().getPriceData().getAveragePrice2005()
                .doubleValue() > 0.0);

        for (Iterator iter = table.getRows().iterator(); iter.hasNext();) {
            StatisticalTableElementIF element = (StatisticalTableElementIF) iter
                    .next();
            assertNotNull(element.getSizeOfSample());

            assertNotNull(element.getPriceData());

            log.info("Name: " + element.getName());
            
            assertTrue(element.getPercent().doubleValue() > 1.0);

            assertTrue(!element.getName().equals(
                    AbstractStatisticalTableElement.NOT_ON_MENU));

        }
    }

    public void testBasicAggregationWithFilter() throws Exception {

        MasterFoodFilterParameters p = MasterFoodFilterParametersTestFactory
                .getItemDescriptionWithBacon();

        MenuMineGraphOptions options = new MenuMineGraphOptions();
        options.setGraphByField(FieldEnum.BASIC_PROTEIN.getOgnlName());
        options.setSimpleFilter("pork");

        RollUpOptions roll = new RollUpOptions();

        StatisticalTableIF table = new StatisticalTableBuilder()
                .buildStatisticalTable_FromAggregation(p, options, roll);

        log.info("Found rows " + table.getRows().size());

        /*
         * 2006-02-06 Based on current database 2006-03-09 Changed from 31 to 25
         * with the DB updated. This is OK per Joe. so I'm changing this to a
         * range.
         * 2006-08-17 reid changed to 7.
         * 2006-11-07 reid changed lower to 6
         */
        assertTrue(table.getRows().size() >= 6 && table.getRows().size() <= 31);

        assertNotNull(table.getTotal());

        for (Iterator iter = table.getRows().iterator(); iter.hasNext();) {
            StatisticalTableElementIF element = (StatisticalTableElementIF) iter
                    .next();
            if (element.getName().toLowerCase().indexOf("pork") < 0) {
                throw new RuntimeException("should have found only pork.");
            }

        }

    }

    public void testBasicAggregationWithDouble() throws Exception {

        MasterFoodFilterParameters p = MasterFoodFilterParametersTestFactory
                .getItemDescriptionWithBacon();

        MenuMineGraphOptions options = new MenuMineGraphOptions();
        options.setGraphByField(FieldEnum.PRICE_2005.getOgnlName());

        RollUpOptions roll = new RollUpOptions();

        StatisticalTableIF table = new StatisticalTableBuilder()
                .buildStatisticalTable_FromAggregation(p, options, roll);

        log.info("Found rows " + table.getRows().size());

        /*
         * 2006-03-07 Based on current database It should be 415.
         */
        assertTrue(table.getRows().size() > 8);

        assertNotNull(table.getTotal());

    }

    public void testBasicAggregationWithInteger() throws Exception {

        MasterFoodFilterParameters p = MasterFoodFilterParametersTestFactory
                .getItemDescriptionWithBacon();

        MenuMineGraphOptions options = new MenuMineGraphOptions();
        options.setGraphByField(FieldEnum.YEAR_PUT_IN_DATABASE.getOgnlName());

        RollUpOptions roll = new RollUpOptions();

        StatisticalTableIF table = new StatisticalTableBuilder()
                .buildStatisticalTable_FromAggregation(p, options, roll);

        log.info("Found rows " + table.getRows().size());

        /*
         * 2006-03-07 Based on current database It should be 415.
         */
        assertTrue(table.getRows().size() > 8);

        assertNotNull(table.getTotal());

    }
}
