/*
 * Created on Jul 12, 2005
 *
 * 
 */
package com.fsrin.menumine.core.chainmap.xwork;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.TreeSet;

import com.fsrin.menumine.common.webwork.MMSorter;
import com.fsrin.menumine.core.chainmap.ChainMapTable;
import com.fsrin.menumine.core.chainmap.ChainStateCountCriteriaParamerters;
import com.fsrin.menumine.core.chainmap.ChainStateCountServiceDelegate;

/**
 * @author Nick
 * 
 *  
 */
public class ChainMapAction extends AbstractChainMapAction {

//    private ChainMapWebOptions chainMapWebOptions;

    private String target;

    private ChainStateCountServiceDelegate chainStateCountServiceDelegate;

    private String baseCensusMapPath;
    
    private String baseStateMapPath;
    
    private String mapByCensusPath;
    
    private String mapByStatePath;
    
    public String execute() throws Exception {
        getChainStateCounts();
        getBaseChainStateCounts();
        
        String census = new MapByCensusBuilder().build(this.getChainMapTable(),this.getBaseCensusMapPath());
        
        this.setMapByCensusPath(census);
        
        String state = new MapByStateBuilder().build(this.getChainMapTable(), this.getBaseStateMapPath());
        
        this.setMapByStatePath(state);
        
        return super.execute();
    }

    
    
    public ChainMapTable getChainMapTable() {
        ChainMapTable table = ChainMapTable.builder.build(this
                .getChainStateCounts(), this.getBaseChainStateCounts());

        return table;
    }

    private Collection getBaseChainStateCounts() {
        Collection col = new ArrayList();

        /*
         * We have a target, we should compare against everything.
         */
        if (this.getTarget() != null && this.getTarget().length() > 0) {
            ChainStateCountCriteriaParamerters p = new ChainStateCountCriteriaParamerters();

            col = this.getServiceDelegate().search(p);
            this.getChainMapContext().setChainStateCountsBase(col);
            this.getChainMapWebOptions().selectAllBenchmark();
        }
        return this.getChainMapContext().getChainStateCountsBase();

    }

    private Collection getChainStateCounts() {
        Collection col = new ArrayList();
        /*
         * If we have a target, look up the new target.
         */
        if (this.getTarget() != null && this.getTarget().length() > 0) {
            ChainStateCountCriteriaParamerters p = new ChainStateCountCriteriaParamerters();
            p.setChain(this.getTarget());
            col = this.getServiceDelegate().search(p);
            this.getChainMapContext().setChainStateCounts(col);
            this.getChainMapWebOptions().updateTarget(col);

        }
        return this.getChainMapContext().getChainStateCounts();
    }

    public ChainStateCountServiceDelegate getServiceDelegate() {
        return chainStateCountServiceDelegate;
    }

    public void setServiceDelegate(
            ChainStateCountServiceDelegate chainStateCountServiceDelegate) {
        this.chainStateCountServiceDelegate = chainStateCountServiceDelegate;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }



    /*
     * Nick 2005.8.8 I think this would be better in a StateMap specific action.
     */

    /*
     * Returns a map whose key is the state abbrivaition and whose value is
     * StateIntencityVo, which combines the intencity with
     * ChainMapTableLineItem.
     */
    public HashMap getStateIntensityMap() {

        ChainMapTable chainMapTable = this.getChainMapTable();
        HashMap map = chainMapTable.getStateIntensityMap();

        return map;
    }

    public Collection getStateIntensityList() {
        TreeSet sorted = new TreeSet(new MMSorter().getDescending(
                "chainMapTableLineItem.chainCount",
                "chainMapTableLineItem.name"));

        sorted.addAll(this.getStateIntensityMap().values());
        return sorted;
    }



    public String getMapByCensusPath() {
        return mapByCensusPath;
    }



    public void setMapByCensusPath(String mapByCensusPath) {
        this.mapByCensusPath = mapByCensusPath;
    }

    public String getMapByStatePath() {
        return mapByStatePath;
    }

    public void setMapByStatePath(String mapByStatePath) {
        this.mapByStatePath = mapByStatePath;
    }



    public String getBaseCensusMapPath() {
        return baseCensusMapPath;
    }



    public void setBaseCensusMapPath(String baseCensusMapPath) {
        this.baseCensusMapPath = baseCensusMapPath;
    }



    public String getBaseStateMapPath() {
        return baseStateMapPath;
    }



    public void setBaseStateMapPath(String baseStateMapPath) {
        this.baseStateMapPath = baseStateMapPath;
    }

}