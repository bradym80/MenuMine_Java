/*
 * Created on Aug 24, 2005
 *
 * 
 */
package com.fsrin.menumine.core.help;

import java.util.HashMap;

import com.fsrin.menumine.core.menumine.FieldEnum;
import com.fsrin.menumine.core.minefields.MineField;
import com.fsrin.menumine.core.minefields.MineFieldsFactory;

/**
 * @author Nick
 * 
 *  
 */
public class HelpDelegate {

    public static HashMap helpMap = new HashMap();

    public static final HelpDelegate singleton = new HelpDelegate();

    HelpVO menuMine = initHelpVO(
            MineFieldsFactory.MINE_TYPE_MENU,
            FieldEnum.MENU_PART,
            "Appetizers, Salads, Soup, Sandwiches, Burgers/Dogs, Center of the Plate"
                    + "Entrees, Prepared Entrees, Pizza and Side Dishes (a la cart)");

    HelpVO menuItemClass = initHelpVO(
            MineFieldsFactory.MINE_TYPE_MENU,
            FieldEnum.MENU_ITEM_CLASS,
            "Further classification of Menu Part including Appetizers-Hot and Appetizers-Cold");

    HelpVO itemType = initHelpVO(
            MineFieldsFactory.MINE_TYPE_MENU,
            FieldEnum.ITEM_TYPE,
            "All menu items are grouped into general types according to similarities such that Big Mac and Whopper are both classified as Signature Burgers");

    HelpVO menuItemName = initHelpVO(MineFieldsFactory.MINE_TYPE_MENU,
            FieldEnum.MENU_ITEM_NAME,
            "Name of the Item - Fresh, Tasty Chef Salad, D'Angelo's Shrimp Pizza, etc.");

    HelpVO description = initHelpVO(
            MineFieldsFactory.MINE_TYPE_MENU,
            FieldEnum.DESCRIPTION,
            "Exact wording on the menu describing the ingredients, flavors and other incidentals of the menu item");

    HelpVO menuStatus = initHelpVO(
            MineFieldsFactory.MINE_TYPE_MENU,
            FieldEnum.MENU_STATUS,
            "When Item was deleted/added, how long it's been on the menu, If item has been returned, etc.");

    HelpVO cuisine = initHelpVO(
            MineFieldsFactory.MINE_TYPE_MENU,
            FieldEnum.CUISINE,
            "Specific Cuisine i.e. Chinese, Japanese, Italian--over thirty various cuisines");

    HelpVO cuisineFamily = initHelpVO(
            MineFieldsFactory.MINE_TYPE_MENU,
            FieldEnum.CUISINE_FAMILY,
            "More general than Cuisine, Cuisine Family details Asian (Japanese, Thai, Chinese etc.) Mediterranean (Greek, Italian, Lebanese etc.)");

    HelpVO basicProtien = initHelpVO(MineFieldsFactory.MINE_TYPE_MENU,
            FieldEnum.BASIC_PROTEIN,
            "Chicken, Turkey, Pork, Beef, Fish, Shrimp, Seafood, Game Meats/Birds");

    HelpVO proteinTypeCut = initHelpVO(
            MineFieldsFactory.MINE_TYPE_MENU,
            FieldEnum.PROTEIN_TYPE_CUT,
            "Chicken Wings, Chicken Breasts, Chicken Tenders and more than 300 other specific protein types and cuts");

    HelpVO veggieFruit = initHelpVO(MineFieldsFactory.MINE_TYPE_MENU,
            FieldEnum.VEGGIE_FRUIT_MM,
            "Lettuce, Broccoli, Turnips, Tomatoes, Apples, Peaches, Pineapples");

    HelpVO carbo = initHelpVO(
            MineFieldsFactory.MINE_TYPE_MENU,
            FieldEnum.CARBO_MM,
            "Mashed Potatoes, Boiled Potatoes, Hash Browns, Basmati Rice, Arborio Rice, Black Beans, Navy Beans etc.");

    HelpVO sideAccompAppetizer = initHelpVO(MineFieldsFactory.MINE_TYPE_MENU,
            FieldEnum.SIDE_OR_ACCOMP,
            "Application Field for sides and appetizers and accompaniments");

