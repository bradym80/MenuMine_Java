/*
 * Created on Sep 14, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.rollup.xwork;

import java.util.ArrayList;
import java.util.Collection;

import com.fsrin.menumine.core.menumine.rollup.RollUpElement;
import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableElementIF;

/**
 * @author Nick
 * 
 *  
 */
public class RollUpTableElement {

    private StatisticalTableElementIF statisticalTableElement;

    private Collection rollUpElements = new ArrayList();

    public RollUpTableElement(StatisticalTableElementIF statisticalTableElement) {
        super();
        this.statisticalTableElement = statisticalTableElement;
    }

    public void addRollUpElement(RollUpElement element) {
        rollUpElements.add(element);
    }

    public StatisticalTableElementIF getStatisticalTableElement() {
        return statisticalTableElement;
    }

    public Collection getRollUpElements() {
        return rollUpElements;
    }
}