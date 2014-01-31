/*
 * Created on 2005-1-18
 *
 */
package com.fsrin.menumine.core.menumine.natlaccountbench.xwork;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jfree.chart.JFreeChart;

import com.fsrin.menumine.core.menumine.FieldEnum;
import com.fsrin.menumine.core.menumine.natlaccountbench.NationalAccountBenchmarkChartBuilder;
import com.fsrin.menumine.core.menumine.webwork.ChartBuilder;
import com.fsrin.menumine.core.menumine.webwork.MenuMineDisplayOptions;
import com.fsrin.menumine.core.menumine.webwork.util.GraphWriterUtilFactory;

/**
 * @author Nick
 * @version 1
 */

public class MenuMineDisplayNatlAccountBenchmarkAction extends AbstractNationalAccountAction {

    private Log log = LogFactory.getLog(MenuMineDisplayNatlAccountBenchmarkAction.class
            .getName());
    
    private String imagePath;
    
    public String execute() throws Exception {
        // super.execute();

        this.setSpecialFunction(SPECIAL_NATIONAL_ACCOUNT_BENCHMARK);
        
        if (this.getSubmitOptions() != null
                && this.getSubmitOptions().equals("Graph")) {
            this.buildGraph();
        }
            
        if (this.getSubmitOptions() != null) {
            NationalAccountBenchmarkWebOptions webOptions = this.getNationalAccountBenchmarkWebOptions();
            
            if (webOptions.getTargetChains() == null || webOptions.getBenchmarkChains() == null) {
                this.addActionError("You must select both target and benchmark chains to continue.");
                return SUCCESS;
            }
            
            this.handleGenerateTable();
        }

        return SUCCESS;
    }

    public MenuMineDisplayOptions getMenuMineDisplayOptions() {

        return this.getMenuMineSessionContextWrapper().getLastDisplayOptions();
    }

    private void buildGraph() throws Exception {
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

        JFreeChart chart = new NationalAccountBenchmarkChartBuilder().build(this.getNationalAccountBenchmarkTableResults(),
                titleString, 23);
        
        String file = new GraphWriterUtilFactory().build().write(chart);

        this.setImagePath(file);
        
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

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }




}