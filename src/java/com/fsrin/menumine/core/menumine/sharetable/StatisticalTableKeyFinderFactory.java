/*
 * Created on Mar 29, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.sharetable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import ognl.Ognl;
import ognl.OgnlException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fsrin.menumine.core.menumine.FieldEnum;
import com.fsrin.menumine.core.menumine.masterfood.MasterFood;

/**
 * @author Nick
 * 
 *  
 */
public class StatisticalTableKeyFinderFactory {
    
    private static Log log = LogFactory.getLog(StatisticalTableKeyFinderFactory.class);
    
    private StatisticalTableKeyFinder keywords = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getKeywords();
        }
    };
    
    private StatisticalTableKeyFinder basicProtein = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getBasicProtein();
        }
    };
    
    private StatisticalTableKeyFinder proteinTypeCut = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getProteinTypeCut();
        }
    };
    // 2009-06-01 MJB added 9 protein fields.
    private StatisticalTableKeyFinder chickenType = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getChickenType();
        }
    };

    private StatisticalTableKeyFinder beefType = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getBeefType();
        }
    };

    private StatisticalTableKeyFinder porkType = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getPorkType();
        }
    };

    private StatisticalTableKeyFinder fishType = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getFishType();
        }
    };

    private StatisticalTableKeyFinder seafoodType = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getSeafoodType();
        }
    };

    private StatisticalTableKeyFinder lambType = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getLambType();
        }
    };

    private StatisticalTableKeyFinder turkeyType = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getTurkeyType();
        }
    };

    private StatisticalTableKeyFinder otherProteinType = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getOtherProteinType();
        }
    };

    private StatisticalTableKeyFinder shrimpType = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getShrimpType();
        }
    };

    private StatisticalTableKeyFinder proteinType = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getProteinType();
        }
    };

    private StatisticalTableKeyFinder cookMeth = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getCookMeth();
        }
    };

    private StatisticalTableKeyFinder sauceCondDressMarMM = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getSauceCondDressMarMM();
        }
    };

    private StatisticalTableKeyFinder flavEnhancSeasBrdgDesIngredMM = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getFlavEnhancSeasBrdgDesIngredMM();
        }
    };

    private StatisticalTableKeyFinder carboVegFruit = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getCarboVegFruit();
        }
    };
    // 2010-10-25 MJB

    private StatisticalTableKeyFinder topFillIngredMM = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getTopFillIngredMM();
        }
    };

    private StatisticalTableKeyFinder cheeseMM = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getCheeseMM();
        }
    };

    private StatisticalTableKeyFinder breadBakeGoodsMM = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getBreadBakeGoodsMM();
        }
    };

    private StatisticalTableKeyFinder menuItem = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getMenuItem();
        }
    };

    private StatisticalTableKeyFinder menuItemType = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getMenuItemType();
        }
    };

    private StatisticalTableKeyFinder itemDescription = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getItemDescription();
        }
    };

    private StatisticalTableKeyFinder cuisine = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getCuisine();
        }
    };

    private StatisticalTableKeyFinder cuisineFamily = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getCuisineFamily();
        }
    };

    private StatisticalTableKeyFinder genCookMeth = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getGenCookMeth();
        }
    };

    private StatisticalTableKeyFinder genMenuPart = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getGenMenuPart();
        }
    };

    private StatisticalTableKeyFinder menuItemClass = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getMenuItemClass();
        }
    };

    private StatisticalTableKeyFinder menuStatus = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getMenuStatus();
        }
    };

    private StatisticalTableKeyFinder price2005 = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getPrice2005();
        }
    };

    private StatisticalTableKeyFinder price2004 = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getPrice2004();
        }
    };

    private StatisticalTableKeyFinder price2003 = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getPrice2003();
        }
    };

    private StatisticalTableKeyFinder price2002 = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getPrice2002();
        }
    };

    private StatisticalTableKeyFinder price2001 = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getPrice2001();
        }
    };

    private StatisticalTableKeyFinder price2000 = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getPrice2000();
        }
    };

    private StatisticalTableKeyFinder price1999 = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getPrice1999();
        }
    };

    private StatisticalTableKeyFinder price1998 = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getPrice1998();
        }
    };

    private StatisticalTableKeyFinder price1997 = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getPrice1997();
        }
    };

    private StatisticalTableKeyFinder price1996 = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getPrice1996();
        }
    };

    private StatisticalTableKeyFinder operationName = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
//            if (masterFood.getChain() != null) {
//                return masterFood.getChain().getOperationName();
//            }
            return masterFood.getOperationName();
            
        }
    };

    private StatisticalTableKeyFinder segment = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
//            if (masterFood.getChain() != null) {
//                return masterFood.getChain().getSegment();
//            }

                return masterFood.getSegment();
        }
    };

    private StatisticalTableKeyFinder sectorName = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
//            if (masterFood.getChain() != null) {
//                return masterFood.getChain().getSectorName();
//            }
            
                return masterFood.getSectorName();
            

            
        }
    };

    private StatisticalTableKeyFinder hqState = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
