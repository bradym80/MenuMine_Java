/*
 * Created on Jun 15, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.webwork.test;

import java.util.Collection;

import org.jmock.MockObjectTestCase;

import com.fsrin.menumine.common.FilterParameter;
import com.fsrin.menumine.core.menumine.webwork.FilterParameterWrapper;

/**
 * @author Nick
 * 
 *  
 */
public class FilterParameterWrapperTest extends MockObjectTestCase {

    public void testParsingStringsWithCommas() {

        FilterParameterWrapper wrapper = new FilterParameterWrapper(
                new FilterParameter());

        String test = "'A', B, 'C\\, D', Wendy's, \\,, 'Chicken\\, Pasta\\, Olives', Burgers\\, Hot Dog's, \\,";
        // String testPostProcess = "'A', B, 'C\\, D', Wendy's, \\, ,'Chicken\\,
        // Pasta\\, Olives', Burgers\\, Hot Dog's";

        wrapper.setNotValues(test);
        Collection not = wrapper.getFilterParameter().getNotValues();

        assertEquals(8, not.size());

        Object[] array = not.toArray();

        assertEquals("'A'", array[0]);
        assertEquals("B", array[1]);
        assertEquals("'C, D'", array[2]);
        assertEquals("Wendy's", array[3]);
        assertEquals(",", array[4]);
        assertEquals("'Chicken, Pasta, Olives'", array[5]);
        assertEquals("Burgers, Hot Dog's", array[6]);
        assertEquals(",", array[7]);

        String testReLoad = wrapper.getNotValues();
        assertEquals(test, testReLoad);

    }

}