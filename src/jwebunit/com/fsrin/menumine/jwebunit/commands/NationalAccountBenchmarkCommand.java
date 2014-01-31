/*
 * Created on Mar 6, 2006 by Reid
 */
package com.fsrin.menumine.jwebunit.commands;

import com.meterware.httpunit.HttpUnitOptions;

import net.sourceforge.jwebunit.WebTestCase;

public class NationalAccountBenchmarkCommand extends AbstractJWebunitCommand {

    public void execute(WebTestCase webTestCase) throws Exception {
        
        
        
        webTestCase.gotoPage("menumineNatlAccountBenchmark.action");
        
        log.info(webTestCase.getDialog().getResponseText());
        
        webTestCase.assertFormPresent("menuMineNABForm");
        
        webTestCase.setWorkingForm("menuMineNABForm");
        webTestCase.setFormElement("menuMineGraphOptions.graphByField", "basicProtein");
        webTestCase.setFormElement("benchmarkType", "benchmark");
        webTestCase.setFormElement("menuMineDisplayOptions.title", "testTitle"+counter);

        webTestCase.setFormElement("nationalAccountBenchmarkWebOptions.targetChains", "Bakers Square");
        webTestCase.setFormElement("nationalAccountBenchmarkWebOptions.benchmarkChains", "Ginos East Pizzaria");
        
        webTestCase.submit("submitOptions","Display Table");
        
        webTestCase.assertTextPresent("Percent Target");
        webTestCase.assertTextPresent("Percent Benchmark");
        
        
        
        this.verifyNotAtTheStartPage(webTestCase);
    }
}
