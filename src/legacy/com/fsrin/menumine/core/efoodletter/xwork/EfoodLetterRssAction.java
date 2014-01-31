/*
 * Created on 2005-1-18
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.fsrin.menumine.core.efoodletter.xwork;

import java.util.ArrayList;
import java.util.Collection;

import com.fsrin.menumine.context.webwork.AbstractMenuMineSessionContextAwareAction;
import com.fsrin.menumine.core.efoodletter.EfoodLetterRssException;
import com.fsrin.menumine.core.efoodletter.EfoodLetterRssFeedManager;

/**
 * @author Nick
 * @version 1
 */

public class EfoodLetterRssAction extends AbstractMenuMineSessionContextAwareAction {

    private EfoodLetterRssFeedManager rssFeedManager = new EfoodLetterRssFeedManager();

    /*
     * How many entries do we want to show.
     */
    private Long sizeLimit = new Long(5);

//    private MenuMineSessionContextWrapper menuMineSessionContextWrapper;

    private Collection rssEntries = new ArrayList();

    public String execute() throws Exception {

        try {
            Collection allRssEntries = this.getRssFeedManager().getEntries();
            this.setRssEntries(allRssEntries);
        } catch (EfoodLetterRssException e) {
            rssEntries = null;
        }

        return SUCCESS;
    }

//    public MenuMineSessionContextWrapper getMenuMineSessionContextWrapper() {
//        return menuMineSessionContextWrapper;
//    }
//
//    public void setMenuMineSessionContextWrapper(
//            MenuMineSessionContextWrapper menuMineSessionContextWrapper) {
//        this.menuMineSessionContextWrapper = menuMineSessionContextWrapper;
//    }

    public boolean isRssAvailable() {
        return (this.getRssEntries() != null && this.getRssEntries().size() > 0);
    }

    public EfoodLetterRssFeedManager getRssFeedManager() {
        return rssFeedManager;
    }

    public void setRssFeedManager(EfoodLetterRssFeedManager rssFeedManager) {
        this.rssFeedManager = rssFeedManager;
    }

    public Collection getRssEntries() {
        return rssEntries;
    }

    public void setRssEntries(Collection rssEntries) {
        if (this.getSizeLimit().longValue() > 0) {
            ArrayList list = new ArrayList();
            list.addAll(rssEntries);

            this.rssEntries = list.subList(0, Math.min(list.size(), this
                    .getSizeLimit().intValue()));
        } else {
            this.rssEntries = rssEntries;
        }

        this.rssEntries = rssEntries;
    }

    public Long getSizeLimit() {
        return sizeLimit;
    }

    public void setSizeLimit(Long sizeLimit) {
        this.sizeLimit = sizeLimit;
    }
}