/*
 * Created on Feb 17, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.webwork;

import com.fsrin.menumine.core.menumine.savedquery.SavedQuery;

/**
 * @author Nick
 * 
 *  
 */
public class QueryHistoryEntry extends SavedQuery {

    //    private String name;
    //
    //    private MasterFoodFilterParametersWrapper parameters;
    //
    //    private FieldsToDisplayBean fieldsToDisplayBean;

    public QueryHistoryEntry() {
        super();

    }

    //    public FieldsToDisplayBean getFieldsToDisplayBean() {
    //        return fieldsToDisplayBean;
    //    }
    //
    //    public void setFieldsToDisplayBean(FieldsToDisplayBean
    // fieldsToDisplayBean) {
    //        this.fieldsToDisplayBean = fieldsToDisplayBean;
    //    }
    //
    //    public MasterFoodFilterParametersWrapper getParameters() {
    //        return parameters;
    //    }
    //
    //    public void setParameters(MasterFoodFilterParametersWrapper parameters) {
    //        this.parameters = parameters;
    //    }
    //
    //    public void setName(String string) {
    //        this.name = string;
    //    }
    //
    //    public String getName() {
    //        return this.name;
    //    }

    public String toString() {
        return this.getName();
    }

}