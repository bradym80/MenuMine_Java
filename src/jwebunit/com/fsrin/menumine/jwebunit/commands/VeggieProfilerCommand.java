/*
 * Created on Mar 6, 2006 by Reid
 */
package com.fsrin.menumine.jwebunit.commands;

import net.sourceforge.jwebunit.WebTestCase;

public class VeggieProfilerCommand extends AbstractJWebunitCommand {

    public void execute(WebTestCase webTestCase) throws Exception {
        
        webTestCase.gotoPage("veggieProfiler.action");
        
        webTestCase.assertTextPresent("Veggie Profiler");
        
        webTestCase.setFormElement("searchString", "carrot");
        
        webTestCase.submit("displayType","Applications");
        
        webTestCase.assertTextPresent("Green Veg");
        
    }

    
}
