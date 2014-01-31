/*
 * Created on Jun 8, 2005
 *
 * 
 */
package com.fsrin.menumine.core.dessertmine.xwork.test;

import java.util.Collection;

import junit.framework.TestCase;

import com.fsrin.menumine.context.MenuMineSessionContextFactory;
import com.fsrin.menumine.context.webwork.MenuMineSessionContextWrapper;
import com.fsrin.menumine.core.dessertmine.xwork.DessertMineAction;
import com.fsrin.menumine.core.menumine.webwork.GeneralMineAction;
import com.fsrin.menumine.core.menumine.webwork.MenuMineDisplaySpreadsheetAction;
import com.fsrin.menumine.core.minefields.DessertMineFields;

/**
 * @author Nick
 * 
 *  
 */
public class DessertMineDisplaySpreadSheetTest extends TestCase {
    MenuMineSessionContextWrapper context;

    MasterFoodServiceDelegateMockImpl masterFoodServiceDelegate = new MasterFoodServiceDelegateMockImpl();

    public DessertMineDisplaySpreadSheetTest() {
        super();

    }

    public void testDessertMineAction() throws Exception {
        this.runStandardSequence();

    }

    public void testDessertMineResetAction() throws Exception {
        this.runStandardSequence();

        assertEquals("Dessert", context.getLastFilterWrapper().getGenMenuPart()
                .getAndValues());
        assertEquals(Boolean.TRUE, context.getLastFieldsToDisplay()
                .getGenMenuPart());

        GeneralMineAction generalMineReset = new GeneralMineAction();
        generalMineReset.setMenuMineSessionContextWrapper(context);
        generalMineReset.setReset("RESET");
        assertEquals(DessertMineAction.INPUT, generalMineReset.execute());
        assertTrue(generalMineReset.getMineFields() instanceof DessertMineFields);

        assertEquals("", generalMineReset.getMasterFoodFilterParameters()
                .getGenMenuPart().getAndValues());
        assertEquals(Boolean.TRUE, generalMineReset.getFieldsToDisplay()
                .getGenMenuPart());

        assertEquals(false, context.isFirstQuerySent());
    }

    /*
     * Test to make sure when we ask for a saved query we get it. Note: This
     * uses a MOCK so we are not testing the persistance of the saved query.
     * 
     * 2006-03-15 RSC No longer used.
     */
//    public void testDessertLoadSavedQueryMineAction() throws Exception {
//        this.runStandardSequence();
//        SavedQueryManagerMockImpl savedQueryManager = new SavedQueryManagerMockImpl();
//
//        GeneralMineAction generalMineLoadSaved = new GeneralMineAction();
//        generalMineLoadSaved.setSavedQueryManager(savedQueryManager);
//        generalMineLoadSaved.setMenuMineSessionContextWrapper(context);
//        generalMineLoadSaved
//                .setSelectHistory(SavedQueryManagerMockImpl.SAMPLE_MOCK_QUERY_1);
//        MasterFoodFilterParametersWrapper filters1 = generalMineLoadSaved
//                .getMasterFoodFilterParameters();
//
//        assertEquals(DessertMineAction.SUCCESS, generalMineLoadSaved.execute());
//        assertTrue(
//                "Mine Fields Should be DessertMineFields!",
//                generalMineLoadSaved.getMineFields() instanceof DessertMineFields);
//        MasterFoodFilterParametersWrapper filters2 = generalMineLoadSaved
//                .getMasterFoodFilterParameters();
//
//        assertTrue("We should have loaded a differnt filter.",
//                filters1 != filters2);
//        assertEquals("MOCK_CAKE_USE", generalMineLoadSaved
//                .getMasterFoodFilterParameters().getCakeUse().getAndValues());
//        assertEquals(Boolean.TRUE, generalMineLoadSaved.getFieldsToDisplay()
//                .getCakeUse());
//
//    }

    /*
     * The standard sequence is hit the dessertmine action to set up the context
     * to run as dessertmine.
     * 
     * Then we hit the GeneralMineAction to deal with the filter. The first time
     * we hit it we havn't submit a query so we just go to input.
     * 
     * Next we submit a query that return 1 result(The
     * MasterFoodServiceDelegateMockImpl only creates 1) Submiting the query
     * first goes to GeneralMineAction then to the
     * MenuMineDisplaySpreadsheetAction where the query is executed.
     *  
     */
    private void runStandardSequence() throws Exception {

        DessertMineAction action = new DessertMineAction();
        action.setMenuMineSessionContextWrapper(context);
        assertEquals(DessertMineAction.SUCCESS, action.execute());

        /*
         * We should have switched to the DessertMine set of fields.
         */
        assertTrue(context.getMineFields() instanceof DessertMineFields);
        /*
         * Dessert mine is defined by only searching items with a
         * DayPartCategory of Dessert.
         */
        assertEquals(context.getLastFilterWrapper().getDayPartCategory()
                .getAndValues(), "Dessert");

        /*
         * This makes sure our filter is correct.
         * 
         * We expect that we should go to input now since we haven't submit any
         * parameters.
         */
        GeneralMineAction generalMineInitial = new GeneralMineAction();
        generalMineInitial.setMenuMineSessionContextWrapper(context);
        assertEquals(DessertMineAction.SUCCESS, generalMineInitial.execute());

        /*
         * Make sure this guy is giving us the correct MineFields.
         */
        assertTrue(generalMineInitial.getMineFields() instanceof DessertMineFields);

        GeneralMineAction generalMineSubmit = new GeneralMineAction();
        generalMineSubmit.setMenuMineSessionContextWrapper(context);
        generalMineSubmit.setSubmit("Submit Query");
        generalMineSubmit.getMasterFoodFilterParameters().getGenMenuPart()
                .setAndValues("Dessert");
        generalMineSubmit.getFieldsToDisplay().setGenMenuPart(Boolean.TRUE);
        Collection historyInital = generalMineSubmit.getHistory();
        int historyInitialSize = historyInital.size();

        assertEquals(DessertMineAction.SUCCESS, generalMineSubmit.execute());
        assertTrue(generalMineSubmit.getMineFields() instanceof DessertMineFields);
        Collection history = generalMineSubmit.getHistory();
        assertEquals(historyInitialSize + 1, history.size());

        MenuMineDisplaySpreadsheetAction spreadsheetAction = new MenuMineDisplaySpreadsheetAction();
        spreadsheetAction
                .setMasterFoodServiceDelegate(masterFoodServiceDelegate);
        spreadsheetAction.setMenuMineSessionContextWrapper(context);
        assertEquals(DessertMineAction.SUCCESS, spreadsheetAction.execute());
        Long count = spreadsheetAction.getCount();
        
        assertTrue(count.longValue() > 0);

        Collection results = spreadsheetAction.getResults();
        
        assertNotNull(results);
        
        assertTrue(results.size() > 0);
    }

    protected void setUp() throws Exception {
        super.setUp();
//        JunitSettings.initilizeTestSystem();
        context = MenuMineSessionContextFactory.getMockWrapper();
    }
}