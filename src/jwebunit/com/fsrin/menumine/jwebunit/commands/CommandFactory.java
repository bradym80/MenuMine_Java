/*
 * Created on Mar 6, 2006 by Reid
 */
package com.fsrin.menumine.jwebunit.commands;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Random;

public class CommandFactory {

    public static Collection commands;
    
    public static Random rand = new Random(new Date().getTime());
    
    public static JWebunitCommand build() throws Exception  {
    
        if (commands == null)
            initializeCommands();
        
        int i = rand.nextInt(commands.size());
        
        
        
        JWebunitCommand ret = null;
        
        Class clazz = (Class) commands.toArray()[i];
        
        ret = (JWebunitCommand) (Class.forName(clazz.getName()).newInstance());
        
        return ret;
    }

    private static void initializeCommands() {
        
        commands = new ArrayList();
        
        commands.add(CarboProfilerCommand.class);
        commands.add(ChainMapCommand.class);
        commands.add(ChainStatCommand.class);
        commands.add(CrossTabCommand.class);
        commands.add(DessertProfilerCommand.class);
        commands.add(FlavorProfilerCommand.class);
        commands.add(HealthyProfilerCommand.class);
        commands.add(ItemChainMenuingCommand.class);
        commands.add(ItemChainMenuingGraphCommand.class);
        commands.add(MarketProfilerCommand.class);
        commands.add(MeanPriceTrendCommand.class);
        commands.add(MeanPriceTrendCommandGraph.class);
        commands.add(MedianPriceTrendCommand.class);
        commands.add(MedianPriceTrendGraphCommand.class);
        commands.add(MenubookCommand.class);
        commands.add(MenubookTrendsCommand.class);
        commands.add(MenuMineGraphBarCommand.class);
        commands.add(MenuMineGraphPieCommand.class);
        commands.add(MenuShareCommand.class);
        commands.add(ProteinProfilerCommand.class);
        commands.add(RollUpCommand.class);
        commands.add(SavedQueryManagerCommand.class);
        commands.add(SpreadsheetCommand.class);
        commands.add(VeggieProfilerCommand.class);
        
    }
    
    
    

}
