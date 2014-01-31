/*
 * Created on Apr 20, 2006 by Reid
 */
package com.fsrin.menumine.core.profiler.flavor;

import java.util.Collection;
import java.util.Iterator;

import com.fsrin.menumine.core.profiler.Profiler;
import com.fsrin.menumine.core.profiler.ProfilerFactory;
import com.fsrin.menumine.core.profiler.aggregation.Profile;
import com.fsrin.menumine.testutil.AbstractNonInitializingMenuMineTestCase;

/**
 * 2006-04-20 RSC new to test the new profiler system.
 * 
 * @author Reid
 */
public class FlavorProfilerTest extends AbstractNonInitializingMenuMineTestCase {

    public void testBasic() throws Exception {
        
        Profiler p = ProfilerFactory.factory.buildFlavorProfiler();
        
        assertNotNull(p);
        
        p.runProfile("garlic");
        
        Collection applications = p.getApplications();
        
        log.info("applications size " + applications.size());
        
        
        
        for (Iterator iter = applications.iterator(); iter.hasNext();) {
            Profile element = (Profile) iter.next();
            log.info(element.getName() + ", " + element.getNumberOfApplications());    
        }
        
        assertEquals(applications.size(), 14);
        
    }
    
}
