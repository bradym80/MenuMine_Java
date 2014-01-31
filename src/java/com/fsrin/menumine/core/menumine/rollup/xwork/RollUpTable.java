/*
 * Created on Sep 14, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.rollup.xwork;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

import org.apache.commons.logging.LogFactory;

import com.fsrin.menumine.common.webwork.MMSorter;
import com.fsrin.menumine.core.menumine.rollup.RollUpElement;
import com.fsrin.menumine.core.menumine.rollup.RollUpOptions;
import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableElementIF;
import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableIF;

/**
 * @author Nick
 * 
 *  
 */
public class RollUpTable {

    public static RollUpTableBuilder builder = new RollUpTableBuilder();

    private HashMap rollUpElementsHash;

    public RollUpTable() {
        super();

    }

    public void addStatisticalTable(StatisticalTableIF statisticalTableResults) {
        if (rollUpElementsHash != null) {
            throw new RuntimeException(
                    "Menu Share already added to RollUp Table.");
        }

        rollUpElementsHash = new HashMap();
        for (Iterator iter = statisticalTableResults.getRows().iterator(); iter
                .hasNext();) {
            StatisticalTableElementIF statisticalTableElement = (StatisticalTableElementIF) iter
                    .next();

            RollUpTableElement rollUpTableElement = new RollUpTableElement(
                    statisticalTableElement);

            rollUpElementsHash.put(statisticalTableElement.getName(),
                    rollUpTableElement);
        }

    }

    public void addRollUpOptions(RollUpOptions rollUpOptions) {

        if (rollUpElementsHash == null) {
            throw new RuntimeException(
                    "Menu Share must be added proir to the Roll Up Options");
        }

        for (Iterator iter = rollUpOptions.getRollUpElements().iterator(); iter
                .hasNext();) {
            RollUpElement element = (RollUpElement) iter.next();

            RollUpTableElement rollUpTableElement = (RollUpTableElement) rollUpElementsHash
                    .get(element.getLabel());

            if (rollUpTableElement == null) {
             //   throw new RuntimeException("Error no element found!");
                LogFactory.getLog(this.getClass()).debug("No element found.  It is possible to find that we have a lable that has no" +
                		" elements in the Share table, thus safely ignored.");
            } else {
                rollUpTableElement.addRollUpElement(element);
            }
        }

    }

    public Collection getRollUpElements() {
        Collection table = new TreeSet(new TreeSet(new MMSorter()
                .getDescending("statisticalTableElement.percent",
                        "statisticalTableElement.name")));
        table.addAll(rollUpElementsHash.values());
        //return elements.values();
        return table;

    }
}