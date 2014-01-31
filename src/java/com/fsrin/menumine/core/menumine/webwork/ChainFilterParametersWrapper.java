/*
 * Created on Jan 19, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.webwork;

import com.fsrin.menumine.core.menumine.chain.ChainFilterParameters;

/**
 * @author Nick
 * 
 *  
 */
public class ChainFilterParametersWrapper extends FilterWrapper {

    private ChainFilterParameters chainFilterParameters;

    public ChainFilterParametersWrapper(
            ChainFilterParameters chainFilterParameters) {
        super();
        this.chainFilterParameters = chainFilterParameters;
    }

    public FilterParameterWrapper getHqState() {
        return new FilterParameterWrapper(chainFilterParameters.getHqState());

    }

    public FilterParameterWrapper getOperationName() {
        return new FilterParameterWrapper(chainFilterParameters
                .getOperationName());
    }

    public FilterParameterWrapper getSectorName() {
        return new FilterParameterWrapper(chainFilterParameters.getSectorName());
    }

    public FilterParameterWrapper getSegment() {
        return new FilterParameterWrapper(chainFilterParameters.getSegment());
    }

    public FilterParameterWrapper getCountryLoc() {
        return new FilterParameterWrapper(chainFilterParameters.getCountryLoc());
    }

    public FilterParameterWrapper getHqRegion() {
        return new FilterParameterWrapper(chainFilterParameters.getHqRegion());
    }

    public FilterParameterWrapper getOperatorType() {
        return new FilterParameterWrapper(chainFilterParameters
                .getOperatorType());
    }

    public FilterParameterWrapper getSameStore() {
        return new FilterParameterWrapper(chainFilterParameters
                .getYearPutInDatabase());
    }

}