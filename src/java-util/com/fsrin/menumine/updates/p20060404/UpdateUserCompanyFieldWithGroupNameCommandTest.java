/*
 * Created on Apr 4, 2006 by Reid
 */
package com.fsrin.menumine.updates.p20060404;

import com.fsrin.menumine.testutil.AbstractNonInitializingMenuMineTestCase;

public class UpdateUserCompanyFieldWithGroupNameCommandTest extends
        AbstractNonInitializingMenuMineTestCase {

    public void testUpdate() throws Exception {
        
        new UpdateUserCompanyFieldWithGroupNameCommand().execute();
        
    }
}
