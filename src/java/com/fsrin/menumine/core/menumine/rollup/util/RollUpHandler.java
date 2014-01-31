/*
 * Created on May 2, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.rollup.util;

/**
 * 2006-02-03 RSC Refactored from generic Object[] and Object to what it's
 * actually using -- Strings.
 * 
 * @author Nick
 * 
 *  
 */
public interface RollUpHandler {

    public String getRollUpKey(String key);

}