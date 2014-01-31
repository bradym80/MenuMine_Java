/*
 * Created on Jan 19, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;

import ognl.Ognl;
import ognl.OgnlException;

/**
 * 2006-01-21 RSC This is basically just a TF for the fields a user selects to
 * include in a display result. Since I'm working on making a faster query, I'm
 * adding a way to work with filter parameters on this as well.
 * 
 * 
 * @author Nick
 * 
 * 
 */
public class FieldsToDisplayBean implements Serializable {

    private Long id;

    /*
     * 2006-01-21 RSC added. 2006-03-02 RSC Not using.
     */
    // private Boolean masterfoodId = Boolean.FALSE;
    private Boolean basicProtein = Boolean.FALSE;

    private Boolean proteinTypeCut = Boolean.FALSE;
    // 06-01-09 MJB added the 9 protein types below.
    private Boolean chickenType = Boolean.FALSE;
    
    private Boolean beefType = Boolean.FALSE;
    
    private Boolean porkType = Boolean.FALSE;
    
    private Boolean fishType = Boolean.FALSE;
    
    private Boolean seafoodType = Boolean.FALSE;
    
    private Boolean lambType = Boolean.FALSE;
    
    private Boolean turkeyType = Boolean.FALSE;
    
    private Boolean otherProteinType = Boolean.FALSE;
    
    private Boolean shrimpType = Boolean.FALSE;
    
    private Boolean proteinType = Boolean.FALSE;

    private Boolean cookMeth = Boolean.FALSE;

    private Boolean genCookMeth = Boolean.FALSE;

    private Boolean sauceCondDressMarMM = Boolean.FALSE;

    private Boolean flavEnhancSeasBrdgDesIngredMM = Boolean.FALSE;

    private Boolean carboVegFruit = Boolean.FALSE;
    
    private Boolean topFillIngredMM = Boolean.FALSE;

    private Boolean cheeseMM = Boolean.FALSE;

    private Boolean breadBakeGoodsMM = Boolean.FALSE;

    private Boolean menuItem = Boolean.FALSE;

    private Boolean menuItemType = Boolean.TRUE;

    private Boolean itemDescription = Boolean.FALSE;

    private Boolean cuisine = Boolean.TRUE;

    private Boolean cuisineFamily = Boolean.FALSE;

    private Boolean genMenuPart = Boolean.TRUE;

    private Boolean menuItemClass = Boolean.TRUE;

    private Boolean menuStatus = Boolean.FALSE;
    
    // MJB 11-12-2209 Added 2010
    private Boolean price2011 = Boolean.FALSE;
    
    private Boolean price2010 = Boolean.FALSE;
    
    // DBB 1-20-2009 Add 2008, 2009
    private Boolean price2009 = Boolean.FALSE;
    
    private Boolean price2008 = Boolean.FALSE;

    private Boolean price2006 = Boolean.FALSE;
    //JDL 10-5-07
    private Boolean price2007 = Boolean.FALSE;

    private Boolean price2005 = Boolean.FALSE;

    private Boolean price2004 = Boolean.FALSE;

    private Boolean price2003 = Boolean.FALSE;

    private Boolean price2002 = Boolean.FALSE;

    private Boolean price2001 = Boolean.FALSE;

    private Boolean price2000 = Boolean.FALSE;

    private Boolean price1999 = Boolean.FALSE;

    private Boolean price1998 = Boolean.FALSE;

    private Boolean price1997 = Boolean.FALSE;

    private Boolean price1996 = Boolean.FALSE;

    /*
     * Chain fields.
     */
    private Boolean chain = Boolean.FALSE;

    private Boolean segment = Boolean.TRUE;

    private Boolean sector = Boolean.FALSE;

    private Boolean hqState = Boolean.FALSE;

    private Boolean chainID = Boolean.FALSE;

    /*
     * Dessert mine Fields
     */

    private Boolean dayPartCategory = Boolean.FALSE;

    private Boolean cakeIngredient = Boolean.FALSE;

    private Boolean cakeUse = Boolean.FALSE;

    private Boolean cookieIngredient = Boolean.FALSE;

    private Boolean cookieUse = Boolean.FALSE;

    private Boolean dessertDoughCrustIngred = Boolean.FALSE;

    private Boolean iceCreamIngredient = Boolean.FALSE;

    private Boolean syrupTopping = Boolean.FALSE;

    private Boolean nutIngredient = Boolean.FALSE;

    private Boolean fruitOrFruitFillingIngred = Boolean.FALSE;

    private Boolean whippedToppingIngred = Boolean.FALSE;

    private Boolean candyIngredient = Boolean.FALSE;

    private Boolean primaryFlavor = Boolean.FALSE;

    private Boolean tasteFlavorWords = Boolean.FALSE;

    private Boolean brand = Boolean.FALSE;

    private Boolean veggieFruitMM = Boolean.FALSE;

    private Boolean carboMM = Boolean.FALSE;
    
    private Boolean carboAll = Boolean.FALSE;

    private Boolean breadUse = Boolean.FALSE;

    private Boolean flavApplication = Boolean.FALSE;

    private Boolean flavorSoup = Boolean.FALSE;

    private Boolean sideOrAccomp = Boolean.FALSE;

    private Boolean healthyTerm = Boolean.FALSE;

    /*
     * Ingredient Mine
     */
    private Boolean cookingSauceOrGravy = Boolean.FALSE;

    private Boolean marinade = Boolean.FALSE;

    private Boolean glaze = Boolean.FALSE;

    private Boolean dressings = Boolean.FALSE;

    private Boolean dipSauceName = Boolean.FALSE;
    
    private Boolean dairyButterCream = Boolean.FALSE;
    
    private Boolean tomatoType = Boolean.FALSE;
    
    private Boolean onionScallionLeek = Boolean.FALSE;

    private Boolean mushroomType = Boolean.FALSE;

    private Boolean condiments = Boolean.FALSE;

    private Boolean butterApplication = Boolean.FALSE;

    private Boolean seasoningName = Boolean.FALSE;

    private Boolean batterBreadingCoating = Boolean.FALSE;

    private Boolean stuffName = Boolean.FALSE;

    private Boolean cheeseRollUp = Boolean.FALSE;

    private Boolean cheeseCheeseSauceFillingType = Boolean.FALSE;

    private Boolean proteinTopName = Boolean.FALSE;

    private Boolean proteinAccompName = Boolean.FALSE;

    private Boolean veggieFruitType = Boolean.FALSE;

    private Boolean greenVegName = Boolean.FALSE;

    private Boolean vegTopName = Boolean.FALSE;

    private Boolean vegAccompName = Boolean.FALSE;

    private Boolean fruitType = Boolean.FALSE;

    private Boolean carboType = Boolean.FALSE;

