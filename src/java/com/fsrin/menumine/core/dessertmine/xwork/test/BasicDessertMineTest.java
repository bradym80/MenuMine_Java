/*
 * Created on Jun 8, 2005
 *
 * 
 */
package com.fsrin.menumine.core.dessertmine.xwork.test;

import junit.framework.TestCase;

import com.fsrin.menumine.context.webwork.MenuMineSessionContextWrapper;
import com.fsrin.menumine.core.dessertmine.xwork.DessertMineAction;
import com.fsrin.menumine.core.menumine.webwork.MasterFoodFilterParametersWrapper;
import com.fsrin.menumine.core.minefields.DessertMineFields;

/**
 * @author Nick
 * 
 *  
 */
public class BasicDessertMineTest extends TestCase {

    public BasicDessertMineTest() {
        super();

    }

    public void testDessertMineAction() throws Exception {
        MenuMineSessionContextWrapper context = new MenuMineSessionContextWrapper();

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

    }

    public void testDessertMineActionRunTwice() throws Exception {
        MenuMineSessionContextWrapper context = new MenuMineSessionContextWrapper();
        MasterFoodFilterParametersWrapper params0 = context
                .getLastFilterWrapper();

        DessertMineAction action = new DessertMineAction();
        action.setMenuMineSessionContextWrapper(context);
        
        /*
         * executing
         */
        assertEquals(DessertMineAction.SUCCESS, action.execute());
        
        MasterFoodFilterParametersWrapper params1 = context
                .getLastFilterWrapper();

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
         * executing again
         */
        assertEquals(DessertMineAction.SUCCESS, action.execute());
        assertTrue(context.getMineFields() instanceof DessertMineFields);
        assertEquals(context.getLastFilterWrapper().getDayPartCategory()
                .getAndValues(), "Dessert");
        
        /*
         * 
         */
        MasterFoodFilterParametersWrapper params2 = context
                .getLastFilterWrapper();

        /*
         * We should create a new MasterFoodFilterParametersWrapper only when we
         * are changing from Menu to Dessert
         */
        assertTrue(params0.getMasterFoodFilterParameters() != params1.getMasterFoodFilterParameters());
        assertTrue(params1.getMasterFoodFilterParameters() == params2.getMasterFoodFilterParameters());
    }

    protected void setUp() throws Exception {
        super.setUp();
//        JunitSettings.initilizeTestSystem();

    }
}