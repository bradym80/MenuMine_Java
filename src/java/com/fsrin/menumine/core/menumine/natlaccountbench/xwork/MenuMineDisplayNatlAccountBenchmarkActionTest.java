/*
 * Created on Feb 2, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.natlaccountbench.xwork;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fsrin.menumine.context.MenuMineSessionContextFactory;
import com.fsrin.menumine.context.webwork.MenuMineSessionContextWrapper;
import com.fsrin.menumine.core.menumine.FieldEnum;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParametersTestFactory;
import com.fsrin.menumine.core.menumine.natlaccountbench.NationalAccountBenchmarkChartBuilder;
import com.fsrin.menumine.core.menumine.natlaccountbench.NationalAccountBenchmarkElement;
import com.fsrin.menumine.core.menumine.natlaccountbench.NationalAccountBenchmarkTable;
import com.fsrin.menumine.core.menumine.rollup.RollUpOptions;
import com.fsrin.menumine.core.menumine.webwork.MasterFoodFilterParametersWrapper;
import com.fsrin.menumine.core.menumine.webwork.MenuMineGraphOptions;
import com.fsrin.menumine.testutil.AbstractNonInitializingMenuMineTestCase;
import com.opensymphony.xwork.Action;

public class MenuMineDisplayNatlAccountBenchmarkActionTest extends
        AbstractNonInitializingMenuMineTestCase {

    private static Log log = LogFactory
            .getLog(MenuMineDisplayNatlAccountBenchmarkActionTest.class);

    public void testBasic() throws Exception {

        FieldEnum graphBy = FieldEnum.BASIC_PROTEIN;
        /*
         * setup the session context and wrapper
         */
        MenuMineSessionContextWrapper sessionContext = MenuMineSessionContextFactory
                .getMockWrapper();

        /*
         * setup the filter options
         */
        MasterFoodFilterParametersWrapper params = MasterFoodFilterParametersTestFactory
                .getItemDescriptionWithBaconInWrapper();

        /*
         * other
         */
        MenuMineGraphOptions graphOptions = new MenuMineGraphOptions();
        graphOptions.setGraphByField(graphBy.getOgnlName());

        RollUpOptions rollUpOptions = new RollUpOptions();

        /*
         * put them together
         */
        sessionContext.setLastFilterWrapper(params);
        sessionContext.setLastGraphOptions(graphOptions);
        sessionContext.setRollUpOptions(rollUpOptions);

        /*
         * build the options
         */
        NationalAccountBenchmarkWebOptions webOptions = new NationalAccountBenchmarkWebOptions();
        Collection targetChains = new ArrayList();
        targetChains.add("Jasons Deli");
        Collection benchmarkChains = new ArrayList();
        benchmarkChains.add("Cosi");
        benchmarkChains.add("Great Wraps");
        benchmarkChains.add("Schlotzkys Deli");

        webOptions.setTargetChains(targetChains);
        webOptions.setBenchmarkChains(benchmarkChains);

        /*
         * build the action
         */
        MenuMineDisplayNatlAccountBenchmarkAction action = new MenuMineDisplayNatlAccountBenchmarkAction();
        action.setMenuMineSessionContextWrapper(sessionContext);
        action.setNationalAccountBenchmarkWebOptions(webOptions);
        action.setMenuMineGraphOptions(graphOptions);

        action.setSubmitOptions("Display Table");
        /*
         * execute
         */
        String s = action.execute();

        assertEquals(Action.SUCCESS, s);

        /*
         * test the table a bit
         */
        NationalAccountBenchmarkTable table = action
                .getNationalAccountBenchmarkTableResults();

        assertNotNull(table);
        assertNotNull(table.getRows());
        assertTrue(table.getRows().size() > 1);
        assertTrue(table.getRows().toArray()[0] instanceof NationalAccountBenchmarkElement);

    }

    public void testBasicWithMeNEds() throws Exception {

        FieldEnum graphBy = FieldEnum.BASIC_PROTEIN;
        /*
         * setup the session context and wrapper
         */
        MenuMineSessionContextWrapper sessionContext = MenuMineSessionContextFactory
                .getMockWrapper();

        /*
         * setup the filter options
         */
        MasterFoodFilterParametersWrapper params = MasterFoodFilterParametersTestFactory
                .getItemDescriptionWithBaconInWrapper();

        /*
         * other
         */
        MenuMineGraphOptions graphOptions = new MenuMineGraphOptions();
        graphOptions.setGraphByField(graphBy.getOgnlName());

        RollUpOptions rollUpOptions = new RollUpOptions();

        /*
         * put them together
         */
        sessionContext.setLastFilterWrapper(params);
        sessionContext.setLastGraphOptions(graphOptions);
        sessionContext.setRollUpOptions(rollUpOptions);

        /*
         * build the options
         */
        NationalAccountBenchmarkWebOptions webOptions = new NationalAccountBenchmarkWebOptions();
        Collection targetChains = new ArrayList();
        targetChains.add("Jasons Deli");
        Collection benchmarkChains = new ArrayList();
        benchmarkChains.add("Cosi");
        benchmarkChains.add("Great Wraps");
        benchmarkChains.add("Me 'N' Eds Pizzaria");

        webOptions.setTargetChains(targetChains);
        webOptions.setBenchmarkChains(benchmarkChains);

        /*
         * build the action
         */
        MenuMineDisplayNatlAccountBenchmarkAction action = new MenuMineDisplayNatlAccountBenchmarkAction();
        action.setMenuMineSessionContextWrapper(sessionContext);
        action.setNationalAccountBenchmarkWebOptions(webOptions);
        action.setMenuMineGraphOptions(graphOptions);

        action.setSubmitOptions("Display Table");
        /*
         * execute
         */
        String s = action.execute();

        assertEquals(Action.SUCCESS, s);

        /*
         * test the table a bit
         */
        NationalAccountBenchmarkTable table = action
                .getNationalAccountBenchmarkTableResults();

        assertNotNull(table);
        assertNotNull(table.getRows());
        assertTrue(table.getRows().size() > 1);
        assertTrue(table.getRows().toArray()[0] instanceof NationalAccountBenchmarkElement);

    }

    public void testBasicWithMeNEds_Graph() throws Exception {

        FieldEnum graphBy = FieldEnum.BASIC_PROTEIN;
        /*
         * setup the session context and wrapper
         */
        MenuMineSessionContextWrapper sessionContext = MenuMineSessionContextFactory
                .getMockWrapper();

        /*
         * setup the filter options
         */
        MasterFoodFilterParametersWrapper params = MasterFoodFilterParametersTestFactory
                .getItemDescriptionWithBaconInWrapper();

        /*
         * other
         */
        MenuMineGraphOptions graphOptions = new MenuMineGraphOptions();
        graphOptions.setGraphByField(graphBy.getOgnlName());
        graphOptions.setGraphTitle("Title");

        RollUpOptions rollUpOptions = new RollUpOptions();

        /*
         * put them together
         */
        sessionContext.setLastFilterWrapper(params);
        sessionContext.setLastGraphOptions(graphOptions);
        sessionContext.setRollUpOptions(rollUpOptions);

        /*
         * build the options
         */
        NationalAccountBenchmarkWebOptions webOptions = new NationalAccountBenchmarkWebOptions();
        Collection targetChains = new ArrayList();
        targetChains.add("Jasons Deli");
        Collection benchmarkChains = new ArrayList();
        benchmarkChains.add("Cosi");
        benchmarkChains.add("Great Wraps");
        benchmarkChains.add("Me 'N' Eds Pizzaria");

        webOptions.setTargetChains(targetChains);
        webOptions.setBenchmarkChains(benchmarkChains);

        /*
         * build the action
         */
        NationalAccountBenchmarkGraphAction action = new NationalAccountBenchmarkGraphAction();
        action.setMenuMineSessionContextWrapper(sessionContext);
        action.setNationalAccountBenchmarkWebOptions(webOptions);
        action.setMenuMineGraphOptions(graphOptions);

        action.setSubmitOptions("Display Graph");

        /*
         * chart builder
         */
        action.setChartBuilder(new NationalAccountBenchmarkChartBuilder());
        /*
         * execute
         */
        String s = action.execute();

        assertEquals(Action.SUCCESS, s);

        /*
         * test the table a bit
         */
        NationalAccountBenchmarkTable table = action
                .getNationalAccountBenchmarkTableResults();

        assertNotNull(table);
        assertNotNull(table.getRows());
        assertTrue(table.getRows().size() > 1);
        assertTrue(table.getRows().toArray()[0] instanceof NationalAccountBenchmarkElement);

        assertTrue(action.getChart() != null);
    }

    public void testBasicWithMeNEds_Trend() throws Exception {

        FieldEnum graphBy = FieldEnum.BASIC_PROTEIN;
        /*
         * setup the session context and wrapper
         */
        MenuMineSessionContextWrapper sessionContext = MenuMineSessionContextFactory
                .getMockWrapper();

        /*
         * setup the filter options
         */
        MasterFoodFilterParametersWrapper params = MasterFoodFilterParametersTestFactory
                .getItemDescriptionWithBaconInWrapper();

        /*
         * other
         */
        MenuMineGraphOptions graphOptions = new MenuMineGraphOptions();
        graphOptions.setGraphByField(graphBy.getOgnlName());

        RollUpOptions rollUpOptions = new RollUpOptions();

        /*
         * put them together
         */
        sessionContext.setLastFilterWrapper(params);
        sessionContext.setLastGraphOptions(graphOptions);
        sessionContext.setRollUpOptions(rollUpOptions);

        /*
         * build the options
         */
        NationalAccountBenchmarkWebOptions webOptions = new NationalAccountBenchmarkWebOptions();
        Collection targetChains = new ArrayList();
        targetChains.add("Jasons Deli");
        Collection benchmarkChains = new ArrayList();
        benchmarkChains.add("Cosi");
        benchmarkChains.add("Great Wraps");
        benchmarkChains.add("Me 'N' Eds Pizzaria");

        webOptions.setTargetChains(targetChains);
        webOptions.setBenchmarkChains(benchmarkChains);

        /*
         * build the action
         */
        MenuMineDisplayNatlAccountBenchmarkTrendAction action = new MenuMineDisplayNatlAccountBenchmarkTrendAction();
        action.setMenuMineSessionContextWrapper(sessionContext);
        action.setNationalAccountBenchmarkWebOptions(webOptions);
        action.setMenuMineGraphOptions(graphOptions);

        action.setSubmitOptions("Display Table");
        /*
         * execute
         */
        String s = action.execute();

        assertEquals(Action.SUCCESS, s);

        /*
         * test the table a bit
         */
        NationalAccountBenchmarkTable table = action
                .getNationalAccountBenchmarkTableResults();

        assertNotNull(table);
        assertNotNull(table.getRows());
        assertTrue(table.getRows().size() > 1);
        assertTrue(table.getRows().toArray()[0] instanceof NationalAccountBenchmarkElement);

    }

    /**
     * 2006-03-08 RSC Used to excersize and eliminate a bug.
     * 
     * @throws Exception
     */
    public void testBasic_EnsureTargetsDontGetIntoTheMasterFilterParameters()
            throws Exception {

        FieldEnum graphBy = FieldEnum.BASIC_PROTEIN;
        /*
         * setup the session context and wrapper
         */
        MenuMineSessionContextWrapper sessionContext = MenuMineSessionContextFactory
                .getMockWrapperWithBacon(SAMPLE_USERNAME);

        /*
         * other
         */
        MenuMineGraphOptions graphOptions = new MenuMineGraphOptions();
        graphOptions.setGraphByField(graphBy.getOgnlName());

        RollUpOptions rollUpOptions = new RollUpOptions();

        /*
         * put them together
         */
        sessionContext.setLastGraphOptions(graphOptions);
        sessionContext.setRollUpOptions(rollUpOptions);

        /*
         * build the options
         */
        NationalAccountBenchmarkWebOptions webOptions = new NationalAccountBenchmarkWebOptions();
        Collection targetChains = new ArrayList();
        targetChains.add("Jasons Deli");
        Collection benchmarkChains = new ArrayList();
        benchmarkChains.add("Cosi");
        benchmarkChains.add("Great Wraps");
        benchmarkChains.add("Me 'N' Eds Pizzaria");

        webOptions.setTargetChains(targetChains);
        webOptions.setBenchmarkChains(benchmarkChains);

        /*
         * build the action
         */
        MenuMineDisplayNatlAccountBenchmarkAction action = new MenuMineDisplayNatlAccountBenchmarkAction();
        action.setMenuMineSessionContextWrapper(sessionContext);
        action.setNationalAccountBenchmarkWebOptions(webOptions);
        action.setMenuMineGraphOptions(graphOptions);

        action.setSubmitOptions("Display Table");
        /*
         * execute
         */
        String s = action.execute();

        assertEquals(Action.SUCCESS, s);

        /*
         * we don't really care about anything EXCEPT how the
         * masterfoodfilterparameters have changed.
         */
        
        assertTrue(sessionContext.getLastFilterWrapper().getOperationName().getInValues().size() == 0);
        

    }
}
