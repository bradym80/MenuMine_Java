/*
 * Created on Jan 28, 2005
 *
 * 
 */
package com.fsrin.menumine.core.chainrss;

import java.net.URL;
import java.util.Iterator;

import junit.framework.TestCase;

import com.fsrin.menumine.testutil.JunitSettings;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

/**
 * @author Nick
 * 
 *  
 */
public class RomeRssTest extends TestCase {

    public void testRead() throws Exception {
        URL feedUrl = new URL(
                "http://www.justinpfister.com/gnewsfeed.php?q=Wendys+Restaurant");

        SyndFeedInput input = new SyndFeedInput();
        SyndFeed feed = input.build(new XmlReader(feedUrl));

        assertTrue(feed.getEntries().size() > 0);
        for (Iterator iter = feed.getEntries().iterator(); iter.hasNext();) {
            SyndEntry element = (SyndEntry) iter.next();

        }

    }

    protected void setUp() throws Exception {
        super.setUp();
        JunitSettings.initilizeTestSystem();

    }

}