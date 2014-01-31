/*
 * Created on Feb 7, 2006 by Reid
 */
package com.fsrin.menumine.core.profiler.xwork;

import com.fsrin.menumine.common.AbstractSpringObjectFactory;

public class ProfilerActionFactory extends AbstractSpringObjectFactory {

    public static final String SPRING_BEAN_NAME_PROTEIN_PROFILER_ACTION = "proteinProfilerAction";

    public static final ProfilerActionFactory factory = new ProfilerActionFactory();
    
    public ProfileAction buildProtein() {
        return (ProfileAction) this.build(SPRING_BEAN_NAME_PROTEIN_PROFILER_ACTION);
    }
}
