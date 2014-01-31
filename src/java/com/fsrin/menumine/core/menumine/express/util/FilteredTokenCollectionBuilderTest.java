/*
 * Created on Jan 24, 2006
 *
 */
package com.fsrin.menumine.core.menumine.express.util;

import java.util.ArrayList;
import java.util.Collection;

import junit.framework.TestCase;

public class FilteredTokenCollectionBuilderTest extends TestCase {

    public void testBasic() throws Exception {
        
        Collection c = new ArrayList();
        
        c.add("one");
        c.add("a"); // should be filtered out.
        c.add("four");
        
        Collection r = new FilteredTokenCollectionBuilder().getFilteredTokens(c);
        
        assertTrue(r.size() == 2);
    }
}