//            if (masterFood.getChain() != null) {
//                return masterFood.getChain().getHqState();
//            }

                return masterFood.getHqState();
        }
    };

    private StatisticalTableKeyFinder dayPartCategory = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getDayPartCategory();
        }
    };

    private StatisticalTableKeyFinder cakeIngredient = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getCakeIngredient();
        }
    };

    private StatisticalTableKeyFinder cakeUse = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getCakeUse();
        }
    };

    private StatisticalTableKeyFinder cookieIngredient = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getCookieIngredient();
        }
    };

    private StatisticalTableKeyFinder cookieUse = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getCookieUse();
        }
    };

    private StatisticalTableKeyFinder dessertDoughCrustIngred = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getDessertDoughCrustIngred();
        }
    };

    private StatisticalTableKeyFinder iceCreamIngredient = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getIceCreamIngredient();
        }
    };

    private StatisticalTableKeyFinder syrupTopping = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getSyrupTopping();
        }
    };

    private StatisticalTableKeyFinder nutIngredient = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getNutIngredient();
        }
    };

    private StatisticalTableKeyFinder fruitOrFruitFillingIngred = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getFruitOrFruitFillingIngred();
        }
    };

    private StatisticalTableKeyFinder whippedToppingIngred = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getWhippedToppingIngred();
        }
    };

    private StatisticalTableKeyFinder candyIngredient = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getCandyIngredient();
        }
    };

    private StatisticalTableKeyFinder primaryFlavor = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getPrimaryFlavor();
        }
    };

    private StatisticalTableKeyFinder tasteFlavorWords = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getTasteFlavorWords();
        }
    };

    private StatisticalTableKeyFinder brand = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getBrand();
        }
    };

    private StatisticalTableKeyFinder veggieFruitMM = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getVeggieFruitMM();
        }
    };

    private StatisticalTableKeyFinder carboMM = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getCarboMM();
        }
    };
    
    private StatisticalTableKeyFinder carboAll = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getCarboAll();
        }
    };

    private StatisticalTableKeyFinder breadUse = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getBreadUse();
        }
    };

    private StatisticalTableKeyFinder flavApplication = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getFlavApplication();
        }
    };

    private StatisticalTableKeyFinder flavorSoup = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getFlavorSoup();
        }
    };

    private StatisticalTableKeyFinder sideOrAccomp = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getSideOrAccomp();
        }
    };

    private StatisticalTableKeyFinder healthyTerm = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getHealthyTerm();
        }
    };

    private StatisticalTableKeyFinder cookingSauceOrGravy = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getCookingSauceOrGravy();
        }
    };

    private StatisticalTableKeyFinder marinade = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getMarinade();
        }
    };

    private StatisticalTableKeyFinder glaze = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getGlaze();
        }
    };

    private StatisticalTableKeyFinder dressings = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getDressings();
        }
    };

    private StatisticalTableKeyFinder dipSauceName = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getDipSauceName();
        }
    };

    private StatisticalTableKeyFinder dairyButterCream = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getDairyButterCream();
        }
    };

    private StatisticalTableKeyFinder onionScallionLeek = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getOnionScallionLeek();
        }
    };

    private StatisticalTableKeyFinder mushroomType = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getMushroomType();
        }
    };
    
    private StatisticalTableKeyFinder tomatoType = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getTomatoType();
        }
    };

    private StatisticalTableKeyFinder condiments = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getCondiments();
        }
    };

    private StatisticalTableKeyFinder butterApplication = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getButterApplication();
        }
    };

    private StatisticalTableKeyFinder seasoningName = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getSeasoningName();
        }
    };

    private StatisticalTableKeyFinder batterBreadingCoating = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getBatterBreadingCoating();
        }
    };

    private StatisticalTableKeyFinder stuffName = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getStuffName();
        }
    };

    private StatisticalTableKeyFinder cheeseRollUp = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getCheeseRollUp();
        }
    };

    private StatisticalTableKeyFinder cheeseCheeseSauceFillingType = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getCheeseCheeseSauceFillingType();
        }
    };

    private StatisticalTableKeyFinder proteinTopName = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getProteinTopName();
        }
    };

    private StatisticalTableKeyFinder proteinAccompName = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getProteinAccompName();
        }
    };

    private StatisticalTableKeyFinder veggieFruitType = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getVeggieFruitType();
        }
    };

    private StatisticalTableKeyFinder greenVegName = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getGreenVegName();
        }
    };

    private StatisticalTableKeyFinder vegTopName = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getVegTopName();
        }
    };

    private StatisticalTableKeyFinder vegAccompName = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getVegAccompName();
        }
    };

    private StatisticalTableKeyFinder fruitType = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getFruitType();
        }
    };

    private StatisticalTableKeyFinder carboType = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getCarboType();
        }
    };

    private StatisticalTableKeyFinder carboTopName = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getCarboTopName();
        }
    };

    private StatisticalTableKeyFinder carboAccompName = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getCarboAccompName();
        }
    };

    private StatisticalTableKeyFinder breadWrapChips = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getBreadWrapChips();
        }
    };

    private StatisticalTableKeyFinder eggType = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getEggType();
        }
    };

    private StatisticalTableKeyFinder hotColdCereal = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getHotColdCereal();
        }
    };

    private StatisticalTableKeyFinder spreadType = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getSpreadType();
        }
    };

    private StatisticalTableKeyFinder breakfastPastry = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getBreakfastPastry();
        }
    };

    private StatisticalTableKeyFinder breakCakeWaff = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getBreakCakeWaff();
        }
    };

    private StatisticalTableKeyFinder logoImageStyle = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getLogoImageStyle();
        }
    };

    private StatisticalTableKeyFinder bevSize = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getBevSize();
        }
    };

    private StatisticalTableKeyFinder servingCount = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getServingCount();
        }
    };

    private StatisticalTableKeyFinder hqRegion = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
//            if (masterFood.getChain() != null) {
//                return masterFood.getChain().getHqRegion();
//            }
            return masterFood.getHqRegion();
        }
    };

    private StatisticalTableKeyFinder operatorType = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
//            if (masterFood.getChain() != null) {
//                return masterFood.getChain().getHqRegion();
//            }
            return masterFood.getHqRegion();
        }
    };

    private StatisticalTableKeyFinder countryLoc = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
//            if (masterFood.getChain() != null) {
//                return masterFood.getChain().getCountryLoc();
//            }
                return masterFood.getCountryLoc();
        }
    };

    private StatisticalTableKeyFinder yearPutInDatabase = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
