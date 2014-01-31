/*
 * Created on Aug 17, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.express;

import java.util.ArrayList;
import java.util.Collection;

import com.fsrin.menumine.core.dessertmine.xwork.test.MasterFoodServiceDelegateMockImpl;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;
import com.fsrin.menumine.core.menumine.masterfood.MasterFood;
import com.fsrin.menumine.core.menumine.masterfood.MasterFoodSearchException;
import com.fsrin.menumine.core.menumine.masterfood.MasterFoodServiceDelegate;

/**
 * @author Nick
 * 
 *  
 */
public class MasterFoodServiceDelegateMockExpressImpl extends
        MasterFoodServiceDelegateMockImpl implements MasterFoodServiceDelegate {

    Collection results = new ArrayList();

    public MasterFoodServiceDelegateMockExpressImpl() {
        super();
        this.initResults();
    }

    protected void initResults() {

        for (int i = 0; i < 500; ++i) {
            MasterFood mf = new MasterFood();
            mf.setBasicProtein("Chicken");
            mf.setCondiments("BBQ");
            mf.setProteinTypeCut("Chicken");
            mf.setProteinTopName("Chicken");
            mf.setSeasoningName("Curry");
            mf.setSauceCondDressMarMM("BBQ");
            mf.setDipSauceName("Curry");
            mf.setDayPartCategory("Appetizer");
            results.add(mf);

        }
    }

    public Collection searchMasterFood(
            MasterFoodFilterParameters filterParameters)
            throws MasterFoodSearchException {

        return results;
    }
}