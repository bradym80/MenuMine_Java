/*
 * Created on Apr 5, 2005
 *
 * 
 */
package com.fsrin.menumine.core.profiler.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import junit.framework.TestCase;

import com.fsrin.menumine.core.menumine.chain.ChainDao;
import com.fsrin.menumine.core.profiler.ProfileDao;
import com.fsrin.menumine.core.profiler.ProfileOperationAggregation;
import com.fsrin.menumine.core.profiler.ProfileServiceDelegate;
import com.fsrin.menumine.core.profiler.Profiler;
import com.fsrin.menumine.core.profiler.ProfilerImpl;
import com.fsrin.menumine.core.profiler.aggregation.Profile;

/**
 * @author Nick
 * @version 2005-4-5
 * 
 * This tests the profiler with data from the masterfood table.
 */
public class MasterFoodProfileTest extends TestCase {

    private Profiler masterFoodProfiler;

    protected void setUp() throws Exception {
        super.setUp();

        masterFoodProfiler = new ProfilerImpl();


    }

    public void testMasterFoodProfile() throws Exception {

        ProfileDao dao = new MockMasterFood50GarlicDao();

        ProfileServiceDelegate sd = new ProfileServiceDelegate();
        sd.setDao(dao);

        ChainDao chainDao = new MockChainDao();

        masterFoodProfiler.setServiceDelegate(sd);
        masterFoodProfiler.setChainDao(chainDao);

        Collection profile = new ArrayList();
        Profile p1 = new MasterFoodToppingFilledIngredProfile();
        Profile p2 = new MasterFoodSeasoningProfile();
        profile.add(p1);
        profile.add(p2);

        masterFoodProfiler.setProfile(profile);
        
        masterFoodProfiler.runProfile("Garlic");

        Collection applications = masterFoodProfiler.getApplications();
        assertEquals(2, applications.size());
        for (Iterator iter = applications.iterator(); iter.hasNext();) {
            Profile element = (Profile) iter.next();
            assertEquals(25, element.getNumberOfApplications());
            assertEquals(.50, element.getApplicationShare(), 0.01);
            assertEquals(5, element.getNumberOfOperationsUsing());
            assertEquals(5, element.getNumberOfApplicationsPerOperator(), 0.1);

        }

        ProfileOperationAggregation operationProfile = masterFoodProfiler
                .getProfileOperationAggregation();
        assertEquals(12, operationProfile.getNumberOfOperatorsInMenuMine());
        assertEquals(5, operationProfile.getNumberOfOperatorsUsingIngredient());
        assertEquals(.41666, operationProfile.getIngredientPenetration(), 0.01);
        assertEquals(50, operationProfile.getTotalApplications());
        assertEquals(10, operationProfile.getApplicationsPerOperator(), 0.01);

        Collection operationShare = masterFoodProfiler.getOperationProfile()
                .getOperations();
        assertEquals(5, operationShare.size());
        for (Iterator iter = operationShare.iterator(); iter.hasNext();) {
            Profile share = (Profile) iter.next();
            assertEquals(10, share.getNumberOfApplications());
            assertEquals(0.2, share.getApplicationShare(), 0.01);
        }
        Collection segmentShare = masterFoodProfiler.getSegmentProfile()
                .getSegments();
        assertEquals(1, segmentShare.size());
        for (Iterator iter = segmentShare.iterator(); iter.hasNext();) {
            Profile share = (Profile) iter.next();
            assertEquals(50, share.getNumberOfApplications());
            assertEquals(1.0, share.getApplicationShare(), 0.01);
        }
        Collection sectorShare = masterFoodProfiler.getSectorProfile()
                .getSectors();
        assertEquals(1, sectorShare.size());
        for (Iterator iter = sectorShare.iterator(); iter.hasNext();) {
            Profile share = (Profile) iter.next();
            assertEquals(50, share.getNumberOfApplications());
            assertEquals(1.0, share.getApplicationShare(), 0.01);
        }

    }
    
    public void testMasterFoodProfileWithNullsOperationName() throws Exception {

        ProfileDao dao = new MockMasterFood50GarlicDaoWithNullChainNames();

        ProfileServiceDelegate sd = new ProfileServiceDelegate();
        sd.setDao(dao);

        ChainDao chainDao = new MockChainDao();

        masterFoodProfiler.setServiceDelegate(sd);
        masterFoodProfiler.setChainDao(chainDao);

        Collection profile = new ArrayList();
        Profile p1 = new MasterFoodToppingFilledIngredProfile();
        Profile p2 = new MasterFoodSeasoningProfile();
        profile.add(p1);
        profile.add(p2);

        masterFoodProfiler.setProfile(profile);
        
        masterFoodProfiler.runProfile("Garlic");

        Collection applications = masterFoodProfiler.getApplications();
        assertEquals(2, applications.size());
        for (Iterator iter = applications.iterator(); iter.hasNext();) {
            Profile element = (Profile) iter.next();
            assertEquals(25, element.getNumberOfApplications());
            assertEquals(.50, element.getApplicationShare(), 0.01);
            /*
             * 3 named, one "N/A"
             */
            assertEquals(4, element.getNumberOfOperationsUsing());
            assertEquals(6.25, element.getNumberOfApplicationsPerOperator(), 0.1);

        }

        ProfileOperationAggregation operationProfile = masterFoodProfiler
                .getProfileOperationAggregation();
        assertEquals(12, operationProfile.getNumberOfOperatorsInMenuMine());
        
        assertEquals(4, operationProfile.getNumberOfOperatorsUsingIngredient());
        assertEquals(.3333, operationProfile.getIngredientPenetration(), 0.01);
        assertEquals(50, operationProfile.getTotalApplications());
        assertEquals(12.5, operationProfile.getApplicationsPerOperator(), 0.01);



    }

    public void testMasterFoodProfileWithNullsSector() throws Exception {
    
        ProfileDao dao = new MockMasterFood50GarlicDaoWithNullSector();
    
        ProfileServiceDelegate sd = new ProfileServiceDelegate();
        sd.setDao(dao);
    
        ChainDao chainDao = new MockChainDao();
    
        masterFoodProfiler.setServiceDelegate(sd);
        masterFoodProfiler.setChainDao(chainDao);
    
        Collection profile = new ArrayList();
        Profile p1 = new MasterFoodToppingFilledIngredProfile();
        Profile p2 = new MasterFoodSeasoningProfile();
        profile.add(p1);
        profile.add(p2);
    
        masterFoodProfiler.setProfile(profile);
        
        masterFoodProfiler.runProfile("Garlic");
    
        assertEquals(masterFoodProfiler.getSectorProfile().getSectors().size(),2);
        

    
    }
    
    public void testMasterFoodProfileWithNullsSegment() throws Exception {
        
        ProfileDao dao = new MockMasterFood50GarlicDaoWithNullSegment();
    
        ProfileServiceDelegate sd = new ProfileServiceDelegate();
        sd.setDao(dao);
    
        ChainDao chainDao = new MockChainDao();
    
        masterFoodProfiler.setServiceDelegate(sd);
        masterFoodProfiler.setChainDao(chainDao);
    
        Collection profile = new ArrayList();
        Profile p1 = new MasterFoodToppingFilledIngredProfile();
        Profile p2 = new MasterFoodSeasoningProfile();
        profile.add(p1);
        profile.add(p2);
    
        masterFoodProfiler.setProfile(profile);
        
        masterFoodProfiler.runProfile("Garlic");
    
        assertEquals(masterFoodProfiler.getSegmentProfile().getSegments().size(),2);
        

    
    }

}