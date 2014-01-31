/*
 * Created on Jan 23, 2006
 *
 */
package com.fsrin.menumine.core.menumine.masterfood.hql;

import junit.framework.TestCase;
import ognl.Ognl;

import com.fsrin.menumine.core.menumine.FieldEnum;
import com.fsrin.menumine.core.menumine.masterfood.MasterFood;

public class MasterFoodBuilderTest extends TestCase {

    /*
     * 2006-01-23 Just an illustration of how this works.
     * 
     */
    public void testBasicOgnlSet() throws Exception {

        MasterFood t = new MasterFood();

        Ognl.setValue(FieldEnum.BASIC_PROTEIN.getOgnlName(), t, "lamma");

        assertTrue(t.getBasicProtein() != null);

        assertEquals("lamma", t.getBasicProtein());

    }


}
