/*
 * Created on Oct 5, 2004
 *
 * 
 */
package com.fsrin.menumine.core.menumine;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author Nick
 * 
 * This is used in the initialization of the SampleDistributions across the
 * entire dataset. We want to init in the background to save time when loading.
 * 
 * 2006-01-20 RSC Entire Execute Method Commented Out
 * 
 */

public class SampleDistributionInitializerProxy {

    private SampleDistributionServiceDelegate sampleDistributionServiceDelegate;

    public static String SPRING_BEAN_NAME = "sampleDistributionInitializerProxy";

    /*
     * (non-Javadoc)
     * 
     * @see org.quartz.Job#execute(org.quartz.JobExecutionContext)
     */
    // public void schedule(CmmsSessionContext cmmsSessionContext) {
    public void execute() {
        //                sampleDistributionServiceDelegate =
        //         (SampleDistributionServiceDelegate) SpringBeanBroker
        //                        .getBeanFactory().getBean(
        //                                SampleDistributionServiceDelegate.SPRING_BEAN_NAME);
        //
        //        
        //                try {
        //                    sampleDistributionServiceDelegate.getBasicProteinDistribution();
        //                } catch (OgnlException e) {
        //                    e.printStackTrace();
        //                }

        //        
        //                try {
        //                    sampleDistributionServiceDelegate.getCookingMethodDistribution();
        //                } catch (OgnlException e) {
        //                    e.printStackTrace();
        //                }

        //        
        //                try {
        //                    sampleDistributionServiceDelegate.getCuisineFamilyDistribution();
        //                } catch (OgnlException e) {
        //                    e.printStackTrace();
        //                }

        //        
        //                try {
        //                    sampleDistributionServiceDelegate.getCuisineOfItemDistribution();
        //                } catch (OgnlException e) {
        //                    e.printStackTrace();
        //                }

        //        
        //                try {
        //                    sampleDistributionServiceDelegate.getGenCookingMethodDistribution();
        //                } catch (OgnlException e) {
        //                    e.printStackTrace();
        //                }

        //        
        //                try {
        //                    sampleDistributionServiceDelegate.getMarketSectorDistribution();
        //                } catch (OgnlException e) {
        //                    e.printStackTrace();
        //                }
        //

        //                try {
        //            sampleDistributionServiceDelegate.getMarketSegmentDistribution();
        //        } catch (OgnlException e) {
        //            e.printStackTrace();
        //        }
        //
        //        try {
        //            sampleDistributionServiceDelegate.getMenuPartDistribution();
        //        } catch (OgnlException e) {
        //            e.printStackTrace();
        //        }
        //
        //        try {
        //            sampleDistributionServiceDelegate.getOperationNameDistribution();
        //        } catch (OgnlException e) {
        //            e.printStackTrace();
        //        }

    }

    private Log log = LogFactory
            .getLog(SampleDistributionInitializerProxy.class);

    public SampleDistributionServiceDelegate getSampleDistributionServiceDelegate() {
        return sampleDistributionServiceDelegate;
    }

    public void setSampleDistributionServiceDelegate(
            SampleDistributionServiceDelegate sampleDistributionServiceDelegate) {
        this.sampleDistributionServiceDelegate = sampleDistributionServiceDelegate;
    }
}