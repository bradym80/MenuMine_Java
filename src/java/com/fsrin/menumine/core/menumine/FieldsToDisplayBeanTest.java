/*
 * Created on Mar 16, 2006
 *
 */
package com.fsrin.menumine.core.menumine;

import com.fsrin.menumine.testutil.AbstractNonInitializingMenuMineTestCase;

public class FieldsToDisplayBeanTest extends
        AbstractNonInitializingMenuMineTestCase {

    public void testBasic() throws Exception {
        
        FieldsToDisplayBean bean = new FieldsToDisplayBean();
        
        bean.setBasicProtein(Boolean.TRUE);
        
        bean.setBevSize(Boolean.TRUE);
        
        FieldsToDisplayBean clone = bean.clone();
        
        assertNotSame(bean,clone);
        
        assertTrue(clone.getBasicProtein());
        
        assertTrue(clone.getBevSize());
        
        assertFalse(clone.getBreadUse());
    }
}
