/*
 * Created on Jan 27, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.sharetable;

import com.fsrin.menumine.core.menumine.FieldEnum;

public class StatisticalTableElementAggregationImpl extends
        AbstractStatisticalTableElement implements StatisticalTableElementIF {

    private Double percent;

    private FieldEnum fieldEnum;

    private Long numberInSample;

    private Long sizeOfSample;

    /*
     * 2006-01-27 RSC Probably won't have a lot going on with this for a while.
     * 2006-02-01 RSC This will be set during the build process.
     */
    private StatisticalTablePriceDataIF priceData;

    public StatisticalTablePriceDataIF getPriceData() {

        return priceData;
    }

    public FieldEnum getFieldEnum() {
        return fieldEnum;
    }

    public void setFieldEnum(FieldEnum fieldEnum) {
        this.fieldEnum = fieldEnum;
    }

    public Long getNumberInSample() {
        return numberInSample;
    }

    public void setNumberInSample(Long numberInSample) {
        this.numberInSample = numberInSample;
    }

    public Double getPercent() {
        
            percent = new Double(100.0 * 
                    ((double) this.getNumberInSample().longValue())
                            / ((double) this.getSizeOfSample().longValue()));
        
        return percent;
    }

    public void setPercent(Double percent) {
        this.percent = percent;
    }

    public Long getSizeOfSample() {
        if (this.getParentTable() != null)
            return this.getParentTable().getSizeOfSample();

        return sizeOfSample;

    }

    public void setSizeOfSample(Long sizeOfSample) {
        this.sizeOfSample = sizeOfSample;
    }

    public void setPriceData(StatisticalTablePriceDataIF priceData) {
        this.priceData = priceData;
    }

}
