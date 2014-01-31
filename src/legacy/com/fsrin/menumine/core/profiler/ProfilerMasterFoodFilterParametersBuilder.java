/*
 * Created on Apr 20, 2006 by Reid
 */
package com.fsrin.menumine.core.profiler;

import java.util.Collection;
import java.util.Iterator;

import ognl.Ognl;

import com.fsrin.menumine.common.FilterParameter;
import com.fsrin.menumine.core.menumine.FieldEnum;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParametersImpl;
import com.fsrin.menumine.core.menumine.express.util.SearchableTokenBuilder;

public class ProfilerMasterFoodFilterParametersBuilder {

    public MasterFoodFilterParameters build(Collection searchableTokens,
            Collection targetFields) throws Exception {


        MasterFoodFilterParametersImpl ret = new MasterFoodFilterParametersImpl();

        for (Iterator iter = targetFields.iterator(); iter.hasNext();) {
            FieldEnum element = (FieldEnum) iter.next();

            FilterParameter p = (FilterParameter) Ognl.getValue(element.getOgnlName(), ret);
            
            p.setSelect(true);
            
            p.getAndValues().addAll(searchableTokens);
        }
        
        return ret;

    }
}