    HelpVO breadBakedGood = initHelpVO(MineFieldsFactory.MINE_TYPE_MENU,
            FieldEnum.BREAD_BAKED_GOOD,
            "Wheat Bread, Enchilada, Croutons, Tortilla---more than 100 others");

    HelpVO breadUse = initHelpVO(
            MineFieldsFactory.MINE_TYPE_MENU,
            FieldEnum.BREAD_USE,
            "Application Field detailing bread use as stand alone side or sandwich platform or accompaniment etc.");

    HelpVO healthyTerm = initHelpVO(
            MineFieldsFactory.MINE_TYPE_MENU,
            FieldEnum.HEALTHY_TERM,
            "Includes specific terms used on the menu includeing low fat, low carb, no cholesterol etc");

    HelpVO sauceOfCondiment = initHelpVO(
            MineFieldsFactory.MINE_TYPE_MENU,
            FieldEnum.SAUCE_OR_CONDIMENT,
            "Combined field for any Sauce, Marinade, Glaze, Dressing, Dipping Sauce or Condiment---Ingredient MenuMine classifies specific components of each of these applications");

    HelpVO flavorApplication = initHelpVO(
            MineFieldsFactory.MINE_TYPE_MENU,
            FieldEnum.FLAV_APPLICATION,
            "Details flavor appication such as Glaze, Marinade, Sauce, Condiment, Dipping Sauce, Dressing etc.");

    HelpVO toppingFilledIngredient = initHelpVO(
            MineFieldsFactory.MINE_TYPE_MENU, FieldEnum.TOPPING_FILLED_INGRED,
            "Guacamole, Sour Cream, Cheese Sauce and more");

    HelpVO cheese = initHelpVO(MineFieldsFactory.MINE_TYPE_MENU,
            FieldEnum.CHEESE,
            "Cheddar, Mozzarella, Romano--over 100 various cheeses");

    HelpVO soupFlavor = initHelpVO(
            MineFieldsFactory.MINE_TYPE_MENU,
            FieldEnum.FLAVOR_SOUP,
            "Details Soup Flavor whether soup is a stand alone side or an accompaniment to a meal");

    HelpVO genCookingMethod = initHelpVO(
            MineFieldsFactory.MINE_TYPE_MENU,
            FieldEnum.GEN_COOKING_METHOD,
            "Grilled, Fried, Boiled, Steamed and more than ten other general cooking methods.");

    HelpVO cookingMethod = initHelpVO(
            MineFieldsFactory.MINE_TYPE_MENU,
            FieldEnum.COOKING_METHOD,
            "More specific than General Cooking Method---includes Char Grilled, Char Broiled, Deep Fried, Sauteed and others");

    HelpVO brand = initHelpVO(
            MineFieldsFactory.MINE_TYPE_MENU,
            FieldEnum.BRAND,
            "If the brand is listed on the menu either in the menu item name or the item description or in a general position on the menu, brand name is detailed here.  Does not include brand mentions on table top or store banners or dispensing machines or openly displayed product.");

    HelpVO operationName = initHelpVO(MineFieldsFactory.MINE_TYPE_MENU,
            FieldEnum.OPERATION_NAME, "Name of Restaurant or Institution");

    HelpVO marketSector = initHelpVO(
            MineFieldsFactory.MINE_TYPE_MENU,
            FieldEnum.MARKET_SECTOR,
            "Casual Chain, Midscale Chains, QSR Chains, Non-Commercial, QSR Independents etc.");

    HelpVO marketSegment = initHelpVO(MineFieldsFactory.MINE_TYPE_MENU,
            FieldEnum.MARKET_SEGMENT,
            "QSR-Burgers, QSR-Pizza, Asian Dinnerhouse, Casual Chain Steakhouse, others");

    HelpVO hqState = initHelpVO(MineFieldsFactory.MINE_TYPE_MENU,
            FieldEnum.HEADQUARTERS_STATE, "Location of Chain HQ, by State");

