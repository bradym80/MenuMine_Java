package com.fsrin.menumine.core.menumine.masterfood;

import java.util.Collection;

import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;

/*
 * Created on Jan 17, 2005
 *
 * 
 */

/**
 * @author Nick
 * 
 * 
 */
public interface MasterFoodServiceDelegate {

    public Collection searchMasterFood(
            MasterFoodFilterParameters filterParameters)
            throws MasterFoodSearchException;

    public Collection searchMasterFoodByHQLConjunction(
            MasterFoodFilterParameters filterParameters)
            throws MasterFoodSearchException;
    
    public Collection searchMasterFoodByHQLDisjunction(
            MasterFoodFilterParameters filterParameters)
            throws MasterFoodSearchException;
    
    public Collection searchMasterFoodByHQL(
            MasterFoodFilterParameters displayParameters,
            MasterFoodFilterParameters selectParameters)
            throws MasterFoodSearchException;

    public Collection searchMasterFoodByHQL(
            String query, MasterFoodFilterParameters displayFilter)
            throws MasterFoodSearchException;
    
    /*
     * 2006-01-24 RSC Not going to use.
     */
//    // 2006-01-19 RSC Just a different way of viewing.
//    public Collection searchMasterFoodExpress(
//            MasterFoodFilterParameters filterParameters)
//            throws MasterFoodSearchException;

    public Long getCount(MasterFoodFilterParameters filterParameters)
            throws MasterFoodSearchException;

    /*
     * 2006-01-24 RSC Not going to use.
     */
//    public Collection searchMasterFoodKeywords(
//            MasterFoodKeywordFilterParameters parameters)
//            throws MasterFoodSearchException;
}