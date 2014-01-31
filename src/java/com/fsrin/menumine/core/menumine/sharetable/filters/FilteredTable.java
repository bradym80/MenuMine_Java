/*
 * Created on Mar 24, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.sharetable.filters;

import java.util.Collection;

import com.fsrin.menumine.core.menumine.FieldEnum;
import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableElementIF;
import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableIF;

public class FilteredTable implements StatisticalTableIF {

    private Collection rows;
    private FieldEnum fieldEnum;
    private Long sizeOfSample;
    private StatisticalTableElementIF total;
    
    public FieldEnum getFieldEnum() {
        return fieldEnum;
    }
    public void setFieldEnum(FieldEnum fieldEnum) {
        this.fieldEnum = fieldEnum;
    }
    public Collection getRows() {
        return rows;
    }
    public void setRows(Collection rows) {
        this.rows = rows;
    }
    public Long getSizeOfSample() {
        if (sizeOfSample == null)
            this.setSizeOfSample(new Long(0));
        return sizeOfSample;
    }
    public void setSizeOfSample(Long sizeOfSample) {
        this.sizeOfSample = sizeOfSample;
    }
    public StatisticalTableElementIF getTotal() {
        return total;
    }
    public void setTotal(StatisticalTableElementIF total) {
        this.total = total;
    }
    

}