    HelpVO menuPartDessert = initHelpVO(
            MineFieldsFactory.MINE_TYPE_DESSERT,
            FieldEnum.DESSERT_MENU_PART,
            "General Classification inlcuding Beverage Dessert, Chiiled Dessert, Frozen Dessert, Cake, Pie, Cream Pastry, Dessert Snack, Topping");

    HelpVO menuItemClassDessert = initHelpVO(
            MineFieldsFactory.MINE_TYPE_DESSERT,
            FieldEnum.MENU_ITEM_CLASS,
            "Further classification of Menu Part including Cookies/Brownies, Cake/Cheesecake, Pudding/Mousse/Gelatin");

    HelpVO itemTypeDessert = initHelpVO(
            MineFieldsFactory.MINE_TYPE_DESSERT,
            FieldEnum.ITEM_TYPE,
            "All menu items are grouped into general types according to similarities such as Chocolate Cake, Carrot Cake, Tiramisu and others");

    HelpVO menuItemNameDessert = initHelpVO(
            MineFieldsFactory.MINE_TYPE_DESSERT,
            FieldEnum.MENU_ITEM_NAME,
            "Name of the Item - Taco Bell's \"Choco taco\" or Iron Skillet's \"Decadent Chocolate Fudge Brownie\"");

    HelpVO descriptionDessert = initHelpVO(
            MineFieldsFactory.MINE_TYPE_DESSERT,
            FieldEnum.DESCRIPTION,
            "Exact wording on the menu describing the ingredients, flavors and other incidentals of the menu item");

    HelpVO menuStatusDessert = initHelpVO(
            MineFieldsFactory.MINE_TYPE_DESSERT,
            FieldEnum.MENU_STATUS,
            "When Item was deleted/added, how long its been on the menu, If item has been returned, etc.");

    HelpVO cuisineSpecificDessert = initHelpVO(
            MineFieldsFactory.MINE_TYPE_DESSERT, FieldEnum.CUISINE,
            "Dessert Cuisine i.e. Italian, Mexican, French, Country-Home, Southern");

    HelpVO cakeTypeFlavorDessert = initHelpVO(
            MineFieldsFactory.MINE_TYPE_DESSERT, FieldEnum.CAKE_INGREDIENT,
            "Chocolate Cake, Carrot Cake, Tiramisu, Coconut Cake");

    HelpVO cakeUseDessert = initHelpVO(
            MineFieldsFactory.MINE_TYPE_DESSERT,
            FieldEnum.CAKE_USE,
            "Platform Field detailing Cake as Hand Held Snack, Cake with Cream Topping, Cake with Fruit Topping, Cake with Ice Cream Topping, Stand Alone Cake");

    HelpVO cookieTypeFlavorDessert = initHelpVO(
            MineFieldsFactory.MINE_TYPE_DESSERT, FieldEnum.COOKIE_INGREDIENT,
            "Peanut Butter, Chocolate Chip, Vanilla Wafer");

    HelpVO cookieUseDessert = initHelpVO(
            MineFieldsFactory.MINE_TYPE_DESSERT,
            FieldEnum.COOKIE_USE,
            "Platform Field detailing Single Cookie Dessert, Shake with Cookie Crumbles, Ice Cream Pie Crust, Cake with Cookie Crumble Layers and more");

    HelpVO doughCrustFlavorDessert = initHelpVO(
            MineFieldsFactory.MINE_TYPE_DESSERT,
            FieldEnum.DESSERT_DOUGH_CRUST_INGRED,
            "Platform Field detailing Cookie Dough, Pie Crust, Chocolate Wafer, Graham Cracker, Tortilla and more");

    HelpVO iceCreamTypeFlavorDessert = initHelpVO(
            MineFieldsFactory.MINE_TYPE_DESSERT,
            FieldEnum.ICE_CREAM_INGREDIENT,
            "Vanilla, Chocolate, strawberry, Oreo Cookie flavor and more");

    HelpVO syrupSauceToppingDessert = initHelpVO(
            MineFieldsFactory.MINE_TYPE_DESSERT, FieldEnum.SYRUP_TOPPING,
            "Vanilla Bean Sauce, Fudge Topping, Raspberry, Caramel and more");

