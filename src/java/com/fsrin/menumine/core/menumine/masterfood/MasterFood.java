/*
 * Created on Jan 17, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.masterfood;

import java.io.Serializable;

import com.fsrin.menumine.core.menumine.chain.AbstractChainInformationBean;
import com.fsrin.menumine.core.menumine.chain.Chain;

/**
 * @author Nick
 * 
 * 
 */
public class MasterFood extends AbstractChainInformationBean implements
        Serializable {

    private Long id;

    private String keywords;

    private String chainName;

    private Integer chainID;

    // private String sectorName;
    //    
    // private String segment;
    //    
    // private String operationName;
    //    

    /*
     * 2006-04-18 RSC this is from chain but is for same store queries.
     */
    private Integer yearPutInDatabase;

    private Integer yearPutInDatabaseSameStore;

    //    
    // private String hqState;
    //    
    // private String hqRegion;
    //    
    // private String operatorType;
    //    
    // private String countryLoc;

    // 2006-01-30 RSC Switchin to a rich chain format.
    // private Chain chain;

    private String basicProtein;

    private String proteinTypeCut;
    
    // 2009-07-10 MJB added the 4 fields below.
    
    private String dairyButterCream;
    
    private String onionScallionLeek;
    
    private String mushroomType;
    
    private String tomatoType;
    
    // 2009-06-01 MJB added the 9 protein types below.
    private String beefType;
    
    private String chickenType;
    
    private String porkType;
    
    private String fishType;
    
    private String seafoodType;
    
    private String lambType;
    
    private String turkeyType;
    
    private String otherProteinType;
    
    private String shrimpType;

    private String proteinType;

    private String cookMeth;

    private String sauceCondDressMarMM;

    private String flavEnhancSeasBrdgDesIngredMM;

    private String carboVegFruit;

    private String topFillIngredMM;

    private String cheeseMM;

    private String breadBakeGoodsMM;

    private String menuItem;

    private String menuItemType;

    private String itemDescription;

    private String cuisine;

    private String cuisineFamily;

    private String genCookMeth;

    private String genMenuPart;

    private String menuItemClass;

    private String menuStatus;
    
    // MJB  ADDED 2011
    private Double price2011;
    private Double price2010;
    // DBB 1-20-2009 Add 2008, 2009
    private Double price2009;
    
    private Double price2008;
    
    //JDL 10-5-07 jdlFloat
    private Double price2007;

    private Double price2006;

    private Double price2005;

    private Double price2004;

    private Double price2003;

    private Double price2002;

    private Double price2001;

    private Double price2000;

    private Double price1999;

    private Double price1998;

    private Double price1997;

    private Double price1996;

    /*
     * Fields added for dessertmine.
     */
    private String dayPartCategory;

    private String cakeIngredient;

    private String cakeUse;

    private String cookieIngredient;

    private String cookieUse;

    private String dessertDoughCrustIngred;

    private String iceCreamIngredient;

    private String syrupTopping;

    private String nutIngredient;

    private String fruitOrFruitFillingIngred;

    private String whippedToppingIngred;

    private String candyIngredient;

    private String primaryFlavor;

    private String tasteFlavorWords;

    private String brand;

    /*
     * Nick 2005-6-23 New Fields!
     */
    private String veggieFruitMM;

    private String carboMM;
    
    private String carboAll;

    private String breadUse;

    private String flavApplication;

    private String flavorSoup;

    private String sideOrAccomp;

    private String healthyTerm;

    /*
     * Nick 2005-8-8 The following field have been added for ingredient mine
     */
    private String cookingSauceOrGravy;

    private String marinade;

    private String glaze;

    private String dressings;

    private String dipSauceName;

    private String condiments;

    private String butterApplication;

    private String seasoningName;

    private String batterBreadingCoating;

    private String stuffName;

    private String cheeseRollUp;

    private String cheeseCheeseSauceFillingType;

    private String proteinTopName;

    private String proteinAccompName;

    private String veggieFruitType;

    private String greenVegName;

    private String vegTopName;

    private String vegAccompName;

    private String fruitType;

    private String carboType;

    private String carboTopName;

    private String carboAccompName;

    private String breadWrapChips;

    /*
     * Fields added for Breakfast mine
     */
    private String eggType;

    private String hotColdCereal;

    private String spreadType;

    private String breakfastPastry;

    private String breakCakeWaff;

    /*
     * Fields added for Beverage mine
     */

    private String logoImageStyle;

    private String bevSize;

    private String servingCount;

    /*
     * 2006-01-17 RSC New Field.
     */
    private String proteinFishShrimpSeafood;

    /*
     * 2006-04-19 RSC
     */
    private String otherAccompaniments;

    private String otherIngredName;

    private String otherToppings;

    private String otherTopIngred;

    private String healthyFlag;

    private String healthySymbol;

    private String fillingSaucesDressings;

    private String cuisineVerySpecific;

    private String grillRoastSmoke;

    private String vegCookMeth;

    private String cookSauceType;

    private String dressingType;

    private String dressingFlavor;

    private String mexBreadType;

    private String roastVegItemType;

    private String appetClassTyp;

    private String prepEntreeType;

    private String breadedFriedAppSide;

    private String potatoTypeUse;

    private String salsaType;

    private String cookieLookAlikeDessert;

    private String breakfastToGo;

    private String pizzaStyle;

    private String bbqCook;

    private String ethnicBreadType;

    private String pepperType;

    private String riceTypeUse;

    private String mexIngredUse;

    private String flavorChangeAnyYear;

    
    
    
    
    private String newItemBrag;

    private String proteinFlavorApp;

    private String oilTypeUse;
    

    private String eggItemUse;

    private String cheeseForm;

    private String cheeseSauceFillingType;
    
    /*
     * 2006-09-06
     */
    
    private String soupWith;
    private String soupBaseBroth;
    
    /*
     * 7-25-2007 JDL added new 9 fields
     */
    
    private String bevMenuItem;
    private String sideAccompDisFlavor;
    private String cookieTypeSource;
    private String creamyTop;
    private String creamyFill;
    private String textureAttrib;
    private String qualityStyle;

	//End JDL
    
    /*
     * 2006-11-07
     */
    private String veggieAll;
    private String allVegCarbFruit; 
    
    
    public String getBasicProtein() {
        return basicProtein;
    }

    public void setBasicProtein(String basicProtein) {
        this.basicProtein = basicProtein;
    }

    public String getBreadBakeGoodsMM() {
        return breadBakeGoodsMM;
    }

    public void setBreadBakeGoodsMM(String breadBakeGoodsMM) {
        this.breadBakeGoodsMM = breadBakeGoodsMM;
    }

    public String getCarboVegFruit() {
        return carboVegFruit;
    }
    
    public void setCarboVegFruit(String carboVegFruit) {
        this.carboVegFruit = carboVegFruit;
    }
    

    // public String getChain() {
    // return chain;
    // }
    // public void setChain(String chain) {
    // this.chain = chain;
    // }
    // public int getChainID() {
    // return chainID;
    // }
    // public void setChainID(int chainID) {
    // this.chainID = chainID;
    // }
    public String getCheeseMM() {
        return cheeseMM;
    }

    public void setCheeseMM(String cheeseMM) {
        this.cheeseMM = cheeseMM;
    }

    public String getCookMeth() {
        return cookMeth;
    }

    public void setCookMeth(String cookMeth) {
        this.cookMeth = cookMeth;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public String getFlavEnhancSeasBrdgDesIngredMM() {
        return flavEnhancSeasBrdgDesIngredMM;
    }

    public void setFlavEnhancSeasBrdgDesIngredMM(
            String flavEnhancSeasBrdgDesIngredMM) {
        this.flavEnhancSeasBrdgDesIngredMM = flavEnhancSeasBrdgDesIngredMM;
    }

    public String getGenMenuPart() {
        return genMenuPart;
    }

    public void setGenMenuPart(String genMenuPart) {
        this.genMenuPart = genMenuPart;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(String menuItem) {
        this.menuItem = menuItem;
    }

    public String getMenuItemClass() {
        return menuItemClass;
    }

    public void setMenuItemClass(String menuItemClass) {
        this.menuItemClass = menuItemClass;
    }

    public String getMenuItemType() {
        return menuItemType;
    }

    public void setMenuItemType(String menuItemType) {
        this.menuItemType = menuItemType;
    }

    public String getMenuStatus() {
        return menuStatus;
    }

    public void setMenuStatus(String menuStatus) {
        this.menuStatus = menuStatus;
    }

    public Double getPrice1998() {
        return price1998;
    }

    public void setPrice1998(Double price1998) {
        this.price1998 = price1998;
    }

    public Double getPrice1999() {
        return price1999;
    }

    public void setPrice1999(Double price1999) {
        this.price1999 = price1999;
    }

    public Double getPrice2000() {
        return price2000;
    }

    public void setPrice2000(Double price2000) {
        this.price2000 = price2000;
    }

    public Double getPrice2001() {
        return price2001;
    }

    public void setPrice2001(Double price2001) {
        this.price2001 = price2001;
    }

    public Double getPrice2002() {
        return price2002;
    }

    public void setPrice2002(Double price2002) {
        this.price2002 = price2002;
    }

    public Double getPrice2003() {
        return price2003;
    }

    public void setPrice2003(Double price2003) {
        this.price2003 = price2003;
    }

    public Double getPrice2004() {
        return price2004;
    }

    public void setPrice2004(Double price2004) {
        this.price2004 = price2004;
    }

    public String getProteinType() {
        return proteinType;
    }

    public void setProteinType(String proteinType) {
        this.proteinType = proteinType;
    }

    public String getProteinTypeCut() {
        return proteinTypeCut;
    }

    public void setProteinTypeCut(String proteinTypeCut) {
        this.proteinTypeCut = proteinTypeCut;
    }
    
    /*2009-06-01 MJB added the 9 protein fields below. */
    public String getChickenType() {
        return chickenType;
    }

    public void setChickenType(String chickenType) {
        this.chickenType = chickenType;
    }
    
    public String getBeefType() {
        return beefType;
    }

    public void setBeefType(String beefType) {
        this.beefType = beefType;
    }
    
    public String getPorkType() {
        return porkType;
    }

    public void setPorkType(String porkType) {
        this.porkType = porkType;
    }
    
    public String getFishType() {
        return fishType;
    }

    public void setFishType(String fishType) {
        this.fishType = fishType;
    }
    
    public String getSeafoodType() {
        return seafoodType;
    }

    public void setSeafoodType(String seafoodType) {
        this.seafoodType = seafoodType;
    }
    
    public String getLambType() {
        return lambType;
    }

    public void setLambType(String lambType) {
        this.lambType = lambType;
    }
    
    public String getTurkeyType() {
        return turkeyType;
    }

    public void setTurkeyType(String turkeyType) {
        this.turkeyType = turkeyType;
    }
    
    public String getOtherProteinType() {
        return otherProteinType;
    }

    public void setOtherProteinType(String otherProteinType) {
        this.otherProteinType = otherProteinType;
    }

    public String getShrimpType() {
        return shrimpType;
    }

    public void setShrimpType(String shrimpType) {
        this.shrimpType = shrimpType;
    }

    public String getSauceCondDressMarMM() {
        return sauceCondDressMarMM;
    }

    public void setSauceCondDressMarMM(String sauceCondDressMarMM) {
        this.sauceCondDressMarMM = sauceCondDressMarMM;
    }

    public String getTopFillIngredMM() {
        return topFillIngredMM;
    }

    public void setTopFillIngredMM(String topFillIngredMM) {
        this.topFillIngredMM = topFillIngredMM;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Chain getChain() {
        throw new RuntimeException("Reid working on chains 2006-01-30");
        // if (chain == null) {
        //
        // try {
        // chain = ChainDao.factory.build().get(
        // new Long(786));
        // } catch (DAOException e) {
        //
        // e.printStackTrace();
        // }
        // }
        // return chain;
    }

    public void setChain(Chain chain) {
        // this.chain = chain;
    }

    public String getCuisineFamily() {
        return cuisineFamily;
    }

    public void setCuisineFamily(String cuisineFamily) {
        this.cuisineFamily = cuisineFamily;
    }

    public String getGenCookMeth() {
        return genCookMeth;
    }

    public void setGenCookMeth(String genCookingMethod) {
        this.genCookMeth = genCookingMethod;
    }

    public Integer getChainID() {
        return chainID;
    }

    public void setChainID(Integer chainID) {
        this.chainID = chainID;
    }

    public String getChainName() {
        return chainName;
    }

    public void setChainName(String chainName) {
        this.chainName = chainName;
    }

    public Double getPrice1996() {
        return price1996;
    }

    public void setPrice1996(Double price1996) {
        this.price1996 = price1996;
    }

    public Double getPrice1997() {
        return price1997;
    }

    public void setPrice1997(Double price1997) {
        this.price1997 = price1997;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCakeIngredient() {
        return cakeIngredient;
    }

    public void setCakeIngredient(String cakeIngredient) {
        this.cakeIngredient = cakeIngredient;
    }

    public String getCakeUse() {
        return cakeUse;
    }

    public void setCakeUse(String cakeUse) {
        this.cakeUse = cakeUse;
    }

    public String getCandyIngredient() {
        return candyIngredient;
    }

    public void setCandyIngredient(String candyIngredient) {
        this.candyIngredient = candyIngredient;
    }

    public String getDessertDoughCrustIngred() {
        return dessertDoughCrustIngred;
    }

    public void setDessertDoughCrustIngred(String dessertDoughCrustIngred) {
        this.dessertDoughCrustIngred = dessertDoughCrustIngred;
    }

    public String getCookieIngredient() {
        return cookieIngredient;
    }

    public void setCookieIngredient(String cookieIngredient) {
        this.cookieIngredient = cookieIngredient;
    }

    public String getCookieUse() {
        return cookieUse;
    }

    public void setCookieUse(String cookieUse) {
        this.cookieUse = cookieUse;
    }

    public String getDayPartCategory() {
        return dayPartCategory;
    }

    public void setDayPartCategory(String dayPartCategory) {
        this.dayPartCategory = dayPartCategory;
    }

    public String getFruitOrFruitFillingIngred() {
        return fruitOrFruitFillingIngred;
    }

    public void setFruitOrFruitFillingIngred(String fruitOrFruitFillingIngred) {
        this.fruitOrFruitFillingIngred = fruitOrFruitFillingIngred;
    }

    public String getIceCreamIngredient() {
        return iceCreamIngredient;
    }

    public void setIceCreamIngredient(String iceCreamIngredient) {
        this.iceCreamIngredient = iceCreamIngredient;
    }

    public String getNutIngredient() {
        return nutIngredient;
    }

    public void setNutIngredient(String nutIngredient) {
        this.nutIngredient = nutIngredient;
    }

    public String getPrimaryFlavor() {
        return primaryFlavor;
    }

    public void setPrimaryFlavor(String primaryFlavor) {
        this.primaryFlavor = primaryFlavor;
    }

    public String getSyrupTopping() {
        return syrupTopping;
    }

    public void setSyrupTopping(String syrupTopping) {
        this.syrupTopping = syrupTopping;
    }

    public String getTasteFlavorWords() {
        return tasteFlavorWords;
    }

    public void setTasteFlavorWords(String tasteFlavorWords) {
        this.tasteFlavorWords = tasteFlavorWords;
    }

    public String getWhippedToppingIngred() {
        return whippedToppingIngred;
    }

    public void setWhippedToppingIngred(String whippedToppingIngred) {
        this.whippedToppingIngred = whippedToppingIngred;
    }

    public String getBreadUse() {
        return breadUse;
    }

    public void setBreadUse(String breadUse) {
        this.breadUse = breadUse;
    }

    public String getCarboMM() {
        return carboMM;
    }

    public void setCarboMM(String carboMM) {
        this.carboMM = carboMM;
    }
    
    public String getCarboAll() {
        return carboAll;
    }

    public void setCarboAll(String carboAll) {
        this.carboAll = carboAll;
    }

    public String getFlavApplication() {
        return flavApplication;
    }

    public void setFlavApplication(String flavApplication) {
        this.flavApplication = flavApplication;
    }

    public String getFlavorSoup() {
        return flavorSoup;
    }

    public void setFlavorSoup(String flavorSoup) {
        this.flavorSoup = flavorSoup;
    }

    public String getSideOrAccomp() {
        return sideOrAccomp;
    }

    public void setSideOrAccomp(String sideOrAccomp) {
        this.sideOrAccomp = sideOrAccomp;
    }

    public String getVeggieFruitMM() {
        return veggieFruitMM;
    }

    public void setVeggieFruitMM(String veggieFruitMM) {
        this.veggieFruitMM = veggieFruitMM;
    }

    private boolean isOnMenu(Double price) {
        return price != null && price.longValue() > 0;
    }
    
    private boolean isOnMenu2(Float price) {
        return price != null && price.longValue() > 0;
    }
    
    // MJB 11-12-2009 added 2011
    public boolean isOnMenu2011() {
        return isOnMenu(this.getPrice2011());
    }
    
    // MJB 11-12-2009 added 2010
    public boolean isOnMenu2010() {
        return isOnMenu(this.getPrice2010());
    }
    // DBB 2-12-2009 Add 2008, 2009
    public boolean isOnMenu2009() {
        return isOnMenu(this.getPrice2009());
    }
    
    public boolean isOnMenu2008() {
        return isOnMenu(this.getPrice2008());
    }
    
    //JDL 10-5-07 jdlFloat
    public boolean isOnMenu2007() {
        return isOnMenu(this.getPrice2007());
    }

    public boolean isOnMenu2006() {
        return isOnMenu(this.getPrice2006());
    }
    
    public boolean isOnMenu2005() {
        return isOnMenu(this.getPrice2005());
    }

    public boolean isOnMenu2004() {
        return isOnMenu(this.getPrice2004());
    }

    public boolean isOnMenu2003() {
        return isOnMenu(this.getPrice2003());
    }

    public boolean isOnMenu2002() {
        return isOnMenu(this.getPrice2002());
    }

    public boolean isOnMenu2001() {
        return isOnMenu(this.getPrice2001());
    }

    public boolean isOnMenu2000() {
        return isOnMenu(this.getPrice2000());
    }

    public boolean isOnMenu1999() {
        return isOnMenu(this.getPrice1999());
    }

    public boolean isOnMenu1998() {
        return isOnMenu(this.getPrice1998());
    }

    public boolean isOnMenu1997() {
        return isOnMenu(this.getPrice1997());
    }

    public boolean isOnMenu1996() {
        return isOnMenu(this.getPrice1996());
    }

    public String getHealthyTerm() {
        return healthyTerm;
    }

    public void setHealthyTerm(String healthyTerm) {
        this.healthyTerm = healthyTerm;
    }

    /*
     * 2006-08-02 rsc updated from 2004 to 2006
     */
//    public Float getPriceCurrent() {
//
//        return this.getPrice2007();
//    }
    
    //JDL 10-5-07 jdlFloat
    //DBB 1-20-2009 Change to 2008
    //MJB 11-12-2009 changed to 2009
    //MJB 08-29-2011 changed to 2011
    public Double getPriceCurrent() {

        return this.getPrice2011();
    }

    /*
     * Nick 2005-8-8 The following field have been added for ingredient mine
     */
    public String getBatterBreadingCoating() {
        return batterBreadingCoating;
    }

    public void setBatterBreadingCoating(String batterBreadingCoating) {
        this.batterBreadingCoating = batterBreadingCoating;
    }

    public String getBreadWrapChips() {
        return breadWrapChips;
    }

    public void setBreadWrapChips(String breadWrapChips) {
        this.breadWrapChips = breadWrapChips;
    }

    public String getButterApplication() {
        return butterApplication;
    }

    public void setButterApplication(String butterApplication) {
        this.butterApplication = butterApplication;
    }

    public String getCarboAccompName() {
        return carboAccompName;
    }

    public void setCarboAccompName(String carboAccompName) {
        this.carboAccompName = carboAccompName;
    }

    public String getCarboTopName() {
        return carboTopName;
    }

    public void setCarboTopName(String carboTopName) {
        this.carboTopName = carboTopName;
    }

    public String getCarboType() {
        return carboType;
    }

    public void setCarboType(String carboType) {
        this.carboType = carboType;
    }

    public String getCheeseCheeseSauceFillingType() {
        return cheeseCheeseSauceFillingType;
    }

    public void setCheeseCheeseSauceFillingType(
            String cheeseCheeseSauceFillingType) {
        this.cheeseCheeseSauceFillingType = cheeseCheeseSauceFillingType;
    }

    public String getCheeseRollUp() {
        return cheeseRollUp;
    }

    public void setCheeseRollUp(String cheeseRollUp) {
        this.cheeseRollUp = cheeseRollUp;
    }

    public String getCondiments() {
        return condiments;
    }

    public void setCondiments(String condiments) {
        this.condiments = condiments;
    }

    public String getCookingSauceOrGravy() {
        return cookingSauceOrGravy;
    }

    public void setCookingSauceOrGravy(String cookingSauceOrGravy) {
        this.cookingSauceOrGravy = cookingSauceOrGravy;
    }

    public String getDipSauceName() {
        return dipSauceName;
    }

    public void setDipSauceName(String dipSauceName) {
        this.dipSauceName = dipSauceName;
    }

    public String getDairyButterCream() {
        return dairyButterCream;
    }

    public void setDairyButterCream(String dairyButterCream) {
        this.dairyButterCream = dairyButterCream;
    }
    
    public String getOnionScallionLeek() {
        return onionScallionLeek;
    }

    public void setOnionScallionLeek(String onionScallionLeek) {
        this.onionScallionLeek = onionScallionLeek;
    }

    public String getMushroomType() {
        return mushroomType;
    }

    public void setMushroomType(String mushroomType) {
        this.mushroomType = mushroomType;
    }
    
    public String getTomatoType() {
        return tomatoType;
    }

    public void setTomatoType(String tomatoType) {
        this.tomatoType = tomatoType;
    }
    
    public String getDressings() {
        return dressings;
    }

    public void setDressings(String dressings) {
        this.dressings = dressings;
    }

    public String getFruitType() {
        return fruitType;
    }

    public void setFruitType(String fruitType) {
        this.fruitType = fruitType;
    }

    public String getGlaze() {
        return glaze;
    }

    public void setGlaze(String glaze) {
        this.glaze = glaze;
    }

    public String getGreenVegName() {
        return greenVegName;
    }

    public void setGreenVegName(String greenVegName) {
        this.greenVegName = greenVegName;
    }

    public String getMarinade() {
        return marinade;
    }

    public void setMarinade(String marinade) {
        this.marinade = marinade;
    }

    public String getProteinAccompName() {
        return proteinAccompName;
    }

    public void setProteinAccompName(String proteinAccompName) {
        this.proteinAccompName = proteinAccompName;
    }

    public String getProteinTopName() {
        return proteinTopName;
    }

    public void setProteinTopName(String proteinTopName) {
        this.proteinTopName = proteinTopName;
    }

    public String getSeasoningName() {
        return seasoningName;
    }

    public void setSeasoningName(String seasoningName) {
        this.seasoningName = seasoningName;
    }

    public String getStuffName() {
        return stuffName;
    }

    public void setStuffName(String stuffName) {
        this.stuffName = stuffName;
    }

    public String getVegAccompName() {
        return vegAccompName;
    }

    public void setVegAccompName(String vegAccompName) {
        this.vegAccompName = vegAccompName;
    }

    public String getVeggieFruitType() {
        return veggieFruitType;
    }

    public void setVeggieFruitType(String veggieFruitType) {
        this.veggieFruitType = veggieFruitType;
    }

    public String getVegTopName() {
        return vegTopName;
    }

    public void setVegTopName(String vegTopName) {
        this.vegTopName = vegTopName;
    }

    public String getBreakCakeWaff() {
        return breakCakeWaff;
    }

    public void setBreakCakeWaff(String breakCakeWaff) {
        this.breakCakeWaff = breakCakeWaff;
    }

    public String getBreakfastPastry() {
        return breakfastPastry;
    }

    public void setBreakfastPastry(String breakfastPastry) {
        this.breakfastPastry = breakfastPastry;
    }

    public String getEggType() {
        return eggType;
    }

    public void setEggType(String eggType) {
        this.eggType = eggType;
    }

    public String getHotColdCereal() {
        return hotColdCereal;
    }

    public void setHotColdCereal(String hotColdCereal) {
        this.hotColdCereal = hotColdCereal;
    }

    public String getSpreadType() {
        return spreadType;
    }

    public void setSpreadType(String spreadType) {
        this.spreadType = spreadType;
    }

    // public String getAccompSideIngred() {
    // return accompSideIngred;
    // }
    // public void setAccompSideIngred(String accompSideIngred) {
    // this.accompSideIngred = accompSideIngred;
    // }
    public String getBevSize() {
        return bevSize;
    }

    public void setBevSize(String bevSize) {
        this.bevSize = bevSize;
    }

    public String getLogoImageStyle() {
        return logoImageStyle;
    }

    public void setLogoImageStyle(String logoImageStyle) {
        this.logoImageStyle = logoImageStyle;
    }

    public String getServingCount() {
        return servingCount;
    }

    public void setServingCount(String servingCount) {
        this.servingCount = servingCount;
    }

    public Double getPrice2005() {
        return price2005;
    }

    public void setPrice2005(Double price2005) {
        this.price2005 = price2005;
    }

    /**
     * @return Returns the proteinFishShrimpSeafood.
     */
    public String getProteinFishShrimpSeafood() {
        return proteinFishShrimpSeafood;
    }

    /**
     * @param proteinFishShrimpSeafood
     *            The proteinFishShrimpSeafood to set.
     */
    public void setProteinFishShrimpSeafood(String proteinFishShrimpSeafood) {
        this.proteinFishShrimpSeafood = proteinFishShrimpSeafood;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    // public String getSectorName() {
    // return sectorName;
    // }
    //
    // public void setSectorName(String chainSectorName) {
    // this.sectorName = chainSectorName;
    // }
    //
    // public String getSegment() {
    // return segment;
    // }
    //
    // public void setSegment(String chainSegment) {
    // this.segment = chainSegment;
    // }
    //
    // public String getOperationName() {
    // return operationName;
    // }
    //
    // public void setOperationName(String chainOperationName) {
    // this.operationName = chainOperationName;
    // }
    //
    // public String getCountryLoc() {
    // return countryLoc;
    // }
    //
    // public void setCountryLoc(String countryLoc) {
    // this.countryLoc = countryLoc;
    // }
    //
    // public String getHqRegion() {
    // return hqRegion;
    // }
    //
    // public void setHqRegion(String hqRegion) {
    // this.hqRegion = hqRegion;
    // }
    //
    // public String getHqState() {
    // return hqState;
    // }
    //
    // public void setHqState(String hqState) {
    // this.hqState = hqState;
    // }
    //
    // public String getOperatorType() {
    // return operatorType;
    // }
    //
    // public void setOperatorType(String operatorType) {
    // this.operatorType = operatorType;
    // }
    //
    public Integer getYearPutInDatabase() {
        return yearPutInDatabase;
    }

    public void setYearPutInDatabase(Integer yearPutInDatabase) {
        this.yearPutInDatabase = yearPutInDatabase;
    }

    public Integer getYearPutInDatabaseSameStore() {
        return yearPutInDatabaseSameStore;
    }

    public void setYearPutInDatabaseSameStore(Integer yearPutInDatabaseSameStore) {
        this.yearPutInDatabaseSameStore = yearPutInDatabaseSameStore;
    }

    public String getHealthyFlag() {
        return healthyFlag;
    }

    public void setHealthyFlag(String healthyFlag) {
        this.healthyFlag = healthyFlag;
    }

    public String getHealthySymbol() {
        return healthySymbol;
    }

    public void setHealthySymbol(String healthySymbol) {
        this.healthySymbol = healthySymbol;
    }

    public String getOtherAccompaniments() {
        return otherAccompaniments;
    }

    public void setOtherAccompaniments(String otherAccompaniments) {
        this.otherAccompaniments = otherAccompaniments;
    }

    public String getOtherIngredName() {
        return otherIngredName;
    }

    public void setOtherIngredName(String otherIngredName) {
        this.otherIngredName = otherIngredName;
    }

    public String getOtherTopIngred() {
        return otherTopIngred;
    }

    public void setOtherTopIngred(String otherTopIngred) {
        this.otherTopIngred = otherTopIngred;
    }

    public String getOtherToppings() {
        return otherToppings;
    }

    public void setOtherToppings(String otherToppings) {
        this.otherToppings = otherToppings;
    }

    public String getFillingSaucesDressings() {
        return fillingSaucesDressings;
    }

    public void setFillingSaucesDressings(String fillingSaucesDressings) {
        this.fillingSaucesDressings = fillingSaucesDressings;
    }

    /**
     * @return Returns the price2006.
     */
    public Double getPrice2006() {
        return price2006;
    }

    /**
     * @param price2006
     *            The price2006 to set.
     */
    public void setPrice2006(Double price2006) {
        this.price2006 = price2006;
    }
    //JDL 10-5-07 jdlFloat
    /**
     * @return Returns the price2007.
     */
    public Double getPrice2007() {
        return price2007;
    }

    /**
     * @param price2007
     *            The price2007 to set.
     */
    public void setPrice2007(Double price2007) {
        this.price2007 = price2007;
    }
    
    // Added 2011
    
    public Double getPrice2011() {
    	return this.price2011;
    }
    
    public void setPrice2011(Double price) {
    	this.price2011 = price;
    }
    // Added 2010
    
    public Double getPrice2010() {
    	return this.price2010;
    }
    
    public void setPrice2010(Double price) {
    	this.price2010 = price;
    }
    // DBB 1-20-2009 Add 2008, 2009
    
    public Double getPrice2008() {
    	return this.price2008;
    }
    
    public void setPrice2008(Double price) {
    	this.price2008 = price;
    }
    
    public Double getPrice2009() {
    	return this.price2009;
    }
    
    public void setPrice2009(Double price) {
    	this.price2009 = price;
    }

    public String getAppetClassTyp() {
        return appetClassTyp;
    }

    public void setAppetClassTyp(String appetClassTyp) {
        this.appetClassTyp = appetClassTyp;
    }

    public String getBbqCook() {
        return bbqCook;
    }

    public void setBbqCook(String bbqCook) {
        this.bbqCook = bbqCook;
    }

    public String getBreadedFriedAppSide() {
        return breadedFriedAppSide;
    }

    public void setBreadedFriedAppSide(String breadedFriedAppSide) {
        this.breadedFriedAppSide = breadedFriedAppSide;
    }

    public String getBreakfastToGo() {
        return breakfastToGo;
    }

    public void setBreakfastToGo(String breakfastToGo) {
        this.breakfastToGo = breakfastToGo;
    }

    public String getCookieLookAlikeDessert() {
        return cookieLookAlikeDessert;
    }

    public void setCookieLookAlikeDessert(String cookieLookAlikeDessert) {
        this.cookieLookAlikeDessert = cookieLookAlikeDessert;
    }

    public String getCookSauceType() {
        return cookSauceType;
    }

    public void setCookSauceType(String cookSauceType) {
        this.cookSauceType = cookSauceType;
    }

    public String getCuisineVerySpecific() {
        return cuisineVerySpecific;
    }

    public void setCuisineVerySpecific(String cuisineVerySpecific) {
        this.cuisineVerySpecific = cuisineVerySpecific;
    }

    public String getDressingFlavor() {
        return dressingFlavor;
    }

    public void setDressingFlavor(String dressingFlavor) {
        this.dressingFlavor = dressingFlavor;
    }

    public String getDressingType() {
        return dressingType;
    }

    public void setDressingType(String dressingType) {
        this.dressingType = dressingType;
    }

    public String getEthnicBreadType() {
        return ethnicBreadType;
    }

    public void setEthnicBreadType(String ethnicBreadType) {
        this.ethnicBreadType = ethnicBreadType;
    }

    public String getFlavorChangeAnyYear() {
        return flavorChangeAnyYear;
    }

    public void setFlavorChangeAnyYear(String flavorChangeAnyYear) {
        this.flavorChangeAnyYear = flavorChangeAnyYear;
    }

    public String getGrillRoastSmoke() {
        return grillRoastSmoke;
    }

    public void setGrillRoastSmoke(String grillRoastSmoke) {
        this.grillRoastSmoke = grillRoastSmoke;
    }

    public String getMexBreadType() {
        return mexBreadType;
    }

    public void setMexBreadType(String mexBreadType) {
        this.mexBreadType = mexBreadType;
    }

    public String getMexIngredUse() {
        return mexIngredUse;
    }

    public void setMexIngredUse(String mexIngredUse) {
        this.mexIngredUse = mexIngredUse;
    }

    public String getPepperType() {
        return pepperType;
    }

    public void setPepperType(String pepperType) {
        this.pepperType = pepperType;
    }

    public String getPizzaStyle() {
        return pizzaStyle;
    }

    public void setPizzaStyle(String pizzaStyle) {
        this.pizzaStyle = pizzaStyle;
    }

    public String getPotatoTypeUse() {
        return potatoTypeUse;
    }

    public void setPotatoTypeUse(String potatoTypeUse) {
        this.potatoTypeUse = potatoTypeUse;
    }

    public String getPrepEntreeType() {
        return prepEntreeType;
    }

    public void setPrepEntreeType(String prepEntreeType) {
        this.prepEntreeType = prepEntreeType;
    }

    public String getRiceTypeUse() {
        return riceTypeUse;
    }

    public void setRiceTypeUse(String riceTypeUse) {
        this.riceTypeUse = riceTypeUse;
    }

    public String getRoastVegItemType() {
        return roastVegItemType;
    }

    public void setRoastVegItemType(String roastVegItemType) {
        this.roastVegItemType = roastVegItemType;
    }

    public String getSalsaType() {
        return salsaType;
    }

    public void setSalsaType(String salsaType) {
        this.salsaType = salsaType;
    }

    public String getVegCookMeth() {
        return vegCookMeth;
    }

    public void setVegCookMeth(String vegCookMethod) {
        this.vegCookMeth = vegCookMethod;
    }

    /**
     * @return Returns the newItemBrag.
     */
    public String getNewItemBrag() {
        return newItemBrag;
    }

    /**
     * @param newItemBrag The newItemBrag to set.
     */
    public void setNewItemBrag(String newItemBrag) {
        this.newItemBrag = newItemBrag;
    }

    /**
     * @return Returns the oilTypeUse.
     */
    public String getOilTypeUse() {
        return oilTypeUse;
    }

    /**
     * @param oilTypeUse The oilTypeUse to set.
     */
    public void setOilTypeUse(String oilTypeUse) {
        this.oilTypeUse = oilTypeUse;
    }

    /**
     * @return Returns the proteinFlavorApp.
     */
    public String getProteinFlavorApp() {
        return proteinFlavorApp;
    }

    /**
     * @param proteinFlavorApp The proteinFlavorApp to set.
     */
    public void setProteinFlavorApp(String proteinFlavorApp) {
        this.proteinFlavorApp = proteinFlavorApp;
    }

    public String getCheeseForm() {
        return cheeseForm;
    }

    public void setCheeseForm(String cheeseForm) {
        this.cheeseForm = cheeseForm;
    }

    public String getCheeseSauceFillingType() {
        return cheeseSauceFillingType;
    }

    public void setCheeseSauceFillingType(String cheeseSauceFillingType) {
        this.cheeseSauceFillingType = cheeseSauceFillingType;
    }

    public String getEggItemUse() {
        return eggItemUse;
    }

    public void setEggItemUse(String eggItemUse) {
        this.eggItemUse = eggItemUse;
    }

    public String getSoupBaseBroth() {
        return soupBaseBroth;
    }

    public void setSoupBaseBroth(String soupBaseBroth) {
        this.soupBaseBroth = soupBaseBroth;
    }

    public String getSoupWith() {
        return soupWith;
    }

    public void setSoupWith(String soupWith) {
        this.soupWith = soupWith;
    }

    public String getAllVegCarbFruit() {
        return allVegCarbFruit;
    }

    public void setAllVegCarbFruit(String allVegCarbFruit) {
        this.allVegCarbFruit = allVegCarbFruit;
    }

    public String getVeggieAll() {
        return veggieAll;
    }

    public void setVeggieAll(String veggieAll) {
        this.veggieAll = veggieAll;
    }
    
    //JDL added fields
    public String getBevMenuItem() {
        return bevMenuItem;
    }

    public void setBevMenuItem(String bevMenuItem) {
        this.bevMenuItem = bevMenuItem;
    }
    
    public String getSideAccompDisFlavor() {
        return sideAccompDisFlavor;
    }

    public void setSideAccompDisFlavor(String sideAccompDisFlavor) {
        this.sideAccompDisFlavor = sideAccompDisFlavor;
    }

    public String getCookieTypeSource() {
        return cookieTypeSource;
    }

    public void setCookieTypeSource(String cookieTypeSource) {
        this.cookieTypeSource = cookieTypeSource;
    }
    
    public String getCreamyTop() {
        return creamyTop;
    }

    public void setCreamyTop(String creamyTop) {
        this.creamyTop = creamyTop;
    }
    
    public String getCreamyFill() {
        return creamyFill;
    }

    public void setCreamyFill(String CreamyFill) {
        this.creamyFill = CreamyFill;
    }
    
    public String getTextureAttrib() {
        return textureAttrib;
    }

    public void setTextureAttrib(String textureAttrib) {
        this.textureAttrib = textureAttrib;
    }
    
    public String getQualityStyle() {
        return qualityStyle;
    }

    public void setQualityStyle(String qualityStyle) {
        this.qualityStyle = qualityStyle;
    }
    
    //End JDL
}