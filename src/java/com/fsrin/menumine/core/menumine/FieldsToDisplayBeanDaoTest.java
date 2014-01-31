/*
 * Created on Feb 21, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine;

import com.fsrin.menumine.testutil.AbstractNonInitializingMenuMineTestCase;

/**
 * @author Nick
 * 
 *  
 */
public class FieldsToDisplayBeanDaoTest extends AbstractNonInitializingMenuMineTestCase {

    public void testFilterDAO() throws Exception {

        FieldsToDisplayBean bean = new FieldsToDisplayBean();

        bean.setBasicProtein(Boolean.TRUE);
        bean.setBreadBakeGoodsMM(Boolean.TRUE);

        FieldsToDisplayBeanDao.factory.build().save(bean);

        Long id = bean.getId();

        FieldsToDisplayBean beanReload = FieldsToDisplayBeanDao.factory.build()
                .get(id);

        assertNotNull(beanReload);
        assertTrue(beanReload.isBasicProtein().booleanValue());
        assertTrue(beanReload.isBreadBakeGoodsMM().booleanValue());

        FieldsToDisplayBeanDao.factory.build().delete(beanReload);
    }

//    protected void setUp() throws Exception {
//        super.setUp();
//        JunitSettings.initilizeTestSystem();
//
//    }
}