/*
 * Created on 2005-1-18
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.fsrin.menumine.core.chainrss.xwork;

import java.util.ArrayList;
import java.util.Collection;

import com.fsrin.menumine.context.webwork.MenuMineSessionContextWrapper;
import com.fsrin.menumine.context.webwork.MenuMineSessionContextWrapperAware;
import com.fsrin.menumine.core.chainrss.ChainRssException;
import com.fsrin.menumine.core.chainrss.ChainRssFeedManager;
import com.fsrin.menumine.core.chainstat.ChainStat;
import com.fsrin.menumine.core.chainstat.ChainStatServiceDelegate;
import com.fsrin.menumine.core.chainstat.ChainStatServiceDelegateException;
import com.opensymphony.xwork.ActionSupport;

/**
 * @author Nick
 * @version 1
 */

public class ChainStatRssAction extends ActionSupport implements
        MenuMineSessionContextWrapperAware {

    private ChainRssFeedManager rssFeedManager;

    private MenuMineSessionContextWrapper menuMineSessionContextWrapper;

    private ChainStatServiceDelegate chainStatServiceDelegate;

    private Long target;

    private Collection rssEntries = new ArrayList();

    public static final String SPRING_BEAN_NAME = "chainStatDetailAction";

    public String execute() throws Exception {
        if (this.getChainStat() == null) {
            this.addActionError("Error finding Chain Stat Detail");
        }

        /*
         * Find the files.
         */
        try {
            rssEntries = this.getRssFeedManager().getEntries(
                    this.getChainStat());
        } catch (ChainRssException e) {
            rssEntries = null;
        }

        return SUCCESS;
    }

    private ChainStat cs;

    public ChainStat getChainStat() {

        try {
            if (cs == null) {
                cs = this.getChainStatServiceDelegate().getById(
                        this.getTarget());
            }
            return cs;
        } catch (ChainStatServiceDelegateException e) {
            e.printStackTrace();
            LOG.info("Error getting Detail for ChainStat:  id="
                    + this.getTarget() + e.getMessage() + " : "
                    + e.getStackTrace());

            return null;
        }

    }

    public MenuMineSessionContextWrapper getMenuMineSessionContextWrapper() {
        return menuMineSessionContextWrapper;
    }

    public void setMenuMineSessionContextWrapper(
            MenuMineSessionContextWrapper menuMineSessionContextWrapper) {
        this.menuMineSessionContextWrapper = menuMineSessionContextWrapper;
    }

    public ChainStatServiceDelegate getChainStatServiceDelegate() {
        return chainStatServiceDelegate;
    }

    public void setChainStatServiceDelegate(
            ChainStatServiceDelegate chainStatServiceDelegate) {
        this.chainStatServiceDelegate = chainStatServiceDelegate;
    }

    public Long getTarget() {
        return target;
    }

    public void setTarget(Long target) {
        this.target = target;
    }

    public boolean isRssAvailable() {
        return (this.getRssEntries() != null && this.getRssEntries().size() > 0);
    }

    public ChainRssFeedManager getRssFeedManager() {
        return rssFeedManager;
    }

    public void setRssFeedManager(ChainRssFeedManager rssFeedManager) {
        this.rssFeedManager = rssFeedManager;
    }

    public Collection getRssEntries() {
        return rssEntries;
    }

    public void setRssEntries(Collection rssEntries) {
        this.rssEntries = rssEntries;
    }
}