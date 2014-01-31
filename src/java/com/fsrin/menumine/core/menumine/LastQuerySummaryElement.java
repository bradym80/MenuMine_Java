/*
 * Created on Feb 1, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine;

import java.util.Collection;
import java.util.Iterator;

/**
 * @author Nick
 * 
 *  
 */
public class LastQuerySummaryElement {

    private FieldEnum field;

    private Collection selection;

    private Collection typeIn;

    private Collection orValues;

    private Collection notValues;

    private Boolean empty;

    public Collection getSelection() {
        return selection;
    }

    public void setSelection(Collection selection) {
        this.selection = selection;
    }

    public Collection getTypeIn() {
        return typeIn;
    }

    public void setTypeIn(Collection typeIn) {
        this.typeIn = typeIn;
    }

    public FieldEnum getField() {
        return field;
    }

    public void setField(FieldEnum field) {
        this.field = field;
    }

    public String getTypeInString() {
        if (this.getTypeIn() != null && this.getTypeIn().size() > 0) {
            return this.buildFriendlyStringFromCollection(this.getTypeIn());
        } else {
            return "N/A";
        }
    }

    public String getSelectionString() {
        if (this.getSelection() != null && this.getSelection().size() > 0) {
            return this.buildFriendlyStringFromCollection(this.getSelection());
        } else {
            return "N/A";
        }
    }

    private String buildFriendlyStringFromCollection(Collection collection) {
        StringBuffer buffer = new StringBuffer();
        for (Iterator iter = collection.iterator(); iter.hasNext();) {
            String element = (String) iter.next();
            if (buffer.length() > 0) {
                buffer.append(", <br>");
            }
            buffer.append(element);

        }

        return buffer.toString();
    }

    public Collection getNotValues() {
        return notValues;
    }

    public void setNotValues(Collection notValues) {
        this.notValues = notValues;
    }

    public Collection getOrValues() {
        return orValues;
    }

    public void setOrValues(Collection orValues) {
        this.orValues = orValues;
    }

    public void setEmpty(Boolean empty) {
        this.empty = empty;
    }

    public Boolean getEmpty() {
        return empty;
    }
}