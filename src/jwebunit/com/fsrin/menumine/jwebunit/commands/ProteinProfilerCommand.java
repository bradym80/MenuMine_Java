/*
 * Created on Mar 6, 2006 by Reid
 */
package com.fsrin.menumine.jwebunit.commands;

import net.sourceforge.jwebunit.WebTestCase;

public class ProteinProfilerCommand extends AbstractJWebunitCommand {

    public void execute(WebTestCase webTestCase) throws Exception {
        
        webTestCase.gotoPage("proteinProfiler.action");
        
        webTestCase.assertTextPresent("Protein Profiler");
        
        webTestCase.setWorkingForm("menuMine");
        
        webTestCase.setFormElement("searchString", "chicken");
        
        webTestCase.submit("displayType","Applications");
        
        webTestCase.assertTextPresent("Application Share");
        
        webTestCase.assertTextPresent("Protein Accompaniment");
        
    }

    
}
