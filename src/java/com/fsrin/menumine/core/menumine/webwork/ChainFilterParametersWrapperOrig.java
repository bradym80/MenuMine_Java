/*
 * Created on Jan 19, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.webwork;

import java.util.Collection;

import com.fsrin.menumine.core.menumine.chain.ChainFilterParametersOrig;

/**
 * @author Nick
 * 
 *  
 */
public class ChainFilterParametersWrapperOrig extends FilterWrapper {

    private ChainFilterParametersOrig chainFilterParameters;

    public ChainFilterParametersWrapperOrig(
            ChainFilterParametersOrig chainFilterParameters) {
        super();
        this.chainFilterParameters = chainFilterParameters;
    }

    public Collection getChainNameIn() {
        return chainFilterParameters.getChainNameIn();
    }

    public String getChainNameLike() {
        return this.returnAsString(chainFilterParameters.getChainNameLike());
    }

    public String getHqStateLike() {
        return this.returnAsString(chainFilterParameters.getHqStateLike());
    }

    public Collection getSectorNameIn() {
        return chainFilterParameters.getSectorNameIn();
    }

    public String getSectorNameLike() {
        return this.returnAsString(chainFilterParameters.getSectorNameLike());
    }

    public Collection getSegmentIn() {
        return chainFilterParameters.getSegmentIn();
    }

    public String getSegmentLike() {
        return this.returnAsString(chainFilterParameters.getSegmentLike());
    }

    public void setChainNameIn(Collection chainNameIn) {
        chainFilterParameters.setChainNameIn(chainNameIn);
    }

    public void setChainNameLike(String chainNameLike) {
        chainFilterParameters
                .setChainNameLike(parseToCollection(chainNameLike));
    }

    public void setHqStateLike(String hqStateLike) {
        chainFilterParameters.setHqStateLike(parseToCollection(hqStateLike));
    }

    public void setSectorNameIn(Collection sectorNameIn) {
        chainFilterParameters.setSectorNameIn(sectorNameIn);
    }

    public void setSectorNameLike(String sectorNameLike) {
        chainFilterParameters
                .setSectorNameLike(parseToCollection(sectorNameLike));
    }

    public void setSegmentIn(Collection segmentIn) {
        chainFilterParameters.setSegmentIn(segmentIn);
    }

    public void setSegmentLike(String segmentLike) {
        chainFilterParameters.setSegmentLike(parseToCollection(segmentLike));
    }
}