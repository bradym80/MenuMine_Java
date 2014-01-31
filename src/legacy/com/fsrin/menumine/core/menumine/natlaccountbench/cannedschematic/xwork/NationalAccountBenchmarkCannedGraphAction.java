/*
 * Created on Jan 20, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.natlaccountbench.cannedschematic.xwork;

import java.util.Iterator;

import org.jfree.chart.JFreeChart;

import com.fsrin.menumine.context.webwork.MenuMineSessionContextWrapper;
import com.fsrin.menumine.context.webwork.MenuMineSessionContextWrapperAware;
import com.fsrin.menumine.core.menumine.natlaccountbench.NationalAccountBenchmarkCan;
import com.fsrin.menumine.core.menumine.natlaccountbench.NationalAccountBenchmarkTable;
import com.fsrin.menumine.core.menumine.natlaccountbench.xwork.ChartBuilder;
import com.fsrin.menumine.core.menumine.natlaccountbench.xwork.NationalAccountBenchmarkWebOptions;
import com.fsrin.menumine.core.menumine.natlaccountbench.xwork.NationalAccountBenchmarkWebOptionsAware;
import com.opensymphony.xwork.ActionSupport;

/**
 * @author Nick
 * 
 *  
 */
public class NationalAccountBenchmarkCannedGraphAction extends ActionSupport
        implements MenuMineSessionContextWrapperAware,
        NationalAccountBenchmarkWebOptionsAware {

    private NationalAccountBenchmarkWebOptions nationalAccountBenchmarkWebOptions;

    private JFreeChart chart;

    private ChartBuilder chartBuilder;

    private String target;

    private MenuMineSessionContextWrapper menuMineSessionContextWrapper;

    public String execute() throws Exception {

        buildGraph();
        return ActionSupport.SUCCESS;
    }

    private void buildGraph() {

        NationalAccountBenchmarkTable nationalAccountBenchmarkTable = this
                .getTargetTable();

        String titleString = getTitle();

        chart = this.getChartBuilder().build(nationalAccountBenchmarkTable,
                titleString, 23);

        //        chart = ChartBuilder.singleton.buildItemsPerChainMenuingGraph(
        //                incidenceTable, titleString, 23);
    }

    private NationalAccountBenchmarkTable getTargetTable() {
        for (Iterator iter = this.getNationalAccountBenchmarkWebOptions()
                .getCannedReport().getCans().iterator(); iter.hasNext();) {
            NationalAccountBenchmarkCan element = (NationalAccountBenchmarkCan) iter
                    .next();
            if (element.getField().getOgnlName().equals(this.getTarget())) {
                return element.getBenchmark();
            }
        }
        return null;
    }

    private String getTitle() {

        for (Iterator iter = this.getNationalAccountBenchmarkWebOptions()
                .getCannedReport().getCans().iterator(); iter.hasNext();) {
            NationalAccountBenchmarkCan element = (NationalAccountBenchmarkCan) iter
                    .next();
            if (element.getField().getOgnlName().equals(this.getTarget())) {
                return element.getField().getFriendlyName()
                        + " National Account Benchmark";
            }
        }

        return "National Account Benchmark";

        //        String title = this.getMenuMineSessionContextWrapper()
        //                .getLastGraphOptions().getGraphTitle();
        //
        //        if (title == null || title.equals("")) {
        //            String key = this.getMenuMineSessionContextWrapper()
        //                    .getLastGraphOptions().getGraphByField();
        //
        //            FieldEnum f = FieldEnum.getByOgnlName(key);
        //            if (f != null) {
        //
        //                title = f.getFriendlyName();
        //            }
        //        }
        //
        //        String titleString = "MenuMine National Account Benchmark - " +
        // title;
        //        // + " - % Distribution - Base: " + getResults().size();
        //        return titleString;

    }

    public JFreeChart getChart() {
        return chart;
    }

    public MenuMineSessionContextWrapper getMenuMineSessionContextWrapper() {
        return menuMineSessionContextWrapper;
    }

    public void setMenuMineSessionContextWrapper(
            MenuMineSessionContextWrapper menuMineSessionContextWrapper) {
        this.menuMineSessionContextWrapper = menuMineSessionContextWrapper;
    }

    private ChartBuilder getChartBuilder() {
        return chartBuilder;
    }

    public void setChartBuilder(ChartBuilder chartBuilder) {
        this.chartBuilder = chartBuilder;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public NationalAccountBenchmarkWebOptions getNationalAccountBenchmarkWebOptions() {
        return nationalAccountBenchmarkWebOptions;
    }

    public void setNationalAccountBenchmarkWebOptions(
            NationalAccountBenchmarkWebOptions nationalAccountBenchmarkWebOptions) {
        this.nationalAccountBenchmarkWebOptions = nationalAccountBenchmarkWebOptions;
    }
}