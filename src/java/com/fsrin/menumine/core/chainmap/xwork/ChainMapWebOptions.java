/*
 * Created on Jun 28, 2005
 *
 * 
 */
package com.fsrin.menumine.core.chainmap.xwork;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

import com.fsrin.menumine.core.chainmap.ChainStateCount;
import com.fsrin.menumine.core.chainstat.ChainStat;
import com.fsrin.menumine.core.chainstat.ChainStatFilterParameters;
import com.fsrin.menumine.core.chainstat.ChainStatSearchException;
import com.fsrin.menumine.core.chainstat.ChainStatServiceDelegate;
import com.fsrin.menumine.core.incidence.IncidenceChain;
import com.fsrin.menumine.core.incidence.IncidenceSector;
import com.fsrin.menumine.core.incidence.IncidenceSegment;
import com.fsrin.menumine.core.incidence.IncidenceTable;
import com.fsrin.menumine.core.incidence.IncidenceTableBuildOptionsWithChains;
import com.fsrin.menumine.core.incidence.IncidenceTableStandardImpl;

/**
 * 
 * This allows us to have the sector segment, chain selector.
 *  
 */
public class ChainMapWebOptions extends BenchMarkOptions {



//    private IncidenceTable table;

    /*
     * Overridden so we can limit to only chains that have a stateCount
     * (non-Javadoc)
     * 
     * @see com.fsrin.menumine.core.chainmap.xwork.BenchMarkOptions#getSectorSegmentChainRelations()
     */
    public IncidenceTable getSectorSegmentChainRelations() {

        if (this.getTable() == null) {
            this.setTable( this.handleTableGenerate());
        }

        return this.getTable();
    }
    
    private IncidenceTable handleTableGenerate() {
        
        IncidenceTable t = null;
        
        Collection chains;
        try {
            ChainStatFilterParameters p = new ChainStatFilterParameters();
            p.setIncludeChainStateCount(Boolean.TRUE);
            chains = ChainStatServiceDelegate.factory.build().find(p);

            Collection filtered = new ArrayList();
            for (Iterator iter = chains.iterator(); iter.hasNext();) {
                ChainStat element = (ChainStat) iter.next();
                if (element.getChainStateCount() != null) {
                    filtered.add(element);
                }
            }

            IncidenceTableBuildOptionsWithChains options = new IncidenceTableBuildOptionsWithChains();
        options.setResults(new ArrayList());
        options.setBaseChains(filtered);
        options.setYear(new Integer(2005));
           
        t = new IncidenceTableStandardImpl(options);
        } catch (ChainStatSearchException e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to load ChainMap Options.");

        }
        
        return t;
    }

    public void selectAllBenchmark() {
        
        Collection sectors = new ArrayList();
        Collection segments = new ArrayList();
        Collection chains = new ArrayList();
        IncidenceTable incidenceTable = getSectorSegmentChainRelations();

        for (Iterator iter = incidenceTable.getIncidenceSectors().iterator(); iter
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

    /*
     * This is specificaly for the chainStateCount
     */
    public void updateTarget(Collection chainStateCount) {

        Collection sectors = new HashSet();
        Collection segments = new HashSet();
        Collection chains = new HashSet();
        IncidenceTable incidenceTable = getSectorSegmentChainRelations();

        for (Iterator iter = incidenceTable.getIncidenceSectors().iterator(); iter
                .hasNext();) {
            IncidenceSector element = (IncidenceSector) iter.next();

            for (Iterator iSegment = element.getIncidenceSegments().iterator(); iSegment
                    .hasNext();) {
                IncidenceSegment eSegment = (IncidenceSegment) iSegment.next();

                for (Iterator iChain = eSegment.getIncidenceChains().iterator(); iChain
                        .hasNext();) {
                    IncidenceChain eChain = (IncidenceChain) iChain.next();

                    for (Iterator iterator = chainStateCount.iterator(); iterator
                            .hasNext();) {
                        ChainStateCount eChainStateCount = (ChainStateCount) iterator
                                .next();
                        if (eChainStateCount.getChain()
                                .equals(eChain.getName())) {
                            chains.add(eChain.getName());
                            sectors.add(element.getName());
                            segments.add(eSegment.getName());
                        }
                    }

                }
            }

        }

        this.setTargetChains(chains);
        this.setTargetSegments(segments);
        this.setTargetSectors(sectors);

    }

}