/*
 * Created on Jun 14, 2004
 *
 */
package com.fsrin.menumine.core.menumine.masterfood;

import java.util.Collection;

import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;

/**
 * @author Reid
 * 
 */
public interface MasterFoodDao {

    public static final String SPRING_BEAN_NAME = "masterFoodDao";

    public static final MasterFoodDaoFactory factory = new MasterFoodDaoFactory();

    public abstract MasterFood save(MasterFood masterFood);

    public abstract MasterFood get(Long id);

    public abstract void delete(MasterFood masterFood);

    public abstract void delete(Long id);

    public abstract Collection findUsingCriteria(
            MasterFoodFilterParameters params);

//    public abstract Collection findExpressUsingCriteria(
//            MasterFoodFilterParameters params);

    public abstract Collection findUsingHQLConjunction(MasterFoodFilterParameters params);
    
    public abstract Collection findUsingHQLDisjunction(MasterFoodFilterParameters params);
    

//    public abstract Collection find(MasterFoodKeywordFilterParameters params);

    public abstract Collection getDistinct(String query);

    public static final String SELECT_BASIC_PROTEIN_BY_DISTINCT = "select DISTINCT masterFood.basicProtein from   com.fsrin.menumine.core.menumine.masterfood.MasterFood as masterFood where masterFood.basicProtein is not null ORDER BY masterFood.basicProtein ASC";

    public static final String SELECT_DESSERT_MENU_PART_BY_DISTINCT = "select DISTINCT masterFood.genMenuPart from   com.fsrin.menumine.core.menumine.masterfood.MasterFood as masterFood where masterFood.genMenuPart is not null and masterFood.genMenuPart like '%Dessert%' ORDER BY masterFood.genMenuPart ASC";

    public static final String SELECT_BREAKFAST_MENU_PART_BY_DISTINCT = "select DISTINCT masterFood.genMenuPart from   com.fsrin.menumine.core.menumine.masterfood.MasterFood as masterFood where masterFood.genMenuPart is not null and masterFood.genMenuPart like '%Breakfast%' ORDER BY masterFood.genMenuPart ASC";

    public static final String SELECT_MENU_PART_BY_DISTINCT = "select DISTINCT masterFood.genMenuPart from   com.fsrin.menumine.core.menumine.masterfood.MasterFood as masterFood where masterFood.genMenuPart is not null and masterFood.genMenuPart not like '%Dessert%' ORDER BY masterFood.genMenuPart ASC";

    public static final String SELECT_BEVERAGE_MENU_PART_BY_DISTINCT = "select DISTINCT masterFood.genMenuPart from   com.fsrin.menumine.core.menumine.masterfood.MasterFood as masterFood where masterFood.genMenuPart is not null and masterFood.genMenuPart like '%Beverage%' ORDER BY masterFood.genMenuPart ASC";

    public static final String SELECT_DESSERT_MENU_ITEM_CLASS_BY_DISTINCT = "select DISTINCT masterFood.menuItemClass from   com.fsrin.menumine.core.menumine.masterfood.MasterFood as masterFood where masterFood.menuItemClass is not null and masterFood.dayPartCategory like '%Dessert%' ORDER BY masterFood.menuItemClass ASC";

    /*
     * 2006-01-31 RSC
     */
//    public static final String SELECT_OPERATION_NAME_BY_DISTINCT = "select DISTINCT masterFood.chain.operationName from   com.fsrin.menumine.core.menumine.masterfood.MasterFood as masterFood where masterFood.chain.operationName is not null ORDER BY masterFood.chain.operationName ASC";
    public static final String SELECT_OPERATION_NAME_BY_DISTINCT = "select DISTINCT masterFood.operationName from   com.fsrin.menumine.core.menumine.masterfood.MasterFood as masterFood where masterFood.operationName is not null ORDER BY masterFood.operationName ASC";


    public static final String SELECT_DESSERT_MENU_STATUS_BY_DISTINCT = "select DISTINCT masterFood.menuStatus from   com.fsrin.menumine.core.menumine.masterfood.MasterFood as masterFood where masterFood.menuStatus is not null and masterFood.dayPartCategory like '%Dessert%' ORDER BY masterFood.menuStatus ASC";

    public static final String SELECT_DESSERT_CUISINE_BY_DISTINCT = "select DISTINCT masterFood.cuisine from   com.fsrin.menumine.core.menumine.masterfood.MasterFood as masterFood where masterFood.cuisine is not null and masterFood.dayPartCategory like '%Dessert%' ORDER BY masterFood.cuisine ASC";

