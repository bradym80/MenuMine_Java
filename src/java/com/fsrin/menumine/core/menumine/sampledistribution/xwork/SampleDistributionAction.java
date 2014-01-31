/*
 * Created on Mar 9, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.sampledistribution.xwork;

import ognl.OgnlException;

import com.fsrin.menumine.context.webwork.AbstractMenuMineSessionContextAwareAction;
import com.fsrin.menumine.core.menumine.SampleDistributionServiceDelegate;
import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableIF;

/**
 * @author Nick
 * 
 *  
 */
public abstract class SampleDistributionAction extends AbstractMenuMineSessionContextAwareAction {

//    private MenuMineSessionContextWrapper menuMineSessionContextWrapper;

    private SampleDistributionServiceDelegate sampleDistributionServiceDelegate;

    public String execute() throws Exception {

        return SUCCESS;
    }

    public abstract StatisticalTableIF getStatisticalTableResults()
            throws OgnlException;

//    public MenuMineSessionContextWrapper getMenuMineSessionContextWrapper() {
//        return menuMineSessionContextWrapper;
//    }
//
//    public void setMenuMineSessionContextWrapper(
//            MenuMineSessionContextWrapper menuMineSessionContextWrapper) {
//        this.menuMineSessionContextWrapper = menuMineSessionContextWrapper;
//    }

    public SampleDistributionServiceDelegate getSampleDistributionServiceDelegate() {
        return sampleDistributionServiceDelegate;
    }

    public void setSampleDistributionServiceDelegate(
            SampleDistributionServiceDelegate sampleDistributionServiceDelegate) {
        this.sampleDistributionServiceDelegate = sampleDistributionServiceDelegate;
    }

    public Integer getCount() {
        return this.getSampleDistributionServiceDelegate().getCount();

    }

}