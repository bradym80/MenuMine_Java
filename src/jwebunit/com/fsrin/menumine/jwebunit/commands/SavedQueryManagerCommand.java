/*
 * Created on Mar 6, 2006 by Reid
 */
package com.fsrin.menumine.jwebunit.commands;

import net.sourceforge.jwebunit.WebTestCase;

public class SavedQueryManagerCommand extends AbstractJWebunitCommand {

    public void execute(WebTestCase webTestCase) throws Exception {
        
        webTestCase.gotoPage("savedQueryList.action");
        
        webTestCase.assertTextPresent("Saved Query List");
        
    }

    
}
