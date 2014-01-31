/*
 * Created on Apr 5, 2005
 *
 * 
 */
package com.fsrin.menumine.core.profiler;

import com.fsrin.menumine.core.menumine.FieldEnum;

/**
 * @author Nick
 * 
 *  
 */
public class GenericProfile extends AbstractProfile {

    private String key;
    
    private FieldEnum fieldEnum;

    public FieldEnum getFieldEnum() {
        return fieldEnum;
    }

    public void setFieldEnum(FieldEnum fieldEnum) {
        this.fieldEnum = fieldEnum;
    }



    public GenericProfile(String key) {
        this.key = key;
    }

    protected String getValue(Object testObject) {

        return "";
    }

    protected boolean testInstanceOf(Object testObject) {

        return true;
    }

    public String getKey() {
        return key;
    }
}