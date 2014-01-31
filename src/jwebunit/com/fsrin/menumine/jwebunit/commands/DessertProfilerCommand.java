/*
 * Created on Mar 6, 2006 by Reid
 */
package com.fsrin.menumine.jwebunit.commands;

import net.sourceforge.jwebunit.WebTestCase;

public class DessertProfilerCommand extends AbstractJWebunitCommand {

    public void execute(WebTestCase webTestCase) throws Exception {
        
        webTestCase.gotoPage("dessertProfiler.action");
        
        webTestCase.assertTextPresent("Dessert Profiler");
        
        webTestCase.setFormElement("searchString", "vanilla");
        
        webTestCase.submit("displayType","Applications");
        
        webTestCase.assertTextPresent("Nut Topping");
        
    }

    
}
