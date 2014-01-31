package com.fsrin.menumine.jwebunit;
import net.sourceforge.jwebunit.WebTestCase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

//import com.meterware.httpunit.HttpUnitOptions;

import com.fsrin.menumine.jwebunit.commands.*;
import net.sourceforge.jwebunit.HttpUnitDialog;
//import com.meterware.httpunit.*;


public class StressTest extends WebTestCase
{
    public static final Log log = LogFactory.getLog(HighLevelTests.class);
    
    public StressTest(String arg0) {
        super(arg0);
        //HttpUnitOptions.setScriptingEnabled(false);
        
    }

    protected void setUp() throws Exception {
        super.setUp();
        
        //new LoginCommand().execute(this,MenuMineTestSettings.location, MenuMineTestSettings.username, MenuMineTestSettings.password);
        this.getTestContext().setBaseUrl("http://localhost:8180");
        this.beginAt("/menumine");
        
        HttpUnitDialog dlg = this.getDialog();
    	dlg.dumpResponse();
    	
       	this.assertTitleEquals("MenuMine - Menu Information Database");
        this.assertFormPresent("loginForm");
        this.setWorkingForm("loginForm");
        this.assertFormElementPresent("username");
        this.assertFormElementPresent("password");
        this.setFormElement("username", "mbrady");
        this.setFormElement("password", "miufri4g");   
        this.assertFormElementEquals("username", "mbrady");
        
        this.submit();
        //SubmitButton submit = dlg.getSubmitButton("submit");
        //submit.click();
        
        this.assertTextNotPresent("Could not authenticate");
       
    }
    
    public void testStress() throws Exception {
    
       	int n = 0;
    	
    	assertTextPresent("6957");
    	
    	// This should be the title on the main page
        assertTitleEquals("Welcome to MenuMine");
        
        assertTextPresent("Market Planning Templates");
             
        new SpreadsheetCommand().execute(this);    
    }
}
