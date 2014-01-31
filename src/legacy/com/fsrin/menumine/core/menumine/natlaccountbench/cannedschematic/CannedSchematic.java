/*
 * Created on Jul 7, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.natlaccountbench.cannedschematic;

import java.util.Collection;

import com.fsrin.menumine.core.minefields.MineFields;

/**
 * @author Nick
 * 
 *  
 */
public abstract class CannedSchematic {

    private String name;

    private String mineType;

    private Boolean includeBenchmark = Boolean.TRUE;

    private Boolean includeBenchmarkTrend = Boolean.TRUE;;

    private Boolean includeBenchmarkGraph;

    abstract public Long getId();

    /*
     * MineFields will be looked up using the mineType. There is not use
     * persisting the whole thing.
     */
    private MineFields mineFields;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CannedSchematic() {
        super();

    }

    public abstract Collection getFields();

    public String getMineType() {
        return mineType;
    }

    public void setMineType(String mineType) {
        this.mineType = mineType;
    }

    public MineFields getMineFields() {
        if (this.mineFields == null && this.mineType != null) {
            this.mineFields = MineFields.factory.getByKey(this.mineType);
        }
        return this.mineFields;
    }

    public void setMineFields(MineFields mineFields) {
        this.mineFields = mineFields;
        this.mineType = mineFields.getMineType();
    }

    public Boolean getIncludeBenchmark() {
        return includeBenchmark;
    }

    public void setIncludeBenchmark(Boolean includeBenchmark) {
        this.includeBenchmark = includeBenchmark;
    }

    public Boolean getIncludeBenchmarkGraph() {
        return includeBenchmarkGraph;
    }

    public void setIncludeBenchmarkGraph(Boolean includeBenchmarkGraph) {
        this.includeBenchmarkGraph = includeBenchmarkGraph;
    }

    public Boolean getIncludeBenchmarkTrend() {
        return includeBenchmarkTrend;
    }

    public void setIncludeBenchmarkTrend(Boolean includeBenchmarkTrend) {
        this.includeBenchmarkTrend = includeBenchmarkTrend;
    }
}