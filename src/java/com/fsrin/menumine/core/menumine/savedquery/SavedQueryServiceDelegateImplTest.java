/*
 * Created on Feb 6, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.savedquery;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import com.fsrin.menumine.common.dao.GenericDAOFactory;
import com.fsrin.menumine.core.menumine.FieldsToDisplayBean;
import com.fsrin.menumine.core.menumine.FieldsToDisplayBeanBuilder;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParametersImpl;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParametersTestFactory;
import com.fsrin.menumine.core.menumine.util.MasterFoodFilterParametersComparator;
import com.fsrin.menumine.testutil.AbstractNonInitializingMenuMineTestCase;
import com.fsrin.menumine.testutil.TimerUtil;

public class SavedQueryServiceDelegateImplTest extends
        AbstractNonInitializingMenuMineTestCase {

    public void testBasic() throws Exception {
        
        SavedQueryServiceDelegate sd = SavedQueryServiceDelegate.factory.build();
        
        TimerUtil timer = TimerUtil.getInstanceAndStart("saved queries");
        
        Collection q = sd.getByUser("mbrady");
        
        timer.stop();
        
        assertTrue(q != null);
        
    }
    
    public void testBasicWithSimple() throws Exception {
        
        SavedQueryServiceDelegate sd = SavedQueryServiceDelegate.factory.build();
        
        TimerUtil timer = TimerUtil.getInstanceAndStart("saved queries");
        
        Collection q = sd.getSimpleByUser("mbrady");
        
        timer.stop();
        
        assertTrue(q != null);
        
    }
    
    public void testGetSimpleById() throws Exception {
        
        
        SavedQueryServiceDelegate sd = SavedQueryServiceDelegate.factory.build();
        
        SavedQuery sq = SavedQueryTestFactory.getBasicUnpersisted();
        sd.saveNew(sq);
        
        long id = sq.getId().longValue();
        sq = null;
        
        TimerUtil timer = TimerUtil.getInstanceAndStart("saved queries");
        
        SavedQuery q2 = sd.getSimpleById(id);
        
        
        
        timer.stop();
        
        assertNotNull(q2);
        
        assertTrue(q2.isSimple());
        
        SavedQuery q3 = sd.getById(id);
        
        assertFalse(q3.isSimple());
        
        sd.delete(q3);
        
    }    
    
    public void testBasicWithSimpleCompare() throws Exception {
        
        SavedQueryServiceDelegate sd = SavedQueryServiceDelegate.factory.build();
        
        TimerUtil timer = TimerUtil.getInstanceAndStart("saved queries");
        
        Collection q = sd.getSimpleByUser("mbrady");
        
        Collection q2 = sd.getByUser("mbrady");
        
        timer.stop();
        
        assertTrue(q != null  && q2 != null);
        
        assertEquals(q.size() , q2.size());
        
    }
    
    public void testSaveAndThenResaveWithAddionalFilterParameter() throws Exception {
        
        MasterFoodFilterParameters p = MasterFoodFilterParametersTestFactory.getItemDescriptionWithBacon();
        
        SavedQueryServiceDelegate sd = SavedQueryServiceDelegate.factory.build();
        
        SavedQuery s = SavedQueryTestFactory.getBasicUnpersisted(p);
        
        sd.saveNew(s);
        

        p.getBasicProtein().setSelect(true);
        
        p.getBasicProtein().getAndValues().add("pork");
        
        p.getBasicProtein().setId(null);
        
        sd.update(s);
        
        assertNotNull(s.getId());
        assertNotNull(s.getFieldsToDisplayBean().getId());
        assertNotNull(s.getMasterFoodFilterParameters().getId());
        
        /*
         * housekeeping
         */
        sd.delete(s);
        
    }
    
    /*
     * cleans out saved queries for the sample user.
     */
    public void testDeleteByUser() throws Exception {
        SavedQueryServiceDelegate sd = SavedQueryServiceDelegate.factory.build();
        
        Collection c = sd.getByUser(SAMPLE_USERNAME);
        
        for (Iterator iter = c.iterator(); iter.hasNext();) {
            SavedQuery element = (SavedQuery) iter.next();
            sd.delete(element);
        }
    }
    
    public void testFilterParameterEquality() throws Exception {
        
        MasterFoodFilterParameters p = MasterFoodFilterParametersTestFactory.getItemDescriptionWithBacon();
        
        FieldsToDisplayBean f = new FieldsToDisplayBeanBuilder().build(p);
        
        SavedQuery sq = new SavedQuery();
        
        sq.setName("test" + new Date().getTime());
        sq.setUserName(SAMPLE_USERNAME);
        sq.setGroupName(SAMPLE_GROUPNAME);
        sq.setFieldsToDisplayBean(f);
        sq.setMasterFoodFilterParameters(p);
        sq.setMineType("mine.mine");
        sq.setPermission(SavedQuery.GROUP_QUERY_PERMISSION);
        
        SavedQueryServiceDelegate.factory.build().saveNew(sq);
        
        long l = sq.getId().longValue();
        
        f = null;
        sq = null;
        
        SavedQuery reload = SavedQueryServiceDelegate.factory.build().getById(new Long(l));
        reload.synchSelectedFields();
        
        new MasterFoodFilterParametersComparator().testForEquality(p, reload.getMasterFoodFilterParameters());
        
        
    }
 
    /**
     * 2006-03-21 RSC since we're using simple queries on the query manager,
     * we need to be able to load and save them appropriately.
     * 
     * @throws Exception
     */
    public void testCascadeDeleteFromSimpleSavedQuery() throws Exception {
        
        SavedQueryServiceDelegate sd = SavedQueryServiceDelegate.factory.build();
        
        SavedQuery q1 = SavedQueryTestFactory.getBasicUnpersisted();
        sd.saveNew(q1);
        
        assertNotNull(q1.getId());
        assertNotNull(q1.getMasterFoodFilterParameters().getId());
        assertNotNull(q1.getFieldsToDisplayBean().getId());
        
        long queryId = q1.getId().longValue();
        long mffpId = q1.getMasterFoodFilterParameters().getId();
        long fieldsId = q1.getFieldsToDisplayBean().getId();
        
        q1 = null;
        
        System.gc();
        SavedQuery simple1 = sd.getSimpleById(queryId);
        sd.delete(simple1);
        
        MasterFoodFilterParameters p = (MasterFoodFilterParameters) GenericDAOFactory.factory.buildAdmin().get(MasterFoodFilterParametersImpl.class,mffpId);
        assertNull(p);
        
        FieldsToDisplayBean f = (FieldsToDisplayBean) GenericDAOFactory.factory.buildAdmin().get(FieldsToDisplayBean.class,fieldsId);
        assertNull(f);

    }
    
    /**
     * 2006-03-21 RSC One error condition is that we occassionally get
     * a missing MFFP (shouldn't anymore) and the load fails.  But we need
     * to be able to delete the parent saved query without throwing an 
     * exception.
     * 
     * @throws Exception
     */
    public void testCascadeDeleteFromSimpleSavedQueryMissingMasterfoodFilterParameters() throws Exception {
        
        this.initializeMailSendingSystem();
        
        SavedQueryServiceDelegate sd = SavedQueryServiceDelegate.factory.build();
        
        SavedQuery q1 = SavedQueryTestFactory.getBasicUnpersisted();
        sd.saveNew(q1);
        
        assertNotNull(q1.getId());
        assertNotNull(q1.getMasterFoodFilterParameters().getId());
        assertNotNull(q1.getFieldsToDisplayBean().getId());
        
        long queryId = q1.getId().longValue();
        long mffpId = q1.getMasterFoodFilterParameters().getId();
        long fieldsId = q1.getFieldsToDisplayBean().getId();
        
        q1 = null;

        MasterFoodFilterParametersImpl p = (MasterFoodFilterParametersImpl) GenericDAOFactory.factory.buildAdmin().get(MasterFoodFilterParametersImpl.class,mffpId);
        GenericDAOFactory.factory.buildAdmin().delete(p);
        
        System.gc();
        SavedQuery simple1 = sd.getSimpleById(queryId);
        sd.delete(simple1);
        
        /*
         * 2006-03-21 RSC Still want to be sure this gets deleted.
         * But it will not without some serious work.  Added some notifications
         * into the system so we can see if it happens.
         */
//        FieldsToDisplayBean f = (FieldsToDisplayBean) GenericDAOFactory.factory.buildAdmin().get(FieldsToDisplayBean.class,fieldsId);
//        assertNull(f);

    }
}
