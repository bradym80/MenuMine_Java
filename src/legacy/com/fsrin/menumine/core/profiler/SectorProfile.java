/*
 * Created on Apr 5, 2005
 *
 * 
 */
package com.fsrin.menumine.core.profiler;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

import com.fsrin.menumine.common.webwork.MMSorter;
import com.fsrin.menumine.core.menumine.chain.AbstractChainInformationBean;
import com.fsrin.menumine.core.profiler.aggregation.Profile;

/**
 * @author Nick
 * 
 *  
 */
public class SectorProfile {

    private Profiler profiler;
    
    private Map sectors = new TreeMap();

    public void add(Object element) {
//        if (element instanceof ChainAware) {
//            Chain chain = ((ChainAware) element).getChain();
//
//            String key = chain.getSectorName();
        if (element instanceof AbstractChainInformationBean) {
            AbstractChainInformationBean food = (AbstractChainInformationBean) element;
            
            String key = food.getSectorName();
            if (key == null) {
                key = AbstractChainInformationBean.UNKNOWN_SEGMENT_KEY;
            }

            if (sectors.containsKey(key)) {
                Profile profile = (Profile) sectors.get(key);
                profile.profile(element, null);
            } else {
                Profile profile = new GenericProfile(key);
                profile.setProfiler(this.profiler);
                profile.profile(element, null);

                sectors.put(key, profile);

            }

        }

    }

    public Collection getSectors() {
        TreeSet set = new TreeSet(new MMSorter().getDescending(
                "applicationShare", "key"));
        set.addAll(sectors.values());

        return set;
    }

    

    public void setProfiler(Profiler profiler) {
        this.profiler = profiler;
    }
}