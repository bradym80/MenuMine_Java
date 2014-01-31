/*
 * Created on Mar 29, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.webwork.util;

import java.util.Comparator;

/**
 * @author Nick
 * 
 *  
 */
public class PriceVOComparator implements Comparator {

    public PriceVOComparator() {
        super();

    }

    public int compare(Object o1, Object o2) {
        PriceVO vo1;
        PriceVO vo2;

        if (o1 instanceof PriceVO) {
            vo1 = (PriceVO) o1;
        } else {
            throw new RuntimeException("");
        }
        if (o2 instanceof PriceVO) {
            vo2 = (PriceVO) o2;
        } else {
            throw new RuntimeException("Cannot compare none PriceVOs");
        }
        if (vo1.getPrice().doubleValue() == vo2.getPrice().doubleValue()) {
            return vo1.getId() - vo2.getId();
        }

        if (vo1.getPrice().doubleValue() > vo2.getPrice().doubleValue()) {
            return 1;
        } else {
            return -1;
        }

    }

}