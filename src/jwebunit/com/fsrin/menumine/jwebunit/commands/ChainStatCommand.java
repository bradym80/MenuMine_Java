/*
 * Created on Mar 6, 2006 by Reid
 */
package com.fsrin.menumine.jwebunit.commands;

import net.sourceforge.jwebunit.WebTestCase;

public class ChainStatCommand extends AbstractJWebunitCommand {

    public void execute(WebTestCase webTestCase) throws Exception {
        
        webTestCase.gotoPage("chainStatList.action");
        
        webTestCase.assertTextPresent("What is Chain Stat?");
        
        webTestCase.setWorkingForm("menuMine");
        
        webTestCase.setFormElement("chainStatFilterParameters.operationName","wendys");
        
        webTestCase.submit("submit", "Search");
        
        webTestCase.assertLinkPresentWithText("Wendys");
        
        webTestCase.assertLinkPresentWithText("wendys.com");
        
        webTestCase.clickLinkWithText("Wendys");
        
        webTestCase.assertTextPresent("# Operating Units");
    }

    
}
