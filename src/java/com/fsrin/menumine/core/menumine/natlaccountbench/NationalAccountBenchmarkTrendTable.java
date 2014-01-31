/*
 * Created on Jun 30, 2005
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

/**
 * @author Nick For the trend table we will funnel the elements into
 *         NationalAccountBenchmarkTables based on if the element is OnMenu
 *         during the year.
 *  
 */
public class NationalAccountBenchmarkTrendTable {

    private NationalAccountBenchmarkTable dataRecent;

    private NationalAccountBenchmarkTable dataMiddle;

    private NationalAccountBenchmarkTable dataOldest;

    public NationalAccountBenchmarkTrendTable(
            NationalAccountBenchmarkOptions options) {
        super();
        dataRecent = new NationalAccountBenchmarkTable(options);
        dataMiddle = new NationalAccountBenchmarkTable(options);
        dataOldest = new NationalAccountBenchmarkTable(options);
    }

    /*
     * 2006-03-10 RSC updated to the 2005-2002-1999 from 2004-2001-1998
     */
    public void addMasterFood(MasterFood element) {

    	// DBB 2-12-2009 Add 2008
    	if (element.isOnMenu2009()) {
            dataRecent.addMasterFood(element);
        }
    	if (element.isOnMenu2008()) {
            dataRecent.addMasterFood(element);
        }
        
        if (element.isOnMenu2005()) {
            dataRecent.addMasterFood(element);
        }

        if (element.isOnMenu2002()) {
            dataMiddle.addMasterFood(element);
        }

        if (element.isOnMenu1999()) {
            dataOldest.addMasterFood(element);
        }

    }

    public Collection getRows() {
        HashMap rows = new HashMap();

        for (Iterator iter = this.getDataOldest().getRows().iterator(); iter
                .hasNext();) {
            NationalAccountBenchmarkElement element = (NationalAccountBenchmarkElement) iter
                    .next();

            NationalAccountBenchmarkTrendElement nabe = this
                    .getNationalAccountBenchmarkTrendElement(element, rows);

            nabe.setBenchmarkOldest(element);
        }

        for (Iterator iter = this.getDataMiddle().getRows().iterator(); iter
                .hasNext();) {
            NationalAccountBenchmarkElement element = (NationalAccountBenchmarkElement) iter
                    .next();

            NationalAccountBenchmarkTrendElement nabe = this
                    .getNationalAccountBenchmarkTrendElement(element, rows);

            nabe.setBenchmarkMiddle(element);
        }

        for (Iterator iter = this.getDataRecent().getRows().iterator(); iter
                .hasNext();) {
            NationalAccountBenchmarkElement element = (NationalAccountBenchmarkElement) iter
                    .next();

            NationalAccountBenchmarkTrendElement nabe = this
                    .getNationalAccountBenchmarkTrendElement(element, rows);

            nabe.setBenchmarkRecent(element);
        }

        TreeSet set = new TreeSet(new MMSorter().getDescendingAllUnique(
                "benchmarkRecent.percentOfTarget", "name"));
        set.addAll(rows.values());
        return set;
    }

    private NationalAccountBenchmarkTrendElement getNationalAccountBenchmarkTrendElement(
            NationalAccountBenchmarkElement nationalAccountBenchmarkElement,
            HashMap rows) {
        NationalAccountBenchmarkTrendElement nabe = (NationalAccountBenchmarkTrendElement) rows
                .get(nationalAccountBenchmarkElement.getName());
        if (nabe == null) {
            nabe = new NationalAccountBenchmarkTrendElement();
            rows.put(nationalAccountBenchmarkElement.getName(), nabe);
        }

        return nabe;
    }

    public NationalAccountBenchmarkTable getDataOldest() {
        return dataOldest;
    }

    public NationalAccountBenchmarkTable getDataMiddle() {
        return dataMiddle;
    }

    public NationalAccountBenchmarkTable getDataRecent() {
        return dataRecent;
    }
}