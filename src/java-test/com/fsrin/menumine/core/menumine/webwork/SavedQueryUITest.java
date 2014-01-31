/*
 * Created on Apr 29, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.webwork;

import java.util.Collection;
import java.util.Iterator;

import junit.framework.TestCase;
import ognl.Ognl;
import ognl.OgnlException;

import com.fsrin.menumine.common.webwork.AuthenticatedUserMockImpl;
import com.fsrin.menumine.context.webwork.MenuMineSessionContextWrapper;
import com.fsrin.menumine.core.dessertmine.xwork.test.SavedQueryManagerMockImpl;
import com.fsrin.menumine.core.menumine.SavedQuery;
// MJB 01-30-14 Removed.
//import com.fsrin.menumine.core.menumine.webwork.legacy.MenuMineAction;
import com.fsrin.menumine.testutil.JunitSettings;
import com.fstx.stdlib2.authen.webwork.UserGroupServiceDelegateMockImpl;
import com.opensymphony.xwork.ActionSupport;

/**
 * @author Nick This hits the general mine action to test how it manages the
 *         querys. We check if to includes them in the history. Then we test
 *         that when we attempt to save, it does.
 * 
 * Note: The saved Query Manager an Service Delegate are not linked since we are
 * running out of container, with out a database.
 *  
 */
public class SavedQueryUITest extends TestCase {

    public SavedQueryUITest() {
        super();

    }

    protected void setUp() throws Exception {
        super.setUp();
        JunitSettings.initilizeTestSystem();

    }

    public void testQueryManagement() throws Exception {

        MenuMineSessionContextWrapper wrapper = new MenuMineSessionContextWrapper();
        wrapper.setAuthenticatedUser(new AuthenticatedUserMockImpl());

        /*
         * SavedQueryManagerMockImpl2 contains a query that is for dessert mine,
         * it should be excluded form the history results found later.
         */
        SavedQueryManagerMockImpl2 savedQueryManager = new SavedQueryManagerMockImpl2();

        MenuMineAction useMenuMine = new MenuMineAction();
        useMenuMine.setMenuMineSessionContextWrapper(wrapper);
        useMenuMine.execute();

        GeneralMineAction generalMineAction1 = new GeneralMineAction();
        generalMineAction1.setMenuMineSessionContextWrapper(wrapper);

        assertEquals(ActionSupport.SUCCESS, generalMineAction1.execute());

        GeneralMineAction generalMineAction2 = new GeneralMineAction();
        generalMineAction2.setMenuMineSessionContextWrapper(wrapper);
        generalMineAction2.getMasterFoodFilterParameters().getBasicProtein()
                .setNotEmpty(true);
        generalMineAction2.setSubmit("Submit Query");

        assertEquals(ActionSupport.SUCCESS, generalMineAction2.execute());

        GeneralMineAction generalMineAction3 = new GeneralMineAction();
        generalMineAction3.setMenuMineSessionContextWrapper(wrapper);

        /*
         * Make use the last query appeard in the history.
         *  
         */
        Collection history = generalMineAction3.getHistory();
        assertEquals(4, history.size());
        assertContains("-----Session Saves-----", history, "name");
        assertContains("-----Permanent Saves-----", history, "name");
        assertContains("Query History 4", history, "name");
        assertContains("----INITIALIZING SAVES----", history, "name");
        generalMineAction3.setSubmit("Submit Query");
        assertEquals(ActionSupport.SUCCESS, generalMineAction3.execute());

        GeneralMineAction generalMineAction = new GeneralMineAction();
        generalMineAction.setMenuMineSessionContextWrapper(wrapper);
        generalMineAction.setSavedQueryManager(savedQueryManager);
        generalMineAction
                .setUserGroupServiceDelegate(new UserGroupServiceDelegateMockImpl());

        generalMineAction
                .setSavedQueryServiceDelegate(new SavedQueryServiceDelegateMockImpl());
        generalMineAction.getMasterFoodFilterParameters().getBasicProtein()
                .setAndValues("Beef");

        generalMineAction.setSpreadsheetName("Test Name");
        generalMineAction.setSubmit("Save");
        assertEquals(ActionSupport.SUCCESS, generalMineAction.execute());

        Collection history2 = generalMineAction.getHistory();
        assertEquals(5, history2.size());
        assertContains("-----Session Saves-----", history2, "name");
        assertContains("-----Permanent Saves-----", history2, "name");
        assertContains("Query History 4", history2, "name");
        assertContains("Query History 5", history2, "name");
        assertContains(SavedQueryManagerMockImpl.SAMPLE_MOCK_QUERY_1, history2,
                "name");

        /*
         * Since we submited with Save we should have called save on the Mock
         * Service Delegetem, thus, it end up in the saved collection.
         */
        assertEquals(1, ((SavedQueryServiceDelegateMockImpl) generalMineAction
                .getSavedQueryServiceDelegate()).saved.size());

        SavedQuery s1 = (SavedQuery) ((SavedQueryServiceDelegateMockImpl) generalMineAction
                .getSavedQueryServiceDelegate()).saved.toArray()[0];

        assertEquals("Test Name", s1.getName());

    }

    private void assertContains(String string, Collection values, String ognl) {
        boolean contains = false;
        for (Iterator iter = values.iterator(); iter.hasNext();) {
            Object element = (Object) iter.next();

            String value = "";
            try {
                value = (String) Ognl.getValue(ognl, element);
            } catch (OgnlException e) {

                e.printStackTrace();
            }
            contains = value.equals(string) || contains;

        }

        assertTrue(string + "Not found in collection : " + values, contains);
    }

}