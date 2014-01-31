/*
 * Created on Jan 20, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.natlaccountbench.xwork;

import org.jfree.chart.JFreeChart;

import com.fsrin.menumine.core.menumine.FieldEnum;


/**
 * @author Nick
 * 
 *  
 */
public class NationalAccountBenchmarkGraphAction extends AbstractNationalAccountAction {

    private JFreeChart chart;

    private ChartBuilder chartBuilder;

    

    public String execute() throws Exception {

        if (this.getSubmitOptions() != null) {
            this.handleGenerateTable();
            this.buildGraph();
        }

        return SUCCESS;
    }

    private void buildGraph() {
        /*
         * nick 2005-7-5
         * 
         * We should chain from the NABAction(the results producer).
         */
//
//        OgnlValueStack stack = ActionContext.getContext().getActionInvocation()
//                .getStack();

        /*
         * 2006-02-02 RSC
         */
//        NationalAccountBenchmarkTable nationalAccountBenchmarkTable = (NationalAccountBenchmarkTable) stack
//                .findValue("nationalAccountBenchmarkTableResults");
        

        //  Collection results = stats.getRows();

        String titleString = getTitle();

        chart = this.getChartBuilder().build(this.getNationalAccountBenchmarkTableResults(),
                titleString, 23);

        //        chart = ChartBuilder.singleton.buildItemsPerChainMenuingGraph(
        //                incidenceTable, titleString, 23);
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

        String titleString = "MenuMine National Account Benchmark - " + title;
        //  + " - % Distribution - Base: " + getResults().size();
        return titleString;

    }

    public JFreeChart getChart() {
        
        if (chart == null)
            this.buildGraph();
        
        return chart;
    }



    private ChartBuilder getChartBuilder() {
        return chartBuilder;
    }

    public void setChartBuilder(ChartBuilder chartBuilder) {
        this.chartBuilder = chartBuilder;
    }

}