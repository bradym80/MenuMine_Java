/*
 * Created on Feb 6, 2006 by Reid
 */
package com.fsrin.menumine.core.menubook;

import java.util.Iterator;

import com.fsrin.menumine.testutil.AbstractNonInitializingMenuMineTestCase;

public class MenuBookBuilderTest extends
        AbstractNonInitializingMenuMineTestCase {

    public void testBasic() throws Exception {
        
        MenuBookBuilder builder = MenuBookBuilderFactory.factory.build();
        
        MenuBook books = builder.build("Wendys");
        
        assertNotNull(books);
        
        assertNotNull(books.getChain());
        
        assertNotNull(books.getMenuParts());
        
        log.info("MenuPart size is " + books.getMenuParts().size());
        
        /*
         * 2006-03-08 Wendy's shouldn't have Pizza on the menu.
         */
        for (Iterator iter = books.getMenuParts().iterator(); iter.hasNext();) {
            MenuBookMenuPart element = (MenuBookMenuPart) iter.next();
            assertTrue(element.getName().indexOf("izza") < 0);
        }
        
    }
}
