/*
 * Created on 2005-1-18
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.fsrin.menumine.core.chainstat.webwork;

import com.fsrin.menumine.context.webwork.AbstractMenuMineSessionContextAwareAction;
import com.fsrin.menumine.core.chainstat.ChainStat;
import com.fsrin.menumine.core.chainstat.ChainStatServiceDelegate;
import com.fsrin.menumine.core.chainstat.ChainStatServiceDelegateException;

/**
 * @author Nick
 * @version 1
 */

public class ChainStatDetailAction extends AbstractMenuMineSessionContextAwareAction {

//    private MenuMineSessionContextWrapper menuMineSessionContextWrapper;

    private ChainStatServiceDelegate chainStatServiceDelegate;

    private Long target;
    
    private ChainStat cs;

    // private Collection files = new ArrayList();

    public static final String SPRING_BEAN_NAME = "chainStatDetailAction";

    public String execute() throws Exception {
    	//this.getMenuMineSessionContextWrapper().setExcel(true);
        if (this.getChainStat() == null) {
            this.addActionError("Error finding Chain Stat Detail");
        }

        	
        return SUCCESS;
    }

    

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

    //    public Collection getFiles() {
    //        return files;
    //    }
    //
    //    public void setFiles(Collection files) {
    //        this.files = files;
    //    }
}