/*
 * Created on Apr 5, 2005
 *
 * 
 */
package com.fsrin.menumine.core.profiler.protein;

import com.fsrin.menumine.core.profiler.AbstractProfile;

/**
 * @author Nick
 * 
 *  
 */
public abstract class AbstractProteinProfile extends AbstractProfile {

    protected boolean testInstanceOf(Object testObject) {
        return testObject instanceof ProteinProfileBean;
    }

}