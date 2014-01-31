/*
 * Created on Jan 21, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.webwork;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fstx.stdlib.common.simpledate.SimpleDate;

/**
 * @author Nick
 * 
 * 
 */
public class MenuMineDisplayOptions implements Serializable {

    public static final String DISPLAY_TYPE_SPREADSHEET = "Display Spreadsheet";

    public static final String DISPLAY_RESET = "Reset";

    public static final String DISPLAY_TYPE_SINGLE_TABLE = "Single Table";
    
    public static final String DISPLAY_TYPE_TREND_TABLE = "Trend Table";
    
    public static final String DISPLAY_TYPE_MULTI_TABLE = "Multi Table";
    
    public static final String DISPLAY_TYPE_GRAPH = "Graph";
    /*
     * NAH This is currently a key used to determine how we should view the
     * data, we end up using it to determine which jsp to include. We need to
     * refactor it so main views include query menu, Summary and tabs rather
     * that menumine.jsp figuring out with jsp to include.
     */
    private String displayType = "none";

    private String sortType;

    private String sortBy;

    private String title = "MenuMine";
    
    

    private boolean rollUp = false;

    private Log log = LogFactory.getLog(MenuMineDisplayOptions.class);

    private Integer targetYear = new Integer(SimpleDate.factory.build()
            .getYear());

    public MenuMineDisplayOptions() {
        super();

    }

    public Map getDisplayTypes() {
        Map types = new HashMap();
        types.put("standard", "Standard");
        types.put("statisticalTable", "Statistical Table");
        types.put("graphBar", "Graph Bar");
        types.put("graphPie", "Graph Pie");
        return types;
    }

    public String getDisplayType() {
        log.debug("Display Type is " + displayType);
        return displayType;
    }

    public void setDisplayType(String displayType) {
        this.displayType = displayType;
    }

    public Map getSortByDirectionOptions() {
        Map map = new HashMap();
        map.put("DESC", "Descending (Z-A)");
        map.put("ASC", "Ascending (A-Z)");
        return map;

    }

    // public Collection getSortByFieldOptions() {
    // return FieldListBuilder.singleton.buildFieldList();
    //
    // }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public String getSortType() {
        return sortType;
    }

    public void setSortType(String sortType) {
        this.sortType = sortType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isRollUp() {
        return rollUp;
    }

    public void setRollUp(boolean rollUp) {
        this.rollUp = rollUp;
    }

    public Integer getTargetYear() {
        return targetYear;
    }

    public void setTargetYear(Integer targetYear) {
        this.targetYear = targetYear;
    }

    public boolean isFilterable() {
        boolean ret = false;

        ret = this.getDisplayType().equalsIgnoreCase("statistical table")
                || this.getDisplayType().equalsIgnoreCase("mean price trend")
                || this.getDisplayType().equalsIgnoreCase("graph");

        return ret;
    }
    
    

}