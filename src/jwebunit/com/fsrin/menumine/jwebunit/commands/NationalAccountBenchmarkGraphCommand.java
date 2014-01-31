/*
 * Created on Mar 6, 2006 by Reid
 */
package com.fsrin.menumine.jwebunit.commands;

import net.sourceforge.jwebunit.WebTestCase;

public class NationalAccountBenchmarkGraphCommand extends AbstractJWebunitCommand {

    public void execute(WebTestCase webTestCase) throws Exception {
        
        
        
        webTestCase.setWorkingForm("menuMineNABForm");
        webTestCase.setFormElement("menuMineGraphOptions.graphByField", "basicProtein");
        webTestCase.setFormElement("benchmarkType", "benchmark");
        webTestCase.setFormElement("menuMineDisplayOptions.title", "testTitle"+counter);

        webTestCase.setFormElement("nationalAccountBenchmarkWebOptions.targetChains", "Bakers Square");
        webTestCase.setFormElement("nationalAccountBenchmarkWebOptions.benchmarkChains", "Ginos East Pizzaria");
        
        webTestCase.submit("submitOptions","Graph");
        
        webTestCase.assertTextPresent("National Account Benchmark Table Graph:");
        webTestCase.assertTextPresent("Percent Benchmark");
        
        
        
        this.verifyNotAtTheStartPage(webTestCase);
    }
}
