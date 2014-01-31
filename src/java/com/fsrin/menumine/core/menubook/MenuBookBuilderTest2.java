/*
 * Created on Mar 7, 2006
 *
 */
package com.fsrin.menumine.core.menubook;

import java.util.Collection;
import java.util.Iterator;

import com.fsrin.menumine.core.menumine.chain.Chain;
import com.fsrin.menumine.core.menumine.chain.ChainFilterParameters;
import com.fsrin.menumine.core.menumine.chain.ChainServiceDelegateFactory;
import com.fsrin.menumine.testutil.AbstractNonInitializingMenuMineTestCase;

/*
 * one of the connection pools was failing.
 */
public class MenuBookBuilderTest2 extends
        AbstractNonInitializingMenuMineTestCase {

    public void testMultipleChains() throws Exception {

        Collection allChains = ChainServiceDelegateFactory.factory.build()
                .search(new ChainFilterParameters());
        
        assertNotNull(allChains);
        assertTrue(allChains.size() > 0);

        for (Iterator iter = allChains.iterator(); iter.hasNext();) {
            Chain element = (Chain) iter.next();
            
            log.info("current chain is " + element.getOperationName());
            
            MenuBook book = new MenuBookBuilderFactory().build().build(element.getOperationName());
            
            assertNotNull(book);
            
        }
        
    }
    
    /**
     * had an error with Elephant Walk chain.  The average price for an item shows up as $0.00 when 
     * there is clearly price data available.
     * 
     * turned out to be a JSP error.
     * 
     * @throws Exception
     */
    public void testElephantWalkError_20060313() throws Exception {
       
        MenuBook book = new MenuBookBuilderFactory().build().build("Elephant Walk");
        
        assertNotNull(book);
        
        assertNotNull(book.getMenuParts());
        
        assertTrue(book.getMenuParts().size() > 0);
        
        for (Iterator iter = book.getMenuParts().iterator(); iter.hasNext();) {
            MenuBookMenuPart element = (MenuBookMenuPart) iter.next();
            log.info("Menu Items Size " + element.getMenuItems().size());
            if (element.getMenuItems().size() > 0) {
                assertTrue(element.getMedianPrice2005().doubleValue() > 0.0);
                assertTrue(element.getMedianPrice2004().doubleValue() > 0.0);
                log.info("Median Price 2004 is " + element.getMedianPrice2004());
            }
        }
    }
}
