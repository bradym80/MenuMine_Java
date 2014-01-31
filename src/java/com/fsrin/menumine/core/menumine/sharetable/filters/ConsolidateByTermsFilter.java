/*
 * Created on Mar 24, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.sharetable.filters;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;

import com.fsrin.menumine.common.webwork.MMSorter;
import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableElementIF;
import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableElementIFBuilder;
import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableIF;

/**
 * 2006-04-10 RSC
 * 
 * @author Reid
 */
public class ConsolidateByTermsFilter extends AbstractFilter {

    private String keywords;

    public void execute(StatisticalTableIF input) throws Exception {

        if (this.getKeywords() == null) {
            this.setResults(input);
            log.info("no keywords sent in");
            return;
        }
        Collection rows = new ArrayList();

        StatisticalTableElementIF none = null;

        StatisticalTableElementIF combined = null;

        // create an array with just the terms to be filtered
        String[] consolidations = this.getKeywords().split(",");

        Map consolidationMap = new HashMap();
        
        StatisticalTableElementIFBuilder builder = new StatisticalTableElementIFBuilder();
        
        for (Iterator iter = input.getRows().iterator(); iter.hasNext();) {
            StatisticalTableElementIF element = (StatisticalTableElementIF) iter
                    .next();

            boolean matched = false;
            
            for (int i = 0; i < consolidations.length; i++) {
                String current = consolidations[i];
                
                String[] fineGrained = current.toLowerCase().trim().split("\\W");
                
                for (int j = 0; j < fineGrained.length; j++) {
                    if (element.getName().toLowerCase().indexOf(fineGrained[j]) != -1) {
                        matched = true;
                        break;
                    }
                }
                
                if (matched) {
                    StatisticalTableElementIF consolidated = (StatisticalTableElementIF) consolidationMap.get(current);
                    
                    if (consolidated == null) {
                        consolidated = builder.setName(current, element);
                    } else {
                        consolidated = builder.buildCombined(current, element, consolidated);
                    }
                    
                    consolidationMap.put(current,consolidated);
                    
                    break;
                } 
                
            }
            
            if (!matched) {
                rows.add(element);
            }
            

        }

        rows.addAll(consolidationMap.values());

        Collection sortedRows =          new TreeSet(new TreeSet(new MMSorter()
                .getDescending("numberInSample", "name")));
        sortedRows.addAll(rows);

        this.handleBuildResults(input, sortedRows);


    }



    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

}
