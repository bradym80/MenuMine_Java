/*
 * Created on 2005-1-18
 *
 */
package com.fsrin.menumine.core.menumine.webwork;

import org.jfree.chart.JFreeChart;

import com.fsrin.menumine.core.incidence.IncidenceTable;
import com.fsrin.menumine.core.incidence.IncidenceTableBuildOptions;
import com.fsrin.menumine.core.incidence.IncidenceTableBuilder;
import com.fsrin.menumine.core.menumine.FieldEnum;
import com.fsrin.menumine.core.menumine.webwork.util.GraphWriterUtilFactory;


/**
 * @author Nick
 * @version 1
 */

public class MenuMineDisplayItemsPerChainMenuingAction extends
        AbstractCategoryIncidenceAction  {

    private static final String ITEMS_PER_CHAIN_MENUING = "Items Per Chain Menuing";
    private static final String VIEW_ITEMS_PER_CHAIN_MENUING_SECTOR_GRAPH = "View Items Per Chain Menuing Sector Graph";
    private static final String VIEW_SECTOR_GRAPH = "View Sector Graph";
    private static final String DOWNLOAD_ITEMS_PER_CHAIN_MENUING_AS_EXCEL = "Download Items Per Chain Menuing As Excel";

    private IncidenceTable incidenceTableTable;
    
    public String execute() throws Exception {
        super.execute();
        
        this.setSubmitOptions(this.getSubmitOptionsItems());
        
        if (this.getSubmitOptions() != null
                && this.getSubmitOptions().equals(
                        DOWNLOAD_ITEMS_PER_CHAIN_MENUING_AS_EXCEL)) {
            this.getMenuMineDisplayOptions().setDisplayType(
                    DOWNLOAD_ITEMS_PER_CHAIN_MENUING_AS_EXCEL);

        } else if (this.getSubmitOptions() != null
                && this.getSubmitOptions().equals(VIEW_SECTOR_GRAPH)) {
            this.getMenuMineDisplayOptions().setDisplayType(
                    VIEW_ITEMS_PER_CHAIN_MENUING_SECTOR_GRAPH);

            this.buildGraph();
            
        } else {
            this.getMenuMineDisplayOptions().setDisplayType(
                    ITEMS_PER_CHAIN_MENUING);
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
//        try {

            if (incidenceTableTable == null) {
                IncidenceTableBuildOptions options = new IncidenceTableBuildOptions();
                options.setParams(this.getMenuMineSessionContextWrapper().getLastFilterWrapper().getMasterFoodFilterParameters());
//                options.setResults(this.getResults());
//                options.setBaseChains(this.getAllChainList());
                options.setYear(this.getTargetYear());

                /*
                 * 2006-01-31 RSC
                 */
//                incidenceTableTable = MenuMineResultsDisplayWrapperBuilder.singleton
//                        .buildIncidenceTable(options);
                incidenceTableTable = new IncidenceTableBuilder().buildItemsPerChainIncidence(options);

            }
//        } catch (IncidenceTableException e) {
//
//            e.printStackTrace();
//            return null;
//        }

        return incidenceTableTable;
    }

    private void buildGraph() throws Exception {
        /*
         * nick 2005-2-18 We chain here through the catincidence. This way it
         * will be on the stack and we can use it as a datasource for the stat
         * tables as it already handle the code to build a table.
         */

//        OgnlValueStack stack = ActionContext.getContext().getActionInvocation()
//                .getStack();

        IncidenceTable incidenceTable = this.getIncidenceTableResults();

        //  Collection results = stats.getRows();

        String titleString = getTitle();

        JFreeChart chart = new ChartBuilder().buildItemsPerChainMenuingGraph(
                incidenceTable, titleString, 23);
        
        String file = new GraphWriterUtilFactory().build().write(chart);
        
        this.setImagePath(file);
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

        String titleString = "MenuMine Items Per Chain Menuing - " + title;
        //  + " - % Distribution - Base: " + getResults().size();
        return titleString;

    }


}