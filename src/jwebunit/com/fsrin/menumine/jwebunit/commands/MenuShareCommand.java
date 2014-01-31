/*
 * Created on Mar 6, 2006 by Reid
 */
package com.fsrin.menumine.jwebunit.commands;

import net.sourceforge.jwebunit.WebTestCase;

public class MenuShareCommand extends AbstractJWebunitCommand  {

    public void execute(WebTestCase webTestCase) throws Exception {
        
        webTestCase.gotoPage("menumine.action");
        
        webTestCase.setWorkingForm("menuMineStatisticalTable");
        webTestCase.setFormElement("menuMineGraphOptions.graphByField", "basicProtein");
        webTestCase.setFormElement("menuMineDisplayOptions.title", "testTitle"+counter);
        webTestCase.submit("submitOptions");
        webTestCase.assertTextPresent("Statistical Table:");
        webTestCase.assertTextPresent("testTitle"+counter);
        verifyNotAtTheStartPage(webTestCase);
        
    }
}
