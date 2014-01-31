/*
 * Created on Apr 20, 2006 by Reid
 */
package com.fsrin.menumine.core.profiler.aggregation;

import java.util.ArrayList;
import java.util.Collection;

import com.fsrin.menumine.core.menumine.FieldEnum;

public class ProfileFieldListProviderVeggieImpl implements ProfileFieldListProvider {

    public Collection getFields() {
        
        Collection ret = new ArrayList();
        
        ret.add(FieldEnum.GREEN_VEG_NAME);
        ret.add(FieldEnum.DESCRIPTION);
        ret.add(FieldEnum.MENU_ITEM_NAME);
        ret.add(FieldEnum.OTHER_ACCOMPANIMENTS);
        ret.add(FieldEnum.OTHER_INGREDIENT);
        ret.add(FieldEnum.OTHER_TOPPINGS);
        ret.add(FieldEnum.STUFF_NAME);
        ret.add(FieldEnum.VEG_ACCOMP_NAME);
        ret.add(FieldEnum.VEGGIE_FRUIT_TYPE);
        ret.add(FieldEnum.VEG_TOP_NAME);
        
        
        return ret;
        
    }

}
