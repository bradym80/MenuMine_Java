/*
 * Created on Mar 24, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.sharetable.filters;

import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableIF;

public class TableFilterer {

    public StatisticalTableIF filter(StatisticalTableIF input,
            TableFilter filter) throws TableFiltererException {

        try {
            filter.execute(input);
        } catch (Exception e) {

            throw new TableFiltererException(e);
        }

        return filter.getResults();
    }
}
