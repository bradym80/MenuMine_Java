/*
 * Created on 2005-1-18
 *
 */
package com.fsrin.menumine.core.menumine.webwork;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fsrin.menumine.common.util.ExceptionUtilities;
import com.fsrin.menumine.common.util.MiscellaneousNotificationAlert;
import com.fsrin.menumine.context.util.BuildStatisticalTableFromActionDelegate;
import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableIF;

/**
 * <p>
 * Different than V1 in that it handles multiple share tables for all displayed
 * fields.
 * 
 * 
 * 
 * @version 1
 */

public class MenuMineDisplayStatisticalTableActionV2 extends
        AbstractMenuMineDisplayAction {

    public static final String SPRING_BEAN_NAME = "menuMineDisplayStatisticalTableAction";

    public static final String MULTIPLE_STATISTICAL_TABLE = "Multiple Statistical Tables";

    private static final String STATISTICAL_TABLE_AS_EXCEL = "Statistical Table As Excel";

    private static final String DOWNLOAD_TABLE_AS_EXCEL = "Download Table As Excel";

    // v1
    private StatisticalTableIF table = null;

    // v2
    private Collection tables = null;
    
    Log log = LogFactory.getLog(MenuMineDisplayStatisticalTableActionV2.class
            .getName());

    public String execute() throws Exception {
        
        log.debug("starting statistical display action");
        super.execute();
        



        // if (this.getMenuMineGraphOptions().getGraphByField() == null
        // || this.getMenuMineGraphOptions().getGraphByField().trim()
        // .length() == 0) {
        // this.addActionError("You must select a field to group by.");
        // return Action.SUCCESS;
        // }
        // if (this.getSubmitOptions() != null
        // && this.getSubmitOptions().equals(DOWNLOAD_TABLE_AS_EXCEL)) {
        // this.getMenuMineDisplayOptions().setDisplayType(
        // STATISTICAL_TABLE_AS_EXCEL);
        //
        // } else {
        this.getMenuMineDisplayOptions().setDisplayType(MULTIPLE_STATISTICAL_TABLE);

        try {
            this.handleBuildTable();
        } catch (Exception e) {
            new MiscellaneousNotificationAlert().sendAlert(
                    "wasn't able to build tables in V2 "
                            + ExceptionUtilities.getExceptionStackTrace(e),
                    this.getMenuMineSessionContextWrapper()
                            .getMenuMineSessionContext());
            this.getMenuMineSessionContextWrapper().getErrorContext().addError("We experienced an error while creating these graphs.  FSRIN has been notified.  Call 888-386-MENU for support. ");
        }
        // }

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

        // v1
        // table = new BuildStatisticalTableFromActionDelegate().build(this);
        tables = new BuildStatisticalTableFromActionDelegate()
                .buildForDisplayedFields(this);

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

    // v1
    public StatisticalTableIF getStatisticalTableResults() {

        return table;
    }

    public Collection getAllStatisticalTables() {

        return tables;
    }

}