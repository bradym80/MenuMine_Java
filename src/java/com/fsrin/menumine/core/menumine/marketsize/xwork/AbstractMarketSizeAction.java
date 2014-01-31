/*
 * Created on Sep 7, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.marketsize.xwork;

import com.fsrin.menumine.core.incidence.IncidenceTableBuildOptions;
import com.fsrin.menumine.core.incidence.IncidenceTableBuilder;
import com.fsrin.menumine.core.menumine.marketsize.MarketSizeIncidenceTable;
import com.fsrin.menumine.core.menumine.marketsize.MarketSizeOptions;
import com.fsrin.menumine.core.menumine.webwork.AbstractMenuMineDisplayAction;

public abstract class AbstractMarketSizeAction extends
        AbstractMenuMineDisplayAction implements
        MarketSizeProjectorContextAware {

    private MarketSizeProjectorContext marketSizeProjectorContext;
    private MarketSizeIncidenceTable marketSizeTable;

    /**
     * @return Returns the marketSizeProjectorContext.
     */
    public MarketSizeProjectorContext getMarketSizeProjectorContext() {
        return marketSizeProjectorContext;
    }

    /**
     * @param marketSizeProjectorContext The marketSizeProjectorContext to set.
     */
    public void setMarketSizeProjectorContext(MarketSizeProjectorContext marketSizeProjectorContext) {
        this.marketSizeProjectorContext = marketSizeProjectorContext;
    }

    /**
     * @return Returns the incidenceTableTable.
     */
    public MarketSizeIncidenceTable getMarketSizeTable() {
        return marketSizeTable;
    }

    /**
     * @param incidenceTableTable The incidenceTableTable to set.
     */
    public void setMarketSizeTable(MarketSizeIncidenceTable incidenceTableTable) {
        this.marketSizeTable = incidenceTableTable;
    }

    public MarketSizeIncidenceTable handleBuild(MarketSizeOptions buildOptions) throws Exception {
    
        IncidenceTableBuildOptions incidenceTableBuildOptions = new IncidenceTableBuildOptions();
        incidenceTableBuildOptions.setParams(this
                .getMenuMineSessionContextWrapper().getLastFilterWrapper()
                .getMasterFoodFilterParameters());
        
        // DBB 1-20-2009 Change Market Size Projector to use 2008 rather than 2005
        // MJB 11-12-2009 Changed to MSP to 2009
        // MJB 10-06-10 Changed to MSP to 2010
        incidenceTableBuildOptions.setYear(new Integer(2011));
    
        MarketSizeIncidenceTable marketSizeIncidenceTable = new IncidenceTableBuilder()
                .buildMarketSizeProjectorTable(incidenceTableBuildOptions,
                        buildOptions);
    
        this.setMarketSizeTable(marketSizeIncidenceTable);
    
        return marketSizeIncidenceTable;
    
    }



}
