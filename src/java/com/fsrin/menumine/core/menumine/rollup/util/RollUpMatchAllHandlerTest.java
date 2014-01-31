/*
 * Created on Feb 3, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.rollup.util;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fsrin.menumine.core.menumine.rollup.RollUpOptions;
import com.fsrin.menumine.core.menumine.rollup.RollUpOptionsTestFactory;

public class RollUpMatchAllHandlerTest extends TestCase {

    private Log log = LogFactory.getLog(RollUpMatchAllHandler.class);
    
    
    public void testBasic() throws Exception {
        
        RollUpOptions options = RollUpOptionsTestFactory.buildTestAmericanRollUpOthers();
        
        RollUpMatchAllHandler handler = new RollUpMatchAllHandler(options);
        
        String res = handler.getRollUpKey("American-Traditional Cuisine");
        
        assertNotNull(res);
        

        
        log.info("items " + res);
        
        assertEquals("American", res);
        
        String res2 = handler.getRollUpKey("American-Regional Cuisine");
        

        
        log.info("items " + res2);
        
        assertEquals("American", res2);
        
        String res3 = handler.getRollUpKey("Other Cuisine");
        

        assertEquals("Other Cuisine", res3);
        
        
    }
    
}
