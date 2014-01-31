/*
 * Created on Apr 5, 2005
 *
 * 
 */
package com.fsrin.menumine.core.profiler;

import java.util.Collection;
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
public class OperationProfile {

    private Profiler profiler;

    private TreeMap operations = new TreeMap();

    public void add(Object element) {
        if (element instanceof AbstractChainInformationBean) {
            // Chain chain = ((ChainAware) element).getChain();
            AbstractChainInformationBean food = (AbstractChainInformationBean) element;

            String key = food.getOperationName();
            
            if (key == null)
                key = AbstractChainInformationBean.UNKNOWN_OPERATION_KEY;

            if (operations.containsKey(key)) {
                Profile profile = (Profile) operations.get(key);
                profile.profile(element, null);
            } else {
                Profile profile = new GenericProfile(key);
                profile.setProfiler(this.profiler);
                profile.profile(element, null);

                operations.put(key, profile);

            }

        } else {
            throw new RuntimeException("can't profile operation "
                    + element.getClass().getName());
        }

    }

    public Collection getOperations() {
        TreeSet set = new TreeSet(new MMSorter().getDescending(
                "applicationShare", "key"));
        set.addAll(operations.values());
        return set;
    }

    public void setProfiler(Profiler profiler) {
        this.profiler = profiler;
    }
}