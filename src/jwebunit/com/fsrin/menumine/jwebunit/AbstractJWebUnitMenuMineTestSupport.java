/*
 * Created on Mar 3, 2006 by Reid
 */
package com.fsrin.menumine.jwebunit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fsrin.menumine.jwebunit.commands.ExpressBaconCommand;
import com.fsrin.menumine.jwebunit.commands.LoginCommand;
import com.meterware.httpunit.HttpUnitOptions;

import net.sourceforge.jwebunit.WebTestCase;

public abstract class AbstractJWebUnitMenuMineTestSupport extends WebTestCase {

    protected static Log log = LogFactory.getLog(AbstractJWebUnitMenuMineTestSupport.class);
    
    public AbstractJWebUnitMenuMineTestSupport(String arg0) {
        super(arg0);
        HttpUnitOptions.setScriptingEnabled(false);
        
    }

    protected void setUp() throws Exception {
        super.setUp();
//        getTestContext().setBaseUrl(MenuMineTestSettings.location);
//        beginAt("/");
//        setFormElement("username", MenuMineTestSettings.username);
//        setFormElement("password",MenuMineTestSettings.password);
//        submit();
//        
//        verifyNotAtTheStartPage();
        
        new LoginCommand().execute(this,MenuMineTestSettings.location, MenuMineTestSettings.username, MenuMineTestSettings.password);
        
//        assertTitleEquals("MenuMine Dashboard");
//        
//        setFormElement("expressSearchQuery","bacon");
//        setFormElement("expressMine","menu.mine");
//        setFormElement("expressDisplayType", "opportunities");
//        submit();
//        assertTextPresent("Display Spreadsheet:");
        
        new ExpressBaconCommand().execute(this);
    }
    
    /*
     * generally this should be done in the commands.
     */
    public void verifyNotAtTheStartPage() throws Exception {
        
        assertTextNotPresent("Password Help");
        assertTextNotPresent("HTTP Status 500");
        
    }
}
