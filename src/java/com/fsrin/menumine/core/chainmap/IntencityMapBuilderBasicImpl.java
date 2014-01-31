/*
 * Created on Aug 5, 2005
 *
 * 
 */
package com.fsrin.menumine.core.chainmap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

import com.fsrin.menumine.common.webwork.MMSorter;

/**
 * @author Nick
 * 
 *  
 */
public class IntencityMapBuilderBasicImpl implements IntencityMapBuilder {

    public IntencityMapBuilderBasicImpl() {
        super();

    }

    /*
     * We take a collection of ChainMapTableLineItems, and return a HashMap of
     * key:StateAbrivaites value StateIntencityVo;
     * 
     * This assign an intencity to each state. This will be used to create the
     * image.
     * 
     * For the first 3 we set the intencity to 5, 4-6 => 4 7-9=> 3 10-11 =>2 all
     * others that are greater than 0 =>1 others are 0;
     * 
     * 
     * 
     * 
     * (non-Javadoc)
     * 
     * @see com.fsrin.menumine.core.chainmap.IntencityMapBuilder#build(java.util.Collection)
     */
    public HashMap build(Collection states) {
        TreeSet set = new TreeSet(new MMSorter().getDescending("chainCount",
                "name"));
        set.addAll(states);

        HashMap intencityMap = new HashMap();

        int count = 1;
        for (Iterator iter = set.iterator(); iter.hasNext();) {
            ChainMapTableLineItem element = (ChainMapTableLineItem) iter.next();

            int myIntencity = this.getIntencityByCount(count, element);
            StateIntencityVo vo = new StateIntencityVo(element, myIntencity);

            intencityMap.put(element.getName(), vo);
            count++;
        }

        return intencityMap;
    }

    private int getIntencityByCount(int count, ChainMapTableLineItem element) {
        if (element.getChainCount().intValue() == 0) {
            return 0;
        }

        if (count == 1 || count == 2 || count == 3) {
            return 5;
        }

        if (count == 4 || count == 5 || count == 6) {
            return 4;
        }

        if (count == 7 || count == 8 || count == 9) {
            return 3;
        }

        if (count == 10 || count == 11 || count == 12) {
            return 2;
        }

        return 1;

    }

}