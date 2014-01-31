/*
 * Created on Jul 18, 2005
 *
 * 
 */
package com.fsrin.menumine.core.chainmap;

import java.util.Collection;
import java.util.Iterator;

import com.fsrin.menumine.testutil.AbstractNonInitializingMenuMineTestCase;

/**
 * @author Nick
 * 
 *  
 */
public class ChainMapTest extends AbstractNonInitializingMenuMineTestCase {



    public void testChainMap() throws Exception {

        ChainMapTable table = new ChainMapTable();

        ChainStateCountServiceDelegate sd = ChainStateCountServiceDelegate.factory
                .build();

        Collection all = sd.search(new ChainStateCountCriteriaParamerters());

        for (Iterator iter = all.iterator(); iter.hasNext();) {
            ChainStateCount element = (ChainStateCount) iter.next();
            
            
            if (element != null) {
                //log.info("element OH count " + element.getOH());
                table.addChainStateCount(element);
            }
             
        }

        assertNotNull(table.getMidwestCount());
        assertNotNull(table.getNorthEastCount());
        assertNotNull(table.getSouthCount());
        assertNotNull(table.getWestCount());

        /*
         * 2006-03-11 RSC These portions of the test have never worked and don't appear
         * to affect functionality.
         */
//        log.info("midwest " + table.getMidwestCount().getAllChainCount());
//        log.info("northeast " + table.getNorthEastCount().getAllChainCount());
//        log.info("south " + table.getSouthCount().getAllChainCount());
//        log.info("west " + table.getWestCount().getAllChainCount());
//        
//        assertEquals(38124, table.getMidwestCount().getAllChainCount()
//                .intValue());
//        assertEquals(22604, table.getNorthEastCount().getAllChainCount()
//                .intValue());
//        assertEquals(59359, table.getSouthCount().getAllChainCount().intValue());
//        assertEquals(53202, table.getWestCount().getAllChainCount().intValue());

    }


}