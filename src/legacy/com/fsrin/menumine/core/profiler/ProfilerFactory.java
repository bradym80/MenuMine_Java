/*
 * Created on Apr 20, 2006 by Reid
 */
package com.fsrin.menumine.core.profiler;

import com.fsrin.menumine.common.AbstractSpringObjectFactory;

/*
 * 2006-04-20 RSC Useful primarily for testing.
 */
public class ProfilerFactory extends AbstractSpringObjectFactory {

    public static final ProfilerFactory factory = new ProfilerFactory();
    
    public static final String SPRING_BEAN_NAME_FLAVOR_PROFILER = "flavorProfiler";
    
    public Profiler buildFlavorProfiler() {
        return (Profiler) this.build(SPRING_BEAN_NAME_FLAVOR_PROFILER);
    }
    
}
