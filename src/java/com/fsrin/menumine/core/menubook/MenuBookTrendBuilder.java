/*
 * Created on Mar 18, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menubook;

import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParametersImpl;
import com.fsrin.menumine.core.menumine.masterfood.MasterFoodServiceDelegate;

/**
 * @author Nick
 * 
 * MenuBookTrends Follow the same patterns as the MenuBook except where we don't
 * limit to just results where there is a price for 2004
 *  
 */
public class MenuBookTrendBuilder extends MenuBookBuilder {

    public static final String SPRING_BEAN_NAME = "menuBookTrendsBuilder";

    private MasterFoodServiceDelegate masterFoodServiceDelegate;

    private MasterFoodFilterParameters buildMasterFoodFilterParameters(
            String chainName) {
        MasterFoodFilterParameters params = new MasterFoodFilterParametersImpl();
        params.getOperationName().getInValues().add(chainName);
//        params.getChain().getOperationName().getInValues().add(chainName);

        return params;
    }

}