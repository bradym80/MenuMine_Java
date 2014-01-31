/*
 * Created on Jun 20, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine;

import java.util.Collection;
import java.util.Set;

import com.fsrin.menumine.common.FilterParameter;
import com.fsrin.menumine.core.minefields.MineFields;

/**
 * @author Nick
 * 
 * Since we have so many params Rather then map each one, to hiberante, I use
 * the public Set getFilterParameters() in the imple the set a collection then
 * we use the Ognl to finish populating the individual fields.
 * 
 * 2006-03-16 RSC added the clonable.
 * 
 */
public interface MasterFoodFilterParameters extends Cloneable {
    public abstract Long getLimit();

    public abstract void setLimit(Long limit);

    public abstract String getOrderBy();

    public abstract void setOrderBy(String orderBy);

    public abstract boolean isSortAsc();

    public abstract void setSortAsc(boolean sortAsc);

    /*
     * 2006-02-06 RSC Removing.
     */
    // public abstract ChainFilterParameters getChain();
    /*
     * 2006-01-21 RSC Empty implementations.
     */
    // public abstract int getCountLikeParameters();
    // public abstract int getCountInParameters();
    public abstract String toString();

    /*
     * Requirement: We need to be able to display a summary of the last query
     * run. Need to only show fields that have data we don't want to overload on
     * data and make it waste space and be useless.
     * 
     * If needed this could produce all fields, and filter it on the view,
     * Probably will not need it.
     * 
     */public abstract Collection getSummary(MineFields mineFields);

    public abstract Collection getSummary();

    public abstract FilterParameter getKeywords();

    public abstract FilterParameter getBasicProtein();

    public abstract FilterParameter getBreadBakeGoodsMM();

    public abstract FilterParameter getCarboVegFruit();

    public abstract FilterParameter getCheeseMM();

    public abstract FilterParameter getCookMeth();

    public abstract FilterParameter getCuisine();

    public abstract FilterParameter getCuisineFamily();

    public abstract FilterParameter getFlavEnhancSeasBrdgDesIngredMM();

    public abstract FilterParameter getGenCookMeth();

    public abstract FilterParameter getGenMenuPart();

    public abstract FilterParameter getItemDescription();

    public abstract FilterParameter getMenuItem();

    public abstract FilterParameter getMenuItemClass();

    public abstract FilterParameter getMenuItemType();

    public abstract FilterParameter getMenuStatus();

    // 2009-06-01 MJB added the 9 protein fields below.
    public abstract FilterParameter getProteinTypeCut();
    
    public abstract FilterParameter getChickenType();
    
    public abstract FilterParameter getBeefType();
    
    public abstract FilterParameter getPorkType();
    
    public abstract FilterParameter getFishType();
    
    public abstract FilterParameter getSeafoodType();
    
    public abstract FilterParameter getLambType();
    
    public abstract FilterParameter getTurkeyType();
    
    public abstract FilterParameter getOtherProteinType();
    
    public abstract FilterParameter getShrimpType();
    
    public abstract FilterParameter getSauceCondDressMarMM();

    public abstract FilterParameter getTopFillIngredMM();

    public abstract void setBasicProtein(FilterParameter basicProtein);

    public abstract void setBreadBakeGoodsMM(FilterParameter breadBakeGoodsMM);
    
    public abstract void setCarboVegFruit(FilterParameter carboVegFruit);

    // public abstract void setChain(ChainFilterParameters
    // chainFilterParameters);

    public abstract void setCheeseMM(FilterParameter cheeseMM);

    public abstract void setCookMeth(FilterParameter cookMeth);

    public abstract void setCuisine(FilterParameter cuisine);

    public abstract void setCuisineFamily(FilterParameter cuisineFamily);

    public abstract void setFlavEnhancSeasBrdgDesIngredMM(
            FilterParameter flavEnhancSeasBrdgDesIngredMM);

    public abstract void setGenCookMeth(FilterParameter genCookMeth);

    public abstract void setGenMenuPart(FilterParameter genMenuPart);

    public abstract void setItemDescription(FilterParameter itemDescription);

    public abstract void setMenuItem(FilterParameter menuItem);

    public abstract void setMenuItemClass(FilterParameter menuItemClass);

    public abstract void setMenuItemType(FilterParameter menuItemType);

    public abstract void setMenuStatus(FilterParameter menuStatus);

    public abstract void setProteinTypeCut(FilterParameter proteinTypeCut);
    
