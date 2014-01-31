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
public class ProteinTypeCutProteinProfile extends AbstractProteinProfile {

    private FieldEnum fieldEnum = FieldEnum.PROTEIN_TYPE_CUT;

    public FieldEnum getFieldEnum() {
        return fieldEnum;
    }

    protected String getValue(Object testObject) {

        return ((ProteinProfileBean) testObject).getProteinTypeCut();

    }

}