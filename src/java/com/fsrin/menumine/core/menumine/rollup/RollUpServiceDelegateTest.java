/*
 * Created on Feb 6, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.rollup;

import java.util.Collection;
import java.util.Iterator;

import com.fsrin.menumine.testutil.AbstractNonInitializingMenuMineTestCase;
import com.fsrin.menumine.testutil.TimerUtil;

public class RollUpServiceDelegateTest extends AbstractNonInitializingMenuMineTestCase {

    public void testBasic_StandardGet() throws Exception {
        
        /*
         * setup
         */
        RollUpServiceDelegate rusd = RollUpServiceDelegate.factory.build();
        RollUpOptions option = new RollUpOptions();
        option.setName("Test Roll Up");
        option.setPermission(1);
        option.setUserName("mbrady");

        RollUpElement rollelement = new RollUpElement();
        rollelement.setLabel("Beef nick");
        rollelement.setTerm("Beef");

        option.getRollUpElements().add(rollelement);

        rusd.save(option);
        
        RollUpServiceDelegate sd = RollUpServiceDelegate.factory.build();
        
        TimerUtil u = TimerUtil.getInstanceAndStart("rollups");
        
        Collection c = sd.getByUser("mbrady");
        
        u.stop();
        
        assertNotNull(c);
        
        log.info("size is " + c.size());
        
        assertTrue(c.size() > 0);
        
        for (Iterator iter = c.iterator(); iter.hasNext();) {
            RollUpOptions element = (RollUpOptions) iter.next();
            assertNotNull(element.getRollUpElements());
        }
        
        Collection c2 =sd.getSimpleByUser("mbrady");
        
        assertEquals(c.size(), c2.size());
        
        
        rusd.delete(option);
    }
    
}