    HelpVO nutToppingDessert = initHelpVO(MineFieldsFactory.MINE_TYPE_DESSERT,
            FieldEnum.NUT_INGREDIENT,
            "Walnuts, Spanish Peanuts, Pistachios, Pecans");

    HelpVO fruitorFruitFillingDessert = initHelpVO(
            MineFieldsFactory.MINE_TYPE_DESSERT,
            FieldEnum.FRUIT_OR_FRUIT_FILLING_INGRED,
            "Maraschino Cherries, Key Lime, Cranberry, Coconut, Cheese, Banana");

    HelpVO whippedToppingDessert = initHelpVO(
            MineFieldsFactory.MINE_TYPE_DESSERT,
            FieldEnum.WHIPPED_TOPPING_INGRED,
            "Mascarpone Cheese, Whipped Cream, Irish Cream, Lemon Mousse, Cream Cheese Filling, Banana Cream");

    HelpVO candyTypeBrandDessert = initHelpVO(
            MineFieldsFactory.MINE_TYPE_DESSERT, FieldEnum.CANDY_INGREDIENT,
            "White Chocolate Shavings, Vanilla Beans, Toffee, Sprinkles, Chocolate Chips");

    HelpVO primaryFlavorDessert = initHelpVO(
            MineFieldsFactory.MINE_TYPE_DESSERT, FieldEnum.PRIMARY_FLAVOR,
            "Peanut Butter, Chocolate, Butter Pecan");

    HelpVO tasteTextureAttributeDessert = initHelpVO(
            MineFieldsFactory.MINE_TYPE_DESSERT, FieldEnum.TASTE_FLAVOR_WORDS,
            "Crisp, Rich, Creamy, Fresh, Tart, Gooey, Flakey as detailed on the menu");

    HelpVO brandDessert = initHelpVO(
            MineFieldsFactory.MINE_TYPE_DESSERT,
            FieldEnum.BRAND,
            "Turtle, Snickers, Smuckers, Hershey, Godiva, Nutrasweet, Eli's, Amaretto, Oreo");

    HelpVO operationNameDessert = initHelpVO(
            MineFieldsFactory.MINE_TYPE_DESSERT, FieldEnum.OPERATION_NAME,
            "Name of Restaurant or Institution");

    HelpVO marketSectorDessert = initHelpVO(
            MineFieldsFactory.MINE_TYPE_DESSERT,
            FieldEnum.MARKET_SECTOR,
            "Casual Chain, Midscale Chains, QSR Chains, Non-Commercial, QSR Independents etc.");

    HelpVO marketSegmentDessert = initHelpVO(
            MineFieldsFactory.MINE_TYPE_DESSERT, FieldEnum.MARKET_SEGMENT,
            "QSR-Burgers, QSR-Pizza, Asian Dinnerhouse, Casual Chain Steakhouse");

    HelpVO headquarterStateDessert = initHelpVO(
            MineFieldsFactory.MINE_TYPE_DESSERT, FieldEnum.HEADQUARTERS_STATE,
            "Location of Chain HQ, by State");

    HelpVO flavorApplicationIngred = initHelpVO(
            MineFieldsFactory.MINE_TYPE_INGREDIENT,
            FieldEnum.FLAV_APPLICATION,
            "Details flavor appication such as Glaze, Marinade, Sauce, Condiment, Dipping Sauce, Dressing etc.");

    HelpVO sauceorCondimentIngred = initHelpVO(
            MineFieldsFactory.MINE_TYPE_INGREDIENT,
            FieldEnum.SAUCE_OR_CONDIMENT,
            "Combined field for any Sauce, Marinade, Glaze, Dressing, Dipping Sauce or Condiment---Ingredient MenuMine classifies specific components of each of these applications");

    HelpVO cookingSauceIngred = initHelpVO(
            MineFieldsFactory.MINE_TYPE_INGREDIENT,
            FieldEnum.COOKING_SAUCE_OR_GRAVY,
            "Application Field detailing all Cooking Sauces such as gravy, au jus---many more");

    HelpVO marinadeIngred = initHelpVO(MineFieldsFactory.MINE_TYPE_INGREDIENT,
            FieldEnum.MARINADE, "Application Field detailing all Marinades");

