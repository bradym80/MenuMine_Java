/*
 * Created on Jul 26, 2006
 *
 */
package com.fsrin.menumine.core.menumine.marketsize.xwork;

import com.fsrin.menumine.core.menumine.marketsize.MarketSizeIncidenceTable;
import com.fsrin.menumine.core.menumine.marketsize.MarketSizeOptions;

public class MarketSizeProjectorContext {

    private MarketSizeIncidenceTable marketSizeIncidenceTable;

    private MarketSizeOptions marketSizeOptions;
    
    /**
     * @return Returns the marketSizeIncidenceTable.
     */
    public MarketSizeIncidenceTable getMarketSizeIncidenceTable() {
        return marketSizeIncidenceTable;
    }

    /**
     * @param marketSizeIncidenceTable The marketSizeIncidenceTable to set.
     */
    public void setMarketSizeIncidenceTable(
            MarketSizeIncidenceTable marketSizeIncidenceTable) {
        this.marketSizeIncidenceTable = marketSizeIncidenceTable;
    }

    /**
     * @return Returns the marketSizeOptions.
     */
    public MarketSizeOptions getMarketSizeOptions() {
        return marketSizeOptions;
    }

    /**
     * @param marketSizeOptions The marketSizeOptions to set.
     */
    public void setMarketSizeOptions(MarketSizeOptions marketSizeOptions) {
        this.marketSizeOptions = marketSizeOptions;
    }
    
    
}
