/*
 * Created on Mar 6, 2006 by Reid
 */
package com.fsrin.menumine.jwebunit.commands;

import net.sourceforge.jwebunit.WebTestCase;

public class ExpressBaconCommand extends AbstractJWebunitCommand {
    
    public void execute(WebTestCase webTestCase) throws Exception {
        
        
        
        webTestCase.assertTitleEquals("MenuMine - Menu Information Database");
        
        webTestCase.setFormElement("searchString","bacon");
        webTestCase.setFormElement("expressMine","menu.mine");
        webTestCase.setFormElement("expressDisplayType", "opportunities");
        webTestCase.submit();
        webTestCase.assertTextPresent("Show As Single");
        
        this.verifyNotAtTheStartPage(webTestCase);
    }
            

}
