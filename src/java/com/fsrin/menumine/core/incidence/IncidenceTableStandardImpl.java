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
public class IncidenceTableStandardImpl implements IncidenceTable {

    private static final String N_A = "N/A";

    private IncidenceTotals totals;

    private Integer year;

    private HashMap incidenceSectors = new HashMap();

    public IncidenceTableStandardImpl(IncidenceTableBuildOptionsWithChains options) {

        this.year = options.getYear();

        for (Iterator iter = options.getBaseChains().iterator(); iter.hasNext();) {
            AbstractChainInformationBean element = (AbstractChainInformationBean) iter.next();

            if (element != null) {
                this.initChain(element);
            }
        }

        totals = new IncidenceTotalsStandardImpl(this);

        for (Iterator iter = options.getResults().iterator(); iter.hasNext();) {
            MasterFood element = (MasterFood) iter.next();
            this.addMasterFood(element);

        }

    }

    /*
     * The report need to know how all the chains break down into sector and
     * segment, so we need to init the chains.
     */
    private void initChain(Chain chain) {
        IncidenceSectorStandardImpl sector = null;

        if (chain.getYearPutInDatabase() == null
                || chain.getYearPutInDatabase().intValue() > this.getYear()
                        .intValue()) {
            return;
        }

        String key = N_A;
        if (chain != null && chain.getSectorName() != null
                && chain.getSectorName().trim().length() != 0) {
            key = chain.getSectorName();
        }

        if (key.equalsIgnoreCase(N_A)) {
            key = N_A;
            
        }
        if (incidenceSectors.containsKey(key) && incidenceSectors.get(key) != null) {
            sector = (IncidenceSectorStandardImpl) incidenceSectors.get(key);

        } else {
            sector = new IncidenceSectorStandardImpl();
            sector.setName(key);
            incidenceSectors.put(key, sector);
        }

        if (sector == null || chain == null)
            throw new RuntimeException("unexpected nulls");
        
        sector.initChain(chain);

    }
    
    private void initChain(AbstractChainInformationBean chain) {
        IncidenceSectorStandardImpl sector = null;

        if (chain.getYearPutInDatabase() == null
                || chain.getYearPutInDatabase().intValue() > this.getYear()
                        .intValue()) {
            return;
        }

        String key = N_A;
        if (chain != null && chain.getSectorName() != null
                && chain.getSectorName().trim().length() != 0) {
            key = chain.getSectorName();
        }

        if (key.equalsIgnoreCase(N_A)) {
            key = N_A;
            
        }
        if (incidenceSectors.containsKey(key) && incidenceSectors.get(key) != null) {
            sector = (IncidenceSectorStandardImpl) incidenceSectors.get(key);

        } else {
            sector = new IncidenceSectorStandardImpl();
            sector.setName(key);
            incidenceSectors.put(key, sector);
        }

        if (sector == null || chain == null)
            throw new RuntimeException("unexpected nulls");
        
        sector.initChain(chain);

    }

    public IncidenceTotals getTotals() {
        return totals;
    }

    public void setTotals(IncidenceTotals totals) {
        this.totals = totals;
    }

    public Collection getIncidenceSectors() {

        return incidenceSectors.values();
    }

    public void addMasterFood(MasterFood masterFood) {

        if (masterFood == null) {
            return;
        }

//        if (masterFood.getChain() != null
//                && masterFood.getChain().getYearPutInDatabase().intValue() > this
//                        .getYear().intValue()) {
//            return;
//        }

        IncidenceSectorStandardImpl sector = null;
        
        String key = N_A;
        
        
//        if (masterFood.getChain() != null
//                && masterFood.getChain().getSectorName() != null
//                && masterFood.getChain().getSectorName().length() != 0) {
//            key = masterFood.getChain().getSectorName();
//        }
        if (masterFood.getSectorName() != null
                && masterFood.getSectorName().length() != 0) {
            key = masterFood.getSectorName();
        }
        

        if (key.equalsIgnoreCase(N_A)) {
            key = N_A;
        }
        if (incidenceSectors.containsKey(key)) {
            sector = (IncidenceSectorStandardImpl) incidenceSectors.get(key);

        } else {
            sector = new IncidenceSectorStandardImpl();
            sector.setName(key);
            incidenceSectors.put(key, sector);
        }

        sector.addMasterFood(masterFood);

    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}