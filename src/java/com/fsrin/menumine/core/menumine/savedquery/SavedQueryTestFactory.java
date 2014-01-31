/*
 * Created on Mar 8, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.savedquery;

import java.util.Date;

import com.fsrin.menumine.core.menumine.FieldsToDisplayBeanBuilder;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParametersTestFactory;
import com.fsrin.menumine.core.minefields.MineFieldsFactory;

public class SavedQueryTestFactory {

    private static int count = 0;
    
    public static SavedQuery getBasicUnpersisted() {
        MasterFoodFilterParameters p = MasterFoodFilterParametersTestFactory.getItemDescriptionWithBacon();
        
        return getBasicUnpersisted(p);
    }
    public static SavedQuery getBasicUnpersisted(MasterFoodFilterParameters p) {
         
        count++;
        
        SavedQuery s = new SavedQuery();
        
        s.setMasterFoodFilterParameters(p);
        
        s.setFieldsToDisplayBean(new FieldsToDisplayBeanBuilder().build(p));
        
        s.setGroupName("TestGroup");
        
        s.setMineType(MineFieldsFactory.MINE_TYPE_MENU);
        
        s.setName("testName" + count + "-" + new Date().getTime());
        
        s.setPermission(SavedQuery.GROUP_QUERY_PERMISSION.intValue());
        
        s.setSimple(true);
        
        s.setUserName("mbrady");
        
        return s;
        
    }
}
