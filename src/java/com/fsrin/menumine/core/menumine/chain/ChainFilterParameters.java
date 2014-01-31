/*
 * Created on Jan 17, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.chain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import ognl.Ognl;
import ognl.OgnlException;

import com.fsrin.menumine.common.FilterParameter;
import com.fsrin.menumine.core.menumine.FieldEnum;

/**
 * @author Nick
 * 
 *  
 */
public class ChainFilterParameters implements Serializable {

    private Long id;

    private FilterParameter operationName = new FilterParameter(
            FieldEnum.OPERATION_NAME);

    private FilterParameter sectorName = new FilterParameter(
            FieldEnum.MARKET_SECTOR);

    private FilterParameter segment = new FilterParameter(
            FieldEnum.MARKET_SEGMENT);

    private FilterParameter hqState = new FilterParameter(
            FieldEnum.HEADQUARTERS_STATE);

    private FilterParameter hqRegion = new FilterParameter(
            FieldEnum.HEADQUARTERS_REGION);

    private FilterParameter operatorType = new FilterParameter(
            FieldEnum.OPERATOR_TYPE);

    private FilterParameter countryLoc = new FilterParameter(
            FieldEnum.COUNTRY_LOCATION);

    private FilterParameter yearPutInDatabase = new FilterParameter(
            FieldEnum.YEAR_PUT_IN_DATABASE);

    public FilterParameter getHqState() {
        return hqState;
    }

    public void setHqState(FilterParameter hqState) {
        this.hqState = hqState;
    }

    public FilterParameter getOperationName() {
        return operationName;
    }

    public void setOperationName(FilterParameter operationName) {
        this.operationName = operationName;
    }

    public FilterParameter getSectorName() {
        return sectorName;
    }

    public void setSectorName(FilterParameter sectorName) {
        this.sectorName = sectorName;
    }

    public FilterParameter getSegment() {
        return segment;
    }

    public void setSegment(FilterParameter segment) {
        this.segment = segment;
    }

    public Collection getAll() {
        Collection all = new ArrayList();
        all.add(operationName);
        all.add(hqState);
        all.add(segment);
        all.add(sectorName);
        all.add(hqRegion);
        all.add(operatorType);
        return all;
    }

    public void setFilterParameters(Set col) {
        for (Iterator iter = col.iterator(); iter.hasNext();) {
            FilterParameter element = (FilterParameter) iter.next();
            try {
                Ognl.setValue(element.getField().getShortOgnlName(), this,
                        element);
            } catch (OgnlException e) {
                /*
                 * nick 2005-21-2005 Any params for the chainfilter will throw
                 * exceptions, and that is fine
                 */
            }
        }
    }

    public Set getFilterParameters() {
        Set all = new HashSet();
        for (Iterator iter = FieldEnum.getAll().iterator(); iter.hasNext();) {
            FieldEnum element = (FieldEnum) iter.next();
            Object o = null;
            try {
                o = Ognl.getValue(element.getShortOgnlName(), this);
            } catch (OgnlException e) {

                /*
                 * nick 2005-21-2005 Any params for the chainfilter will throw
                 * exceptions, and that is fine
                 */
            }
            if (o != null) {
                all.add(o);
            }
        }

        return all;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FilterParameter getCountryLoc() {
        return countryLoc;
    }

    public void setCountryLoc(FilterParameter countryLoc) {
        this.countryLoc = countryLoc;
    }

    public FilterParameter getHqRegion() {
        return hqRegion;
    }

    public void setHqRegion(FilterParameter hqRegion) {
        this.hqRegion = hqRegion;
    }

    public FilterParameter getOperatorType() {
        return operatorType;
    }

    public void setOperatorType(FilterParameter operatorType) {
        this.operatorType = operatorType;
    }

    public FilterParameter getYearPutInDatabase() {
        return yearPutInDatabase;
    }

    public void setYearPutInDatabase(FilterParameter yearPutInDatabase) {
        this.yearPutInDatabase = yearPutInDatabase;
    }
}