/*
 * Created on Feb 3, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.sharetable;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class StatisticalTableElementIFBuilder {

    private static final Log log = LogFactory.getLog(StatisticalTableElementIFBuilder.class);
    
    public StatisticalTableElementIF setName(String combinedName, StatisticalTableElementIF one) {
        StatisticalTableElementAggregationImpl ret = (StatisticalTableElementAggregationImpl) one;

        ret.setName(combinedName);
        ret.setFieldEnum(one.getFieldEnum()); // should be the same
        
        
        ret.setNumberInSample(new Long(one.getNumberInSample().longValue()));// this is the total for

        ret.setPriceData(one.getPriceData());
        ret.setParentTable(one.getParentTable());

        
        
        return ret;        
    }
    
    public StatisticalTableElementIF buildCombined(String combinedName,
            StatisticalTableElementIF one, StatisticalTableElementIF two) {

        if (one.getParentTable() == null || two.getParentTable() == null)
            throw new RuntimeException("a parent table is null");
        
        if (one.getParentTable() != two.getParentTable())
            throw new RuntimeException("you can only merge rows of the same table.");
        
        StatisticalTableElementAggregationImpl ret = new StatisticalTableElementAggregationImpl();

        ret.setName(combinedName);
        ret.setFieldEnum(one.getFieldEnum()); // should be the same
        
        if (one == null || one.getSizeOfSample() == null) {
            log.warn("one or one.sizeOfSample is null");
        }
//        ret.setSizeOfSample(new Long(one.getSizeOfSample().longValue()));
        // the whole table. no
        // need to add.
        
        ret.setNumberInSample(new Long(one.getNumberInSample().longValue()
                + two.getNumberInSample().longValue()));// this is the total for

        ret.setPriceData(new StatisticalTablePriceDataBuilder().buildCombined(
                one.getPriceData(), one.getSizeOfSample().intValue(), two
                        .getPriceData(), two.getSizeOfSample().intValue()));
        ret.setParentTable(one.getParentTable());
        ret.setPercent(new Double((ret.getNumberInSample().doubleValue() / ret
                .getSizeOfSample().doubleValue()) * 100.0));

        
        
        return ret;
    }
    
    public StatisticalTableElementIF decorateCombined(String combinedName,
            StatisticalTableElementIF toDecorate, StatisticalTableElementIF two) {

        if (toDecorate.getParentTable() == null || two.getParentTable() == null)
            throw new RuntimeException("a parent table is null");
        
        if (toDecorate.getParentTable() != two.getParentTable())
            throw new RuntimeException("you can only merge rows of the same table.");
        
        StatisticalTableElementAggregationImpl ret = (StatisticalTableElementAggregationImpl) toDecorate;

        ret.setName(combinedName);
        ret.setFieldEnum(toDecorate.getFieldEnum()); // should be the same
        
        if (toDecorate == null || toDecorate.getSizeOfSample() == null) {
            log.warn("one or one.sizeOfSample is null");
        }
//        ret.setSizeOfSample(new Long(one.getSizeOfSample().longValue()));
        // the whole table. no
        // need to add.
        
        ret.setNumberInSample(new Long(toDecorate.getNumberInSample().longValue()
                + two.getNumberInSample().longValue()));// this is the total for

        ret.setPriceData(new StatisticalTablePriceDataBuilder().buildCombined(
                toDecorate.getPriceData(), toDecorate.getSizeOfSample().intValue(), two
                        .getPriceData(), two.getSizeOfSample().intValue()));
        ret.setParentTable(toDecorate.getParentTable());
        ret.setPercent(new Double((ret.getNumberInSample().doubleValue() / ret
                .getSizeOfSample().doubleValue()) * 100.0));

        
        
        return ret;
    }

    /*
     * 2006-04-10 used for tests.
     */
    public static StatisticalTableElementIF build(StatisticalTableIF parent, String name, int numberInSample) {
        
        StatisticalTableElementAggregationImpl ret = new StatisticalTableElementAggregationImpl();
        
        ret.setFieldEnum(parent.getFieldEnum());
        ret.setName(name);
        ret.setNumberInSample(new Long(numberInSample));
        ret.setParentTable( parent);
        
        return ret;
        
    }
}
