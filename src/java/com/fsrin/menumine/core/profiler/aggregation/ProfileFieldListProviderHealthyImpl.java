/*
 * Created on Apr 20, 2006 by Reid
 */
package com.fsrin.menumine.core.profiler.aggregation;

import java.util.ArrayList;
import java.util.Collection;

import com.fsrin.menumine.core.menumine.FieldEnum;

public class ProfileFieldListProviderHealthyImpl implements ProfileFieldListProvider {

    public Collection getFields() {
        
        Collection ret = new ArrayList();
        
        ret.add(FieldEnum.HEALTHY_FLAG);
        ret.add(FieldEnum.HEALTHY_SYMBOL);
        ret.add(FieldEnum.HEALTHY_TERM);
        ret.add(FieldEnum.DESCRIPTION);
        ret.add(FieldEnum.MENU_ITEM_NAME);

        
        
        return ret;
        
    }

}
