/*
 * Created on Mar 24, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.sharetable.filters;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableIF;
import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableTotalDecorator;

public abstract class AbstractFilter implements TableFilter {

    protected Log log = LogFactory.getLog(AbstractFilter.class);
    
    private StatisticalTableIF results;
    
    public StatisticalTableIF getResults() {
        
        return results;
    }

    public void handleBuildResults(StatisticalTableIF input, Collection rows) {
    
        FilteredTable table = new FilteredTable();

        table.setRows(rows);

        table.setFieldEnum(input.getFieldEnum());

        this.postFilterDecoration(table);

        this.setResults(table);
    }
    
    public void setResults(StatisticalTableIF result) {
        this.results = result;
    }
    
    public void postFilterDecoration(FilteredTable input) {

        new StatisticalTableTotalDecorator().decorateWithTotal(input);
        new StatisticalTableReferenceDecorator().decorateWithReference(input);
        
        input.setSizeOfSample(input.getTotal().getSizeOfSample());
    }

}
