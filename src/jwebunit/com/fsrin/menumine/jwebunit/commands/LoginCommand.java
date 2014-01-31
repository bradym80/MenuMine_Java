/*
 * Created on Mar 6, 2006 by Reid
 */
package com.fsrin.menumine.jwebunit.commands;

import net.sourceforge.jwebunit.WebTestCase;

public class LoginCommand extends AbstractJWebunitCommand {

    public void execute(WebTestCase webTestCase) throws Exception {
        throw new RuntimeException("Can't instantiate this through the factory.");
    }
    
    public void execute(WebTestCase webTestCase, String location,
            String username, String password) throws Exception {

        webTestCase.getTestContext().setBaseUrl(location);
        webTestCase.beginAt("/");
        webTestCase.setFormElement("username", username);
        webTestCase.setFormElement("password", password);
        webTestCase.submit();

        verifyNotAtTheStartPage(webTestCase);

    }

}
