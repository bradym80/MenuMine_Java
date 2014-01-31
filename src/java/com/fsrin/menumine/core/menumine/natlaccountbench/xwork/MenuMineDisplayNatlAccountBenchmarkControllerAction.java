/*
 * Created on 2005-7-7
 *
 */
package com.fsrin.menumine.core.menumine.natlaccountbench.xwork;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jfree.chart.JFreeChart;

import com.fsrin.menumine.context.webwork.MenuMineSessionContextWrapperAware;
import com.fsrin.menumine.core.menumine.FieldEnum;
import com.fsrin.menumine.core.menumine.natlaccountbench.NationalAccountBenchmarkTable;
import com.fsrin.menumine.core.menumine.webwork.AbstractMenuMineDisplayAction;
import com.fsrin.menumine.core.menumine.webwork.util.GraphWriterUtilFactory;
import com.fsrin.menumine.core.minefields.MineField;
import com.fsrin.menumine.core.minefields.MineFields;
import com.opensymphony.webwork.util.Sorter;

/**
 * @author Nick
 * @version 1
 */

public class MenuMineDisplayNatlAccountBenchmarkControllerAction extends
        AbstractMenuMineDisplayAction implements MenuMineSessionContextWrapperAware,
        NationalAccountBenchmarkWebOptionsAware {

    private static final String BENCHMARK_TREND = "benchmark.trend";

    private static final String SUCCESS_TREND = "success-trend";

    private static final String SUCCESS_CANNED = "success-canned";

    private static final String NATIONAL_ACCOUNT_BENCHMARK = "National Account Benchmark";

    private static final String NATIONAL_ACCOUNT_BENCHMARK_TABLE_GRAPH = "National Account Benchmark Table Graph";

    private static final String NATIONAL_ACCOUNT_BENCHMARK_TABLE_AS_EXCEL = "National Account Benchmark Table As Excel";

    private static final String DOWNLOAD_TABLE_AS_EXCEL = "Download Table As Excel";

    private String benchmarkType;
    
    private NationalAccountBenchmarkTable table = null;

    private NationalAccountBenchmarkWebOptions nationalAccountBenchmarkWebOptions;

    public String execute() throws Exception {
        
//        this.setSpecialFunction(SPECIAL_NATIONAL_ACCOUNT_BENCHMARK);
        
        super.execute();

        if (this.getSubmitOptions() != null
                && this.getSubmitOptions().equals(DOWNLOAD_TABLE_AS_EXCEL)) {
            this.getMenuMineDisplayOptions().setDisplayType(
                    NATIONAL_ACCOUNT_BENCHMARK_TABLE_AS_EXCEL);

        } else if (this.getSubmitOptions() != null
                && this.getSubmitOptions().equals("Graph")) {
            this.getMenuMineDisplayOptions().setDisplayType(
                    NATIONAL_ACCOUNT_BENCHMARK_TABLE_GRAPH);
            

            
        } else {
            this.getMenuMineDisplayOptions().setDisplayType(
                    NATIONAL_ACCOUNT_BENCHMARK);
        }
        this.getMenuMineSessionContextWrapper().setLastGraphOptions(
                this.getMenuMineGraphOptions());

        /*
         * 2006-03-08 RSC Handle in the builder.
         * 
         * NAH For the N.A.B we will limit it to just the chains that are in the
         * report.
         * 
         * If a user wants to look at everything a full query will be to large.
         * Making them select the chains twice would be tedious.
         */
        /*
         * 2006-02-04 RSC refactored out the chains.
         * 2006-03-08 RSC this should all be handled in the NAB builder.
         */
////        this.getMenuMineSessionContextWrapper().getLastFilterWrapper()
////                .getChain().getOperationName().setInValues(new ArrayList());
//        this.getMenuMineSessionContextWrapper().getLastFilterWrapper()
//        .getOperationName().setInValues(new ArrayList());
//
//        if (this.getNationalAccountBenchmarkWebOptions().getTargetChains() != null) {
////            this.getMenuMineSessionContextWrapper().getLastFilterWrapper()
////                    .getChain().getOperationName().getInValues().addAll(
////                            this.getNationalAccountBenchmarkWebOptions()
////                                    .getTargetChains());
//            this.getMenuMineSessionContextWrapper().getLastFilterWrapper()
//            .getOperationName().getInValues().addAll(
//                    this.getNationalAccountBenchmarkWebOptions()
//                            .getTargetChains());
//        }
//        if (this.getNationalAccountBenchmarkWebOptions().getBenchmarkChains() != null) {
////            this.getMenuMineSessionContextWrapper().getLastFilterWrapper()
////                    .getChain().getOperationName().getInValues().addAll(
////                            this.getNationalAccountBenchmarkWebOptions()
////                                    .getBenchmarkChains());
//            this.getMenuMineSessionContextWrapper().getLastFilterWrapper()
//            .getOperationName().getInValues().addAll(
//                    this.getNationalAccountBenchmarkWebOptions()
//                            .getBenchmarkChains());
//        }

        /*
         * 2006-02-02 Reid
         */
//        if (this.isCannedReport()) {
//            this.getMenuMineGraphOptions().setGraphByField(null);
//
//            return SUCCESS_CANNED;
//        }
        /*
         * Since we are not using a can, let's get it out of the context!
         */
//        this.getNationalAccountBenchmarkWebOptions().setCannedSchematic(null);

        //        /*
        //         * If a canned report was not selected we must have been given a
        // single
        //         * field(Or bad data!).
        //         */
        //        this.getMenuMineGraphOptions()
        //                .setGraphByField(this.getGroupByField());
        //        this.getMenuMineSessionContextWrapper().setLastGraphOptions(
        //                this.getMenuMineGraphOptions());
        //        

        if (this.isDisplayBenchMarkTrends()) {
            return SUCCESS_TREND;
        } else {

            return SUCCESS;
        }
    }

    /*
     * 2006-02-02 RSC Not using.
     */
//    private boolean isCannedReport() {
//        if (this.getNationalAccountBenchmarkWebOptions().getCannedSchematic() != null
//                && this.getMenuMineGraphOptions().getGraphByField() == null) {
//            return true;
//        }
//
//        for (Iterator iter = this.getCannedSchematics().iterator(); iter
//                .hasNext();) {
//            CannedSchematic element = (CannedSchematic) iter.next();
//            if (element.getName().equals(
//                    this.getMenuMineGraphOptions().getGraphByField())) {
//                this.getNationalAccountBenchmarkWebOptions()
//                        .setCannedSchematic(element);
//                return true;
//            }
//        }
//        return false;
//    }

    private boolean isDisplayBenchMarkTrends() {

        return this.getBenchmarkType() != null
                && this.getBenchmarkType().equals(BENCHMARK_TREND);
    }



    public NationalAccountBenchmarkWebOptions getNationalAccountBenchmarkWebOptions() {
        return nationalAccountBenchmarkWebOptions;
    }

    public void setNationalAccountBenchmarkWebOptions(
            NationalAccountBenchmarkWebOptions nationalAccountBenchmarkWebOptions) {
        this.nationalAccountBenchmarkWebOptions = nationalAccountBenchmarkWebOptions;
    }

    Log log = LogFactory
            .getLog(MenuMineDisplayNatlAccountBenchmarkControllerAction.class
                    .getName());

    public String getBenchmarkType() {
        return benchmarkType;
    }

    public void setBenchmarkType(String benchmarkType) {
        this.benchmarkType = benchmarkType;
    }

    public Collection getGroupByFieldOptions() {
        Collection ret = new ArrayList();

        MineFields mineFields = this.getMenuMineSessionContextWrapper()
                .getMineFields();
        Collection all = mineFields.getAllFields();
        Collection allSorted = new TreeSet(new Sorter()
                .getAscending("friendlyName"));
        allSorted.addAll(all);

        /*
         * 2006-02-02 RSC Not Using.
         */
//        ret.add(new GroupByFieldOptionLabelImpl("--Canned Reports--"));
//        for (Iterator iter = this.getCannedSchematics().iterator(); iter
//                .hasNext();) {
//            CannedSchematic element = (CannedSchematic) iter.next();
//            ret.add(new GroupByFieldOptionCannedSchematicImpl(element));
//        }
//
//        ret.add(new GroupByFieldOptionLabelImpl("--Fields--"));
        for (Iterator iter = allSorted.iterator(); iter.hasNext();) {
            MineField element = (MineField) iter.next();
            ret.add(new GroupByFieldOptionMenuFieldImpl(element));
        }
        return ret;

    }

    /*
     * 2006-02-02 RSC
     */
//    private Collection getCannedSchematics() {
//        CannedSchematicCriteriaParamerters params = new CannedSchematicCriteriaParamerters();
//
//        params.setUserName(this.getMenuMineSessionContextWrapper()
//                .getAuthenticatedUser().getUsername());
//        params.setGroupName(this.getMenuMineSessionContextWrapper()
//                .getUserGroup().getName());
//        params.setMineType(this.getMenuMineSessionContextWrapper()
//                .getMineFields().getMineType());
//
//        Collection ret = new ArrayList();
//
//        ret = CannedSchematicServiceDelegate.factory.build().search(params);
//
//        ret.add(new CannedSchematicDefaultImpl(this
//                .getMenuMineSessionContextWrapper().getMineFields()));
//        return ret;
//    }

    // private String groupByField;

    public String getGroupByField() {
//        CannedSchematic cs = this.getNationalAccountBenchmarkWebOptions()
//                .getCannedSchematic();
//        if (cs != null) {
//            return cs.getName();
//        }
        return this.getMenuMineSessionContextWrapper().getLastGraphOptions()
                .getGraphByField();
    }

    //    public void setGroupByField(String groupByField) {
    //        this.groupByField = groupByField;
    //    }
    
}