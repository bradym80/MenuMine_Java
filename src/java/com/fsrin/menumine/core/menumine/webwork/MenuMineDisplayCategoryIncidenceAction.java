/*
 * Created on 2005-1-18
 *
 */
package com.fsrin.menumine.core.menumine.webwork;

import ognl.Ognl;

import org.jfree.chart.JFreeChart;

import com.fsrin.menumine.core.incidence.IncidenceTable;
import com.fsrin.menumine.core.incidence.IncidenceTableBuildOptions;
import com.fsrin.menumine.core.incidence.IncidenceTableBuilder;
import com.fsrin.menumine.core.menumine.FieldEnum;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;
import com.fsrin.menumine.core.menumine.webwork.util.GraphWriterUtilFactory;
import com.opensymphony.xwork.ActionContext;
import com.opensymphony.xwork.util.OgnlValueStack;

/**
 * @author Nick
 * @version 1
 */

public class MenuMineDisplayCategoryIncidenceAction extends
        AbstractCategoryIncidenceAction {

    public static final String CATEGORY_INCIDENCE = "Category Incidence";

    public static final String VIEW_CATEGORY_INCIDENCE_SECTOR_GRAPH = "View Category Incidence Sector Graph";

    public static final String VIEW_SECTOR_GRAPH = "View Sector Graph";

    public static final String DOWNLOAD_CATEGORY_INCIDENCE_AS_EXCEL = "Download Category Incidence As Excel";

    private IncidenceTable incidenceTableTable;

    public String execute() throws Exception {
        super.execute();
        
        if (this.getSubmitOptionsItems() != null) {
            return SUCCESS + "-items";
        }
        
        if (this.getSubmitOptions() != null
                && this.getSubmitOptions().equals(
                        DOWNLOAD_CATEGORY_INCIDENCE_AS_EXCEL)) {
            this.getMenuMineDisplayOptions().setDisplayType(
                    DOWNLOAD_CATEGORY_INCIDENCE_AS_EXCEL);

        } else if (this.getSubmitOptions() != null
                && this.getSubmitOptions().equals(VIEW_SECTOR_GRAPH)) {
            this.getMenuMineDisplayOptions().setDisplayType(
                    VIEW_CATEGORY_INCIDENCE_SECTOR_GRAPH);

            this.buildGraph();
            
        } else {
            this.getMenuMineDisplayOptions().setDisplayType(CATEGORY_INCIDENCE);
        }

        return SUCCESS;

    }

    public boolean isRollUp() {
        return this.getMenuMineDisplayOptions().isRollUp();

    }

    public void setRollUp(boolean rollUp) {
        this.getMenuMineDisplayOptions().setRollUp(rollUp);
    }

    public Integer getTargetYear() {
        return this.getMenuMineDisplayOptions().getTargetYear();
    }

    public String getTargetYearString() {
        return this.getTargetYear().toString();
    }

    public void setTargetYear(Integer targetYear) {
        this.getMenuMineDisplayOptions().setTargetYear(targetYear);
    }

    public IncidenceTable getIncidenceTableResults() {
  

            if (incidenceTableTable == null) {
                
                MasterFoodFilterParameters p = this.getMenuMineSessionContextWrapper().getLastFilterWrapper().getMasterFoodFilterParameters().clone();
                
                try {
                    Ognl.setValue("price" + this.getTargetYearString() + ".empty", p, Boolean.FALSE);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                
                IncidenceTableBuildOptions options = new IncidenceTableBuildOptions();
                
                options
                        .setParams(p);

                options.setYear(this.getTargetYear());


                

                
                incidenceTableTable = new IncidenceTableBuilder().buildCategoryIncidenceTable(options);
            }


        return incidenceTableTable;
    }
    
    private void buildGraph() throws Exception {
        /*
         * nick 2005-2-18 We chain here through the catincidence. This way it
         * will be on the stack and we can use it as a datasource for the stat
         * tables as it already handle the code to build a table.
         */

        OgnlValueStack stack = ActionContext.getContext().getActionInvocation()
                .getStack();

        IncidenceTable incidenceTable = this.getIncidenceTableResults();
        //  Collection results = stats.getRows();

        String titleString = getTitle();

        JFreeChart chart = new ChartBuilder().buildCategoryIncidenceGraph(
                incidenceTable, titleString, 23);
        
        String path = new GraphWriterUtilFactory().build().write(chart);
        
        this.setImagePath(path);
    }

    private String getTitle() {
        String title = this.getMenuMineSessionContextWrapper()
                .getLastGraphOptions().getGraphTitle();

        if (title == null || title.equals("")) {
            String key = this.getMenuMineSessionContextWrapper()
                    .getLastGraphOptions().getGraphByField();

            FieldEnum f = FieldEnum.getByOgnlName(key);
            if (f != null) {

                title = f.getFriendlyName();
            }
        }

        String titleString = "MenuMine Category Incidence - " + title;
        //  + " - % Distribution - Base: " + getResults().size();
        return titleString;

    }


}