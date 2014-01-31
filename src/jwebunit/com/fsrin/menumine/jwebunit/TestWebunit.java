package com.fsrin.menumine.jwebunit;
import com.fsrin.menumine.jwebunit.commands.SpreadsheetCommand;

import net.sourceforge.jwebunit.HttpUnitDialog;
import net.sourceforge.jwebunit.WebTestCase;


public class TestWebunit extends WebTestCase {
	
    protected void setUp() throws Exception {
        super.setUp();
	
	    this.getTestContext().setBaseUrl("http://www.sailinganarchy.com");
	    this.beginAt("index_page1.php");
	    
	    HttpUnitDialog dlg = this.getDialog();
		dlg.dumpResponse();
		
	    this.assertLinkPresent("Forums");
	    this.clickLink("Forums");
	    
	    this.assertTitleEquals("fooBar");
	    
	    dlg = this.getDialog();
		dlg.dumpResponse();
    }
	
    public void testStress() throws Exception {
        
       	int n = 0;
    	
    	assertTextPresent("6957");
    	
    	// This should be the title on the main page
        assertTitleEquals("Welcome to MenuMine");
        
        assertTextPresent("Market Planning Templates");
              
    }

}
