/*
 * Created on Feb 1, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
 * 2006-07-26 to add a new field
 * 
 * 1) create the constant here
 * 2) add to fieldstodisplaybean java & hbm
 * 3) add to masterfoodfilterparamsters IF & IMPL
 * 4) add to masterfoodfilterparameterswrapper IF & IMPL
 * 5) add to masterfood.java & hbm
 * 6) add to statistical table key finder factory
 * 
 */
public class FieldEnum implements Serializable {

    private String name;

    private String friendlyName;

    private boolean searchable;

    /*
     * This is the ognl to get a list of distinctQuery options.
     */
    private String distinctQuery;

    /*
     * 2005.2.1 if we have a name we can grab the ognl from here to get data.
     * For instance if I know which fields a selected.
     * 
     * If we need to show more then 7 fields we should go this way rather than
     * the clunky display wrapper.
     */
    private String ognlShortName;

    private String ognlRoot;

    private boolean numeric;

    private static Collection all = new ArrayList();

    public static FieldEnum KEYWORDS = new FieldEnum("keywords", "Keywords",
            "keywords", true, null);

    public static FieldEnum MENU_ITEM_NAME = new FieldEnum("menuItemName",
            "Menu Item Name", "menuItem", true, null);

    public static FieldEnum BASIC_PROTEIN = new FieldEnum("basicProtein",
            "Basic Protein", "basicProtein", true, null);

    /*
     * 2006-01-22 RSC Multiple menu parts since different menu groups will have
     * different menu parts. Note that "genMenuPart" is the same everywhere.
     */
    public static FieldEnum MENU_PART = new FieldEnum("menuPart", "Menu Part",
            "genMenuPart", true, null);

    public static FieldEnum DESSERT_MENU_PART = new FieldEnum("menuPart",
            "Menu Part", "genMenuPart", true, null, "dessertMenuPart");

    public static FieldEnum BREAKFAST_MENU_PART = new FieldEnum("menuPart",
            "Menu Part", "genMenuPart", true, null, "breakfastMenuPart");

    public static FieldEnum BEVERAGE_MENU_PART = new FieldEnum("menuPart",
            "Menu Part", "genMenuPart", true, null, "beverageMenuPart");

    /*
     * 2006-01-30 RSC Eliminating the chain object
     */
    // public static FieldEnum MARKET_SECTOR = new FieldEnum("marketSector",
    // "Market Sector", "sectorName", true, "chain");
    public static FieldEnum MARKET_SECTOR = new FieldEnum("marketSector",
            "Market Sector", "sectorName", true, null);

    // public static FieldEnum MARKET_SEGMENT = new FieldEnum("marketSegment",
    // "Market Segment", "segment", true, "chain");
    public static FieldEnum MARKET_SEGMENT = new FieldEnum("marketSegment",
            "Market Segment", "segment", true, null);

    public static FieldEnum CUISINE = new FieldEnum("cuisine", "Cuisine",
            "cuisine", true, null);

    public static FieldEnum DESSERT_CUISINE = new FieldEnum("cuisine",
            "Cuisine", "cuisine", true, null, "dessertCuisine");

    public static FieldEnum COOKING_METHOD = new FieldEnum("cookingMethod",
            "Cooking Method", "cookMeth", true, null);

    // public static FieldEnum OPERATION_NAME = new FieldEnum("operationName",
    // "Operation Name", "operationName", true, "chain");
    public static FieldEnum OPERATION_NAME = new FieldEnum("operationName",
            "Operation Name", "operationName", true, null);

    public static FieldEnum OPERATION_CHAIN_ID = new FieldEnum("chainId",
            "Operation Chain ID", "chainID", true, null);

    // public static FieldEnum YEAR_PUT_IN_DATABASE = new FieldEnum(
    // "yearPutInDatabase", "Year Added To Database", "yearPutInDatabase",
    // true, "chain");
    public static FieldEnum YEAR_PUT_IN_DATABASE = new FieldEnum(
            "yearPutInDatabase", "Year Added To Database", "yearPutInDatabase",
            true, null);

    public static FieldEnum YEAR_PUT_IN_DATABASE_SAME_STORE = new FieldEnum(
            "yearPutInDatabaseSameStore", "Same Store",
            "yearPutInDatabaseSameStore", true, null, null, true);

    public static FieldEnum PROTEIN_TYPE_CUT = new FieldEnum("proteinTypeCut",
            "Protein Type/Cut", "proteinTypeCut", true, null);
    
