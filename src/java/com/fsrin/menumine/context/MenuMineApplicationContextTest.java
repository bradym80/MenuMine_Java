/*
 * Created on 2005-1-14
 *
 */
package com.fsrin.menumine.context;

import junit.framework.TestCase;

/**
 * @author Nick
 *  
 */
public class MenuMineApplicationContextTest extends TestCase {



    /*
     * @see TestCase#setUp()
     */
    protected void setUp() throws Exception {
        super.setUp();
//        JunitSettings.initilizeTestSystem();

    }

    public void testBroker() throws Exception {

        //has to get an application context
        MenuMineApplicationContext menuMineApplicationContext = MenuMineApplicationContext.broker
                .find();
        assertTrue(menuMineApplicationContext.isValid());

        //authenticator has to be valid
        assertTrue(menuMineApplicationContext.getAuthenticator() != null);

    }

}