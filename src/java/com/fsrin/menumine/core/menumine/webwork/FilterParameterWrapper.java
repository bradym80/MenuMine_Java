/*
 * Created on Feb 16, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.webwork;

import java.util.Collection;

import com.fsrin.menumine.common.FilterParameter;

/**
 * @author Nick
 * 
 * 
 */
public class FilterParameterWrapper extends FilterWrapper {

    private FilterParameter filterParameter;

    public FilterParameterWrapper() {
        super();

    }

    public Collection getInValues() {
        return filterParameter.getInValues();
    }

    public FilterParameterWrapper(FilterParameter filterParameter) {
        this.filterParameter = filterParameter;
    }

    public String getAndValues() {
        return returnAsString(filterParameter.getAndValues());
    }

    public void setAndValues(String andString) {

        filterParameter.setAndValues(parseToCollection(andString));
    }

    public String getOrValues() {
        return returnAsString(filterParameter.getOrValues());
    }

    public void setOrValues(String orString) {
        filterParameter.setOrValues(parseToCollection(orString));
    }

    public String getNotValues() {
        return returnAsString(filterParameter.getNotValues());
    }

    public void setNotValues(String notString) {
        Collection nots = parseToCollection(notString);

        filterParameter.setNotValues(nots);
    }

    public Boolean getEmpty() {
        return filterParameter.getEmpty();
    }

    public Boolean getNotEmpty() {
        return new Boolean(!filterParameter.getEmpty().booleanValue());
    }

    public void setEmpty(Boolean empty) {
        this.filterParameter.setEmpty(empty);
    }

    public void setEmpty(boolean empty) {
        this.filterParameter.setEmpty(new Boolean(empty));
    }

    public void setNotEmpty(boolean empty) {
        this.filterParameter.setEmpty(new Boolean(!empty));
    }

    public void setNotEmpty(Boolean empty) {
        if (empty != null) {
            this.filterParameter.setEmpty(new Boolean(!empty.booleanValue()));
        }
    }

    public void setInValues(Collection in) {
        filterParameter.setInValues(in);
    }

    private static String masterFoodFilterParameters = "mp";

    /*
     * Helpers for making the jsps a bit more generic.
     */
    public String getInName() {
        return masterFoodFilterParameters + "."
                + this.filterParameter.getField().getInName();
    }

    public String getAndName() {
        return masterFoodFilterParameters + "."
                + this.filterParameter.getField().getAndName();
    }

    public String getOrName() {
        return masterFoodFilterParameters + "."
                + this.filterParameter.getField().getOrName();
    }

    public String getNotName() {
        return masterFoodFilterParameters + "."
                + this.filterParameter.getField().getNotName();
    }

    public String getEmptyName() {
        return masterFoodFilterParameters + "."
                + this.filterParameter.getField().getEmptyName();

    }

    public String getNotEmptyName() {
        return masterFoodFilterParameters + "."
                + this.filterParameter.getField().getNotEmptyName();
    }

    public String getFriendlyName() {
        return this.filterParameter.getField().getFriendlyName();
    }

    public String getBaseName() {
        return masterFoodFilterParameters + "."
                + this.filterParameter.getField().getOgnlName();
    }

    public FilterParameter getFilterParameter() {
        return filterParameter;
    }

    /*
     * 2006-04-14 Just a simple summary added by Reid
     */
    public String getSimpleSummary() {
        StringBuffer ret = new StringBuffer();

        if (this.getFilterParameter().hasAnds()) {
            ret.append("And: " + this.getAndValues());
        }
        
        ret.append(" ");
        if (this.getFilterParameter().hasIns()) {
            ret.append("In: " + this.getInValues());
        }
        ret.append(" ");
        if (this.getFilterParameter().hasOrs()) {
            ret.append("Or: " + this.getOrValues());
        }
        ret.append(" ");
        if (this.getFilterParameter().hasNots()) {
            ret.append("Not: " + this.getNotValues());
        }
        ret.append(" ");
        String r = ret.toString();
        
        if (r.length() > 60) {
            r = r.substring(0,60) + "...";
        }
        return r;
    }
}