    // MJB 06-01-09 added the 9 protein types below.
    
    public static FieldEnum CHICKEN_TYPE = new FieldEnum("chickenType",
    		"Chicken Type", "chickenType", true, null);
    
    public static FieldEnum BEEF_TYPE = new FieldEnum("beefType",
    		"Beef Type", "beefType", true, null);
    
    public static FieldEnum PORK_TYPE = new FieldEnum("porkType",
    		"Pork Type", "porkType", true, null);
    
    public static FieldEnum FISH_TYPE = new FieldEnum("fishType",
    		"Fish Type", "fishType", true, null);
    
    public static FieldEnum SEAFOOD_TYPE = new FieldEnum("seafoodType",
    		"Seafood Type", "seafoodType", true, null);
    
    public static FieldEnum LAMB_TYPE = new FieldEnum("lambType",
    		"Lamb Type", "lambType", true, null);
    
    public static FieldEnum TURKEY_TYPE = new FieldEnum("turkeyType",
    		"Turkey Type", "turkeyType", true, null);
    
    public static FieldEnum OTHER_PROTEIN_TYPE = new FieldEnum("otherProteinType",
    		"Other Protein Type", "otherProteinType", true, null);
    
    public static FieldEnum SHRIMP_TYPE = new FieldEnum("shrimpType",
    		"Shrimp Type", "shrimpType", true, null);

    public static FieldEnum SAUCE_OR_CONDIMENT = new FieldEnum(
            "sauceCondDressMarMM", "Sauce or Condiment", "sauceCondDressMarMM",
            true, null);

    public static FieldEnum SEASONING_BREADING = new FieldEnum(
            "seasoningBreading", "Seasoning/Breading",
            "flavEnhancSeasBrdgDesIngredMM", true, null);

    public static FieldEnum VEGGIE_OR_CARBO = new FieldEnum("carboVegFruit",
            "Veggie or Carbo", "carboVegFruit", true, null);

    public static FieldEnum TOPPING_FILLED_INGRED = new FieldEnum(
            "toppingFilledIngred", "Topping Filled Ingred", "topFillIngredMM",
            true, null);

    public static FieldEnum CHEESE = new FieldEnum("cheese", "Cheese",
            "cheeseMM", true, null);

    public static FieldEnum BREAD_BAKED_GOOD = new FieldEnum("breadBakedGood",
            "Bread/Baked Good", "breadBakeGoodsMM", true, null);

    public static FieldEnum ITEM_TYPE = new FieldEnum("itemType", "Item Type",
            "menuItemType", true, null);

    public static FieldEnum DESCRIPTION = new FieldEnum("description",
            "Description", "itemDescription", true, null);

    public static FieldEnum MENU_ITEM_CLASS = new FieldEnum("menuItemClass",
            "Menu Item Class", "menuItemClass", true, null);

    public static FieldEnum DESSERT_MENU_ITEM_CLASS = new FieldEnum(
            "menuItemClass", "Menu Item Class", "menuItemClass", true, null,
            "dessertMenuItemClass");

    public static FieldEnum MENU_STATUS = new FieldEnum("menuStatus",
            "Menu Status", "menuStatus", true, null);

    public static FieldEnum DESSERT_MENU_STATUS = new FieldEnum("menuStatus",
            "Menu Status", "menuStatus", true, null, "dessertMenuStatus");

    public static FieldEnum GEN_COOKING_METHOD = new FieldEnum("genCookMeth",
            "General Cook Method", "genCookMeth", true, null);

    public static FieldEnum CUISINE_FAMILY = new FieldEnum("cuisineFamily",
            "Cuisine Family", "cuisineFamily", true, null);

    // public static FieldEnum HEADQUARTERS_STATE = new FieldEnum(
    // "headquartersState", "Headquarters State", "hqState", true, "chain");
    public static FieldEnum HEADQUARTERS_STATE = new FieldEnum(
            "headquartersState", "Headquarters State", "hqState", true, null);

    // public static FieldEnum HEADQUARTERS_REGION = new FieldEnum(
    // "headquartersRegion", "Headquarters Region", "hqRegion", true,
    // "chain");
    public static FieldEnum HEADQUARTERS_REGION = new FieldEnum(
            "headquartersRegion", "Headquarters Region", "hqRegion", true, null);

