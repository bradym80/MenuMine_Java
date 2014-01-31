/*
 * Created on Mar 14, 2005
 *
 * 
 */
package com.fsrin.menumine.core.incidence;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import com.fsrin.menumine.core.menumine.chain.AbstractChainInformationBean;
import com.fsrin.menumine.core.menumine.chain.Chain;
import com.fsrin.menumine.core.menumine.masterfood.MasterFood;

/**
 * @author Nick
 * 
 *  
 */
public class IncidenceSectorStandardImpl implements IncidenceSector {

    private static final String N_A = "N/A";

    private String name;

    private HashMap incidenceSegments = new HashMap();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection getIncidenceSegments() {
        return incidenceSegments.values();
    }

    public void initChain(Chain chain) {
        IncidenceSegmentStandardImpl segment = null;

        String key = N_A;
        
        if (chain != null && chain.getSegment() != null
                && chain.getSegment().length() != 0) {
            key = chain.getSegment();
        }

        if (incidenceSegments.containsKey(key)) {
            segment = (IncidenceSegmentStandardImpl) incidenceSegments.get(key);
        } else {
            segment = new IncidenceSegmentStandardImpl();
            segment.setName(chain.getSegment());
            incidenceSegments.put(key, segment);
        }

        segment.initChain(chain);

    }
    
    public void initChain(AbstractChainInformationBean chain) {
        IncidenceSegmentStandardImpl segment = null;

        String key = N_A;
        
        if (chain != null && chain.getSegment() != null
                && chain.getSegment().length() != 0) {
            key = chain.getSegment();
        }

        if (incidenceSegments.containsKey(key)) {
            segment = (IncidenceSegmentStandardImpl) incidenceSegments.get(key);
        } else {
            segment = new IncidenceSegmentStandardImpl();
            segment.setName(chain.getSegment());
            incidenceSegments.put(key, segment);
        }

        segment.initChain(chain);

    }

    public int getNumberOfChains() {
        int count = 0;
        for (Iterator iter = this.getIncidenceSegments().iterator(); iter
                .hasNext();) {
            IncidenceSegment element = (IncidenceSegment) iter.next();
            count += element.getNumberOfChains();
        }
        return count;
    }

    public int getNumberOfChainsMenuingItems() {
        int count = 0;
        for (Iterator iter = this.getIncidenceSegments().iterator(); iter
                .hasNext();) {
            IncidenceSegment element = (IncidenceSegment) iter.next();
            count += element.getNumberOfChainsMenuingItems();
        }
        return count;
    }

    public double getCategoryIncidence() {
        double menuing = this.getNumberOfChainsMenuingItems();
        double chains = this.getNumberOfChains();
        return (menuing / chains) * 100.0;
    }

    public double getNumberOfItemsPerChainMenued() {

        double items = this.getNumberOfItemsBeingMenued();
        double chains = this.getNumberOfChainsMenuingItems();

        if (chains == 0.0) {
            return 0.0;
        }
        return items / chains;
    }

    public int getNumberOfItemsBeingMenued() {

        int count = 0;
        for (Iterator iter = incidenceSegments.values().iterator(); iter
                .hasNext();) {
            IncidenceSegment element = (IncidenceSegment) iter.next();
            count += element.getNumberOfItemsBeingMenued();
        }

        return count;
    }

    public void addMasterFood(MasterFood masterFood) {

        IncidenceSegmentStandardImpl segment = null;
        String key = N_A;
//        if (masterFood.getChain() != null
//                && masterFood.getChain().getSegment() != null) {
//            key = masterFood.getChain().getSegment();
//        }
        
        if (masterFood.getSegment() != null) {
            key = masterFood.getSegment();
        }

        if (incidenceSegments.containsKey(key)) {
            segment = (IncidenceSegmentStandardImpl) incidenceSegments.get(key);
        } else {
            segment = new IncidenceSegmentStandardImpl();
            segment.setName(key);
            incidenceSegments.put(key, segment);
        }

        segment.addMasterFood(masterFood);
    }
}