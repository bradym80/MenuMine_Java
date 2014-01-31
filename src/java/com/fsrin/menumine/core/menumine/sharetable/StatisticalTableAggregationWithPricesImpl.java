/*
 * Created on Jan 27, 2006
 *
 */
package com.fsrin.menumine.core.menumine.sharetable;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;

import com.fsrin.menumine.common.webwork.MMSorter;
import com.fsrin.menumine.core.menumine.FieldEnum;

/**
 * 2006-01-27 based an aggregate results instead of individual results. 
 * 
 * @author Reid
 *
 */
public class StatisticalTableAggregationWithPricesImpl implements Serializable,
        StatisticalTableIF {

    private Collection rawRows;
    private Collection elementRows;
    private FieldEnum fieldEnum;
    private Long sizeOfSample;
    private StatisticalTableElementIF total;
    
    
    
    public Collection getRows() {
        if (elementRows == null)
            prepareElementRows();
        
        return elementRows;
    }

    public void setRows(Collection rows) {
        elementRows = new TreeSet(new TreeSet(new MMSorter()
                .getDescending("percent", "name")));
        
        elementRows.addAll(rows);
        
    }
    
    private void prepareElementRows() {
        
        /*
         * decorate the elements first.
         * 2006-02-01 RSC Don't need this for prices.
         */
        //new GroupCounterDecorator().decorateWithShare(rawRows);
        
        /*
         * figure out our total.
         * 2006-02-01 RSC Don't need this for prices.
         *
         */
//        Integer total = new GroupCounterTotaller().getTotal(rawRows);
        
        elementRows = new TreeSet(new TreeSet(new MMSorter()
                .getDescending("numberInSample", "name")));
        
        
        for (Iterator iter = rawRows.iterator(); iter.hasNext();) {
            
            Object[] element = (Object[])iter.next();
            
            StatisticalTableElementAggregationImpl processed = new StatisticalTableElementAggregationImpl();
            processed.setFieldEnum(this.fieldEnum);
            processed.setNumberInSample(new Long(((Integer)element[0]).longValue()));
//            processed.setSizeOfSample(new Long(total.longValue()));
            String name= (String) element[1];
            if (name == null || name.trim().length() == 0) {
                name=AbstractStatisticalTableElement.NOT_ON_MENU;
            }
            processed.setName(name);
//            processed.setPercent(new Double(element.getShare().doubleValue() * 100.0));
            
            processed.setPriceData(new StatisticalTablePriceDataAggregationImpl(element));
//            processed.setSizeOfSample(this.getSizeOfSample());
            processed.setParentTable(this);
            
            elementRows.add(processed);
        }
        


        
    }
    /**
     * @return Returns the fieldEnum.
     */
    public FieldEnum getFieldEnum() {
        return fieldEnum;
    }

    /**
     * @param fieldEnum The fieldEnum to set.
     */
    public void setFieldEnum(FieldEnum fieldEnum) {
        this.fieldEnum = fieldEnum;
    }

    /**
     * @return Returns the sizeOfSample.
     */
    public Long getSizeOfSample() {
        return sizeOfSample;
    }

    /**
     * @param sizeOfSample The sizeOfSample to set.
     */
    public void setSizeOfSample(Long sizeOfSample) {
        this.sizeOfSample = sizeOfSample;
    }

    /**
     * @return Returns the total.
     */
    public StatisticalTableElementIF getTotal() {
        return total;
    }

    /**
     * @param total The total to set.
     */
    public void setTotal(StatisticalTableElementIF total) {
        this.total = total;
    }

    public Collection getRawRows() {
        return rawRows;
    }

    public void setRawRows(Collection rawRows) {
        this.rawRows = rawRows;
    }



}