    // public static FieldEnum OPERATOR_TYPE = new FieldEnum("operatorType",
    // "Operator Type", "operatorType", true, "chain");
    public static FieldEnum OPERATOR_TYPE = new FieldEnum("operatorType",
            "Operator Type", "operatorType", true, null);

    // public static FieldEnum COUNTRY_LOCATION = new FieldEnum("countryLoc",
    // "Country", "countryLoc", true, "chain");
    public static FieldEnum COUNTRY_LOCATION = new FieldEnum("countryLoc",
            "Country", "countryLoc", true, null);
    
    public static FieldEnum PRICE_2011 = new FieldEnum("price2011",
            "Price 2011", "price2011", true, null, null, true);
    
    // MJB 11-12-2009 Added 2010
    public static FieldEnum PRICE_2010 = new FieldEnum("price2010",
            "Price 2010", "price2010", true, null, null, true);
    
    // DBB 1-20-2009 Add 2008, 2009
    public static FieldEnum PRICE_2009 = new FieldEnum("price2009",
            "Price 2009", "price2009", true, null, null, true);
        
    public static FieldEnum PRICE_2008 = new FieldEnum("price2008",
            "Price 2008", "price2008", true, null, null, true);
    
    //JDL 10-5-07
    public static FieldEnum PRICE_2007 = new FieldEnum("price2007",
            "Price 2007", "price2007", true, null, null, true);
    
    public static FieldEnum PRICE_2006 = new FieldEnum("price2006",
            "Price 2006", "price2006", true, null, null, true);

    public static FieldEnum PRICE_2005 = new FieldEnum("price2005",
            "Price 2005", "price2005", true, null, null, true);

    public static FieldEnum PRICE_2004 = new FieldEnum("price2004",
            "Price 2004", "price2004", true, null, null, true);

    public static FieldEnum PRICE_2003 = new FieldEnum("price2003",
            "Price 2003", "price2003", true, null, null, true);

    public static FieldEnum PRICE_2002 = new FieldEnum("price2002",
            "Price 2002", "price2002", true, null, null, true);

    public static FieldEnum PRICE_2001 = new FieldEnum("price2001",
            "Price 2001", "price2001", true, null, null, true);

    public static FieldEnum PRICE_2000 = new FieldEnum("price2000",
            "Price 2000", "price2000", true, null, null, true);

    public static FieldEnum PRICE_1999 = new FieldEnum("price1999",
            "Price 1999", "price1999", true, null, null, true);

    public static FieldEnum PRICE_1998 = new FieldEnum("price1998",
            "Price 1998", "price1998", true, null, null, true);

    public static FieldEnum PRICE_1997 = new FieldEnum("price1997",
            "Price 1997", "price1997", true, null, null, true);

    public static FieldEnum PRICE_1996 = new FieldEnum("price1996",
            "Price 1996", "price1996", true, null, null, true);

    public static FieldEnum DAY_PART_CATEGORY = new FieldEnum(
            "dayPartCategory", "Day Part Category", "dayPartCategory", true,
            null);

    public static FieldEnum CAKE_INGREDIENT = new FieldEnum("cakeIngredient",
            "Cake Type/Flavor", "cakeIngredient", true, null);

    public static FieldEnum CAKE_USE = new FieldEnum("cakeUse", "Cake Use",
            "cakeUse", true, null);

    public static FieldEnum COOKIE_INGREDIENT = new FieldEnum(
            "cookieIngredient", "Cookie Type/Flavor", "cookieIngredient", true,
            null);

    public static FieldEnum COOKIE_USE = new FieldEnum("cookieUse",
            "Cookie Use", "cookieUse", true, null);

    public static FieldEnum DESSERT_DOUGH_CRUST_INGRED = new FieldEnum(
            "dessertDoughCrustIngred", "Dough/Crust/Flavor",
            "dessertDoughCrustIngred", true, null);

    public static FieldEnum ICE_CREAM_INGREDIENT = new FieldEnum(
            "iceCreamIngredient", "Ice Cream Type/Flavor",
            "iceCreamIngredient", true, null);

    public static FieldEnum SYRUP_TOPPING = new FieldEnum("syrupTopping",
            "Syrup/Sauce Topping", "syrupTopping", true, null);

    public static FieldEnum NUT_INGREDIENT = new FieldEnum("nutIngredient",
            "Nut Topping", "nutIngredient", true, null);

