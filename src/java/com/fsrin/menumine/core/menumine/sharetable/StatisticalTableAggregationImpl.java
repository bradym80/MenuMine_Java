/*
 * Created on Jan 27, 2006
 *
 */
package com.fsrin.menumine.core.menumine.sharetable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fsrin.menumine.common.webwork.MMSorter;
import com.fsrin.menumine.core.menumine.FieldEnum;
import com.fsrin.menumine.util.GroupCounterTotaller;
import com.fsrin.menumine.util.GroupCounterVO;

/**
 * 2006-01-27 based an aggregate results instead of individual results. 
 * 
 * @author Reid
 *
 */
public class StatisticalTableAggregationImpl implements Serializable,
        StatisticalTableIF {

    private Collection rawRows;
    private Collection elementRows;
    private FieldEnum fieldEnum;
    private Long sizeOfSample;
    private StatisticalTableElementIF total;
    
    private static Log log = LogFactory.getLog(StatisticalTableAggregationImpl.class);
    
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
        
        log.debug("starting to prepareElementRows");
        
        /*
         * decorate the elements first.
         * 
         * 2006-04-10 RSC Don't need this -- percent is easy enough to do on the fly.
         */
        //new GroupCounterDecorator().decorateWithShare(rawRows);
        
        /*
         * figure out our total.
         */
        Integer total = new GroupCounterTotaller().getTotal(rawRows);
        
//        elementRows = new TreeSet(new TreeSet(new MMSorter()
//                .getDescending("percent", "name")));
        
        elementRows = new ArrayList();
        
        for (Iterator iter = rawRows.iterator(); iter.hasNext();) {
            GroupCounterVO element = (GroupCounterVO) iter.next();
            StatisticalTableElementAggregationImpl processed = new StatisticalTableElementAggregationImpl();
            processed.setFieldEnum(this.fieldEnum);
            processed.setNumberInSample(new Long(element.getCount().longValue()));
            //2006-03-24 RSC
//            processed.setSizeOfSample(new Long(total.longValue()));
            processed.setName(element.getGroup());
//            processed.setPercent(new Double(element.getShare().doubleValue() * 100.0));
            processed.setParentTable(this);
            elementRows.add(processed);
        }
        
        log.debug(" prepareElementRows is completed");

        
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
        if (sizeOfSample == null && this.getTotal() != null) 
            this.setSizeOfSample(this.getTotal().getSizeOfSample());
        
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
