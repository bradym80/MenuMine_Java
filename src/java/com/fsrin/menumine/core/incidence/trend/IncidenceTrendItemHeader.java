/*
 * Created on Sep 14, 2006 by Reid
 */
package com.fsrin.menumine.core.incidence.trend;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class IncidenceTrendItemHeader extends IncidenceTrendItem {

    private Map incidenceTrendItems = new HashMap();

    public Map getIncidenceTrendItems() {
        return incidenceTrendItems;
    }

    public void setIncidenceTrendItems(Map incidenceTrendItems) {
        this.incidenceTrendItems = incidenceTrendItems;
    }
    
    public Collection getSortedTrendItems() {
        
        Collection ret = new TreeSet();
        
        ret.addAll(this.getIncidenceTrendItems().values());
        
        return ret;
        
    }
    
    
    
    

}
