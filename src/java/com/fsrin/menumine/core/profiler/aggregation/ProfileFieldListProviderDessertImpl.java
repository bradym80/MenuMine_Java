/*
 * Created on Apr 20, 2006 by Reid
 */
package com.fsrin.menumine.core.profiler.aggregation;

import java.util.ArrayList;
import java.util.Collection;

import com.fsrin.menumine.core.menumine.FieldEnum;

public class ProfileFieldListProviderDessertImpl implements ProfileFieldListProvider {

    public Collection getFields() {
        
        Collection ret = new ArrayList();
        
        ret.add(FieldEnum.CAKE_INGREDIENT);
        ret.add(FieldEnum.CANDY_INGREDIENT);
        ret.add(FieldEnum.COOKIE_INGREDIENT);
        ret.add(FieldEnum.FRUIT_OR_FRUIT_FILLING_INGRED);
        ret.add(FieldEnum.ICE_CREAM_INGREDIENT);
        ret.add(FieldEnum.DESCRIPTION);
        ret.add(FieldEnum.MENU_ITEM_NAME);
        ret.add(FieldEnum.NUT_INGREDIENT);
        ret.add(FieldEnum.OTHER_TOP_INGREDIENT);
        ret.add(FieldEnum.WHIPPED_TOPPING_INGRED);
        
        
        return ret;
        
    }

}