    private Boolean carboTopName = Boolean.FALSE;

    private Boolean carboAccompName = Boolean.FALSE;

    private Boolean breadWrapChips = Boolean.FALSE;

    private Boolean eggType = Boolean.FALSE;

    private Boolean hotColdCereal = Boolean.FALSE;

    private Boolean spreadType = Boolean.FALSE;

    private Boolean breakfastPastry = Boolean.FALSE;

    private Boolean breakCakeWaff = Boolean.FALSE;

    /*
     * Fields added for Beverage mine
     */
    private Boolean logoImageStyle = Boolean.FALSE;

    private Boolean bevSize = Boolean.FALSE;

    private Boolean servingCount = Boolean.FALSE;

    /*
     * Added Chain Fields
     */
    private Boolean hqRegion = Boolean.FALSE;

    private Boolean operatorType = Boolean.FALSE;

    private Boolean countryLoc = Boolean.FALSE;

    private Boolean yearPutInDatabase = Boolean.FALSE;

    private Boolean yearPutInDatabaseSameStore = Boolean.FALSE;

    /*
     * 2006-01-17 RSC
     */
    private Boolean proteinFishShrimpSeafood = Boolean.FALSE;

    private Boolean keywords = Boolean.FALSE;

    private Boolean otherIngredName = Boolean.FALSE;

    private Boolean otherToppings = Boolean.FALSE;

    private Boolean otherTopIngred = Boolean.FALSE;

    private Boolean otherAccompaniments = Boolean.FALSE;

    private Boolean healthyFlag = Boolean.FALSE;

    private Boolean healthySymbol = Boolean.FALSE;

    private Boolean fillingSaucesDressings = Boolean.FALSE;

    /*
     * 2006-08-02 reid@fivesticks.com types and use fields
    
     */
    private Boolean cuisineVerySpecific = Boolean.FALSE;
    
    private Boolean grillRoastSmoke = Boolean.FALSE;

    private Boolean vegCookMeth = Boolean.FALSE;

    private Boolean cookSauceType = Boolean.FALSE;

    private Boolean dressingType = Boolean.FALSE;

    private Boolean dressingFlavor = Boolean.FALSE;

    private Boolean mexBreadType = Boolean.FALSE;

    private Boolean roastVegItemType = Boolean.FALSE;

    private Boolean appetClassTyp = Boolean.FALSE;

    private Boolean prepEntreeType = Boolean.FALSE;

    private Boolean breadedFriedAppSide = Boolean.FALSE;

    private Boolean potatoTypeUse = Boolean.FALSE;

    private Boolean salsaType = Boolean.FALSE;

    private Boolean cookieLookAlikeDessert = Boolean.FALSE;

    private Boolean breakfastToGo = Boolean.FALSE;

    private Boolean pizzaStyle = Boolean.FALSE;

    private Boolean bbqCook = Boolean.FALSE;

    private Boolean ethnicBreadType = Boolean.FALSE;

    private Boolean pepperType = Boolean.FALSE;

    private Boolean riceTypeUse = Boolean.FALSE;

    private Boolean mexIngredUse = Boolean.FALSE;

    private Boolean flavorChangeAnyYear = Boolean.FALSE;

    private Boolean newItemBrag = Boolean.FALSE;

    private Boolean proteinFlavorApp = Boolean.FALSE;

    private Boolean oilTypeUse = Boolean.FALSE;


    private Boolean eggItemUse = Boolean.FALSE;

    private Boolean cheeseForm = Boolean.FALSE;

    private Boolean cheeseSauceFillingType = Boolean.FALSE;
    
    
    
    /*
     * 2006-09-06
     */
    private Boolean soupWith = Boolean.FALSE;

    private Boolean soupBaseBroth = Boolean.FALSE;

    /*
     * 7-25-07 JDL
     */
    
    private Boolean bevMenuItem = Boolean.FALSE;
    
    private Boolean sideAccompDisFlavor = Boolean.FALSE;
       
    private Boolean cookieTypeSource = Boolean.FALSE;
    
    private Boolean creamyTop = Boolean.FALSE;
    
    private Boolean creamyFill = Boolean.FALSE;
   
    private Boolean textureAttrib = Boolean.FALSE;
    
    private Boolean qualityStyle = Boolean.FALSE;

    //End JDL
    
    
    /*
     * 2006-11-07
     */
    private Boolean veggieAll = Boolean.FALSE;

    private Boolean allVegCarbFruit = Boolean.FALSE;    
    
    
    
    public int countTotalSelected() {
        //int count = countPrimaryFieldsSelected();
        
        int count = 0;
        
        Collection col = new ArrayList();
        for (Iterator iter = FieldEnum.getAll().iterator(); iter.hasNext();) {
            FieldEnum element = (FieldEnum) iter.next();

            Object o = null;
            try {
                /*
                 * 2006-01-22 RSC shorthand reflection...
                 * Note that where FieldEnum.getAll returns multiple copies
                 * of the same field (genMenuPart), this will return duplicate
                 * references to the same filter parameter.
                 */
                o = Ognl.getValue(element.getShortOgnlName(), this);
            } catch (OgnlException e) {
                /*
                 * 2006-08-17 reid added for good measure.
                 */
                e.printStackTrace();
                /*
                 * nick 2005-21-2005 Any params for the chainfilter will throw
                 * exceptions, and that is fine
                 * reid 
                 */
            }
            if (o != null) {
                Boolean selected = (Boolean) o;
                if (selected.booleanValue()) {
                    count++;
                }
            }
        }
        
        return count;
    }

    public Boolean isBasicProtein() {
        return basicProtein;
    }

    public void setBasicProtein(Boolean basicProtein) {
        this.basicProtein = basicProtein;
    }

    public Boolean isBreadBakeGoodsMM() {
        return breadBakeGoodsMM;
    }

    public void setBreadBakeGoodsMM(Boolean breadBakeGoodsMM) {
        this.breadBakeGoodsMM = breadBakeGoodsMM;
    }

    public Boolean isCarboVegFruit() {
        return carboVegFruit;
    }

    public void setCarboVegFruit(Boolean carboVegFruit) {
        this.carboVegFruit = carboVegFruit;
    }

    public Boolean isCheeseMM() {
        return cheeseMM;
    }

    public void setCheeseMM(Boolean cheeseMM) {
        this.cheeseMM = cheeseMM;
    }

    public Boolean isCookMeth() {
        return cookMeth;
    }

    public void setCookMeth(Boolean cookMeth) {
        this.cookMeth = cookMeth;
    }

    public Boolean isCuisine() {
        return cuisine;
    }

    public void setCuisine(Boolean cuisine) {
        this.cuisine = cuisine;
    }

