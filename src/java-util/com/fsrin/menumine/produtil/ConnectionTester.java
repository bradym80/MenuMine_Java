/*
 * Created on Mar 24, 2006 by Reid
 */
package com.fsrin.menumine.produtil;

import com.fsrin.menumine.core.chainstat.ChainStat;
import com.fsrin.menumine.core.menumine.chain.ChainServiceDelegateFactory;
import com.fsrin.menumine.testutil.AbstractNonInitializingMenuMineTestCase;

/**
 * useful for testing remote access.
 * @author Reid
 */
public class ConnectionTester extends AbstractNonInitializingMenuMineTestCase {

    public void testBasic() throws Exception {
        
        ChainStat c = ChainServiceDelegateFactory.factory.build().find("wendys");
        
        assertNotNull(c);
    }
}
