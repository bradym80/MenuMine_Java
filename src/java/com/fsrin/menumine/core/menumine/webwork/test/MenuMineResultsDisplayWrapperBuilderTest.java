/*
 * Created on Jan 19, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.webwork.test;

import java.util.ArrayList;
import java.util.Collection;

import junit.framework.TestCase;

import com.fsrin.menumine.core.menumine.FieldsToDisplayBean;
import com.fsrin.menumine.core.menumine.masterfood.MasterFood;
import com.fsrin.menumine.core.menumine.webwork.util.MenuMineResultsDisplayWrapper;
import com.fsrin.menumine.core.menumine.webwork.util.MenuMineResultsDisplayWrapperBuilder;
import com.fsrin.menumine.core.minefields.MenuMineFields;

/**
 * @author Nick
 * 
 *  
 */
public class MenuMineResultsDisplayWrapperBuilderTest extends TestCase {

    public void testWrapperBuilder() {
        MasterFood testFood = new MasterFood();
//        Chain testChain = new Chain();
//        testFood.setChain(testChain);

        testFood.setBasicProtein("Beef");
        testFood.setCuisine("Asian");
        testFood.setPrice1998(new Double(1.09));
        testFood.setOperationName("Fivesticks");

        FieldsToDisplayBean fieldsToDisplayBean = new FieldsToDisplayBean();
        fieldsToDisplayBean.setBasicProtein(Boolean.TRUE);
        fieldsToDisplayBean.setCuisine(Boolean.TRUE);
        fieldsToDisplayBean.setPrice1998(Boolean.TRUE);
        fieldsToDisplayBean.setOperationName(Boolean.TRUE);
        fieldsToDisplayBean.setCarboVegFruit(Boolean.TRUE);

        Collection results = new ArrayList();
        results.add(testFood);

        Collection wrappers = MenuMineResultsDisplayWrapperBuilder.singleton
                .buildCollection(results, fieldsToDisplayBean,
                        new MenuMineFields());

        assertEquals(1, wrappers.size());
        MenuMineResultsDisplayWrapper wrapper = (MenuMineResultsDisplayWrapper) wrappers
                .toArray()[0];
        assertTrue(((String) wrapper.getValue2()).indexOf("Beef") > -1);
        assertEquals("$1.09", wrapper.getValue4());
        assertTrue(((String) wrapper.getValue3()).indexOf("Fivesticks") > -1);
        assertTrue(((String) wrapper.getValue1()).indexOf("Asian") > -1);

        assertEquals("", wrapper.getValue5());

        assertEquals("", wrapper.getValue6());
        assertEquals("", wrapper.getValue7());

    }
}