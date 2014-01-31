/*
 * Created on Mar 8, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine;

import junit.framework.TestCase;

import com.fsrin.menumine.common.SpringBeanBroker;

/**
 * @author Nick
 * 
 *  
 */
public class SampleDistributionServiceDelegateTest extends TestCase {

    public SampleDistributionServiceDelegate getSampleDistributionServiceDelegate() {
        return (SampleDistributionServiceDelegate) SpringBeanBroker
                .getBeanFactory().getBean(
                        SampleDistributionServiceDelegate.SPRING_BEAN_NAME);
    }

    protected void setUp() throws Exception {
        super.setUp();
//        JunitSettings.initilizeTestSystem();
    }

    /*
     * This test is slow and we are not using it right now.
     */
    public void testBasicProteinDistribution() throws Exception {
        //        StatisticalTable col = this.getSampleDistributionServiceDelegate()
        //                .getBasicProteinDistribution();
        //
        //        for (Iterator iter = col.getRows().iterator(); iter.hasNext();) {
        //            StatisticalTableElement element = (StatisticalTableElement) iter
        //                    .next();
        //            System.out
        //                    .println(element.getName() + " : " + element.getPercent());
        //        }

    }

}