    HelpVO glazeIngred = initHelpVO(MineFieldsFactory.MINE_TYPE_INGREDIENT,
            FieldEnum.GLAZE, "Application Field detailing all Glazes");

    HelpVO dressingIngred = initHelpVO(MineFieldsFactory.MINE_TYPE_INGREDIENT,
            FieldEnum.DRESSINGS, "Application Field detailing all Dressings");

    HelpVO dipSauceIngred = initHelpVO(MineFieldsFactory.MINE_TYPE_INGREDIENT,
            FieldEnum.DIP_SAUCE_NAME,
            "Application Field detailing all Dipping Sauces");

    HelpVO condimentIngred = initHelpVO(MineFieldsFactory.MINE_TYPE_INGREDIENT,
            FieldEnum.CONDIMENTS, "Application Field detailing all Condiments");

    HelpVO cheeseApplicationIngred = initHelpVO(
            MineFieldsFactory.MINE_TYPE_INGREDIENT,
            FieldEnum.CHEESE_APPLICATION,
            "Application Field detailing all cheese use as a topping, sandwich ingredient, dip or other use");

    HelpVO butterApplicationIngred = initHelpVO(
            MineFieldsFactory.MINE_TYPE_INGREDIENT,
            FieldEnum.BUTTER_APPLICATION,
            "Details application including butter use as a spread, saute oil, baked good ingredient, dipping sauce, topping, butter sauce, glaze, batter ingredient or other ingredient");

    HelpVO primaryFlavorIngred = initHelpVO(
            MineFieldsFactory.MINE_TYPE_INGREDIENT,
            FieldEnum.PRIMARY_FLAVOR,
            "Details the main flavor or flavors in each menu item such as garlic, onion, jalapeno, chili---does not report on flavor of the protein type or flavor carriers such as rice or pasta or potatoes");

    HelpVO tasteTextureAttributeIngred = initHelpVO(
            MineFieldsFactory.MINE_TYPE_INGREDIENT,
            FieldEnum.TASTE_FLAVOR_WORDS,
            "Details general taste and flavor terms on the menu including fresh, crunchy, spicy---many more");

    HelpVO seasoningorBreadingIngred = initHelpVO(
            MineFieldsFactory.MINE_TYPE_INGREDIENT,
            FieldEnum.SEASONING_BREADING,
            "Garlic, Basil, Chipotle, Oregano and others as specified on the menu");

    HelpVO batterBreadingCoatingIngred = initHelpVO(
            MineFieldsFactory.MINE_TYPE_INGREDIENT,
            FieldEnum.BATTER_BREADING_COATING,
            "Tempura Batter, Coconut Breading and others as specified on the menu");

    HelpVO toppingFillingIngredIngred = initHelpVO(
            MineFieldsFactory.MINE_TYPE_INGREDIENT,
            FieldEnum.TOPPING_FILLED_INGRED,
            "Sauces used as fillings for proteins or veggies or dough enrobed items");

    HelpVO stuffFillingIngred = initHelpVO(
            MineFieldsFactory.MINE_TYPE_INGREDIENT,
            FieldEnum.STUFF_NAME,
            "Meats or breads or carbos or sauces used as fillings for proteins or veggies or dough enrobed items");

    HelpVO cheeseRollUpIngred = initHelpVO(
            MineFieldsFactory.MINE_TYPE_INGREDIENT, FieldEnum.CHEESE_ROLL_UP,
            "Combines Cheese types into broad groups such as Cheddar, Parmesan etc");

    HelpVO cheeseIngred = initHelpVO(MineFieldsFactory.MINE_TYPE_INGREDIENT,
            FieldEnum.CHEESE,
            "Details flavor variations and naming variations of cheeses");

    HelpVO basicProteinIngred = initHelpVO(
            MineFieldsFactory.MINE_TYPE_INGREDIENT, FieldEnum.BASIC_PROTEIN,
            "Chicken, Turkey, Pork, Beef, Fish, Shrimp, Seafood, Game Meats/Birds");

