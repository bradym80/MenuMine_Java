/*
 * Created on Aug 18, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.express;

import java.util.Collection;

/**
 * @author Nick
 * 
 *  
 */
public interface MineRanker {
    public abstract Collection rank(Collection keyCounters);
}