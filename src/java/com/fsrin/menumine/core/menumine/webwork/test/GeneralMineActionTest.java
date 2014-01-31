/*
 * Created on Jun 17, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.webwork.test;

import org.jmock.Mock;
import org.jmock.MockObjectTestCase;

import com.fsrin.menumine.context.MenuMineSessionContextFactory;
import com.fsrin.menumine.context.webwork.MenuMineSessionContextWrapper;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;
import com.fsrin.menumine.core.menumine.webwork.GeneralMineAction;
import com.fsrin.menumine.core.menumine.webwork.MasterFoodFilterParametersWrapperImpl;
import com.fsrin.menumine.testutil.JunitSettings;

/**
 * @author Nick
 * 
 *  
 */
public class GeneralMineActionTest extends MockObjectTestCase {

    public void testGeneralMine() throws Exception {

        Mock mockFilterParameters = mock(MasterFoodFilterParameters.class);

//        mockFilterParameters.expects(once()).method(
//                "applyMasterFoodFilterParameters");

        MenuMineSessionContextWrapper wrapper = MenuMineSessionContextFactory.getMockWrapper("mbrady");

        MasterFoodFilterParameters masterFoodFilterParameters = (MasterFoodFilterParameters) mockFilterParameters
                .proxy();

        MasterFoodFilterParametersWrapperImpl mfParamsWrapper = new MasterFoodFilterParametersWrapperImpl(
                masterFoodFilterParameters);

        wrapper.setLastFilterWrapper(mfParamsWrapper);

        GeneralMineAction general = new GeneralMineAction();
        general.setMenuMineSessionContextWrapper(wrapper);
        general.getMasterFoodFilterParameters().getBasicProtein().setAndValues(
                "Beef");

        general.setSubmit("Submit");
        general.execute();

    }

    protected void setUp() throws Exception {

        super.setUp();

        JunitSettings.initilizeTestSystem();
    }
}