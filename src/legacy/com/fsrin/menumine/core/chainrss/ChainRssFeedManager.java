/*
 * Created on Apr 11, 2005
 *
 * 
 */
package com.fsrin.menumine.core.chainrss;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;

import com.fsrin.menumine.core.chainstat.ChainStat;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

/**
 * @author Nick
 * 
 *  
 */
public class ChainRssFeedManager {

    public Collection getEntries(ChainStat chain) throws ChainRssException {
        URL feedUrl;
        try {
            //  feedUrl = new
            // URL("http://www.justinpfister.com/gnewsfeed.php?q="+chain.getChain()+"+Restaurant");
            feedUrl = new URL("http://news.search.yahoo.com/news/rss?p="
                    + chain.getChain() + "++Business&ei=UTF-8&fl=0&x=wrt");

        } catch (MalformedURLException e) {
            throw new ChainRssException(e);
        }
        SyndFeedInput input = new SyndFeedInput();
        SyndFeed feed = null;
        try {
            feed = input.build(new XmlReader(feedUrl));
        } catch (Exception e1) {
            throw new ChainRssException(e1);
        }

        if (feed == null) {
            throw new ChainRssException("No feed found");
        }
        return feed.getEntries();

    }

}