/*
 * Created on Mar 6, 2006 by Reid
 */
package com.fsrin.menumine.jwebunit.commands;

import net.sourceforge.jwebunit.WebTestCase;

public class CarboProfilerCommand extends AbstractJWebunitCommand {

    public void execute(WebTestCase webTestCase) throws Exception {
        
        webTestCase.gotoPage("carboProfiler.action");
        
        webTestCase.assertTextPresent("Carbo Profiler");
        
        webTestCase.setFormElement("searchString", "pasta");
        
        webTestCase.submit("displayType","Applications");
        
        webTestCase.assertTextPresent("Carbo Accompaniment");
       
        
    }

    
}
