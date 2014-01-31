/*
 * Created on Apr 5, 2005
 *
 * 
 */
package com.fsrin.menumine.core.profiler.flavor;

import com.fsrin.menumine.core.menumine.chain.AbstractChainInformationBean;

/**
 * 2006-04-19 RSC These are built from MasterFood Records.
 * 
 * @author Nick
 * 
 *  
 */
public class FlavorProfileBean extends AbstractChainInformationBean {

    private Long id;

//    private Chain chain;

    private String menuItem;

    private String itemDescription;

    private String cookingSauceOrGravy;

    private String marinade;

    private String glaze;

    private String condiments;

    private String dressings;

    private String dipSauceName;

    private String seasoningName;

    private String stuffName;

    private String batterBreadingCoating;

    private String fillingSaucesDressings;

    private String otherToppings;

    private String otherIngredName;

    private String breadWrapChips;

    private String cheeseMM;

    private String syrupTopping;

    public FlavorProfileBean() {
        super();

    }

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

    public String getBatterBreadingCoating() {
        return batterBreadingCoating;
    }

    public void setBatterBreadingCoating(String batterBreadingCoating) {
        this.batterBreadingCoating = batterBreadingCoating;
    }

    public String getBreadWrapChips() {
        return breadWrapChips;
    }

    public void setBreadWrapChips(String breadWrapChips) {
        this.breadWrapChips = breadWrapChips;
    }

    public String getCheeseMM() {
        return cheeseMM;
    }

    public void setCheeseMM(String cheese) {
        this.cheeseMM = cheese;
    }

    public String getCondiments() {
        return condiments;
    }

    public void setCondiments(String condiments) {
        this.condiments = condiments;
    }

    public String getCookingSauceOrGravy() {
        return cookingSauceOrGravy;
    }

    public void setCookingSauceOrGravy(String cookingSauceOrGravy) {
        this.cookingSauceOrGravy = cookingSauceOrGravy;
    }

    public String getDipSauceName() {
        return dipSauceName;
    }

    public void setDipSauceName(String dipSauceName) {
        this.dipSauceName = dipSauceName;
    }

    public String getDressings() {
        return dressings;
    }

    public void setDressings(String dressings) {
        this.dressings = dressings;
    }

    public String getFillingSaucesDressings() {
        return fillingSaucesDressings;
    }

    public void setFillingSaucesDressings(String fillingSaucesDressings) {
        this.fillingSaucesDressings = fillingSaucesDressings;
    }

    public String getGlaze() {
        return glaze;
    }

    public void setGlaze(String glaze) {
        this.glaze = glaze;
    }

    public String getMarinade() {
        return marinade;
    }

    public void setMarinade(String marinade) {
        this.marinade = marinade;
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

    public String getSeasoningName() {
        return seasoningName;
    }

    public void setSeasoningName(String seasoningName) {
        this.seasoningName = seasoningName;
    }

    public String getStuffName() {
        return stuffName;
    }

    public void setStuffName(String stuffName) {
        this.stuffName = stuffName;
    }

    public String getSyrupTopping() {
        return syrupTopping;
    }

    public void setSyrupTopping(String syrupTopping) {
        this.syrupTopping = syrupTopping;
    }
}