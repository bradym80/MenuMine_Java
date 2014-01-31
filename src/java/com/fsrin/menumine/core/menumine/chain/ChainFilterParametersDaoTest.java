/*
 * Created on Feb 21, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.chain;

import junit.framework.TestCase;

/**
 * @author Nick
 * 
 *  
 */
public class ChainFilterParametersDaoTest extends TestCase {

    public void testFilterDAO() throws Exception {
        ChainFilterParameters params = new ChainFilterParameters();

        params.getHqState().getAndValues().add("one");
        params.getHqState().getAndValues().add("two");

        //        for (Iterator iter = params.getAll().iterator(); iter.hasNext();) {
        //            FilterParameter element = (FilterParameter) iter.next();
        //            FilterParameterDao.factory.build().save(element);
        //        }
        //
        //        for (Iterator iter = params.getAll().iterator(); iter.hasNext();) {
        //            FilterParameter element = (FilterParameter) iter.next();

        //        }

        params = ChainFilterParametersDao.factory.build().save(params);

        Long id = params.getId();
        assertNotNull(id);

        ChainFilterParameters paramsReload = ChainFilterParametersDao.factory
                .build().get(id);

        assertNotNull(paramsReload);

        assertEquals(2, paramsReload.getHqState().getAndValues().size());
    }

    protected void setUp() throws Exception {
        super.setUp();
//        JunitSettings.initilizeTestSystem();

    }
}