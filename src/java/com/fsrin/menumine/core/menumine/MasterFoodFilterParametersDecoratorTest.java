/*
 * Created on Mar 17, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine;

import com.fsrin.menumine.testutil.AbstractNonInitializingMenuMineTestCase;

public class MasterFoodFilterParametersDecoratorTest extends
        AbstractNonInitializingMenuMineTestCase {

    public void testSynchronize() throws Exception {

        MasterFoodFilterParameters p = MasterFoodFilterParametersTestFactory
                .getItemDescriptionWithBacon();
        
        assertTrue(p.getItemDescription().isSelect());
        assertTrue(p.getGenMenuPart().isSelect());
        
        /*
         * totally empty, should get rid of those guys.
         */
        FieldsToDisplayBean f = new FieldsToDisplayBean();
        
        new MasterFoodFilterParametersDecorator().decorateSelect(p,f);
        
        assertFalse(p.getItemDescription().isSelect());
        assertFalse(p.getGenMenuPart().isSelect());
        
        f.setBasicProtein(Boolean.TRUE);
        f.setItemDescription(Boolean.TRUE);
        f.setGenMenuPart(Boolean.TRUE);
        
        new MasterFoodFilterParametersDecorator().decorateSelect(p,f);
        
        assertTrue(p.getBasicProtein().isSelect());
        assertTrue(p.getItemDescription().isSelect());
        assertTrue(p.getGenMenuPart().isSelect());

    }
}
