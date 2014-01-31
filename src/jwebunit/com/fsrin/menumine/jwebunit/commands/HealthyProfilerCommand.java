/*
 * Created on Mar 6, 2006 by Reid
 */
package com.fsrin.menumine.jwebunit.commands;

import net.sourceforge.jwebunit.WebTestCase;

public class HealthyProfilerCommand extends AbstractJWebunitCommand {

    public void execute(WebTestCase webTestCase) throws Exception {
        
        webTestCase.gotoPage("healthyProfiler.action");
        
        webTestCase.assertTextPresent("Healthy Profiler");
        
        webTestCase.setFormElement("searchString", "heart");
        
        webTestCase.submit("displayType","Applications");
        
        webTestCase.assertTextPresent("Healthy Term");
        
    }

    
}
