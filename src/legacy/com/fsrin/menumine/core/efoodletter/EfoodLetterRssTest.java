/*
 * Created on Jan 28, 2005
 *
 * 
 */
package com.fsrin.menumine.core.efoodletter;

import java.util.Collection;

import junit.framework.TestCase;

import com.fsrin.menumine.testutil.JunitSettings;

/**
 * @author Nick
 * 
 *  
 */
public class EfoodLetterRssTest extends TestCase {

    public void testRead() throws Exception {

        EfoodLetterRssFeedManager rssManager = new EfoodLetterRssFeedManager();
        Collection entries = rssManager.getEntries();

        assertTrue(entries.size() > 0);

    }

    protected void setUp() throws Exception {
        super.setUp();
        JunitSettings.initilizeTestSystem();

    }

}