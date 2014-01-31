/*
 * Created on Apr 5, 2005
 *
 * 
 */
package com.fsrin.menumine.core.profiler.carbo;

import com.fsrin.menumine.core.profiler.AbstractProfile;

/**
 * @author Nick
 * 
 *  
 */
public abstract class AbstractCarboProfile extends AbstractProfile {

    protected boolean testInstanceOf(Object testObject) {
        return testObject instanceof CarboProfileBean;
    }

}