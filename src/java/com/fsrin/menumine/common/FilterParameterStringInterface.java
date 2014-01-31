/*
 * Created on Jun 16, 2005
 *
 * 
 */
package com.fsrin.menumine.common;

import java.util.Collection;

import com.fsrin.menumine.core.menumine.FieldEnum;

/**
 * @author Nick
 * 
 *  
 */
public interface FilterParameterStringInterface extends FilterParameterInterface{
    public abstract Long getId();

    public abstract void setId(Long id);

    public abstract boolean isFilterEmpty();

    public abstract Boolean getEmpty();

    public abstract void setEmpty(Boolean empty);

    public abstract Collection<String> getAndValues();

    public abstract Collection<String> getInValues();

    public abstract Collection<String> getNotValues();

    public abstract Collection<String> getOrValues();

    public abstract void setAndValues(Collection<String> and);

    public abstract void setInValues(Collection<String> in);

    public abstract void setNotValues(Collection<String> not);

    public abstract void setOrValues(Collection<String> or);

    public abstract String getFieldName();

    public abstract FieldEnum getField();

    public abstract void setFieldName(String fieldName);
}