/*
 * Created on Aug 17, 2005
 *
 * 
 */
package com.fsrin.menumine.common.util;

import junit.framework.TestCase;

/**
 * @author Nick
 * 
 *  
 */
public class MenuMineUtilTest extends TestCase {

    public MenuMineUtilTest() {
        super();

    }

    public MenuMineUtilTest(String arg0) {
        super(arg0);

    }

    public void testStringRootifyerOnion() {
        String root = MenuMineUtil.stringRootifyer("Onions");
        assertEquals("Onion", root);

    }

    public void testStringRootifyerPeppers() {

        String root = MenuMineUtil.stringRootifyer("Peppers, Bell");
        assertEquals("Pepper, Bell", root);

    }

}