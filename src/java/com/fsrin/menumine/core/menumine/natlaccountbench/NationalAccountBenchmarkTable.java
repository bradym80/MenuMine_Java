/*
 * Created on Jun 27, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.natlaccountbench;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

import com.fsrin.menumine.common.webwork.MMSorter;
import com.fsrin.menumine.core.menumine.masterfood.MasterFood;
import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableElementIF;
import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableIF;
import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableStandardImpl;

/**
 * @author Nick
 * 
 *  
 */
public class NationalAccountBenchmarkTable {

    private NationalAccountBenchmarkOptions options;

    private StatisticalTableStandardImpl shareTableA;

    private StatisticalTableStandardImpl shareTableB;

    public NationalAccountBenchmarkTable(NationalAccountBenchmarkOptions options) {
        this.options = options;

        shareTableA = new StatisticalTableStandardImpl(options);
        shareTableB = new StatisticalTableStandardImpl(options);

    }

    public void addMasterFood(MasterFood element) {

//        if (element.getChain() != null
//                && options.getChainsA() != null
//                && options.getChainsA().contains(
//                        element.getChain().getOperationName())) {
//            shareTableA.addMasterFood(element);
//        }
//
//        if (element.getChain() != null
//                && options.getChainsB() != null
//                && options.getChainsB().contains(
//                        element.getChain().getOperationName())) {
//            shareTableB.addMasterFood(element);
//        }
        
        if (element != null
                && options.getChainsA() != null
                && options.getChainsA().contains(
                        element.getOperationName())) {
            shareTableA.addMasterFood(element);
        }

        if (element != null
                && options.getChainsB() != null
                && options.getChainsB().contains(
                        element.getOperationName())) {
            shareTableB.addMasterFood(element);
        }

    }

    public StatisticalTableIF getShareTableA() {
        return shareTableA;
    }

    public StatisticalTableIF getShareTableB() {
        return shareTableB;
    }

    public NationalAccountBenchmarkOptions getOptions() {
        return options;
    }

    public Collection getRows() {
        HashMap rows = new HashMap();

        for (Iterator iter = this.getShareTableA().getRows().iterator(); iter
                .hasNext();) {
            StatisticalTableElementIF element = (StatisticalTableElementIF) iter
                    .next();

            NationalAccountBenchmarkElement nabe = this
                    .getNationalAccountBenchmarkElement(element, rows);

            nabe.setTarget(element);

        }

        for (Iterator iter = this.getShareTableB().getRows().iterator(); iter
                .hasNext();) {
            StatisticalTableElementIF element = (StatisticalTableElementIF) iter
                    .next();

            NationalAccountBenchmarkElement nabe = this
                    .getNationalAccountBenchmarkElement(element, rows);

            nabe.setBenchmark(element);

        }

        TreeSet set = new TreeSet(new MMSorter().getDescendingAllUnique(
                "percentOfTarget", "percentOfBenchmark"));
        set.addAll(rows.values());
        return set;
    }

    private NationalAccountBenchmarkElement getNationalAccountBenchmarkElement(
            StatisticalTableElementIF statisticalTableElement, HashMap rows) {
        NationalAccountBenchmarkElement nabe = (NationalAccountBenchmarkElement) rows
                .get(statisticalTableElement.getName());
        if (nabe == null) {
            nabe = new NationalAccountBenchmarkElement();
            rows.put(statisticalTableElement.getName(), nabe);
        }

        return nabe;
    }

}