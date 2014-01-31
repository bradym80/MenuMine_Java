/*
 * Created on Apr 5, 2005
 *
 * 
 */
package com.fsrin.menumine.core.profiler.veggie;

import com.fsrin.menumine.core.menumine.FieldEnum;

/**
 * @author Nick
 * 
 *  
 */
public class StuffNameVeggieProfile extends AbstractVeggieProfile {

    private FieldEnum fieldEnum = FieldEnum.STUFF_NAME;

    protected String getValue(Object testObject) {

        return ((VeggieProfileBean) testObject).getStuffName();

    }

    public FieldEnum getFieldEnum() {
        return fieldEnum;
    }

}