    // public static final String SELECT_OPERATION_NAME_BY_DISTINCT = "select
    // DISTINCT masterFood.chain from com.fsrin.menumine.core.menumine.Chain as
    // masterFood where masterFood.chain is not null ORDER BY masterFood.chain
    // ASC";

    public static final String SELECT_CUISINE_FAMILY_BY_DISTINCT = "select DISTINCT masterFood.cuisineFamily from   com.fsrin.menumine.core.menumine.masterfood.MasterFood as masterFood where masterFood.cuisineFamily is not null ORDER BY masterFood.cuisineFamily ASC";

    public static final String SELECT_CAKE_USE_BY_DISTINCT = "select DISTINCT masterFood.cakeUse from   com.fsrin.menumine.core.menumine.masterfood.MasterFood as masterFood where masterFood.cakeUse is not null and masterFood.dayPartCategory like '%Dessert%' ORDER BY masterFood.cakeUse ASC";

    public static final String SELECT_COOKIE_USE_BY_DISTINCT = "select DISTINCT masterFood.cookieUse from   com.fsrin.menumine.core.menumine.masterfood.MasterFood as masterFood where masterFood.cookieUse is not null and masterFood.dayPartCategory like '%Dessert%' ORDER BY masterFood.cookieUse ASC";

    public static final String SELECT_GEN_COOKING_METHOD_BY_DISTINCT = "select DISTINCT masterFood.genCookMeth from   com.fsrin.menumine.core.menumine.masterfood.MasterFood as masterFood where masterFood.genCookMeth is not null ORDER BY masterFood.genCookMeth ASC";

    /*
     * nick 2005-2-3 These are obsoleted by CuisineFamily and GenCookMeth.
     */
    public static final String SELECT_CUISINE_BY_DISTINCT = "select DISTINCT masterFood.cuisine from   com.fsrin.menumine.core.menumine.masterfood.MasterFood as masterFood where masterFood.cuisine is not null ORDER BY masterFood.cuisine ASC";

    public static final String SELECT_COOKING_METHOD_BY_DISTINCT = "select DISTINCT masterFood.cookMeth from   com.fsrin.menumine.core.menumine.masterfood.MasterFood as masterFood where masterFood.cookMeth is not null ORDER BY masterFood.cookMeth ASC";

    // public static final String SELECT_MARKET_SECTOR_BY_DISTINCT = "select
    // DISTINCT masterFood.chain.sector from
    // com.fsrin.menumine.core.menumine.MasterFood as masterFood where
    // masterFood.chain.sector is not null ORDER BY masterFood.chain.sector
    // ASC";

    // public static final String SELECT_MARKET_SEGMENT_BY_DISTINCT = "select
    // DISTINCT masterFood.chain.segment from
    // com.fsrin.menumine.core.menumine.MasterFood as masterFood where
    // masterFood.chain.segment is not null ORDER BY masterFood.chain.segment
    // ASC";
    /*
     * nick - 2005-1-18 It may make sence to put this two querys with the
     * ChainDAO, but these querys make sence to group them together in one place
     * as they are all used to prepopulate the main form. Also the chain is a
     * subproperty of the masterfood, so an association exists.
     * 
     * 2006-01-31 RSC Data has been refactored do these are in the main table.
     */
    //public static final String SELECT_MARKET_SECTOR_BY_DISTINCT = "select DISTINCT chain.sectorName from   com.fsrin.menumine.core.menumine.chain.Chain as chain where chain.sectorName is not null ORDER BY  chain.sectorName ASC";
    public static final String SELECT_MARKET_SECTOR_BY_DISTINCT = "select DISTINCT sectorName from   com.fsrin.menumine.core.menumine.masterfood.MasterFood where sectorName is not null ORDER BY  sectorName ASC";

    public static final String SELECT_MARKET_SEGMENT_BY_DISTINCT = "select DISTINCT segment from   com.fsrin.menumine.core.menumine.masterfood.MasterFood where  segment is not null ORDER BY  segment ASC";

    public abstract Long getCount(MasterFoodFilterParameters masterFood)
            throws Exception;

    /*
     * 2006-02-02 RSC Doesn't seem to be doing anything
     */
//    public abstract Collection getPageableResults(
//            MasterFoodFilterParametersImpl params);

//    public abstract Collection findUsingHQL(
//            MasterFoodFilterParameters filterParameters,
//            FilterParameter[] extraParameters);

    public int execute(String hql) throws Exception;
}