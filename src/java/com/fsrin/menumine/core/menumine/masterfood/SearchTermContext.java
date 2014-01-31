/*
 * Created on Aug 23, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.masterfood;

import java.util.ArrayList;
import java.util.Collection;

import com.fsrin.menumine.common.FilterParameter;

/**
 * @author Nick
 * 
 *  
 */
public class SearchTermContext {

    private String keyTerm;

    private Collection orTerms = new ArrayList();

    private Collection andTerms = new ArrayList();

    private Collection notTerms = new ArrayList();

    public SearchTermContext(String keyTerm) {
        super();
        this.keyTerm = keyTerm;
    }

    public Collection getNotTerms() {
        return notTerms;
    }

    public Collection getOrTerms() {
        return orTerms;
    }

    public String getKeyTerm() {
        return keyTerm;
    }

    public void applyTpParameter(FilterParameter current) {
        current.getAndValues().remove(this.getKeyTerm());
        current.getOrValues().addAll(this.getOrTerms());
        current.getNotValues().addAll(this.getNotTerms());
        current.getAndValues().addAll(this.getAndTerms());
    }

    public Collection getAndTerms() {
        return andTerms;
    }
}