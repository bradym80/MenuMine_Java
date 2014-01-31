/*
 * Created on Feb 9, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.savedquery.xwork;

import com.fsrin.menumine.context.MenuMineSessionContextFactory;
import com.fsrin.menumine.core.menumine.FieldsToDisplayBeanBuilder;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParametersTestFactory;
import com.fsrin.menumine.core.menumine.savedquery.SavedQuery;
import com.fsrin.menumine.core.menumine.savedquery.SavedQueryServiceDelegate;
import com.fsrin.menumine.core.menumine.savedquery.SavedQueryTestFactory;
import com.fsrin.menumine.testutil.AbstractNonInitializingMenuMineTestCase;
import com.opensymphony.xwork.Action;

public class SavedQueryModifyActionTest extends
        AbstractNonInitializingMenuMineTestCase {

    private SavedQuery sample;
    private int count;
    
    protected void setUp() throws Exception {
        
        super.setUp();
        
        count++;
        
        sample = new SavedQuery();
        sample.setName("name"+count);
        sample.setGroupName("groupName");
        sample.setPermission(1);
        sample.setUserName("mbrady");
        
        sample.setMasterFoodFilterParameters(MasterFoodFilterParametersTestFactory.getItemDescriptionWithBacon());
        sample.setFieldsToDisplayBean(new FieldsToDisplayBeanBuilder().build(sample.getMasterFoodFilterParameters()));
        
        SavedQueryServiceDelegate.factory.build().saveNew(sample);
    }

    protected void tearDown() throws Exception {
        
        super.tearDown();
        
        try {
            SavedQueryServiceDelegate.factory.build().delete(sample);
        } catch (Exception e) {
            log.info("Failed to delete sample query");
        }
    }
    
    public void testBasic() throws Exception {
        
        SavedQueryModifyAction action = new SavedQueryModifyAction();
        
        action.setMenuMineSessionContextWrapper(MenuMineSessionContextFactory.getMockWrapper("mbrady"));
        
        action.setSavedQueryModifyContext(new SavedQueryModifyContext());
        
        assertEquals(Action.SUCCESS, action.execute());
        
    }
    
    public void testBasicContextConfig() throws Exception {
        
        SavedQueryModifyAction action = new SavedQueryModifyAction();
        
        action.setMenuMineSessionContextWrapper(MenuMineSessionContextFactory.getMockWrapper("mbrady"));
        
        action.setSavedQueryModifyContext(new SavedQueryModifyContext());
        
        action.setSavedQueryServiceDelegate(SavedQueryServiceDelegate.factory.build());
        
        action.setTarget(sample.getId());
        
        assertEquals(Action.INPUT, action.execute());
        
        assertNotNull(action.getSavedQueryModifyContext().getTarget());
        
    }
    
    public void testBasicContextSaves() throws Exception {
        
        SavedQueryModifyAction action = new SavedQueryModifyAction();
        
        action.setMenuMineSessionContextWrapper(MenuMineSessionContextFactory.getMockWrapper("mbrady"));
        
        action.setSavedQueryModifyContext(new SavedQueryModifyContext());
        
        action.getSavedQueryModifyContext().setTarget(sample);
        
        action.setSavedQueryServiceDelegate(SavedQueryServiceDelegate.factory.build());
        
        
        
        action.setSubmitQuery("submit");
        
        action.getTargetQuery().setName("newName");
        
        action.getTargetQuery().setGroupName("newGroupName");
        
        action.getTargetQuery().setPermission(1);
        
        try {
            action.execute();
            assertTrue("shouldn't be here", false);
        } catch (Exception e) {
            
        }
        
//        assertNull(action.getSavedQueryModifyContext().getTarget());
//        
//        SavedQuery s2 = SavedQueryServiceDelegate.factory.build().getById(sample.getId());
//        
//        assertEquals("newName", s2.getName());
        
    }


    public void testBasicContextDeletes() throws Exception {
        
        /*
         * 2006-03-21 RSC am creating one here so teardown doesn't
         * complain.
         */
        SavedQuery q2 = SavedQueryTestFactory.getBasicUnpersisted();
        SavedQueryServiceDelegate.factory.build().saveNew(q2);
        
        SavedQueryModifyAction action = new SavedQueryModifyAction();
        
        action.setMenuMineSessionContextWrapper(MenuMineSessionContextFactory.getMockWrapper("mbrady"));
        
        action.setSavedQueryModifyContext(new SavedQueryModifyContext());
        
        action.getSavedQueryModifyContext().setTarget(q2);
        
        action.setSavedQueryServiceDelegate(SavedQueryServiceDelegate.factory.build());
        
        
        
        action.setDeleteQuery("delete");
        

        assertEquals(Action.SUCCESS, action.execute());
        
        assertNull(action.getSavedQueryModifyContext().getTarget());
        
        SavedQuery s2 = null;
        
        s2 = SavedQueryServiceDelegate.factory.build().getById(q2.getId());
        
        assertNull(s2);
        

        
    }    
    
}
