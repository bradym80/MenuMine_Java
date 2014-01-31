/*
 * Created on Mar 30, 2006 by Reid
 */
package com.fsrin.menumine.produtil;

import com.fsrin.menumine.testutil.AbstractNonInitializingMenuMineTestCase;

public class KeywordBuilderCommandTest extends
        AbstractNonInitializingMenuMineTestCase {

    public void testBasic() throws Exception {
        
        KeywordBuilderCommand cmd = new KeywordBuilderCommand();
        
        cmd.execute();
        
    }
}
