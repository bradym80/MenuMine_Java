/*
 * Created on Aug 18, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.express;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fsrin.menumine.common.webwork.MMSorter;

/**
 * @author Nick
 * 
 * 
 */
public abstract class MineRankerAbstractImpl implements MineRanker {

    private static Log log = LogFactory.getLog(MineRankerAbstractImpl.class);

    public MineRankerAbstractImpl() {
        super();

    }

    public Collection rank(Collection keyCounters) {
        TreeSet sortedRanks = new TreeSet(new MMSorter().getDescending(
                "mineCount",
                "mineFieldsExpressQueryCounter.targetMine.mineType"));

        Collection rawRanks = this.handleRanking(keyCounters);

        // for (Iterator iter = rawRanks.iterator(); iter.hasNext();) {
        // MineRank element = (MineRank) iter.next();
        // System.out.println(element.getMineFieldsExpressQueryCounter()
        // .getTargetMine().getMineType()
        // + ": " + element.getMineCount());
        // }

        sortedRanks.addAll(rawRanks);
        LogFactory.getLog(this.getClass()).debug("\nSorted!");
        for (Iterator iter = sortedRanks.iterator(); iter.hasNext();) {
            MineRank element = (MineRank) iter.next();
            log.debug(element.getMineFieldsExpressQueryCounter()
                    .getTargetMine().getMineType()
                    + ": " + element.getMineCount());
        }

        return sortedRanks;
    }

    protected abstract Collection handleRanking(Collection keyCounters);

    private HashMap buildKeyCounterMap(Collection keyCounters) {

        HashMap keyCounterMap = new HashMap();

        for (Iterator iter = keyCounters.iterator(); iter.hasNext();) {
            KeyCounter keyCounter = (KeyCounter) iter.next();
            keyCounterMap.put(keyCounter.getMineField().getFieldEnum()
                    .getName(), keyCounter);

        }

        return keyCounterMap;
    }

}