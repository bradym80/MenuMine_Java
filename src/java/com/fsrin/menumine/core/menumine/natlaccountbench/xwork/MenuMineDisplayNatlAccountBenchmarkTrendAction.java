/*
 * Created on 2005-1-18
 *
 */
package com.fsrin.menumine.core.menumine.natlaccountbench.xwork;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fsrin.menumine.core.menumine.natlaccountbench.NationalAccountBenchmarkBuilder;
import com.fsrin.menumine.core.menumine.natlaccountbench.NationalAccountBenchmarkTrendTable;
import com.fsrin.menumine.core.menumine.webwork.MenuMineDisplayOptions;

/**
 * @author Nick
 * @version 1
 */

public class MenuMineDisplayNatlAccountBenchmarkTrendAction extends
        AbstractNationalAccountAction {

    Log log = LogFactory
    .getLog(MenuMineDisplayNatlAccountBenchmarkTrendAction.class
            .getName());

    private NationalAccountBenchmarkTrendTable table = null;
    
    public String execute() throws Exception {
     //   super.execute();

        this.setSpecialFunction(SPECIAL_NATIONAL_ACCOUNT_BENCHMARK);
        
        if (this.getSubmitOptions() != null)
            this.handleGenerateTrendTable();
        
        return SUCCESS;
    }

     public MenuMineDisplayOptions getMenuMineDisplayOptions() {

        return this.getMenuMineSessionContextWrapper().getLastDisplayOptions();
    }
    
     private void handleGenerateTrendTable() {
         
         table = new NationalAccountBenchmarkBuilder().buildTrendFromParameters(this
                 .getMenuMineSessionContextWrapper().getLastFilterWrapper()
                 .getMasterFoodFilterParameters(), this
                 .getMenuMineSessionContextWrapper().getLastGraphOptions(), this
                 .getMenuMineSessionContextWrapper().getRollUpOptions(), this
                 .getNationalAccountBenchmarkWebOptions());
     }

    public NationalAccountBenchmarkTrendTable getNationalAccountBenchmarkTrendTableResults() {

        if (table == null)
            this.handleGenerateTrendTable();
//        if (!this.isBelowCountLimit()) {
//            return null;
//        }
//        if (table == null) {
//            Collection results = this.getResults();
//
//            try {
//                long timeStart = new Date().getTime();
//
//                table = new NationalAccountBenchmarkBuilder()
//                        .buildNationalAccountBenchmarkTrendTableFromCollection(
//                                results, this.getMenuMineSessionContextWrapper().getLastGraphOptions(), this
//                                        .getMenuMineSessionContextWrapper()
//                                        .getRollUpOptions(),
//                                this.getNationalAccountBenchmarkWebOptions()
//                                        .getTargetChains(),
//                                this.getNationalAccountBenchmarkWebOptions()
//                                        .getBenchmarkChains());
//
//                long timeEnd = new Date().getTime();
//                log.info("Retrieved NationalAccountBenchmark Table in: "
//                        + (timeEnd - timeStart));
//
//            } catch (OgnlException e) {
//                e.printStackTrace();
//                LogFactory.getLog(this.getClass()).info(e.getStackTrace());
//                return null;
//            } catch (RuntimeException r) {
//                r.printStackTrace();
//                LogFactory.getLog(this.getClass()).info(r.getStackTrace());
//                return null;
//            }
//        }

        /*
         * We don't want this to hang out for to long.
         */
        this.getMenuMineSessionContextWrapper().getLastGraphOptions()
                .setSimpleFilter(null);
        //        /*
        //         * Cache the table;
        //         */
        //        this.getMenuMineSessionContextWrapper().setLastShareTable(table);
        return table;
    }
//
//    private NationalAccountBenchmarkWebOptions nationalAccountBenchmarkWebOptions;
//
//    public NationalAccountBenchmarkWebOptions getNationalAccountBenchmarkWebOptions() {
//        return nationalAccountBenchmarkWebOptions;
//    }
//
//    public void setNationalAccountBenchmarkWebOptions(
//            NationalAccountBenchmarkWebOptions nationalAccountBenchmarkWebOptions) {
//        this.nationalAccountBenchmarkWebOptions = nationalAccountBenchmarkWebOptions;
//    }



}