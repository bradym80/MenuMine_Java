/*
 * Created on Mar 24, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.sharetable;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.TreeSet;

import com.fsrin.menumine.common.webwork.MMSorter;
import com.fsrin.menumine.core.menumine.FieldEnum;
import com.fsrin.menumine.core.menumine.masterfood.MasterFood;
import com.fsrin.menumine.core.menumine.rollup.util.RollUpHandler;
import com.fsrin.menumine.core.menumine.rollup.util.RollUpMatchAllHandler;

/**
 * @author Nick
 * 
 *  
 */
public class StatisticalTableStandardImpl implements Serializable, StatisticalTableIF {

    private HashMap elements = new HashMap();

    private long sizeOfSample = 0;

    private final String groupByField;

    private StatisticalTableOptions options;

    private FieldEnum fieldEnum;

    private StatisticalTableElementStandardImpl total;

    private StatisticalTableKeyFinder keyFinder;

    public StatisticalTableStandardImpl(StatisticalTableOptions options) {
        this.groupByField = options.getGroupByField();

        this.options = options;

        fieldEnum = FieldEnum.getByOgnlName(groupByField);
        
        keyFinder = StatisticalTableKeyFinder.factory.build(fieldEnum);

        total = new StatisticalTableElementStandardImpl("Total", this);

    }

    public void addMasterFood(MasterFood masterFood) {
        sizeOfSample++;
        String key = (String) getKey(masterFood);

        /*
         * This returns the keys we need to match this record under.
         * handleRollUp handles null keys!
         */
        String keyList = this.handleRollUp(key);

//        for (int i = 0; i < keyList.length; i++) {
//            Object tempKey = keyList[i];

            /*
             * Test if this key passed the filter. This feature exists for the
             * roll up builder. This filter is a single temp indexOf matching.
             */
            if (this.options.isSimpleFilter(keyList)) {
                StatisticalTableElementStandardImpl element = getElement(keyList);
                element.addMasterFood(masterFood);
            }

//        }

        total.addMasterFood(masterFood);
    }

    /*
     * nick 2005-5-2 This is like a filter for the key, it must either return
     * the given key or processed key. The key is then placed in an array. This
     * is required because of the differnt rollup options.
     */
    private String handleRollUp(String key) {
        if (key == null) {
            key = "Not on Menu";
        }

        /*
         * 2006-02-02 RSC Refacoring this out since it seems that the
         * match each is vestigal.
         */
        RollUpHandler rollUpHandler = null;
//        if (this.options.getAggregationType() != null
//                && this.options
//                        .getAggregationType()
//                        .equals(
//                                StatisticalTableOptions.AGGREGATION_TYPE_MATCH_ALL_TERMS)) {
            rollUpHandler = new RollUpMatchAllHandler(this.options
                    .getRollUpOptions());
//        } else {
//            /*
//             * This still uses the StatTable options. For not we are not going
//             * to use this, so I'm not refactoring.
//             *  
//             */
//            rollUpHandler = new RollUpMatchEachHandler(this.options);
//        }

        return rollUpHandler.getRollUpKey(key);

    }

    private StatisticalTableElementStandardImpl getElement(Object key) {

        StatisticalTableElementStandardImpl element = (StatisticalTableElementStandardImpl) elements
                .get(key);
        if (element == null) {

            element = new StatisticalTableElementStandardImpl(key.toString(), this);
            this.elements.put(key, element);
        }

        return element;

    }

    private Object getKey(MasterFood masterFood) {
        return this.keyFinder.getKey(masterFood);
    }

    public Collection getRows() {
        Collection table = new TreeSet(new TreeSet(new MMSorter()
                .getDescending("percent", "name")));
        table.addAll(elements.values());
        //return elements.values();
        return table;
    }

    public FieldEnum getFieldEnum() {
        return fieldEnum;
    }

    public Long getSizeOfSample() {
        return new Long(sizeOfSample);
    }

    public StatisticalTableElementIF getTotal() {
        return total;
    }

    public void setRows(Collection c) {
        
        throw new RuntimeException("can't set rows into a standard impl");
    }

    public void setTotal(StatisticalTableElementIF total) {
        total = total;
    }
}