/*
 * Created on Aug 26, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.rollup;

import java.util.ArrayList;
import java.util.Collection;

import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableElementIF;

/**
 * @author Nick
 * 
 *  
 */
public class AutoRollUpWordCountVO {

    private String name;

    private int count;

    private Collection includedStatisticalTableElement = new ArrayList();

    public AutoRollUpWordCountVO(String name) {
        super();

        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public String getName() {
        return name;
    }

    public void incrementCount() {
        this.count++;
    }

    public void addStatisticalTableElement(
            StatisticalTableElementIF statisticalTableElement) {
        includedStatisticalTableElement.add(statisticalTableElement);

    }
    public Collection getIncludedStatisticalTableElement() {
        return includedStatisticalTableElement;
    }

    public void incrementCount(Long numberInSample) {
        this.count+=numberInSample.intValue();
    }
}