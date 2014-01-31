/*
 * Created on Jul 21, 2005
 *
 * 
 */
package com.fsrin.menumine.core.chainmap.xwork;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.fsrin.menumine.core.incidence.IncidenceSector;
import com.fsrin.menumine.core.incidence.IncidenceSegment;
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
public class BenchMarkOptions {
    private Collection targetChains;

    private Collection benchmarkChains;

    private Collection targetSectors;

    private Collection benchmarkSectors;

    private Collection targetSegments;

    private Collection benchmarkSegments;

    private IncidenceTable table;

    // private CannedSchematic cannedSchematic;

    public IncidenceTable getTable() {
        return table;
    }

    public void setTable(IncidenceTable table) {
        this.table = table;
    }

    public BenchMarkOptions() {
        super();

    }

    public Collection getBenchmarkChainsOptions() {
        Collection chainsOptions = new ArrayList();

        if (this.getBenchmarkSectors() != null) {
            for (Iterator iter = this.getSectorSegmentChainRelations()
                    .getIncidenceSectors().iterator(); iter.hasNext();) {
                IncidenceSector incidenceSectorElement = (IncidenceSector) iter
                        .next();
                for (Iterator iterator = this.getBenchmarkSectors().iterator(); iterator
                        .hasNext();) {
                    String element = (String) iterator.next();
                    if (incidenceSectorElement.getName() != null
                            && incidenceSectorElement.getName().equals(element)) {
                        // chainsOptions.addAll(incidenceSectorElement.getIncidenceSegments());
                        for (Iterator iteratorSegments = incidenceSectorElement
                                .getIncidenceSegments().iterator(); iteratorSegments
                                .hasNext();) {
                            IncidenceSegment incidenceSegmentElement = (IncidenceSegment) iteratorSegments
                                    .next();
                            for (Iterator iteratorSegmentsSelected = this
                                    .getBenchmarkSegments().iterator(); iteratorSegmentsSelected
                                    .hasNext();) {
                                String selectedSegementElement = (String) iteratorSegmentsSelected
                                        .next();
                                if (incidenceSegmentElement.getName() != null
                                        && incidenceSegmentElement
                                                .getName()
                                                .equals(selectedSegementElement)) {
                                    chainsOptions
                                            .addAll(incidenceSegmentElement
                                                    .getIncidenceChains());
                                }
                            }

                        }

                    }
                }

            }
        }
        return chainsOptions;
    }

    public Collection getBenchmarkSegmentsOptions() {

        Collection segmentOptions = new ArrayList();

        if (this.getBenchmarkSectors() != null) {
            for (Iterator iter = this.getSectorSegmentChainRelations()
                    .getIncidenceSectors().iterator(); iter.hasNext();) {
                IncidenceSector incidenceSectorElement = (IncidenceSector) iter
                        .next();
                for (Iterator iterator = this.getBenchmarkSectors().iterator(); iterator
                        .hasNext();) {
                    String element = (String) iterator.next();
                    if (incidenceSectorElement.getName() != null
                            && incidenceSectorElement.getName().equals(element)) {
                        segmentOptions.addAll(incidenceSectorElement
                                .getIncidenceSegments());
                    }
                }

            }
        }
        return segmentOptions;
    }

    public Collection getBenchmarkSectorsOptions() {
        return this.getSectorSegmentChainRelations().getIncidenceSectors();
    }

