/*
 * Created on Feb 3, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.rollup.util;

import com.fsrin.menumine.core.menumine.rollup.RollUpOptions;

public class RollUpHandlerFactory {

    public static final RollUpHandler getRollUpHandler(RollUpOptions options) {
        
        return new RollUpMatchAllHandler(options);
        
    }
}
