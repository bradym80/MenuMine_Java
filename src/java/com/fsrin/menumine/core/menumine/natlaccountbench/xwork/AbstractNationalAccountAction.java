/*
 * Created on Feb 2, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.natlaccountbench.xwork;

import com.fsrin.menumine.core.menumine.natlaccountbench.NationalAccountBenchmarkBuilder;
import com.fsrin.menumine.core.menumine.natlaccountbench.NationalAccountBenchmarkTable;
import com.fsrin.menumine.core.menumine.webwork.AbstractMenuMineDisplayAction;

public abstract class AbstractNationalAccountAction extends
        AbstractMenuMineDisplayAction implements
        NationalAccountBenchmarkWebOptionsAware {

    private NationalAccountBenchmarkWebOptions nationalAccountBenchmarkWebOptions;

    private NationalAccountBenchmarkTable table = null;

    private String specialFunction;
    
    public NationalAccountBenchmarkTable getNationalAccountBenchmarkTableResults() {

        if (table == null) {
            try {
                this.handleGenerateTable();
            } catch (Exception e) {
                // just means we don't have any parameters.
            }
        }
        // /*
        // * Cache the table;
        // */
        // this.getMenuMineSessionContextWrapper().setLastShareTable(table);
        return table;
    }

    public NationalAccountBenchmarkWebOptions getNationalAccountBenchmarkWebOptions() {
        return nationalAccountBenchmarkWebOptions;
    }

    public void handleGenerateTable() {

        // long timeStart = new Date().getTime();

        /*
         * 2006-02-02 RSC
         */
        // try {
        // table = new NationalAccountBenchmarkBuilder()
        // .buildNationalAccountBenchmarkTableFromCollection(results,
        // this.getMenuMineSessionContextWrapper()
        // .getLastGraphOptions(), this
        // .getMenuMineSessionContextWrapper()
        // .getRollUpOptions(), this
        // .getNationalAccountBenchmarkWebOptions()
        // .getTargetChains(), this
        // .getNationalAccountBenchmarkWebOptions()
        // .getBenchmarkChains());
        // } catch (OgnlException e) {
        // throw new RuntimeException("failed to build table", e);
        // }
        table = new NationalAccountBenchmarkBuilder().buildFromParameters(this
                .getMenuMineSessionContextWrapper().getLastFilterWrapper()
                .getMasterFoodFilterParameters(), this
                .getMenuMineSessionContextWrapper().getLastGraphOptions(), this
                .getMenuMineSessionContextWrapper().getRollUpOptions(), this
                .getNationalAccountBenchmarkWebOptions());

        /*
         * We don't want this to hang out for to long.
         */
        this.getMenuMineSessionContextWrapper().getLastGraphOptions()
                .setSimpleFilter(null);
    }

    public void setNationalAccountBenchmarkWebOptions(
            NationalAccountBenchmarkWebOptions nationalAccountBenchmarkWebOptions) {
        this.nationalAccountBenchmarkWebOptions = nationalAccountBenchmarkWebOptions;
    }
    
    public String getSpecialFunction() {
        return specialFunction;
    }

    public void setSpecialFunction(String specialFunction) {
        this.specialFunction = specialFunction;
    }

}
