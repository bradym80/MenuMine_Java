/*
 * Created on Feb 3, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.sharetable;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fsrin.menumine.common.webwork.MMSorter;
import com.fsrin.menumine.core.menumine.rollup.RollUpOptions;
import com.fsrin.menumine.core.menumine.rollup.util.RollUpHandler;
import com.fsrin.menumine.core.menumine.rollup.util.RollUpHandlerFactory;

public class StatisticalTableRollUp {

    private static Log log = LogFactory.getLog(StatisticalTableRollUp.class);

    public void filter(StatisticalTableIF target, RollUpOptions options) {

        /*
         * means we have nothing to roll up.
         */
        if (options == null || options.getRollUpElements().size() == 0)
            return;

        RollUpHandler handler = RollUpHandlerFactory.getRollUpHandler(options);

        HashMap filteredRows = new HashMap();

        for (Iterator iter = target.getRows().iterator(); iter.hasNext();) {

            StatisticalTableElementIF element = (StatisticalTableElementIF) iter
                    .next();

            if (element.getSizeOfSample() == null) {
                throw new RuntimeException(
                        "Size of sample is null in current element. "
                                + element.getName());
            }

            String key = handler.getRollUpKey(element.getName());

            log.debug("Rollup key is " + key);

            StatisticalTableElementIF existing = (StatisticalTableElementIF) filteredRows
                    .get(key);

            StatisticalTableElementIF result = null;

            if (existing == null)
                result = element;
            else {

                result = new StatisticalTableElementIFBuilder().buildCombined(
                        key, existing, element);

                if (result.getSizeOfSample() == null) {
                    throw new RuntimeException(
                            "result size of sample is unexpectedly null");
                }
            }

            log.debug("putting " + result.getName() + " int map using key "
                    + key);

            filteredRows.put(key, result);

        }

        Collection sortedRows = new TreeSet(new TreeSet(new MMSorter()
                .getDescending("numberInSample", "name")));
        sortedRows.addAll(filteredRows.values());

        target.setRows(sortedRows);

    }

}
