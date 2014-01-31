/*
 * Created on Mar 6, 2006 by Reid
 */
package com.fsrin.menumine.jwebunit.commands;

import net.sourceforge.jwebunit.WebTestCase;

public class FlavorProfilerCommand extends AbstractJWebunitCommand {

    public void execute(WebTestCase webTestCase) throws Exception {
        
        webTestCase.gotoPage("flavorProfiler.action");
        
        webTestCase.assertTextPresent("Flavor Profiler");
        
        webTestCase.setWorkingForm("menuMine");
        
        webTestCase.setFormElement("searchString", "garlic");
        
        webTestCase.submit("displayType","Applications");
        
        webTestCase.assertTextPresent("Application Share");
       
        webTestCase.gotoPage("flavorProfiler.action?searchString=garlic&displayType=Operator+Share");
        
        webTestCase.assertTextPresent("Leonas");

        webTestCase.gotoPage("flavorProfiler.action?searchString=garlic&displayType=Segment+Share");
        
        webTestCase.assertTextPresent("Family Dining Chain");

        webTestCase.gotoPage("flavorProfiler.action?searchString=garlic&displayType=Sector+Share");
        
        webTestCase.assertTextPresent("Casual Chain Sector");
        
        webTestCase.gotoPage("flavorProfiler.action?searchString=garlic&displayType=Application+Chart");
        
        webTestCase.assertTextPresent("profilerApplicationChart.menuminepng");


        
    }

    
}
