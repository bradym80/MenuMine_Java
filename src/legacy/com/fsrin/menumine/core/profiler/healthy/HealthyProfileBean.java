/*
 * Created on Apr 5, 2005
 *
 * 
 */
package com.fsrin.menumine.core.profiler.healthy;

import com.fsrin.menumine.core.menumine.chain.AbstractChainInformationBean;

/**
 * @author Nick
 * 
 *  
 */
public class HealthyProfileBean extends AbstractChainInformationBean {

    private Long id;

//    private Chain chain;

    private String menuItem;

    private String itemDescription;

    private String healthyTerm;

    private String healthyFlag;

    private String healthySymbol;

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

    public String getHealthyFlag() {
        return healthyFlag;
    }

    public void setHealthyFlag(String healthyFlag) {
        this.healthyFlag = healthyFlag;
    }

    public String getHealthySymbol() {
        return healthySymbol;
    }

    public void setHealthySymbol(String healthySymbol) {
        this.healthySymbol = healthySymbol;
    }

    public String getHealthyTerm() {
        return healthyTerm;
    }

    public void setHealthyTerm(String healthyTerm) {
        this.healthyTerm = healthyTerm;
    }
}