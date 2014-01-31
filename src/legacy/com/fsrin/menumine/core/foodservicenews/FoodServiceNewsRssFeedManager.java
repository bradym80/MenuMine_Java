/*
 * Created on Apr 11, 2005
 *
 * 
 */
package com.fsrin.menumine.core.foodservicenews;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.TreeSet;

import com.opensymphony.webwork.util.Sorter;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

/**
 * @author Nick
 * 
 *  
 */
public class FoodServiceNewsRssFeedManager {

    private boolean disable = true;

    public Collection getEntries(String search)
            throws FoodServiceNewsRssException {
        URL feedUrl;

        try {
            //              feedUrl = new
            //             URL("http://www.justinpfister.com/gnewsfeed.php?q="+chain.getChain()+"+Restaurant");
            //                       

            feedUrl = new URL("http://www.justinpfister.com/gnewsfeed.php?q="
                    + search + "++Business&ei=UTF-8&fl=0&x=wrt");

            //            feedUrl = new URL("http://news.google.com/news?q=" + search
            //                    + "++Business&output=rss");

            //            // feedUrl = new URL("");

        } catch (MalformedURLException e) {
            throw new FoodServiceNewsRssException(e);
        }
        SyndFeedInput input = new SyndFeedInput();
        SyndFeed feed = null;
        try {
            feed = input.build(new XmlReader(feedUrl));
        } catch (Exception e1) {
            throw new FoodServiceNewsRssException(e1);
        }

        if (feed == null) {
            throw new FoodServiceNewsRssException("No feed found");
        }
        return feed.getEntries();

    }

    private Collection entries;

    public Collection getEntries() throws FoodServiceNewsRssException {

        if (entries == null) {
            updateEntries();
        }

        return this.entries;

    }

    public void updateEntries() throws FoodServiceNewsRssException {
        /*
         * This will return a lot of duplicate results, so if we sort by title
         * we will eliminate some of them.
         */
        if (!disable) {
            Collection all = new TreeSet(new Sorter().getAscending("title"));
            //Collection foodService1 = this.getEntries("Food++Service");

            Collection foodService2 = this.getEntries("Foodservice");
            // Collection dining = this.getEntries("Dining");
            Collection restaurantChain = this.getEntries("Restaurant++Chain");
            //  Collection menu = this.getEntries("Menu");

            // all.addAll(foodService1);
            all.addAll(foodService2);
            // all.addAll(dining);
            all.addAll(restaurantChain);
            //  all.addAll(menu);

            this.entries = all;
        }

    }

    public boolean isDisable() {
        return disable;
    }

    public void setDisable(boolean disable) {
        this.disable = disable;
    }
}