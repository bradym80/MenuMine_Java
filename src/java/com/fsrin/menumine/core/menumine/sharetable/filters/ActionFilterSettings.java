/*
 * Created on Apr 5, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.sharetable.filters;

/**
 * a simple VO to handle checkbox settings gracefully.
 * 
 * @author Reid
 */
public class ActionFilterSettings {

    private boolean filterNone;
    
    private boolean filterLowPass;
    
    private boolean filterHighPass;
    
    private boolean filterCombination;
    
    private boolean filterCommonTerms;
    
    private boolean filterKeywordRow;
    
    private boolean filterConsolidateByTerms;

    public boolean isFilterConsolidateByTerms() {
        return filterConsolidateByTerms;
    }

    public void setFilterConsolidateByTerms(boolean filterConsolidateByTerms) {
        this.filterConsolidateByTerms = filterConsolidateByTerms;
    }

    public boolean isFilterHighPass() {
        return filterHighPass;
    }

    public void setFilterHighPass(boolean filterHighPass) {
        this.filterHighPass = filterHighPass;
    }

    public boolean isFilterLowPass() {
        return filterLowPass;
    }

    public void setFilterLowPass(boolean filterLowPass) {
        this.filterLowPass = filterLowPass;
    }

    public boolean isFilterNone() {
        return filterNone;
    }

    public void setFilterNone(boolean filterNone) {
        this.filterNone = filterNone;
    }

    public boolean isFilterCombination() {
        return filterCombination;
    }

    public void setFilterCombination(boolean filterCombination) {
        this.filterCombination = filterCombination;
    }

    public boolean isFilterCommonTerms() {
        return filterCommonTerms;
    }

    public void setFilterCommonTerms(boolean filterKeywords) {
        this.filterCommonTerms = filterKeywords;
    }

    public boolean isFilterKeywordRow() {
        return filterKeywordRow;
    }

    public void setFilterKeywordRow(boolean filterKeywordRowFilter) {
        this.filterKeywordRow = filterKeywordRowFilter;
    }
    
    
}
