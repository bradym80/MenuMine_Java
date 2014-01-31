/*
 * Created on Feb 3, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.rollup;

import java.util.ArrayList;

import com.fsrin.menumine.core.menumine.FieldEnum;

public class RollUpOptionsTestFactory {

    private static int count;
    
    public static RollUpOptions buildTestAmericanRollUpOthers() {
        
        count++;
        
        RollUpOptions options = new RollUpOptions();
        
        options.setGroupName("group"+count);
        options.setId(new Long(count));
        options.setOtherItemRollUpType(RollUpOptions.OTHER_ITEM_ROLL_UP_TYPE_ROLL_UP_OTHERS);
        options.setPermission(RollUpOptions.USER_QUERY_PERMISSION.intValue());
        options.setRollUpElements(new ArrayList());
        /*
         * 2006-02-03 rsc how important is field name when we're using the aggregation?
         * 
         */ 
        options.setTargetFieldName(FieldEnum.CUISINE_FAMILY.getOgnlName());
        options.setUserName("mbrady");
        
        
        RollUpElement element1 = new RollUpElement();
        element1.setLabel("American");
        element1.setTerm("American-Traditional Cuisine");
        options.getRollUpElements().add(element1);
        
        RollUpElement element2 = new RollUpElement();
        element2.setLabel("American");
        element2.setTerm("American-Regional Cuisine");
        options.getRollUpElements().add(element2);
        
        return options;
    }
}
