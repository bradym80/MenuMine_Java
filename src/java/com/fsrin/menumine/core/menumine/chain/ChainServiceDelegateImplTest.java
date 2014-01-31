/*
 * Created on Feb 6, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.chain;

import com.fsrin.menumine.core.chainstat.ChainStat;
import com.fsrin.menumine.testutil.AbstractNonInitializingMenuMineTestCase;

public class ChainServiceDelegateImplTest extends
        AbstractNonInitializingMenuMineTestCase {

    public void testBasic() throws Exception {
        
        ChainStat c = ChainServiceDelegateFactory.factory.build().find("Wendys");
        
        assertNotNull(c);
    }
}
