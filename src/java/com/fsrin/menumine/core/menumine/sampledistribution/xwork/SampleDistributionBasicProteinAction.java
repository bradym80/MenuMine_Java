/*
 * Created on Mar 9, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.sampledistribution.xwork;

import ognl.OgnlException;

import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableIF;

/**
 * @author Nick
 * 
 *  
 */
public class SampleDistributionBasicProteinAction extends
        SampleDistributionAction  {

    public StatisticalTableIF getStatisticalTableResults() throws OgnlException {
        StatisticalTableIF sampleDist = this
                .getSampleDistributionServiceDelegate()
                .getBasicProteinDistribution();
        return sampleDist;
    }

}