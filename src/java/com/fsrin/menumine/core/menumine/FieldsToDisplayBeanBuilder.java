/*
 * Created on Jan 23, 2006
 *
 */
package com.fsrin.menumine.core.menumine;

import java.util.Collection;
import java.util.Iterator;

import ognl.Ognl;
import ognl.OgnlException;

import com.fsrin.menumine.common.FilterParameter;
import com.fsrin.menumine.core.menumine.util.SelectedFieldListBuilder;

/**
 * Uses OGNL to set the selected fields as the ones we're displaying.
 * 
 * @author Reid
 * 
 */
public class FieldsToDisplayBeanBuilder {

    public FieldsToDisplayBean build(MasterFoodFilterParameters params) {

        Collection fields = new SelectedFieldListBuilder()
                .getOgnlNameSet(params);

        FieldsToDisplayBean ret = new FieldsToDisplayBean();

        for (Iterator iter = fields.iterator(); iter.hasNext();) {
            String element = (String) iter.next();

            // log.info("element is " + element + ", object[i] is " +
            // object[i]);
            try {
                Ognl.setValue(element, ret, Boolean.TRUE);
            } catch (OgnlException e) {
                throw new RuntimeException("how did this get mixed up");
            }

        }

        return ret;
        
    }
    
    public void decorateParams(FieldsToDisplayBean fieldsToDisplayBean,
            MasterFoodFilterParameters params) {
        
        Collection fields = params.getAll();
        
        try {
        for (Iterator iter = fields.iterator(); iter.hasNext();) {
            FilterParameter element = (FilterParameter) iter.next();
            
            Boolean display = (Boolean) Ognl.getValue(element.getField().getOgnlName(), fieldsToDisplayBean);
            
            Ognl.setValue(element.getField().getOgnlName()+".select", params, display);
            
            
        }
        
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("failed to synch params with fields to DisplayBean.");
        }
    }

}
