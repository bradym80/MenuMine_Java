/*
 * Created on Feb 16, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.webwork.test;

import junit.framework.TestCase;

import com.fsrin.menumine.core.menumine.webwork.MasterFoodFilterParametersWrapper;
import com.fsrin.menumine.core.menumine.webwork.MasterFoodFilterParametersWrapperImpl;

/**
 * @author Nick
 * 
 *  
 */
public class MasterFoodFilterParametersWrapperTest extends TestCase {

    /*
     * Test to make sure the filter wrapper works.
     */
    public void testFilterWrapper() {
        MasterFoodFilterParametersWrapper wrapper = new MasterFoodFilterParametersWrapperImpl();

        String testString = "This, Is, A, Test";
        wrapper.getBasicProtein().setAndValues(testString);
        assertEquals(4, wrapper.getMasterFoodFilterParameters()
                .getBasicProtein().getAndValues().size());
    }

}