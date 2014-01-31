/*
 * Created on Mar 6, 2006 by Reid
 */
package com.fsrin.menumine.jwebunit;

import com.fsrin.menumine.jwebunit.commands.CommandFactory;
import com.fsrin.menumine.jwebunit.commands.JWebunitCommand;

public class MonkeyUserTest extends AbstractJWebUnitMenuMineTestSupport {

    public MonkeyUserTest(String arg0) {
        super(arg0);
        
    }

    public void testLikeAMonkey() throws Exception {
        
        for (int a=1; a<=100; a++) {
            
            JWebunitCommand cmd = CommandFactory.build();
            
            cmd.execute(this);
            
        }
        
    }
}
