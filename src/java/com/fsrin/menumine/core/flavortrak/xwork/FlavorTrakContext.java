/*
 * Created on Aug 14, 2006 by Reid
 */
package com.fsrin.menumine.core.flavortrak.xwork;

public class FlavorTrakContext {

    private String query;
    
    private String cuisineFamily;
    
    private String genMenuPart;
    
    private String genCookingMethod;

    public String getCuisineFamily() {
        return cuisineFamily;
    }

    public void setCuisineFamily(String cuisineFamily) {
        this.cuisineFamily = cuisineFamily;
    }

    public String getGenCookingMethod() {
        return genCookingMethod;
    }

    public void setGenCookingMethod(String genCookingMethod) {
        this.genCookingMethod = genCookingMethod;
    }

    public String getGenMenuPart() {
        return genMenuPart;
    }

    public void setGenMenuPart(String genMenuPart) {
        this.genMenuPart = genMenuPart;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