    HelpVO proteinTypeCutIngred = initHelpVO(
            MineFieldsFactory.MINE_TYPE_INGREDIENT,
            FieldEnum.PROTEIN_TYPE_CUT,
            "Chicken Wings, Chicken Breasts, Chicken Tenders and more than 300 other specific protein types and cuts");

    HelpVO proteinToppingIngred = initHelpVO(
            MineFieldsFactory.MINE_TYPE_INGREDIENT, FieldEnum.PROTEIN_TOP_NAME,
            "Proteins generally used as a topping on pizza or a salad");

    HelpVO proteinAccompanimentIngred = initHelpVO(
            MineFieldsFactory.MINE_TYPE_INGREDIENT,
            FieldEnum.PROTEIN_ACCOMP_NAME,
            "Proteins served as a side dish including sausages or anti pasto meats");

    HelpVO generalCookMethodIngred = initHelpVO(
            MineFieldsFactory.MINE_TYPE_INGREDIENT,
            FieldEnum.GEN_COOKING_METHOD, "Grilled, Fried, Boiled, Steamed");

    HelpVO cookingMethodIngred = initHelpVO(
            MineFieldsFactory.MINE_TYPE_INGREDIENT,
            FieldEnum.COOKING_METHOD,
            "More specific than General Cooking Method---insludes Char Grilled, Char Broiled, Deep Fried, Sauteed");

    HelpVO veggieFruitIngred = initHelpVO(
            MineFieldsFactory.MINE_TYPE_INGREDIENT, FieldEnum.VEGGIE_FRUIT_TYPE,
            "Lettuce, Broccoli, Turnips, Tomatoes, Apples, Peaches, Pineapples");

    HelpVO greenVeggieIngred = initHelpVO(
            MineFieldsFactory.MINE_TYPE_INGREDIENT,
            FieldEnum.GREEN_VEG_NAME,
            "Includes any green veggie such as spinach, iceburg lettuce, romaine, broccoli etc.");

    HelpVO veggieToppingIngred = initHelpVO(
            MineFieldsFactory.MINE_TYPE_INGREDIENT, FieldEnum.VEG_TOP_NAME,
            "Toppings on pizza or sandwiches");

    HelpVO veggieAccompanimentIngred = initHelpVO(
            MineFieldsFactory.MINE_TYPE_INGREDIENT,
            FieldEnum.VEG_ACCOMP_NAME,
            "Veggies served along with the center of the plate entree as opposed to stand alone (a la carte) side dishes");

    HelpVO fruitTypeIngred = initHelpVO(MineFieldsFactory.MINE_TYPE_INGREDIENT,
            FieldEnum.FRUIT_TYPE,
            "Includes Apples, Pineapples, Apricots, Peaches---many more");

    HelpVO carboTypeIngred = initHelpVO(
            MineFieldsFactory.MINE_TYPE_INGREDIENT,
            FieldEnum.CARBO_TYPE,
            "Mashed Potatoes, Boiled Potatoes, Hash Browns, Basmati Rice, Arborio Rice, Black Beans, Navy Beans etc.");

    HelpVO carboToppingIngred = initHelpVO(
            MineFieldsFactory.MINE_TYPE_INGREDIENT, FieldEnum.CARBO_TOP_NAME,
            "Toppings or ingredients");

    HelpVO carboAccompanimentIngred = initHelpVO(
            MineFieldsFactory.MINE_TYPE_INGREDIENT,
            FieldEnum.CARBO_ACCOMP_NAME,
            "Carbos served along with the center of the plate entree as opposed to stand alone (a la carte) side dishes");

    HelpVO breadWrapChipIngred = initHelpVO(
            MineFieldsFactory.MINE_TYPE_INGREDIENT,
            FieldEnum.BREAD_WRAPS_CHIPS,
            "Wheat Bread, Enchilada, Croutons, Tortilla---more than 100 others");

    HelpVO soupFlavorIngred = initHelpVO(
            MineFieldsFactory.MINE_TYPE_INGREDIENT,
            FieldEnum.FLAVOR_SOUP,
            "Details Soup Flavor whether soup is a stand alone side or an accompaniment to a meal");

