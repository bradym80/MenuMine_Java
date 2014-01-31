/*
 * Created on Jan 24, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.webwork;

import com.fsrin.menumine.core.menumine.FieldsToDisplayBean;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;

/**
 * @author Nick
 * 
 *  
 */
public interface QueryValidator {

    boolean validate(MasterFoodFilterParameters masterFoodFilterParameters,
            FieldsToDisplayBean fieldsToDisplayBean);

}