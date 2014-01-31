/*
 * Created on Mar 6, 2006 by Reid
 */
package com.fsrin.menumine.jwebunit.commands;

import net.sourceforge.jwebunit.WebTestCase;

public class SpreadsheetCommand extends AbstractJWebunitCommand {

    public void execute(WebTestCase webTestCase) throws Exception {
        
        webTestCase.gotoPage("menumine.action");
        
        webTestCase.setWorkingForm("menuMineSpreadSheet");
        webTestCase.setFormElement("menuMineDisplayOptions.sortBy", "basicProtein");
        webTestCase.setFormElement("menuMineDisplayOptions.sortType", "ASC");
        webTestCase.setFormElement("menuMineDisplayOptions.title", "testTitle"+counter);

        
        webTestCase.submit();
        webTestCase.assertTextPresent("Display Spreadsheet:");
        webTestCase.assertTextPresent("testTitle"+counter);
        webTestCase.assertLinkPresentWithText("Export to Excel");
        verifyNotAtTheStartPage(webTestCase);
        
    }
}
