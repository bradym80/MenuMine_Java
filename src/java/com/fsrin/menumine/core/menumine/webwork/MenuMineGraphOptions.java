/*
 * Created on Jan 21, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.webwork;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.fsrin.menumine.core.menumine.FieldEnum;

/**
 * @author Nick
 * 
 *  
 */
public class MenuMineGraphOptions implements Serializable {

    private String graphByField;// = FieldEnum.BASIC_PROTEIN.getOgnlName();

    private String graphTitle = "";

    private String graphByType = "pie";

    private String rollUpToLoadName;

    private String aggregationType;

    private String otherItemRollUpType;

    private String simpleFilter;
    
    /*
     * filter settings
     */
    /*
     * none
     */
    private boolean filterNone = true;
    
    /*
     * low pass
     */
    private boolean filterBelowPercentage = true;
    
    private double filterBelowPercentageValue = 1.0;

    private boolean filterBelowPercentageEliminate;
    
    private String filterBelowPercentageLabel = "Below Low Pass Threshold";
    
    /*
     * high pass
     */
    private boolean filterAbovePercentage;
    
    private double filterAbovePercentageValue = 10.0;

    private boolean filterAbovePercentageEliminate;   
    
    private String filterAbovePercentageLabel = "Above High Pass Threshold";
    
    /*
     * combination records
     */
    private boolean filterCombination;
    
    private boolean filterCombinationEliminate;
    
    private String filterCombinationLabel = "Combination Records";
    
    /*
     * keywords
     */
    private boolean filterCommonTerms;
    
    private String filterCommonTermsList;

    /*
     * consolidate by terms
     */
    private boolean filterConsolidateByTerms;
    
    private String filterConsolidateByTermsList;
    
    /*
     * rows with keywords
     */
    private boolean filterKeywordRow;
    
    private String filterKeywordRowTermsList;
    
    private boolean filterKeywordRowEliminate;
    
    private String filterKeywordRowLabel = "Eliminated By Keyword";    
    
    /*
     * combination records
     */
    //    public Collection getGraphByFields() {
    //        return FieldListBuilder.singleton.buildFieldList();
    //    }

    public Map getGraphByTypes() {
        Map map = new HashMap();
        map.put("bar", "Bar");
        map.put("pie", "Pie");
        return map;
    }

    public String getGraphByField() {
        return graphByField;
    }

    public FieldEnum getGraphByFieldEnum() {
        return FieldEnum.getByOgnlName(graphByField);
    }

    public void setGraphByField(String graphByField) {
        this.graphByField = graphByField;
    }

    public String getGraphByType() {
        return graphByType;
    }

    public void setGraphByType(String graphByType) {
        this.graphByType = graphByType;
    }

    public String getGraphTitle() {
        return graphTitle;
    }

    public void setGraphTitle(String graphTitle) {
        this.graphTitle = graphTitle;
    }

    public String getAggregationType() {
        return aggregationType;
    }

    public void setAggregationType(String aggregationType) {
        this.aggregationType = aggregationType;
    }

    public String getOtherItemRollUpType() {
        return otherItemRollUpType;
    }

    public void setOtherItemRollUpType(String otherItemRollUpType) {
        this.otherItemRollUpType = otherItemRollUpType;
    }

    public String getSimpleFilter() {
        return simpleFilter;
    }

    public void setSimpleFilter(String simpleFilter) {
        this.simpleFilter = simpleFilter;
    }

    public boolean isGraphByFieldSelected() {
        return this.getGraphByField() != null
                && this.getGraphByField().length() > 0;
    }

    public String getRollUpToLoadName() {
        return rollUpToLoadName;
    }

    public void setRollUpToLoadName(String rollUpToLoadName) {
        this.rollUpToLoadName = rollUpToLoadName;
    }

    public boolean isFilterBelowPercentage() {
        return filterBelowPercentage;
    }

    public void setFilterBelowPercentage(boolean filterBelowPercentage) {
        this.filterBelowPercentage = filterBelowPercentage;
    }

    public double getFilterBelowPercentageValue() {
        return filterBelowPercentageValue;
    }

    public void setFilterBelowPercentageValue(double filterBelowPercentageValue) {
        this.filterBelowPercentageValue = filterBelowPercentageValue;
    }

    public boolean isFilterNone() {
        return filterNone;
    }

