/*
 * Created on Jan 24, 2006
 *
 */
package com.fsrin.menumine.core.menumine.express;

import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;

/**
 * 2006-01-24 Taking the place of the Express Query Builder.  Basically all we need
 * to do is decorate a parameters object with an express query.
 * 
 * @author Reid
 *
 */
public interface ParameterDecorator {

    public void setTargetParameters(MasterFoodFilterParameters params);
    
    public void decorate(Object expressQuery);
    
}
