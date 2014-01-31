/*
 * Created on May 2, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.rollup.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.fsrin.menumine.core.menumine.rollup.RollUpElement;
import com.fsrin.menumine.core.menumine.rollup.RollUpOptions;
import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableOptions;

/**
 * 2006-02-02 RSC Original implemented rolluphandler but it looks
 * vestigal so i'm dumping it.
 *
 * @author Nick
 * 
 *  
 */
public class RollUpMatchEachHandler  {

    public StatisticalTableOptions options = new StatisticalTableOptions();

    public Object[] handleRollUp(Object key) {

        if (this.options.getRollUpOptions() == null
                || this.options.getRollUpOptions().getRollUpElements().size() == 0) {

            Object[] keyList = new Object[1];
            keyList[0] = key;
            return keyList;
        }

        //        if (this.options.getRollUpTerms() == null
        //                || this.options.getRollUpTerms().length() == 0
        //                || !(key instanceof String)) {
        //
        //            Object[] keyList = new Object[1];
        //            keyList[0] = key;
        //            return keyList;
        //        }

        //   String[] terms = this.options.getRollUpTerms().split(",");

        // StringBuffer newKey = new StringBuffer();
        Collection newKey = new ArrayList();
        for (Iterator iter = this.options.getRollUpOptions()
                .getRollUpElements().iterator(); iter.hasNext();) {
            RollUpElement element = (RollUpElement) iter.next();

            String tempTerm = element.getTerm();
            String mockKey = element.getLabel();

            if (tempTerm != null && tempTerm.length() > 0
                    && key instanceof String) {
                //                if (((String) key).toLowerCase()
                //                        .indexOf(tempTerm.toLowerCase()) >= 0) {
                if (((String) key).toLowerCase().equals(tempTerm.toLowerCase())) {

                    if (!newKey.contains(mockKey)) {
                        newKey.add(mockKey);
                    }

                }
            }

        }

        if (newKey.size() == 0) {

            /*
             * If we are rolling up Other we just use the other key.
             */

            if (options.getOtherItemRollUpType() != null
                    && options
                            .getOtherItemRollUpType()
                            .equals(
                                    RollUpOptions.OTHER_ITEM_ROLL_UP_TYPE_ROLL_UP_OTHERS)) {
                key = "Other";
            }

            Object[] keyList = new Object[1];
            keyList[0] = key;
            return keyList;
        }

        return newKey.toArray();

    }

    public RollUpMatchEachHandler(StatisticalTableOptions options) {
        super();
        this.options = options;
    }

}