/*
 * Created on 2005-1-18
 *
 */
package com.fsrin.menumine.core.menumine.webwork;

import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fsrin.menumine.core.crosstab.CrossTabulationTable;
import com.fsrin.menumine.core.crosstab.CrossTabulationTableBuilder;
import com.fsrin.menumine.core.menumine.rollup.RollUpElement;
import com.fsrin.menumine.core.menumine.rollup.RollUpOptions;
import com.fsrin.menumine.core.menumine.rollup.RollUpServiceDelegate;
import com.fsrin.menumine.core.menumine.rollup.RollUpServiceDelegateException;

/**
 * @author Nick
 * @version 1
 */

public class MenuMineDisplayCrossTabulationAction extends AbstractMenuMineDisplayAction {

    private static final String CROSS_TABULATION = "Cross Tabulation";

    private static final String DOWNLOAD_CROSS_TAB_AS_EXCEL = "Download Cross Tab As Excel";

    private static final Log log = LogFactory
            .getLog(MenuMineDisplayCrossTabulationAction.class);

    private CrossTabulationTable crossTabulationResults;

    public String execute() throws Exception {
        super.execute();
        if (this.getSubmitOptions() != null
                && this.getSubmitOptions().equals(DOWNLOAD_CROSS_TAB_AS_EXCEL)) {
            this.getMenuMineDisplayOptions().setDisplayType(
                    DOWNLOAD_CROSS_TAB_AS_EXCEL);

        } else {
            this.getMenuMineDisplayOptions().setDisplayType(CROSS_TABULATION);
        }

        this.getMenuMineSessionContextWrapper().setLastCrossTabulationOptions(
                this.getMenuMineCrossTabulationOptions());

        if (!this.getMenuMineCrossTabulationOptions().isFieldsSelected()) {
            return SUCCESS;
        }

        this.handleBuildResults();

        return SUCCESS;
    }

    private void handleBuildResults() {

        // try {

        /*
         * Set up the roll ups. 2006-02-03 RSC Simplified.
         */
        // RollUpOptions vRollUp = null;
        String vName = this.getMenuMineCrossTabulationOptions()
                .getVerticalRollUpName();
        // if (vName != null) {
        // for (Iterator iter = this.getSavedRollUps().iterator(); iter
        // .hasNext();) {
        // /*
        // * going through a list of saved roll ups and bringing
        // * it back by name.
        // */
        // RollUpOptions element = (RollUpOptions) iter.next();
        // if (vName.equals(element.getName())) {
        // vRollUp = element;
        // }
        // }
        // }
        this.getMenuMineCrossTabulationOptions().setVerticalRollUpOptions(
                this.resolveRollUpOptions(vName));

        /*
         * 2006-02-03 RSC Simplified.
         */
        // RollUpOptions hRollUp = null;
        String hName = this.getMenuMineCrossTabulationOptions()
                .getHorizontalRollUpName();
        // if (hName != null) {
        // for (Iterator iter = this.getSavedRollUps().iterator(); iter
        // .hasNext();) {
        // RollUpOptions element = (RollUpOptions) iter.next();
        // if (hName.equals(element.getName())) {
        // hRollUp = element;
        // }
        // }
        // }
        this.getMenuMineCrossTabulationOptions().setHorizontalRollUpOptions(
                this.resolveRollUpOptions(hName));

        /*
         * 2006-01-31 RSC
         */
        // crossTabulationTable =
        // MenuMineResultsDisplayWrapperBuilder.singleton
        // .buildCrossTabulationTable(this.getResults(), this
        // .getMenuMineCrossTabulationOptions());
        this.getMenuMineCrossTabulationOptions().setFilter(
                this.getMenuMineSessionContextWrapper().getLastFilterWrapper()
                        .getMasterFoodFilterParameters());

        CrossTabulationTable table = new CrossTabulationTableBuilder()
                .build(this.getMenuMineCrossTabulationOptions());

        // } catch (OgnlException e) {
        //
        // e.printStackTrace();
        // return null;
        // }

        this.crossTabulationResults = table;

    }

    private RollUpOptions resolveRollUpOptions(String name) {

        /*
         * 2006-02-03 RSC We have two of these since the ones in memory have a
         * stale session reference and will fail when we try to load the
         * options.
         */

        RollUpOptions ret = null;

        if (name != null) {


                try {
                    ret = RollUpServiceDelegate.factory.build().getByName(name,
                            this.getMenuMineSessionContextWrapper().getAuthenticatedUser().getUsername());
                } catch (RollUpServiceDelegateException e) {
                    throw new RuntimeException("failed in rollsups");
                }


        }

        if (ret != null) {
            for (Iterator iter = ret.getRollUpElements().iterator(); iter.hasNext();) {
                RollUpElement element = (RollUpElement) iter.next();
                log.info("element label " + element.getLabel());
                
            }
        }
        return ret;
    }

    public CrossTabulationTable getCrossTabulationResults() {

        return crossTabulationResults;
    }

    // private IncidenceTable incidenceTableTable;
    //
    // public IncidenceTable getIncidenceTableResults() {
    // try {
    //
    // if (incidenceTableTable == null) {
    // IncidenceTableBuildOptions options = new IncidenceTableBuildOptions();
    // options.setResults(this.getResults());
    // options.setBaseChains(this.getAllChainList());
    // options.setYear(new Integer(2005));
    //
    // incidenceTableTable = MenuMineResultsDisplayWrapperBuilder.singleton
    // .buildIncidenceTable(options);
    // }
    // } catch (IncidenceTableException e) {
    //
    // e.printStackTrace();
    // return null;
    // }
    //
    // return incidenceTableTable;
    // }

}