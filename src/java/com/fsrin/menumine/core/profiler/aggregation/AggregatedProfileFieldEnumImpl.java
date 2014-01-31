/*
 * Created on Apr 20, 2006 by Reid
 */
package com.fsrin.menumine.core.profiler.aggregation;

import com.fsrin.menumine.core.menumine.FieldEnum;

public class AggregatedProfileFieldEnumImpl extends AbstractAggregatedProfile {

    private FieldEnum fieldEnum;

    public void setFieldEnum(FieldEnum fieldEnum) {
        this.fieldEnum = fieldEnum;
    }

    public FieldEnum getFieldEnum() {

        return fieldEnum;
    }

    public String getName() {

        return this.getFieldEnum().getFriendlyName();
    }

}
