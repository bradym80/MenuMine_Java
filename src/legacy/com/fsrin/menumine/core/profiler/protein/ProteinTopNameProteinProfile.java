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
public class ProteinTopNameProteinProfile extends AbstractProteinProfile {

    private FieldEnum fieldEnum = FieldEnum.PROTEIN_TOP_NAME;
    

    public FieldEnum getFieldEnum() {
        return fieldEnum;
    }


    protected String getValue(Object testObject) {

        return ((ProteinProfileBean) testObject).getProteinTopName();

    }

}