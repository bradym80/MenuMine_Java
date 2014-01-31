/*
 * Created on Aug 14, 2006 by Reid
 */
package com.fsrin.menumine.core.flavortrak.xwork;

import org.springframework.util.StringUtils;

import com.opensymphony.xwork.Action;

public class UpdateFlavorTrakContextAction extends
        AbstractFlavorTrakContextAwareJSONAction {

    private String queryString;

    private String cuisineFamily;

    private String genMenuPart;

    private String genCookingMethod;

    public String execute() throws Exception {

        if (StringUtils.hasText(this.getQueryString())) {
            if (this.getQueryString().equals("[none]")) {
                this.getFlavorTrakContext().setQuery(null);
            } else {
                this.getFlavorTrakContext().setQuery(this.getQueryString());
            }
        }

        if (StringUtils.hasText(this.getCuisineFamily())) {
            if (this.getCuisineFamily().equals("[none]")) {
                this.getFlavorTrakContext().setCuisineFamily(null);
            } else {
                this.getFlavorTrakContext().setCuisineFamily(
                        this.getCuisineFamily());
            }
        }

        if (StringUtils.hasText(this.getGenMenuPart())) {
            if (this.getGenMenuPart().equals("[none]")) {
                this.getFlavorTrakContext().setGenMenuPart(null);
            } else {
                this.getFlavorTrakContext().setGenMenuPart(
                        this.getGenMenuPart());
            }
        }

        if (StringUtils.hasText(this.getGenCookingMethod())) {
            if (this.getGenCookingMethod().equals("[none]")) {
                this.getFlavorTrakContext().setGenCookingMethod(null);
            } else {
                this.getFlavorTrakContext().setGenCookingMethod(
                        this.getGenCookingMethod());
            }
        }

        return Action.SUCCESS;
    }

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

    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

}
