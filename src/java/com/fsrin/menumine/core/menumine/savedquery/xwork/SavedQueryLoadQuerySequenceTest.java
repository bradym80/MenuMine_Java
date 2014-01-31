/*
 * Created on Mar 17, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.savedquery.xwork;

import java.util.Date;

import com.fsrin.menumine.common.SpringBeanBroker;
import com.fsrin.menumine.context.MenuMineSessionContextFactory;
import com.fsrin.menumine.context.webwork.MenuMineSessionContextWrapper;
import com.fsrin.menumine.core.menumine.FieldsToDisplayBean;
import com.fsrin.menumine.core.menumine.FieldsToDisplayBeanBuilder;
import com.fsrin.menumine.core.menumine.util.MasterFoodFilterParametersComparator;
import com.fsrin.menumine.testutil.AbstractNonInitializingMenuMineTestCase;
import com.opensymphony.xwork.Action;

public class SavedQueryLoadQuerySequenceTest extends
        AbstractNonInitializingMenuMineTestCase {

    private String queryName;

    protected void setUp() throws Exception {

        super.setUp();

        queryName = "testQuery " + new Date().getTime();
    }

    protected void tearDown() throws Exception {

        super.tearDown();

    }

    public void testSaveQueryLoadQuerySequenceTest() throws Exception {

        /*
         * start with a simple save.
         */

        MenuMineSessionContextWrapper session = MenuMineSessionContextFactory
                .getMockWrapperWithBacon(SAMPLE_USERNAME);
        
        /*
         * 2006-08-17 reid added so the system knows that fields to display.
         */
        FieldsToDisplayBean fields = new FieldsToDisplayBeanBuilder().build(session.getLastFilterWrapper().getMasterFoodFilterParameters());
        
        session.setLastFieldsToDisplay(fields);


        SaveAsNewQueryAction saveAction = (SaveAsNewQueryAction) SpringBeanBroker
                .getBeanFactory()
                .getBean(SaveAsNewQueryAction.SPRING_BEAN_NAME);

        saveAction.setMenuMineSessionContextWrapper(session);

        saveAction.setSpreadsheetName(queryName);

        String s = saveAction.execute();

        assertEquals(Action.SUCCESS, s);

        /*
         * laod the saved query from above using the name.
         */
        MenuMineSessionContextWrapper loadSession = MenuMineSessionContextFactory
                .getMockWrapper(SAMPLE_USERNAME);

        LoadQueryAction loadAction = (LoadQueryAction) SpringBeanBroker
                .getBeanFactory().getBean(LoadQueryAction.SPRING_BEAN_NAME);

        loadAction.setMenuMineSessionContextWrapper(loadSession);

        loadAction.setSelectHistory(queryName);

        String loadResult = loadAction.execute();

        assertEquals(Action.SUCCESS, loadResult);

        /*
         * now test and make sure the filter parameters are equal.
         */

        assertNotSame(session.getLastFilterWrapper(), loadSession
                .getLastFilterWrapper());

        assertNotSame(session.getLastFilterWrapper()
                .getMasterFoodFilterParameters(), loadSession
                .getLastFilterWrapper().getMasterFoodFilterParameters());

        new MasterFoodFilterParametersComparator().testForEquality(session
                .getLastFilterWrapper().getMasterFoodFilterParameters(),
                loadSession.getLastFilterWrapper()
                        .getMasterFoodFilterParameters());

    }


}
