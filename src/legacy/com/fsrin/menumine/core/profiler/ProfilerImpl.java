/*
 * Created on Apr 5, 2005
 *
 * 
 */
package com.fsrin.menumine.core.profiler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;

import com.fsrin.menumine.common.webwork.MMSorter;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;
import com.fsrin.menumine.core.menumine.chain.ChainDao;
import com.fsrin.menumine.core.menumine.chain.ChainFilterParameters;
import com.fsrin.menumine.core.menumine.express.util.SearchableTokenBuilder;
import com.fsrin.menumine.core.menumine.masterfood.MasterFoodServiceDelegateFactory;
import com.fsrin.menumine.core.profiler.aggregation.Profile;

/**
 * @author Nick
 * 
 * 
 */
public class ProfilerImpl implements Profiler {

    private ProfileServiceDelegate serviceDelegate;

    private ChainDao chainDao;

    private Collection profile;

    private Collection applications;

    private long totalApplications = 0;

    private SegmentProfile segmentProfile = new SegmentProfile();

    private SectorProfile sectorProfile = new SectorProfile();

    private OperationProfile operationProfile = new OperationProfile();

    private String searchString;

    private ProfileOperationAggregation profileOperationAggregation;

    private Collection targetFields;
    
    private MasterFoodFilterParameters masterFoodFilterParameters;

    public MasterFoodFilterParameters getMasterFoodFilterParameters() {
        return masterFoodFilterParameters;
    }

    public void setMasterFoodFilterParameters(
            MasterFoodFilterParameters masterFoodFilterParameters) {
        this.masterFoodFilterParameters = masterFoodFilterParameters;
    }

    public ProfileServiceDelegate getServiceDelegate() {
        return serviceDelegate;
    }

    public void setServiceDelegate(ProfileServiceDelegate serviceDelegate) {
        this.serviceDelegate = serviceDelegate;
    }

    public Collection getProfile() {
        return profile;
    }

    public void setProfile(Collection profile) {
        this.profile = profile;
    }

    public void runProfile(String _searchString) throws Exception {

        this.getServiceDelegate().getDao().setTargetFields(this.getTargetFields());

        searchString = _searchString.trim();
        /*
         * The profiles must be able to callback to get the total;
         */
        for (Iterator iter = this.getProfile().iterator(); iter.hasNext();) {
            Profile element = (Profile) iter.next();
            element.setProfiler(this);
        }
        segmentProfile.setProfiler(this);
        sectorProfile.setProfiler(this);
        operationProfile.setProfiler(this);

        /*
         * 2006-04-20 RSC This is the old system. It uses abbreviated objects to
         * find results. The goal is to switch to the standard MasterFood and
         * HQL
         * 
         * The old system basically build a list of single terms (like express
         * query) and then ANDs them.
         */
        // ProfileParameters params = new ProfileParametersImpl();
        // params.setSearchString(searchString);
        // Collection results = this.getServiceDelegate().find(params);
        // build a MasterFoodFilterParameters
        Collection searchableTokens = new SearchableTokenBuilder().buildSearchableToken(searchString);
        
        MasterFoodFilterParameters p = new ProfilerMasterFoodFilterParametersBuilder()
                .build(searchableTokens, this.getTargetFields());
        this.setMasterFoodFilterParameters(p);
        
        // run the query.
        Collection results = MasterFoodServiceDelegateFactory.factory.build()
                .searchMasterFoodByHQLDisjunction(p);

        this.setTotalApplications(results.size());
        for (Iterator iter = results.iterator(); iter.hasNext();) {
            /*
             * This is some object that we can profile against. It may me
             * Flavor, MasterFood, Desert ....
             */
            Object element = (Object) iter.next();
            for (Iterator iterator = this.getProfile().iterator(); iterator
                    .hasNext();) {
                Profile profile = (Profile) iterator.next();

                /*
                 * Test and record if this profile matches the search.
                 */
                profile.profile(element, searchableTokens);
            }

            segmentProfile.add(element);
            sectorProfile.add(element);

            operationProfile.add(element);

        }

        Collection table = new TreeSet(new TreeSet(new MMSorter()
                .getDescending("numberOfApplications", "name")));

        table.addAll(this.profile);

        this.applications = table;
    }

    public Collection getApplications() {

        return this.applications;
    }

    public ProfileOperationAggregation getProfileOperationAggregation() {
        if (profileOperationAggregation == null) {

            long numberOfChains = this.getNumberOfChainsInMenuMine();
            long numgerInMenuMine = this.getOperationProfile().getOperations()
                    .size();
            long total = this.getTotalApplications();
            profileOperationAggregation = new ProfileOperationAggregation(
                    numberOfChains, numgerInMenuMine, total);

        }
        return profileOperationAggregation;

    }

    private long getNumberOfChainsInMenuMine() {
        Collection col = chainDao.find(new ChainFilterParameters());
        return col.size();
    }

    public OperationProfile getOperationProfile() {

        return this.operationProfile;
    }

    public SegmentProfile getSegmentProfile() {

        return this.segmentProfile;
    }

    public SectorProfile getSectorProfile() {

        return this.sectorProfile;
    }

    public long getTotalApplications() {

        return this.totalApplications;
    }

    public ChainDao getChainDao() {
        return chainDao;
    }

    public void setChainDao(ChainDao chainDao) {
        this.chainDao = chainDao;
    }

    public void setApplications(Collection applications) {
        this.applications = applications;
    }

    public void setTotalApplications(long totalApplications) {
        this.totalApplications = totalApplications;
    }

    public String getSearchString() {

        return this.searchString;
    }

    public Collection getTargetFields() {
//        if (targetFields == null) {
//            /*
//             * 2006-04-19 RSC First thing is to get the fields
//             */
//            targetFields = new ArrayList();
//            for (Iterator iter = this.profile.iterator(); iter.hasNext();) {
//                Profile element = (Profile) iter.next();
//                targetFields.add(element.getFieldEnum());
//            }
//            
//        }
        return targetFields;
    }

    public void setTargetFields(Collection targetFields) {
        this.targetFields = targetFields;
    }
}