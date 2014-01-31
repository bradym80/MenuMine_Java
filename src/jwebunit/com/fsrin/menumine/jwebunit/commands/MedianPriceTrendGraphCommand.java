/*
 * Created on Mar 6, 2006 by Reid
 */
package com.fsrin.menumine.jwebunit.commands;

import net.sourceforge.jwebunit.WebTestCase;

public class MedianPriceTrendGraphCommand extends AbstractJWebunitCommand {

    public void execute(WebTestCase webTestCase) throws Exception {
        
        webTestCase.gotoPage("menumine.action");
        
        webTestCase.setWorkingForm("menuMineMedianPrice");
        webTestCase.setFormElement("menuMineGraphOptions.graphByField", "basicProtein");
        webTestCase.setFormElement("menuMineDisplayOptions.title", "testTitle"+counter);
        webTestCase.submit("submitOptions","View Trendline Graph");
        
        webTestCase.assertTextNotPresent("Median Price Trend:");
        
        webTestCase.assertTextPresent("viewMedianPriceTrendLineGraph.menuminepng");
        verifyNotAtTheStartPage(webTestCase);
        
    }
}