    public Collection getTargetChainsOptions() {
        Collection chainsOptions = new ArrayList();

        if (this.getTargetSectors() != null) {
            for (Iterator iter = this.getSectorSegmentChainRelations()
                    .getIncidenceSectors().iterator(); iter.hasNext();) {
                IncidenceSector incidenceSectorElement = (IncidenceSector) iter
                        .next();
                for (Iterator iterator = this.getTargetSectors().iterator(); iterator
                        .hasNext();) {
                    String element = (String) iterator.next();
                    if (incidenceSectorElement.getName() != null
                            && incidenceSectorElement.getName().equals(element)) {
                        // chainsOptions.addAll(incidenceSectorElement.getIncidenceSegments());
                        for (Iterator iteratorSegments = incidenceSectorElement
                                .getIncidenceSegments().iterator(); iteratorSegments
                                .hasNext();) {
                            IncidenceSegment incidenceSegmentElement = (IncidenceSegment) iteratorSegments
                                    .next();
                            for (Iterator iteratorSegmentsSelected = this
                                    .getTargetSegments().iterator(); iteratorSegmentsSelected
                                    .hasNext();) {
                                String selectedSegementElement = (String) iteratorSegmentsSelected
                                        .next();
                                if (incidenceSegmentElement.getName() != null
                                        && incidenceSegmentElement
                                                .getName()
                                                .equals(selectedSegementElement)) {
                                    chainsOptions
                                            .addAll(incidenceSegmentElement
                                                    .getIncidenceChains());
                                }
                            }

                        }

                    }
                }

            }
        }
        return chainsOptions;
    }

    public Collection getTargetSegmentsOptions() {

        Collection segmentOptions = new ArrayList();

        if (this.getTargetSectors() != null) {
            for (Iterator iter = this.getSectorSegmentChainRelations()
                    .getIncidenceSectors().iterator(); iter.hasNext();) {
                IncidenceSector incidenceSectorElement = (IncidenceSector) iter
                        .next();
                for (Iterator iterator = this.getTargetSectors().iterator(); iterator
                        .hasNext();) {
                    String element = (String) iterator.next();
                    if (incidenceSectorElement.getName() != null
                            && incidenceSectorElement.getName().equals(element)) {
                        segmentOptions.addAll(incidenceSectorElement
                                .getIncidenceSegments());
                    }
                }

            }
        }
        return segmentOptions;
    }

    public Collection getTargetSectorsOptions() {
        Collection ret = this.getSectorSegmentChainRelations()
                .getIncidenceSectors();
        return ret;
    }

    /*
     * We need to relate the Sectors to the Segments to the Chains. As it turns
     * out an IncidenceTable does just that.
     * 
     * It would be good to abstract that relation ship so we don't directly
     * depend on the IncidenceTable.
     */

    public IncidenceTable getSectorSegmentChainRelations() {

        if (this.getTable() == null) {
            Collection chains = ChainDao.factory.build().find(
                    new ChainFilterParameters());

            IncidenceTableBuildOptionsWithChains options = new IncidenceTableBuildOptionsWithChains();
            options.setResults(new ArrayList());
            options.setBaseChains(chains);
            options.setYear(new Integer(2005));

            this.setTable(new IncidenceTableStandardImpl(options));
        }
        return this.getTable();
    }

    public Collection getBenchmarkChains() {
        return benchmarkChains;
    }

    public void setBenchmarkChains(Collection benchmarkChains) {
        this.benchmarkChains = benchmarkChains;
    }

    public Collection getTargetChains() {
        return targetChains;
    }

    public void setTargetChains(Collection targetChains) {
        this.targetChains = targetChains;
    }

    public Collection getBenchmarkSectors() {
        return benchmarkSectors;
    }

    public void setBenchmarkSectors(Collection benchmarkSectors) {
        this.benchmarkSectors = benchmarkSectors;
    }

    public Collection getBenchmarkSegments() {
        return benchmarkSegments;
    }

    public void setBenchmarkSegments(Collection benchmarkSegments) {
        this.benchmarkSegments = benchmarkSegments;
    }

    public Collection getTargetSectors() {
        return targetSectors;
    }

    public void setTargetSectors(Collection targetSectors) {
        this.targetSectors = targetSectors;
    }

    public Collection getTargetSegments() {
        return targetSegments;
    }

    public void setTargetSegments(Collection targetSegments) {
        this.targetSegments = targetSegments;
    }

    // public CannedSchematic getCannedSchematic() {
    // return cannedSchematic;
    // }
    //
    // public void setCannedSchematic(CannedSchematic cannedSchematic) {
    // this.cannedSchematic = cannedSchematic;
    // }

}