    public static FieldEnum FRUIT_OR_FRUIT_FILLING_INGRED = new FieldEnum(
            "fruitOrFruitFillingIngred", "Fruit Or Fruit Filling",
            "fruitOrFruitFillingIngred", true, null);

    public static FieldEnum WHIPPED_TOPPING_INGRED = new FieldEnum(
            "whippedToppingIngred", "Whipped Topping", "whippedToppingIngred",
            true, null);

    public static FieldEnum CANDY_INGREDIENT = new FieldEnum("candyIngredient",
            "Candy Type/Brand", "candyIngredient", true, null);

    public static FieldEnum PRIMARY_FLAVOR = new FieldEnum("primaryFlavor",
            "Primary Flavor", "primaryFlavor", true, null);

    // MK renaming field based on ticket #17
    public static FieldEnum TASTE_FLAVOR_WORDS = new FieldEnum(
            "tasteFlavorWords", "Taste Flavor Attrib.", "tasteFlavorWords",
            true, null);
    
    // MK adding new field based on ticket #17
   // public static FieldEnum CREAMY_TOPPING = new FieldEnum(
   //         "CreamyTop", "Creamy Topping", "CreamyTop",
   //         true, null);
    
    // MK adding new field based on ticket #17
    public static FieldEnum CREAMY_FILLING = new FieldEnum(
            "creamyFill", "Creamy Filling", "creamyFill",
            true, null);
    
    // MK adding new field based on ticket #17
   // public static FieldEnum TEXTURE_ATTRIBUTE = new FieldEnum(
  //          "TextureAttrib", "Texture Attribute", "TextureAttrib",
  //          true, null);
    
    // MK adding new field based on ticket #17
    public static FieldEnum QUALITY_STYLE = new FieldEnum(
            "qualityStyle", "Quality/Style Attr.", "qualityStyle",
            true, null);

    public static FieldEnum BRAND = new FieldEnum("brand", "Brand", "brand",
            true, null);

    public static FieldEnum VEGGIE_FRUIT_MM = new FieldEnum("veggieFruitMM",
            "Veggie/Fruit", "veggieFruitMM", true, null);

    public static FieldEnum CARBO_MM = new FieldEnum("carboMM", "Carbo",
            "carboMM", true, null);
    
    public static FieldEnum CARBO_ALL = new FieldEnum("carboAll", "Any Carb Use",
            "carboAll", true, null);

    public static FieldEnum BREAD_USE = new FieldEnum("breadUse", "Bread Use",
            "breadUse", true, null);

    public static FieldEnum FLAV_APPLICATION = new FieldEnum("flavApplication",
            "Flavor Application", "flavApplication", true, null);

    public static FieldEnum FLAVOR_SOUP = new FieldEnum("flavorSoup",
            "Soup Flavor", "flavorSoup", true, null);

    public static FieldEnum SIDE_OR_ACCOMP = new FieldEnum("sideOrAccomp",
            "Side Or Accomp ", "sideOrAccomp", true, null);

    public static FieldEnum HEALTHY_TERM = new FieldEnum("healthyTerm",
            "Healthy Term", "healthyTerm", true, null);

    /*
     * Nick 2005-8-8 Added for ingredient menumine.
     */
    public static FieldEnum COOKING_SAUCE_OR_GRAVY = new FieldEnum(
            "cookingSauceOrGravy", "Cooking Sauce", "cookingSauceOrGravy",
            true, null);

    public static FieldEnum MARINADE = new FieldEnum("marinade", "Marinade",
            "marinade", true, null);

    public static FieldEnum GLAZE = new FieldEnum("glaze", "Glaze", "glaze",
            true, null);

    public static FieldEnum DRESSINGS = new FieldEnum("dressings", "Dressing",
            "dressings", true, null);

    public static FieldEnum DIP_SAUCE_NAME = new FieldEnum("dipSauceName",
            "Dip Sauce", "dipSauceName", true, null);
    
    public static FieldEnum DAIRY_BUTTER_CREAM = new FieldEnum("dairyButterCream",
            "Dairy/Butter/Cream", "dairyButterCream", true, null);
    
    public static FieldEnum ONION_SCALLION_LEEK = new FieldEnum("onionScallionLeek",
            "Onion/Scallion/Leek", "onionScallionLeek", true, null);
    
    public static FieldEnum MUSHROOM_TYPE = new FieldEnum("mushroomType",
            "Mushroom Type", "mushroomType", true, null);
    
