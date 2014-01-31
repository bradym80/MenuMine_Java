/*
 * Created on Apr 5, 2005
 *
 * 
 */
package com.fsrin.menumine.core.profiler.dessert;

import com.fsrin.menumine.core.menumine.chain.AbstractChainInformationBean;

/**
 * @author Nick
 * 
 *  
 */
public class DessertProfileBean extends AbstractChainInformationBean {

    private Long id;

//    private Chain chain;

    private String menuItem;

    private String itemDescription;

    private String fruitOrFruitFillingIngred;

    private String iceCreamIngredient;

    private String cakeIngredient;

    private String cookieIngredient;

    private String nutIngredient;

    private String whippedToppingIngred;

    private String candyIngredient;

    private String otherTopIngred;

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

    public String getCakeIngredient() {
        return cakeIngredient;
    }

    public void setCakeIngredient(String cakeIngredient) {
        this.cakeIngredient = cakeIngredient;
    }

    public String getCandyIngredient() {
        return candyIngredient;
    }

    public void setCandyIngredient(String candyIngredient) {
        this.candyIngredient = candyIngredient;
    }

    public String getCookieIngredient() {
        return cookieIngredient;
    }

    public void setCookieIngredient(String cookieIngredient) {
        this.cookieIngredient = cookieIngredient;
    }

    public String getFruitOrFruitFillingIngred() {
        return fruitOrFruitFillingIngred;
    }

    public void setFruitOrFruitFillingIngred(String fruitOrFruitFillingIngred) {
        this.fruitOrFruitFillingIngred = fruitOrFruitFillingIngred;
    }

    public String getIceCreamIngredient() {
        return iceCreamIngredient;
    }

    public void setIceCreamIngredient(String iceCreamIngredient) {
        this.iceCreamIngredient = iceCreamIngredient;
    }

    public String getNutIngredient() {
        return nutIngredient;
    }

    public void setNutIngredient(String nutIngredient) {
        this.nutIngredient = nutIngredient;
    }

    public String getOtherTopIngred() {
        return otherTopIngred;
    }

    public void setOtherTopIngred(String otherTopIngred) {
        this.otherTopIngred = otherTopIngred;
    }

    public String getWhippedToppingIngred() {
        return whippedToppingIngred;
    }

    public void setWhippedToppingIngred(String whippedToppingIngred) {
        this.whippedToppingIngred = whippedToppingIngred;
    }
}