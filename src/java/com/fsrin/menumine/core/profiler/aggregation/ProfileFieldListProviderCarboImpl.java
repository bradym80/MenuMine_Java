/*
 * Created on Apr 20, 2006 by Reid
 */
package com.fsrin.menumine.core.profiler.aggregation;

import java.util.ArrayList;
import java.util.Collection;

import com.fsrin.menumine.core.menumine.FieldEnum;

public class ProfileFieldListProviderCarboImpl implements ProfileFieldListProvider {

    public Collection getFields() {
        
        Collection ret = new ArrayList();
        
        ret.add(FieldEnum.CARBO_ACCOMP_NAME);
        ret.add(FieldEnum.CARBO_TOP_NAME);
        ret.add(FieldEnum.CARBO_TYPE);
        ret.add(FieldEnum.DESCRIPTION);
        ret.add(FieldEnum.MENU_ITEM_NAME);
        ret.add(FieldEnum.OTHER_ACCOMPANIMENTS);
        ret.add(FieldEnum.OTHER_INGREDIENT);
        ret.add(FieldEnum.OTHER_TOPPINGS);
        ret.add(FieldEnum.STUFF_NAME);      
        
        return ret;
        
    }

}