    // 2009-06-01 MJB added 9 protein types below.    
    public abstract void setChickenType(FilterParameter chickenType);
    
    public abstract void setBeefType(FilterParameter beefType);
    
    public abstract void setPorkType(FilterParameter porkType);
    
    public abstract void setFishType(FilterParameter fishType);
    
    public abstract void setSeafoodType(FilterParameter seafoodType);
    
    public abstract void setLambType(FilterParameter lambType);
    
    public abstract void setTurkeyType(FilterParameter turkeyType);
    
    public abstract void setOtherProteinType(FilterParameter otherProteinType);
    
    public abstract void setShrimpType(FilterParameter shrimpType);

    public abstract void setSauceCondDressMarMM(
            FilterParameter sauceCondDressMarMM);

    public abstract void setTopFillIngredMM(FilterParameter topFillIngredMM);

    public abstract Collection getAll();

    /*
     * 2006-01-21 RSC
     */
    public abstract Collection getAllWithCriteria();

    public abstract Collection getAllPricing();

    public abstract String getName();

    public abstract void setName(String name);

    public abstract FilterParameter getPrice1996();

    public abstract void setPrice1996(FilterParameter price1996);

    public abstract FilterParameter getPrice1997();

    public abstract void setPrice1997(FilterParameter price1997);

    public abstract FilterParameter getPrice1998();

    public abstract void setPrice1998(FilterParameter price1998);

    public abstract FilterParameter getPrice1999();

    public abstract void setPrice1999(FilterParameter price1999);

    public abstract FilterParameter getPrice2000();

    public abstract void setPrice2000(FilterParameter price2000);

    public abstract FilterParameter getPrice2001();

    public abstract void setPrice2001(FilterParameter price2001);

    public abstract FilterParameter getPrice2002();

    public abstract void setPrice2002(FilterParameter price2002);

    public abstract FilterParameter getPrice2003();

    public abstract void setPrice2003(FilterParameter price2003);

    public abstract FilterParameter getPrice2004();

    public abstract void setPrice2004(FilterParameter price2004);

    public abstract FilterParameter getPrice2005();

    public abstract void setPrice2005(FilterParameter price2005);

    public abstract FilterParameter getPrice2006();

    public abstract void setPrice2006(FilterParameter price2006);
    
    //JDL 10-5-07
    public abstract FilterParameter getPrice2007();

    public abstract void setPrice2007(FilterParameter price2007);
    
    // DBB 1-20-2009 Add 2008, 2009
    public abstract FilterParameter getPrice2008();

    public abstract void setPrice2008(FilterParameter price2008);
    
    public abstract FilterParameter getPrice2009();

    public abstract void setPrice2009(FilterParameter price2009);
    
    // MJB 11-12-2009 Added 2010
    public abstract FilterParameter getPrice2010();

    public abstract void setPrice2010(FilterParameter price2010);
    
    public abstract FilterParameter getPrice2011();

    public abstract void setPrice2011(FilterParameter price2011);

    public abstract void setFilterParameters(Set col);

    public abstract Set getFilterParameters();

    public abstract Long getId();

    public abstract void setId(Long id);

    public abstract Long getFirstResult();

    public abstract void setFirstResult(Long firstResult);

    public abstract FilterParameter getBrand();

    public abstract void setBrand(FilterParameter brand);

    public abstract FilterParameter getCakeIngredient();

    public abstract void setCakeIngredient(FilterParameter cakeIngredient);

    public abstract FilterParameter getCakeUse();

    public abstract void setCakeUse(FilterParameter cakeUse);

    public abstract FilterParameter getCandyIngredient();

    public abstract void setCandyIngredient(FilterParameter candyIngredient);

    // public abstract ChainFilterParameters getChainFilterParameters();

    // public abstract void setChainFilterParameters(
    // ChainFilterParameters chainFilterParameters);

    public abstract FilterParameter getCookieIngredient();

    public abstract void setCookieIngredient(FilterParameter cookieIngredient);

    public abstract FilterParameter getCookieUse();

    public abstract void setCookieUse(FilterParameter cookieUse);

    public abstract FilterParameter getDayPartCategory();

    public abstract void setDayPartCategory(FilterParameter dayPartCategory);

    public abstract FilterParameter getDessertDoughCrustIngred();

    public abstract void setDessertDoughCrustIngred(
            FilterParameter dessertDoughCrustIngred);

    public abstract FilterParameter getFruitOrFruitFillingIngred();

