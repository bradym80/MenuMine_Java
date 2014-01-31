/*
 * Created on Jun 17, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.webwork;

import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;

/**
 * @author Nick
 * 
 * 
 */
public interface MasterFoodFilterParametersWrapper {

    public abstract MasterFoodFilterParameters getMasterFoodFilterParameters();

    // public abstract ChainFilterParametersWrapper getChain();

    public abstract FilterParameterWrapper getKeywords();

    public abstract FilterParameterWrapper getBasicProtein();

    public abstract FilterParameterWrapper getBreadBakeGoodsMM();

    public abstract FilterParameterWrapper getCarboVegFruit();

    public abstract FilterParameterWrapper getCheeseMM();

    public abstract FilterParameterWrapper getCookMeth();

    public abstract FilterParameterWrapper getCuisine();

    public abstract FilterParameterWrapper getCuisineFamily();

    public abstract FilterParameterWrapper getFlavEnhancSeasBrdgDesIngredMM();

    public abstract FilterParameterWrapper getGenCookMeth();

    public abstract FilterParameterWrapper getGenMenuPart();

    public abstract FilterParameterWrapper getItemDescription();

    public abstract FilterParameterWrapper getMenuItem();

    public abstract FilterParameterWrapper getMenuItemClass();

    public abstract FilterParameterWrapper getMenuItemType();

    public abstract FilterParameterWrapper getMenuStatus();

    // public FilterParameterWrapper getProteinType() {
    public abstract FilterParameterWrapper getProteinTypeCut();
    
    // 2009-06-01 MJB added 9 protein type fields below.
    public abstract FilterParameterWrapper getChickenType();
    
    public abstract FilterParameterWrapper getBeefType();
    
    public abstract FilterParameterWrapper getPorkType();
    
    public abstract FilterParameterWrapper getFishType();
    
    public abstract FilterParameterWrapper getSeafoodType();
    
    public abstract FilterParameterWrapper getLambType();
    
    public abstract FilterParameterWrapper getTurkeyType();
    
    public abstract FilterParameterWrapper getOtherProteinType();
    
    public abstract FilterParameterWrapper getShrimpType();

    public abstract FilterParameterWrapper getSauceCondDressMarMM();

    public abstract FilterParameterWrapper getTopFillIngredMM();

    //MJB
    public abstract FilterParameterWrapper getPrice2011();
    
    public abstract FilterParameterWrapper getPrice2010();
    // DBB 1-20-2009 Add 2008, 2009
    public abstract FilterParameterWrapper getPrice2009();
    
    public abstract FilterParameterWrapper getPrice2008();
    
    public abstract FilterParameterWrapper getPrice2006();
    //JDL 10-5-07
    public abstract FilterParameterWrapper getPrice2007();

    public abstract FilterParameterWrapper getPrice2005();

    public abstract FilterParameterWrapper getPrice2004();

    public abstract FilterParameterWrapper getPrice2003();

    public abstract FilterParameterWrapper getPrice2002();

    public abstract FilterParameterWrapper getPrice2001();

    public abstract FilterParameterWrapper getPrice2000();

    public abstract FilterParameterWrapper getPrice1999();

    public abstract FilterParameterWrapper getPrice1998();

    public abstract FilterParameterWrapper getPrice1997();

    public abstract FilterParameterWrapper getPrice1996();

    public abstract Long getLimit();

    public abstract void setLimit(Long limit);

    public abstract String getOrderBy();

    public abstract boolean isSortAsc();

    public abstract void setOrderBy(String orderBy);

    public abstract void setSortAsc(boolean sortAsc);

    public abstract String getSortType();

    public abstract void setSortType(String sortType);

    public abstract FilterParameterWrapper getBrand();

    public abstract FilterParameterWrapper getCakeIngredient();

    public abstract FilterParameterWrapper getCakeUse();

    public abstract FilterParameterWrapper getCandyIngredient();

    public abstract FilterParameterWrapper getCookieIngredient();

    public abstract FilterParameterWrapper getCookieUse();

    public abstract FilterParameterWrapper getDayPartCategory();

    public abstract FilterParameterWrapper getDessertDoughCrustIngred();

    public abstract FilterParameterWrapper getFruitOrFruitFillingIngred();

    public abstract FilterParameterWrapper getNutIngredient();

    public abstract FilterParameterWrapper getPrimaryFlavor();

    public abstract FilterParameterWrapper getSyrupTopping();

    public abstract FilterParameterWrapper getTasteFlavorWords();

    public abstract FilterParameterWrapper getWhippedToppingIngred();

    public abstract FilterParameterWrapper getIceCreamIngredient();

    public abstract FilterParameterWrapper getBreadUse();

    public abstract FilterParameterWrapper getCarboMM();
    
    public abstract FilterParameterWrapper getCarboAll();

    public abstract FilterParameterWrapper getFlavApplication();

    public abstract FilterParameterWrapper getFlavorSoup();

    public abstract FilterParameterWrapper getSideOrAccomp();

    public abstract FilterParameterWrapper getVeggieFruitMM();

    public abstract FilterParameterWrapper getHealthyTerm();

    public abstract FilterParameterWrapper getBatterBreadingCoating();

    public abstract FilterParameterWrapper getBreadWrapChips();

    public abstract FilterParameterWrapper getButterApplication();

    public abstract FilterParameterWrapper getCarboAccompName();

    public abstract FilterParameterWrapper getCarboTopName();

