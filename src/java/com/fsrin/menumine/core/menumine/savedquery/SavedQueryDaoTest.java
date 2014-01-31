/*
 * Created on Feb 21, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.savedquery;

import com.fsrin.menumine.core.menumine.FieldsToDisplayBean;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParametersImpl;
import com.fsrin.menumine.testutil.AbstractNonInitializingMenuMineTestCase;

/**
 * @author Nick
 * 
 *  
 */
public class SavedQueryDaoTest extends AbstractNonInitializingMenuMineTestCase {

    public void testFilterDAO() throws Exception {

        SavedQuery savedQuery = new SavedQuery();

        MasterFoodFilterParametersImpl params = new MasterFoodFilterParametersImpl();

        params.getBasicProtein().getAndValues().add("one");
        params.getBasicProtein().getAndValues().add("two");

        params.getHqState().getAndValues().add("hq1");
        params.getHqState().getAndValues().add("hq2");

        savedQuery.setMasterFoodFilterParameters(params);
        savedQuery.setGroupName("my Group");
        savedQuery.setName("my name");
        savedQuery.setPermission(1);
        savedQuery.setUserName("my UserName");

        FieldsToDisplayBean bean = new FieldsToDisplayBean();

        bean.setBasicProtein(Boolean.TRUE);
        bean.setBreadBakeGoodsMM(Boolean.TRUE);

        savedQuery.setFieldsToDisplayBean(bean);

        savedQuery = SavedQueryDao.factory.build().saveNew(savedQuery);
        //  params = MasterFoodFilterParametersDao.factory.build().save(params);

        Long id = savedQuery.getId();
        assertNotNull(id);

        SavedQuery savedQueryReload = SavedQueryDao.factory.build().get(id);

        assertNotNull(savedQueryReload);

        MasterFoodFilterParameters paramsReload = savedQueryReload
                .getMasterFoodFilterParameters();

        assertNotNull(paramsReload);

        assertEquals(2, paramsReload.getBasicProtein().getAndValues().size());
        assertEquals(2, paramsReload.getHqState().getAndValues()
                .size());

        FieldsToDisplayBean beanReload = savedQuery.getFieldsToDisplayBean();

        assertNotNull(beanReload);
        assertTrue(beanReload.isBasicProtein().booleanValue());
        assertTrue(beanReload.isBreadBakeGoodsMM().booleanValue());
        
        SavedQueryDao.factory.build().delete(savedQuery);
    }

//    protected void setUp() throws Exception {
//        super.setUp();
//        JunitSettings.initilizeTestSystem();
//
//    }
}