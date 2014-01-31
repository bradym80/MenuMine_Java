/*
 * Created on 2005-1-18
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.fsrin.menumine.core.chainstat.webwork;

import java.util.ArrayList;
import java.util.Collection;

import com.fsrin.menumine.context.webwork.AbstractMenuMineSessionContextAwareAction;
import com.fsrin.menumine.core.chainstat.ChainStat;
import com.fsrin.menumine.core.chainstat.ChainStatServiceDelegate;
import com.fsrin.menumine.core.chainstat.ChainStatServiceDelegateException;
import com.fsrin.menumine.core.menucam.MenuCamManager;

/**
 * @author Nick
 * @version 1
 */

public class ChainStatMenuCamAction extends AbstractMenuMineSessionContextAwareAction {

    private MenuCamManager menuCamManager;

//    private MenuMineSessionContextWrapper menuMineSessionContextWrapper;

    private ChainStatServiceDelegate chainStatServiceDelegate;

    private Long target;

    private Collection files = new ArrayList();

    public static final String SPRING_BEAN_NAME = "chainStatDetailAction";

    public String execute() throws Exception {
        if (this.getChainStat() == null) {
            this.addActionError("Error finding Chain Stat Detail");
        }

        /*
         * Find the files.
         */
        files = this.getMenuCamManager().getFiles(this.getChainStat());

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

//    public MenuMineSessionContextWrapper getMenuMineSessionContextWrapper() {
//        return menuMineSessionContextWrapper;
//    }
//
//    public void setMenuMineSessionContextWrapper(
//            MenuMineSessionContextWrapper menuMineSessionContextWrapper) {
//        this.menuMineSessionContextWrapper = menuMineSessionContextWrapper;
//    }

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

    public boolean isMenuCamAvailable() {
        return (this.getFiles() != null && this.getFiles().size() > 0);
    }

    public Collection getFiles() {
        return files;
    }

    public void setFiles(Collection files) {
        this.files = files;
    }

    public MenuCamManager getMenuCamManager() {
        return menuCamManager;
    }

    public void setMenuCamManager(MenuCamManager menuCamManager) {
        this.menuCamManager = menuCamManager;
    }
}