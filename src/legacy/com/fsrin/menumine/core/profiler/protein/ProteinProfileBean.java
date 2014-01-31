/*
 * Created on Apr 5, 2005
 *
 * 
 */
package com.fsrin.menumine.core.profiler.protein;

import com.fsrin.menumine.core.menumine.chain.AbstractChainInformationBean;


/**
 * 2006-02-07 RSC Removed Chain Aware. Extended abstractProfileBean
 * @author Nick
 * 
 *  
 */
public class ProteinProfileBean extends AbstractChainInformationBean {

    private Long id;

//    private Chain chain;

    private String menuItem;

    private String itemDescription;

    private String proteinTypeCut;

    private String proteinTopName;

    private String proteinAccompName;

    private String stuffName;

//    public Chain getChain() {
//        return chain;
//    }
//
//    public void setChain(Chain chain) {
//        this.chain = chain;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(String menuItem) {
        this.menuItem = menuItem;
    }

    public String getProteinAccompName() {
        return proteinAccompName;
    }

    public void setProteinAccompName(String proteinAccompName) {
        this.proteinAccompName = proteinAccompName;
    }

    public String getProteinTopName() {
        return proteinTopName;
    }

    public void setProteinTopName(String proteinTopName) {
        this.proteinTopName = proteinTopName;
    }

    public String getProteinTypeCut() {
        return proteinTypeCut;
    }

    public void setProteinTypeCut(String proteinTypeCut) {
        this.proteinTypeCut = proteinTypeCut;
    }

    public String getStuffName() {
        return stuffName;
    }

    public void setStuffName(String stuffName) {
        this.stuffName = stuffName;
    }
}