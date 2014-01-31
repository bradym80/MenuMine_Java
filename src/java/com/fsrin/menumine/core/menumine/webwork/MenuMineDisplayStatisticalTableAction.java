/*
 * Created on 2005-1-18
 *
 */
package com.fsrin.menumine.core.menumine.webwork;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fsrin.menumine.context.util.BuildStatisticalTableFromActionDelegate;
import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableIF;
import com.opensymphony.xwork.Action;

/**
 * <p>
 * Aka, MenuShare.
 * 
 * @author Nick
 * @version 1
 */

public class MenuMineDisplayStatisticalTableAction extends
        AbstractMenuMineDisplayAction {

    public static final String SPRING_BEAN_NAME = "menuMineDisplayStatisticalTableAction";

    public static final String STATISTICAL_TABLE = "Statistical Table";

    private static final String STATISTICAL_TABLE_AS_EXCEL = "Statistical Table As Excel";

    private static final String DOWNLOAD_TABLE_AS_EXCEL = "Download Table As Excel";

    private StatisticalTableIF table = null;

    // private String submitOptions;

    private String submitOptionsAll;

    Log log = LogFactory.getLog(MenuMineDisplayStatisticalTableAction.class
            .getName());

    private String submitBarGraph;

    private String submitPieGraph;

    public String execute() throws Exception {
        log.debug("starting statistical display action");

        super.execute();

        if (this.getSubmitOptionsAll() != null) {
            this.getMenuMineDisplayOptions().setDisplayType(
                    MenuMineDisplayOptions.DISPLAY_TYPE_MULTI_TABLE);
            return Action.SUCCESS + "-all";
        }

        if (this.getSubmitBarGraph() != null
                || this.getSubmitPieGraph() != null) {
            if (this.getSubmitBarGraph() != null) {
                this.getMenuMineSessionContextWrapper().getLastGraphOptions()
                        .setGraphByType("Bar");
            } else {
                this.getMenuMineSessionContextWrapper().getLastGraphOptions()
                        .setGraphByType("Pie");
            }

            return SUCCESS + "-graph";

        }

        if (this.getMenuMineGraphOptions().getGraphByField() == null
                || this.getMenuMineGraphOptions().getGraphByField().trim()
                        .length() == 0) {
            this.addActionError("You must select a field to group by.");
            return Action.SUCCESS;
        }

        this.getMenuMineDisplayOptions().setDisplayType(STATISTICAL_TABLE);

        this.handleBuildTable();

        this.getMenuMineSessionContextWrapper().setLastGraphOptions(
                this.getMenuMineGraphOptions());

        log.debug("completed");
        return SUCCESS;
    }

    // public String getPostAction()
    // {
    // return "menumineStatisticalTable.action";
    // }

    private void handleBuildTable() throws Exception {

        // table = new StatisticalTableBuilder()
        // .buildStatisticalTable_FromAggregation(
        // this.getMenuMineSessionContextWrapper()
        // .getLastFilterWrapper()
        // .getMasterFoodFilterParameters(), this
        // .getMenuMineGraphOptions(), this
        // .getMenuMineSessionContextWrapper()
        // .getRollUpOptions());
        table = new BuildStatisticalTableFromActionDelegate().build(this);

        /*
         * We don't want this to hang out for too long.
         */
        this.getMenuMineSessionContextWrapper().getLastGraphOptions()
                .setSimpleFilter(null);
        /*
         * Cache the table;
         * 
         * 2006-02-09 RSC Why? 2006-02-10 RSC Helps in roll up building.
         */
        this.getMenuMineSessionContextWrapper().setLastShareTable(table);
    }

    public StatisticalTableIF getStatisticalTableResults() {

        return table;
    }

    // public String getSubmitOptions() {
    // return submitOptions;
    // }
    //
    // public void setSubmitOptions(String submitOptions) {
    //        
    // this.submitOptions = submitOptions;
    // }

    public String getSubmitOptionsAll() {
        return submitOptionsAll;
    }

    public void setSubmitOptionsAll(String submitOptionsAll) {
        this.submitOptionsAll = submitOptionsAll;
    }

    public String getSubmitBarGraph() {
        return submitBarGraph;
    }

    public String getSubmitPieGraph() {
        return submitPieGraph;
    }

    public void setSubmitBarGraph(String submitBarGraph) {
        this.submitBarGraph = submitBarGraph;
    }

    public void setSubmitPieGraph(String submitPieGraph) {
        this.submitPieGraph = submitPieGraph;
    }

}