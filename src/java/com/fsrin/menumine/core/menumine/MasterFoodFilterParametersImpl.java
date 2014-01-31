/*
 * Created on Jan 17, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import ognl.Ognl;
import ognl.OgnlException;

import org.apache.commons.collections.collection.UnmodifiableCollection;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.fsrin.menumine.common.FilterParameter;
import com.fsrin.menumine.core.menumine.masterfood.MasterFoodQuerySummaryBuilder;
import com.fsrin.menumine.core.minefields.MineFields;

/**
 * 
 * This encapsulates the properties in which we can query the menumine database.
 * 
 * @author Nick
 * 
 * 
 */
public class MasterFoodFilterParametersImpl implements Serializable,
        MasterFoodFilterParameters {

    private Long id;

    private Collection all = new ArrayList();

    private Set filterParameters = new HashSet();

    /*
     * This is just an name to Identify the query. For now just to bo used in
     * the history.
     */
    private String name;

    /*
     * 2006-02-06 RSC Mostly not using this in the read only world.
     */
//    private ChainFilterParameters chainFilterParameters = new ChainFilterParameters();

    private FilterParameter keywords = this
    .instantiateFilterParameter(FieldEnum.KEYWORDS);

    
    private FilterParameter basicProtein = this
            .instantiateFilterParameter(FieldEnum.BASIC_PROTEIN);

//  2009-06-01 MJB added the protein types below.
    private FilterParameter chickenType = instantiateFilterParameter(FieldEnum.CHICKEN_TYPE);

    private FilterParameter beefType = instantiateFilterParameter(FieldEnum.BEEF_TYPE);
    
    private FilterParameter porkType = instantiateFilterParameter(FieldEnum.PORK_TYPE);
    
    private FilterParameter fishType = instantiateFilterParameter(FieldEnum.FISH_TYPE);
    
    private FilterParameter seafoodType = instantiateFilterParameter(FieldEnum.SEAFOOD_TYPE);
    
    private FilterParameter lambType = instantiateFilterParameter(FieldEnum.LAMB_TYPE);
    
    private FilterParameter turkeyType = instantiateFilterParameter(FieldEnum.TURKEY_TYPE);
    
    private FilterParameter otherProteinType = instantiateFilterParameter(FieldEnum.OTHER_PROTEIN_TYPE);
    
    private FilterParameter shrimpType = instantiateFilterParameter(FieldEnum.SHRIMP_TYPE);
    
    private FilterParameter proteinTypeCut = instantiateFilterParameter(FieldEnum.PROTEIN_TYPE_CUT);
    
    // private FilterParameter proteinType = new FilterParameter();

    private FilterParameter cookMeth = instantiateFilterParameter(FieldEnum.COOKING_METHOD);

    private FilterParameter sauceCondDressMarMM = instantiateFilterParameter(FieldEnum.SAUCE_OR_CONDIMENT);

    private FilterParameter flavEnhancSeasBrdgDesIngredMM = instantiateFilterParameter(FieldEnum.SEASONING_BREADING);
    
    private FilterParameter carboVegFruit = instantiateFilterParameter(FieldEnum.VEGGIE_OR_CARBO);

    private FilterParameter topFillIngredMM = instantiateFilterParameter(FieldEnum.TOPPING_FILLED_INGRED);

    private FilterParameter cheeseMM = instantiateFilterParameter(FieldEnum.CHEESE);

    private FilterParameter breadBakeGoodsMM = instantiateFilterParameter(FieldEnum.BREAD_BAKED_GOOD);

    private FilterParameter menuItem = instantiateFilterParameter(FieldEnum.MENU_ITEM_NAME);

    private FilterParameter menuItemType = instantiateFilterParameter(FieldEnum.ITEM_TYPE);

    private FilterParameter itemDescription = instantiateFilterParameter(FieldEnum.DESCRIPTION);

    private FilterParameter cuisine = instantiateFilterParameter(FieldEnum.CUISINE);

    private FilterParameter genMenuPart = instantiateFilterParameter(FieldEnum.MENU_PART);

    private FilterParameter menuItemClass = instantiateFilterParameter(FieldEnum.MENU_ITEM_CLASS);

    private FilterParameter menuStatus = instantiateFilterParameter(FieldEnum.MENU_STATUS);

    private FilterParameter genCookMeth = instantiateFilterParameter(FieldEnum.GEN_COOKING_METHOD);

    private FilterParameter cuisineFamily = instantiateFilterParameter(FieldEnum.CUISINE_FAMILY);

    // MJB 11-12-2009 Added 2010
    private FilterParameter price2011 = instantiateFilterParameter(FieldEnum.PRICE_2011);
    
    private FilterParameter price2010 = instantiateFilterParameter(FieldEnum.PRICE_2010);
    // DBB 1-20-2009 Add 2008, 2009
    private FilterParameter price2009 = instantiateFilterParameter(FieldEnum.PRICE_2009);
    
    private FilterParameter price2008 = instantiateFilterParameter(FieldEnum.PRICE_2008);
    
    //JDL 10-5-07
    private FilterParameter price2007 = instantiateFilterParameter(FieldEnum.PRICE_2007);
    
    private FilterParameter price2006 = instantiateFilterParameter(FieldEnum.PRICE_2006);
    
    private FilterParameter price2005 = instantiateFilterParameter(FieldEnum.PRICE_2005);

    private FilterParameter price2004 = instantiateFilterParameter(FieldEnum.PRICE_2004);

    private FilterParameter price2003 = instantiateFilterParameter(FieldEnum.PRICE_2003);

    private FilterParameter price2002 = instantiateFilterParameter(FieldEnum.PRICE_2002);

    private FilterParameter price2001 = instantiateFilterParameter(FieldEnum.PRICE_2001);

    private FilterParameter price2000 = instantiateFilterParameter(FieldEnum.PRICE_2000);

    private FilterParameter price1999 = instantiateFilterParameter(FieldEnum.PRICE_1999);

    private FilterParameter price1998 = instantiateFilterParameter(FieldEnum.PRICE_1998);

    private FilterParameter price1997 = instantiateFilterParameter(FieldEnum.PRICE_1997);

    private FilterParameter price1996 = instantiateFilterParameter(FieldEnum.PRICE_1996);

    private FilterParameter dayPartCategory = instantiateFilterParameter(FieldEnum.DAY_PART_CATEGORY);

    private FilterParameter cakeIngredient = instantiateFilterParameter(FieldEnum.CAKE_INGREDIENT);

    private FilterParameter cakeUse = instantiateFilterParameter(FieldEnum.CAKE_USE);

    private FilterParameter cookieIngredient = instantiateFilterParameter(FieldEnum.COOKIE_INGREDIENT);

    private FilterParameter cookieUse = instantiateFilterParameter(FieldEnum.COOKIE_USE);

    private FilterParameter dessertDoughCrustIngred = instantiateFilterParameter(FieldEnum.DESSERT_DOUGH_CRUST_INGRED);

    private FilterParameter iceCreamIngredient = instantiateFilterParameter(FieldEnum.ICE_CREAM_INGREDIENT);

    private FilterParameter syrupTopping = instantiateFilterParameter(FieldEnum.SYRUP_TOPPING);

    private FilterParameter nutIngredient = instantiateFilterParameter(FieldEnum.NUT_INGREDIENT);

    private FilterParameter fruitOrFruitFillingIngred = instantiateFilterParameter(FieldEnum.FRUIT_OR_FRUIT_FILLING_INGRED);

    private FilterParameter whippedToppingIngred = instantiateFilterParameter(FieldEnum.WHIPPED_TOPPING_INGRED);

    private FilterParameter candyIngredient = instantiateFilterParameter(FieldEnum.CANDY_INGREDIENT);

    private FilterParameter primaryFlavor = instantiateFilterParameter(FieldEnum.PRIMARY_FLAVOR);

    private FilterParameter tasteFlavorWords = instantiateFilterParameter(FieldEnum.TASTE_FLAVOR_WORDS);

    private FilterParameter brand = instantiateFilterParameter(FieldEnum.BRAND);

    private FilterParameter veggieFruitMM = instantiateFilterParameter(FieldEnum.VEGGIE_FRUIT_MM);

    private FilterParameter carboMM = instantiateFilterParameter(FieldEnum.CARBO_MM);
    
    private FilterParameter carboAll = instantiateFilterParameter(FieldEnum.CARBO_ALL);

    private FilterParameter breadUse = instantiateFilterParameter(FieldEnum.BREAD_USE);

    private FilterParameter flavApplication = instantiateFilterParameter(FieldEnum.FLAV_APPLICATION);

    private FilterParameter flavorSoup = instantiateFilterParameter(FieldEnum.FLAVOR_SOUP);

    private FilterParameter sideOrAccomp = instantiateFilterParameter(FieldEnum.SIDE_OR_ACCOMP);

    private FilterParameter healthyTerm = instantiateFilterParameter(FieldEnum.HEALTHY_TERM);

    private FilterParameter cookingSauceOrGravy = instantiateFilterParameter(FieldEnum.COOKING_SAUCE_OR_GRAVY);

    private FilterParameter marinade = instantiateFilterParameter(FieldEnum.MARINADE);

    private FilterParameter glaze = instantiateFilterParameter(FieldEnum.GLAZE);

    private FilterParameter dressings = instantiateFilterParameter(FieldEnum.DRESSINGS);

    private FilterParameter dipSauceName = instantiateFilterParameter(FieldEnum.DIP_SAUCE_NAME);

    private FilterParameter dairyButterCream = instantiateFilterParameter(FieldEnum.DAIRY_BUTTER_CREAM);
    
    private FilterParameter onionScallionLeek = instantiateFilterParameter(FieldEnum.ONION_SCALLION_LEEK);
    
    private FilterParameter mushroomType = instantiateFilterParameter(FieldEnum.MUSHROOM_TYPE);
    
    private FilterParameter tomatoType = instantiateFilterParameter(FieldEnum.TOMATO_TYPE);
    
    private FilterParameter condiments = instantiateFilterParameter(FieldEnum.CONDIMENTS);

    private FilterParameter butterApplication = instantiateFilterParameter(FieldEnum.BUTTER_APPLICATION);

    private FilterParameter seasoningName = instantiateFilterParameter(FieldEnum.SEASONING_NAME);

    private FilterParameter batterBreadingCoating = instantiateFilterParameter(FieldEnum.BATTER_BREADING_COATING);

    private FilterParameter stuffName = instantiateFilterParameter(FieldEnum.STUFF_NAME);

    private FilterParameter cheeseRollUp = instantiateFilterParameter(FieldEnum.CHEESE_ROLL_UP);

    private FilterParameter cheeseCheeseSauceFillingType = instantiateFilterParameter(FieldEnum.CHEESE_APPLICATION);

    private FilterParameter proteinTopName = instantiateFilterParameter(FieldEnum.PROTEIN_TOP_NAME);

    private FilterParameter proteinAccompName = instantiateFilterParameter(FieldEnum.PROTEIN_ACCOMP_NAME);

    private FilterParameter veggieFruitType = instantiateFilterParameter(FieldEnum.VEGGIE_FRUIT_TYPE);

    private FilterParameter greenVegName = instantiateFilterParameter(FieldEnum.GREEN_VEG_NAME);

    private FilterParameter vegTopName = instantiateFilterParameter(FieldEnum.VEG_TOP_NAME);

    private FilterParameter vegAccompName = instantiateFilterParameter(FieldEnum.VEG_ACCOMP_NAME);

    private FilterParameter fruitType = instantiateFilterParameter(FieldEnum.FRUIT_TYPE);

    private FilterParameter carboType = instantiateFilterParameter(FieldEnum.CARBO_TYPE);

    private FilterParameter carboTopName = instantiateFilterParameter(FieldEnum.CARBO_TOP_NAME);

    private FilterParameter carboAccompName = instantiateFilterParameter(FieldEnum.CARBO_ACCOMP_NAME);

    private FilterParameter breadWrapChips = instantiateFilterParameter(FieldEnum.BREAD_WRAPS_CHIPS);

    private FilterParameter eggType = instantiateFilterParameter(FieldEnum.EGG_TYPE);

    private FilterParameter hotColdCereal = instantiateFilterParameter(FieldEnum.HOT_COLD_CEREAL);

    private FilterParameter spreadType = instantiateFilterParameter(FieldEnum.SPREAD_TYPE);

    private FilterParameter breakfastPastry = instantiateFilterParameter(FieldEnum.BREAKFAST_PASTRY);

    private FilterParameter breakCakeWaff = instantiateFilterParameter(FieldEnum.BREAK_CAKE_WAFFLE);

    private FilterParameter logoImageStyle = instantiateFilterParameter(FieldEnum.LOGO_IMAGE_STYLE);

    private FilterParameter bevSize = instantiateFilterParameter(FieldEnum.BEV_SIZE);

    private FilterParameter servingCount = instantiateFilterParameter(FieldEnum.SERVING_COUNT);

    
    /*
     * 2006-01-17 RSC
     */

    private FilterParameter proteinFishShrimpSeafood = instantiateFilterParameter(FieldEnum.PROTEIN_FISH_SHRIMP_SEAFOOD);

    
    /*
     * 2006-01-31 RSC originally in chain--moved them over here.
     */
    private FilterParameter sectorName = instantiateFilterParameter(FieldEnum.MARKET_SECTOR);
    
    private FilterParameter segment = instantiateFilterParameter(FieldEnum.MARKET_SEGMENT);

    private FilterParameter operationName = instantiateFilterParameter(FieldEnum.OPERATION_NAME);

    private FilterParameter yearPutInDatabase = instantiateFilterParameter(FieldEnum.YEAR_PUT_IN_DATABASE);

    private FilterParameter yearPutInDatabaseSameStore = instantiateFilterParameter(FieldEnum.YEAR_PUT_IN_DATABASE_SAME_STORE);

    private FilterParameter hqState = instantiateFilterParameter(FieldEnum.HEADQUARTERS_STATE);

    private FilterParameter hqRegion = instantiateFilterParameter(FieldEnum.HEADQUARTERS_REGION);

    private FilterParameter operatorType = instantiateFilterParameter(FieldEnum.OPERATOR_TYPE);

    private FilterParameter countryLoc = instantiateFilterParameter(FieldEnum.COUNTRY_LOCATION);
    
    private FilterParameter chainID = instantiateFilterParameter(FieldEnum.OPERATION_CHAIN_ID);

    
    /*
     * 2006-04-20 RSC These are primarily used with profiler
     */
    private FilterParameter otherIngredName = instantiateFilterParameter(FieldEnum.OTHER_INGREDIENT);
    
    private FilterParameter otherToppings = instantiateFilterParameter(FieldEnum.OTHER_TOPPINGS);
    
    private FilterParameter otherTopIngred = instantiateFilterParameter(FieldEnum.OTHER_TOP_INGREDIENT);
    
    private FilterParameter otherAccompaniments = instantiateFilterParameter(FieldEnum.OTHER_ACCOMPANIMENTS);
    
    private FilterParameter healthyFlag = instantiateFilterParameter(FieldEnum.HEALTHY_FLAG);
    
    private FilterParameter healthySymbol = instantiateFilterParameter(FieldEnum.HEALTHY_SYMBOL);
    
    private FilterParameter fillingSaucesDressings = instantiateFilterParameter(FieldEnum.FILLING_SAUCES_DRESSINGS);
    
    
    /*
     * 2006-08-02 RSC types and uses fields
     */
    private FilterParameter cuisineVerySpecific= instantiateFilterParameter(FieldEnum.CUISINE_VERY_SPECIFIC);
    private FilterParameter grillRoastSmoke= instantiateFilterParameter(FieldEnum.GRILL_ROAST_SMOKE);
    private FilterParameter vegCookMeth   = instantiateFilterParameter(FieldEnum.VEG_COOK_METHOD);
    private FilterParameter cookSauceType = instantiateFilterParameter(FieldEnum.COOK_SAUCE_TYPE);
    private FilterParameter dressingType= instantiateFilterParameter(FieldEnum.DRESSING_TYPE);
    private FilterParameter dressingFlavor= instantiateFilterParameter(FieldEnum.DRESSING_FLAVOR);
    private FilterParameter mexBreadType= instantiateFilterParameter(FieldEnum.MEX_BREAD_TYPE);
    private FilterParameter roastVegItemType = instantiateFilterParameter(FieldEnum.ROAST_VEG_ITEM_TYPE); 
    private FilterParameter appetClassTyp= instantiateFilterParameter(FieldEnum.APPET_CLASS_TYP);
    private FilterParameter prepEntreeType= instantiateFilterParameter(FieldEnum.PREP_ENTREE_TYPE);
    private FilterParameter breadedFriedAppSide  = instantiateFilterParameter(FieldEnum.BREADED_FRIED_APPET_SIDE);
    private FilterParameter potatoTypeUse= instantiateFilterParameter(FieldEnum.POTATO_TYPE_USE);
    private FilterParameter salsaType = instantiateFilterParameter(FieldEnum.SALSA_TYPE);
    private FilterParameter cookieLookAlikeDessert  = instantiateFilterParameter(FieldEnum.COOKIE_LOOK_ALIKE_DESSERT);  
    private FilterParameter breakfastToGo= instantiateFilterParameter(FieldEnum.BREAKFAST_TO_GO);
    private FilterParameter pizzaStyle= instantiateFilterParameter(FieldEnum.PIZZA_STYLE);
    private FilterParameter bbqCook= instantiateFilterParameter(FieldEnum.BBQ_COOK);
    private FilterParameter ethnicBreadType  = instantiateFilterParameter(FieldEnum.ETHNIC_BREAD_TYPE); 
    private FilterParameter pepperType= instantiateFilterParameter(FieldEnum.PEPPER_TYPE);
    private FilterParameter riceTypeUse= instantiateFilterParameter(FieldEnum.RICE_TYPE_USE);
    private FilterParameter mexIngredUse = instantiateFilterParameter(FieldEnum.MEX_INGRED_USE);
    private FilterParameter flavorChangeAnyYear = instantiateFilterParameter(FieldEnum.FLAVOR_CHANGE_ANY_YEAR);   

    
    
    
    private FilterParameter newItemBrag= instantiateFilterParameter(FieldEnum.NEW_ITEM_BRAG);
    private FilterParameter proteinFlavorApp = instantiateFilterParameter(FieldEnum.PROTEIN_FLAVOR_APP);
    private FilterParameter oilTypeUse = instantiateFilterParameter(FieldEnum.OIL_TYPE_USE);   


    private FilterParameter eggItemUse= instantiateFilterParameter(FieldEnum.EGG_ITEM_USE);
    private FilterParameter cheeseForm = instantiateFilterParameter(FieldEnum.CHEESE_FORM);
    private FilterParameter cheeseSauceFillingType = instantiateFilterParameter(FieldEnum.CHEESE_SAUCE_FILLING_TYPE);   
    

    private FilterParameter soupWith= instantiateFilterParameter(FieldEnum.SOUP_WITH);
    private FilterParameter soupBaseBroth = instantiateFilterParameter(FieldEnum.SOUP_BASE_BROTH);
   
    
    /*
     *  7-25-07 JDL
     */
    private FilterParameter bevMenuItem = instantiateFilterParameter(FieldEnum.BEV_MENU_ITEM);
    private FilterParameter sideAccompDisFlavor = instantiateFilterParameter(FieldEnum.SID_ACCOMP_DIS_FLAVOR);

    private FilterParameter cookieTypeSource = instantiateFilterParameter(FieldEnum.COOKIE_TYPE_SOURCE);
    private FilterParameter creamyTop = instantiateFilterParameter(FieldEnum.CREAMY_TOP);
    private FilterParameter creamyFill = instantiateFilterParameter(FieldEnum.CREAMY_FILLING);

    private FilterParameter textureAttrib = instantiateFilterParameter(FieldEnum.TEXTURE_ATTRIB);
    private FilterParameter qualityStyle = instantiateFilterParameter(FieldEnum.QUALITY_STYLE);
  
    //End JDL
    
    private FilterParameter veggieAll= instantiateFilterParameter(FieldEnum.VEGGIE_ALL);
    private FilterParameter allVegCarbFruit = instantiateFilterParameter(FieldEnum.ALL_VEG_CARB_FRUIT);

    
    private Long limit;

    private Long firstResult;

    private boolean sortAsc = true;

    private String orderBy = null;

    public Long getLimit() {
        return limit;
    }

    private FilterParameter instantiateFilterParameter(FieldEnum field) {

        FilterParameter fp = new FilterParameter(field);
        // all.add(fp);
        filterParameters.add(fp);
        return fp;
    }

    public void setLimit(Long limit) {
        this.limit = limit;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public boolean isSortAsc() {
        return sortAsc;
    }

    public void setSortAsc(boolean sortAsc) {
        this.sortAsc = sortAsc;
    }


    public String toString() {

        return ToStringBuilder.reflectionToString(this);

    }

    /*
     * Requirement: We need to be able to display a summary of the last query
     * run. Need to only show fields that have data we don't want to overload on
     * data and make it waste space and be useless.
     * 
     * If needed this could produce all fields, and filter it on the view,
     * Probably will not need it.
     * 
     */
    public Collection getSummary(MineFields mineFields) {

        return MasterFoodQuerySummaryBuilder.singleton.build(this, mineFields);

    }

    public Collection getSummary() {

        return MasterFoodQuerySummaryBuilder.singleton.build(this);

    }

    public FilterParameter getBasicProtein() {
        return basicProtein;
    }

    public FilterParameter getBreadBakeGoodsMM() {
        return breadBakeGoodsMM;
    }

    public FilterParameter getCarboVegFruit() {
        return carboVegFruit;
    }

    public FilterParameter getCheeseMM() {
        return cheeseMM;
    }

    public FilterParameter getCookMeth() {
        return cookMeth;
    }

    public FilterParameter getCuisine() {
        return cuisine;
    }

    public FilterParameter getCuisineFamily() {
        return cuisineFamily;
    }

    public FilterParameter getFlavEnhancSeasBrdgDesIngredMM() {
        return flavEnhancSeasBrdgDesIngredMM;
    }

    public FilterParameter getGenCookMeth() {
        return genCookMeth;
    }

    public FilterParameter getGenMenuPart() {
        return genMenuPart;
    }

    public FilterParameter getItemDescription() {
        return itemDescription;
    }

    public FilterParameter getMenuItem() {
        return menuItem;
    }

    public FilterParameter getMenuItemClass() {
        return menuItemClass;
    }

    public FilterParameter getMenuItemType() {
        return menuItemType;
    }

    public FilterParameter getMenuStatus() {
        return menuStatus;
    }

    // public FilterParameter getProteinType() {
    // return proteinType;
    // }

    public FilterParameter getProteinTypeCut() {
        return proteinTypeCut;
    }
 // 2009-06-01 MJB added 9 protein fields below.
    public FilterParameter getChickenType() {
        return chickenType;
    }
    public FilterParameter getBeefType() {
        return beefType;
    }
    public FilterParameter getPorkType() {
        return porkType;
    }
    public FilterParameter getFishType() {
        return fishType;
    }
    public FilterParameter getSeafoodType() {
        return seafoodType;
    }
    public FilterParameter getLambType() {
        return lambType;
    }
    public FilterParameter getTurkeyType() {
        return turkeyType;
    }
    public FilterParameter getOtherProteinType() {
        return otherProteinType;
    }
    public FilterParameter getShrimpType() {
        return shrimpType;
    }
    public FilterParameter getSauceCondDressMarMM() {
        return sauceCondDressMarMM;
    }

    public FilterParameter getTopFillIngredMM() {
        return topFillIngredMM;
    }

    public void setBasicProtein(FilterParameter basicProtein) {
        this.basicProtein = basicProtein;
    }

    public void setBreadBakeGoodsMM(FilterParameter breadBakeGoodsMM) {
        this.breadBakeGoodsMM = breadBakeGoodsMM;
    }

    public void setCarboVegFruit(FilterParameter carboVegFruit) {
        this.carboVegFruit = carboVegFruit;
    }

//    public void setChain(ChainFilterParameters chainFilterParameters) {
//        this.chainFilterParameters = chainFilterParameters;
//    }

    public void setCheeseMM(FilterParameter cheeseMM) {
        this.cheeseMM = cheeseMM;
    }

    public void setCookMeth(FilterParameter cookMeth) {
        this.cookMeth = cookMeth;
    }

    public void setCuisine(FilterParameter cuisine) {
        this.cuisine = cuisine;
    }

    public void setCuisineFamily(FilterParameter cuisineFamily) {
        this.cuisineFamily = cuisineFamily;
    }

    public void setFlavEnhancSeasBrdgDesIngredMM(
            FilterParameter flavEnhancSeasBrdgDesIngredMM) {
        this.flavEnhancSeasBrdgDesIngredMM = flavEnhancSeasBrdgDesIngredMM;
    }

    public void setGenCookMeth(FilterParameter genCookMeth) {
        this.genCookMeth = genCookMeth;
    }

    public void setGenMenuPart(FilterParameter genMenuPart) {
        this.genMenuPart = genMenuPart;
    }

    public void setItemDescription(FilterParameter itemDescription) {
        this.itemDescription = itemDescription;
    }

    public void setMenuItem(FilterParameter menuItem) {
        this.menuItem = menuItem;
    }

    public void setMenuItemClass(FilterParameter menuItemClass) {
        this.menuItemClass = menuItemClass;
    }

    public void setMenuItemType(FilterParameter menuItemType) {
        this.menuItemType = menuItemType;
    }

    public void setMenuStatus(FilterParameter menuStatus) {
        this.menuStatus = menuStatus;
    }

    // public void setProteinType(FilterParameter proteinType) {
    // this.proteinType = proteinType;
    // }

    public void setProteinTypeCut(FilterParameter proteinTypeCut) {
        this.proteinTypeCut = proteinTypeCut;
    }
    public void setChickenType(FilterParameter chickenType) {
        this.chickenType = chickenType;
    }
    public void setBeefType(FilterParameter beefType) {
        this.beefType = beefType;
    }
    public void setPorkType(FilterParameter porkType) {
        this.porkType = porkType;
    }
    public void setFishType(FilterParameter fishType) {
        this.fishType = fishType;
    }
    public void setSeafoodType(FilterParameter seafoodType) {
        this.seafoodType = seafoodType;
    }
    public void setLambType(FilterParameter lambType) {
        this.lambType = lambType;
    }
    public void setTurkeyType(FilterParameter turkeyType) {
        this.turkeyType = turkeyType;
    }
    public void setOtherProteinType(FilterParameter otherProteinType) {
        this.otherProteinType = otherProteinType;
    }
    public void setShrimpType(FilterParameter shrimpType) {
        this.shrimpType = shrimpType;
    }
    public void setSauceCondDressMarMM(FilterParameter sauceCondDressMarMM) {
        this.sauceCondDressMarMM = sauceCondDressMarMM;
    }

    public void setTopFillIngredMM(FilterParameter topFillIngredMM) {
        this.topFillIngredMM = topFillIngredMM;
    }

    /*
     * 2006-01-21 RSC
     * 
     * Get all returns 88 regardless of how the filters are setup.
     * refactored to use the protected modifiable all.
     * 
     * (non-Javadoc)
     * 
     * @see com.fsrin.menumine.core.menumine.MasterFoodFilterParameters#getAll()
     */
    public Collection getAll() {
        // /*
        // * 2006-01-21 RSC Just wants to make this instance, uh, unmodifiable.
        // */

        Collection col = this.getModifiableAll(false);

        return UnmodifiableCollection.decorate(col);
    }

    protected Collection getModifiableAll(boolean onlyWithCriteria) {

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
                 * nick 2005-21-2005 Any params for the chainfilter will throw
                 * exceptions, and that is fine
                 */
            }
            if (o != null) {
                FilterParameter fp = (FilterParameter) o;
                if (!onlyWithCriteria || !fp.isFilterEmpty()) {
                    col.add(o);
                }
            }

        }

        /*
         * 2006-01-21 RSC Just wants to make this instance, uh, unmodifiable.
         */
        return UnmodifiableCollection.decorate(col);

    }

    public Collection getAllWithCriteria() {
        Collection col = this.getModifiableAll(true);
        /*
         * 2006-01-21 RSC Just wants to make this instance, uh, unmodifiable.
         * Just using this here to be consistent with the original.
         */
        return UnmodifiableCollection.decorate(col);

    }

    public Collection getAllPricing() {

        Collection all = new ArrayList();
//JDL 10-7-07
        all.add(price2011);
        all.add(price2010);
        all.add(price2009);
        all.add(price2008);
        all.add(price2007);
        all.add(price2006);
        all.add(price2005);
        all.add(price2004);
        all.add(price2003);
        all.add(price2002);
        all.add(price2001);
        all.add(price2000);
        all.add(price1999);
        all.add(price1998);
        all.add(price1997);
        all.add(price1996);

        return all;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FilterParameter getPrice1996() {
        return price1996;
    }

    public void setPrice1996(FilterParameter price1996) {
        this.price1996 = price1996;
    }

    public FilterParameter getPrice1997() {
        return price1997;
    }

    public void setPrice1997(FilterParameter price1997) {
        this.price1997 = price1997;
    }

    public FilterParameter getPrice1998() {
        return price1998;
    }

    public void setPrice1998(FilterParameter price1998) {
        this.price1998 = price1998;
    }

    public FilterParameter getPrice1999() {
        return price1999;
    }

    public void setPrice1999(FilterParameter price1999) {
        this.price1999 = price1999;
    }

    public FilterParameter getPrice2000() {
        return price2000;
    }

    public void setPrice2000(FilterParameter price2000) {
        this.price2000 = price2000;
    }

    public FilterParameter getPrice2001() {
        return price2001;
    }

    public void setPrice2001(FilterParameter price2001) {
        this.price2001 = price2001;
    }

    public FilterParameter getPrice2002() {
        return price2002;
    }

    public void setPrice2002(FilterParameter price2002) {
        this.price2002 = price2002;
    }

    public FilterParameter getPrice2003() {
        return price2003;
    }

    public void setPrice2003(FilterParameter price2003) {
        this.price2003 = price2003;
    }

    public FilterParameter getPrice2004() {
        return price2004;
    }

    public void setPrice2004(FilterParameter price2004) {
        this.price2004 = price2004;
    }

    public FilterParameter getPrice2005() {
        return price2005;
    }

    public void setPrice2005(FilterParameter price2005) {
        this.price2005 = price2005;
    }

    public void setFilterParameters(Set col) {
        this.filterParameters = col;
        for (Iterator iter = col.iterator(); iter.hasNext();) {
            FilterParameter element = (FilterParameter) iter.next();
            try {
                if (element != null && element.getField() != null
                        && element.getField().getShortOgnlName() != null) {
                    Ognl.setValue(element.getField().getShortOgnlName(), this,
                            element);
                } else {

                }
            } catch (OgnlException e) {
                /*
                 * nick 2005-21-2005 Any params for the chainfilter will throw
                 * exceptions, and that is fine
                 */
            }
        }
    }

    public Set getFilterParameters() {

        for (Iterator iter = FieldEnum.getAll().iterator(); iter.hasNext();) {
            FieldEnum element = (FieldEnum) iter.next();
            Object o = null;
            try {
                o = Ognl.getValue(element.getShortOgnlName(), this);
            } catch (OgnlException e) {

                /*
                 * nick 2005-21-2005 Any params for the chainfilter will throw
                 * exceptions, and that is fine
                 */
            }
            if (o != null) {

                this.filterParameters.add(o);
            }
        }

        return this.filterParameters;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFirstResult() {
        return firstResult;
    }

    public void setFirstResult(Long firstResult) {
        this.firstResult = firstResult;
    }

    public FilterParameter getBrand() {
        return brand;
    }

    public void setBrand(FilterParameter brand) {
        this.brand = brand;
    }

    public FilterParameter getCakeIngredient() {
        return cakeIngredient;
    }

    public void setCakeIngredient(FilterParameter cakeIngredient) {
        this.cakeIngredient = cakeIngredient;
    }

    public FilterParameter getCakeUse() {
        return cakeUse;
    }

    public void setCakeUse(FilterParameter cakeUse) {
        this.cakeUse = cakeUse;
    }

    public FilterParameter getCandyIngredient() {
        return candyIngredient;
    }

    public void setCandyIngredient(FilterParameter candyIngredient) {
        this.candyIngredient = candyIngredient;
    }

//    public ChainFilterParameters getChainFilterParameters() {
//        return chainFilterParameters;
//    }
//
//    public void setChainFilterParameters(
//            ChainFilterParameters chainFilterParameters) {
//        this.chainFilterParameters = chainFilterParameters;
//    }

    public FilterParameter getCookieIngredient() {
        return cookieIngredient;
    }

    public void setCookieIngredient(FilterParameter cookieIngredient) {
        this.cookieIngredient = cookieIngredient;
    }

    public FilterParameter getCookieUse() {
        return cookieUse;
    }

    public void setCookieUse(FilterParameter cookieUse) {
        this.cookieUse = cookieUse;
    }

    public FilterParameter getDayPartCategory() {
        return dayPartCategory;
    }

    public void setDayPartCategory(FilterParameter dayPartCategory) {
        this.dayPartCategory = dayPartCategory;
    }

    public FilterParameter getDessertDoughCrustIngred() {
        return dessertDoughCrustIngred;
    }

    public void setDessertDoughCrustIngred(
            FilterParameter dessertDoughCrustIngred) {
        this.dessertDoughCrustIngred = dessertDoughCrustIngred;
    }

    public FilterParameter getFruitOrFruitFillingIngred() {
        return fruitOrFruitFillingIngred;
    }

    public void setFruitOrFruitFillingIngred(
            FilterParameter fruitOrFruitFillingIngred) {
        this.fruitOrFruitFillingIngred = fruitOrFruitFillingIngred;
    }

    public FilterParameter getIceCreamIngredient() {
        return iceCreamIngredient;
    }

    public void setIceCreamIngredient(FilterParameter iceCreamIngredient) {
        this.iceCreamIngredient = iceCreamIngredient;
    }

    public FilterParameter getNutIngredient() {
        return nutIngredient;
    }

    public void setNutIngredient(FilterParameter nutIngredient) {
        this.nutIngredient = nutIngredient;
    }

    public FilterParameter getPrimaryFlavor() {
        return primaryFlavor;
    }

    public void setPrimaryFlavor(FilterParameter primaryFlavor) {
        this.primaryFlavor = primaryFlavor;
    }

    public FilterParameter getSyrupTopping() {
        return syrupTopping;
    }

    public void setSyrupTopping(FilterParameter syrupTopping) {
        this.syrupTopping = syrupTopping;
    }

    public FilterParameter getTasteFlavorWords() {
        return tasteFlavorWords;
    }

    public void setTasteFlavorWords(FilterParameter tasteFlavorWords) {
        this.tasteFlavorWords = tasteFlavorWords;
    }

    public FilterParameter getWhippedToppingIngred() {
        return whippedToppingIngred;
    }

    public void setWhippedToppingIngred(FilterParameter whippedToppingIngred) {
        this.whippedToppingIngred = whippedToppingIngred;
    }

    public void applyMasterFoodFilterParameters(
            MasterFoodFilterParameters newParams) {

        for (Iterator iter = FieldEnum.getAll().iterator(); iter.hasNext();) {
            FieldEnum element = (FieldEnum) iter.next();
            Object oThis = null;
            Object oNewParams = null;
            try {
                oThis = Ognl.getValue(element.getOgnlName(), this);
                oNewParams = Ognl.getValue(element.getOgnlName(), newParams);
            } catch (OgnlException e) {

                /*
                 * nick 2005-21-2005 Any params for the chainfilter will throw
                 * exceptions, and that is fine
                 */
            }
            if (oThis != null && oNewParams != null) {
                this.applyFilterParameter((FilterParameter) oThis,
                        (FilterParameter) oNewParams);

            } else {
                throw new RuntimeException(
                        "Ognl Error applying new filter parameters.");
            }
        }
    }

    /*
     * 2006-01-17 RSC This was already commented about. Appears to have been
     * replaced by the OGNL above.
     */
    // /*
    // * Apply params from one set of MasterFoodFilterParametersWrapper to
    // * another. We need to have the params from the request applied to the
    // * context.
    // */
    // public void applyMasterFoodFilterParameters2(
    // MasterFoodFilterParameters newParams) {
    //
    // FilterParameter fp = this.getBasicProtein();
    //
    // fp.setEmpty(newParams.getBasicProtein().getEmpty());
    // this.getBasicProtein().setInValues(
    // newParams.getBasicProtein().getInValues());
    // this.getBasicProtein().setAndValues(
    // newParams.getBasicProtein().getAndValues());
    // this.getBasicProtein().setNotValues(
    // newParams.getBasicProtein().getNotValues());
    // this.getBasicProtein().setOrValues(
    // newParams.getProtein().getOrValues());
    //
    // this.getProteinTypeCut().setEmpty(
    // newParams.getProteinTypeCut().getEmpty());
    // this.getProteinTypeCut().setInValues(
    // newParams.getProteinTypeCut().getInValues());
    // this.getProteinTypeCut().setAndValues(
    // newParams.getProteinTypeCut().getAndValues());
    // this.getProteinTypeCut().setNotValues(
    // newParams.getProteinTypeCut().getNotValues());
    // this.getProteinTypeCut().setOrValues(
    // newParams.getProteinTypeCut().getOrValues());
    //
    // this.getCookMeth().setEmpty(newParams.getCookMeth().getEmpty());
    // this.getCookMeth().setInValues(newParams.getCookMeth().getInValues());
    // this.getCookMeth().setAndValues(newParams.getCookMeth().getAndValues());
    // this.getCookMeth().setNotValues(newParams.getCookMeth().getNotValues());
    // this.getCookMeth().setOrValues(newParams.getCookMeth().getOrValues());
    //
    // this.applyFilterParameter(this.getSauceCondDressMarMM(), newParams
    // .getSauceCondDressMarMM());
    //
    // this.applyFilterParameter(this.getFlavEnhancSeasBrdgDesIngredMM(),
    // newParams.getFlavEnhancSeasBrdgDesIngredMM());
    //
    // this.applyFilterParameter(this.getCarboVegFruit(), newParams
    // .getCarboVegFruit());
    //
    // this.applyFilterParameter(this.getTopFillIngredMM(), newParams
    // .getTopFillIngredMM());
    //
    // this.applyFilterParameter(this.getCheeseMM(), newParams.getCheeseMM());
    //
    // this.applyFilterParameter(this.getBreadBakeGoodsMM(), newParams
    // .getBreadBakeGoodsMM());
    //
    // this.applyFilterParameter(this.getMenuItem(), newParams.getMenuItem());
    //
    // this.applyFilterParameter(this.getMenuItemType(), newParams
    // .getMenuItemType());
    //
    // this.applyFilterParameter(this.getItemDescription(), newParams
    // .getItemDescription());
    //
    // this.applyFilterParameter(this.getCuisine(), newParams.getCuisine());
    //
    // this.applyFilterParameter(this.getGenMenuPart(), newParams
    // .getGenMenuPart());
    //
    // this.applyFilterParameter(this.getMenuItemClass(), newParams
    // .getMenuItemClass());
    //
    // this.applyFilterParameter(this.getMenuStatus(), newParams
    // .getMenuStatus());
    //
    // this.applyFilterParameter(this.getGenCookMeth(), newParams
    // .getGenCookMeth());
    //
    // this.applyFilterParameter(this.getCuisineFamily(), newParams
    // .getCuisineFamily());
    //
    // this
    // .applyFilterParameter(this.getPrice2004(), newParams
    // .getPrice2004());
    //
    // this
    // .applyFilterParameter(this.getPrice2003(), newParams
    // .getPrice2003());
    //
    // this
    // .applyFilterParameter(this.getPrice2002(), newParams
    // .getPrice2002());
    //
    // this
    // .applyFilterParameter(this.getPrice2001(), newParams
    // .getPrice2001());
    //
    // this
    // .applyFilterParameter(this.getPrice2000(), newParams
    // .getPrice2000());
    //
    // this
    // .applyFilterParameter(this.getPrice1999(), newParams
    // .getPrice1999());
    //
    // this
    // .applyFilterParameter(this.getPrice1998(), newParams
    // .getPrice1998());
    //
    // this
    // .applyFilterParameter(this.getPrice1997(), newParams
    // .getPrice1997());
    //
    // this
    // .applyFilterParameter(this.getPrice1996(), newParams
    // .getPrice1996());
    //
    // this.applyFilterParameter(this.getChain().getHqState(), newParams
    // .getChain().getHqState());
    //
    // this.applyFilterParameter(this.getChain().getOperationName(), newParams
    // .getChain().getOperationName());
    //
    // this.applyFilterParameter(this.getChain().getSectorName(), newParams
    // .getChain().getSectorName());
    //
    // this.applyFilterParameter(this.getChain().getSegment(), newParams
    // .getChain().getSegment());
    //
    // this.applyFilterParameter(this.getCakeIngredient(), newParams
    // .getCakeIngredient());
    //
    // this.applyFilterParameter(this.getCakeUse(), newParams.getCakeUse());
    //
    // this.applyFilterParameter(this.getCookieIngredient(), newParams
    // .getCookieIngredient());
    //
    // this
    // .applyFilterParameter(this.getCookieUse(), newParams
    // .getCookieUse());
    //
    // this.applyFilterParameter(this.getDessertDoughCrustIngred(), newParams
    // .getDessertDoughCrustIngred());
    //
    // this.applyFilterParameter(this.getIceCreamIngredient(), newParams
    // .getIceCreamIngredient());
    //
    // this.applyFilterParameter(this.getSyrupTopping(), newParams
    // .getSyrupTopping());
    //
    // this.applyFilterParameter(this.getNutIngredient(), newParams
    // .getNutIngredient());
    //
    // this.applyFilterParameter(this.getFruitorFruitFillingIngred(),
    // newParams.getFruitorFruitFillingIngred());
    //
    // this.applyFilterParameter(this.getWhippedToppingIngred(), newParams
    // .getWhippedToppingIngred());
    //
    // this.applyFilterParameter(this.getCandyIngredient(), newParams
    // .getCandyIngredient());
    //
    // this.applyFilterParameter(this.getPrimaryFlavor(), newParams
    // .getPrimaryFlavor());
    //
    // this.applyFilterParameter(this.getTasteFlavorWords(), newParams
    // .getTasteFlavorWords());
    //
    // this.applyFilterParameter(this.getBrand(), newParams.getBrand());
    //
    // this.applyFilterParameter(this.getVeggieFruitMM(), newParams
    // .getVeggieFruitMM());
    // this.applyFilterParameter(this.getCarboMM(), newParams.getCarboMM());
    // this.applyFilterParameter(this.getBreadUse(), newParams.getBreadUse());
    // this.applyFilterParameter(this.getFlavApplication(), newParams
    // .getFlavApplication());
    // this.applyFilterParameter(this.getFlavorSoup(), newParams
    // .getFlavorSoup());
    // this.applyFilterParameter(this.getSideOrAccomp(), newParams
    // .getSideOrAccomp());
    //
    // this.applyFilterParameter(this.getHealthyTerm(), newParams
    // .getHealthyTerm());
    //
    // }
    private void applyFilterParameter(FilterParameter orig,
            FilterParameter update) {
        orig.setEmpty(update.getEmpty());
        orig.setInValues(update.getInValues());
        orig.setAndValues(update.getAndValues());
        orig.setNotValues(update.getNotValues());
        orig.setOrValues(update.getOrValues());

    }

    public FilterParameter getBreadUse() {
        return breadUse;
    }

    public void setBreadUse(FilterParameter breadUse) {
        this.breadUse = breadUse;
    }

    public FilterParameter getCarboMM() {
        return carboMM;
    }

    public void setCarboMM(FilterParameter carboMM) {
        this.carboMM = carboMM;
    }
    
    public FilterParameter getCarboAll() {
        return carboAll;
    }

    public void setCarboAll(FilterParameter carboAll) {
        this.carboAll = carboAll;
    }

    public FilterParameter getFlavApplication() {
        return flavApplication;
    }

    public void setFlavApplication(FilterParameter flavApplication) {
        this.flavApplication = flavApplication;
    }

    public FilterParameter getFlavorSoup() {
        return flavorSoup;
    }

    public void setFlavorSoup(FilterParameter flavorSoup) {
        this.flavorSoup = flavorSoup;
    }

    public FilterParameter getSideOrAccomp() {
        return sideOrAccomp;
    }

    public void setSideOrAccomp(FilterParameter sideOrAccomp) {
        this.sideOrAccomp = sideOrAccomp;
    }

    public FilterParameter getVeggieFruitMM() {
        return veggieFruitMM;
    }

    public void setVeggieFruitMM(FilterParameter veggieFruitMM) {
        this.veggieFruitMM = veggieFruitMM;
    }

    public FilterParameter getHealthyTerm() {
        return healthyTerm;
    }

    public void setHealthyTerm(FilterParameter healthyTerm) {
        this.healthyTerm = healthyTerm;
    }

    public FilterParameter getBatterBreadingCoating() {
        return batterBreadingCoating;
    }

    public void setBatterBreadingCoating(FilterParameter batterBreadingCoating) {
        this.batterBreadingCoating = batterBreadingCoating;
    }

    public FilterParameter getBreadWrapChips() {
        return breadWrapChips;
    }

    public void setBreadWrapChips(FilterParameter breadWrapChips) {
        this.breadWrapChips = breadWrapChips;
    }

    public FilterParameter getButterApplication() {
        return butterApplication;
    }

    public void setButterApplication(FilterParameter butterApplication) {
        this.butterApplication = butterApplication;
    }

    public FilterParameter getCarboAccompName() {
        return carboAccompName;
    }

    public void setCarboAccompName(FilterParameter carboAccompName) {
        this.carboAccompName = carboAccompName;
    }

    public FilterParameter getCarboTopName() {
        return carboTopName;
    }

    public void setCarboTopName(FilterParameter carboTopName) {
        this.carboTopName = carboTopName;
    }

    public FilterParameter getCarboType() {
        return carboType;
    }

    public void setCarboType(FilterParameter carboType) {
        this.carboType = carboType;
    }

    public FilterParameter getCheeseCheeseSauceFillingType() {
        return cheeseCheeseSauceFillingType;
    }

    public void setCheeseCheeseSauceFillingType(
            FilterParameter cheeseCheeseSauceFillingType) {
        this.cheeseCheeseSauceFillingType = cheeseCheeseSauceFillingType;
    }

    public FilterParameter getCheeseRollUp() {
        return cheeseRollUp;
    }

    public void setCheeseRollUp(FilterParameter cheeseRollUp) {
        this.cheeseRollUp = cheeseRollUp;
    }

    public FilterParameter getCondiments() {
        return condiments;
    }

    public void setCondiments(FilterParameter condiments) {
        this.condiments = condiments;
    }

    public FilterParameter getCookingSauceOrGravy() {
        return cookingSauceOrGravy;
    }

    public void setCookingSauceOrGravy(FilterParameter cookingSauceOrGravy) {
        this.cookingSauceOrGravy = cookingSauceOrGravy;
    }

    public FilterParameter getDipSauceName() {
        return dipSauceName;
    }

    public void setDipSauceName(FilterParameter dipSauceName) {
        this.dipSauceName = dipSauceName;
    }
    
    public FilterParameter getDairyButterCream() {
        return dairyButterCream;
    }

    public void setDairyButterCream(FilterParameter dairyButterCream) {
        this.dairyButterCream = dairyButterCream;
    }
    
    public FilterParameter getOnionScallionLeek() {
        return onionScallionLeek;
    }

    public void setOnionScallionLeek(FilterParameter onionScallionLeek) {
        this.onionScallionLeek = onionScallionLeek;
    }
    
    public FilterParameter getMushroomType() {
        return mushroomType;
    }

    public void setMushroomType(FilterParameter mushroomType) {
        this.mushroomType = mushroomType;
    }
    

    public FilterParameter getTomatoType() {
        return tomatoType;
    }

    public void setTomatoType(FilterParameter tomatoType) {
        this.tomatoType = tomatoType;
    }

    public FilterParameter getDressings() {
        return dressings;
    }

    public void setDressings(FilterParameter dressings) {
        this.dressings = dressings;
    }

    public FilterParameter getFruitType() {
        return fruitType;
    }

    public void setFruitType(FilterParameter fruitType) {
        this.fruitType = fruitType;
    }

    public FilterParameter getGlaze() {
        return glaze;
    }

    public void setGlaze(FilterParameter glaze) {
        this.glaze = glaze;
    }

    public FilterParameter getGreenVegName() {
        return greenVegName;
    }

    public void setGreenVegName(FilterParameter greenVegName) {
        this.greenVegName = greenVegName;
    }

    public FilterParameter getMarinade() {
        return marinade;
    }

    public void setMarinade(FilterParameter marinade) {
        this.marinade = marinade;
    }

    public FilterParameter getProteinAccompName() {
        return proteinAccompName;
    }

    public void setProteinAccompName(FilterParameter proteinAccompName) {
        this.proteinAccompName = proteinAccompName;
    }

    public FilterParameter getProteinTopName() {
        return proteinTopName;
    }

    public void setProteinTopName(FilterParameter proteinTopName) {
        this.proteinTopName = proteinTopName;
    }

    public FilterParameter getSeasoningName() {
        return seasoningName;
    }

    public void setSeasoningName(FilterParameter seasoningName) {
        this.seasoningName = seasoningName;
    }

    public FilterParameter getStuffName() {
        return stuffName;
    }

    public void setStuffName(FilterParameter stuffName) {
        this.stuffName = stuffName;
    }

    public FilterParameter getVegAccompName() {
        return vegAccompName;
    }

    public void setVegAccompName(FilterParameter vegAccompName) {
        this.vegAccompName = vegAccompName;
    }

    public FilterParameter getVeggieFruitType() {
        return veggieFruitType;
    }

    public void setVeggieFruitType(FilterParameter veggieFruitType) {
        this.veggieFruitType = veggieFruitType;
    }

    public FilterParameter getVegTopName() {
        return vegTopName;
    }

    public void setVegTopName(FilterParameter vegTopName) {
        this.vegTopName = vegTopName;
    }

    public FilterParameter getBevSize() {
        return bevSize;
    }

    public void setBevSize(FilterParameter bevSize) {
        this.bevSize = bevSize;
    }

    public FilterParameter getBreakCakeWaff() {
        return breakCakeWaff;
    }

    public void setBreakCakeWaff(FilterParameter breakCakeWaff) {
        this.breakCakeWaff = breakCakeWaff;
    }

    public FilterParameter getBreakfastPastry() {
        return breakfastPastry;
    }

    public void setBreakfastPastry(FilterParameter breakfastPastry) {
        this.breakfastPastry = breakfastPastry;
    }

    public FilterParameter getEggType() {
        return eggType;
    }

    public void setEggType(FilterParameter eggType) {
        this.eggType = eggType;
    }

    public FilterParameter getHotColdCereal() {
        return hotColdCereal;
    }

    public void setHotColdCereal(FilterParameter hotColdCereal) {
        this.hotColdCereal = hotColdCereal;
    }

    public FilterParameter getLogoImageStyle() {
        return logoImageStyle;
    }

    public void setLogoImageStyle(FilterParameter logoImageStyle) {
        this.logoImageStyle = logoImageStyle;
    }

    public FilterParameter getServingCount() {
        return servingCount;
    }

    public void setServingCount(FilterParameter servingCount) {
        this.servingCount = servingCount;
    }

    public FilterParameter getSpreadType() {
        return spreadType;
    }

    public void setSpreadType(FilterParameter spreadType) {
        this.spreadType = spreadType;
    }

    /**
     * @return Returns the proteinFishShrimpSeafood.
     */
    public FilterParameter getProteinFishShrimpSeafood() {
        return proteinFishShrimpSeafood;
    }

    /**
     * @param proteinFishShrimpSeafood
     *            The proteinFishShrimpSeafood to set.
     */
    public void setProteinFishShrimpSeafood(
            FilterParameter proteinFishShrimpSeafood) {
        this.proteinFishShrimpSeafood = proteinFishShrimpSeafood;
    }
    
    /*
     * 2006-01-31 RSC Added from the chain section
     */

    public FilterParameter getCountryLoc() {
        return countryLoc;
    }

    public void setCountryLoc(FilterParameter countryLoc) {
        this.countryLoc = countryLoc;
    }

    public FilterParameter getHqRegion() {
        return hqRegion;
    }

    public void setHqRegion(FilterParameter hqRegion) {
        this.hqRegion = hqRegion;
    }

    public FilterParameter getHqState() {
        return hqState;
    }

    public void setHqState(FilterParameter hqState) {
        this.hqState = hqState;
    }

    public FilterParameter getOperationName() {
        return operationName;
    }

    public void setOperationName(FilterParameter operationName) {
        this.operationName = operationName;
    }

    public FilterParameter getOperatorType() {
        return operatorType;
    }

    public void setOperatorType(FilterParameter operatorType) {
        this.operatorType = operatorType;
    }

    public FilterParameter getSectorName() {
        return sectorName;
    }

    public void setSectorName(FilterParameter sectorName) {
        this.sectorName = sectorName;
    }

    public FilterParameter getSegment() {
        return segment;
    }

    public void setSegment(FilterParameter segment) {
        this.segment = segment;
    }

    public FilterParameter getYearPutInDatabase() {
        return yearPutInDatabase;
    }

    public void setYearPutInDatabase(FilterParameter yearPutInDatabase) {
        this.yearPutInDatabase = yearPutInDatabase;
    }

    public FilterParameter getChainID() {
        return chainID;
    }

    public void setChainID(FilterParameter chainID) {
        this.chainID = chainID;
    }
    
    /*
     * 2006-03-16 RSC goes deep into the FilterParameters to clone.
     * 
     * (non-Javadoc)
     * @see java.lang.Object#clone()
     */
    public MasterFoodFilterParameters clone() {
        
        MasterFoodFilterParameters ret = new MasterFoodFilterParametersImpl();
        
        for (Iterator iter = FieldEnum.getAll().iterator(); iter.hasNext();) {
            FieldEnum element = (FieldEnum) iter.next();

            FilterParameter clone = null;
            
            try {
            clone = ((FilterParameter) Ognl.getValue(element.getOgnlName(), this)).clone();
            
            Ognl.setValue(element.getOgnlName(), ret, clone);
            } catch (Exception e) {
                throw new RuntimeException("failed while cloning params");
            }
        }        
        
        return ret;
    }

    public FilterParameter getKeywords() {
        return keywords;
    }

    public void setKeywords(FilterParameter keywords) {
        this.keywords = keywords;
    }

    public FilterParameter getYearPutInDatabaseSameStore() {
        return yearPutInDatabaseSameStore;
    }

    public void setYearPutInDatabaseSameStore(
            FilterParameter yearPutInDatabaseSameStore) {
        this.yearPutInDatabaseSameStore = yearPutInDatabaseSameStore;
    }

    public FilterParameter getHealthyFlag() {
        return healthyFlag;
    }

    public void setHealthyFlag(FilterParameter healthyFlag) {
        this.healthyFlag = healthyFlag;
    }

    public FilterParameter getHealthySymbol() {
        return healthySymbol;
    }

    public void setHealthySymbol(FilterParameter healthySymbol) {
        this.healthySymbol = healthySymbol;
    }

    public FilterParameter getOtherAccompaniments() {
        return otherAccompaniments;
    }

    public void setOtherAccompaniments(FilterParameter otherAccompaniments) {
        this.otherAccompaniments = otherAccompaniments;
    }

    public FilterParameter getOtherIngredName() {
        return otherIngredName;
    }

    public void setOtherIngredName(FilterParameter otherIngredName) {
        this.otherIngredName = otherIngredName;
    }

    public FilterParameter getOtherTopIngred() {
        return otherTopIngred;
    }

    public void setOtherTopIngred(FilterParameter otherTopIngred) {
        this.otherTopIngred = otherTopIngred;
    }

    public FilterParameter getOtherToppings() {
        return otherToppings;
    }

    public void setOtherToppings(FilterParameter otherToppings) {
        this.otherToppings = otherToppings;
    }

    public FilterParameter getFillingSaucesDressings() {
        return fillingSaucesDressings;
    }

    public void setFillingSaucesDressings(FilterParameter fillingSaucesDressings) {
        this.fillingSaucesDressings = fillingSaucesDressings;
    }

    /**
     * @return Returns the price2006.
     */
    public FilterParameter getPrice2006() {
        return price2006;
    }

    /**
     * @param price2006 The price2006 to set.
     */
    public void setPrice2006(FilterParameter price2006) {
        this.price2006 = price2006;
    }
    //JDL 10-5-07
    /**
     * @return Returns the price2007.
     */
    public FilterParameter getPrice2007() {
        return price2007;
    }

    /**
     * @param price2007 The price2007 to set.
     */
    public void setPrice2007(FilterParameter price2007) {
        this.price2007 = price2007;
    }
    

    
    // DBB 1-20-2009 Add 2008, 2009
    /**
     * @param price2008 The price2008 to set.
     */
    public void setPrice2008(FilterParameter price2008) {
        this.price2008 = price2008;
    }
    
    /**
     * @return Returns the price2008.
     */
    public FilterParameter getPrice2008() {
        return price2008;
    }
    
    /**
     * @param price2009 The price2009 to set.
     */
    public void setPrice2009(FilterParameter price2009) {
        this.price2009 = price2009;
    }
    
    /**
     * @return Returns the price2009.
     */
    public FilterParameter getPrice2009() {
        return price2009;
    }
    /**
     * @param price2010 The price2010 to set.
     */
    // MJB 11-12-2009 Added 2010
    public void setPrice2010(FilterParameter price2010) {
        this.price2010 = price2010;
    }
    
    /**
     * @return Returns the price2010.
     */
    public FilterParameter getPrice2010() {
        return price2010;
    }
    
    public void setPrice2011(FilterParameter price2011) {
        this.price2011 = price2011;
    }
    
    /**
     * @return Returns the price2010.
     */
    public FilterParameter getPrice2011() {
        return price2011;
    }


    /**
     * @return Returns the appetClassTyp.
     */
    public FilterParameter getAppetClassTyp() {
        return appetClassTyp;
    }

    /**
     * @param appetClassTyp The appetClassTyp to set.
     */
    public void setAppetClassTyp(FilterParameter appetClassTyp) {
        this.appetClassTyp = appetClassTyp;
    }

    /**
     * @return Returns the bbqCook.
     */
    public FilterParameter getBbqCook() {
        return bbqCook;
    }

    /**
     * @param bbqCook The bbqCook to set.
     */
    public void setBbqCook(FilterParameter bbqCook) {
        this.bbqCook = bbqCook;
    }

    /**
     * @return Returns the breadedFriedAppSide.
     */
    public FilterParameter getBreadedFriedAppSide() {
        return breadedFriedAppSide;
    }

    /**
     * @param breadedFriedAppSide The breadedFriedAppSide to set.
     */
    public void setBreadedFriedAppSide(FilterParameter breadedFriedAppSide) {
        this.breadedFriedAppSide = breadedFriedAppSide;
    }

    /**
     * @return Returns the breakfastToGo.
     */
    public FilterParameter getBreakfastToGo() {
        return breakfastToGo;
    }

    /**
     * @param breakfastToGo The breakfastToGo to set.
     */
    public void setBreakfastToGo(FilterParameter breakfastToGo) {
        this.breakfastToGo = breakfastToGo;
    }

    /**
     * @return Returns the cookieLookAlikeDessert.
     */
    public FilterParameter getCookieLookAlikeDessert() {
        return cookieLookAlikeDessert;
    }

    /**
     * @param cookieLookAlikeDessert The cookieLookAlikeDessert to set.
     */
    public void setCookieLookAlikeDessert(FilterParameter cookieLookAlikeDessert) {
        this.cookieLookAlikeDessert = cookieLookAlikeDessert;
    }

    /**
     * @return Returns the cookSauceType.
     */
    public FilterParameter getCookSauceType() {
        return cookSauceType;
    }

    /**
     * @param cookSauceType The cookSauceType to set.
     */
    public void setCookSauceType(FilterParameter cookSauceType) {
        this.cookSauceType = cookSauceType;
    }

    /**
     * @return Returns the dressingFlavor.
     */
    public FilterParameter getDressingFlavor() {
        return dressingFlavor;
    }

    /**
     * @param dressingFlavor The dressingFlavor to set.
     */
    public void setDressingFlavor(FilterParameter dressingFlavor) {
        this.dressingFlavor = dressingFlavor;
    }

    /**
     * @return Returns the dressingType.
     */
    public FilterParameter getDressingType() {
        return dressingType;
    }

    /**
     * @param dressingType The dressingType to set.
     */
    public void setDressingType(FilterParameter dressingType) {
        this.dressingType = dressingType;
    }

    /**
     * @return Returns the ethnicBreadType.
     */
    public FilterParameter getEthnicBreadType() {
        return ethnicBreadType;
    }

    /**
     * @param ethnicBreadType The ethnicBreadType to set.
     */
    public void setEthnicBreadType(FilterParameter ethnicBreadType) {
        this.ethnicBreadType = ethnicBreadType;
    }

    /**
     * @return Returns the flavorChangeAnyYear.
     */
    public FilterParameter getFlavorChangeAnyYear() {
        return flavorChangeAnyYear;
    }

    /**
     * @param flavorChangeAnyYear The flavorChangeAnyYear to set.
     */
    public void setFlavorChangeAnyYear(FilterParameter flavorChangeAnyYear) {
        this.flavorChangeAnyYear = flavorChangeAnyYear;
    }

    /**
     * @return Returns the fruitorFruitFillingIngred.
     */
    public FilterParameter getFruitorFruitFillingIngred() {
        return fruitOrFruitFillingIngred;
    }

    /**
     * @param fruitorFruitFillingIngred The fruitorFruitFillingIngred to set.
     */

    /**
     * @return Returns the grillRoastSmoke.
     */
    public FilterParameter getGrillRoastSmoke() {
        return grillRoastSmoke;
    }

    /**
     * @param grillRoastSmoke The grillRoastSmoke to set.
     */
    public void setGrillRoastSmoke(FilterParameter grillRoastSmoke) {
        this.grillRoastSmoke = grillRoastSmoke;
    }

    /**
     * @return Returns the mexBreadType.
     */
    public FilterParameter getMexBreadType() {
        return mexBreadType;
    }

    /**
     * @param mexBreadType The mexBreadType to set.
     */
    public void setMexBreadType(FilterParameter mexBreadType) {
        this.mexBreadType = mexBreadType;
    }

    /**
     * @return Returns the mexIngredUse.
     */
    public FilterParameter getMexIngredUse() {
        return mexIngredUse;
    }

    /**
     * @param mexIngredUse The mexIngredUse to set.
     */
    public void setMexIngredUse(FilterParameter mexIngredUse) {
        this.mexIngredUse = mexIngredUse;
    }

    /**
     * @return Returns the pepperType.
     */
    public FilterParameter getPepperType() {
        return pepperType;
    }

    /**
     * @param pepperType The pepperType to set.
     */
    public void setPepperType(FilterParameter pepperType) {
        this.pepperType = pepperType;
    }

    /**
     * @return Returns the pizzaStyle.
     */
    public FilterParameter getPizzaStyle() {
        return pizzaStyle;
    }

    /**
     * @param pizzaStyle The pizzaStyle to set.
     */
    public void setPizzaStyle(FilterParameter pizzaStyle) {
        this.pizzaStyle = pizzaStyle;
    }

    /**
     * @return Returns the potatoTypeUse.
     */
    public FilterParameter getPotatoTypeUse() {
        return potatoTypeUse;
    }

    /**
     * @param potatoTypeUse The potatoTypeUse to set.
     */
    public void setPotatoTypeUse(FilterParameter potatoTypeUse) {
        this.potatoTypeUse = potatoTypeUse;
    }

    /**
     * @return Returns the prepEntreeType.
     */
    public FilterParameter getPrepEntreeType() {
        return prepEntreeType;
    }

    /**
     * @param prepEntreeType The prepEntreeType to set.
     */
    public void setPrepEntreeType(FilterParameter prepEntreeType) {
        this.prepEntreeType = prepEntreeType;
    }

    /**
     * @return Returns the riceTypeUse.
     */
    public FilterParameter getRiceTypeUse() {
        return riceTypeUse;
    }

    /**
     * @param riceTypeUse The riceTypeUse to set.
     */
    public void setRiceTypeUse(FilterParameter riceTypeUse) {
        this.riceTypeUse = riceTypeUse;
    }

    /**
     * @return Returns the roastVegItemType.
     */
    public FilterParameter getRoastVegItemType() {
        return roastVegItemType;
    }

    /**
     * @param roastVegItemType The roastVegItemType to set.
     */
    public void setRoastVegItemType(FilterParameter roastVegItemType) {
        this.roastVegItemType = roastVegItemType;
    }

    /**
     * @return Returns the salsaType.
     */
    public FilterParameter getSalsaType() {
        return salsaType;
    }

    /**
     * @param salsaType The salsaType to set.
     */
    public void setSalsaType(FilterParameter salsaType) {
        this.salsaType = salsaType;
    }

    /**
     * @return Returns the vegCookMeth.
     */
    public FilterParameter getVegCookMeth() {
        return vegCookMeth;
    }

    /**
     * @param vegCookMeth The vegCookMeth to set.
     */
    public void setVegCookMeth(FilterParameter vegCookMeth) {
        this.vegCookMeth = vegCookMeth;
    }

    /**
     * @return Returns the cuisineVerySpecific.
     */
    public FilterParameter getCuisineVerySpecific() {
        return cuisineVerySpecific;
    }

    /**
     * @param cuisineVerySpecific The cuisineVerySpecific to set.
     */
    public void setCuisineVerySpecific(FilterParameter cuisineVerySpecific) {
        this.cuisineVerySpecific = cuisineVerySpecific;
    }

    /**
     * @return Returns the newItemBrag.
     */
    public FilterParameter getNewItemBrag() {
        return newItemBrag;
    }

    /**
     * @param newItemBrag The newItemBrag to set.
     */
    public void setNewItemBrag(FilterParameter newItemBrag) {
        this.newItemBrag = newItemBrag;
    }

    /**
     * @return Returns the oilTypeUse.
     */
    public FilterParameter getOilTypeUse() {
        return oilTypeUse;
    }

    /**
     * @param oilTypeUse The oilTypeUse to set.
     */
    public void setOilTypeUse(FilterParameter oilTypeUse) {
        this.oilTypeUse = oilTypeUse;
    }

    /**
     * @return Returns the proteinFlavorApp.
     */
    public FilterParameter getProteinFlavorApp() {
        return proteinFlavorApp;
    }

    /**
     * @param proteinFlavorApp The proteinFlavorApp to set.
     */
    public void setProteinFlavorApp(FilterParameter proteinFlavorApp) {
        this.proteinFlavorApp = proteinFlavorApp;
    }

    public FilterParameter getCheeseForm() {
        return cheeseForm;
    }

    public void setCheeseForm(FilterParameter cheeseForm) {
        this.cheeseForm = cheeseForm;
    }

    public FilterParameter getCheeseSauceFillingType() {
        return cheeseSauceFillingType;
    }

    public void setCheeseSauceFillingType(FilterParameter cheeseSauceFillingType) {
        this.cheeseSauceFillingType = cheeseSauceFillingType;
    }

    public FilterParameter getEggItemUse() {
        return eggItemUse;
    }

    public void setEggItemUse(FilterParameter eggItemUse) {
        this.eggItemUse = eggItemUse;
    }



    public FilterParameter getSoupBaseBroth() {
        return soupBaseBroth;
    }

    public void setSoupBaseBroth(FilterParameter soupBaseBroth) {
        this.soupBaseBroth = soupBaseBroth;
    }

    public FilterParameter getSoupWith() {
        return soupWith;
    }

    public void setSoupWith(FilterParameter soupWith) {
        this.soupWith = soupWith;
    }

    public FilterParameter getAllVegCarbFruit() {
        return allVegCarbFruit;
    }

    public void setAllVegCarbFruit(FilterParameter allVegCarbFruit) {
        this.allVegCarbFruit = allVegCarbFruit;
    }

    public FilterParameter getVeggieAll() {
        return veggieAll;
    }

    public void setVeggieAll(FilterParameter veggieAll) {
        this.veggieAll = veggieAll;
    }
    
    /*
     *  7-25-07 JDL
     */
    
    public FilterParameter getBevMenuItem() {
        return bevMenuItem;
    }

    public void setBevMenuItem(FilterParameter bevMenuItem) {
        this.bevMenuItem = bevMenuItem;
    }
    
    public FilterParameter getSideAccompDisFlavor() {
        return sideAccompDisFlavor;
    }

    public void setSideAccompDisFlavor(FilterParameter sideAccompDisFlavor) {
        this.sideAccompDisFlavor = sideAccompDisFlavor;
    }
    
    public FilterParameter getCookieTypeSource() {
        return cookieTypeSource;
    }

    public void setCookieTypeSource(FilterParameter cookieTypeSource) {
        this.cookieTypeSource = cookieTypeSource;
    }
    
    public FilterParameter getCreamyTop() {
        return creamyTop;
    }

    public void setCreamyTop(FilterParameter creamyTop) {
        this.creamyTop = creamyTop;
    }
    
    public FilterParameter getCreamyFill() {
        return creamyFill;
    }

    public void setCreamyFill(FilterParameter creamyFill) {
        this.creamyFill = creamyFill;
    }
    
    public FilterParameter getTextureAttrib() {
        return textureAttrib;
    }

    public void setTextureAttrib(FilterParameter textureAttrib) {
        this.textureAttrib = textureAttrib;
    }
    
    public FilterParameter getQualityStyle() {
        return qualityStyle;
    }

    public void setQualityStyle(FilterParameter qualityStyle) {
        this.qualityStyle = qualityStyle;
    }
}