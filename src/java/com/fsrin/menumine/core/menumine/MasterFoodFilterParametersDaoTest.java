/*
 * Created on Feb 21, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine;

import junit.framework.TestCase;

/**
 * @author Nick
 * 
 *  
 */
public class MasterFoodFilterParametersDaoTest extends TestCase {

    public void testFilterDAO() throws Exception {
        MasterFoodFilterParameters params = new MasterFoodFilterParametersImpl();

        params.getBasicProtein().getAndValues().add("one");
        params.getBasicProtein().getAndValues().add("two");

        params.getHqState().getAndValues().add("hq1");
        params.getHqState().getAndValues().add("hq2");

        params = MasterFoodFilterParametersDao.factory.build().save(params);

        Long id = params.getId();
        assertNotNull(id);

        MasterFoodFilterParameters paramsReload = MasterFoodFilterParametersDao.factory
                .build().get(id);

        assertNotNull(paramsReload);

        assertEquals(2, paramsReload.getBasicProtein().getAndValues().size());
        assertEquals(2, paramsReload.getHqState().getAndValues()
                .size());
    }

    protected void setUp() throws Exception {
        super.setUp();
//        JunitSettings.initilizeTestSystem();

    }
}