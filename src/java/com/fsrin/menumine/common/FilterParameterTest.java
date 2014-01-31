/*
 * Created on Mar 16, 2006
 *
 */
package com.fsrin.menumine.common;

import com.fsrin.menumine.core.menumine.FieldEnum;
import com.fsrin.menumine.testutil.AbstractNonInitializingMenuMineTestCase;

public class FilterParameterTest extends
        AbstractNonInitializingMenuMineTestCase {

    public void testBasicClone() throws Exception {
        
        FilterParameter fp = new FilterParameter(FieldEnum.BASIC_PROTEIN);
        
        fp.setSelect(true);
        
        FilterParameter clone = fp.clone();
        
        assertNotSame(fp,clone);
        
        assertSame(fp.getField(), clone.getField());
        
        assertTrue(fp.isSelect());
        
    }
}
