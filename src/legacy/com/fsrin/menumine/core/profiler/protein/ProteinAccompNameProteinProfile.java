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
public class ProteinAccompNameProteinProfile extends AbstractProteinProfile {

    private FieldEnum fieldEnum = FieldEnum.PROTEIN_ACCOMP_NAME;
    
    public FieldEnum getFieldEnum() {
        return fieldEnum;
    }

    public ProteinAccompNameProteinProfile() {
        super();
    }

    protected String getValue(Object testObject) {

        return ((ProteinProfileBean) testObject).getProteinAccompName();

    }

}