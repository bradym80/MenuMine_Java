/*
 * Created on Aug 5, 2005
 *
 * 
 */
package com.fsrin.menumine.core.chainmap;

/**
 * @author Nick
 * 
 *  
 */
public class StateIntencityVo {

    private ChainMapTableLineItem chainMapTableLineItem;

    private int myIntensity;

    public StateIntencityVo() {
        super();

    }

    public StateIntencityVo(ChainMapTableLineItem chainMapTableLineItem,
            int myIntensity) {
        this.chainMapTableLineItem = chainMapTableLineItem;
        this.myIntensity = myIntensity;
    }

    public ChainMapTableLineItem getChainMapTableLineItem() {
        return chainMapTableLineItem;
    }

    public void setChainMapTableLineItem(
            ChainMapTableLineItem chainMapTableLineItem) {
        this.chainMapTableLineItem = chainMapTableLineItem;
    }

    public int getMyIntensity() {
        return myIntensity;
    }

    public void setMyIntensity(int myIntensity) {
        this.myIntensity = myIntensity;
    }
}