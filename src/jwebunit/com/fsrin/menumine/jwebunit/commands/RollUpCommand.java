/*
 * Created on Mar 6, 2006 by Reid
 */
package com.fsrin.menumine.jwebunit.commands;

import net.sourceforge.jwebunit.WebTestCase;

public class RollUpCommand extends AbstractJWebunitCommand {

    public void execute(WebTestCase webTestCase) throws Exception {
        
        /*
         * we have to have some statistical table before 
         */
        new MenuShareCommand().execute(webTestCase);
        
        webTestCase.gotoPage("menumineBuildRollUp.action");
        
        webTestCase.assertTextPresent("Roll Up Checked Items As");
        
        this.verifyNotAtTheStartPage(webTestCase);
    }
}