    public static FieldEnum TOMATO_TYPE = new FieldEnum("tomatoType",
            "Tomato Type", "tomatoType", true, null);

    public static FieldEnum CONDIMENTS = new FieldEnum("condiments",
            "Condiment", "condiments", true, null);

    public static FieldEnum BUTTER_APPLICATION = new FieldEnum(
            "butterApplication", "Butter Application", "butterApplication",
            true, null);

    public static FieldEnum SEASONING_NAME = new FieldEnum("seasoningName",
            "Seasoning", "seasoningName", true, null);

    public static FieldEnum BATTER_BREADING_COATING = new FieldEnum(
            "batterBreadingCoating", "Batter/Breading/Coating",
            "batterBreadingCoating", true, null);

    public static FieldEnum STUFF_NAME = new FieldEnum("stuffName",
            "Stuff/Fill", "stuffName", true, null);

    public static FieldEnum CHEESE_ROLL_UP = new FieldEnum("cheeseRollUp",
            "Cheese Roll Up", "cheeseRollUp", true, null);

    public static FieldEnum CHEESE_APPLICATION = new FieldEnum(
            "cheeseCheeseSauceFillingType", "Cheese Application",
            "cheeseCheeseSauceFillingType", true, null);

    public static FieldEnum PROTEIN_TOP_NAME = new FieldEnum("proteinTopName",
            "Protein Topping", "proteinTopName", true, null);

    public static FieldEnum PROTEIN_ACCOMP_NAME = new FieldEnum(
            "proteinAccompName", "Protein Accompaniment", "proteinAccompName",
            true, null);

    public static FieldEnum VEGGIE_FRUIT_TYPE = new FieldEnum(
            "veggieFruitType", "Veggie Ingred/Side", "veggieFruitType", true, null);

    public static FieldEnum GREEN_VEG_NAME = new FieldEnum("greenVegName",
            "Green Veg", "greenVegName", true, null);

    public static FieldEnum VEG_TOP_NAME = new FieldEnum("vegTopName",
            "Veggie Topping", "vegTopName", true, null);

    public static FieldEnum VEG_ACCOMP_NAME = new FieldEnum("vegAccompName",
            "Veggie Accomp to Entree", "vegAccompName", true, null);

    public static FieldEnum FRUIT_TYPE = new FieldEnum("fruitType",
            "Fruit Type", "fruitType", true, null);

    public static FieldEnum CARBO_TYPE = new FieldEnum("carboType",
            "Carb Ingred/Side", "carboType", true, null);

    public static FieldEnum CARBO_TOP_NAME = new FieldEnum("carboTopName",
            "Carb Topping", "carboTopName", true, null);

    public static FieldEnum CARBO_ACCOMP_NAME = new FieldEnum("carboAccompName",
    		"Carb Accomp to Entree", "carboAccompName", true, null);

    public static FieldEnum BREAD_WRAPS_CHIPS = new FieldEnum("breadWrapChips",
            "Bread/Wrap/Chip", "breadWrapChips", true, null);

    public static FieldEnum EGG_TYPE = new FieldEnum("eggType", "Egg Type",
            "eggType", true, null);

    public static FieldEnum HOT_COLD_CEREAL = new FieldEnum("hotColdCereal",
            "Hot Cold Cereal", "hotColdCereal", true, null);

    // public static FieldEnum accompSideIngred= new FieldEnum("vegAccompName",
    // "Veggie Accompaniment", "vegAccompName", true, null);

    public static FieldEnum SPREAD_TYPE = new FieldEnum("spreadType",
            "Spread Type", "spreadType", true, null);

    public static FieldEnum BREAKFAST_PASTRY = new FieldEnum("breakfastPastry",
            "Breakfast Pastry", "breakfastPastry", true, null);

    public static FieldEnum BREAK_CAKE_WAFFLE = new FieldEnum("breakCakeWaff",
            "Cake Waffle", "breakCakeWaff", true, null);

    /*
     * Fields added for Beverage mine
     */

    public static FieldEnum LOGO_IMAGE_STYLE = new FieldEnum("logoImageStyle",
            "Logo Image Style", "logoImageStyle", true, null);

    public static FieldEnum BEV_SIZE = new FieldEnum("bevSize",
            "Beverage Size", "bevSize", true, null);

