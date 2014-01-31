/*
 * Created on Apr 5, 2005
 *
 * 
 */
package com.fsrin.menumine.core.profiler.protein;

import com.fsrin.menumine.core.menumine.FieldEnum;

/**
 * @author Nick
 * 
 *  
 */
public class ItemDescriptionProteinProfile extends AbstractProteinProfile {

    private FieldEnum fieldEnum = FieldEnum.DESCRIPTION;
    
    public FieldEnum getFieldEnum() {
        return fieldEnum;
    }

    public ItemDescriptionProteinProfile() {
        super();
    }

    protected String getValue(Object testObject) {

        return ((ProteinProfileBean) testObject).getItemDescription();

    }

}