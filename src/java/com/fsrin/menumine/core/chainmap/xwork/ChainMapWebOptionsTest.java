/*
 * Created on Feb 17, 2006 by Reid
 */
package com.fsrin.menumine.core.chainmap.xwork;

import com.fsrin.menumine.core.incidence.IncidenceTable;
import com.fsrin.menumine.testutil.AbstractNonInitializingMenuMineTestCase;

public class ChainMapWebOptionsTest extends AbstractNonInitializingMenuMineTestCase {

    public void testBasic() throws Exception {
        
        ChainMapWebOptions options = new ChainMapWebOptions();
        
        assertNotNull(options.getSectorSegmentChainRelations());
        
        IncidenceTable table = options.getSectorSegmentChainRelations();
        
        assertNotNull(table.getIncidenceSectors());
        
    }
}
