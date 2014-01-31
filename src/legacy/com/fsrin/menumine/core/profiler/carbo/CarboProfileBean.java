/*
 * Created on Apr 5, 2005
 *
 * 
 */
package com.fsrin.menumine.core.profiler.carbo;

import com.fsrin.menumine.core.menumine.chain.AbstractChainInformationBean;

/**
 * @author Nick
 * 
 *  
 */
public class CarboProfileBean extends AbstractChainInformationBean {

    private Long id;

//    private Chain chain;

    private String menuItem;

    private String itemDescription;

    private String carboType;

    private String carboAccompName;

    private String carboTopName;

    private String otherAccompaniments;

    private String otherIngredName;

    private String otherToppings;

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

    public String getCarboAccompName() {
        return carboAccompName;
    }

    public void setCarboAccompName(String carboAccompName) {
        this.carboAccompName = carboAccompName;
    }

    public String getCarboTopName() {
        return carboTopName;
    }

    public void setCarboTopName(String carboTopName) {
        this.carboTopName = carboTopName;
    }

    public String getCarboType() {
        return carboType;
    }

    public void setCarboType(String carboType) {
        this.carboType = carboType;
    }

    public String getOtherAccompaniments() {
        return otherAccompaniments;
    }

    public void setOtherAccompaniments(String otherAccompaniments) {
        this.otherAccompaniments = otherAccompaniments;
    }

    public String getOtherIngredName() {
        return otherIngredName;
    }

    public void setOtherIngredName(String otherIngredName) {
        this.otherIngredName = otherIngredName;
    }

    public String getOtherToppings() {
        return otherToppings;
    }

    public void setOtherToppings(String otherToppings) {
        this.otherToppings = otherToppings;
    }

    public String getStuffName() {
        return stuffName;
    }

    public void setStuffName(String stuffName) {
        this.stuffName = stuffName;
    }
}