/*
 * Created on Feb 3, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.sharetable;

import java.util.HashMap;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 2006-02-03 Cruises through the statistical table and leaves in items with 
 * matching labels and excludes those with no match.
 * 
 */
public class StatisticalTableFilter {

    private static Log log = LogFactory.getLog(StatisticalTableFilter.class);
    
    public void filter(StatisticalTableIF target, String simpleFilter) {
        
        if (simpleFilter == null || simpleFilter.trim().length() == 0)
            return ;
        
        
        HashMap filteredRows = new HashMap();
        
        for (Iterator iter = target.getRows().iterator(); iter.hasNext();) {
            StatisticalTableElementIF element = (StatisticalTableElementIF) iter.next();
        
            simpleFilter = simpleFilter.toLowerCase();

            if (element.getName().toLowerCase().indexOf(simpleFilter) > -1) {
            
                StatisticalTableElementIF result = null;
                
                log.info("putting " + element.getName() + " int map using key " + element.getName());
                
                filteredRows.put(element.getName(), element);
            
            }
            
        }
        
        
        target.setRows(filteredRows.values());
        
        
        
        
        
    }
    
}
