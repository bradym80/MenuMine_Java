/*
 * Created on Jul 12, 2005
 *
 * 
 */
package com.fsrin.menumine.core.chainmap.xwork;

import java.util.ArrayList;
import java.util.Collection;

import com.fsrin.menumine.core.chainmap.ChainMapTable;
import com.fsrin.menumine.core.chainmap.ChainStateCountCriteriaParamerters;
import com.fsrin.menumine.core.chainmap.ChainStateCountServiceDelegate;
import com.fsrin.menumine.core.incidence.IncidenceTable;
import com.fsrin.menumine.core.incidence.IncidenceTableBuildOptions;
import com.fsrin.menumine.core.incidence.IncidenceTableBuildOptionsWithChains;
import com.fsrin.menumine.core.incidence.IncidenceTableStandardImpl;
import com.fsrin.menumine.core.menumine.chain.ChainDao;
import com.fsrin.menumine.core.menumine.chain.ChainFilterParameters;

/**
 * @author Nick
 * 
 *  
 */
public class ChainMapSetTargetCollectionAction extends AbstractChainMapAction {

//    private ChainMapWebOptions chainMapWebOptions;
//
//    //private Collection targetCol;
//
//    private MenuMineSessionContextWrapper menuMineSessionContextWrapper;
//
//    private ChainMapContext chainMapContext;

    private ChainStateCountServiceDelegate chainStateCountServiceDelegate;

    public String execute() throws Exception {
        getTargetChainStateCounts();
        geBenchmarkChainStateCounts();

        return super.execute();
    }

//    public ChainMapContext getChainMapContext() {
//        return chainMapContext;
//    }
//
//    public void setChainMapContext(ChainMapContext chainMapContext) {
//        this.chainMapContext = chainMapContext;
//    }

    public ChainMapTable getChainMapTable() {
        ChainMapTable table = ChainMapTable.builder.build(this
                .getTargetChainStateCounts(), this.geBenchmarkChainStateCounts());

        return table;
    }

    /*
     * 2006-01-17 RSC Renamed from getBase... to getBenchmark.
     */
    private Collection geBenchmarkChainStateCounts() {
        Collection col = null;
        /*
         * If we have a target, look up the new target.
         */

        ChainStateCountCriteriaParamerters p = new ChainStateCountCriteriaParamerters();
        if (this.getChainMapWebOptions().getBenchmarkChains() != null) {
            Collection bench = this.getChainMapWebOptions()
                    .getBenchmarkChains();
            p.setChains(bench);
        }
        col = this.getServiceDelegate().search(p);
        this.getChainMapContext().setChainStateCountsBase(col);
        return col;

    }

    /*
     * 2006-01-17 RSC renamed to getTarget...
     */
    private Collection getTargetChainStateCounts() {
        Collection col = null;
        /*
         * If we have a target, look up the new target.
         */
        Collection target = this.getChainMapWebOptions().getTargetChains();

        if (target != null && target.size() > 0) {
            ChainStateCountCriteriaParamerters p = new ChainStateCountCriteriaParamerters();
            p.setChains(target);
            col = this.getServiceDelegate().search(p);
            this.getChainMapContext().setChainStateCounts(col);
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

//    public MenuMineSessionContextWrapper getMenuMineSessionContextWrapper() {
//        return menuMineSessionContextWrapper;
//    }
//
//    public void setMenuMineSessionContextWrapper(
//            MenuMineSessionContextWrapper menuMineSessionContextWrapper) {
//        this.menuMineSessionContextWrapper = menuMineSessionContextWrapper;
//    }

    //    public Collection getTargetCol() {
    //        return targetCol;
    //    }
    //
    //    public void setTargetCol(Collection targetCol) {
    //        this.targetCol = targetCol;
    //    }

    private IncidenceTable table;

    public IncidenceTable getSectorSegmentChainRelations() {

        if (table == null) {
            Collection chains = ChainDao.factory.build().find(
                    new ChainFilterParameters());
            IncidenceTableBuildOptionsWithChains options = new IncidenceTableBuildOptionsWithChains();
            options.setResults(new ArrayList());
            options.setBaseChains(chains);
            options.setYear(new Integer(2005));

            table = new IncidenceTableStandardImpl(options);
        }
        return table;
    }

//    public ChainMapWebOptions getChainMapWebOptions() {
//        return chainMapWebOptions;
//    }
//
//    public void setChainMapWebOptions(ChainMapWebOptions chainMapWebOptions) {
//        this.chainMapWebOptions = chainMapWebOptions;
//    }
}