    public abstract void setFruitOrFruitFillingIngred(
            FilterParameter fruitOrFruitFillingIngred);

    public abstract FilterParameter getIceCreamIngredient();

    public abstract void setIceCreamIngredient(
            FilterParameter iceCreamIngredient);

    public abstract FilterParameter getNutIngredient();

    public abstract void setNutIngredient(FilterParameter nutIngredient);

    public abstract FilterParameter getPrimaryFlavor();

    public abstract void setPrimaryFlavor(FilterParameter primaryFlavor);

    public abstract FilterParameter getSyrupTopping();

    public abstract void setSyrupTopping(FilterParameter syrupTopping);

    public abstract FilterParameter getTasteFlavorWords();

    public abstract void setTasteFlavorWords(FilterParameter tasteFlavorWords);

    public abstract FilterParameter getWhippedToppingIngred();

    public abstract void setWhippedToppingIngred(
            FilterParameter whippedToppingIngred);

    public void applyMasterFoodFilterParameters(
            MasterFoodFilterParameters newParams);

    public abstract FilterParameter getBreadUse();

    public abstract void setBreadUse(FilterParameter breadUse);

    public abstract FilterParameter getCarboMM();

    public abstract void setCarboMM(FilterParameter carboMM);
    
    public abstract FilterParameter getCarboAll();

    public abstract void setCarboAll(FilterParameter carboAll);

    public abstract FilterParameter getFlavApplication();

    public abstract void setFlavApplication(FilterParameter flavApplication);

    public abstract FilterParameter getFlavorSoup();

    public abstract void setFlavorSoup(FilterParameter flavorSoup);

    public abstract FilterParameter getSideOrAccomp();

    public abstract void setSideOrAccomp(FilterParameter sideOrAccomp);

    public abstract FilterParameter getVeggieFruitMM();

    public abstract void setVeggieFruitMM(FilterParameter veggieFruitMM);

    public abstract FilterParameter getHealthyTerm();

    public abstract void setHealthyTerm(FilterParameter healthyTerm);

    public abstract FilterParameter getBatterBreadingCoating();

    public abstract void setBatterBreadingCoating(
            FilterParameter batterBreadingCoating);

    public abstract FilterParameter getBreadWrapChips();

    public abstract void setBreadWrapChips(FilterParameter breadWrapChips);

    public abstract FilterParameter getButterApplication();

    public abstract void setButterApplication(FilterParameter butterApplication);

    public abstract FilterParameter getCarboAccompName();

    public abstract void setCarboAccompName(FilterParameter carboAccompName);

    public abstract FilterParameter getCarboTopName();

    public abstract void setCarboTopName(FilterParameter carboTopName);

    public abstract FilterParameter getCarboType();

    public abstract void setCarboType(FilterParameter carboType);

    public abstract FilterParameter getCheeseCheeseSauceFillingType();

    public abstract void setCheeseCheeseSauceFillingType(
            FilterParameter cheeseCheeseSauceFillingType);

    public abstract FilterParameter getCheeseRollUp();

    public abstract void setCheeseRollUp(FilterParameter cheeseRollUp);

    public abstract FilterParameter getCondiments();

    public abstract void setCondiments(FilterParameter condiments);

    public abstract FilterParameter getCookingSauceOrGravy();

    public abstract void setCookingSauceOrGravy(
            FilterParameter cookingSauceOrGravy);

    public abstract FilterParameter getDipSauceName();

    public abstract void setDipSauceName(FilterParameter dipSauceName);

    public abstract FilterParameter getDressings();

    public abstract void setDressings(FilterParameter dressings);

    public abstract FilterParameter getFruitType();

    public abstract void setFruitType(FilterParameter fruitType);

    public abstract FilterParameter getGlaze();

    public abstract void setGlaze(FilterParameter glaze);

    public abstract FilterParameter getGreenVegName();

    public abstract void setGreenVegName(FilterParameter greenVegName);

    public abstract FilterParameter getMarinade();

    public abstract void setMarinade(FilterParameter marinade);

    public abstract FilterParameter getProteinAccompName();

    public abstract void setProteinAccompName(FilterParameter proteinAccompName);

    public abstract FilterParameter getProteinTopName();

    public abstract void setProteinTopName(FilterParameter proteinTopName);

    public abstract FilterParameter getSeasoningName();

    public abstract void setSeasoningName(FilterParameter seasoningName);

    public abstract FilterParameter getStuffName();

    public abstract void setStuffName(FilterParameter stuffName);

