/*
 * Created on Mar 6, 2006 by Reid
 */
package com.fsrin.menumine.jwebunit.commands;

import net.sourceforge.jwebunit.WebTestCase;

public class NationalAccountBenchmarkTrendsCommand extends AbstractJWebunitCommand {

    public void execute(WebTestCase webTestCase) throws Exception {
        
        webTestCase.setWorkingForm("menuMineNABForm");
        webTestCase.setFormElement("menuMineGraphOptions.graphByField", "basicProtein");
        webTestCase.setFormElement("benchmarkType", "benchmark.trend");
        webTestCase.setFormElement("menuMineDisplayOptions.title", "testTitle"+counter);

        webTestCase.setFormElement("nationalAccountBenchmarkWebOptions.targetChains", "Bakers Square");
        webTestCase.setFormElement("nationalAccountBenchmarkWebOptions.benchmarkChains", "Ginos East Pizzaria");
        
        webTestCase.submit("submitOptions","Display Table");
        
        webTestCase.assertTextPresent("Target");
        webTestCase.assertTextPresent("Benchmark");
        webTestCase.assertTextPresent("2004");
        
        this.verifyNotAtTheStartPage(webTestCase);
    }
}
