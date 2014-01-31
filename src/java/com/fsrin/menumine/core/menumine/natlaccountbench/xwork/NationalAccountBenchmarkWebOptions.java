/*
 * Created on Jun 28, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.natlaccountbench.xwork;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.fsrin.menumine.core.chainmap.xwork.BenchMarkOptions;
import com.fsrin.menumine.core.incidence.IncidenceChain;
import com.fsrin.menumine.core.incidence.IncidenceSector;
import com.fsrin.menumine.core.incidence.IncidenceSegment;
import com.fsrin.menumine.core.incidence.IncidenceTable;
import com.fsrin.menumine.core.incidence.IncidenceTableBuildOptionsWithChains;
import com.fsrin.menumine.core.incidence.IncidenceTableStandardImpl;
import com.fsrin.menumine.core.menumine.chain.ChainDao;
import com.fsrin.menumine.core.menumine.chain.ChainFilterParameters;

/**
 * @author Nick This object will server a dual role in NationalAccountBench, and
 *         Chain Map.
 * 
 * We should break out the code for the sector segment, chain selector
 *  
 */
public class NationalAccountBenchmarkWebOptions extends BenchMarkOptions {

//    private NationalAccountBenchmarkCannedReport cannedReport;

//    private CannedSchematic cannedSchematic;

    public NationalAccountBenchmarkWebOptions() {
        super();

    }

    /*
     * We need to relate the Sectors to the Segments to the Chains. As it turns
     * out an IncidenceTable does just that.
     * 
     * It would be good to abstract that relation ship so we don't directly
     * depend on the IncidenceTable.
     */
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

//    public CannedSchematic getCannedSchematic() {
//        return cannedSchematic;
//    }
//
//    public void setCannedSchematic(CannedSchematic cannedSchematic) {
//        this.cannedSchematic = cannedSchematic;
//    }

    public void selectAllBenchmark() {
        Collection sectors = new ArrayList();
        Collection segments = new ArrayList();
        Collection chains = new ArrayList();
        IncidenceTable table = getSectorSegmentChainRelations();

        for (Iterator iter = table.getIncidenceSectors().iterator(); iter
                .hasNext();) {
            IncidenceSector element = (IncidenceSector) iter.next();
            sectors.add(element.getName());
            for (Iterator iSegment = element.getIncidenceSegments().iterator(); iSegment
                    .hasNext();) {
                IncidenceSegment eSegment = (IncidenceSegment) iSegment.next();
                segments.add(eSegment.getName());
                for (Iterator iChain = eSegment.getIncidenceChains().iterator(); iChain
                        .hasNext();) {
                    IncidenceChain eChain = (IncidenceChain) iChain.next();
                    chains.add(eChain.getName());

                }
            }

        }

        this.setBenchmarkChains(chains);
        this.setBenchmarkSegments(segments);
        this.setBenchmarkSectors(sectors);

    }

    //    /*
    //     * This is specificaly for the chainStateCount
    //     */
    //    public void updateTarget(Collection chainStateCount) {
    //
    //        Collection sectors = new HashSet();
    //        Collection segments = new HashSet();
    //        Collection chains = new HashSet();
    //        IncidenceTable table = getSectorSegmentChainRelations();
    //
    //        for (Iterator iter = table.getIncidenceSectors().iterator(); iter
    //                .hasNext();) {
    //            IncidenceSector element = (IncidenceSector) iter.next();
    //
    //            for (Iterator iSegment = element.getIncidenceSegments().iterator();
    // iSegment
    //                    .hasNext();) {
    //                IncidenceSegment eSegment = (IncidenceSegment) iSegment.next();
    //
    //                for (Iterator iChain = eSegment.getIncidenceChains().iterator(); iChain
    //                        .hasNext();) {
    //                    IncidenceChain eChain = (IncidenceChain) iChain.next();
    //
    //                    for (Iterator iterator = chainStateCount.iterator(); iterator
    //                            .hasNext();) {
    //                        ChainStateCount eChainStateCount = (ChainStateCount) iterator
    //                                .next();
    //                        if (eChainStateCount.getChain()
    //                                .equals(eChain.getName())) {
    //                            chains.add(eChain.getName());
    //                            sectors.add(element.getName());
    //                            segments.add(eSegment.getName());
    //                        }
    //                    }
    //
    //                }
    //            }
    //
    //        }
    //
    //        this.setTargetChains(chains);
    //        this.setTargetSegments(segments);
    //        this.setTargetSectors(sectors);
    //
    //    }
//    public NationalAccountBenchmarkCannedReport getCannedReport() {
//        return cannedReport;
//    }
//
//    public void setCannedReport(
//            NationalAccountBenchmarkCannedReport cannedReport) {
//        this.cannedReport = cannedReport;
//    }
}