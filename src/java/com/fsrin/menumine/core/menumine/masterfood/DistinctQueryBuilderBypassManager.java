/*
 * Created on Jan 22, 2006
 *
 */
package com.fsrin.menumine.core.menumine.masterfood;

public class DistinctQueryBuilderBypassManager {

    private static boolean bypass;

    /**
     * @return Returns the bypass.
     */
    public static boolean isBypass() {
        return bypass;
    }

    /**
     * @param bypass The bypass to set.
     */
    public static void setBypass(boolean bypass) {
        DistinctQueryBuilderBypassManager.bypass = bypass;
    }
    
}
