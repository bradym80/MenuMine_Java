/*
 * Created on Jun 27, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.natlaccountbench;

import java.util.ArrayList;
import java.util.Collection;

import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParametersImpl;
import com.fsrin.menumine.core.menumine.chain.Chain;
import com.fsrin.menumine.core.menumine.masterfood.MasterFood;
import com.fsrin.menumine.core.menumine.masterfood.MasterFoodDao;

/**
 * @author Nick
 * 
 *  
 */
public class MasterFoodDaoMockImpl implements MasterFoodDao {

    public MasterFoodDaoMockImpl() {
        super();

    }

    public MasterFood save(MasterFood masterFood) {

        return null;
    }

    public MasterFood get(Long id) {

        return null;
    }

    public void delete(MasterFood masterFood) {
    }

    public void delete(Long id) {
    }

    public Collection findUsingCriteria(MasterFoodFilterParameters params) {
        Collection results = new ArrayList();
        MasterFood mf = this.buildMasterFood("Burger King", "Beef");
        results.add(mf);
        mf = this.buildMasterFood("Burger King", "Beef");
        results.add(mf);
        mf = this.buildMasterFood("Burger King", "Beef");
        results.add(mf);
        mf = this.buildMasterFood("Burger King", "Beef");
        results.add(mf);
        mf = this.buildMasterFood("Burger King", "Chicken");
        results.add(mf);
        mf = this.buildMasterFood("Burger King", "Chicken");
        results.add(mf);
        mf = this.buildMasterFood("Burger King", "Chicken");
        results.add(mf);
        mf = this.buildMasterFood("Burger King", "Fish");
        results.add(mf);
        mf = this.buildMasterFood("Burger King", "Fish");
        results.add(mf);
        mf = this.buildMasterFood("Burger King", "");
        results.add(mf);

        mf = this.buildMasterFood("Wendy's", "Beef");
        results.add(mf);
        mf = this.buildMasterFood("Wendy's", "Beef");
        results.add(mf);
        mf = this.buildMasterFood("Wendy's", "Beef");
        results.add(mf);
        mf = this.buildMasterFood("Wendy's", "Beef");
        results.add(mf);
        mf = this.buildMasterFood("Wendy's", "Chicken");
        results.add(mf);
        mf = this.buildMasterFood("Wendy's", "Chicken");
        results.add(mf);
        mf = this.buildMasterFood("Wendy's", "Chicken");
        results.add(mf);
        mf = this.buildMasterFood("Wendy's", "Fish");
        results.add(mf);
        mf = this.buildMasterFood("Wendy's", "Fish");
        results.add(mf);
        mf = this.buildMasterFood("Wendy's", "");
        results.add(mf);

        mf = this.buildMasterFood("Arby's", "Beef");
        results.add(mf);
        mf = this.buildMasterFood("Fridays", "Beef");
        results.add(mf);
        mf = this.buildMasterFood("Fridays", "Beef");
        results.add(mf);
        mf = this.buildMasterFood("Chillies", "Beef");
        results.add(mf);
        mf = this.buildMasterFood("Other", "Chicken");
        results.add(mf);
        mf = this.buildMasterFood("Ditkas", "Chicken");
        results.add(mf);
        mf = this.buildMasterFood("Tru", "Chicken");
        results.add(mf);
        mf = this.buildMasterFood("China Grill", "Fish");
        results.add(mf);
        mf = this.buildMasterFood("JJ Fish", "Fish");
        results.add(mf);
        mf = this.buildMasterFood("JJ Fish", "");
        results.add(mf);

        return results;
    }
//
//    public Collection find(MasterFoodKeywordFilterParameters params) {
//        return null;
//    }

    private MasterFood buildMasterFood(String operationName, String basicProtein) {
        MasterFood mf = new MasterFood();
        Chain chain = new Chain();
//        mf.setChain(chain);

        mf.setBasicProtein(basicProtein);
        mf.setOperationName(operationName);
        return mf;
    }

    public Collection getDistinct(String query) {

        return null;
    }

    public Long getCount(MasterFoodFilterParameters masterFood)
            throws Exception {

        return null;
    }

    public Collection getPageableResults(MasterFoodFilterParametersImpl params) {

        return null;
    }

    public Collection findExpressUsingCriteria(MasterFoodFilterParameters params) {
        
        return null;
    }

    public Collection findUsingHQLConjunction(MasterFoodFilterParameters params) {
        
        return null;
    }

    public int execute(String hql) throws Exception {
        
        return 0;
    }

    public Collection findUsingHQLDisjunction(MasterFoodFilterParameters params) {
        
        return null;
    }

}