//            if (masterFood.getChain() != null) {
//                return masterFood.getChain().getYearPutInDatabase();
//            }
            return masterFood.getYearPutInDatabase();
        }
    };
    
    /*
     * 2006-01-17 RSC
     */
    private StatisticalTableKeyFinder proteinFishShrimpSeafood = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getProteinFishShrimpSeafood();
        }
    };
    
    private StatisticalTableKeyFinder chainID = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getChainID();
        }
    };
    
    /*
     * 2006-08-02 rsc1@fivesticks.com
     */
    private StatisticalTableKeyFinder price2006 = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getPrice2006();
        }
    };    

    //JDL 10-5-07
    private StatisticalTableKeyFinder price2007 = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getPrice2007();
        }
    };
    
    // DBB 1-20-2009
    private StatisticalTableKeyFinder price2008 = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getPrice2008();
        }
    };
        
    private StatisticalTableKeyFinder price2009 = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getPrice2009();
        }
    };
    // MJB 11-12-2009 Added 2010
    private StatisticalTableKeyFinder price2010 = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getPrice2010();
        }
    };
    
    private StatisticalTableKeyFinder price2011 = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getPrice2011();
        }
    };
    
    
    private StatisticalTableKeyFinder cuisineVerySpecific= new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getCuisineVerySpecific();
        }
    };    
    private StatisticalTableKeyFinder grillRoastSmoke= new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getGrillRoastSmoke();
        }
    };    
    private StatisticalTableKeyFinder vegCookMeth  = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getVegCookMeth();
        }
    };     
    private StatisticalTableKeyFinder cookSauceType = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getCookSauceType();
        }
    };    
    private StatisticalTableKeyFinder dressingType= new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getDressingType();
        }
    };    
    private StatisticalTableKeyFinder dressingFlavor= new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getDressingFlavor();
        }
    };    
    private StatisticalTableKeyFinder mexBreadType= new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getMexBreadType();
        }
    };    
    private StatisticalTableKeyFinder roastVegItemType  = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getRoastVegItemType();
        }
    };    
    private StatisticalTableKeyFinder appetClassTyp= new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getAppetClassTyp();
        }
    };    
    private StatisticalTableKeyFinder prepEntreeType= new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getPrepEntreeType();
        }
    };    
    private StatisticalTableKeyFinder breadedFriedAppSide  = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getBreadedFriedAppSide();
        }
    };    
    private StatisticalTableKeyFinder potatoTypeUse= new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getPotatoTypeUse();
        }
    };    
    private StatisticalTableKeyFinder salsaType = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getSalsaType();
        }
    };    
    private StatisticalTableKeyFinder cookieLookAlikeDessert  = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getCookieLookAlikeDessert();
        }
    };      
    private StatisticalTableKeyFinder breakfastToGo= new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getBreakfastToGo();
        }
    };    
    private StatisticalTableKeyFinder pizzaStyle= new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getPizzaStyle();
        }
    };    
    private StatisticalTableKeyFinder bbqCook= new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getBbqCook();
        }
    };    
    private StatisticalTableKeyFinder ethnicBreadType  = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getEthnicBreadType();
        }
    };     
    private StatisticalTableKeyFinder pepperType= new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getPepperType();
        }
    };    
    private StatisticalTableKeyFinder riceTypeUse= new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getRiceTypeUse();
        }
    };    
    private StatisticalTableKeyFinder mexIngredUse = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getMexIngredUse();
        }
    };    
    private StatisticalTableKeyFinder flavorChangeAnyYear  = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getFlavorChangeAnyYear();
        }
    };      

    
    
    
    
    private StatisticalTableKeyFinder newItemBrag= new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getNewItemBrag();
        }
    };    
    private StatisticalTableKeyFinder proteinFlavorApp = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getProteinFlavorApp();
        }
    };    
    private StatisticalTableKeyFinder oilTypeUse  = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getOilTypeUse();
        }
    }; 
    

    private StatisticalTableKeyFinder eggItemUse= new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getEggItemUse();
        }
    };    
    private StatisticalTableKeyFinder cheeseForm = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getCheeseForm();
        }
    };    
    private StatisticalTableKeyFinder cheeseSauceFillingType  = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getCheeseSauceFillingType();
        }
    }; 
    
    /*
     * 2006-09-06
     */
    private StatisticalTableKeyFinder soupWith= new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getSoupWith();
        }
    };    
    private StatisticalTableKeyFinder soupBaseBroth = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getSoupBaseBroth();
        }
    };    

    /*
     * 7-27-07 JDL
     */
    
    private StatisticalTableKeyFinder bevMenuItem = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getBevMenuItem();
        }
    };
    
    private StatisticalTableKeyFinder sideAccompDisFlavor = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getSideAccompDisFlavor();
        }
    };

    private StatisticalTableKeyFinder CookieTypeSource = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getCookieTypeSource();
        }
    };
    
    private StatisticalTableKeyFinder CreamyTop = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getCreamyTop();
        }
    };
    
    private StatisticalTableKeyFinder creamyFill = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getCreamyFill();
        }
    };
    
    private StatisticalTableKeyFinder OtherTopIngred = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getOtherTopIngred();
        }
    };
    
    private StatisticalTableKeyFinder TextureAttrib = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getTextureAttrib();
        }
    };
    
    private StatisticalTableKeyFinder QualityStyle = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getQualityStyle();
        }
    };
    //END JDL --Bottom may need modification
    
    /*
     * 2006-11-07
     */
    private StatisticalTableKeyFinder veggieAll= new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getVeggieAll();
        }
    };    
    private StatisticalTableKeyFinder allVegCarbFruit = new AbstractStatisticalTableKeyFinder() {
        protected Object findKey(MasterFood masterFood) {
            return masterFood.getAllVegCarbFruit();
        }
    };     
    
    
    public StatisticalTableKeyFinderFactory() {
        super();
    }

    public StatisticalTableKeyFinder build(FieldEnum fieldEnum) {
        
        log.info("FieldEnum " + fieldEnum.getOgnlName());
        
        try {
            return (StatisticalTableKeyFinder) Ognl.getValue(fieldEnum
                    .getShortOgnlName(), this);
        } catch (OgnlException e) {

            e.printStackTrace();
            return null;
        }
    }

    public StatisticalTableKeyFinder getBasicProtein() {
        return basicProtein;
    }

    public StatisticalTableKeyFinder getBreadBakeGoodsMM() {
        return breadBakeGoodsMM;
    }

    public StatisticalTableKeyFinder getCarboVegFruit() {
        return carboVegFruit;
    }
    
    public StatisticalTableKeyFinder getCheeseMM() {
        return cheeseMM;
    }

    public StatisticalTableKeyFinder getCookMeth() {
        return cookMeth;
    }

    public StatisticalTableKeyFinder getCuisine() {
        return cuisine;
    }

    public StatisticalTableKeyFinder getCuisineFamily() {
        return cuisineFamily;
    }

    public StatisticalTableKeyFinder getFlavEnhancSeasBrdgDesIngredMM() {
        return flavEnhancSeasBrdgDesIngredMM;
    }

    public StatisticalTableKeyFinder getGenCookMeth() {
        return genCookMeth;
    }

    public StatisticalTableKeyFinder getGenMenuPart() {
        return genMenuPart;
    }

    public StatisticalTableKeyFinder getItemDescription() {
        return itemDescription;
    }

    public StatisticalTableKeyFinder getMenuItem() {
        return menuItem;
    }

    public StatisticalTableKeyFinder getMenuItemClass() {
        return menuItemClass;
    }

    public StatisticalTableKeyFinder getMenuItemType() {
        return menuItemType;
    }

    public StatisticalTableKeyFinder getMenuStatus() {
        return menuStatus;
    }

    public StatisticalTableKeyFinder getPrice1996() {
        return price1996;
    }

    public StatisticalTableKeyFinder getPrice1997() {
        return price1997;
    }

    public StatisticalTableKeyFinder getPrice1998() {
        return price1998;
    }

    public StatisticalTableKeyFinder getPrice1999() {
        return price1999;
    }

    public StatisticalTableKeyFinder getPrice2000() {
        return price2000;
    }

    public StatisticalTableKeyFinder getPrice2001() {
        return price2001;
    }

    public StatisticalTableKeyFinder getPrice2002() {
        return price2002;
    }

    public StatisticalTableKeyFinder getPrice2003() {
        return price2003;
    }

    public StatisticalTableKeyFinder getPrice2004() {
        return price2004;
    }

    public StatisticalTableKeyFinder getPrice2005() {
        return price2005;
    }
    
    public StatisticalTableKeyFinder getPrice2006() {
        return price2006;
    }   
    
    //JDL 10-5-07
    public StatisticalTableKeyFinder getPrice2007() {
        return price2007;
    } 
    
    //DBB 1-20-2009 Add 2007, 2009
    public StatisticalTableKeyFinder getPrice2008() {
        return price2008;
    } 
    
    public StatisticalTableKeyFinder getPrice2009() {
        return price2009;
    } 
    
    //MJB 11-12-2009 Added 2010
    public StatisticalTableKeyFinder getPrice2010() {
        return price2010;
    }
    
    public StatisticalTableKeyFinder getPrice2011() {
        return price2011;
    }
    
    public StatisticalTableKeyFinder getProteinType() {
        return proteinType;
    }
    // 2009-06-01 MJB added 9 protein fields below.
    public StatisticalTableKeyFinder getChickenType() {
        return chickenType;
    }
    
    public StatisticalTableKeyFinder getBeefType() {
        return beefType;
    }
    
    public StatisticalTableKeyFinder getPorkType() {
        return porkType;
    }
    
    public StatisticalTableKeyFinder getFishType() {
        return fishType;
    }
    
    public StatisticalTableKeyFinder getSeafoodType() {
        return seafoodType;
    }
    
    public StatisticalTableKeyFinder getLambType() {
        return lambType;
    }
    
    public StatisticalTableKeyFinder getTurkeyType() {
        return turkeyType;
    }
    
    public StatisticalTableKeyFinder getOtherProteinType() {
        return otherProteinType;
    }
    
    public StatisticalTableKeyFinder getShrimpType() {
        return shrimpType;
    }
    
    public StatisticalTableKeyFinder getProteinTypeCut() {
        return proteinTypeCut;
    }

    public StatisticalTableKeyFinder getSauceCondDressMarMM() {
        return sauceCondDressMarMM;
    }

    public StatisticalTableKeyFinder getTopFillIngredMM() {
        return topFillIngredMM;
    }

    public StatisticalTableKeyFinder getHqState() {
        return hqState;
    }

    public StatisticalTableKeyFinder getOperationName() {
        return operationName;
    }

    public StatisticalTableKeyFinder getSectorName() {
        return sectorName;
    }

    public StatisticalTableKeyFinder getSegment() {
        return segment;
    }

    public StatisticalTableKeyFinder getBrand() {
        return brand;
    }

    public StatisticalTableKeyFinder getCakeIngredient() {
        return cakeIngredient;
    }

    public StatisticalTableKeyFinder getCakeUse() {
        return cakeUse;
    }

    public StatisticalTableKeyFinder getCandyIngredient() {
        return candyIngredient;
    }

    public StatisticalTableKeyFinder getCookieIngredient() {
        return cookieIngredient;
    }

    public StatisticalTableKeyFinder getCookieUse() {
        return cookieUse;
    }

    public StatisticalTableKeyFinder getDayPartCategory() {
        return dayPartCategory;
    }

    public StatisticalTableKeyFinder getDessertDoughCrustIngred() {
        return dessertDoughCrustIngred;
    }

    public StatisticalTableKeyFinder getFruitOrFruitFillingIngred() {
        return fruitOrFruitFillingIngred;
    }

    public StatisticalTableKeyFinder getIceCreamIngredient() {
        return iceCreamIngredient;
    }

    public StatisticalTableKeyFinder getNutIngredient() {
        return nutIngredient;
    }

    public StatisticalTableKeyFinder getPrimaryFlavor() {
        return primaryFlavor;
    }

    public StatisticalTableKeyFinder getSyrupTopping() {
        return syrupTopping;
    }

    public StatisticalTableKeyFinder getTasteFlavorWords() {
        return tasteFlavorWords;
    }

    public StatisticalTableKeyFinder getWhippedToppingIngred() {
        return whippedToppingIngred;
    }

    public StatisticalTableKeyFinder getBreadUse() {
        return breadUse;
    }

    public void setBreadUse(StatisticalTableKeyFinder breadUse) {
        this.breadUse = breadUse;
    }

    public StatisticalTableKeyFinder getCarboMM() {
        return carboMM;
    }

    public void setCarboMM(StatisticalTableKeyFinder carboMM) {
        this.carboMM = carboMM;
    }
    
    public StatisticalTableKeyFinder getCarboAll() {
        return carboAll;
    }

    public void setCarboAll(StatisticalTableKeyFinder carboAll) {
        this.carboAll = carboAll;
    }

    public StatisticalTableKeyFinder getFlavApplication() {
        return flavApplication;
    }

    public void setFlavApplication(StatisticalTableKeyFinder flavApplication) {
        this.flavApplication = flavApplication;
    }

    public StatisticalTableKeyFinder getFlavorSoup() {
        return flavorSoup;
    }

    public void setFlavorSoup(StatisticalTableKeyFinder flavorSoup) {
        this.flavorSoup = flavorSoup;
    }

    public StatisticalTableKeyFinder getSideOrAccomp() {
        return sideOrAccomp;
    }

    public void setSideOrAccomp(StatisticalTableKeyFinder sideOrAccomp) {
        this.sideOrAccomp = sideOrAccomp;
    }

    public StatisticalTableKeyFinder getVeggieFruitMM() {
        return veggieFruitMM;
    }

    public void setVeggieFruitMM(StatisticalTableKeyFinder veggieFruitMM) {
        this.veggieFruitMM = veggieFruitMM;
    }
    
    
    public StatisticalTableKeyFinder getSideAccompDisFlavor() {
        return sideAccompDisFlavor;
    }

    public void setSideAccompDisFlavor(StatisticalTableKeyFinder sideAccompDisFlavor) {
        this.sideAccompDisFlavor = sideAccompDisFlavor;
    }
    
    public StatisticalTableKeyFinder getCookieTypeSource() {
        return CookieTypeSource;
    }

    public void setCookieTypeSource(StatisticalTableKeyFinder CookieTypeSource) {
        this.CookieTypeSource = CookieTypeSource;
    }
    
    
    public StatisticalTableKeyFinder getCreamyTop() {
        return CreamyTop;
    }

    public void setCreamyTop(StatisticalTableKeyFinder CreamyTop) {
        this.CreamyTop = CreamyTop;
    }
    
   
    public StatisticalTableKeyFinder getCreamyFill() {
        return creamyFill;
    }

    public void setCreamyFill(StatisticalTableKeyFinder creamyFill) {
        this.creamyFill = creamyFill;
    }
    
    public StatisticalTableKeyFinder getOtherTopIngred() {
        return OtherTopIngred;
    }

    public void setOtherTopIngred(StatisticalTableKeyFinder OtherTopIngred) {
        this.OtherTopIngred = OtherTopIngred;
    }
    
    
    public StatisticalTableKeyFinder getTextureAttrib() {
        return TextureAttrib;
    }

    public void setTextureAttrib(StatisticalTableKeyFinder TextureAttrib) {
        this.TextureAttrib = TextureAttrib;
    }
    
    public StatisticalTableKeyFinder getQualityStyle() {
        return QualityStyle;
    }

    public void setQualityStyle(StatisticalTableKeyFinder QualityStyle) {
        this.QualityStyle = QualityStyle;
    }
    
    public void setBasicProtein(StatisticalTableKeyFinder basicProtein) {
        this.basicProtein = basicProtein;
    }

    public void setBrand(StatisticalTableKeyFinder brand) {
        this.brand = brand;
    }

    public void setBreadBakeGoodsMM(StatisticalTableKeyFinder breadBakeGoodsMM) {
        this.breadBakeGoodsMM = breadBakeGoodsMM;
    }

    public void setCakeIngredient(StatisticalTableKeyFinder cakeIngredient) {
        this.cakeIngredient = cakeIngredient;
    }

    public void setCakeUse(StatisticalTableKeyFinder cakeUse) {
        this.cakeUse = cakeUse;
    }

    public void setCandyIngredient(StatisticalTableKeyFinder candyIngredient) {
        this.candyIngredient = candyIngredient;
    }

    public void setCarboVegFruit(StatisticalTableKeyFinder carboVegFruit) {
        this.carboVegFruit = carboVegFruit;
    }
    
    public void setCheeseMM(StatisticalTableKeyFinder cheeseMM) {
        this.cheeseMM = cheeseMM;
    }

    public void setCookieIngredient(StatisticalTableKeyFinder cookieIngredient) {
        this.cookieIngredient = cookieIngredient;
    }

    public void setCookieUse(StatisticalTableKeyFinder cookieUse) {
        this.cookieUse = cookieUse;
    }

    public void setCookMeth(StatisticalTableKeyFinder cookMeth) {
        this.cookMeth = cookMeth;
    }

    public void setCuisine(StatisticalTableKeyFinder cuisine) {
        this.cuisine = cuisine;
    }

    public void setCuisineFamily(StatisticalTableKeyFinder cuisineFamily) {
        this.cuisineFamily = cuisineFamily;
    }

    public void setDayPartCategory(StatisticalTableKeyFinder dayPartCategory) {
        this.dayPartCategory = dayPartCategory;
    }

    public void setDessertDoughCrustIngred(
            StatisticalTableKeyFinder dessertDoughCrustIngred) {
        this.dessertDoughCrustIngred = dessertDoughCrustIngred;
    }

    public void setFlavEnhancSeasBrdgDesIngredMM(
            StatisticalTableKeyFinder flavEnhancSeasBrdgDesIngredMM) {
        this.flavEnhancSeasBrdgDesIngredMM = flavEnhancSeasBrdgDesIngredMM;
    }

    public void setFruitOrFruitFillingIngred(
            StatisticalTableKeyFinder fruitOrFruitFillingIngred) {
        this.fruitOrFruitFillingIngred = fruitOrFruitFillingIngred;
    }

    public void setGenCookMeth(StatisticalTableKeyFinder genCookMeth) {
        this.genCookMeth = genCookMeth;
    }

    public void setGenMenuPart(StatisticalTableKeyFinder genMenuPart) {
        this.genMenuPart = genMenuPart;
    }

    public void setHqState(StatisticalTableKeyFinder hqState) {
        this.hqState = hqState;
    }

    public void setIceCreamIngredient(
            StatisticalTableKeyFinder iceCreamIngredient) {
        this.iceCreamIngredient = iceCreamIngredient;
    }

    public void setItemDescription(StatisticalTableKeyFinder itemDescription) {
        this.itemDescription = itemDescription;
    }

    public void setMenuItem(StatisticalTableKeyFinder menuItem) {
        this.menuItem = menuItem;
    }

    public void setMenuItemClass(StatisticalTableKeyFinder menuItemClass) {
        this.menuItemClass = menuItemClass;
    }

    public void setMenuItemType(StatisticalTableKeyFinder menuItemType) {
        this.menuItemType = menuItemType;
    }

    public void setMenuStatus(StatisticalTableKeyFinder menuStatus) {
        this.menuStatus = menuStatus;
    }

    public void setNutIngredient(StatisticalTableKeyFinder nutIngredient) {
        this.nutIngredient = nutIngredient;
    }

    public void setOperationName(StatisticalTableKeyFinder operationName) {
        this.operationName = operationName;
    }

    public void setPrice1996(StatisticalTableKeyFinder price1996) {
        this.price1996 = price1996;
    }

    public void setPrice1997(StatisticalTableKeyFinder price1997) {
        this.price1997 = price1997;
    }

    public void setPrice1998(StatisticalTableKeyFinder price1998) {
        this.price1998 = price1998;
    }

    public void setPrice1999(StatisticalTableKeyFinder price1999) {
        this.price1999 = price1999;
    }

    public void setPrice2000(StatisticalTableKeyFinder price2000) {
        this.price2000 = price2000;
    }

    public void setPrice2001(StatisticalTableKeyFinder price2001) {
        this.price2001 = price2001;
    }

    public void setPrice2002(StatisticalTableKeyFinder price2002) {
        this.price2002 = price2002;
    }

    public void setPrice2003(StatisticalTableKeyFinder price2003) {
        this.price2003 = price2003;
    }

    public void setPrice2004(StatisticalTableKeyFinder price2004) {
        this.price2004 = price2004;
    }

    public void setPrice2005(StatisticalTableKeyFinder price2005) {
        this.price2005 = price2005;
    }
    
    public void setPrice2006(StatisticalTableKeyFinder price2006) {
        this.price2006 = price2006;
    }
    
    //JDL 10-5-07
    public void setPrice2007(StatisticalTableKeyFinder price2007) {
        this.price2007 = price2007;
    }
    
    // DBB 1-20-2009 Add 2008, 2009
    public void setPrice2008(StatisticalTableKeyFinder price2008) {
        this.price2008 = price2008;
    }
    
    public void setPrice2009(StatisticalTableKeyFinder price2009) {
        this.price2009 = price2009;
    }
    
    // MJB 11-12-2009 Added 2010
    public void setPrice2010(StatisticalTableKeyFinder price2010) {
        this.price2010 = price2010;
    }
    
    public void setPrice2011(StatisticalTableKeyFinder price2011) {
        this.price2011 = price2011;
    }
    
    public void setPrimaryFlavor(StatisticalTableKeyFinder primaryFlavor) {
        this.primaryFlavor = primaryFlavor;
    }

    public void setProteinType(StatisticalTableKeyFinder proteinType) {
        this.proteinType = proteinType;
    }

    public void setProteinTypeCut(StatisticalTableKeyFinder proteinTypeCut) {
        this.proteinTypeCut = proteinTypeCut;
    }
    
    public void setChickenType(StatisticalTableKeyFinder chickenType) {
        this.chickenType = chickenType;
    }
    
    public void setBeefType(StatisticalTableKeyFinder beefType) {
        this.beefType = beefType;
    }
    
    public void setPorkType(StatisticalTableKeyFinder porkType) {
        this.porkType = porkType;
    }
    
    public void setFishType(StatisticalTableKeyFinder fishType) {
        this.fishType = fishType;
    }
    
    public void setSeafoodType(StatisticalTableKeyFinder seafoodType) {
        this.seafoodType = seafoodType;
    }
    
    public void setLambType(StatisticalTableKeyFinder lambType) {
        this.lambType = lambType;
    }
    
    public void setTurkeyType(StatisticalTableKeyFinder turkeyType) {
        this.turkeyType = turkeyType;
    }
    
    public void setOtherProteinType(StatisticalTableKeyFinder otherProteinType) {
        this.otherProteinType = otherProteinType;
    }
    
    public void setShrimpType(StatisticalTableKeyFinder shrimpType) {
        this.shrimpType = shrimpType;
    }
    
    public void setSauceCondDressMarMM(
            StatisticalTableKeyFinder sauceCondDressMarMM) {
        this.sauceCondDressMarMM = sauceCondDressMarMM;
    }

    public void setSectorName(StatisticalTableKeyFinder sectorName) {
        this.sectorName = sectorName;
    }

    public void setSegment(StatisticalTableKeyFinder segment) {
        this.segment = segment;
    }

    public void setSyrupTopping(StatisticalTableKeyFinder syrupTopping) {
        this.syrupTopping = syrupTopping;
    }

    public void setTasteFlavorWords(StatisticalTableKeyFinder tasteFlavorWords) {
        this.tasteFlavorWords = tasteFlavorWords;
    }

    public void setTopFillIngredMM(StatisticalTableKeyFinder topFillIngredMM) {
        this.topFillIngredMM = topFillIngredMM;
    }

    public void setWhippedToppingIngred(
            StatisticalTableKeyFinder whippedToppingIngred) {
        this.whippedToppingIngred = whippedToppingIngred;
    }

    public StatisticalTableKeyFinder getHealthyTerm() {
        return healthyTerm;
    }

    public void setHealthyTerm(StatisticalTableKeyFinder healthyTerm) {
        this.healthyTerm = healthyTerm;
    }

    public StatisticalTableKeyFinder getBatterBreadingCoating() {
        return batterBreadingCoating;
    }

    public void setBatterBreadingCoating(
            StatisticalTableKeyFinder batterBreadingCoating) {
        this.batterBreadingCoating = batterBreadingCoating;
    }

    public StatisticalTableKeyFinder getBreadWrapChips() {
        return breadWrapChips;
    }

    public void setBreadWrapChips(StatisticalTableKeyFinder breadWrapChips) {
        this.breadWrapChips = breadWrapChips;
    }

    public StatisticalTableKeyFinder getButterApplication() {
        return butterApplication;
    }

    public void setButterApplication(StatisticalTableKeyFinder butterApplication) {
        this.butterApplication = butterApplication;
    }

    public StatisticalTableKeyFinder getCarboAccompName() {
        return carboAccompName;
    }

    public void setCarboAccompName(StatisticalTableKeyFinder carboAccompName) {
        this.carboAccompName = carboAccompName;
    }

    public StatisticalTableKeyFinder getCarboTopName() {
        return carboTopName;
    }

    public void setCarboTopName(StatisticalTableKeyFinder carboTopName) {
        this.carboTopName = carboTopName;
    }

    public StatisticalTableKeyFinder getCarboType() {
        return carboType;
    }

    public void setCarboType(StatisticalTableKeyFinder carboType) {
        this.carboType = carboType;
    }

    public StatisticalTableKeyFinder getCheeseCheeseSauceFillingType() {
        return cheeseCheeseSauceFillingType;
    }

    public void setCheeseCheeseSauceFillingType(
            StatisticalTableKeyFinder cheeseCheeseSauceFillingType) {
        this.cheeseCheeseSauceFillingType = cheeseCheeseSauceFillingType;
    }

    public StatisticalTableKeyFinder getCheeseRollUp() {
        return cheeseRollUp;
    }

    public void setCheeseRollUp(StatisticalTableKeyFinder cheeseRollUp) {
        this.cheeseRollUp = cheeseRollUp;
    }

    public StatisticalTableKeyFinder getCondiments() {
        return condiments;
    }

    public void setCondiments(StatisticalTableKeyFinder condiments) {
        this.condiments = condiments;
    }

    public StatisticalTableKeyFinder getCookingSauceOrGravy() {
        return cookingSauceOrGravy;
    }

    public void setCookingSauceOrGravy(
            StatisticalTableKeyFinder cookingSauceOrGravy) {
        this.cookingSauceOrGravy = cookingSauceOrGravy;
    }

    public StatisticalTableKeyFinder getDipSauceName() {
        return dipSauceName;
    }

    public void setDipSauceName(StatisticalTableKeyFinder dipSauceName) {
        this.dipSauceName = dipSauceName;
    }
    
    public StatisticalTableKeyFinder getDairyButterCream() {
        return dairyButterCream;
    }

    public void setDairyButterCream(StatisticalTableKeyFinder dairyButterCream) {
        this.dairyButterCream = dairyButterCream;
    }
    
    public StatisticalTableKeyFinder getOnionScallionLeek() {
        return onionScallionLeek;
    }

    public void setOnionScallionLeek(StatisticalTableKeyFinder onionScallionLeek) {
        this.onionScallionLeek = onionScallionLeek;
    }

    public StatisticalTableKeyFinder getMushroomType() {
        return mushroomType;
    }

    public void setMushroomType(StatisticalTableKeyFinder mushroomType) {
        this.mushroomType = mushroomType;
    }
    
    public StatisticalTableKeyFinder getTomatoType() {
        return tomatoType;
    }

    public void setTomatoType(StatisticalTableKeyFinder tomatoType) {
        this.tomatoType = tomatoType;
    }

    public StatisticalTableKeyFinder getDressings() {
        return dressings;
    }

    public void setDressings(StatisticalTableKeyFinder dressings) {
        this.dressings = dressings;
    }

    public StatisticalTableKeyFinder getFruitType() {
        return fruitType;
    }

    public void setFruitType(StatisticalTableKeyFinder fruitType) {
        this.fruitType = fruitType;
    }

    public StatisticalTableKeyFinder getGlaze() {
        return glaze;
    }

    public void setGlaze(StatisticalTableKeyFinder glaze) {
        this.glaze = glaze;
    }

    public StatisticalTableKeyFinder getGreenVegName() {
        return greenVegName;
    }

    public void setGreenVegName(StatisticalTableKeyFinder greenVegName) {
        this.greenVegName = greenVegName;
    }

    public StatisticalTableKeyFinder getMarinade() {
        return marinade;
    }

    public void setMarinade(StatisticalTableKeyFinder marinade) {
        this.marinade = marinade;
    }

    public StatisticalTableKeyFinder getProteinAccompName() {
        return proteinAccompName;
    }

    public void setProteinAccompName(StatisticalTableKeyFinder proteinAccompName) {
        this.proteinAccompName = proteinAccompName;
    }

    public StatisticalTableKeyFinder getProteinTopName() {
        return proteinTopName;
    }

    public void setProteinTopName(StatisticalTableKeyFinder proteinTopName) {
        this.proteinTopName = proteinTopName;
    }

    public StatisticalTableKeyFinder getSeasoningName() {
        return seasoningName;
    }

    public void setSeasoningName(StatisticalTableKeyFinder seasoningName) {
        this.seasoningName = seasoningName;
    }

    public StatisticalTableKeyFinder getStuffName() {
        return stuffName;
    }

    public void setStuffName(StatisticalTableKeyFinder stuffName) {
        this.stuffName = stuffName;
    }

    public StatisticalTableKeyFinder getVegAccompName() {
        return vegAccompName;
    }

    public void setVegAccompName(StatisticalTableKeyFinder vegAccompName) {
        this.vegAccompName = vegAccompName;
    }

    public StatisticalTableKeyFinder getVeggieFruitType() {
        return veggieFruitType;
    }

    public void setVeggieFruitType(StatisticalTableKeyFinder veggieFruitType) {
        this.veggieFruitType = veggieFruitType;
    }
    
    public StatisticalTableKeyFinder getVeggieAll() {
        return veggieAll;
    }

    public void setVeggieAll(StatisticalTableKeyFinder veggieAll) {
        this.veggieAll = veggieAll;
    }

    public StatisticalTableKeyFinder getVegTopName() {
        return vegTopName;
    }

    public void setVegTopName(StatisticalTableKeyFinder vegTopName) {
        this.vegTopName = vegTopName;
    }

    public Collection getAll() {
        Collection all = new ArrayList();
        for (Iterator iter = FieldEnum.getAll().iterator(); iter.hasNext();) {
            FieldEnum field = (FieldEnum) iter.next();
            try {
                Object o = Ognl.getValue(field.getShortOgnlName(), this);
                all.add(o);

            } catch (OgnlException e) {

                e.printStackTrace();
            }
        }
        return all;
    }

    public StatisticalTableKeyFinder getBevSize() {
        return bevSize;
    }

    public void setBevSize(StatisticalTableKeyFinder bevSize) {
        this.bevSize = bevSize;
    }
    
    public StatisticalTableKeyFinder BevMenuItem() {
        return bevMenuItem;
    }

    public void setBevMenuItem(StatisticalTableKeyFinder bevMenuItem) {
        this.bevMenuItem = bevMenuItem;
    }

    public StatisticalTableKeyFinder getBreakCakeWaff() {
        return breakCakeWaff;
    }

    public void setBreakCakeWaff(StatisticalTableKeyFinder breakCakeWaff) {
        this.breakCakeWaff = breakCakeWaff;
    }

    public StatisticalTableKeyFinder getBreakfastPastry() {
        return breakfastPastry;
    }

    public void setBreakfastPastry(StatisticalTableKeyFinder breakfastPastry) {
        this.breakfastPastry = breakfastPastry;
    }

    public StatisticalTableKeyFinder getCountryLoc() {
        return countryLoc;
    }

    public void setCountryLoc(StatisticalTableKeyFinder countryLoc) {
        this.countryLoc = countryLoc;
    }

    public StatisticalTableKeyFinder getEggType() {
        return eggType;
    }

    public void setEggType(StatisticalTableKeyFinder eggType) {
        this.eggType = eggType;
    }

    public StatisticalTableKeyFinder getHotColdCereal() {
        return hotColdCereal;
    }

    public void setHotColdCereal(StatisticalTableKeyFinder hotColdCereal) {
        this.hotColdCereal = hotColdCereal;
    }

    public StatisticalTableKeyFinder getHqRegion() {
        return hqRegion;
    }

    public void setHqRegion(StatisticalTableKeyFinder hqRegion) {
        this.hqRegion = hqRegion;
    }

    public StatisticalTableKeyFinder getLogoImageStyle() {
        return logoImageStyle;
    }

    public void setLogoImageStyle(StatisticalTableKeyFinder logoImageStyle) {
        this.logoImageStyle = logoImageStyle;
    }

    public StatisticalTableKeyFinder getOperatorType() {
        return operatorType;
    }

    public void setOperatorType(StatisticalTableKeyFinder operatorType) {
        this.operatorType = operatorType;
    }

    public StatisticalTableKeyFinder getServingCount() {
        return servingCount;
    }

    public void setServingCount(StatisticalTableKeyFinder servingCount) {
        this.servingCount = servingCount;
    }

    public StatisticalTableKeyFinder getSpreadType() {
        return spreadType;
    }

    public void setSpreadType(StatisticalTableKeyFinder spreadType) {
        this.spreadType = spreadType;
    }
    public StatisticalTableKeyFinder getYearPutInDatabase() {
        return yearPutInDatabase;
    }
    public void setYearPutInDatabase(StatisticalTableKeyFinder yearPutInDatabase) {
        this.yearPutInDatabase = yearPutInDatabase;
    }

    /*
     * 2006-01-17 RSC
     */
    /**
     * @return Returns the proteinFishShrimpSeafood.
     */
    public StatisticalTableKeyFinder getProteinFishShrimpSeafood() {
        return proteinFishShrimpSeafood;
    }

    /**
     * @param proteinFishShrimpSeafood The proteinFishShrimpSeafood to set.
     */
    public void setProteinFishShrimpSeafood(
            StatisticalTableKeyFinder proteinFishShrimpSeafood) {
        this.proteinFishShrimpSeafood = proteinFishShrimpSeafood;
    }

    public StatisticalTableKeyFinder getChainID() {
        return chainID;
    }

    public void setChainID(StatisticalTableKeyFinder chainID) {
        this.chainID = chainID;
    }

    public StatisticalTableKeyFinder getKeywords() {
        return keywords;
    }

    public void setKeywords(StatisticalTableKeyFinder keywords) {
        this.keywords = keywords;
    }

    /**
     * @return Returns the appetClassTyp.
     */
    public StatisticalTableKeyFinder getAppetClassTyp() {
        return appetClassTyp;
    }

    /**
     * @param appetClassTyp The appetClassTyp to set.
     */
    public void setAppetClassTyp(StatisticalTableKeyFinder appetClassTyp) {
        this.appetClassTyp = appetClassTyp;
    }

    /**
     * @return Returns the bbqCook.
     */
    public StatisticalTableKeyFinder getBbqCook() {
        return bbqCook;
    }

    /**
     * @param bbqCook The bbqCook to set.
     */
    public void setBbqCook(StatisticalTableKeyFinder bbqCook) {
        this.bbqCook = bbqCook;
    }

    /**
     * @return Returns the breadedFriedAppSide.
     */
    public StatisticalTableKeyFinder getBreadedFriedAppSide() {
        return breadedFriedAppSide;
    }

    /**
     * @param breadedFriedAppSide The breadedFriedAppSide to set.
     */
    public void setBreadedFriedAppSide(StatisticalTableKeyFinder breadedFriedAppSide) {
        this.breadedFriedAppSide = breadedFriedAppSide;
    }

    /**
     * @return Returns the breakfastToGo.
     */
    public StatisticalTableKeyFinder getBreakfastToGo() {
        return breakfastToGo;
    }

    /**
     * @param breakfastToGo The breakfastToGo to set.
     */
    public void setBreakfastToGo(StatisticalTableKeyFinder breakfastToGo) {
        this.breakfastToGo = breakfastToGo;
    }

    /**
     * @return Returns the cookieLookAlikeDessert.
     */
    public StatisticalTableKeyFinder getCookieLookAlikeDessert() {
        return cookieLookAlikeDessert;
    }

    /**
     * @param cookieLookAlikeDessert The cookieLookAlikeDessert to set.
     */
    public void setCookieLookAlikeDessert(
            StatisticalTableKeyFinder cookieLookAlikeDessert) {
        this.cookieLookAlikeDessert = cookieLookAlikeDessert;
    }

    /**
     * @return Returns the cookSauceType.
     */
    public StatisticalTableKeyFinder getCookSauceType() {
        return cookSauceType;
    }

    /**
     * @param cookSauceType The cookSauceType to set.
     */
    public void setCookSauceType(StatisticalTableKeyFinder cookSauceType) {
        this.cookSauceType = cookSauceType;
    }

    /**
     * @return Returns the cuisineVerySpecific.
     */
    public StatisticalTableKeyFinder getCuisineVerySpecific() {
        return cuisineVerySpecific;
    }

    /**
     * @param cuisineVerySpecific The cuisineVerySpecific to set.
     */
    public void setCuisineVerySpecific(StatisticalTableKeyFinder cuisineVerySpecific) {
        this.cuisineVerySpecific = cuisineVerySpecific;
    }

    /**
     * @return Returns the dressingFlavor.
     */
    public StatisticalTableKeyFinder getDressingFlavor() {
        return dressingFlavor;
    }

    /**
     * @param dressingFlavor The dressingFlavor to set.
     */
    public void setDressingFlavor(StatisticalTableKeyFinder dressingFlavor) {
        this.dressingFlavor = dressingFlavor;
    }

    /**
     * @return Returns the dressingType.
     */
    public StatisticalTableKeyFinder getDressingType() {
        return dressingType;
    }

    /**
     * @param dressingType The dressingType to set.
     */
    public void setDressingType(StatisticalTableKeyFinder dressingType) {
        this.dressingType = dressingType;
    }

    /**
     * @return Returns the ethnicBreadType.
     */
    public StatisticalTableKeyFinder getEthnicBreadType() {
        return ethnicBreadType;
    }

    /**
     * @param ethnicBreadType The ethnicBreadType to set.
     */
    public void setEthnicBreadType(StatisticalTableKeyFinder ethnicBreadType) {
        this.ethnicBreadType = ethnicBreadType;
    }

    /**
     * @return Returns the flavorChangeAnyYear.
     */
    public StatisticalTableKeyFinder getFlavorChangeAnyYear() {
        return flavorChangeAnyYear;
    }

    /**
     * @param flavorChangeAnyYear The flavorChangeAnyYear to set.
     */
    public void setFlavorChangeAnyYear(StatisticalTableKeyFinder flavorChangeAnyYear) {
        this.flavorChangeAnyYear = flavorChangeAnyYear;
    }

    /**
     * @return Returns the grillRoastSmoke.
     */
    public StatisticalTableKeyFinder getGrillRoastSmoke() {
        return grillRoastSmoke;
    }

    /**
     * @param grillRoastSmoke The grillRoastSmoke to set.
     */
    public void setGrillRoastSmoke(StatisticalTableKeyFinder grillRoastSmoke) {
        this.grillRoastSmoke = grillRoastSmoke;
    }

    /**
     * @return Returns the mexBreadType.
     */
    public StatisticalTableKeyFinder getMexBreadType() {
        return mexBreadType;
    }

    /**
     * @param mexBreadType The mexBreadType to set.
     */
    public void setMexBreadType(StatisticalTableKeyFinder mexBreadType) {
        this.mexBreadType = mexBreadType;
    }

    /**
     * @return Returns the mexIngredUse.
     */
    public StatisticalTableKeyFinder getMexIngredUse() {
        return mexIngredUse;
    }

    /**
     * @param mexIngredUse The mexIngredUse to set.
     */
    public void setMexIngredUse(StatisticalTableKeyFinder mexIngredUse) {
        this.mexIngredUse = mexIngredUse;
    }

    /**
     * @return Returns the pepperType.
     */
    public StatisticalTableKeyFinder getPepperType() {
        return pepperType;
    }

    /**
     * @param pepperType The pepperType to set.
     */
    public void setPepperType(StatisticalTableKeyFinder pepperType) {
        this.pepperType = pepperType;
    }

    /**
     * @return Returns the pizzaStyle.
     */
    public StatisticalTableKeyFinder getPizzaStyle() {
        return pizzaStyle;
    }

    /**
     * @param pizzaStyle The pizzaStyle to set.
     */
    public void setPizzaStyle(StatisticalTableKeyFinder pizzaStyle) {
        this.pizzaStyle = pizzaStyle;
    }

    /**
     * @return Returns the potatoTypeUse.
     */
    public StatisticalTableKeyFinder getPotatoTypeUse() {
        return potatoTypeUse;
    }

    /**
     * @param potatoTypeUse The potatoTypeUse to set.
     */
    public void setPotatoTypeUse(StatisticalTableKeyFinder potatoTypeUse) {
        this.potatoTypeUse = potatoTypeUse;
    }

    /**
     * @return Returns the prepEntreeType.
     */
    public StatisticalTableKeyFinder getPrepEntreeType() {
        return prepEntreeType;
    }

    /**
     * @param prepEntreeType The prepEntreeType to set.
     */
    public void setPrepEntreeType(StatisticalTableKeyFinder prepEntreeType) {
        this.prepEntreeType = prepEntreeType;
    }

    /**
     * @return Returns the riceTypeUse.
     */
    public StatisticalTableKeyFinder getRiceTypeUse() {
        return riceTypeUse;
    }

    /**
     * @param riceTypeUse The riceTypeUse to set.
     */
    public void setRiceTypeUse(StatisticalTableKeyFinder riceTypeUse) {
        this.riceTypeUse = riceTypeUse;
    }

    /**
     * @return Returns the roastVegItemType.
     */
    public StatisticalTableKeyFinder getRoastVegItemType() {
        return roastVegItemType;
    }

    /**
     * @param roastVegItemType The roastVegItemType to set.
     */
    public void setRoastVegItemType(StatisticalTableKeyFinder roastVegItemType) {
        this.roastVegItemType = roastVegItemType;
    }

    /**
     * @return Returns the salsaType.
     */
    public StatisticalTableKeyFinder getSalsaType() {
        return salsaType;
    }

    /**
     * @param salsaType The salsaType to set.
     */
    public void setSalsaType(StatisticalTableKeyFinder salsaType) {
        this.salsaType = salsaType;
    }

    /**
     * @return Returns the vegCookMeth.
     */
    public StatisticalTableKeyFinder getVegCookMeth() {
        return vegCookMeth;
    }

    /**
     * @param vegCookMeth The vegCookMeth to set.
     */
    public void setVegCookMeth(StatisticalTableKeyFinder vegCookMeth) {
        this.vegCookMeth = vegCookMeth;
    }

    public StatisticalTableKeyFinder getSoupBaseBroth() {
        return soupBaseBroth;
    }

    public void setSoupBaseBroth(StatisticalTableKeyFinder soupBaseBroth) {
        this.soupBaseBroth = soupBaseBroth;
    }

    public StatisticalTableKeyFinder getSoupWith() {
        return soupWith;
    }

    public void setSoupWith(StatisticalTableKeyFinder soupWith) {
        this.soupWith = soupWith;
    }
}