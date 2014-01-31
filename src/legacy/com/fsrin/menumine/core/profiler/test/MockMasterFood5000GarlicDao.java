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
public class MockMasterFood5000GarlicDao extends ProfileDao {

    private Collection data = new ArrayList();

    public MockMasterFood5000GarlicDao() {
        super();
        this.initData();
    }

    private void initData() {

        Chain[] chains = new Chain[12];
        Chain chain0 = new Chain();
        chain0.setOperationName("Chain0");
        chain0.setSegment("Segment1");
        chain0.setSectorName("Sector1");
        chains[0] = chain0;

        Chain chain1 = new Chain();
        chain1.setOperationName("Chain1");
        chain1.setSegment("Segment1");
        chain1.setSectorName("Sector1");
        chains[1] = chain1;

        Chain chain2 = new Chain();
        chain2.setOperationName("Chain2");
        chain2.setSegment("Segment2");
        chain2.setSectorName("Sector1");
        chains[2] = chain2;

        Chain chain3 = new Chain();
        chain3.setOperationName("Chain3");
        chain3.setSegment("Segment2");
        chain3.setSectorName("Sector1");
        chains[3] = chain3;

        Chain chain4 = new Chain();
        chain4.setOperationName("Chain4");
        chain4.setSegment("Segment3");
        chain4.setSectorName("Sector2");
        chains[4] = chain4;

        Chain chain5 = new Chain();
        chain5.setOperationName("Chain5");
        chain5.setSegment("Segment3");
        chain5.setSectorName("Sector2");
        chains[5] = chain5;

        Chain chain6 = new Chain();
        chain6.setOperationName("Chain6");
        chain6.setSegment("Segment4");
        chain6.setSectorName("Sector2");
        chains[6] = chain6;

        Chain chain7 = new Chain();
        chain7.setOperationName("Chain7");
        chain7.setSegment("Segment4");
        chain7.setSectorName("Sector2");
        chains[7] = chain7;

        Chain chain8 = new Chain();
        chain8.setOperationName("Chain8");
        chain8.setSegment("Segment5");
        chain8.setSectorName("Sector3");
        chains[8] = chain8;

        Chain chain9 = new Chain();
        chain9.setOperationName("Chain9");
        chain9.setSegment("Segment5");
        chain9.setSectorName("Sector3");
        chains[9] = chain9;

        Chain chain10 = new Chain();
        chain10.setOperationName("Chain10");
        chain10.setSegment("Segment6");
        chain10.setSectorName("Sector3");
        chains[10] = chain10;

        Chain chain11 = new Chain();
        chain11.setOperationName("Chain11");
        chain11.setSegment("Segment6");
        chain11.setSectorName("Sector3");
        chains[11] = chain11;

        for (int i = 0; i < 500000; i++) {
            MasterFood mf = new MasterFood();
            mf.setChain(chains[i % 12]);
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