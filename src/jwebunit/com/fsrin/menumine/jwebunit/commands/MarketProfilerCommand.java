/*
 * Created on Mar 6, 2006 by Reid
 */
package com.fsrin.menumine.jwebunit.commands;

import net.sourceforge.jwebunit.WebTestCase;

public class MarketProfilerCommand extends AbstractJWebunitCommand {

    public void execute(WebTestCase webTestCase) throws Exception {
        
        webTestCase.gotoPage("marketProfiler.action");
        
        webTestCase.assertTextPresent("Market Profiler");
        
        webTestCase.setFormElement("searchString", "cheese");
        
        webTestCase.submit("displayType","Applications");
        
        webTestCase.assertTextPresent("Menu Item");
        
    }

    
}
