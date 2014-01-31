/*
 * Created on Jan 27, 2006
 *
 */
package com.fsrin.menumine.core.menumine.sharetable;

import java.util.Collection;

import com.fsrin.menumine.core.menumine.FieldEnum;

public interface StatisticalTableIF {

    public Collection getRows();
    
    public void setRows(Collection c);

    public FieldEnum getFieldEnum();

    public Long getSizeOfSample();

    public StatisticalTableElementIF getTotal();
    
    public void setTotal(StatisticalTableElementIF total);

}