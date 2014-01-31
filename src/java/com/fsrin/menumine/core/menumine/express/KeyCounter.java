/*
 * Created on Aug 16, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.express;

import java.util.HashMap;
import java.util.Iterator;

import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableKeyFinder;
import com.fsrin.menumine.core.minefields.MineField;

/**
 * @author Nick
 * 
 *  
 */
public class KeyCounter {


     
     
    private final StatisticalTableKeyFinder statisticalTableKeyFinder;

   

    private final MineField mineField;

    private HashMap tokenMap = new HashMap();

    private int count;

    public KeyCounter(MineField field, StatisticalTableKeyFinder keyFinder) {
        super();

        this.mineField = field;
        this.statisticalTableKeyFinder = keyFinder;
    }

   

    public MineField getMineField() {
        return mineField;
    }

    public StatisticalTableKeyFinder getStatisticalTableKeyFinder() {
        return statisticalTableKeyFinder;
    }

    public void incrementCount(String token) {
        this.count++;
        if (tokenMap.containsKey(token)) {
            Integer i = (Integer) tokenMap.get(token);
            tokenMap.put(token, new Integer(i.intValue() + 1));
        } else {
            tokenMap.put(token, new Integer(1));
        }

    }

    public Integer getCount(String token) {
        if (tokenMap.containsKey(token)) {
            Integer i = (Integer) tokenMap.get(token);
            return i;
        } else {
            return new Integer(0);
        }
    }

    public Integer getCount() {
        return new Integer(count);
    }

    public String getTokenList() {
        StringBuffer buffer = new StringBuffer();

        for (Iterator iter = tokenMap.keySet().iterator(); iter.hasNext();) {
            String element = (String) iter.next();
            buffer.append(", ").append(element);
        }
        return buffer.toString();
    }

    

}