    public Boolean isFlavEnhancSeasBrdgDesIngredMM() {
        return flavEnhancSeasBrdgDesIngredMM;
    }

    public void setFlavEnhancSeasBrdgDesIngredMM(
            Boolean flavEnhancSeasBrdgDesIngredMM) {
        this.flavEnhancSeasBrdgDesIngredMM = flavEnhancSeasBrdgDesIngredMM;
    }

    public Boolean isGenMenuPart() {

        return genMenuPart;
    }

    public void setGenMenuPart(Boolean genMenuPart) {

        this.genMenuPart = genMenuPart;
    }

    public Boolean isItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(Boolean itemDescription) {
        this.itemDescription = itemDescription;
    }

    public Boolean isMenuItem() {
        return menuItem;
    }

    public void setMenuItem(Boolean menuItem) {
        this.menuItem = menuItem;
    }

    public Boolean isMenuItemClass() {
        return menuItemClass;
    }

    public void setMenuItemClass(Boolean menuItemClass) {
        this.menuItemClass = menuItemClass;
    }

    public Boolean isMenuItemType() {
        return menuItemType;
    }

    public void setMenuItemType(Boolean menuItemType) {
        this.menuItemType = menuItemType;
    }

    public Boolean isMenuStatus() {
        return menuStatus;
    }

    public void setMenuStatus(Boolean menuStatus) {
        this.menuStatus = menuStatus;
    }

    public Boolean isPrice1998() {
        return price1998;
    }

    public void setPrice1998(Boolean price1998) {
        this.price1998 = price1998;
    }

    public Boolean isPrice1999() {
        return price1999;
    }

    public void setPrice1999(Boolean price1999) {
        this.price1999 = price1999;
    }

    public Boolean isPrice2000() {
        return price2000;
    }

    public void setPrice2000(Boolean price2000) {
        this.price2000 = price2000;
    }

    public Boolean isPrice2001() {
        return price2001;
    }

    public void setPrice2001(Boolean price2001) {
        this.price2001 = price2001;
    }

    public Boolean isPrice2002() {
        return price2002;
    }

    public void setPrice2002(Boolean price2002) {
        this.price2002 = price2002;
    }

    public Boolean isPrice2003() {
        return price2003;
    }

    public void setPrice2003(Boolean price2003) {
        this.price2003 = price2003;
    }

    public Boolean isPrice2004() {
        return price2004;
    }

    public void setPrice2004(Boolean price2004) {
        this.price2004 = price2004;
    }

    public Boolean isPrice2005() {
        return price2005;
    }
    
    public Boolean isPrice2006() {
        return price2006;
    }

    public void setPrice2005(Boolean price2005)  {
        this.price2005 = price2005;
    }
    
    // DBB 1-20-2009 Add 2008, 2009
    public Boolean isPrice2008() {
        return price2008;
    }

    public Boolean isPrice2009() {
        return price2009;
    }

    // MJB 11-12-2009 Added 2010
    public Boolean isPrice2010() {
        return price2010;
    }
    
    public Boolean isPrice2011() {
        return price2011;
    }
    
    public Boolean isProteinType() {
        return proteinType;
    }

    public void setProteinType(Boolean proteinType) {
        this.proteinType = proteinType;
    }

    public Boolean isChickenType() {
        return chickenType;
    }

    public Boolean isBeefType() {
        return beefType;
    }
    
    public Boolean isPorkType() {
        return porkType;
    }
    
    public Boolean isFishType() {
        return fishType;
    }
    
    public Boolean isSeafoodType() {
        return seafoodType;
    }
    
    public Boolean isLambType() {
        return lambType;
    }
    
    public Boolean isTurkeyType() {
        return turkeyType;
    }
    
    public Boolean isOtherProteinType() {
        return otherProteinType;
    }
    
    public Boolean isShrimpType() {
        return shrimpType;
    }
    
    public Boolean isProteinTypeCut() {
        return proteinTypeCut;
    }
    
    public void setChickenType(Boolean chickenType) {
        this.chickenType = chickenType;
    }

    public void setBeefType(Boolean beefType) {
        this.beefType = beefType;
    }
    
    public void setPorkType(Boolean porkType) {
        this.porkType = porkType;
    }
    
    public void setFishType(Boolean fishType) {
        this.fishType = fishType;
    }
    
    public void setSeafoodType(Boolean seafoodType) {
        this.seafoodType = seafoodType;
    }
    
    public void setLambType(Boolean lambType) {
        this.lambType = lambType;
    }
    
    public void setTurkeyType(Boolean turkeyType) {
        this.turkeyType = turkeyType;
    }
    
    public void setOtherProteinType(Boolean otherProteinType) {
        this.otherProteinType = otherProteinType;
    }
    
    public void setShrimpType(Boolean shrimpType) {
        this.shrimpType = shrimpType;
    }
    
    public void setProteinTypeCut(Boolean proteinTypeCut) {
        this.proteinTypeCut = proteinTypeCut;
    }
    
    public Boolean isSauceCondDressMarMM() {
        return sauceCondDressMarMM;
    }

    public void setSauceCondDressMarMM(Boolean sauceCondDressMarMM) {
        this.sauceCondDressMarMM = sauceCondDressMarMM;
    }

    public Boolean isTopFillIngredMM() {
        return topFillIngredMM;
    }

    public void setTopFillIngredMM(Boolean topFillIngredMM) {
        this.topFillIngredMM = topFillIngredMM;
    }

    public Boolean isOperationName() {
        return chain;
    }

    public void setOperationName(Boolean chain) {
        this.chain = chain;
    }

    public Boolean isHqState() {
        return hqState;
    }

    public void setHqState(Boolean hqState) {
        this.hqState = hqState;
    }

    public Boolean isSectorName() {
        return sector;
    }

    public void setSectorName(Boolean sector) {
        this.sector = sector;
    }

    public Boolean isSegment() {
        return segment;
    }

    public void setSegment(Boolean segment) {
        this.segment = segment;
    }

    /*
     * This will return a count of the primary fields selected. This excludes
     * Operation Name. As per meeting with Joe If a user selects Operation Name,
     * they need to select another Primary fields as well, thus for internal
     * purposes, we exclude OpName from the primary field list.
     * 
     */
//    public int countPrimaryFieldsSelected() {
//        int count = 0;
//
//        if (this.isGenMenuPart().booleanValue()) {
//            count++;
//        }
//        if (this.isSegment().booleanValue()) {
//            count++;
//        }
//        if (this.isSectorName().booleanValue()) {
//            count++;
//        }
//        if (this.isBasicProtein().booleanValue()) {
//            count++;
//        }
//        if (this.isCuisine().booleanValue()) {
//            count++;
//        }
//        if (this.isCookMeth().booleanValue()) {
//            count++;
//        }
//        return count;
//    }

