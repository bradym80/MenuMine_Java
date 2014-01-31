/*
 * Created on Sep 19, 2005
 *
 * 
 */
package com.fsrin.menumine.common;

import com.fsrin.menumine.core.menumine.FieldEnum;

/**
 * @author Nick
 * 
 * 
 */
public interface FilterParameterInterface {
    public abstract Long getId();

    public abstract void setId(Long id);

    public abstract boolean isFilterEmpty();

    public abstract String getFieldName();

    public abstract FieldEnum getField();

    public abstract void setFieldName(String fieldName);

}