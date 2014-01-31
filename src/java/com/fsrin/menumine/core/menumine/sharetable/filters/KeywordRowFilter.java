/*
 * Created on Apr 10, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.sharetable.filters;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableElementIF;
import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableElementIFBuilder;
import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableIF;

/**
 * if a row matched any of the keywords a user entered, just eliminate the
 * whole row and accrue to none.
 * 
 * @author Reid
 */
public class KeywordRowFilter extends AbstractFilter {

    private String keywords;
    
    private String combinedName;
    
    private boolean eliminate;
    
    
    
    public void execute(StatisticalTableIF input) throws Exception {
        
        if (this.getKeywords() == null || this.getKeywords().trim().length() == 0) {
            log.info("no keywords.");
            this.setResults(input);
            return;
        }

        /*
         * 2006-05-26 reid@fivesticks.com need to get rid of any non
         * space white space.
         */
        String keywords = this.getKeywords();
        keywords.replaceAll("\\W", " ");
        
//        String[] keywordArray = this.getKeywords().toLowerCase().split("\\W");
        String[] keywordArray = keywords.split("\\W");
        Collection rows = new ArrayList();

        StatisticalTableElementIF combined = null;
        
        StatisticalTableElementIFBuilder builder = new StatisticalTableElementIFBuilder();

        for (Iterator iter = input.getRows().iterator(); iter.hasNext();) {
            StatisticalTableElementIF element = (StatisticalTableElementIF) iter
                    .next();

            
            if (this.isKeywordMatch(element, keywordArray)) {
               if (combined != null) {
                   combined = builder.buildCombined(this.getCombinedName(), combined, element);
               } else {
                   combined = builder.setName(this.getCombinedName(), element);
               }
               
            } else {
                rows.add(element);
            }

        }

        if (!this.isEliminate() && combined != null) {
            rows.add(combined);
        }



        this.handleBuildResults(input, rows);
    }

    public boolean isKeywordMatch(StatisticalTableElementIF element, String[] keywordArray) {
        
        boolean ret = false;
        
        String lc = element.getName().toLowerCase();
       
        for (int i = 0; i < keywordArray.length; i++) {
            if (lc.indexOf(keywordArray[i]) != -1) {
                ret = true;
                break;
            }
        }
        
        
        return ret;
    }
    public boolean isEliminate() {
        return eliminate;
    }

    public void setEliminate(boolean eliminate) {
        this.eliminate = eliminate;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getCombinedName() {
        return combinedName;
    }

    public void setCombinedName(String combinedName) {
        this.combinedName = combinedName;
    }

}
