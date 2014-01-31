/*
 * Created on Mar 10, 2006 by Reid
 */
package com.fsrin.menumine.produtil;

import com.fsrin.menumine.testutil.AbstractNonInitializingMenuMineTestCase;

/**
 * 2006-03-10 Basically just a driver.
 * 
 * @author Reid
 */

public class DataEmptyToNullConverterCommandTest extends
        AbstractNonInitializingMenuMineTestCase {

    public void testBasic() throws Exception {
        
        new DataEmptyToNullConverterCommand().execute();
    }
}
