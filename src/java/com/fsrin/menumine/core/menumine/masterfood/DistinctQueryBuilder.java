/*
 * Created on Jan 18, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.masterfood;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import com.fsrin.menumine.testutil.TimerUtil;

/**
 * @author Nick
 * 
 * This class is used to get the values to populate the selection boxes for the
 * main list. Rather then put each method in the service delegate we collect
 * them here.
 * 
 * 2006-08-14 RSC Is configured as a singleton within Spring.
 * 
 * 2006-01-20 RSC Memory Hog?  Not too bad.  Couldn't we generate these statically?
 * It only takes up about 8k.
 * 
 * 2006-01-22 RSC Test hog! Adds ~1min to test setup and execution because it
 * runs anytime the spring context initializes.  Added monitor below.
 * 
 */
public class DistinctQueryBuilder implements MasterFoodDaoAware,
        ApplicationListener {

    public static final String SPRING_BEAN_NAME = "distinctQueryBuilder";
    
    private static Log log = LogFactory.getLog(DistinctQueryBuilder.class);

    private MasterFoodDao masterFoodDao;

    private Collection marketSegment;

    private Collection marketSector;

    private Collection menuPart;

    private Collection dessertMenuPart;

    private Collection beverageMenuPart;

    private Collection breakfastMenuPart;

    private Collection basicProtein;

    private Collection cuisineOfItem;

    private Collection cookingMethod;

    private Collection operationName;

    private Collection cuisineFamily;

    private Collection genCookingMethod;

    private Collection dessertMenuItemClass;

    private Collection dessertMenuStatus;

    private Collection dessertCuisine;

    private Collection cakeUse;

    private Collection cookieUse;

    public Collection getBreakfastMenuPartInit() {
        if (breakfastMenuPart == null) {
            log.debug("initialize getBreakfastMenuPartInit");
            breakfastMenuPart = this.getMasterFoodDao().getDistinct(
                    MasterFoodDao.SELECT_BREAKFAST_MENU_PART_BY_DISTINCT);
        }
        return breakfastMenuPart;
    }

    public Collection getBeverageMenuPartInit() {
        if (beverageMenuPart == null) {
            log.debug("initialize getBreakfastMenuPartInit");
            beverageMenuPart = this.getMasterFoodDao().getDistinct(
                    MasterFoodDao.SELECT_BEVERAGE_MENU_PART_BY_DISTINCT);
        }
        return beverageMenuPart;
    }

    public Collection getDessertMenuPartInit() {
        if (dessertMenuPart == null) {
            log.debug("initialize getDessertMenuPartInit");
            dessertMenuPart = this.getMasterFoodDao().getDistinct(
                    MasterFoodDao.SELECT_DESSERT_MENU_PART_BY_DISTINCT);
        }
        return dessertMenuPart;
    }

    public Collection getDessertMenuItemClassInit() {
        if (dessertMenuItemClass == null) {
            log.debug("initialize getDessertMenuItemClassInit");
            dessertMenuItemClass = this.getMasterFoodDao().getDistinct(
                    MasterFoodDao.SELECT_DESSERT_MENU_ITEM_CLASS_BY_DISTINCT);
        }
        return dessertMenuItemClass;
    }

    public Collection getDessertMenuStatusInit() {
        if (dessertMenuStatus == null) {
            log.debug("initialize getDessertMenuStatusInit");
            dessertMenuStatus = this.getMasterFoodDao().getDistinct(
                    MasterFoodDao.SELECT_DESSERT_MENU_STATUS_BY_DISTINCT);
        }
        return dessertMenuStatus;
    }

    public Collection getDessertCuisineInit() {
        if (dessertCuisine == null) {
            log.debug("initialize getDessertCuisineInit");
            dessertCuisine = this.getMasterFoodDao().getDistinct(
                    MasterFoodDao.SELECT_DESSERT_CUISINE_BY_DISTINCT);
        }
        return dessertCuisine;
    }

    public Collection getCakeUseInit() {
        if (cakeUse == null) {
            log.debug("initialize getCakeUseInit");
            cakeUse = this.getMasterFoodDao().getDistinct(
                    MasterFoodDao.SELECT_CAKE_USE_BY_DISTINCT);
        }
        return cakeUse;
    }

    public Collection getCookieUseInit() {
        if (cookieUse == null) {
            log.debug("initialize getCookieUseInit");
            cookieUse = this.getMasterFoodDao().getDistinct(
                    MasterFoodDao.SELECT_COOKIE_USE_BY_DISTINCT);
        }
        return cookieUse;
    }

    public Collection getMenuPartInit() {
        if (menuPart == null) {
            log.debug("initialize getMenuPartInit");
            menuPart = this.getMasterFoodDao().getDistinct(
                    MasterFoodDao.SELECT_MENU_PART_BY_DISTINCT);
        }
        return menuPart;
    }

    public Collection getMarketSectorInit() {
        if (marketSector == null) {
            log.debug("initialize getMarketSectorInit");
            marketSector = this.getMasterFoodDao().getDistinct(
                    MasterFoodDao.SELECT_MARKET_SECTOR_BY_DISTINCT);
        }
        return marketSector;
    }

    public Collection getMarketSegmentInit() {
        if (marketSegment == null) {
            log.debug("initialize getMarketSegmentInit");
            marketSegment = this.getMasterFoodDao().getDistinct(
                    MasterFoodDao.SELECT_MARKET_SEGMENT_BY_DISTINCT);
        }
        return marketSegment;
    }

    public Collection getBasicProteinInit() {
        if (basicProtein == null) {
            log.debug("initialize getBasicProteinInit");
            basicProtein = this.getMasterFoodDao().getDistinct(
                    MasterFoodDao.SELECT_BASIC_PROTEIN_BY_DISTINCT);
        }
        return basicProtein;
    }

    public Collection getCuisineOfItemInit() {
        if (cuisineOfItem == null) {
            log.debug("initialize getCuisineOfItemInit");
            cuisineOfItem = this.getMasterFoodDao().getDistinct(
                    MasterFoodDao.SELECT_CUISINE_BY_DISTINCT);
        }
        return cuisineOfItem;
    }

    public Collection getCookingMethodInit() {
        if (cookingMethod == null) {
            log.debug("initialize getCookingMethodInit");
            cookingMethod = this.getMasterFoodDao().getDistinct(
                    MasterFoodDao.SELECT_COOKING_METHOD_BY_DISTINCT);
        }

        return cookingMethod;
    }

    public Collection getOperationNameInit() {

        //operationName = null;
        if (operationName == null) {
            log.debug("initialize getOperationNameInit");
            operationName = this.getMasterFoodDao().getDistinct(
                    MasterFoodDao.SELECT_OPERATION_NAME_BY_DISTINCT);
        }
        return operationName;
    }

    public MasterFoodDao getMasterFoodDao() {
        return masterFoodDao;
    }

    public void setMasterFoodDao(MasterFoodDao masterFoodDao) {
        this.masterFoodDao = masterFoodDao;
    }

    public Collection getCuisineFamilyInit() {
        if (cuisineFamily == null) {
            log.debug("initialize getCuisineFamilyInit");
            cuisineFamily = this.getMasterFoodDao().getDistinct(
                    MasterFoodDao.SELECT_CUISINE_FAMILY_BY_DISTINCT);
        }

        return cuisineFamily;

    }

    public Collection getGenCookingMethodInit() {
        if (genCookingMethod == null) {
            log.debug("initialize getGenCookingMethodInit");
            genCookingMethod = this.getMasterFoodDao().getDistinct(
                    MasterFoodDao.SELECT_GEN_COOKING_METHOD_BY_DISTINCT);
        }

        return genCookingMethod;
    }

    public Collection getMenuPart() {

        return menuPart;
    }

    public Collection getMarketSector() {

        return marketSector;
    }

    public Collection getMarketSegment() {

        return marketSegment;
    }

    public Collection getBasicProtein() {

        return basicProtein;
    }

    public Collection getCuisineOfItem() {

        return cuisineOfItem;
    }

    public Collection getCookingMethod() {

        return cookingMethod;
    }

    public Collection getOperationName() {

        return operationName;
    }

    public Collection getCuisineFamily() {

        return cuisineFamily;

    }

    public Collection getGenCookingMethod() {

        return genCookingMethod;
    }

    public Collection getDessertMenuPart() {
        return dessertMenuPart;
    }

    public Collection getCakeUse() {
        return cakeUse;
    }

    public Collection getCookieUse() {
        return cookieUse;
    }

    public Collection getDessertCuisine() {
        return dessertCuisine;
    }

    public Collection getDessertMenuItemClass() {
        return dessertMenuItemClass;
    }

    public Collection getDessertMenuStatus() {
        return dessertMenuStatus;
    }

    public Collection getBeverageMenuPart() {
        return beverageMenuPart;
    }

    public Collection getBreakfastMenuPart() {
        return breakfastMenuPart;
    }

    /*
     * nick 2005.5.17 Whenever a ContextRefreshedEvent event is thrown we make
     * sure we are initialized. This depends on spring. (non-Javadoc)
     * 
     * @see org.springframework.context.ApplicationListener#onApplicationEvent(org.springframework.context.ApplicationEvent)
     */
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        
        
        
        /*
         * 2006-01-22 RSC Added Bypass since it interferes with tests
         */
        if (DistinctQueryBuilderBypassManager.isBypass())
            return;
        
        TimerUtil timer = TimerUtil.getInstanceAndStart("distinct");
        
        
        if (applicationEvent instanceof ContextRefreshedEvent) {
            getMenuPartInit();
            getMarketSectorInit();
            getMarketSegmentInit();
            getBasicProteinInit();
            getCuisineOfItemInit();
            getCookingMethodInit();
            getOperationNameInit();
            getCuisineFamilyInit();
            getGenCookingMethodInit();
            getDessertMenuPartInit();
            getDessertMenuItemClassInit();
            getDessertMenuStatusInit();
            getDessertCuisineInit();
            getBeverageMenuPartInit();
            getBreakfastMenuPartInit();
            getCakeUseInit();
            getCookieUseInit();

        }
        timer.stop();
    }

}