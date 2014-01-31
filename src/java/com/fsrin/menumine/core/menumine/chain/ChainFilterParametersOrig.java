/*
 * Created on Jan 17, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.chain;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Nick
 * 
 *  
 */
public class ChainFilterParametersOrig {

    private Collection chainNameIn = new ArrayList();

    private Collection chainNameLike = new ArrayList();

    private Collection sectorNameIn = new ArrayList();

    private Collection sectorNameLike = new ArrayList();

    private Collection segmentIn = new ArrayList();

    private Collection segmentLike = new ArrayList();

    private Collection hqStateIn = new ArrayList();

    private Collection hqStateLike = new ArrayList();

    public Collection getChainNameIn() {
        return chainNameIn;
    }

    public void setChainNameIn(Collection chainNameIn) {
        this.chainNameIn = chainNameIn;
    }

    public Collection getChainNameLike() {
        return chainNameLike;
    }

    public void setChainNameLike(Collection chainNameLike) {
        this.chainNameLike = chainNameLike;
    }

    public Collection getHqStateIn() {
        return hqStateIn;
    }

    public void setHqStateIn(Collection hqStateIn) {
        this.hqStateIn = hqStateIn;
    }

    public Collection getHqStateLike() {
        return hqStateLike;
    }

    public void setHqStateLike(Collection hqStateLike) {
        this.hqStateLike = hqStateLike;
    }

    public Collection getSectorNameIn() {
        return sectorNameIn;
    }

    public void setSectorNameIn(Collection sectorNameIn) {
        this.sectorNameIn = sectorNameIn;
    }

    public Collection getSectorNameLike() {
        return sectorNameLike;
    }

    public void setSectorNameLike(Collection sectorNameLike) {
        this.sectorNameLike = sectorNameLike;
    }

    public Collection getSegmentIn() {
        return segmentIn;
    }

    public void setSegmentIn(Collection segmentIn) {
        this.segmentIn = segmentIn;
    }

    public Collection getSegmentLike() {
        return segmentLike;
    }

    public void setSegmentLike(Collection segmentLike) {
        this.segmentLike = segmentLike;
    }
}