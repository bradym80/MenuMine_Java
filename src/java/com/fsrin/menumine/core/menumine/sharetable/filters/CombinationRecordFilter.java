/*
 * Created on Mar 24, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.sharetable.filters;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableElementIF;
import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableElementIFBuilder;
import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableIF;

/**
 * have to remove anything with a key of "none" and then adjust the total size
 * of the sample.
 * 
 * @author Reid
 */
public class CombinationRecordFilter extends AbstractFilter {

    private boolean eliminate;

    private String combinedName = "Combination Records";
    
    public void execute(StatisticalTableIF input) throws Exception {
        Collection rows = new ArrayList();

        StatisticalTableElementIF none = null;

        StatisticalTableElementIF combined = null;
        
        for (Iterator iter = input.getRows().iterator(); iter.hasNext();) {
            StatisticalTableElementIF element = (StatisticalTableElementIF) iter
                    .next();

            if (element.getName().indexOf("/") != -1) {
                log.info("found a none record " + element.getNumberInSample());
                
                if (!this.isEliminate()) {
                    if (combined == null) {
                        combined = new StatisticalTableElementIFBuilder()
                        .setName(this.getCombinedName(), element);
                    } else {
                        combined = new StatisticalTableElementIFBuilder()
                                .buildCombined(this.getCombinedName(),
                                        combined, element);
                    }
                }
                
            } else {
                rows.add(element);
            }

        }

        if (!this.isEliminate() && combined != null) {
            rows.add(combined);
        }
        
        FilteredTable table = new FilteredTable();

        table.setRows(rows);
        
        table.setFieldEnum(input.getFieldEnum());

        this.postFilterDecoration(table);

        this.setResults(table);

    }

    public String getCombinedName() {
        return combinedName;
    }

    public void setCombinedName(String combinedName) {
        this.combinedName = combinedName;
    }

    public boolean isEliminate() {
        return eliminate;
    }

    public void setEliminate(boolean eliminate) {
        this.eliminate = eliminate;
    }

}