    public abstract FilterParameter getVegAccompName();

    public abstract void setVegAccompName(FilterParameter vegAccompName);

    public abstract FilterParameter getVeggieFruitType();

    public abstract void setVeggieFruitType(FilterParameter veggieFruitType);

    public abstract FilterParameter getVegTopName();

    public abstract void setVegTopName(FilterParameter vegTopName);

    public abstract FilterParameter getBevSize();

    public abstract void setBevSize(FilterParameter bevSize);

    public abstract FilterParameter getBreakCakeWaff();

    public abstract void setBreakCakeWaff(FilterParameter breakCakeWaff);

    public abstract FilterParameter getBreakfastPastry();

    public abstract void setBreakfastPastry(FilterParameter breakfastPastry);

    public abstract FilterParameter getEggType();

    public abstract void setEggType(FilterParameter eggType);

    public abstract FilterParameter getHotColdCereal();

    public abstract void setHotColdCereal(FilterParameter hotColdCereal);

    public abstract FilterParameter getLogoImageStyle();

    public abstract void setLogoImageStyle(FilterParameter logoImageStyle);

    public abstract FilterParameter getServingCount();

    public abstract void setServingCount(FilterParameter servingCount);

    public abstract FilterParameter getSpreadType();

    public abstract void setSpreadType(FilterParameter spreadType);

    
    
    /**
     * @return Returns the proteinFishShrimpSeafood.
     */
    public abstract FilterParameter getProteinFishShrimpSeafood();

    /**
     * @param proteinFishShrimpSeafood
     *            The proteinFishShrimpSeafood to set.
     */
    public abstract void setProteinFishShrimpSeafood(
            FilterParameter proteinFishShrimpSeafood);

    /*
     * 2006-01-31 RSC
     */
    public FilterParameter getCountryLoc();

    public void setCountryLoc(FilterParameter countryLoc);

    public FilterParameter getHqRegion();

    public void setHqRegion(FilterParameter hqRegion);

    public FilterParameter getHqState();

    public void setHqState(FilterParameter hqState);

    public FilterParameter getOperationName();

    public void setOperationName(FilterParameter operationName);

    public FilterParameter getOperatorType();

    public void setOperatorType(FilterParameter operatorType);

    public FilterParameter getSectorName();

    public void setSectorName(FilterParameter sectorName);

    public FilterParameter getSegment();

    public void setSegment(FilterParameter segment);

    public FilterParameter getYearPutInDatabase();

    public void setYearPutInDatabase(FilterParameter yearPutInDatabase);

    public FilterParameter getChainID();

    public void setChainID(FilterParameter chainID);

    public MasterFoodFilterParameters clone();

    public FilterParameter getYearPutInDatabaseSameStore();

    public void setYearPutInDatabaseSameStore(
            FilterParameter yearPutInDatabaseSameStore);

    /*
     * 2006-04-20 RSC Profiler Related fields
     */
    public FilterParameter getHealthyFlag();

    public void setHealthyFlag(FilterParameter healthyFlag);

    public FilterParameter getHealthySymbol();

    public void setHealthySymbol(FilterParameter healthySymbol);

    public FilterParameter getOtherAccompaniments();

    public void setOtherAccompaniments(FilterParameter otherAccompaniments);

    public FilterParameter getOtherIngredName();

    public void setOtherIngredName(FilterParameter otherIngredName);

    public FilterParameter getOtherTopIngred();

    public void setOtherTopIngred(FilterParameter otherTopIngred);

    public FilterParameter getOtherToppings();

    public void setOtherToppings(FilterParameter otherToppings);

    public FilterParameter getFillingSaucesDressings();

    public void setFillingSaucesDressings(FilterParameter fillingSaucesDressings);

    /*
     * 2006-08-02 types and uses reid@fivesticks.com
     */
    public FilterParameter getCuisineVerySpecific();

    public void setCuisineVerySpecific(FilterParameter filterParameter);
    
    public FilterParameter getGrillRoastSmoke();

    public void setGrillRoastSmoke(FilterParameter filterParameter);

    public FilterParameter getVegCookMeth();

    public void setVegCookMeth(FilterParameter filterParameter);

    public FilterParameter getCookSauceType();

    public void setCookSauceType(FilterParameter filterParameter);

    public FilterParameter getDressingType();

    public void setDressingType(FilterParameter filterParameter);

    public FilterParameter getDressingFlavor();

    public void setDressingFlavor(FilterParameter filterParameter);

