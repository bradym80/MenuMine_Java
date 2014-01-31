/*
 * Created on Jan 23, 2006
 *
 */
package com.fsrin.menumine.core.menumine.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.fsrin.menumine.common.FilterParameter;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;

public class SelectedFieldListBuilder {
    /*
     * get us a small collection of the fields we care about
     * 
     * default visibility primarily for testing.
     */
    public Collection getOgnlNameSet(MasterFoodFilterParameters params) {
        
        Collection ret = new ArrayList();
        
        for (Iterator iter = params.getAll().iterator(); iter.hasNext();) {
            FilterParameter element = (FilterParameter) iter.next();
            
            if (element.isSelect()) {
                if (!ret.contains(element.getField().getOgnlName())) {
                    ret.add(element.getField().getOgnlName());
                }
            }
        }
        
        return ret;
    }
}
