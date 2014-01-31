/*
 * Created on Apr 5, 2005
 *
 * 
 */
package com.fsrin.menumine.core.profiler;

import java.util.Collection;

import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;
import com.fsrin.menumine.core.menumine.chain.ChainDao;

/**
 * @author Nick
 * 
 *  
 */

public interface Profiler {

    public void setServiceDelegate(ProfileServiceDelegate sd);

    public void setChainDao(ChainDao chainDao);

    public void setProfile(Collection profile);

    public void runProfile(String string) throws Exception;

    public String getSearchString();

    public Collection getApplications();

    public ProfileOperationAggregation getProfileOperationAggregation();

    public OperationProfile getOperationProfile();

    public SegmentProfile getSegmentProfile();

    public SectorProfile getSectorProfile();

    public long getTotalApplications();
    
    public Collection getTargetFields();
    
    public MasterFoodFilterParameters getMasterFoodFilterParameters();

}