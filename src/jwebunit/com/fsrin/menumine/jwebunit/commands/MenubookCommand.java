/*
 * Created on Mar 6, 2006 by Reid
 */
package com.fsrin.menumine.jwebunit.commands;

import net.sourceforge.jwebunit.WebTestCase;

public class MenubookCommand extends AbstractJWebunitCommand {

    public void execute(WebTestCase webTestCase) throws Exception {
        
        webTestCase.gotoPage("menuBookList.action");
        
        webTestCase.assertTextPresent("What is MenuBook?");
        
        webTestCase.setWorkingForm("menuMine");
        
        webTestCase.setFormElement("chainStatFilterParameters.operationName","wendys");
        
        webTestCase.submit("submit", "Search");
        
        webTestCase.assertLinkPresentWithText("Wendys");
        
        webTestCase.assertTextPresent("QSR Chain Sector");
        
        webTestCase.clickLinkWithText("Wendys");
        
        webTestCase.assertTextPresent("Classic Single Hamburger");
        
        
    }

    
}
