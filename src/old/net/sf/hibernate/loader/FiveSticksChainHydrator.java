/*
 * Created on Mar 30, 2005
 *
 * 
 */
package net.sf.hibernate.loader;

import com.fsrin.menumine.core.menumine.chain.Chain;

/**
 * @author Nick
 * 
 *  
 */
public class FiveSticksChainHydrator implements FiveSticksHydrator {

    public FiveSticksChainHydrator() {
        super();

    }

    public void hydrate(Object object, Object[] values) {
        if (values.length != 4) {
            throw new RuntimeException(
                    "HBM must have changed!  Please update FiveSticksChainHydrator to reflect changes.");
        }

        ((Chain) object).setOperationName((String) values[0]);
        ((Chain) object).setSegment((String) values[1]);
        ((Chain) object).setSectorName((String) values[2]);
        ((Chain) object).setHqState((String) values[3]);
    }

}