    public static FieldEnum SERVING_COUNT = new FieldEnum("servingCount",
            "Serving Count", "servingCount", true, null);

    /*
     * 2006-01-17 Fields added RSC
     */
    public static FieldEnum PROTEIN_FISH_SHRIMP_SEAFOOD = new FieldEnum(
            "proteinFishShrimpSeafood", "Fish/Shrimp/Seafood",
            "proteinFishShrimpSeafood", true, null);

    /*
     * 2006-04-19 RSC Hidden fields from profiler.
     */
    public static FieldEnum OTHER_INGREDIENT = new FieldEnum("otherIngredName",
            "Other Ingredient", "otherIngredName", true, null);

    public static FieldEnum OTHER_TOPPINGS = new FieldEnum("otherToppings",
            "Other Toppings", "otherToppings", true, null);

    public static FieldEnum OTHER_TOP_INGREDIENT = new FieldEnum(
            "otherTopIngred", "Other Topping/Ingred", "otherTopIngred", true,
            null);

    public static FieldEnum OTHER_ACCOMPANIMENTS = new FieldEnum(
            "otherAccompaniments", "Other Accompaniments",
            "otherAccompaniments", true, null);

    public static FieldEnum HEALTHY_FLAG = new FieldEnum("healthyFlag",
            "Healthy Flag", "healthyFlag", true, null);

    public static FieldEnum HEALTHY_SYMBOL = new FieldEnum("healthySymbol",
            "Healthy Symbol", "healthySymbol", true, null);

    public static FieldEnum FILLING_SAUCES_DRESSINGS = new FieldEnum("fillingSaucesDressings",
            "Filling/Sauces/Dressings", "fillingSaucesDressings", true, null);

    public static FieldEnum CUISINE_VERY_SPECIFIC = new FieldEnum("cuisineVerySpecific",
            "Cuisine, Very Specific", "cuisineVerySpecific", true, null);    
    
    public static FieldEnum GRILL_ROAST_SMOKE = new FieldEnum("grillRoastSmoke",
            "Grilled, Roasted or Smoked", "grillRoastSmoke", true, null);    
    
    public static FieldEnum VEG_COOK_METHOD = new FieldEnum("vegCookMeth",
            "Vegetable Cook Method", "vegCookMeth", true, null);    
    
    public static FieldEnum COOK_SAUCE_TYPE = new FieldEnum("cookSauceType",
            "Cooking Sauce Type", "cookSauceType", true, null);    
    
    public static FieldEnum DRESSING_TYPE = new FieldEnum("dressingType",
            "Dressing Type", "dressingType", true, null);    
    
    public static FieldEnum DRESSING_FLAVOR = new FieldEnum("dressingFlavor",
            "Dressing Flavor", "dressingFlavor", true, null);    
    
    public static FieldEnum MEX_BREAD_TYPE = new FieldEnum("mexBreadType",
            "Mexican Bread Type", "mexBreadType", true, null);    
    
    public static FieldEnum ROAST_VEG_ITEM_TYPE = new FieldEnum("roastVegItemType",
            "Roast Vegetable Item Type", "roastVegItemType", true, null);    
    
    public static FieldEnum APPET_CLASS_TYP = new FieldEnum("appetClassTyp",
            "Appetizer Class Type", "appetClassTyp", true, null);    
    
    public static FieldEnum PREP_ENTREE_TYPE = new FieldEnum("prepEntreeType",
            "Prepared Entree Type", "prepEntreeType", true, null);    
    
    public static FieldEnum BREADED_FRIED_APPET_SIDE = new FieldEnum("breadedFriedAppSide",
            "Breaded Fried Appetizer Side", "breadedFriedAppSide", true, null);    
    
    public static FieldEnum POTATO_TYPE_USE = new FieldEnum("potatoTypeUse",
            "Potato Type Use", "potatoTypeUse", true, null);    
    
    public static FieldEnum SALSA_TYPE = new FieldEnum("salsaType",
            "Salsa Type", "salsaType", true, null);    
    
    public static FieldEnum COOKIE_LOOK_ALIKE_DESSERT = new FieldEnum("cookieLookAlikeDessert",
            "Cookie Look Alike Dessert", "cookieLookAlikeDessert", true, null);    
    
    public static FieldEnum BREAKFAST_TO_GO = new FieldEnum("breakfastToGo",
            "Breakfast To Go", "breakfastToGo", true, null);    
    
