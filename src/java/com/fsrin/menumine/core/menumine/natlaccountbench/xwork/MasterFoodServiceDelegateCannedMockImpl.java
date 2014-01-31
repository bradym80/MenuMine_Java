/*
 * Created on Jul 15, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.natlaccountbench.xwork;

import java.util.ArrayList;
import java.util.Collection;

import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;
import com.fsrin.menumine.core.menumine.chain.Chain;
import com.fsrin.menumine.core.menumine.masterfood.MasterFood;
import com.fsrin.menumine.core.menumine.masterfood.MasterFoodSearchException;
import com.fsrin.menumine.core.menumine.masterfood.MasterFoodServiceDelegate;

/**
 * @author Nick
 * 
 *  
 */
public class MasterFoodServiceDelegateCannedMockImpl implements
        MasterFoodServiceDelegate {

    public MasterFoodServiceDelegateCannedMockImpl() {
        super();

    }

    public Collection searchMasterFood(
            MasterFoodFilterParameters filterParameters)
            throws MasterFoodSearchException {
        Collection col = new ArrayList();

        MasterFood mf = this.getMasterFood();
        col.add(mf);

        mf = this.getMasterFood();
        col.add(mf);

        mf = this.getMasterFood();
        col.add(mf);

        mf = this.getMasterFood();
        col.add(mf);

        mf = this.getMasterFood();
        col.add(mf);

        return col;
    }



    private static int i = 0;

    private MasterFood getMasterFood() {
        i++;
        MasterFood mf = new MasterFood();
        mf.setBasicProtein("Basic Protein" + i);
        mf.setBreadBakeGoodsMM("Bread Baked" + i);
        mf.setBreadUse("Bread" + i);
        mf.setCakeUse("Cake Use" + i);
        Chain chain = new Chain();
        chain.setOperationName("Wendy's");
        mf.setChain(chain);

        return mf;
    }

    public Long getCount(MasterFoodFilterParameters filterParameters)
            throws MasterFoodSearchException {

        return new Long(5);
    }

    public Collection searchMasterFoodExpress(MasterFoodFilterParameters filterParameters) throws MasterFoodSearchException {
        
        return null;
    }

    public Collection searchMasterFoodByHQLConjunction(MasterFoodFilterParameters filterParameters) throws MasterFoodSearchException {
        
        return null;
    }

    public Collection searchMasterFoodByHQL(String query, MasterFoodFilterParameters displayFilter) throws MasterFoodSearchException {
        
        return null;
    }

    public Collection searchMasterFoodByHQL(MasterFoodFilterParameters displayParameters, MasterFoodFilterParameters selectParameters) throws MasterFoodSearchException {
        
        return null;
    }

    public Collection searchMasterFoodByHQLDisjunction(MasterFoodFilterParameters filterParameters) throws MasterFoodSearchException {
        
        return null;
    }

}