/*
 * Created on Apr 5, 2005
 *
 * 
 */
package com.fsrin.menumine.core.profiler.market;

import com.fsrin.menumine.core.profiler.AbstractProfile;

/**
 * @author Nick
 * 
 *  
 */
public abstract class AbstractMarketProfile extends AbstractProfile {

    protected boolean testInstanceOf(Object testObject) {
        return testObject instanceof MarketProfileBean;
    }

}