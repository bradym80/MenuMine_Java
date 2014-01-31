/*
 * Created on Jul 19, 2005
 *
 * 
 */
package com.fsrin.menumine.core.chainmap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 2006-01-17 RSC Contains all of the information for building a graph.
 * 
 * @author Reid
 * @author Nick
 * 
 *  
 */
public class ChainMapTable {

    private static Log log = LogFactory.getLog(ChainMapTable.class);
    
    public static ChainMapTableBuilder builder = new ChainMapTableBuilder();

    private ChainMapTableLineItem westCount = new ChainMapTableLineItem(
            ChainStateCount.WEST, this);

    private ChainMapTableLineItem midwestCount = new ChainMapTableLineItem(
            ChainStateCount.MIDWEST, this);

    private ChainMapTableLineItem southCount = new ChainMapTableLineItem(
            ChainStateCount.SOUTH, this);

    private ChainMapTableLineItem northEastCount = new ChainMapTableLineItem(
            ChainStateCount.NORTH_EAST, this);

    private ChainMapTableLineItem totalCount = new ChainMapTableLineItem(
            "Total", this);

    private HashMap stateBreakDown = new HashMap();

    private HashSet targetChains = new HashSet();

    private HashSet benchmarkChains = new HashSet();

    public ChainMapTable() {
        super();
    }

    public void addChainStateCount(ChainStateCount chainStateCount) {

        if (chainStateCount == null)
            log.info("chainStateCount is null");
        
        HashMap regionMap = new HashMap();
        /*
         * Seed the map;
         */

        //        regionMap.put(ChainStateCount.WEST, this.westCount);
        //        regionMap.put(ChainStateCount.NORTH_EAST, this.northEastCount);
        //        regionMap.put(ChainStateCount.MIDWEST, this.midwestCount);
        //        regionMap.put(ChainStateCount.SOUTH, this.southCount);
        for (Iterator iter = ChainStateCountMapper.factory.getAll().iterator(); iter
                .hasNext();) {
            ChainStateCountMapper element = (ChainStateCountMapper) iter.next();
            Long count = (Long) regionMap.get(element.getKey());
            if (count == null) {
                count = new Long(0);
                regionMap.put(element.getKey(), count);
            }
            
            /*
             * 2006-01-17 RSC was throwing NPE when no benchmark items were selected.
             */
            Long addValue = new Long(0);
            if (chainStateCount != null)
                addValue = element.getValue(chainStateCount);
            
            if (addValue != null) {
                regionMap.put(element.getKey(), new Long(count.longValue()
                        + addValue.longValue()));
            }

            /*
             * We need to keep track of the states as well as the regions.
             */
            this.addToStateBreakDown(element, chainStateCount);
            this.totalCount.addChainCount(addValue);

        }

        this.westCount
                .addChainCount((Long) regionMap.get(ChainStateCount.WEST));
        this.northEastCount.addChainCount((Long) regionMap
                .get(ChainStateCount.NORTH_EAST));
        this.midwestCount.addChainCount((Long) regionMap
                .get(ChainStateCount.MIDWEST));
        this.southCount.addChainCount((Long) regionMap
                .get(ChainStateCount.SOUTH));

        /*
         * Keep track of all the chains that are included. It may be nice to
         * have the chain object, but strings will do for now.
         */
        this.targetChains.add(chainStateCount.getChain());

    }

    /*
     * This builds the stateBreakDownTable. This will put a single chains value
     * for a single chain in to the table.
     * 
     * 2006-01-17 RSC Corrected spelling
     */
    private void addToStateBreakDown(ChainStateCountMapper mapper,
            ChainStateCount chainStateCount) {

        if (mapper.getValue(chainStateCount) != null
                && mapper.getValue(chainStateCount).longValue() > 0) {
            ChainMapTableLineItem li = (ChainMapTableLineItem) this.stateBreakDown
                    .get(mapper.getStateKey());

            if (li == null) {
                li = new ChainMapTableLineItem(mapper.getStateKey().toString(),
                        this);
                this.stateBreakDown.put(mapper.getStateKey(), li);
            }

            li.addChainCount(mapper.getValue(chainStateCount));
        }
    }

    /*
     * The builds a base in which we can compare the target.
     */
    public void addAllChainStateCount(ChainStateCount chainStateCount) {

        if (chainStateCount == null) {
//            log.info("chainStateCount is unexpectedly null");
            return;
        }
        
        HashMap regionMap = new HashMap();
        /*
         * Seed the map;
         */

        //        regionMap.put(ChainStateCount.WEST, this.westCount);
        //        regionMap.put(ChainStateCount.NORTH_EAST, this.northEastCount);
        //        regionMap.put(ChainStateCount.MIDWEST, this.midwestCount);
        //        regionMap.put(ChainStateCount.SOUTH, this.southCount);
        for (Iterator iter = ChainStateCountMapper.factory.getAll().iterator(); iter
                .hasNext();) {
            ChainStateCountMapper element = (ChainStateCountMapper) iter.next();
            Long count = (Long) regionMap.get(element.getKey());
            if (count == null) {
                count = new Long(0);
                regionMap.put(element.getKey(), count);
            }
            
            /*
             * 2006-01-17 RSC 
             */
            Long addValue = new Long(0);
            if (chainStateCount != null) 
                addValue = element.getValue(chainStateCount);
            
            if (addValue != null) {
                regionMap.put(element.getKey(), new Long(count.longValue()
                        + addValue.longValue()));
            }

            this.totalCount.addAllChainCount(addValue);

        }

        this.westCount.addAllChainCount((Long) regionMap
                .get(ChainStateCount.WEST));
        this.northEastCount.addAllChainCount((Long) regionMap
                .get(ChainStateCount.NORTH_EAST));
        this.midwestCount.addAllChainCount((Long) regionMap
                .get(ChainStateCount.MIDWEST));
        this.southCount.addAllChainCount((Long) regionMap
                .get(ChainStateCount.SOUTH));

        this.benchmarkChains.add(chainStateCount.getChain());

    }

    public ChainMapTableLineItem getMidwestCount() {
        return midwestCount;
    }

    public void setMidwestCount(ChainMapTableLineItem midwestCount) {
        this.midwestCount = midwestCount;
    }

    public ChainMapTableLineItem getNorthEastCount() {
        return northEastCount;
    }

    public void setNorthEastCount(ChainMapTableLineItem northEastCount) {
        this.northEastCount = northEastCount;
    }

    public ChainMapTableLineItem getSouthCount() {
        return southCount;
    }

    public void setSouthCount(ChainMapTableLineItem southCount) {
        this.southCount = southCount;
    }

    public ChainMapTableLineItem getWestCount() {
        return westCount;
    }

    public void setWestCount(ChainMapTableLineItem westCount) {
        this.westCount = westCount;
    }

    public ChainMapTableLineItem getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(ChainMapTableLineItem totalCount) {
        this.totalCount = totalCount;
    }

    public Collection getRegions() {
        Collection ret = new ArrayList();
        ret.add(this.midwestCount);
        ret.add(this.northEastCount);
        ret.add(this.southCount);
        ret.add(this.westCount);

        return ret;

    }

    public Collection getStates() {
        return this.stateBreakDown.values();
    }

    public Collection getBenchmarkChains() {
        return benchmarkChains;
    }

    public Collection getTargetChains() {
        return targetChains;
    }

    public HashMap getStateIntensityMap() {
        return this.getIntencityMapBuilder().build(this.getStates());

    }

    public IntencityMapBuilder getIntencityMapBuilder() {
        return new IntencityMapBuilderBasicImpl();
    }

}