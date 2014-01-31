/*
 * Created on Mar 30, 2006 by Reid
 */
package com.fsrin.menumine.produtil;

import com.fsrin.menumine.testutil.AbstractNonInitializingMenuMineTestCase;

public class UpdateDatabaseStructureCommandTest extends
        AbstractNonInitializingMenuMineTestCase {

    public void testCommand() throws Exception {
        
        UpdateDatabaseStructureCommand command = new UpdateDatabaseStructureCommand();
        
        command.execute();
        
    }
    
}
