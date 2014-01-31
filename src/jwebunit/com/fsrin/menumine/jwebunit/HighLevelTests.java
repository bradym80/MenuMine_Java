
package com.fsrin.menumine.jwebunit;

import net.sourceforge.jwebunit.WebTestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.meterware.httpunit.HttpUnitOptions;

/**
 * @author Reid
 * @version March 3, 2006
 */
public class HighLevelTests extends WebTestCase {

    public static final Log log = LogFactory.getLog(HighLevelTests.class);
    
    public HighLevelTests(String arg0) {
        super(arg0);
        HttpUnitOptions.setScriptingEnabled(false);
        
    }

    protected void setUp() throws Exception {
        super.setUp();
        getTestContext().setBaseUrl(MenuMineTestSettings.location);
    }
    
    public void testLogin() throws Exception {
        beginAt("/");
        assertTextPresent("MenuMine covers the entire marketplace");
        assertTextPresent("name=\"loginForm\"");
        log.info(this.getDialog().getResponseText());
        
        assertFormPresent("loginForm");
        
        this.setWorkingForm("loginForm");
        setFormElement("username", "mbrady");
        setFormElement("password","miufri4g");
        submit();
        
        assertTitleEquals("MenuMine Dashboard");
        
    }

    public void testLoginAndExpress() throws Exception {
        beginAt("/");
        setFormElement("username", "mbrady");
        setFormElement("password","miufri4g");
        submit();
        assertTitleEquals("MenuMine Dashboard");
        
        setFormElement("searchString","bacon");
        setFormElement("expressMine","menu.mine");
        setFormElement("expressDisplayType", "opportunities");
        submit();
        assertTextPresent("Show As Single");
        assertTextNotPresent("able to sort through 80,000");
        
    }
}