    public void setFilterNone(boolean filterNone) {
        this.filterNone = filterNone;
    }

    public boolean isFilterBelowPercentageEliminate() {
        return filterBelowPercentageEliminate;
    }

    public void setFilterBelowPercentageEliminate(
            boolean filterBelowPercentageEliminate) {
        this.filterBelowPercentageEliminate = filterBelowPercentageEliminate;
    }

    public boolean isFilterAbovePercentage() {
        return filterAbovePercentage;
    }

    public void setFilterAbovePercentage(boolean filterAbovePercentage) {
        this.filterAbovePercentage = filterAbovePercentage;
    }

    public boolean isFilterAbovePercentageEliminate() {
        return filterAbovePercentageEliminate;
    }

    public void setFilterAbovePercentageEliminate(
            boolean filterAbovePercentageEliminate) {
        this.filterAbovePercentageEliminate = filterAbovePercentageEliminate;
    }

    public double getFilterAbovePercentageValue() {
        return filterAbovePercentageValue;
    }

    public void setFilterAbovePercentageValue(double filterAbovePercentageValue) {
        this.filterAbovePercentageValue = filterAbovePercentageValue;
    }

    public String getFilterAbovePercentageLabel() {
        return filterAbovePercentageLabel;
    }

    public void setFilterAbovePercentageLabel(String filterAbovePercentageLabel) {
        this.filterAbovePercentageLabel = filterAbovePercentageLabel;
    }

    public String getFilterBelowPercentageLabel() {
        return filterBelowPercentageLabel;
    }

    public void setFilterBelowPercentageLabel(String filterBelowPercentatageLabel) {
        this.filterBelowPercentageLabel = filterBelowPercentatageLabel;
    }

    public boolean isFilterCombination() {
        return filterCombination;
    }

    public void setFilterCombination(boolean filterCombination) {
        this.filterCombination = filterCombination;
    }

    public boolean isFilterCombinationEliminate() {
        return filterCombinationEliminate;
    }

    public void setFilterCombinationEliminate(boolean filterCombinationEliminate) {
        this.filterCombinationEliminate = filterCombinationEliminate;
    }

    public String getFilterCombinationLabel() {
        return filterCombinationLabel;
    }

    public void setFilterCombinationLabel(String filterCombinationLabel) {
        this.filterCombinationLabel = filterCombinationLabel;
    }

    public boolean isFilterCommonTerms() {
        return filterCommonTerms;
    }

    public void setFilterCommonTerms(boolean filterKeywords) {
        this.filterCommonTerms = filterKeywords;
    }

    public String getFilterCommonTermsList() {
        return filterCommonTermsList;
    }

    public void setFilterCommonTermsList(String filterKeywordsList) {
        this.filterCommonTermsList = filterKeywordsList;
    }

    public boolean isFilterKeywordRow() {
        return filterKeywordRow;
    }

    public void setFilterKeywordRow(boolean filterKeywordRow) {
        this.filterKeywordRow = filterKeywordRow;
    }

    public boolean isFilterKeywordRowEliminate() {
        return filterKeywordRowEliminate;
    }

    public void setFilterKeywordRowEliminate(boolean filterKeywordRowEliminate) {
        this.filterKeywordRowEliminate = filterKeywordRowEliminate;
    }

    public String getFilterKeywordRowLabel() {
        return filterKeywordRowLabel;
    }

    public void setFilterKeywordRowLabel(String filterKeywordRowLabel) {
        this.filterKeywordRowLabel = filterKeywordRowLabel;
    }

    public String getFilterKeywordRowTermsList() {
        return filterKeywordRowTermsList;
    }

    public void setFilterKeywordRowTermsList(String filterKeywordRowTermsList) {
        this.filterKeywordRowTermsList = filterKeywordRowTermsList;
    }

    public boolean isFilterConsolidateByTerms() {
        return filterConsolidateByTerms;
    }

    public void setFilterConsolidateByTerms(boolean filterConsolidateByTerms) {
        this.filterConsolidateByTerms = filterConsolidateByTerms;
    }

    public String getFilterConsolidateByTermsList() {
        return filterConsolidateByTermsList;
    }

    public void setFilterConsolidateByTermsList(String filterConsolidateByTermsList) {
        this.filterConsolidateByTermsList = filterConsolidateByTermsList;
    }
}