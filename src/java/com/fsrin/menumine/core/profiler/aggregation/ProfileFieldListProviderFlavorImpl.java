/*
 * Created on Apr 20, 2006 by Reid
 */
package com.fsrin.menumine.core.profiler.aggregation;

import java.util.ArrayList;
import java.util.Collection;

import com.fsrin.menumine.core.menumine.FieldEnum;

public class ProfileFieldListProviderFlavorImpl implements ProfileFieldListProvider {

    public Collection getFields() {
        
        Collection ret = new ArrayList();
        
        ret.add(FieldEnum.BATTER_BREADING_COATING);
        ret.add(FieldEnum.BREAD_WRAPS_CHIPS);
        ret.add(FieldEnum.CHEESE);
        ret.add(FieldEnum.CONDIMENTS);
        ret.add(FieldEnum.COOKING_SAUCE_OR_GRAVY);
        ret.add(FieldEnum.DIP_SAUCE_NAME);
        ret.add(FieldEnum.DRESSINGS);
        ret.add(FieldEnum.GLAZE);
        ret.add(FieldEnum.DESCRIPTION);
        ret.add(FieldEnum.MARINADE);
        ret.add(FieldEnum.MENU_ITEM_NAME);
        ret.add(FieldEnum.OTHER_INGREDIENT);
        ret.add(FieldEnum.OTHER_TOPPINGS);
        ret.add(FieldEnum.SEASONING_NAME);
        ret.add(FieldEnum.STUFF_NAME);
        ret.add(FieldEnum.SYRUP_TOPPING);
        
        
        return ret;
        
    }

}
