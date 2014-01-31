/*
 * Created 2005.2.1
 */

package com.fsrin.menumine.core.menumine.masterfood;

import java.util.Collection;

import junit.framework.TestCase;

import com.fsrin.menumine.core.menumine.LastQuerySummaryElement;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParametersImpl;
import com.fsrin.menumine.core.minefields.MenuMineFields;

/**
 * @author Nick
 *  
 */
public class MasterFoodQuerySummaryTest extends TestCase {

    public MasterFoodQuerySummaryTest(String arg0) {
        super(arg0);
    }

    public void testQuerySummary() {

        MasterFoodFilterParameters masterFoodFilterParameters = new MasterFoodFilterParametersImpl();
        masterFoodFilterParameters.getBasicProtein().getInValues().add("Beef");
        masterFoodFilterParameters.getBasicProtein().getAndValues().add("Be");

        Collection collection = masterFoodFilterParameters
                .getSummary(new MenuMineFields());
        assertEquals(1, collection.size());

        LastQuerySummaryElement ele = (LastQuerySummaryElement) collection
                .toArray()[0];

        assertEquals(1, ele.getTypeIn().size());
        assertEquals("Be", ele.getTypeIn().toArray()[0]);

        assertEquals(1, ele.getSelection().size());
        assertEquals("Beef", ele.getSelection().toArray()[0]);
    }

    protected void setUp() throws Exception {
        super.setUp();
//        JunitSettings.initilizeTestSystem();

    }

}