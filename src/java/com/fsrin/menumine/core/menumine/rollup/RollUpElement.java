/*
 * Created on May 11, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.rollup;

/**
 * @author Nick
 * 
 *  
 */
public class RollUpElement {

    private Long id;

    private String term;

    private String label;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}