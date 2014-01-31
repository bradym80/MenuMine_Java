/*
 * Created on Jan 27, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.sharetable;

import com.fsrin.menumine.core.menumine.FieldEnum;
import com.fsrin.menumine.util.ItemCountAwareIF;

public interface StatisticalTableElementIF extends ItemCountAwareIF{

    public StatisticalTableIF getParentTable();
    
    public void setParentTable(StatisticalTableIF parentTable);
    
    public Double getPercent();

    public FieldEnum getFieldEnum();

    public String getNameWordClickable();
    
    public String getNameWordClickableShort();

    public String getName();

    public Long getNumberInSample();

    public Long getSizeOfSample();

    public StatisticalTablePriceDataIF getPriceData();
    
    

}