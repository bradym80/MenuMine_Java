/*
 * Created on Jan 31, 2006 by Reid
 */
package com.fsrin.menumine.core.crosstab;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fsrin.menumine.common.dao.GenericDAOFactory;
import com.fsrin.menumine.core.menumine.FieldEnum;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParametersTestFactory;
import com.fsrin.menumine.core.menumine.masterfood.hql.MasterFoodQueryBuilder;
import com.fsrin.menumine.core.menumine.rollup.RollUpOptionsTestFactory;
import com.fsrin.menumine.core.menumine.webwork.MenuMineCrossTabulationOptions;
import com.fsrin.menumine.testutil.AbstractNonInitializingMenuMineTestCase;

public class CrossTabulationTableBuilderTest extends
        AbstractNonInitializingMenuMineTestCase {

    private Log log = LogFactory.getLog(CrossTabulationTableBuilderTest.class);

    public void testBasic() throws Exception {

        MenuMineCrossTabulationOptions options = new MenuMineCrossTabulationOptions();

        options.setFilter(MasterFoodFilterParametersTestFactory
                .getItemDescriptionWithBacon());
        options.setHorizontalField(FieldEnum.BASIC_PROTEIN.getOgnlName());
        options.setVerticalField(FieldEnum.CHEESE.getOgnlName());

        CrossTabulationTable table = new CrossTabulationTableBuilder()
                .build(options);

        log.info("should have built the table...");

        assertNotNull(table);

        /*
         * figure out what the columns should look like
         */
        MasterFoodFilterParameters pRows = MasterFoodFilterParametersTestFactory
                .getItemDescriptionWithBacon();
        pRows.getBasicProtein().setSelect(true);

        Collection testColumns = GenericDAOFactory.factory.buildData().find(
                new MasterFoodQueryBuilder().getQueryForCountWithGroupByConjunctive(pRows,
                        FieldEnum.BASIC_PROTEIN.getOgnlName()).toString());

        log.info("testColumns size: " + testColumns.size()
                + ", table column count " + table.getColumns().size());
        assertEquals(testColumns.size(), table.getColumns().size());

        /*
         * figure out what the rows should look like.
         */
        MasterFoodFilterParameters pColumns = MasterFoodFilterParametersTestFactory
                .getItemDescriptionWithBacon();
        pColumns.getCheeseMM().setSelect(true);

        Collection testRows = GenericDAOFactory.factory.buildData().find(
                new MasterFoodQueryBuilder().getQueryForCountWithGroupByConjunctive(
                        pColumns, FieldEnum.CHEESE.getOgnlName())
                        .toString());

        log.info("testRows size: " + testRows.size() + ", table row count "
                + table.getRows().size());
        assertEquals(testRows.size(), table.getRows().size());
    }
    
    public void testBasicWithRollUps() throws Exception {

        MenuMineCrossTabulationOptions options = new MenuMineCrossTabulationOptions();

        options.setFilter(MasterFoodFilterParametersTestFactory
                .getItemDescriptionWithBacon());
        options.setHorizontalField(FieldEnum.CUISINE_FAMILY.getOgnlName());
        options.setHorizontalRollUpOptions(RollUpOptionsTestFactory.buildTestAmericanRollUpOthers());
        options.setVerticalField(FieldEnum.CHEESE.getOgnlName());

        CrossTabulationTable table = new CrossTabulationTableBuilder()
                .build(options);

        log.info("should have built the table...");

        assertNotNull(table);

        /*
         * figure out what the columns should look like
         */
        MasterFoodFilterParameters pRows = MasterFoodFilterParametersTestFactory
                .getItemDescriptionWithBacon();
        pRows.getBasicProtein().setSelect(true);

        Collection testColumns = GenericDAOFactory.factory.buildData().find(
                new MasterFoodQueryBuilder().getQueryForCountWithGroupByConjunctive(pRows,
                        FieldEnum.CUISINE_FAMILY.getOgnlName()).toString());

        /*
         * 2006-02-03 RSC Remember that it should be one less because 
         * of the test roll up options.
         */
        log.info("testColumns size: " + testColumns.size()
                + ", table column count " + table.getColumns().size());
        assertEquals(testColumns.size()-1, table.getColumns().size());

        /*
         * figure out what the rows should look like.
         */
        MasterFoodFilterParameters pColumns = MasterFoodFilterParametersTestFactory
                .getItemDescriptionWithBacon();
        pColumns.getCheeseMM().setSelect(true);

        Collection testRows = GenericDAOFactory.factory.buildData().find(
                new MasterFoodQueryBuilder().getQueryForCountWithGroupByConjunctive(
                        pColumns, FieldEnum.CHEESE.getOgnlName())
                        .toString());

        log.info("testRows size: " + testRows.size() + ", table row count "
                + table.getRows().size());
        assertEquals(testRows.size(), table.getRows().size());
    }
}
