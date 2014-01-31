/*
 * Created on Apr 5, 2005
 *
 * 
 */
package com.fsrin.menumine.core.profiler.veggie;

import com.fsrin.menumine.core.profiler.AbstractProfile;

/**
 * @author Nick
 * 
 *  
 */
public abstract class AbstractVeggieProfile extends AbstractProfile {

    protected boolean testInstanceOf(Object testObject) {
        return testObject instanceof VeggieProfileBean;
    }

}