    public static FieldEnum PIZZA_STYLE = new FieldEnum("pizzaStyle",
            "Pizza Style", "pizzaStyle", true, null);    
    
    public static FieldEnum BBQ_COOK = new FieldEnum("bbqCook",
            "BBQ Cook", "bbqCook", true, null);    
    
    public static FieldEnum ETHNIC_BREAD_TYPE = new FieldEnum("ethnicBreadType",
            "Ethnic Bread Type", "ethnicBreadType", true, null);    
    
    public static FieldEnum PEPPER_TYPE = new FieldEnum("pepperType",
            "Pepper Type", "pepperType", true, null);    
    
    public static FieldEnum RICE_TYPE_USE = new FieldEnum("riceTypeUse",
            "Rice Type Use", "riceTypeUse", true, null);    
    
    public static FieldEnum MEX_INGRED_USE = new FieldEnum("mexIngredUse",
            "Mexican Ingredient Use", "mexIngredUse", true, null);    
    
    public static FieldEnum FLAVOR_CHANGE_ANY_YEAR = new FieldEnum("flavorChangeAnyYear",
            "Flavor Change Any Year", "flavorChangeAnyYear", true, null);    

    public static FieldEnum NEW_ITEM_BRAG = new FieldEnum("newItemBrag",
            "New Item Brag", "newItemBrag", true, null);
    
    public static FieldEnum PROTEIN_FLAVOR_APP = new FieldEnum("proteinFlavorApp",
            "Protein Flavor App", "proteinFlavorApp", true, null);
    
    public static FieldEnum OIL_TYPE_USE = new FieldEnum("oilTypeUse",
            "Oil Type Use", "oilTypeUse", true, null);
    
    public static FieldEnum EGG_ITEM_USE = new FieldEnum("eggItemUse",
            "Egg Item Use", "eggItemUse", true, null);
    
    public static FieldEnum CHEESE_FORM = new FieldEnum("cheeseForm",
            "Cheese Form", "cheeseForm", true, null);
    
    public static FieldEnum CHEESE_SAUCE_FILLING_TYPE = new FieldEnum("cheeseSauceFillingType",
            "Cheese Sce Fill Type", "cheeseSauceFillingType", true, null);    
    
    /*
     * 2006-09-06
     */
    public static FieldEnum SOUP_WITH = new FieldEnum("soupWith",
            "Soup With", "soupWith", true, null); 
    
    public static FieldEnum SOUP_BASE_BROTH = new FieldEnum("soupBaseBroth",
            "Soup Base Broth", "soupBaseBroth", true, null); 
    
    /*
     * 7-25-07 JDL Added 9 new fields
     */
    public static FieldEnum BEV_MENU_ITEM = new FieldEnum("bevMenuItem",
            "Bev Menu Item", "bevMenuItem", true, null); 
    
    public static FieldEnum SID_ACCOMP_DIS_FLAVOR = new FieldEnum("sideAccompDisFlavor",
            "Side Accomp Dis Flavor", "sideAccompDisFlavor", true, null); 
    
    public static FieldEnum COOKIE_TYPE_SOURCE = new FieldEnum("cookieTypeSource",
            "Cookie Type Source", "cookieTypeSource", true, null); 
    
    public static FieldEnum CREAMY_TOP = new FieldEnum("creamyTop",
            "Creamy Top", "creamyTop", true, null); 
    
   // public static FieldEnum CREAMY_FILL = new FieldEnum("CreamyFill",
   //         "Creamy Fill", "CreamyFill", true, null); 

    public static FieldEnum TEXTURE_ATTRIB = new FieldEnum("textureAttrib",
            "Texture Attrib", "textureAttrib", true, null); 
    
    /*public static FieldEnum QUALITY_STYLE = new FieldEnum("QualityStyle",
            "Quality Style", "QualityStyle", true, null); */
    
   //End JDL

    
    /*
     * 2006-11-07
     */
    public static FieldEnum VEGGIE_ALL = new FieldEnum("veggieAll",
            "Any Veggie Use", "veggieAll", true, null); 
    
    public static FieldEnum ALL_VEG_CARB_FRUIT = new FieldEnum("allVegCarbFruit",
            "Any Veg/Carb/Fruit", "allVegCarbFruit", true, null); 
    
    public FieldEnum(String name, String friendlyName, String ognlName) {
        super();
        this.friendlyName = friendlyName;
        this.name = name;
        this.ognlShortName = ognlName;
        this.searchable = false;
        this.distinctQuery = name;
        all.add(this);
    }

