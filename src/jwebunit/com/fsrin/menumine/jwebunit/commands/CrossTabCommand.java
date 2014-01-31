/*
 * Created on Mar 6, 2006 by Reid
 */
package com.fsrin.menumine.jwebunit.commands;

import net.sourceforge.jwebunit.WebTestCase;

public class CrossTabCommand extends AbstractJWebunitCommand {

    public void execute(WebTestCase webTestCase) throws Exception {
        webTestCase.gotoPage("menumine.action");
        
        webTestCase.setWorkingForm("menuMineCrossTabulation");
        
        webTestCase.setFormElement("menuMineCrossTabulationOptions.horizontalField", "basicProtein");
        webTestCase.setFormElement("menuMineCrossTabulationOptions.verticalField", "basicProtein");
        webTestCase.setFormElement("menuMineDisplayOptions.title", "testTitle"+counter);

        webTestCase.submit();
        
        webTestCase.assertTextPresent("Cross Tabulation:");
        webTestCase.assertTextPresent("Record Count:");
        webTestCase.assertLinkPresentWithText("Export to Excel");
        verifyNotAtTheStartPage(webTestCase);
    }
}
