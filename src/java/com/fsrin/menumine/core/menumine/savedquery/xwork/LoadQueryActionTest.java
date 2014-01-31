/*
 * Created on Mar 15, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.savedquery.xwork;

import com.fsrin.menumine.common.SpringBeanBroker;
import com.fsrin.menumine.common.dao.GenericDAO;
import com.fsrin.menumine.common.dao.GenericDAOFactory;
import com.fsrin.menumine.context.MenuMineSessionContextFactory;
import com.fsrin.menumine.context.webwork.MenuMineSessionContextWrapper;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParametersImpl;
import com.fsrin.menumine.core.menumine.savedquery.SavedQuery;
import com.fsrin.menumine.core.menumine.savedquery.SavedQueryServiceDelegate;
import com.fsrin.menumine.core.menumine.savedquery.SavedQueryTestFactory;
import com.fsrin.menumine.testutil.AbstractNonInitializingMenuMineTestCase;
import com.opensymphony.xwork.Action;

public class LoadQueryActionTest extends
        AbstractNonInitializingMenuMineTestCase {

    SavedQuery savedQuery;
    
    protected void setUp() throws Exception {
        super.setUp();
        savedQuery = SavedQueryTestFactory.getBasicUnpersisted();
        SavedQueryServiceDelegate.factory.build().saveNew(savedQuery);
        initializeMailSendingSystem();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        SavedQueryServiceDelegate.factory.build().delete(savedQuery);
        
    }

    public void testBasic() throws Exception {
        
        MenuMineSessionContextWrapper sessionContextWrapper = MenuMineSessionContextFactory.getMockWrapperWithChicken(SAMPLE_USERNAME);
        
        LoadQueryAction action = (LoadQueryAction) SpringBeanBroker.getBeanFactory().getBean(LoadQueryAction.SPRING_BEAN_NAME);
        
        action.setMenuMineSessionContextWrapper(sessionContextWrapper);
        
        assertNotNull(action.getSavedQueryManager());
        
        String s = action.execute();
        
        assertEquals(Action.SUCCESS,s);
    }

    /*
     * should switch from chicken to bacon.
     */
    public void testLoad() throws Exception {
        
        MenuMineSessionContextWrapper sessionContextWrapper = MenuMineSessionContextFactory.getMockWrapperWithChicken(SAMPLE_USERNAME);
        
        LoadQueryAction action = (LoadQueryAction) SpringBeanBroker.getBeanFactory().getBean(LoadQueryAction.SPRING_BEAN_NAME);
        
        action.setMenuMineSessionContextWrapper(sessionContextWrapper);
        
        assertNotNull(action.getSavedQueryManager());
        
        action.setSelectHistory(savedQuery.getName());
        
        String s = action.execute();
        
        assertEquals(Action.SUCCESS,s);
        
        assertTrue(sessionContextWrapper.getLastFilterWrapper().getItemDescription().getAndValues().contains("bacon"));
    }    
    
    public void testLoadFailsSinceMMFPAreGone() throws Exception {

        GenericDAO dao = GenericDAOFactory.factory.buildAdmin();
        MasterFoodFilterParametersImpl mf = (MasterFoodFilterParametersImpl) dao.get(MasterFoodFilterParametersImpl.class, savedQuery.getMasterFoodFilterParameters().getId());
        dao.delete(mf);
        
        MenuMineSessionContextWrapper sessionContextWrapper = MenuMineSessionContextFactory.getMockWrapperWithChicken(SAMPLE_USERNAME);
        
        LoadQueryAction action = (LoadQueryAction) SpringBeanBroker.getBeanFactory().getBean(LoadQueryAction.SPRING_BEAN_NAME);
        
        action.setMenuMineSessionContextWrapper(sessionContextWrapper);
        
        assertNotNull(action.getSavedQueryManager());
        
        action.setSelectHistory(savedQuery.getName());
        
        String s = action.execute();
        
        assertEquals(Action.SUCCESS,s);
        
        assertTrue(sessionContextWrapper.getErrorContext().hasErrors());

        
        
    }
    
    
}
