/*
 * Created on May 11, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.rollup.util;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Nick
 * 
 *  
 */
public class RollUpParameters {

    private String rollUpLabel;

    private Collection rows = new ArrayList();

    private String[] terms;


    public RollUpParameters(int numberOfRows) {
        super();
        for (int i = 0; i < numberOfRows; i++) {
            RollUpRow row = new RollUpRow();
            rows.add(row);
        }
    }

    public String getRollUpLabel() {
        return rollUpLabel;
    }

    public void setRollUpLabel(String rollUpLabel) {
        this.rollUpLabel = rollUpLabel;
    }

    public Collection getRows() {
        return rows;
    }

    public void setRows(Collection rows) {
        this.rows = rows;
    }

    public void setTerm(String s)
    {
     terms = new String[1]; 
     terms[0]= s;
    }
    
    public String[] getTerms() {
        return terms;
    }

    public void setTerms(String[] terms) {
        this.terms = terms;
    }
}