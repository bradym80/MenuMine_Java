/*
 * Created on Jan 24, 2006
 *
 */
package com.fsrin.menumine.core.menumine.express;

import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;

public abstract class AbstractParameterDecorator {

    private MasterFoodFilterParameters targetParameters;

    /**
     * @return Returns the targetParams.
     */
    public MasterFoodFilterParameters getTargetParameters() {
        return targetParameters;
    }

    /**
     * @param targetParams
     *            The targetParams to set.
     */
    public void setTargetParameters(MasterFoodFilterParameters targetParams) {
        this.targetParameters = targetParams;
    }
}
