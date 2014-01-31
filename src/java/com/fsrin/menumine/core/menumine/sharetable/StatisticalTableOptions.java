/*
 * Created on May 2, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.sharetable;

import com.fsrin.menumine.core.menumine.rollup.RollUpOptions;

/**
 * @author Nick
 * 
 *  
 */
public class StatisticalTableOptions {

    /*
     * If a menu item matches multiple terms we create a row for the combination
     * of terms.
     */
    public static String AGGREGATION_TYPE_MATCH_ALL_TERMS = "matchAll";

    /*
     * 
     * A menu item will be counted once for each term given.
     * 
     * 2006-02-02 RSC Doesn't seem to be used--I'm dumping it.
     */
//    public static String AGGREGATION_TYPE_MATCH_EACH_TERMS = "matchEach";

    private String groupByField;

    private RollUpOptions rollUpOptions;

    private String aggregationType;

    private String otherItemRollUpType;

    private String simpleFilter;

    public StatisticalTableOptions() {
        super();

    }

    public String getAggregationType() {
        return aggregationType;
    }

    public void setAggregationType(String aggregationType) {
        this.aggregationType = aggregationType;
    }

    public String getGroupByField() {
        return groupByField;
    }

    public void setGroupByField(String groupByField) {
        this.groupByField = groupByField;
    }

    public String getOtherItemRollUpType() {
        return otherItemRollUpType;
    }

    public void setOtherItemRollUpType(String otherItemRollUpType) {
        this.otherItemRollUpType = otherItemRollUpType;
    }

    public String getSimpleFilter() {
        return simpleFilter;
    }

    public void setSimpleFilter(String simpleFilter) {
        this.simpleFilter = simpleFilter;
    }

    public boolean isSimpleFilter(Object tempKey) {
        /*
         * If we don't have a filter it must pass!
         */
        if (this.getSimpleFilter() == null
                || this.getSimpleFilter().length() == 0) {
            return true;
        }

        return tempKey.toString().toLowerCase().indexOf(
                this.getSimpleFilter().toLowerCase()) > -1;
    }

    public RollUpOptions getRollUpOptions() {
        return rollUpOptions;
    }

    public void setRollUpOptions(RollUpOptions rollUpOptions) {
        this.rollUpOptions = rollUpOptions;
    }
}