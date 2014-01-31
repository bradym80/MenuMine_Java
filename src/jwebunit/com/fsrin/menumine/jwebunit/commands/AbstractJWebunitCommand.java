/*
 * Created on Mar 6, 2006 by Reid
 */
package com.fsrin.menumine.jwebunit.commands;

import net.sourceforge.jwebunit.WebTestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class AbstractJWebunitCommand implements JWebunitCommand {

    public static int counter = 0;
    
    public static Log log = LogFactory.getLog(AbstractJWebunitCommand.class);
    
    public AbstractJWebunitCommand() {
        super();
        counter++;
        log.info("starting " + this.getClass().getName());
    }
    
    public void verifyNotAtTheStartPage(WebTestCase webTestCase) throws Exception {
        
        webTestCase.assertTextNotPresent("Password Help");
        webTestCase.assertTextNotPresent("HTTP Status 500");
        
    }
}
