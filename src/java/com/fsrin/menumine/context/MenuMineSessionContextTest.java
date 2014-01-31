/*
 * Created on 2005-1-14
 *
 */
package com.fsrin.menumine.context;

import junit.framework.TestCase;

import com.fstx.stdlib2.authen.AuthenticatedUser;

/**
 * @author Nick
 *  
 */
public class MenuMineSessionContextTest extends TestCase {

    /*
     * @see TestCase#setUp()
     */
    protected void setUp() throws Exception {
        super.setUp();
//        JunitSettings.initilizeTestSystem();
    }

    public void testFactory() throws Exception {

        AuthenticatedUser authenticatedUser = null;

        MenuMineApplicationContext applicationContext = MenuMineApplicationContext.broker
                .find();

        /*
         * sessions can't exist without authenticated users.
         */
        MenuMineSessionContext menuMineSessionContext1 = MenuMineSessionContext.factory
                .build(authenticatedUser);

        //make sure the Spring singleton is working.
        assertTrue(menuMineSessionContext1.getMenuMineApplicationContext() == applicationContext);

        /*
         * while sessions with the same authenticated user are odd, this was we
         * can make sure we're not getting the same session 2x.
         */
        MenuMineSessionContext menuMineSessionContext2 = MenuMineSessionContext.factory
                .build(authenticatedUser);

        assertTrue(menuMineSessionContext1 != menuMineSessionContext2);

    }

}