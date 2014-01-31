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

public class LowCountRowsFilter extends AbstractFilter implements
        TableFilter {

//    private StatisticalTableIF results;

    private int combinationThreshhold;

    /**
     * causes us to drop the matching rows.  Default behavior is to combine.
     */
    private boolean eliminate;

    private String combinedName = "Below Threshold";

//    public StatisticalTableIF getResults() {
//        return results;
//    }
//
//    public void setResults(StatisticalTableIF results) {
//        this.results = results;
//    }

    public void execute(StatisticalTableIF input) throws Exception {

        if (this.getCombinationThreshhold() == 0.0) {
            throw new RuntimeException(
                    "combination threshold must be greater than 0");
        }

        Collection rows = new ArrayList();

        StatisticalTableElementIF combined = null;

        for (Iterator iter = input.getRows().iterator(); iter.hasNext();) {
            StatisticalTableElementIF element = (StatisticalTableElementIF) iter
                    .next();

            if (element.getNumberInSample().intValue() <= this
                    .getCombinationThreshhold()) {
                if (!this.isEliminate()) {
                    if (combined == null) {
                        combined = element;
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

//        FilteredTable table = new FilteredTable();
//
//        table.setRows(rows);
//        table.setFieldEnum(input.getFieldEnum());
//
//        this.postFilterDecoration(table);
//
//        this.setResults(table);

        this.handleBuildResults(input, rows);
    }

    public int getCombinationThreshhold() {
        return combinationThreshhold;
    }

    public void setCombinationThreshhold(int combinationThreshhold) {
        this.combinationThreshhold = combinationThreshhold;
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
