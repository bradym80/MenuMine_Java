/*
 * Created on Mar 6, 2006 by Reid
 */
package com.fsrin.menumine.jwebunit.commands;

import net.sourceforge.jwebunit.WebTestCase;

public class MenuMineGraphPieCommand extends AbstractJWebunitCommand {

    public void execute(WebTestCase webTestCase) throws Exception {
        
        webTestCase.gotoPage("menumine.action");
        
        
        webTestCase.setWorkingForm("menuMineStatisticalTable");
        webTestCase.setFormElement("menuMineGraphOptions.graphByField", "basicProtein");
//        webTestCase.setFormElement("menuMineGraphOptions.graphByType", "pie");
        webTestCase.setFormElement("menuMineGraphOptions.graphTitle", "testTitle"+counter);
        webTestCase.submit("submitBarGraph","View Pie Graph");
        webTestCase.assertTextNotPresent("Statistical Table:");
        webTestCase.assertTextPresent("MenuMine Graph");
        verifyNotAtTheStartPage(webTestCase);
        
    }
}
