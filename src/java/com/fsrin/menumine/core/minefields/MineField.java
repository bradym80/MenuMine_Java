/*
 * Created on May 31, 2005
 *
 * 
 */
package com.fsrin.menumine.core.minefields;

import java.util.Collection;

import ognl.Ognl;
import ognl.OgnlException;

import com.fsrin.menumine.core.help.HelpDelegate;
import com.fsrin.menumine.core.menumine.FieldEnum;
import com.fsrin.menumine.core.menumine.webwork.FilterParameterWrapper;

/**
 * @author Nick
 * 
 *  
 */
public class MineField {

    public static int FIELD_PRIORITY_LOW = 1;

    public static int FIELD_PRIORITY_MEDIUM = 2;

    public static int FIELD_PRIORITY_HIGH = 3;

    private int priority = FIELD_PRIORITY_LOW;

    private FieldEnum fieldEnum;

    private MineFields mineFields;

    private String cssClassFieldModifier;

    private String help = "Help";

    public MineField(FieldEnum fieldEnum, MineFields mineFields, int priority) {
        this.fieldEnum = fieldEnum;
        this.mineFields = mineFields;
        this.priority = priority;
    }

    public MineField(FieldEnum fieldEnum, MineFields mineFields, int priority,
            String cssClassFieldModifier) {
        this.fieldEnum = fieldEnum;
        this.mineFields = mineFields;
        this.cssClassFieldModifier = cssClassFieldModifier;
        this.priority = priority;
    }

    /*
     * Helpers to get dynamic data used by the form.
     */
    public Boolean getFieldsToDisplayValue() {
        Boolean value = Boolean.FALSE;
        try {
            value = (Boolean) Ognl.getValue(this.fieldEnum.getShortOgnlName(),
                    this.mineFields.getFieldsToDisplayBean());
        } catch (OgnlException e) {
            e.printStackTrace();

        }
        return value;

    }

    /*
     * 2006-03-29 originally just catches exception -- let's abort early
     * rather than going through the tree.
     */
    public Collection getDistinctQuery() {
        Collection value = null;
        
        if (this.getFieldEnum().getDistinctQuery() == null)
            return null;
        
        try {
            value = (Collection) Ognl.getValue(this.fieldEnum
                    .getDistinctQuery(), mineFields.getDistinctQueryBuilder());
        } catch (OgnlException e) {

            /*
             * Not all fields will have a distinct query.
             */
            value = null;
        }
        return value;

    }

    public FilterParameterWrapper getCurrentMasterFoodFilterParameter() {
        FilterParameterWrapper value = null;
        try {
            value = (FilterParameterWrapper) Ognl.getValue(this.fieldEnum
                    .getOgnlName(), mineFields.getMasterFoodFilterParameters());
        } catch (OgnlException e) {

        }
        return value;

    }

    /*
     * Basic getters and setters.
     */
    public FieldEnum getFieldEnum() {
        return fieldEnum;
    }

    public void setFieldEnum(FieldEnum fieldEnum) {
        this.fieldEnum = fieldEnum;
    }

    public MineFields getMineFields() {
        return mineFields;
    }

    public void setMineFields(MineFields mineFields) {
        this.mineFields = mineFields;
    }

    /*
     * Delegates for the FieldEnum.
     */
    public String getAndName() {
        return fieldEnum.getAndName();
    }

    public String getEmptyName() {
        return fieldEnum.getEmptyName();
    }

    public String getFieldsToDisplayName() {
        return fieldEnum.getFieldsToDisplayName();
    }

    public String getFriendlyName() {
        return fieldEnum.getFriendlyName();
    }

    public String getInName() {
        return fieldEnum.getInName();
    }

    public String getName() {
        return fieldEnum.getName();
    }

    public String getNotEmptyName() {
        return fieldEnum.getNotEmptyName();
    }

    public String getNotName() {
        return fieldEnum.getNotName();
    }

    public String getOgnlName() {
        return fieldEnum.getOgnlName();
    }

    public String getOrName() {
        return fieldEnum.getOrName();
    }

    public String getShortOgnlName() {
        return fieldEnum.getShortOgnlName();
    }

    public void setFriendlyName(String friendlyName) {
        fieldEnum.setFriendlyName(friendlyName);
    }

    public void setName(String name) {
        fieldEnum.setName(name);
    }

    public void setOgnlName(String ognlName) {
        fieldEnum.setOgnlName(ognlName);
    }

    public String getCssClassFieldModifier() {
        return cssClassFieldModifier;
    }

    public void setCssClassFieldModifier(String cssClassFieldModifier) {
        this.cssClassFieldModifier = cssClassFieldModifier;
    }

    public String getHelp() {
        help = HelpDelegate.singleton.getMineFieldHelp(this);
        return this.getFriendlyName() + ": " + help;
    }

    public void setHelp(String help) {
        this.help = help;
    }

    public int getPriority() {
        return priority;
    }
}