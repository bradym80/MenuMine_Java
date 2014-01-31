/*
 * Created on Mar 6, 2006 by Reid
 */
package com.fsrin.menumine.jwebunit.commands;

import net.sourceforge.jwebunit.WebTestCase;

public class MeanPriceTrendCommand extends AbstractJWebunitCommand {

    public void execute(WebTestCase webTestCase) throws Exception {
        
        webTestCase.gotoPage("menumine.action");
        
        webTestCase.setWorkingForm("menuMineMeanPrice");
        webTestCase.setFormElement("menuMineGraphOptions.graphByField", "basicProtein");
        webTestCase.setFormElement("menuMineDisplayOptions.title", "testTitle"+counter);
        webTestCase.submit("submitOptions","Redisplay Mean Price Trend");
        
        
        webTestCase.assertTextPresent("Mean Price Trend:");
        webTestCase.assertTextPresent("testTitle"+counter);
        verifyNotAtTheStartPage(webTestCase);
        
    }
}
