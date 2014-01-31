/*
 * Created on Jan 23, 2006
 *
 */
package com.fsrin.menumine.core.menumine.util;

import java.util.Collection;

import junit.framework.TestCase;

import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParametersImpl;

public class SelectedFieldListBuilderTest extends TestCase {
    /*
     * want to make sure it only returns unique field names even if multiple are
     * selected.
     */
    public void testOgnlFieldList() throws Exception {

        MasterFoodFilterParameters p = new MasterFoodFilterParametersImpl();

        /*
         * four things would normally return in getAll when this is set to true.
         */
        p.getGenMenuPart().setSelect(true);

        Collection ognls = new SelectedFieldListBuilder().getOgnlNameSet(p);

        assertEquals(1, ognls.size());
    }
}
