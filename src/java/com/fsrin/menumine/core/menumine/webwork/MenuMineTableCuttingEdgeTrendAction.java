/*
 * Created on May 15, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.webwork;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/*
 * 2006-05-15 RSC Chain Trend
 * 
 * Two tables, graphs.
 * 
 * Top: same store, 2001-2005 chain in market sector on menu 2005
 * 
 * Bottom same store, 2001-2005 chain in market sector on menu 2001
 * 
 */
public class MenuMineTableCuttingEdgeTrendAction extends
        AbstractCuttingEdgeTableTrendAction {

    private Log log = LogFactory.getLog(MenuMineTableCuttingEdgeTrendAction.class);




    public String execute() throws Exception {
        log.debug("starting MenuMineTableChainTrendAction");

        super.execute();

        this.getMenuMineDisplayOptions().setDisplayType(MenuMineDisplayOptions.DISPLAY_TYPE_TREND_TABLE);
        
        this.getMenuMineSessionContextWrapper().getShareTableMap().clear();
        


        //this.getMenuMineSessionContextWrapper().getShareTableMap().put(this.getMenuMineGraphOptions().getGraphByFieldEnum().getOgnlName() + "-trend-2005", this.getTrend2005());
        
        // DBB 1-20-2009 Use 2003/2008 rather than 2002/2007
        // MJB 11-12-2009 Use 2004/2009 rather than 2003/2008
        this.getMenuMineSessionContextWrapper().getShareTableMap().put(this.getMenuMineGraphOptions().getGraphByFieldEnum().getOgnlName() + "-trend-2011", this.getTrend2011());
        
        //this.getMenuMineSessionContextWrapper().getShareTableMap().put(this.getMenuMineGraphOptions().getGraphByFieldEnum().getOgnlName() + "-trend-2001", this.getTrend2001());
        
        this.getMenuMineSessionContextWrapper().getShareTableMap().put(this.getMenuMineGraphOptions().getGraphByFieldEnum().getOgnlName() + "-trend-2006", this.getTrend2006());
        
        return SUCCESS;
    }



}
