/*
 * Created on Sep 14, 2006 by Reid
 */
package com.fsrin.menumine.core.incidence.trend;

import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParametersTestFactory;
import com.fsrin.menumine.testutil.AbstractNonInitializingMenuMineTestCase;

public class IncidenceTableTrendBuilderTest extends
        AbstractNonInitializingMenuMineTestCase {

    public void testBasic() throws Exception {

        MasterFoodFilterParameters p = MasterFoodFilterParametersTestFactory
                .getItemDescriptionWithBacon();

        IncidenceTableTrendBuilder builder = new IncidenceTableTrendBuilder();

        IncidenceTableTrend incidenceTableTrend = builder.build(p);

        assertNotNull(incidenceTableTrend);

    }

}
