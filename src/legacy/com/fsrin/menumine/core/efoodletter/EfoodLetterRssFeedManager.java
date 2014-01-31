/*
 * Created on Apr 11, 2005
 *
 * 
 */
package com.fsrin.menumine.core.efoodletter;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;

import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

/**
 * @author Nick
 * 
 *  
 */
public class EfoodLetterRssFeedManager {

    public Collection getEntries() throws EfoodLetterRssException {
        URL feedUrl;
        try {
            //  feedUrl = new
            // URL("http://www.justinpfister.com/gnewsfeed.php?q="+chain.getChain()+"+Restaurant");
            feedUrl = new URL(" http://agreq.blogspot.com/atom.xml");

        } catch (MalformedURLException e) {
            throw new EfoodLetterRssException(e);
        }
        SyndFeedInput input = new SyndFeedInput();
        SyndFeed feed = null;
        try {
            feed = input.build(new XmlReader(feedUrl));
        } catch (Exception e1) {
            throw new EfoodLetterRssException(e1);
        }

        if (feed == null) {
            throw new EfoodLetterRssException("No feed found");
        }
        return feed.getEntries();

        //        }
    }

}