/*
 * Created on Mar 6, 2006 by Reid
 */
package com.fsrin.menumine.jwebunit;

import com.fsrin.menumine.jwebunit.commands.CarboProfilerCommand;
import com.fsrin.menumine.jwebunit.commands.ChainMapCommand;
import com.fsrin.menumine.jwebunit.commands.ChainStatCommand;
import com.fsrin.menumine.jwebunit.commands.DessertProfilerCommand;
import com.fsrin.menumine.jwebunit.commands.FlavorProfilerCommand;
import com.fsrin.menumine.jwebunit.commands.HealthyProfilerCommand;
import com.fsrin.menumine.jwebunit.commands.MarketProfilerCommand;
import com.fsrin.menumine.jwebunit.commands.MenubookCommand;
import com.fsrin.menumine.jwebunit.commands.MenubookTrendsCommand;
import com.fsrin.menumine.jwebunit.commands.ProteinProfilerCommand;
import com.fsrin.menumine.jwebunit.commands.SavedQueryManagerCommand;
import com.fsrin.menumine.jwebunit.commands.VeggieProfilerCommand;

public class AdvancedUserTests extends AbstractJWebUnitMenuMineTestSupport {

    public AdvancedUserTests(String arg0) {
        super(arg0);
        
    }

    public void testCarboProfiler() throws Exception {
        
        new CarboProfilerCommand().execute(this);
    }
    
    public void testFlavorProfiler() throws Exception {
        
        new FlavorProfilerCommand().execute(this);
    }
    
    public void testProteinProfiler() throws Exception {
        
        new ProteinProfilerCommand().execute(this);
    }
    
    public void testVeggieProfiler() throws Exception {
        
        new VeggieProfilerCommand().execute(this);
    }
    
    public void testDessertProfiler() throws Exception {
        
        new DessertProfilerCommand().execute(this);
    }
    
    public void testHealthyProfiler() throws Exception {
        new HealthyProfilerCommand().execute(this);
    }
    
    public void testMarketProfiler() throws Exception {
        new MarketProfilerCommand().execute(this);
    }
    
    public void testChainMap() throws Exception {
        
        new ChainMapCommand().execute(this);
    }
    
    public void testChainStat() throws Exception {
        
        new ChainStatCommand().execute(this);
    }
    
    public void testMenubook() throws Exception {
        
        new MenubookCommand().execute(this);
    }
    
    public void testMenubookTrends() throws Exception {
        
        new MenubookTrendsCommand().execute(this);
    }
    
    public void testSavedQueryManager() throws Exception {
        
        new SavedQueryManagerCommand().execute(this);
    }
    
    
}
