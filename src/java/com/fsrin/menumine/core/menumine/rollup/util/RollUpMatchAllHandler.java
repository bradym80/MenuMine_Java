/*
 * Created on May 2, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.rollup.util;

import java.util.HashMap;
import java.util.Iterator;

import com.fsrin.menumine.core.menumine.rollup.RollUpElement;
import com.fsrin.menumine.core.menumine.rollup.RollUpOptions;

/**
 * @author Nick
 * 
 * This will include the item in exactly 1 rollup. If it matches multiple rules,
 * we Create a label that is a combo of all matching rules. This doen't really
 * matter now that we match exactly.
 * 
 * 2006-02-02 RSC The basic ID is you send in the roll up options and a possibly
 * rolled up term.  This either returns
 * 1) what the term is rolled up into
 * 2) if there is no rollup defined, it returns whatever you put in.
 */
public class RollUpMatchAllHandler implements RollUpHandler {

    //    public StatisticalTableOptions options = new StatisticalTableOptions();
    public RollUpOptions options;

    public HashMap quickMap;

    public RollUpMatchAllHandler(RollUpOptions options) {
        super();
        this.options = options;

        this.quickMap = this.prepareQuickMap(options);

    }
    
    public String getRollUpKey(String key) {

        if (this.options == null
                || this.options.getRollUpElements().size() == 0) {

//            Object[] keyList = new Object[1];
//            keyList[0] = key;
            return key;
        }
        StringBuffer newKey = new StringBuffer();

        if (quickMap != null) {
            if (quickMap.containsKey(key)) {
                RollUpElement element = (RollUpElement) quickMap.get(key);
                newKey.append(element.getLabel());
            } else {
                newKey.append(key);
            }
        } else {

            // String[] terms = this.options.getRollUpTerms().split(",");
            for (Iterator iter = this.options.getRollUpElements().iterator(); iter
                    .hasNext();) {
                RollUpElement element = (RollUpElement) iter.next();

                //  for (int i = 0; i < terms.length; i++) {

                //            String tempTerm = terms[i].trim();
                //            String mockKey = tempTerm;
                String tempTerm = element.getTerm();
                String mockKey = element.getLabel();

                if (tempTerm != null && tempTerm.length() > 0
                        && key instanceof String) {
                    if (((String) key).toLowerCase().equals(
                            tempTerm.toLowerCase())) {

                        /*
                         * In the case of a roll Up of Chocolate,choc:Chocolate
                         * 'Chocolate Cake' would match both terms, since the
                         * Labels are the same we don't want to combine
                         *  
                         */
                        if (newKey.indexOf(mockKey) < 0) {
                            if (newKey.length() > 0) {
                                newKey.append("/");
                            }

                            newKey.append(mockKey);
                        }
                    }
                }

            }
        }

        if (newKey.length() > 0) {
            key = newKey.toString();
        } else {
            if (options.getOtherItemRollUpType() != null
                    && options
                            .getOtherItemRollUpType()
                            .equals(
                                    RollUpOptions.OTHER_ITEM_ROLL_UP_TYPE_ROLL_UP_OTHERS)) {
                key = "Other";
            }
        }

//        Object[] keyList = new Object[1];
//        keyList[0] = key;
        return key;

    }



    private HashMap prepareQuickMap(RollUpOptions options) {

        HashMap quickMap = new HashMap();
        if (options != null && options.getRollUpElements() != null) {
            for (Iterator iter = options.getRollUpElements().iterator(); iter
                    .hasNext();) {
                RollUpElement element = (RollUpElement) iter.next();
                quickMap.put(element.getTerm(), element);
            }
        }

        return quickMap;
    }

}