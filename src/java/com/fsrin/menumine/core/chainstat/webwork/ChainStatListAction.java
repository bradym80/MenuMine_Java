/*
 * Created on 2005-1-18
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.fsrin.menumine.core.chainstat.webwork;

import java.util.Collection;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.logging.LogFactory;

import com.fsrin.menumine.context.webwork.AbstractMenuMineSessionContextAwareAction;
import com.fsrin.menumine.core.chainstat.ChainStatFilterParameters;
import com.fsrin.menumine.core.chainstat.ChainStatSearchException;
import com.fsrin.menumine.core.chainstat.ChainStatServiceDelegate;

/**
 * @author Nick
 * @version 1
 */

public class ChainStatListAction extends AbstractMenuMineSessionContextAwareAction {

//    private MenuMineSessionContextWrapper menuMineSessionContextWrapper;

    private ChainStatFilterParameters chainStatFilterParameters = new ChainStatFilterParameters();

    private ChainStatServiceDelegate chainStatServiceDelegate;

    private String submit;

    private String back;

    public static final String SPRING_BEAN_NAME = "chainStatListAction";

    public String execute() throws Exception {

        if (this.getSubmit() != null) {
            this
                    .getMenuMineSessionContextWrapper()
                    .setLastChainStatFilterParameters(chainStatFilterParameters);
        } else {
            if (this.getMenuMineSessionContextWrapper()
                    .getLastChainStatFilterParameters() != null) {
                chainStatFilterParameters = this
                        .getMenuMineSessionContextWrapper()
                        .getLastChainStatFilterParameters();
            }
        }

        return SUCCESS;
    }

    public Collection getList() {

        if (this.getSubmit() == null && this.getBack() == null) {
            return null;
        }

        try {
            return this.getChainStatServiceDelegate().find(
                    this.getChainStatFilterParameters());
        } catch (ChainStatSearchException e) {
            LogFactory.getLog(this.getClass().getName()).info(
                    "Error Searching for ChainStat! "
                            + ToStringBuilder.reflectionToString(this
                                    .getChainStatFilterParameters()));
            LogFactory.getLog(this.getClass().getName()).info(
                    e.getMessage() + " : " + e.getStackTrace());
            e.printStackTrace();
            this.addActionError("Error searching for ChainStat.");
            return null;
        }

    }

    public Collection getDistinctSegments() {

        return this.getChainStatServiceDelegate().getDistinctSegments();
    }

    public Collection getDistinctSectorNames() {

        return this.getChainStatServiceDelegate().getDistinctSectorNames();

    }

    public Collection getDistinctOperationNames() {

        return this.getChainStatServiceDelegate().getDistinctOperationNames();

    }

    public ChainStatFilterParameters getChainStatFilterParameters() {
        return chainStatFilterParameters;
    }

    public void setChainStatFilterParameters(
            ChainStatFilterParameters chainStatFilterParameters) {
        this.chainStatFilterParameters = chainStatFilterParameters;
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

    public String getSubmit() {
        return submit;
    }

    public void setSubmit(String submit) {
        this.submit = submit;
    }

    public String getBack() {
        return back;
    }

    public void setBack(String back) {
        this.back = back;
    }
}