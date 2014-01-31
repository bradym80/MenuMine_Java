/*
 * Created on Mar 30, 2005
 *
 * 
 */
package net.sf.hibernate.loader;

import com.fsrin.menumine.core.menumine.masterfood.MasterFood;

/**
 * @author Nick
 * 
 *  
 */
public class FiveSticksHydratorFactory {

    public FiveSticksHydratorFactory() {
        super();

    }

    public FiveSticksHydrator getHydrator(Object object) {

        //        if (object instanceof Chain) {
        //            return new FiveSticksChainHydrator();
        //        }
        if (object instanceof MasterFood) {
            return new FiveSticksMasterFoodHydrator();
        }
        return null;
    }

}