/*
 * Created on Aug 14, 2006 by Reid
 */
package com.fsrin.menumine.core.flavortrak;

import java.util.Collection;
import java.util.Iterator;

import com.fsrin.menumine.core.flavortrak.xwork.FlavorTrakContext;
import com.fsrin.menumine.testutil.AbstractNonInitializingMenuMineTestCase;

public class FlavorTrakBuilderTest extends
        AbstractNonInitializingMenuMineTestCase {

    public void testBasic() throws Exception {
        
        FlavorTrakBuilder builder = new FlavorTrakBuilder();
        
        FlavorTrakContext flavorTrakContext = new FlavorTrakContext();
        
        flavorTrakContext.setQuery("chicken");
        
        flavorTrakContext.setGenMenuPart("Appetizer");
        
        builder.build(flavorTrakContext);
        
        assertTrue(builder.getRecordCount() > 0);
        /*
         * 2006-08-17 reid@fivesticks.com not returning anything
         */
//        log.info("total key words = " + kw.size());
        
//        for (Iterator iter = kw.iterator(); iter.hasNext();) {
//            String   element = (String) iter.next();
//            
//            log.info(element);
//            
//        }
        
    }
    
}
