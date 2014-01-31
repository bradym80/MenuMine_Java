/*
 * Created on Mar 14, 2005
 *
 * 
 */
package com.fsrin.menumine.core.incidence;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fsrin.menumine.common.webwork.MMSorter;
import com.fsrin.menumine.core.menumine.chain.AbstractChainInformationBean;
import com.fsrin.menumine.core.menumine.chain.Chain;
import com.fsrin.menumine.core.menumine.masterfood.MasterFood;

/**
 * @author Nick
 * 
 * 
 */
public class IncidenceSegmentStandardImpl implements IncidenceSegment {

    private String name;

    private HashMap incidenceChains = new HashMap();
    
    private static Log log = LogFactory.getLog(IncidenceSegmentStandardImpl.class);

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
        for (Iterator iter = incidenceChains.values().iterator(); iter
                .hasNext();) {
            IncidenceChain element = (IncidenceChain) iter.next();
            count += element.getNumberOfItemsMenued();
        }

        return count;

    }

    public int getNumberOfChainsMenuingItems() {
        int count = 0;
        for (Iterator iter = incidenceChains.values().iterator(); iter
                .hasNext();) {
            IncidenceChain element = (IncidenceChain) iter.next();
            if (element.isMenuingItems()) {
                count++;
            }
        }

        return count;
    }

    public int getNumberOfChains() {
        return incidenceChains.size();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection getIncidenceChains() {
        TreeSet sorted = new TreeSet(new MMSorter().getAscendingAllUnique(
                "name", "numberOfItemsMenued"));
        sorted.addAll(incidenceChains.values());
        return sorted;
    }

    public void initChain(Chain chain) {
        IncidenceChain iChain = null;
        if (incidenceChains.containsKey(chain.getOperationName())) {
            iChain = (IncidenceChain) incidenceChains.get(chain
                    .getOperationName());
        } else {
            iChain = new IncidenceChain();

            if (chain.getOperationName() != null
                    && chain.getOperationName().indexOf("\"") > -1) {
                String name = chain.getOperationName().replaceAll("\"", "");
                iChain.setName(name);
            } else {
                iChain.setName(chain.getOperationName());

            }

            incidenceChains.put(chain.getOperationName(), iChain);
        }

    }
    
    public void initChain(AbstractChainInformationBean chain) {
        IncidenceChain iChain = null;
        if (incidenceChains.containsKey(chain.getOperationName())) {
            iChain = (IncidenceChain) incidenceChains.get(chain
                    .getOperationName());
        } else {
            iChain = new IncidenceChain();

            if (chain.getOperationName() != null
                    && chain.getOperationName().indexOf("\"") > -1) {
                String name = chain.getOperationName().replaceAll("\"", "");
                iChain.setName(name);
            } else {
                iChain.setName(chain.getOperationName());

            }

            incidenceChains.put(chain.getOperationName(), iChain);
        }

    }    

    public void addMasterFood(MasterFood masterFood) {
        IncidenceChain iChain = null;
        String key = "N/A";
//        if (masterFood.getChain() != null) {
//            key = masterFood.getChain().getOperationName();
//        }
        if (masterFood.getOperationName() != null) {
            key = masterFood.getOperationName();
        }

        
        
        if (incidenceChains.containsKey(key)) {
            iChain = (IncidenceChain) incidenceChains.get(key);
        } else {
            iChain = new IncidenceChain();
            incidenceChains.put(key, iChain);
        }

        iChain.incrementCount();

    }
}