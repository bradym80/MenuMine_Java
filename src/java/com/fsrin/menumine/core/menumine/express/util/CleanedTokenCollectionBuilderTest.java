/*
 * Created on Jan 24, 2006
 *
 */
package com.fsrin.menumine.core.menumine.express.util;

import java.util.ArrayList;
import java.util.Collection;

import junit.framework.TestCase;

public class CleanedTokenCollectionBuilderTest extends TestCase {

    public void testBasic() throws Exception {
        
        Collection c = new ArrayList();
        c.add("one,");
        
        Collection r = new CleanedTokenCollectionBuilder().clean(c);
        
        assertEquals(1,r.size());
        assertEquals("one",(String)r.toArray()[0]);
        
    }
}
