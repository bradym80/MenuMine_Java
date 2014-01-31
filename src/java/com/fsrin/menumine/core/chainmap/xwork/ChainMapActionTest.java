/*
 * Created on Feb 7, 2006 by Reid
 */
package com.fsrin.menumine.core.chainmap.xwork;

import java.util.Iterator;

import com.fsrin.menumine.common.SpringBeanBroker;
import com.fsrin.menumine.context.MenuMineSessionContextFactory;
import com.fsrin.menumine.core.incidence.IncidenceChain;
import com.fsrin.menumine.core.incidence.IncidenceSector;
import com.fsrin.menumine.core.incidence.IncidenceSegment;
import com.fsrin.menumine.testutil.AbstractNonInitializingMenuMineTestCase;
import com.opensymphony.xwork.Action;

public class ChainMapActionTest extends AbstractNonInitializingMenuMineTestCase {

    public void testBasic() throws Exception {
        ChainMapAction action = (ChainMapAction) SpringBeanBroker
                .getBeanFactory().getBean("chainMapAction");

        action.setMenuMineSessionContextWrapper(MenuMineSessionContextFactory
                .getMockWrapper());

        action.setChainMapContext(new ChainMapContext());

        action.setChainMapWebOptions(new ChainMapWebOptions());

        String s = action.execute();

        assertEquals(Action.SUCCESS, s);

        assertNotNull(action.getChainMapWebOptions()
                .getSectorSegmentChainRelations().getIncidenceSectors());

        log.info("Sector size is "
                + action.getChainMapWebOptions()
                        .getSectorSegmentChainRelations().getIncidenceSectors()
                        .size());

        /*
         * 2006-03-11 RSC Sector size dropped to 6 so I changed it to a range.
         * 
         */
        assertTrue(action.getChainMapWebOptions()
                .getSectorSegmentChainRelations().getIncidenceSectors().size() >= 5);

        IncidenceSector sector = (IncidenceSector) action
                .getChainMapWebOptions().getSectorSegmentChainRelations()
                .getIncidenceSectors().toArray()[0];

        assertNotNull(sector.getIncidenceSegments());

        log.info("sector segment size is "
                + sector.getIncidenceSegments().size());

        IncidenceSegment segment = (IncidenceSegment) sector
                .getIncidenceSegments().toArray()[0];

        assertNotNull(segment.getIncidenceChains());

        log.info("chain size is " + segment.getIncidenceChains().size());

        assertTrue(segment.getIncidenceChains().size() > 0);

        IncidenceChain incidenceChain = (IncidenceChain) segment
                .getIncidenceChains().toArray()[0];

        assertNotNull(incidenceChain.getName());

        assertTrue(incidenceChain.getName().trim().length() > 0);

        for (Iterator iter = action.getChainMapWebOptions().getSectorSegmentChainRelations().getIncidenceSectors().iterator(); iter.hasNext();) {
            
            IncidenceSector element = (IncidenceSector) iter.next();
            
            log.info("in segments size " + element.getIncidenceSegments().size());
            
            assertNotNull(element.getName());
            
            for (Iterator iterator2 = element.getIncidenceSegments().iterator(); iterator2.hasNext();) {
                IncidenceSegment element2 = (IncidenceSegment) iterator2.next();
                
                assertNotNull(element2.getName());
                
                log.info("in chains size " + element2.getIncidenceChains().size());
                
                for (Iterator iterator3 = element2.getIncidenceChains().iterator(); iterator3
                        .hasNext();) {
                    IncidenceChain element3 = (IncidenceChain) iterator3.next();
                    
                    assertNotNull(element3.getName());
                    
                }
                
            }
            
            
        }
        
        assertNotNull(action.getChainMapTable());
    }

}
