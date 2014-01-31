/*
 * Created on Apr 20, 2006 by Reid
 */
package com.fsrin.menumine.core.profiler.aggregation;

import java.util.ArrayList;
import java.util.Collection;

import com.fsrin.menumine.core.menumine.FieldEnum;

public class ProfileFieldEnumCollections {

    public Collection<FieldEnum> buildFlavorFields() {
        
        Collection<FieldEnum> ret = new ArrayList<FieldEnum>();
        
        ret.add(FieldEnum.SAUCE_OR_CONDIMENT);
        ret.add(FieldEnum.SEASONING_NAME);
        
        return ret;
        
    }
}