    public FieldEnum(String name, String friendlyName, String ognlName,
            boolean searchable, String ognlRoot) {
        super();
        this.friendlyName = friendlyName;
        this.name = name;
        this.ognlShortName = ognlName;
        this.searchable = searchable;
        this.ognlRoot = ognlRoot;
        this.distinctQuery = name;
        all.add(this);
    }

    public FieldEnum(String name, String friendlyName, String ognlName,
            boolean searchable, String ognlRoot, String distinctQuery) {
        super();
        this.friendlyName = friendlyName;
        this.name = name;
        this.ognlShortName = ognlName;
        this.searchable = searchable;
        this.ognlRoot = ognlRoot;
        this.distinctQuery = distinctQuery;
        all.add(this);
    }

    /*
     * 2006-03-29 RSC Added for pricing.
     */
    public FieldEnum(String name, String friendlyName, String ognlName,
            boolean searchable, String ognlRoot, String distinctQuery,
            boolean numeric) {
        super();
        this.friendlyName = friendlyName;
        this.name = name;
        this.ognlShortName = ognlName;
        this.searchable = searchable;
        this.ognlRoot = ognlRoot;
        this.distinctQuery = distinctQuery;
        this.numeric = numeric;
        all.add(this);
    }

    public String getFriendlyName() {
        return friendlyName;
    }

    public void setFriendlyName(String friendlyName) {
        this.friendlyName = friendlyName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOgnlName() {
        StringBuffer buffer = new StringBuffer();
        if (this.ognlRoot != null) {
            buffer.append(this.ognlRoot).append(".");
        }
        buffer.append(this.ognlShortName);
        return buffer.toString();
    }

    /*
     * This returns the final property. Basicaly without the chain if present.
     */
    public String getShortOgnlName() {

        return ognlShortName;
    }

    public void setOgnlName(String ognlName) {
        this.ognlShortName = ognlName;
    }

    public String getInName() {
        if (!this.searchable) {
            return null;
        }
        return this.getOgnlName() + ".inValues";
    }

    public String getAndName() {
        if (!this.searchable) {
            return null;
        }
        return this.getOgnlName() + ".andValues";
    }

    public String getOrName() {
        if (!this.searchable) {
            return null;
        }
        return this.getOgnlName() + ".orValues";
    }

    public String getNotName() {
        if (!this.searchable) {
            return null;
        }
        return this.getOgnlName() + ".notValues";
    }

    public String getEmptyName() {
        if (!this.searchable) {
            return null;
        }
        return this.getOgnlName() + ".empty";
    }

    public static Collection getAll() {

        return all;
    }

    public String getNotEmptyName() {

        if (!this.searchable) {
            return null;
        }
        return this.getOgnlName() + ".notEmpty";
    }

    public String getFieldsToDisplayName() {

        if (!this.searchable) {
            return null;
        }
        return "fieldsToDisplay." + this.getShortOgnlName();
    }

    /*
     * Short Ognl Name is used by the filterparameter and is the same as the
     * name.
     */
    public static FieldEnum getByName(String fieldName) {
        for (Iterator iter = getAll().iterator(); iter.hasNext();) {
            FieldEnum element = (FieldEnum) iter.next();
            if (element.getShortOgnlName().equals(fieldName)) {
                return element;
            }
        }
        return null;
    }

    public static FieldEnum getByOgnlName(String fieldName) {
        for (Iterator iter = getAll().iterator(); iter.hasNext();) {
            FieldEnum element = (FieldEnum) iter.next();
            if (element.getOgnlName().equals(fieldName)) {
                return element;
            }
        }
        return null;
    }

    /**
     * only added in to help fix a problem with BuildRollUp. For a while it was
     * saving by name rather than OgnlName.
     * 
     * @deprecated
     */
    public static FieldEnum getByOldName(String fieldName) {
        for (Iterator iter = getAll().iterator(); iter.hasNext();) {
            FieldEnum element = (FieldEnum) iter.next();
            if (element.getName().equals(fieldName)) {
                return element;
            }
        }
        return null;
    }

    public String getDistinctQuery() {
        return distinctQuery;
    }

    public boolean isNumeric() {
        return numeric;
    }

    public void setNumeric(boolean numeric) {
        this.numeric = numeric;
    }
}