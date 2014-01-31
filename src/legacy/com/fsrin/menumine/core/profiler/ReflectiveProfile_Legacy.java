/*
 * Created on Apr 5, 2005
 *
 * 
 */
package com.fsrin.menumine.core.profiler;

import ognl.Ognl;
import ognl.OgnlException;

import com.fsrin.menumine.core.menumine.FieldEnum;

/**
 * @author Nick This will profile objects using ognl. This will be slow, but
 *         will allow me got get up and running quickly.
 *  
 */
public class ReflectiveProfile_Legacy extends AbstractProfile {

    private String ognlString;

    private FieldEnum fieldEnum;
    
    public FieldEnum getFieldEnum() {
        return fieldEnum;
    }

    public ReflectiveProfile_Legacy() {
        super();
    }

    protected String getValue(Object testObject) {
        try {
            return (String) Ognl.getValue(ognlString, testObject);
        } catch (OgnlException e) {
            return "";
        }
    }

    protected boolean testInstanceOf(Object testObject) {

        try {
            Ognl.getValue(ognlString, testObject);
        } catch (OgnlException e) {
            return false;
        }
        return true;
    }

    public String getOgnlString() {
        return ognlString;
    }

    public void setOgnlString(String ognlString) {
        this.ognlString = ognlString;
    }
}