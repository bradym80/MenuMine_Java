/*
 * Created on Apr 5, 2005
 *
 * 
 */
package com.fsrin.menumine.core.profiler.test;

import java.util.ArrayList;
import java.util.Collection;

import com.fsrin.menumine.core.menumine.chain.Chain;
import com.fsrin.menumine.core.menumine.chain.ChainDao;
import com.fsrin.menumine.core.menumine.chain.ChainFilterParameters;

/**
 * @author Nick
 * 
 *  
 */
public class MockChainDao implements ChainDao {

    public MockChainDao() {
        super();

    }

    public Chain save(Chain chain) {

        throw new RuntimeException("Your father was a hampster");
    }

    public Chain get(Long id) {

        throw new RuntimeException("Your mother smells of elderberries");
    }

    public void delete(Chain chain) {

        throw new RuntimeException("Your mother smells of elderberries");
    }

    public void delete(Long id) {

        throw new RuntimeException("Your mother smells of elderberries");
    }

    public Collection find(ChainFilterParameters params) {

        //Chain[] chains = new Chain[5];
        Collection col = new ArrayList();

        Chain chain0 = new Chain();
        chain0.setOperationName("Chain0");
        chain0.setSegment("Segment1");
        chain0.setSectorName("Sector1");
        col.add(chain0);

        Chain chain1 = new Chain();
        chain1.setOperationName("Chain1");
        chain1.setSegment("Segment1");
        chain1.setSectorName("Sector1");
        col.add(chain1);

        Chain chain2 = new Chain();
        chain2.setOperationName("Chain2");
        chain2.setSegment("Segment2");
        chain2.setSectorName("Sector1");
        col.add(chain2);

        Chain chain3 = new Chain();
        chain3.setOperationName("Chain3");
        chain3.setSegment("Segment2");
        chain3.setSectorName("Sector1");
        col.add(chain3);

        Chain chain4 = new Chain();
        chain4.setOperationName("Chain4");
        chain4.setSegment("Segment3");
        chain4.setSectorName("Sector2");
        col.add(chain4);

        Chain chain5 = new Chain();
        chain5.setOperationName("Chain5");
        chain5.setSegment("Segment3");
        chain5.setSectorName("Sector2");
        col.add(chain5);

        Chain chain6 = new Chain();
        chain6.setOperationName("Chain6");
        chain6.setSegment("Segment4");
        chain6.setSectorName("Sector2");
        col.add(chain6);

        Chain chain7 = new Chain();
        chain7.setOperationName("Chain7");
        chain7.setSegment("Segment4");
        chain7.setSectorName("Sector2");
        col.add(chain7);

        Chain chain8 = new Chain();
        chain8.setOperationName("Chain8");
        chain8.setSegment("Segment5");
        chain8.setSectorName("Sector3");
        col.add(chain8);

        Chain chain9 = new Chain();
        chain9.setOperationName("Chain9");
        chain9.setSegment("Segment5");
        chain9.setSectorName("Sector3");
        col.add(chain9);

        Chain chain10 = new Chain();
        chain10.setOperationName("Chain10");
        chain10.setSegment("Segment6");
        chain10.setSectorName("Sector3");
        col.add(chain10);

        Chain chain11 = new Chain();
        chain11.setOperationName("Chain11");
        chain11.setSegment("Segment6");
        chain11.setSectorName("Sector3");
        col.add(chain11);

        return col;

    }

}