    public Boolean isCuisineFamily() {
        return cuisineFamily;
    }

    public void setCuisineFamily(Boolean cuisineFamily) {
        this.cuisineFamily = cuisineFamily;
    }

    public Boolean isGenCookMeth() {
        return genCookMeth;
    }

    public void setGenCookMeth(Boolean genCookMeth) {
        this.genCookMeth = genCookMeth;
    }

    public Boolean isPrice1996() {
        return price1996;
    }

    public void setPrice1996(Boolean price1996) {
        this.price1996 = price1996;
    }

    public Boolean isPrice1997() {
        return price1997;
    }

    public void setPrice1997(Boolean price1997) {
        this.price1997 = price1997;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getBasicProtein() {
        return basicProtein;
    }

    public Boolean getBreadBakeGoodsMM() {
        return breadBakeGoodsMM;
    }

    public Boolean getCarboVegFruit() {
        return carboVegFruit;
    }

    public Boolean getOperationName() {
        return chain;
    }

    public Boolean getCheeseMM() {
        return cheeseMM;
    }

    public Boolean getCookMeth() {
        return cookMeth;
    }

    public Boolean getCuisine() {
        return cuisine;
    }

    public Boolean getCuisineFamily() {
        return cuisineFamily;
    }

    public Boolean getFlavEnhancSeasBrdgDesIngredMM() {
        return flavEnhancSeasBrdgDesIngredMM;
    }

    public Boolean getGenCookMeth() {
        return genCookMeth;
    }

    public Boolean getGenMenuPart() {
        return genMenuPart;
    }

    public Boolean getHqState() {
        return hqState;
    }

    public Boolean getItemDescription() {
        return itemDescription;
    }

    public Boolean getMenuItem() {
        return menuItem;
    }

    public Boolean getMenuItemClass() {
        return menuItemClass;
    }

    public Boolean getMenuItemType() {
        return menuItemType;
    }

    public Boolean getMenuStatus() {
        return menuStatus;
    }

    public Boolean getPrice1996() {
        return price1996;
    }

    public Boolean getPrice1997() {
        return price1997;
    }

    public Boolean getPrice1998() {
        return price1998;
    }

    public Boolean getPrice1999() {
        return price1999;
    }

    public Boolean getPrice2000() {
        return price2000;
    }

    public Boolean getPrice2001() {
        return price2001;
    }

    public Boolean getPrice2002() {
        return price2002;
    }

    public Boolean getPrice2003() {
        return price2003;
    }

    public Boolean getPrice2004() {
        return price2004;
    }

    public Boolean getPrice2005() {
        return price2005;
    }

    public Boolean getProteinType() {
        return proteinType;
    }

    public Boolean getProteinTypeCut() {
        return proteinTypeCut;
    }
    // 2009-06-01 MJB added the 9 protein fields below.
    public Boolean getChickenType() {
        return chickenType;
    }

    public Boolean getBeefType() {
        return beefType;
    }

    public Boolean getPorkType() {
        return porkType;
    }

    public Boolean getFishType() {
        return fishType;
    }

    public Boolean getSeafoodType() {
        return seafoodType;
    }

    public Boolean getLambType() {
        return lambType;
    }

    public Boolean getTurkeyType() {
        return turkeyType;
    }

    public Boolean getOtherProteinType() {
        return otherProteinType;
    }

    public Boolean getShrimpType() {
        return shrimpType;
    }

    public Boolean getSauceCondDressMarMM() {
        return sauceCondDressMarMM;
    }

    public Boolean getSectorName() {
        return sector;
    }

    public Boolean getSegment() {
        return segment;
    }

    public Boolean getTopFillIngredMM() {
        return topFillIngredMM;
    }

    public Boolean getBrand() {
        return brand;
    }

    public void setBrand(Boolean brand) {
        this.brand = brand;
    }

    public Boolean getCakeIngredient() {
        return cakeIngredient;
    }

    public void setCakeIngredient(Boolean cakeIngredient) {
        this.cakeIngredient = cakeIngredient;
    }

    public Boolean getCakeUse() {
        return cakeUse;
    }

    public void setCakeUse(Boolean cakeUse) {
        this.cakeUse = cakeUse;
    }

    public Boolean getCandyIngredient() {
        return candyIngredient;
    }

    public void setCandyIngredient(Boolean candyIngredient) {
        this.candyIngredient = candyIngredient;
    }

    public Boolean getChain() {
        return chain;
    }

    public void setChain(Boolean chain) {
        this.chain = chain;
    }

    public Boolean getCookieIngredient() {
        return cookieIngredient;
    }

    public void setCookieIngredient(Boolean cookieIngredient) {
        this.cookieIngredient = cookieIngredient;
    }

    public Boolean getCookieUse() {
        return cookieUse;
    }

    public void setCookieUse(Boolean cookieUse) {
        this.cookieUse = cookieUse;
    }

    public Boolean getDayPartCategory() {
        return dayPartCategory;
    }

    public void setDayPartCategory(Boolean dayPartCategory) {
        this.dayPartCategory = dayPartCategory;
    }

    public Boolean getDessertDoughCrustIngred() {
        return dessertDoughCrustIngred;
    }

    public void setDessertDoughCrustIngred(Boolean dessertDoughCrustIngred) {
        this.dessertDoughCrustIngred = dessertDoughCrustIngred;
    }

    public Boolean getFruitOrFruitFillingIngred() {
        return fruitOrFruitFillingIngred;
    }

    public void setFruitOrFruitFillingIngred(Boolean fruitOrFruitFillingIngred) {
        this.fruitOrFruitFillingIngred = fruitOrFruitFillingIngred;
    }

    public Boolean getIceCreamIngredient() {
        return iceCreamIngredient;
    }

    public void setIceCreamIngredient(Boolean iceCreamIngredient) {
        this.iceCreamIngredient = iceCreamIngredient;
    }

    public Boolean getNutIngredient() {
        return nutIngredient;
    }

    public void setNutIngredient(Boolean nutIngredient) {
        this.nutIngredient = nutIngredient;
    }

    public Boolean getPrimaryFlavor() {
        return primaryFlavor;
    }

    public void setPrimaryFlavor(Boolean primaryFlavor) {
        this.primaryFlavor = primaryFlavor;
    }

    public Boolean getSector() {
        return sector;
    }

    public void setSector(Boolean sector) {
        this.sector = sector;
    }

    public Boolean getSyrupTopping() {
        return syrupTopping;
    }

    public void setSyrupTopping(Boolean syrupTopping) {
        this.syrupTopping = syrupTopping;
    }

    public Boolean getTasteFlavorWords() {
        return tasteFlavorWords;
    }

    public void setTasteFlavorWords(Boolean tasteFlavorWords) {
        this.tasteFlavorWords = tasteFlavorWords;
    }

    public Boolean getWhippedToppingIngred() {
        return whippedToppingIngred;
    }

    public void setWhippedToppingIngred(Boolean whippedToppingIngred) {
        this.whippedToppingIngred = whippedToppingIngred;
    }

    public Boolean getBreadUse() {
        return breadUse;
    }

    public void setBreadUse(Boolean breadUse) {
        this.breadUse = breadUse;
    }

    public Boolean getCarboMM() {
        return carboMM;
    }

    public void setCarboMM(Boolean carboMM) {
        this.carboMM = carboMM;
    }
    
    public Boolean getCarboAll() {
        return carboAll;
    }

    public void setCarboAll(Boolean carboAll) {
        this.carboAll = carboAll;
    }

    public Boolean getFlavApplication() {
        return flavApplication;
    }

    public void setFlavApplication(Boolean flavApplication) {
        this.flavApplication = flavApplication;
    }

    public Boolean getFlavorSoup() {
        return flavorSoup;
    }

    public void setFlavorSoup(Boolean flavorSoup) {
        this.flavorSoup = flavorSoup;
    }

    public Boolean getSideOrAccomp() {
        return sideOrAccomp;
    }

    public void setSideOrAccomp(Boolean sideOrAccomp) {
        this.sideOrAccomp = sideOrAccomp;
    }

    public Boolean getVeggieFruitMM() {
        return veggieFruitMM;
    }

    public void setVeggieFruitMM(Boolean veggieFruitMM) {
        this.veggieFruitMM = veggieFruitMM;
    }

    public Boolean getHealthyTerm() {
        return healthyTerm;
    }

    public void setHealthyTerm(Boolean healthyTerm) {
        this.healthyTerm = healthyTerm;
    }

    public Boolean getBatterBreadingCoating() {
        return batterBreadingCoating;
    }

    public void setBatterBreadingCoating(Boolean batterBreadingCoating) {
        this.batterBreadingCoating = batterBreadingCoating;
    }

    public Boolean getBreadWrapChips() {
        return breadWrapChips;
    }

    public void setBreadWrapChips(Boolean breadWrapChips) {
        this.breadWrapChips = breadWrapChips;
    }

    public Boolean getButterApplication() {
        return butterApplication;
    }

    public void setButterApplication(Boolean butterApplication) {
        this.butterApplication = butterApplication;
    }

    public Boolean getCarboAccompName() {
        return carboAccompName;
    }

    public void setCarboAccompName(Boolean carboAccompName) {
        this.carboAccompName = carboAccompName;
    }

    public Boolean getCarboTopName() {
        return carboTopName;
    }

    public void setCarboTopName(Boolean carboTopName) {
        this.carboTopName = carboTopName;
    }

    public Boolean getCarboType() {
        return carboType;
    }

    public void setCarboType(Boolean carboType) {
        this.carboType = carboType;
    }

    public Boolean getCheeseCheeseSauceFillingType() {
        return cheeseCheeseSauceFillingType;
    }

    public void setCheeseCheeseSauceFillingType(
            Boolean cheeseCheeseSauceFillingType) {
        this.cheeseCheeseSauceFillingType = cheeseCheeseSauceFillingType;
    }

    public Boolean getCheeseRollUp() {
        return cheeseRollUp;
    }

    public void setCheeseRollUp(Boolean cheeseRollUp) {
        this.cheeseRollUp = cheeseRollUp;
    }

    public Boolean getCondiments() {
        return condiments;
    }

    public void setCondiments(Boolean condiments) {
        this.condiments = condiments;
    }

    public Boolean getCookingSauceOrGravy() {
        return cookingSauceOrGravy;
    }

    public void setCookingSauceOrGravy(Boolean cookingSauceOrGravy) {
        this.cookingSauceOrGravy = cookingSauceOrGravy;
    }

    public Boolean getDipSauceName() {
        return dipSauceName;
    }

    public void setDipSauceName(Boolean dipSauceName) {
        this.dipSauceName = dipSauceName;
    }

    public Boolean getDairyButterCream() {
        return dairyButterCream;
    }

    public void setDairyButterCream(Boolean dairyButterCream) {
        this.dairyButterCream = dairyButterCream;
    }

    public Boolean getOnionScallionLeek() {
        return onionScallionLeek;
    }

    public void setOnionScallionLeek(Boolean onionScallionLeek) {
        this.onionScallionLeek = onionScallionLeek;
    }

    public Boolean getMushroomType() {
        return mushroomType;
    }

    public void setMushroomType(Boolean mushroomType) {
        this.mushroomType = mushroomType;
    }
    
    public Boolean getTomatoType() {
        return tomatoType;
    }

    public void setTomatoType(Boolean tomatoType) {
        this.tomatoType = tomatoType;
    }

    public Boolean getDressings() {
        return dressings;
    }

    public void setDressings(Boolean dressings) {
        this.dressings = dressings;
    }

    public Boolean getFruitType() {
        return fruitType;
    }

    public void setFruitType(Boolean fruitType) {
        this.fruitType = fruitType;
    }

    public Boolean getGlaze() {
        return glaze;
    }

    public void setGlaze(Boolean glaze) {
        this.glaze = glaze;
    }

    public Boolean getGreenVegName() {
        return greenVegName;
    }

    public void setGreenVegName(Boolean greenVegName) {
        this.greenVegName = greenVegName;
    }

    public Boolean getMarinade() {
        return marinade;
    }

    public void setMarinade(Boolean marinade) {
        this.marinade = marinade;
    }

    public Boolean getProteinAccompName() {
        return proteinAccompName;
    }

    public void setProteinAccompName(Boolean proteinAccompName) {
        this.proteinAccompName = proteinAccompName;
    }

    public Boolean getProteinTopName() {
        return proteinTopName;
    }

    public void setProteinTopName(Boolean proteinTopName) {
        this.proteinTopName = proteinTopName;
    }

    public Boolean getSeasoningName() {
        return seasoningName;
    }

    public void setSeasoningName(Boolean seasoningName) {
        this.seasoningName = seasoningName;
    }

    public Boolean getStuffName() {
        return stuffName;
    }

    public void setStuffName(Boolean stuffName) {
        this.stuffName = stuffName;
    }

    public Boolean getVegAccompName() {
        return vegAccompName;
    }

    public void setVegAccompName(Boolean vegAccompName) {
        this.vegAccompName = vegAccompName;
    }

    public Boolean getVeggieFruitType() {
        return veggieFruitType;
    }

    public void setVeggieFruitType(Boolean veggieFruitType) {
        this.veggieFruitType = veggieFruitType;
    }

    public Boolean getVegTopName() {
        return vegTopName;
    }

    public void setVegTopName(Boolean vegTopName) {
        this.vegTopName = vegTopName;
    }

    public Boolean getBevSize() {
        return bevSize;
    }

    public void setBevSize(Boolean bevSize) {
        this.bevSize = bevSize;
    }

    public Boolean getBreakCakeWaff() {
        return breakCakeWaff;
    }

    public void setBreakCakeWaff(Boolean breakCakeWaff) {
        this.breakCakeWaff = breakCakeWaff;
    }

    public Boolean getBreakfastPastry() {
        return breakfastPastry;
    }

    public void setBreakfastPastry(Boolean breakfastPastry) {
        this.breakfastPastry = breakfastPastry;
    }

    public Boolean getEggType() {
        return eggType;
    }

    public void setEggType(Boolean eggType) {
        this.eggType = eggType;
    }

    public Boolean getHotColdCereal() {
        return hotColdCereal;
    }

    public void setHotColdCereal(Boolean hotColdCereal) {
        this.hotColdCereal = hotColdCereal;
    }

    public Boolean getLogoImageStyle() {
        return logoImageStyle;
    }

    public void setLogoImageStyle(Boolean logoImageStyle) {
        this.logoImageStyle = logoImageStyle;
    }

    public Boolean getServingCount() {
        return servingCount;
    }

    public void setServingCount(Boolean servingCount) {
        this.servingCount = servingCount;
    }

    public Boolean getSpreadType() {
        return spreadType;
    }

    public void setSpreadType(Boolean spreadType) {
        this.spreadType = spreadType;
    }

    public Boolean getCountryLoc() {
        return countryLoc;
    }

    public void setCountryLoc(Boolean countryLoc) {
        this.countryLoc = countryLoc;
    }

    public Boolean getHqRegion() {
        return hqRegion;
    }

    public void setHqRegion(Boolean hqRegion) {
        this.hqRegion = hqRegion;
    }

    public Boolean getOperatorType() {
        return operatorType;
    }

    public void setOperatorType(Boolean operatorType) {
        this.operatorType = operatorType;
    }

    public Boolean getYearPutInDatabase() {
        return yearPutInDatabase;
    }

    public void setYearPutInDatabase(Boolean yearPutInDatabase) {
        this.yearPutInDatabase = yearPutInDatabase;
    }

    /**
     * @return Returns the proteinFishShimpSeafood.
     */
    public Boolean getProteinFishShrimpSeafood() {
        return proteinFishShrimpSeafood;
    }

    /**
     * @param proteinFishShimpSeafood
     *            The proteinFishShimpSeafood to set.
     */
    public void setProteinFishShrimpSeafood(Boolean proteinFishShimpSeafood) {
        this.proteinFishShrimpSeafood = proteinFishShimpSeafood;
    }

    // /**
    // * @return Returns the masterfoodId.
    // */
    // public Boolean getMasterfoodId() {
    // return masterfoodId;
    // }
    //
    // /**
    // * @param masterfoodId
    // * The masterfoodId to set.
    // */
    // public void setMasterfoodId(Boolean masterfoodId) {
    // this.masterfoodId = masterfoodId;
    // }

    public Boolean getChainID() {
        return chainID;
    }

    public void setChainID(Boolean chainID) {
        this.chainID = chainID;
    }

    public FieldsToDisplayBean clone() {
        FieldsToDisplayBean ret = new FieldsToDisplayBean();

        for (Iterator iter = FieldEnum.getAll().iterator(); iter.hasNext();) {
            FieldEnum element = (FieldEnum) iter.next();

            Boolean clone = null;

            try {
                clone = (Boolean) Ognl.getValue(element.getOgnlName(), this);

                Ognl.setValue(element.getOgnlName(), ret, clone);
            } catch (Exception e) {
                throw new RuntimeException("failed while cloning params", e);
            }
        }
        return ret;
    }

    public Collection getSelectedOgnlNames() {
        Collection ret = new TreeSet();

        for (Iterator iter = FieldEnum.getAll().iterator(); iter.hasNext();) {
            FieldEnum element = (FieldEnum) iter.next();

            Boolean clone = null;

            try {
                clone = (Boolean) Ognl.getValue(element.getOgnlName(), this);

            } catch (Exception e) {
                // throw new RuntimeException("failed while cloning params");
            }

            if (clone != null && clone.booleanValue()) {
                ret.add(element.getOgnlName());
            }
        }
        return ret;
    }

    public Boolean getKeywords() {
        return keywords;
    }

    public void setKeywords(Boolean keywords) {
        this.keywords = keywords;
    }

    public Boolean getYearPutInDatabaseSameStore() {
        return yearPutInDatabaseSameStore;
    }

    public void setYearPutInDatabaseSameStore(Boolean yearPutInDatabaseSameStore) {
        this.yearPutInDatabaseSameStore = yearPutInDatabaseSameStore;
    }

    public Boolean getFillingSaucesDressings() {
        return fillingSaucesDressings;
    }

    public void setFillingSaucesDressings(Boolean fillingSaucesDressings) {
        this.fillingSaucesDressings = fillingSaucesDressings;
    }

    public Boolean getHealthyFlag() {
        return healthyFlag;
    }

    public void setHealthyFlag(Boolean healthyFlag) {
        this.healthyFlag = healthyFlag;
    }

    public Boolean getHealthySymbol() {
        return healthySymbol;
    }

    public void setHealthySymbol(Boolean healthySymbol) {
        this.healthySymbol = healthySymbol;
    }

    public Boolean getOtherAccompaniments() {
        return otherAccompaniments;
    }

    public void setOtherAccompaniments(Boolean otherAccompaniments) {
        this.otherAccompaniments = otherAccompaniments;
    }

    public Boolean getOtherIngredName() {
        return otherIngredName;
    }

    public void setOtherIngredName(Boolean otherIngredName) {
        this.otherIngredName = otherIngredName;
    }

    public Boolean getOtherTopIngred() {
        return otherTopIngred;
    }

    public void setOtherTopIngred(Boolean otherTopIngred) {
        this.otherTopIngred = otherTopIngred;
    }

    public Boolean getOtherToppings() {
        return otherToppings;
    }

    public void setOtherToppings(Boolean otherToppings) {
        this.otherToppings = otherToppings;
    }

    // MJB 11-12-2009 Added 2010
    /**
     * @return Returns the price2010.
     */
    public Boolean getPrice2011() {
        return price2011;
    }
    
    /**
     * @param price2010
     *            The price2010 to set.
     */
    public void setPrice2011(Boolean price2011) {
        this.price2011 = price2011;
    }
    
    public Boolean getPrice2010() {
        return price2010;
    }
    
    /**
     * @param price2010
     *            The price2010 to set.
     */
    public void setPrice2010(Boolean price2010) {
        this.price2010 = price2010;
    }
    
    // DBB 1-20-2009 add 2008, 1009
    /**
     * @return Returns the price2009.
     */
    public Boolean getPrice2009() {
        return price2009;
    }
    
    /**
     * @param price2009
     *            The price2009 to set.
     */
    public void setPrice2009(Boolean price2009) {
        this.price2009 = price2009;
    }
    //JDL 10-5-07
    /**
     * @return Returns the price2008.
     */
    public Boolean getPrice2008() {
        return price2008;
    }
    
    /**
     * @param price2008
     *            The price2008 to set.
     */
    public void setPrice2008(Boolean price2008) {
        this.price2008 = price2008;
    }
    
    /**
     * @return Returns the price2006.
     */
    public Boolean getPrice2006() {
        return price2006;
    }

    /**
     * @param price2006
     *            The price2006 to set.
     */
    public void setPrice2006(Boolean price2006) {
        this.price2006 = price2006;
    }
    //JDL 10-5-07
    /**
     * @return Returns the price2007.
     */
    public Boolean getPrice2007() {
        return price2007;
    }

    /**
     * @param price2007
     *            The price2007 to set.
     */
    public void setPrice2007(Boolean price2007) {
        this.price2007 = price2007;
    }

    /**
     * @return Returns the appetClassTyp.
     */
    public Boolean getAppetClassTyp() {
        return appetClassTyp;
    }

    /**
     * @param appetClassTyp The appetClassTyp to set.
     */
    public void setAppetClassTyp(Boolean appetClassTyp) {
        this.appetClassTyp = appetClassTyp;
    }

    /**
     * @return Returns the bbqCook.
     */
    public Boolean getBbqCook() {
        return bbqCook;
    }

    /**
     * @param bbqCook The bbqCook to set.
     */
    public void setBbqCook(Boolean bbqCook) {
        this.bbqCook = bbqCook;
    }

    /**
     * @return Returns the breadedFriedAppSide.
     */
    public Boolean getBreadedFriedAppSide() {
        return breadedFriedAppSide;
    }

    /**
     * @param breadedFriedAppSide The breadedFriedAppSide to set.
     */
    public void setBreadedFriedAppSide(Boolean breadedFriedAppSide) {
        this.breadedFriedAppSide = breadedFriedAppSide;
    }

    /**
     * @return Returns the breakfastToGo.
     */
    public Boolean getBreakfastToGo() {
        return breakfastToGo;
    }

    /**
     * @param breakfastToGo The breakfastToGo to set.
     */
    public void setBreakfastToGo(Boolean breakfastToGo) {
        this.breakfastToGo = breakfastToGo;
    }

    /**
     * @return Returns the cookieLookAlikeDessert.
     */
    public Boolean getCookieLookAlikeDessert() {
        return cookieLookAlikeDessert;
    }

    /**
     * @param cookieLookAlikeDessert The cookieLookAlikeDessert to set.
     */
    public void setCookieLookAlikeDessert(Boolean cookieLookAlikeDessert) {
        this.cookieLookAlikeDessert = cookieLookAlikeDessert;
    }

    /**
     * @return Returns the cookSauceType.
     */
    public Boolean getCookSauceType() {
        return cookSauceType;
    }

    /**
     * @param cookSauceType The cookSauceType to set.
     */
    public void setCookSauceType(Boolean cookSauceType) {
        this.cookSauceType = cookSauceType;
    }

    /**
     * @return Returns the dressingFlavor.
     */
    public Boolean getDressingFlavor() {
        return dressingFlavor;
    }

    /**
     * @param dressingFlavor The dressingFlavor to set.
     */
    public void setDressingFlavor(Boolean dressingFlavor) {
        this.dressingFlavor = dressingFlavor;
    }

    /**
     * @return Returns the dressingType.
     */
    public Boolean getDressingType() {
        return dressingType;
    }

    /**
     * @param dressingType The dressingType to set.
     */
    public void setDressingType(Boolean dressingType) {
        this.dressingType = dressingType;
    }

    /**
     * @return Returns the ethnicBreadType.
     */
    public Boolean getEthnicBreadType() {
        return ethnicBreadType;
    }

    /**
     * @param ethnicBreadType The ethnicBreadType to set.
     */
    public void setEthnicBreadType(Boolean ethnicBreadType) {
        this.ethnicBreadType = ethnicBreadType;
    }

    /**
     * @return Returns the flavorChangeAnyYear.
     */
    public Boolean getFlavorChangeAnyYear() {
        return flavorChangeAnyYear;
    }

    /**
     * @param flavorChangeAnyYear The flavorChangeAnyYear to set.
     */
    public void setFlavorChangeAnyYear(Boolean flavorChangeAnyYear) {
        this.flavorChangeAnyYear = flavorChangeAnyYear;
    }

    /**
     * @return Returns the grillRoastSmoke.
     */
    public Boolean getGrillRoastSmoke() {
        return grillRoastSmoke;
    }

    /**
     * @param grillRoastSmoke The grillRoastSmoke to set.
     */
    public void setGrillRoastSmoke(Boolean grillRoastSmoke) {
        this.grillRoastSmoke = grillRoastSmoke;
    }

    /**
     * @return Returns the mexBreadType.
     */
    public Boolean getMexBreadType() {
        return mexBreadType;
    }

    /**
     * @param mexBreadType The mexBreadType to set.
     */
    public void setMexBreadType(Boolean mexBreadType) {
        this.mexBreadType = mexBreadType;
    }

    /**
     * @return Returns the mexIngredUse.
     */
    public Boolean getMexIngredUse() {
        return mexIngredUse;
    }

    /**
     * @param mexIngredUse The mexIngredUse to set.
     */
    public void setMexIngredUse(Boolean mexIngredUse) {
        this.mexIngredUse = mexIngredUse;
    }

    /**
     * @return Returns the pepperType.
     */
    public Boolean getPepperType() {
        return pepperType;
    }

    /**
     * @param pepperType The pepperType to set.
     */
    public void setPepperType(Boolean pepperType) {
        this.pepperType = pepperType;
    }

    /**
     * @return Returns the pizzaStyle.
     */
    public Boolean getPizzaStyle() {
        return pizzaStyle;
    }

    /**
     * @param pizzaStyle The pizzaStyle to set.
     */
    public void setPizzaStyle(Boolean pizzaStyle) {
        this.pizzaStyle = pizzaStyle;
    }

    /**
     * @return Returns the potatoTypeUse.
     */
    public Boolean getPotatoTypeUse() {
        return potatoTypeUse;
    }

    /**
     * @param potatoTypeUse The potatoTypeUse to set.
     */
    public void setPotatoTypeUse(Boolean potatoTypeUse) {
        this.potatoTypeUse = potatoTypeUse;
    }

    /**
     * @return Returns the prepEntreeType.
     */
    public Boolean getPrepEntreeType() {
        return prepEntreeType;
    }

    /**
     * @param prepEntreeType The prepEntreeType to set.
     */
    public void setPrepEntreeType(Boolean prepEntreeType) {
        this.prepEntreeType = prepEntreeType;
    }

    /**
     * @return Returns the riceTypeUse.
     */
    public Boolean getRiceTypeUse() {
        return riceTypeUse;
    }

    /**
     * @param riceTypeUse The riceTypeUse to set.
     */
    public void setRiceTypeUse(Boolean riceTypeUse) {
        this.riceTypeUse = riceTypeUse;
    }

    /**
     * @return Returns the roastVegItemType.
     */
    public Boolean getRoastVegItemType() {
        return roastVegItemType;
    }

    /**
     * @param roastVegItemType The roastVegItemType to set.
     */
    public void setRoastVegItemType(Boolean roastVegItemType) {
        this.roastVegItemType = roastVegItemType;
    }

    /**
     * @return Returns the salsaType.
     */
    public Boolean getSalsaType() {
        return salsaType;
    }

    /**
     * @param salsaType The salsaType to set.
     */
    public void setSalsaType(Boolean salsaType) {
        this.salsaType = salsaType;
    }

    /**
     * @return Returns the vegCookMeth.
     */
    public Boolean getVegCookMeth() {
        return vegCookMeth;
    }

    /**
     * @param vegCookMeth The vegCookMeth to set.
     */
    public void setVegCookMeth(Boolean vegCookMeth) {
        this.vegCookMeth = vegCookMeth;
    }

    /**
     * @return Returns the cuisineVerySpecific.
     */
    public Boolean getCuisineVerySpecific() {
        return cuisineVerySpecific;
    }

    /**
     * @param cuisineVerySpecific The cuisineVerySpecific to set.
     */
    public void setCuisineVerySpecific(Boolean cuisineVerySpecific) {
        this.cuisineVerySpecific = cuisineVerySpecific;
    }

    /**
     * @return Returns the newItemBrag.
     */
    public Boolean getNewItemBrag() {
        return newItemBrag;
    }

    /**
     * @param newItemBrag The newItemBrag to set.
     */
    public void setNewItemBrag(Boolean newItemBrag) {
        this.newItemBrag = newItemBrag;
    }

    /**
     * @return Returns the oilTypeUse.
     */
    public Boolean getOilTypeUse() {
        return oilTypeUse;
    }

    /**
     * @param oilTypeUse The oilTypeUse to set.
     */
    public void setOilTypeUse(Boolean oilTypeUse) {
        this.oilTypeUse = oilTypeUse;
    }

    /**
     * @return Returns the proteinFlavorApp.
     */
    public Boolean getProteinFlavorApp() {
        return proteinFlavorApp;
    }

    /**
     * @param proteinFlavorApp The proteinFlavorApp to set.
     */
    public void setProteinFlavorApp(Boolean proteinFlavorApp) {
        this.proteinFlavorApp = proteinFlavorApp;
    }

    public Boolean getCheeseForm() {
        return cheeseForm;
    }

    public void setCheeseForm(Boolean cheeseForm) {
        this.cheeseForm = cheeseForm;
    }

    public Boolean getCheeseSauceFillingType() {
        return cheeseSauceFillingType;
    }

    public void setCheeseSauceFillingType(Boolean cheeseSauceFillingType) {
        this.cheeseSauceFillingType = cheeseSauceFillingType;
    }

    public Boolean getEggItemUse() {
        return eggItemUse;
    }

    public void setEggItemUse(Boolean eggItemUse) {
        this.eggItemUse = eggItemUse;
    }


    public Boolean getSoupWith() {
        return soupWith;
    }

    public void setSoupWith(Boolean soupBase) {
        this.soupWith = soupBase;
    }

    public Boolean getSoupBaseBroth() {
        return soupBaseBroth;
    }

    public void setSoupBaseBroth(Boolean soupBaseBroth) {
        this.soupBaseBroth = soupBaseBroth;
    }

    public Boolean getAllVegCarbFruit() {
        return allVegCarbFruit;
    }

    public void setAllVegCarbFruit(Boolean allVegCarbFruit) {
        this.allVegCarbFruit = allVegCarbFruit;
    }

    public Boolean getVeggieAll() {
        return veggieAll;
    }

    public void setVeggieAll(Boolean veggieAll) {
        this.veggieAll = veggieAll;
    }
    
    public Boolean getBevMenuItem() {
        return bevMenuItem;
    }

    public void setBevMenuItem(Boolean bevMenuItem) {
    	if(bevMenuItem == null){
    		this.bevMenuItem = false;
    	}else{
    		this.bevMenuItem = bevMenuItem;
    	}
    }
    
    public Boolean getSideAccompDisFlavor() {
        return sideAccompDisFlavor;
    }

    public void setSideAccompDisFlavor(Boolean sideAccompDisFlavor) {
    	if(sideAccompDisFlavor == null){
    		this.sideAccompDisFlavor = false;
    	}else{
    		this.sideAccompDisFlavor = sideAccompDisFlavor;
    	}
    }
    
    public Boolean getCookieTypeSource() {
        return cookieTypeSource;
    }

    public void setCookieTypeSource(Boolean cookieTypeSource) {
    	if(cookieTypeSource == null){
    		this.cookieTypeSource = false;
    	}else{
    		this.cookieTypeSource = cookieTypeSource;
    	}
    }
    
    public Boolean getCreamyTop() {
        return creamyTop;
    }

    public void setCreamyTop(Boolean creamyTop) {
    	if(creamyTop == null){
    		this.creamyTop = false;
    	}else{
    		this.creamyTop = creamyTop;
    	}
    }
    
    public Boolean getCreamyFill() {
        return creamyFill;
    }

    public void setCreamyFill(Boolean creamyFill) {
    	if(creamyFill == null){
    		this.creamyFill = false;
    	}else{
    		this.creamyFill = creamyFill;
    	}
    }
    
    public Boolean getTextureAttrib() {
        return textureAttrib;
    }

    public void setTextureAttrib(Boolean textureAttrib) {
    	if(textureAttrib == null){
    		this.textureAttrib = false;
    	}else{
    		this.textureAttrib = textureAttrib;
    	}
    }
    
    public Boolean getQualityStyle() {
        return qualityStyle;
    }

    public void setQualityStyle(Boolean qualityStyle) {
    	if(qualityStyle == null){
    		this.qualityStyle = false;
    	}else{
    		this.qualityStyle = qualityStyle;
    	}
    }
    
    //End JDL

}