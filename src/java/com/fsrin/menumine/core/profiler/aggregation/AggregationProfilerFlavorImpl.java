/*
 * Created on Apr 20, 2006 by Reid
 */
package com.fsrin.menumine.core.profiler.aggregation;

import java.util.Collection;

public class AggregationProfilerFlavorImpl {

    public Collection getApplications(String searchString) throws Exception {

        return new AggregatedProfileBuilder().buildApplications(
                new ProfileFieldListProviderFlavorImpl(),
                searchString);

    }

}
