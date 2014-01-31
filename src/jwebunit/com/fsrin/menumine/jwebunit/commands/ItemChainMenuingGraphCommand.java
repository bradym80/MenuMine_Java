/*
 * Created on Mar 6, 2006 by Reid
 */
package com.fsrin.menumine.jwebunit.commands;

import net.sourceforge.jwebunit.WebTestCase;

public class ItemChainMenuingGraphCommand extends AbstractJWebunitCommand {

    public void execute(WebTestCase webTestCase) throws Exception {
        
        webTestCase.gotoPage("menumine.action");
        
        webTestCase.setWorkingForm("menuMineItemsPerChain");
        webTestCase.setFormElement("menuMineDisplayOptions.title", "testTitle"+counter);
        webTestCase.setFormElement("targetYear","2005");
        webTestCase.submit("submitOptions","View Sector Graph");
        
        webTestCase.assertTextNotPresent("Items Per Chain Menuing:");
        webTestCase.assertTextPresent("viewItemsPerChainMenuingSectorGraph.menuminepng");
        verifyNotAtTheStartPage(webTestCase);
        
    }
}
