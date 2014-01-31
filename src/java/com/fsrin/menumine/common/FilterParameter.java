/*
 * Created on Feb 16, 2005
 *
 * 
 */
package com.fsrin.menumine.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.fsrin.menumine.core.menumine.FieldEnum;

/**
 * @author Nick
 * 
 *  
 */

public class FilterParameter implements Serializable, FilterParameterStringInterface, Cloneable {

    private Long id;



    private FieldEnum field;

    private Collection<String> and = new ArrayList<String>();

    private Collection<String> or = new ArrayList<String>();

    private Collection<String> not = new ArrayList<String>();

    private Collection<String> in = new ArrayList<String>();
    
    private boolean select = false;

    private Boolean empty = null;

    
        public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public FilterParameter(FieldEnum field) {
        this.field = field;
    }

    public FilterParameter() {
        super();

    }

    public boolean isFilterEmpty() {

        if (and.size() == 0 && or.size() == 0 && not.size() == 0
                && in.size() == 0 && empty == null) {
            return true;
        }
        return false;
    }

    public Boolean getEmpty() {
        return empty;
    }

    public void setEmpty(Boolean empty) {
        this.empty = empty;
    }

    public Collection<String> getAndValues() {
        return and;
    }

    public Collection<String> getInValues() {
        return in;
    }

    public Collection<String> getNotValues() {
        return not;
    }

    public Collection<String> getOrValues() {
        return or;
    }

    public void setAndValues(Collection<String> and) {
        this.and = and;
    }

    public void setInValues(Collection<String> in) {
        this.in = in;
    }

    public void setNotValues(Collection<String> not) {
        if (not.contains("'Not On Menu'")) {
            this.setEmpty(Boolean.FALSE);
            not.remove("'Not On Menu'");
        }

        this.not = not;
    }

    public void setOrValues(Collection<String> or) {
        this.or = or;
    }

    public String getFieldName() {
        if (this.field == null) {
            return "";
        }
        return this.field.getShortOgnlName();
    }

    public FieldEnum getField() {

        return this.field;
    }

    public void setFieldName(String fieldName) {
        this.field = FieldEnum.getByName(fieldName);
    }

    public boolean hasAnds() {
        return this.and != null && this.and.size() > 0;
    }
    
    public boolean hasOrs() {
        return this.or != null && this.or.size() > 0;
    }
    
    public boolean hasNots() {
        return this.not != null && this.not.size() > 0;
    }
    
    public boolean hasIns() {
        return this.in != null && this.in.size() > 0;
    }

    /**
     * @return Returns the select.
     */
    public boolean isSelect() {
        return select;
    }

    /**
     * @param select The select to set.
     */
    public void setSelect(boolean select) {
        this.select = select;
    }
    
    /*
     * object for use with OGNL/Reflections
     */
    public void setSelect(Boolean bool) {
        if (bool != null)
            this.setSelect(bool.booleanValue());
    }
    
    /*
     * 2006-03-16 RSC actually clonges without the surrogate id. 
     * 
     * (non-Javadoc)
     * @see java.lang.Object#clone()
     */
    public FilterParameter clone() {
        FilterParameter ret = new FilterParameter();
        
        for (Iterator<String> iter = this.getAndValues().iterator(); iter.hasNext();) {
            String element =  iter.next();
            ret.getAndValues().add(element);
        }
        for (Iterator<String> iter = this.getOrValues().iterator(); iter.hasNext();) {
            String element = iter.next();
            ret.getOrValues().add(element);
        }
        for (Iterator<String> iter = this.getInValues().iterator(); iter.hasNext();) {
            String element =  iter.next();
            ret.getInValues().add(element);
        }
        for (Iterator<String> iter = this.getNotValues().iterator(); iter.hasNext();) {
            String element = iter.next();
            ret.getNotValues().add(element);
        }
        ret.setEmpty(this.getEmpty());
        
        ret.setFieldName(this.getFieldName());
        
        ret.setSelect(this.isSelect());
        
        return ret;
        
        
    }

}