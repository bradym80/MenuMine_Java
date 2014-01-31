/*
 * Created on Jan 20, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.sharetable;

import com.fsrin.menumine.core.menumine.FieldEnum;
import com.fsrin.menumine.core.menumine.masterfood.MasterFood;

/**
 * @author Nick This displays data in groups along with stats about the groups
 * 
 */
public class StatisticalTableElementStandardImpl extends
        AbstractStatisticalTableElement implements StatisticalTableElementIF {

    private String name;

    /*
     * This is the field we are grouping on.
     */
    // private FieldEnum fieldEnum;
    // private Long sizeOfSample;
    private final StatisticalTableIF statisticalTable;

    private long numberInSample = 0;

    // private Collection results;

    private StatisticalTablePriceDataStandardImpl priceData = new StatisticalTablePriceDataStandardImpl();

    public StatisticalTableElementStandardImpl(String name,
            StatisticalTableIF statisticalTable) {
        this.name = name;
        this.statisticalTable = statisticalTable;
    }

    public void addMasterFood(MasterFood masterFood) {
        numberInSample++;
        priceData.addMasterFood(masterFood);
    }

    public Double getPercent() {

        double percent = (this.getNumberInSample().doubleValue() / this
                .getSizeOfSample().doubleValue()) * 100;
        if (this.getNumberInSample() == null
                || this.getNumberInSample().longValue() == 0) {
            percent = 0.0;
        }

        return new Double(percent);
    }

    public FieldEnum getFieldEnum() {
        return this.statisticalTable.getFieldEnum();
    }

    public String getName() {
        return name;
    }

    public Long getNumberInSample() {
        return new Long(numberInSample);
    }

    public Long getSizeOfSample() {
        return this.statisticalTable.getSizeOfSample();
    }

    public StatisticalTablePriceDataIF getPriceData() {
        return priceData;
    }
}
