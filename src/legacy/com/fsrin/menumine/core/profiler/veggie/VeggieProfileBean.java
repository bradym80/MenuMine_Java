/*
 * Created on Apr 5, 2005
 *
 * 
 */
package com.fsrin.menumine.core.profiler.veggie;

import com.fsrin.menumine.core.menumine.chain.AbstractChainInformationBean;

/**
 * @author Nick
 * 
 *  
 */
public class VeggieProfileBean extends AbstractChainInformationBean {

    private Long id;

//    private Chain chain;

    private String menuItem;

    private String itemDescription;

    private String veggieFruitType;

    private String greenVegName;

    private String vegTopName;

    private String vegAccompName;

    private String otherAccompaniments;

    private String otherToppings;

    private String otherIngredName;

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

    public String getGreenVegName() {
        return greenVegName;
    }

    public void setGreenVegName(String greenVegName) {
        this.greenVegName = greenVegName;
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

    public String getVegAccompName() {
        return vegAccompName;
    }

    public void setVegAccompName(String vegAccompName) {
        this.vegAccompName = vegAccompName;
    }

    public String getVeggieFruitType() {
        return veggieFruitType;
    }

    public void setVeggieFruitType(String veggieFruitType) {
        this.veggieFruitType = veggieFruitType;
    }

    public String getVegTopName() {
        return vegTopName;
    }

    public void setVegTopName(String vegTopName) {
        this.vegTopName = vegTopName;
    }
}