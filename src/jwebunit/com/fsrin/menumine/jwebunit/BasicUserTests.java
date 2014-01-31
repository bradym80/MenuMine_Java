/*
 * Created on Mar 3, 2006 by Reid
 */
package com.fsrin.menumine.jwebunit;

import com.fsrin.menumine.jwebunit.commands.CrossTabCommand;
import com.fsrin.menumine.jwebunit.commands.ItemChainMenuingCommand;
import com.fsrin.menumine.jwebunit.commands.ItemChainMenuingGraphCommand;
import com.fsrin.menumine.jwebunit.commands.MeanPriceTrendCommand;
import com.fsrin.menumine.jwebunit.commands.MeanPriceTrendCommandGraph;
import com.fsrin.menumine.jwebunit.commands.MedianPriceTrendCommand;
import com.fsrin.menumine.jwebunit.commands.MedianPriceTrendGraphCommand;
import com.fsrin.menumine.jwebunit.commands.MenuMineGraphBarCommand;
import com.fsrin.menumine.jwebunit.commands.MenuMineGraphPieCommand;
import com.fsrin.menumine.jwebunit.commands.MenuShareCommand;
import com.fsrin.menumine.jwebunit.commands.NationalAccountBenchmarkCommand;
import com.fsrin.menumine.jwebunit.commands.NationalAccountBenchmarkGraphCommand;
import com.fsrin.menumine.jwebunit.commands.NationalAccountBenchmarkTrendsCommand;
import com.fsrin.menumine.jwebunit.commands.RollUpCommand;
import com.fsrin.menumine.jwebunit.commands.SpreadsheetCommand;


public class BasicUserTests extends AbstractJWebUnitMenuMineTestSupport {

    private static int counter = 0;
    
    public BasicUserTests(String arg0) {
        super(arg0);
        counter++;
    }
    
    public void testBasicContext() throws Exception {
        /*
         * 2006-03-03 RSC Basically, the context needs to get us here
         * everytime.
         * 
         * just makes sure we know where we're starting.
         */
        assertTextPresent("Display Spreadsheet:");
        assertTextNotPresent("Password Help");
        
    }
    
    public void testMenuShare() throws Exception {
        this.handleMenuShare();
    }
    
    public void testMedianPriceTrend() throws Exception {
        this.handleMedianPriceTrend();
        
        this.handleMedianPriceTrendGraph();
    }
    
    public void testMeanPriceTrend() throws Exception {
        
        this.handleMeanPriceTrend();
        
        this.handleMeanPriceTrendGraph();
    }
    
    public void testItemPerChainMenuing() throws Exception {
        
        this.handleItemsChainMenuing();
        
        this.handleItemsChainMenuingGraph();
        
    }
    
    public void testCrossTab() throws Exception {
        
        this.handleCrossTab();
        
    }
    
    public void testMenuMineGraph() throws Exception {
        
 
        this.handleMenuMineGraphPie();
        
        this.handleMenuMineGraphBar();
        
    }
    
    public void testMenuMineSpreadsheet() throws Exception {
        
        this.handleMenuMineSpreadsheet();
        
    }
    
    public void testSequence() throws Exception {
        
        this.handleMenuShare();
        
        this.handleMedianPriceTrend();
        
        this.handleMedianPriceTrendGraph();
        
        this.handleMeanPriceTrend();
        
        this.handleMeanPriceTrendGraph();
        
        this.handleItemsChainMenuing();
        
        this.handleItemsChainMenuingGraph();
        
        this.handleMenuMineGraphPie();
        
        this.handleMenuMineGraphBar();
        
        this.handleMenuMineSpreadsheet();
        
        this.handleRollUp();
        
    }
    
    public void testRollUp() throws Exception {
        
        this.handleRollUp();
    }
    public void testSequence2() throws Exception {
        
        this.handleMenuShare();
        
        this.handleMenuMineGraphBar();        
        
        this.handleItemsChainMenuing();

        this.handleMedianPriceTrend();
        
        this.handleMeanPriceTrend();
        
        this.handleMenuMineGraphPie();
        
        this.handleMedianPriceTrendGraph();
        
        this.handleMeanPriceTrendGraph();
               
        this.handleItemsChainMenuingGraph();
        
        this.handleItemsChainMenuing();

        this.handleMedianPriceTrend();
        
        this.handleMenuMineSpreadsheet();
        
        this.handleMenuShare();
        
        this.handleMenuMineGraphBar();        
        
        this.handleMeanPriceTrendGraph();
        
        this.handleItemsChainMenuingGraph();
        
        this.handleMenuMineSpreadsheet();
        
        this.handleMeanPriceTrend();
        
        this.handleMenuMineGraphPie();
        
        this.handleMedianPriceTrendGraph();
        
    }
    
    public void testNationalAccountBenchmark() throws Exception {
        
        this.handleNationalAccountBenchmark();
        
        this.handleNationalAccountBenchmarkGraph();
        
        this.handleNationalAccountBenchmarkTrend();
    }
    
    public void handleMenuShare() throws Exception {
        
        new MenuShareCommand().execute(this);
        
    }
    
    public void handleMedianPriceTrend() throws Exception {
        
        new MedianPriceTrendCommand().execute(this);
        

    }
    
    public void handleMedianPriceTrendGraph() throws Exception {
        
        
        new MedianPriceTrendGraphCommand().execute(this);

        
    }
    
    public void handleMeanPriceTrend() throws Exception {

        new MeanPriceTrendCommand().execute(this);

    }
    
    public void handleMeanPriceTrendGraph() throws Exception {

        new MeanPriceTrendCommandGraph().execute(this);
    }
    
    public void handleItemsChainMenuing() throws Exception {

        new ItemChainMenuingCommand().execute(this);
        
    }
    
    public void handleItemsChainMenuingGraph() throws Exception {

        new ItemChainMenuingGraphCommand().execute(this);
        
    }
    
    public void handleCrossTab() throws Exception {

        new CrossTabCommand().execute(this);
        
    }
    
    public void handleMenuMineGraphPie() throws Exception {
        
        new MenuMineGraphPieCommand().execute(this);
    }
    
    public void handleMenuMineGraphBar() throws Exception {
        
        new MenuMineGraphBarCommand().execute(this);
        
    }
    
    public void handleMenuMineSpreadsheet() throws Exception {
        
        new SpreadsheetCommand().execute(this);
        
    }
    
    public void handleNationalAccountBenchmark() throws Exception {
        
        new NationalAccountBenchmarkCommand().execute(this);
    }

    public void handleNationalAccountBenchmarkGraph() throws Exception {
        
        new NationalAccountBenchmarkGraphCommand().execute(this);
    }
    
    public void handleNationalAccountBenchmarkTrend() throws Exception {
        
        new NationalAccountBenchmarkTrendsCommand().execute(this);
    }
    
    public void handleRollUp() throws Exception {
        new RollUpCommand().execute(this);
    }
    
}
