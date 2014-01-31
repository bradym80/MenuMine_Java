/*
 * Created on Mar 6, 2006 by Reid
 */
package com.fsrin.menumine.jwebunit.commands;

import net.sourceforge.jwebunit.WebTestCase;

public interface JWebunitCommand {

    public void execute(WebTestCase webTestCase) throws Exception;
}
