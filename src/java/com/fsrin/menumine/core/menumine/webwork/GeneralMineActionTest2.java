/*
 * Created on Mar 8, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.webwork;

import java.util.Collection;
import java.util.Iterator;

import com.fsrin.menumine.common.SpringBeanBroker;
import com.fsrin.menumine.context.MenuMineSessionContextFactory;
import com.fsrin.menumine.context.webwork.MenuMineSessionContextWrapper;
import com.fsrin.menumine.core.menumine.savedquery.SavedQuery;
import com.fsrin.menumine.core.menumine.savedquery.SavedQueryServiceDelegate;
import com.fsrin.menumine.core.menumine.savedquery.SavedQueryTestFactory;
import com.fsrin.menumine.testutil.AbstractNonInitializingMenuMineTestCase;
import com.opensymphony.xwork.Action;

public class GeneralMineActionTest2 extends
        AbstractNonInitializingMenuMineTestCase {

    SavedQuery savedQuery;

    protected void setUp() throws Exception {

        super.setUp();

        savedQuery = SavedQueryTestFactory.getBasicUnpersisted();

        SavedQueryServiceDelegate.factory.build().saveNew(savedQuery);

    }

    protected void tearDown() throws Exception {

        super.tearDown();

        SavedQueryServiceDelegate.factory.build().delete(savedQuery);
    }

    /*
     * 2006-03-08 rsc need to reproduce error when updating a saved query that
     * has been loaded during a session.
     */
    public void testSavedQuery() throws Exception {

        /*
         * common prep.
         */
        MenuMineSessionContextWrapper sc = MenuMineSessionContextFactory
                .getMockWrapperWithBacon("mbrady");

        GeneralMineAction action = (GeneralMineAction) SpringBeanBroker
                .getBeanFactory().getBean(GeneralMineAction.SPRING_BEAN_NAME);

        action.setMenuMineSessionContextWrapper(sc);
        
        action.setSubmit("search");
        
        String r1 = action.execute();
        
        assertEquals(Action.SUCCESS,r1);
        
        /*
         * recall the saved query.
         */
        action.setSubmit(null);
        
        action.setSelectHistory(savedQuery.getName());
        
        String r2 = action.execute();
        
        assertEquals(Action.SUCCESS,r2);
        
        /*
         * attempt to save it.  
         * 2006-03-08 RSC this reproduces a bug in updating saved queries.
         */
        action.setSubmit("Save");
        
        action.setSpreadsheetName(savedQuery.getName());
        
        String r3 = action.execute();
        
        assertEquals(Action.SUCCESS,r3);
        
        /*
         * OK so the error works but our reference to the savedquery we're using for testing
         * purposes needs to be updated since the SD would have deleted the original.
         */
        GeneralMineAction action2 = (GeneralMineAction) SpringBeanBroker.getBeanFactory().getBean(GeneralMineAction.SPRING_BEAN_NAME);
        action2.setMenuMineSessionContextWrapper(sc);
        
        Collection h = action2.getHistory();
        
        assertNotNull(h);
        assertTrue(h.size() > 0);
        
        boolean found = false;
        for (Iterator iter = h.iterator(); iter.hasNext();) {
            SavedQuery element = (SavedQuery) iter.next();
            if (element.getName().equals(savedQuery.getName())) {
                savedQuery = element;
                found = true;
                break;
            }
        }
        
        assertTrue(found);
    }
}