    public abstract FilterParameterWrapper getCarboType();

    public abstract FilterParameterWrapper getCheeseCheeseSauceFillingType();

    public abstract FilterParameterWrapper getCheeseRollUp();

    public abstract FilterParameterWrapper getCondiments();

    public abstract FilterParameterWrapper getCookingSauceOrGravy();

    public abstract FilterParameterWrapper getDipSauceName();

    public abstract FilterParameterWrapper getDairyButterCream();
    
    public abstract FilterParameterWrapper getOnionScallionLeek();
    
    public abstract FilterParameterWrapper getMushroomType();
    
    public abstract FilterParameterWrapper getTomatoType();
    
    public abstract FilterParameterWrapper getDressings();

    public abstract FilterParameterWrapper getFruitType();

    public abstract FilterParameterWrapper getGlaze();

    public abstract FilterParameterWrapper getGreenVegName();

    public abstract FilterParameterWrapper getMarinade();

    public abstract FilterParameterWrapper getProteinAccompName();

    public abstract FilterParameterWrapper getProteinTopName();

    public abstract FilterParameterWrapper getSeasoningName();

    public abstract FilterParameterWrapper getStuffName();

    public abstract FilterParameterWrapper getVegAccompName();

    public abstract FilterParameterWrapper getVeggieFruitType();

    public abstract FilterParameterWrapper getVegTopName();

    public abstract FilterParameterWrapper getBevSize();

    public abstract FilterParameterWrapper getBreakCakeWaff();

    public abstract FilterParameterWrapper getBreakfastPastry();

    public abstract FilterParameterWrapper getEggType();

    public abstract FilterParameterWrapper getHotColdCereal();

    public abstract FilterParameterWrapper getLogoImageStyle();

    public abstract FilterParameterWrapper getServingCount();

    public abstract FilterParameterWrapper getSpreadType();

    /*
     * 2006-01-17 RSC
     */
    public abstract FilterParameterWrapper getProteinFishShrimpSeafood();

    /*
     * 2006-02-06 RSC
     */
    public FilterParameterWrapper getCountryLoc();

    public FilterParameterWrapper getHqRegion();

    public FilterParameterWrapper getHqState();

    public FilterParameterWrapper getOperationName();

    public FilterParameterWrapper getOperatorType();

    public FilterParameterWrapper getSectorName();

    public FilterParameterWrapper getSegment();

    public FilterParameterWrapper getYearPutInDatabase();

    public FilterParameterWrapper getYearPutInDatabaseSameStore();

    public FilterParameterWrapper getChainID();

    /*
     * 2006-04-20 RSC
     */
    public FilterParameterWrapper getOtherIngredName();

    public FilterParameterWrapper getOtherToppings();

    public FilterParameterWrapper getOtherTopIngred();

    public FilterParameterWrapper getOtherAccompaniments();

    public FilterParameterWrapper getHealthyFlag();

    public FilterParameterWrapper getHealthySymbol();

    public FilterParameterWrapper getFillingSaucesDressings();

    /*
     * 2006-08-02 RSC Types & Uses
     */
    public FilterParameterWrapper getCuisineVerySpecific();

    public FilterParameterWrapper getGrillRoastSmoke();

    public FilterParameterWrapper getVegCookMeth();

    public FilterParameterWrapper getCookSauceType();

    public FilterParameterWrapper getDressingType();

    public FilterParameterWrapper getDressingFlavor();

    public FilterParameterWrapper getMexBreadType();

    public FilterParameterWrapper getRoastVegItemType();

    public FilterParameterWrapper getAppetClassTyp();

    public FilterParameterWrapper getPrepEntreeType();

    public FilterParameterWrapper getBreadedFriedAppSide();

    public FilterParameterWrapper getPotatoTypeUse();

    public FilterParameterWrapper getSalsaType();

    public FilterParameterWrapper getCookieLookAlikeDessert();

    public FilterParameterWrapper getBreakfastToGo();

    public FilterParameterWrapper getPizzaStyle();

    public FilterParameterWrapper getBbqCook();

    public FilterParameterWrapper getEthnicBreadType();

    public FilterParameterWrapper getPepperType();

    public FilterParameterWrapper getRiceTypeUse();

    public FilterParameterWrapper getMexIngredUse();

    public FilterParameterWrapper getFlavorChangeAnyYear();
    
    public FilterParameterWrapper getNewItemBrag();

    public FilterParameterWrapper getProteinFlavorApp();

    public FilterParameterWrapper getOilTypeUse();    
    
    public FilterParameterWrapper getEggItemUse();

    public FilterParameterWrapper getCheeseForm();

    public FilterParameterWrapper getCheeseSauceFillingType();      
    
    /*
     * 2006-09-06
     */
    public FilterParameterWrapper getSoupWith();

    public FilterParameterWrapper getSoupBaseBroth();


    /*
     * 2006-11-07
     */
    public FilterParameterWrapper getVeggieAll();

    public FilterParameterWrapper getAllVegCarbFruit();
    
    
    
    public FilterParameterWrapper getTextureAttrib();
    
    public FilterParameterWrapper getCreamyFill();
    
    public FilterParameterWrapper getCreamyTop();
    
    public FilterParameterWrapper getBevMenuItem();
    
    public FilterParameterWrapper getSideAccompDisFlavor();
    
    public FilterParameterWrapper getCookieTypeSource();
    
    public FilterParameterWrapper getQualityStyle();
}