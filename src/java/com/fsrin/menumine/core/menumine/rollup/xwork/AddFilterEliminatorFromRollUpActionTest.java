/*
 * Created on Jun 3, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.rollup.xwork;

import com.fsrin.menumine.context.webwork.MenuMineSessionContextWrapper;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParametersImpl;
import com.fsrin.menumine.core.menumine.rollup.RollUpElement;
import com.fsrin.menumine.core.menumine.rollup.RollUpOptions;
import com.fsrin.menumine.core.menumine.webwork.MasterFoodFilterParametersWrapperImpl;
import com.fsrin.menumine.core.menumine.webwork.MenuMineGraphOptions;
import com.opensymphony.xwork.ActionSupport;

/**
 * @author Nick
 * 
 *  
 */
public class AddFilterEliminatorFromRollUpActionTest extends AbstractRollUpTestSupport {

    public void testAddFilterEliminatorFromRollUpAction() throws Exception {
        MenuMineSessionContextWrapper context = new MenuMineSessionContextWrapper();
        context.setLastFilterWrapper(new MasterFoodFilterParametersWrapperImpl(
                new MasterFoodFilterParametersImpl()));
        context.setLastGraphOptions(new MenuMineGraphOptions());
        context.getLastGraphOptions().setGraphByField("basicProtein");

        RollUpOptions rollUpOptions = new RollUpOptions();

        RollUpElement element = new RollUpElement();
        element.setLabel("MyTest");
        element.setTerm("Beef");
        rollUpOptions.getRollUpElements().add(element);

        context.setRollUpOptions(rollUpOptions);

        AddFilterEliminatorFromRollUpAction action = new AddFilterEliminatorFromRollUpAction();
        action.setTarget("MyTest");// This is the label of the element in the
                                   // roll up.
        action.setMenuMineSessionContextWrapper(context);

        assertEquals(ActionSupport.SUCCESS, action.execute());

        MasterFoodFilterParameters params = action
                .getMenuMineSessionContextWrapper().getLastFilterWrapper()
                .getMasterFoodFilterParameters();

        assertEquals(1, params.getBasicProtein().getNotValues().size());//We
                                                                        // should
                                                                        // have
                                                                        // added
                                                                        // 'Beef'
                                                                        // to
                                                                        // the
                                                                        // not.
        assertEquals("Beef", params.getBasicProtein().getNotValues()
                .toArray()[0]);

    }

//    protected void setUp() throws Exception {
//
//        super.setUp();
//
//        JunitSettings.initilizeTestSystem();
//    }
}