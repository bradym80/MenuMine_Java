/*
 * Created on Sep 14, 2006 by Reid
 */
package com.fsrin.menumine.core.incidence;

public abstract class AbstractIncidenceTotals implements IncidenceTotals {

    private int recordCount;

    public int getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }
    
}
