/*
 * Created on Mar 15, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.savedquery.xwork;

import java.util.Collection;
import java.util.Date;

import com.fsrin.menumine.common.FilterParameter;
import com.fsrin.menumine.common.SpringBeanBroker;
import com.fsrin.menumine.context.MenuMineSessionContextFactory;
import com.fsrin.menumine.context.webwork.MenuMineSessionContextWrapper;
import com.fsrin.menumine.core.menumine.FieldsToDisplayBean;
import com.fsrin.menumine.core.menumine.FieldsToDisplayBeanBuilder;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParametersTestFactory;
import com.fsrin.menumine.core.menumine.savedquery.SavedQuery;
import com.fsrin.menumine.core.menumine.savedquery.SavedQueryServiceDelegate;
import com.fsrin.menumine.core.menumine.util.MasterFoodFilterParametersComparator;
import com.fsrin.menumine.testutil.AbstractNonInitializingMenuMineTestCase;
import com.opensymphony.xwork.Action;

public class SaveAsNewQueryActionTest extends
        AbstractNonInitializingMenuMineTestCase {

    public void testBasic() throws Exception {

        MenuMineSessionContextWrapper sessionContextWrapper = MenuMineSessionContextFactory
                .getMockWrapperWithBacon(SAMPLE_USERNAME);

        assertTrue(sessionContextWrapper.getLastFilterWrapper()
                .getGenMenuPart().getFilterParameter().isSelect());

        SaveAsNewQueryAction action = (SaveAsNewQueryAction) SpringBeanBroker
                .getBeanFactory()
                .getBean(SaveAsNewQueryAction.SPRING_BEAN_NAME);

        action.setMenuMineSessionContextWrapper(sessionContextWrapper);

        assertNotNull(action.getSavedQueryManager());
        assertNotNull(action.getSavedQueryServiceDelegate());
        assertNotNull(action.getUserGroupServiceDelegate());

        String s = action.execute();

        assertEquals(Action.SUCCESS, s);

    }

    public void testVerifySavedAndSelectedDisplayFields() throws Exception {

        MenuMineSessionContextWrapper sessionContextWrapper = MenuMineSessionContextFactory
                .getMockWrapperWithBacon(SAMPLE_USERNAME);
        
        /*
         * 2006-08-17 reid added so the system knows that fields to display.
         */
        FieldsToDisplayBean fields = new FieldsToDisplayBeanBuilder().build(sessionContextWrapper.getLastFilterWrapper().getMasterFoodFilterParameters());
        
        sessionContextWrapper.setLastFieldsToDisplay(fields);

        Collection savedQueries = SavedQueryServiceDelegate.factory.build()
                .getByUser(SAMPLE_USERNAME);

        SaveAsNewQueryAction action = (SaveAsNewQueryAction) SpringBeanBroker
                .getBeanFactory()
                .getBean(SaveAsNewQueryAction.SPRING_BEAN_NAME);

        action.setMenuMineSessionContextWrapper(sessionContextWrapper);

        assertNotNull(action.getSavedQueryManager());
        assertNotNull(action.getSavedQueryServiceDelegate());
        assertNotNull(action.getUserGroupServiceDelegate());

        action.setSpreadsheetName("test" + new Date().getTime());

        String s = action.execute();

        assertEquals(Action.SUCCESS, s);

        Collection savedQueriesAfter = SavedQueryServiceDelegate.factory
                .build().getByUser(SAMPLE_USERNAME);

        assertTrue(savedQueriesAfter.size() == savedQueries.size() + 1);

        SavedQuery q = SavedQueryServiceDelegate.factory.build().getByUser(
                SAMPLE_USERNAME, action.getSpreadsheetName());

        assertTrue(q.getFieldsToDisplayBean().countTotalSelected() > 0);

        SavedQueryServiceDelegate.factory.build().delete(q);
    }

    public void testSaveAsNewFeature() throws Exception {

        MenuMineSessionContextWrapper sessionContextWrapper = MenuMineSessionContextFactory
                .getMockWrapperWithBacon(SAMPLE_USERNAME);

        /*
         * 2006-08-17 reid added so the system knows that fields to display.
         */
        FieldsToDisplayBean fields = new FieldsToDisplayBeanBuilder().build(sessionContextWrapper.getLastFilterWrapper().getMasterFoodFilterParameters());
        
        sessionContextWrapper.setLastFieldsToDisplay(fields);

        
        FilterParameter o = sessionContextWrapper.getLastFilterWrapper()
                .getItemDescription().getFilterParameter();

        assertTrue(sessionContextWrapper.getLastFilterWrapper()
                .getItemDescription().getFilterParameter().isSelect());

        assertTrue(sessionContextWrapper.getLastFilterWrapper()
                .getGenMenuPart().getFilterParameter().isSelect());

        assertTrue(sessionContextWrapper.getLastFilterWrapper()
                .getBasicProtein().getFilterParameter().isSelect());

        SaveAsNewQueryAction action = (SaveAsNewQueryAction) SpringBeanBroker
                .getBeanFactory()
                .getBean(SaveAsNewQueryAction.SPRING_BEAN_NAME);

        action.setMenuMineSessionContextWrapper(sessionContextWrapper);

        action.setSpreadsheetName("first" + new Date().getTime());

        String s = action.execute();

        assertEquals(Action.SUCCESS, s);

        SavedQuery result = action.getResult();
        
        Long id = result.getId();
        
        sessionContextWrapper = null;
        
        action = null;
        
        result = null;
        
        SavedQuery reloaded = SavedQueryServiceDelegate.factory.build().getById(id);
        
        
        MasterFoodFilterParameters bacon = MasterFoodFilterParametersTestFactory.getItemDescriptionWithBacon();
        
        new MasterFoodFilterParametersComparator().testForEquality(reloaded.getMasterFoodFilterParameters(),bacon);
        


    }
    
    /*
     * should get an error message if you attempt to save with
     * a name that already exists.
     */
    public void testSaveAsNewFeatureWithANameAlreadyInUse() throws Exception {

        MenuMineSessionContextWrapper sessionContextWrapper = MenuMineSessionContextFactory
                .getMockWrapperWithBacon(SAMPLE_USERNAME);

        /*
         * 2006-08-17 reid added so the system knows that fields to display.
         */
        FieldsToDisplayBean fields = new FieldsToDisplayBeanBuilder().build(sessionContextWrapper.getLastFilterWrapper().getMasterFoodFilterParameters());
        
        sessionContextWrapper.setLastFieldsToDisplay(fields);

        
        SaveAsNewQueryAction action = (SaveAsNewQueryAction) SpringBeanBroker
                .getBeanFactory()
                .getBean(SaveAsNewQueryAction.SPRING_BEAN_NAME);

        action.setMenuMineSessionContextWrapper(sessionContextWrapper);

        action.setSpreadsheetName("first" + new Date().getTime());

        String s = action.execute();

        assertEquals(Action.SUCCESS, s);

        assertFalse(sessionContextWrapper.getErrorContext().hasErrors());
        
        /*
         * ok now let's do the same thing.
         */
        String s2 = action.execute();

        assertEquals(Action.SUCCESS, s2);

        assertTrue(sessionContextWrapper.getErrorContext().hasErrors());

    }
}
