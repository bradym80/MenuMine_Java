/*
 * Created on Apr 20, 2006 by Reid
 */
package com.fsrin.menumine.core.profiler.aggregation;

import java.util.ArrayList;
import java.util.Collection;

import com.fsrin.menumine.core.menumine.FieldEnum;

public class ProfileFieldListProviderProteinImpl implements ProfileFieldListProvider {

    public Collection getFields() {
        
        Collection ret = new ArrayList();
        
        ret.add(FieldEnum.DESCRIPTION);
        ret.add(FieldEnum.MENU_ITEM_NAME);
        ret.add(FieldEnum.PROTEIN_ACCOMP_NAME);
        ret.add(FieldEnum.PROTEIN_TOP_NAME);
        ret.add(FieldEnum.PROTEIN_TYPE_CUT);
        ret.add(FieldEnum.STUFF_NAME);
        ret.add(FieldEnum.PROTEIN_FISH_SHRIMP_SEAFOOD);
        
        
        return ret;
        
    }

}
