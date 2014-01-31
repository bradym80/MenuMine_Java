/*
 * Created on Jun 8, 2005
 *
 * 
 */
package com.fsrin.menumine.core.dessertmine.xwork.test;

import java.util.ArrayList;
import java.util.Collection;

import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;
import com.fsrin.menumine.core.menumine.masterfood.MasterFood;
import com.fsrin.menumine.core.menumine.masterfood.MasterFoodSearchException;
import com.fsrin.menumine.core.menumine.masterfood.MasterFoodServiceDelegate;

/**
 * @author Nick
 * 
 *  
 */
public class AbstractMasterFoodServiceDelegateMockImpl implements
        MasterFoodServiceDelegate {

    private Collection results = new ArrayList();

    public AbstractMasterFoodServiceDelegateMockImpl() {
        super();
        initResults();
    }

    protected void initResults() {
        MasterFood mf = new MasterFood();
        mf.setCakeIngredient("CakeIngredient");
        mf.setCakeUse("CakeUse");
        mf.setCandyIngredient("CandyIngredient");
        mf.setCookieIngredient("cookieIngredient");
        mf.setCookieUse("CookieUse");
        mf.setDayPartCategory("DayPartCategory");

        mf.setDessertDoughCrustIngred("dessertDoughCrustIngred");
        mf.setIceCreamIngredient("iceCreamIngredient");
        mf.setSyrupTopping("syrupTopping");
        mf.setNutIngredient("nutIngredient");

        mf.setFruitOrFruitFillingIngred("fruitOrFruitFillingIngred");
        mf.setWhippedToppingIngred("whippedToppingIngred");

        mf.setPrimaryFlavor("primaryFlavor");
        mf.setTasteFlavorWords("tasteFlavorWords");
        mf.setBrand("brand");

        this.getResults().add(mf);

    }

    public Collection searchMasterFood(
            MasterFoodFilterParameters filterParameters)
            throws MasterFoodSearchException {

        return results;
    }



    public Long getCount(MasterFoodFilterParameters filterParameters)
            throws MasterFoodSearchException {

        return new Long(results.size());
    }

    public Collection getResults() {
        return results;
    }

    public void setResults(Collection results) {
        this.results = results;
    }

    public Collection searchMasterFoodExpress(MasterFoodFilterParameters filterParameters) throws MasterFoodSearchException {
        
        return null;
    }

    public Collection searchMasterFoodByHQLConjunction(MasterFoodFilterParameters filterParameters) throws MasterFoodSearchException {
        
        return this.results;
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