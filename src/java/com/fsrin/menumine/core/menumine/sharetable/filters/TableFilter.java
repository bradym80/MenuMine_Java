/*
 * Created on Mar 24, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.sharetable.filters;

import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableIF;

public interface TableFilter {

    public void execute(StatisticalTableIF input) throws Exception;
    
    public StatisticalTableIF getResults();
}