    public FilterParameter getMexBreadType();

    public void setMexBreadType(FilterParameter filterParameter);

    public FilterParameter getRoastVegItemType();

    public void setRoastVegItemType(FilterParameter filterParameter);

    public FilterParameter getAppetClassTyp();

    public void setAppetClassTyp(FilterParameter filterParameter);

    public FilterParameter getPrepEntreeType();

    public void setPrepEntreeType(FilterParameter filterParameter);

    public FilterParameter getBreadedFriedAppSide();

    public void setBreadedFriedAppSide(FilterParameter filterParameter);

    public FilterParameter getPotatoTypeUse();

    public void setPotatoTypeUse(FilterParameter filterParameter);

    public FilterParameter getSalsaType();

    public void setSalsaType(FilterParameter filterParameter);

    public FilterParameter getCookieLookAlikeDessert();

    public void setCookieLookAlikeDessert(FilterParameter filterParameter);

    public FilterParameter getBreakfastToGo();

    public void setBreakfastToGo(FilterParameter filterParameter);

    public FilterParameter getPizzaStyle();

    public void setPizzaStyle(FilterParameter filterParameter);

    public FilterParameter getBbqCook();

    public void setBbqCook(FilterParameter filterParameter);

    public FilterParameter getEthnicBreadType();

    public void setEthnicBreadType(FilterParameter filterParameter);

    public FilterParameter getPepperType();

    public void setPepperType(FilterParameter filterParameter);

    public FilterParameter getRiceTypeUse();

    public void setRiceTypeUse(FilterParameter filterParameter);

    public FilterParameter getMexIngredUse();

    public void setMexIngredUse(FilterParameter filterParameter);

    public FilterParameter getFlavorChangeAnyYear();

    public void setFlavorChangeAnyYear(FilterParameter filterParameter);

    
    
    
    
    public FilterParameter getNewItemBrag();

    public void setNewItemBrag(FilterParameter filterParameter);

    public FilterParameter getProteinFlavorApp();

    public void setProteinFlavorApp(FilterParameter filterParameter);

    public FilterParameter getOilTypeUse();

    public void setOilTypeUse(FilterParameter filterParameter);
    

    public FilterParameter getEggItemUse();

    public void setEggItemUse(FilterParameter filterParameter);

    public FilterParameter getCheeseForm();

    public void setCheeseForm(FilterParameter filterParameter);

    public FilterParameter getCheeseSauceFillingType();

    public void setCheeseSauceFillingType(FilterParameter filterParameter);

    
    /*
     * 2006-09-06
     */
    public FilterParameter getSoupWith();

    public void setSoupWith(FilterParameter filterParameter);

    public FilterParameter getSoupBaseBroth();

    public void setSoupBaseBroth(FilterParameter filterParameter);

    
    /*
     *  7-25-07 JDL
     */
    public FilterParameter getBevMenuItem();

    public void setBevMenuItem(FilterParameter filterParameter);
    
    public FilterParameter getSideAccompDisFlavor();

    public void setSideAccompDisFlavor(FilterParameter filterParameter);
    
    public FilterParameter getCookieTypeSource();

    public void setCookieTypeSource(FilterParameter filterParameter);
    
    public FilterParameter getCreamyTop();

    public void setCreamyTop(FilterParameter filterParameter);
    
    public FilterParameter getCreamyFill();

    public void setCreamyFill(FilterParameter filterParameter);
    
    public FilterParameter getTextureAttrib();

    public void setTextureAttrib(FilterParameter filterParameter);
    
    public FilterParameter getQualityStyle();

    public void setQualityStyle(FilterParameter filterParameter);    

   //End JDL
    
    /*
     * 2006-11-07
     */
    public FilterParameter getVeggieAll();

    public void setVeggieAll(FilterParameter filterParameter);

    public FilterParameter getAllVegCarbFruit();

    public void setAllVegCarbFruit(FilterParameter filterParameter);

	public abstract FilterParameter getDairyButterCream();

	public abstract void setDairyButterCream(FilterParameter dairyButterCream);
	
	public abstract FilterParameter getOnionScallionLeek();

	public abstract void setOnionScallionLeek(FilterParameter onionScallionLeek);
	
	public abstract FilterParameter getMushroomType();
	
	public abstract void setMushroomType(FilterParameter mushroomType);
	
	public abstract FilterParameter getTomatoType();
	
	public abstract void setTomatoType(FilterParameter tomatoType);

	
	   
        
    
}