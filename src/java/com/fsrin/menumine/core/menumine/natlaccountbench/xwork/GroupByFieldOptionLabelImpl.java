/*
 * Created on Jul 7, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.natlaccountbench.xwork;

/**
 * @author Nick
 * 
 *  
 */
public class GroupByFieldOptionLabelImpl implements GroupByFieldOption {

    private String label;

    public GroupByFieldOptionLabelImpl(String label) {
        this.label = label;
    }

    public String getKey() {

        return this.label;
    }

    public String getValue() {

        return this.label;
    }

}