    HelpVO menuPartIngred = initHelpVO(
            MineFieldsFactory.MINE_TYPE_INGREDIENT,
            FieldEnum.MENU_PART,
            "Appetizers, Salads, Soup, Sandwiches, Burgers/Dogs, Center of the Plate Entrees, Prepared Entrees, Pizza and Side Dishes (a la cart)");

    HelpVO cuisineIngred = initHelpVO(MineFieldsFactory.MINE_TYPE_INGREDIENT,
            FieldEnum.CUISINE,
            "Specific Cuisine i.e. Chinese, Japanese, Italian--over thirty various cuisnes");

    HelpVO cuisineFamilyIngred = initHelpVO(
            MineFieldsFactory.MINE_TYPE_INGREDIENT,
            FieldEnum.CUISINE_FAMILY,
            "More general than Cuisine, Cuisine Family details Asian (Japanese, Thai, Chinese etc.) Mediterranean (Greek, Italian, Lebanese etc.)");

    HelpVO itemTypeIngred = initHelpVO(
            MineFieldsFactory.MINE_TYPE_INGREDIENT,
            FieldEnum.ITEM_TYPE,
            "All menu items are grouped into general types according to similarities such that Big Mac and Whopper are both classified as Signature Burgers");

    HelpVO menuItemNameIngred = initHelpVO(
            MineFieldsFactory.MINE_TYPE_INGREDIENT, FieldEnum.MENU_ITEM_NAME,
            "Name of the Item - Fresh, Tasty Chef Salad, D'Angelo's Shrimp Pizza, etc.");

    HelpVO descriptionIngred = initHelpVO(
            MineFieldsFactory.MINE_TYPE_INGREDIENT,
            FieldEnum.DESCRIPTION,
            "Exact wording on the menu describing the ingredients, flavors and other incidentals of the menu item");

    HelpVO menuItemClassIngred = initHelpVO(
            MineFieldsFactory.MINE_TYPE_INGREDIENT,
            FieldEnum.MENU_ITEM_CLASS,
            "Further classification of Menu Part including Appetizers-Hot and Appetizers-Cold");

    HelpVO menuStatusIngred = initHelpVO(
            MineFieldsFactory.MINE_TYPE_INGREDIENT,
            FieldEnum.MENU_STATUS,
            "When Item was deleted/added, how long its been on the menu, If item has been returned, etc.");

    HelpVO operationNameIngred = initHelpVO(
            MineFieldsFactory.MINE_TYPE_INGREDIENT, FieldEnum.OPERATION_NAME,
            "Name of Restaurant or Institution");

    HelpVO marketSectorIngred = initHelpVO(
            MineFieldsFactory.MINE_TYPE_INGREDIENT,
            FieldEnum.MARKET_SECTOR,
            "Casual Chain, Midscale Chains, QSR Chains, Non-Commercial, QSR Independents etc.");

    HelpVO marketSegmentIngred = initHelpVO(
            MineFieldsFactory.MINE_TYPE_INGREDIENT, FieldEnum.MARKET_SEGMENT,
            "QSR-Burgers, QSR-Pizza, Asian Dinnerhouse, Casual Chain Steakhouse");

    HelpVO headquartersStateIngred = initHelpVO(
            MineFieldsFactory.MINE_TYPE_INGREDIENT,
            FieldEnum.HEADQUARTERS_STATE, "Location of Chain HQ, by State");

    HelpVO priceIngred = initHelpVO(
            MineFieldsFactory.MINE_TYPE_INGREDIENT,
            FieldEnum.PRICE_1996,
            "Menu Price is given if the item is on the menu in a given year.  If price is listed as $0.00, then the item is or was not on the menu in a given year.");

    public HelpDelegate() {
        super();
    }

    private HelpVO initHelpVO(String mineTypeMenu, FieldEnum name,
            String helpString) {

        HelpVO helpVO = new HelpVO(helpString);

        helpMap.put(mineTypeMenu + name.getName(), helpVO);

        return helpVO;
    }

    public String getMineFieldHelp(MineField field) {

        HelpVO vo = (HelpVO) helpMap.get(field.getMineFields().getMineType()
                + field.getFieldEnum().getName());
        if (vo != null) {
            return vo.getHelp();
        } else {
            return "";
        }

    }

}