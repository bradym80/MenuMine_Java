/*
 * Created on Apr 5, 2005
 *
 * 
 */
package com.fsrin.menumine.core.profiler.test;

import java.util.ArrayList;
import java.util.Collection;

import com.fsrin.menumine.core.menumine.chain.Chain;
import com.fsrin.menumine.core.menumine.masterfood.MasterFood;
import com.fsrin.menumine.core.profiler.ProfileDao;
import com.fsrin.menumine.core.profiler.ProfileParameters;

/**
 * @author Nick
 * 
 *  
 */
public class MockMasterFood50GarlicDaoWithNullSegment extends ProfileDao {

    private Collection data = new ArrayList();

    public MockMasterFood50GarlicDaoWithNullSegment() {
        super();
        this.initData();
    }

    private void initData() {

        Chain[] chains = new Chain[5];
        Chain chain0 = new Chain();
        chain0.setOperationName("Chain0");
        chain0.setSegment("Segment");
        chain0.setSectorName("Sector");
        chains[0] = chain0;

        Chain chain1 = new Chain();
        chain1.setOperationName("Chain1");
        chain1.setSegment(null);
        chain1.setSectorName("Sector");
        chains[1] = chain1;

        Chain chain2 = new Chain();
        chain2.setOperationName("Chain2");
        chain2.setSegment("Segment");
        chain2.setSectorName("Sector");
        chains[2] = chain2;

        Chain chain3 = new Chain();
        chain3.setOperationName("Chain3");
        chain3.setSegment(null);
        chain3.setSectorName("Sector");
        chains[3] = chain3;

        Chain chain4 = new Chain();
        chain4.setOperationName("Chain4");
        chain4.setSegment("Segment");
        chain4.setSectorName("Sector");
        chains[4] = chain4;

        for (int i = 0; i < 50; i++) {
            MasterFood mf = new MasterFood();
            mf.setOperationName(chains[i % 5].getOperationName());
            mf.setSegment(chains[i % 5].getSegment());
            mf.setSectorName(chains[i % 5].getSectorName());
            if (i % 2 == -0) {
                mf.setTopFillIngredMM("Garlic :" + i);
                mf.setFlavEnhancSeasBrdgDesIngredMM("Season" + i);

            } else {
                mf.setTopFillIngredMM("Ingred" + i);
                mf.setFlavEnhancSeasBrdgDesIngredMM("Garlic :" + i);
            }

            this.data.add(mf);
        }
    }

    public Collection find(final ProfileParameters profileParameters) {
        return data;
    }

}