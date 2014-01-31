/*
 * Created on Apr 20, 2006 by Reid
 */
package com.fsrin.menumine.core.profiler.aggregation;

import java.util.ArrayList;
import java.util.Collection;

import com.fsrin.menumine.core.menumine.FieldEnum;

public class ProfileFieldListProviderMarketImpl implements ProfileFieldListProvider {

    public Collection getFields() {
        
        Collection ret = new ArrayList();
        
        ret.add(FieldEnum.DESCRIPTION);
        ret.add(FieldEnum.MENU_ITEM_NAME);

        
        
        return ret;
        
    }

}
