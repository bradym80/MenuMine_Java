/*
 * Created on May 31, 2005
 *
 * 
 */
package com.fsrin.menumine.core.minefields;

import java.util.ArrayList;
import java.util.Collection;

import com.fsrin.menumine.core.menumine.FieldEnum;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;
import com.fsrin.menumine.core.menumine.masterfood.MasterFood;

/**
 * This build the fields to use with ingredient mine
 * 
 * @author Nick 2005-6-7
 * 
 * 
 */
public class IngredientMineFields extends MineFields {
    // private MineType mineType = MineType.MENUMINE;;

    public IngredientMineFields() {

        MineGroup flavorEnhancerWet = new MineGroup("Flavor Enhancer - Wet");
        flavorEnhancerWet.setImage("img/enhancer-wet.gif");
        flavorEnhancerWet.setBgcolor("#3399FF");
        flavorEnhancerWet.setCssClass("headerBGProduct");

        flavorEnhancerWet.getMineFields().add(
                new MineField(FieldEnum.FLAV_APPLICATION, this,
                        MineField.FIELD_PRIORITY_LOW));
        flavorEnhancerWet.getMineFields().add(
                new MineField(FieldEnum.SAUCE_OR_CONDIMENT, this,
                        MineField.FIELD_PRIORITY_MEDIUM));

        flavorEnhancerWet.getMineFields().add(
                new MineField(FieldEnum.COOKING_SAUCE_OR_GRAVY, this,
                        MineField.FIELD_PRIORITY_LOW));
        
        flavorEnhancerWet.getMineFields().add(
                new MineField(FieldEnum.COOK_SAUCE_TYPE, this,
                        MineField.FIELD_PRIORITY_LOW));
        
        flavorEnhancerWet.getMineFields().add(
                new MineField(FieldEnum.MARINADE, this,
                        MineField.FIELD_PRIORITY_MEDIUM));
        flavorEnhancerWet.getMineFields().add(
                new MineField(FieldEnum.GLAZE, this,
                        MineField.FIELD_PRIORITY_MEDIUM));
        flavorEnhancerWet.getMineFields().add(
                new MineField(FieldEnum.DRESSINGS, this,
                        MineField.FIELD_PRIORITY_LOW));
        flavorEnhancerWet.getMineFields().add(
                new MineField(FieldEnum.DRESSING_TYPE, this,
                        MineField.FIELD_PRIORITY_LOW));
        flavorEnhancerWet.getMineFields().add(
                new MineField(FieldEnum.DIP_SAUCE_NAME, this,
                        MineField.FIELD_PRIORITY_LOW));
        flavorEnhancerWet.getMineFields().add(
                new MineField(FieldEnum.DRESSING_FLAVOR, this,
                        MineField.FIELD_PRIORITY_LOW));
        flavorEnhancerWet.getMineFields().add(
                new MineField(FieldEnum.CONDIMENTS, this,
                        MineField.FIELD_PRIORITY_LOW));
        flavorEnhancerWet.getMineFields().add(
                new MineField(FieldEnum.DAIRY_BUTTER_CREAM, this,
                        MineField.FIELD_PRIORITY_LOW));
        /*
         * 2006-08-16 reid@fivesticks.com
         * removed per Joe.
         */
//        flavorEnhancerWet.getMineFields().add(
//                new MineField(FieldEnum.CHEESE_APPLICATION, this,
//                        MineField.FIELD_PRIORITY_LOW));
        
        flavorEnhancerWet.getMineFields().add(
                new MineField(FieldEnum.BUTTER_APPLICATION, this,
                        MineField.FIELD_PRIORITY_LOW));
        flavorEnhancerWet.getMineFields().add(
                new MineField(FieldEnum.PRIMARY_FLAVOR, this,
                        MineField.FIELD_PRIORITY_LOW));
        flavorEnhancerWet.getMineFields().add(
                new MineField(FieldEnum.TASTE_FLAVOR_WORDS, this,
                        MineField.FIELD_PRIORITY_LOW));
        
        // MK adding field based on ticket #18
        flavorEnhancerWet.getMineFields().add(
                new MineField(FieldEnum.TEXTURE_ATTRIB, this,
                        MineField.FIELD_PRIORITY_LOW));
        
        // MK adding field based on ticket #18
        // Does not work yet.
        flavorEnhancerWet.getMineFields().add(
                new MineField(FieldEnum.QUALITY_STYLE, this,
                        MineField.FIELD_PRIORITY_LOW));
        
        getMineGroups().add(flavorEnhancerWet);

        MineGroup flavorEnhancerDry = new MineGroup("Flavor Enhancer - Dry");
        flavorEnhancerDry.setImage("img/enhancer-dry.gif");
        flavorEnhancerDry.setBgcolor("#66CCFF");
        flavorEnhancerDry.setCssClass("headerBGIngred");

        flavorEnhancerDry.getMineFields().add(
                new MineField(FieldEnum.SEASONING_NAME, this,
                        MineField.FIELD_PRIORITY_MEDIUM));
        flavorEnhancerDry.getMineFields().add(
                new MineField(FieldEnum.BATTER_BREADING_COATING, this,
                        MineField.FIELD_PRIORITY_MEDIUM));
        //flavorEnhancerDry.getMineFields().add(
        //        new MineField(FieldEnum.TOPPING_FILLED_INGRED, this,
        //                MineField.FIELD_PRIORITY_LOW));
        flavorEnhancerDry.getMineFields().add(
                new MineField(FieldEnum.STUFF_NAME, this,
                        MineField.FIELD_PRIORITY_LOW));
        flavorEnhancerDry.getMineFields().add(
                new MineField(FieldEnum.CHEESE_ROLL_UP, this,
                        MineField.FIELD_PRIORITY_LOW));
        flavorEnhancerDry.getMineFields().add(
                new MineField(FieldEnum.CHEESE, this,
                        MineField.FIELD_PRIORITY_LOW));
        flavorEnhancerDry.getMineFields().add(
                new MineField(FieldEnum.CHEESE_FORM, this,
                        MineField.FIELD_PRIORITY_LOW));
        flavorEnhancerDry.getMineFields().add(
                new MineField(FieldEnum.CHEESE_SAUCE_FILLING_TYPE, this,
                        MineField.FIELD_PRIORITY_LOW));

        getMineGroups().add(flavorEnhancerDry);

        
        MineGroup preparation = new MineGroup("Preparation");
        preparation.setImage("img/ingredient-component.gif");
        preparation.setBgcolor("#6699FF");
        preparation.setCssClass("headerBGFlavor");
        
        preparation.getMineFields().add(
                new MineField(FieldEnum.GEN_COOKING_METHOD, this,
                        MineField.FIELD_PRIORITY_LOW));
        preparation.getMineFields().add(
                new MineField(FieldEnum.COOKING_METHOD, this,
                        MineField.FIELD_PRIORITY_LOW));
        preparation.getMineFields().add(
                new MineField(FieldEnum.GRILL_ROAST_SMOKE, this,
                        MineField.FIELD_PRIORITY_LOW));
        preparation.getMineFields().add(
                new MineField(FieldEnum.VEG_COOK_METHOD, this,
                        MineField.FIELD_PRIORITY_LOW));
        preparation.getMineFields().add(
                new MineField(FieldEnum.BBQ_COOK, this,
                        MineField.FIELD_PRIORITY_LOW));

        getMineGroups().add(preparation);
        
        MineGroup types = new MineGroup("Types/Uses");
        types.setImage("img/ingredient-component.gif");
        types.setBgcolor("#6699FF");
        types.setCssClass("headerBGFlavor");
        
        types.setForceExtraColumn(true);
        
        types.getMineFields().add(
                new MineField(FieldEnum.PREP_ENTREE_TYPE, this,
                        MineField.FIELD_PRIORITY_LOW));
        types.getMineFields().add(
                new MineField(FieldEnum.APPET_CLASS_TYP, this,
                        MineField.FIELD_PRIORITY_LOW));
        // MK adding field based on ticket #18
        types.getMineFields().add(
                new MineField(FieldEnum.SIDE_OR_ACCOMP, this,
                        MineField.FIELD_PRIORITY_LOW));
        types.getMineFields().add(
                new MineField(FieldEnum.ROAST_VEG_ITEM_TYPE, this,
                        MineField.FIELD_PRIORITY_LOW));
        types.getMineFields().add(
                new MineField(FieldEnum.PIZZA_STYLE, this,
                        MineField.FIELD_PRIORITY_LOW));
        types.getMineFields().add(
                new MineField(FieldEnum.PEPPER_TYPE, this,
                        MineField.FIELD_PRIORITY_LOW));
        types.getMineFields().add(
                new MineField(FieldEnum.MEX_INGRED_USE, this,
                        MineField.FIELD_PRIORITY_LOW));
        types.getMineFields().add(
                new MineField(FieldEnum.EGG_TYPE, this,
                        MineField.FIELD_PRIORITY_LOW));    
        
        types.getMineFields().add(
                new MineField(FieldEnum.EGG_ITEM_USE, this,
                        MineField.FIELD_PRIORITY_LOW));  
        
        getMineGroups().add(types);
        

        MineGroup carbos = new MineGroup("Carbs");
        carbos.setImage("img/ingredient-component.gif");
        carbos.setBgcolor("#6699FF");
        carbos.setCssClass("headerBGFlavor");   

        carbos.getMineFields().add(
                new MineField(FieldEnum.CARBO_ALL, this,
                        MineField.FIELD_PRIORITY_LOW));
        carbos.getMineFields().add(
                new MineField(FieldEnum.CARBO_TYPE, this,
                        MineField.FIELD_PRIORITY_LOW));
        carbos.getMineFields().add(
                new MineField(FieldEnum.CARBO_ACCOMP_NAME, this,
                        MineField.FIELD_PRIORITY_LOW));
        //carbos.getMineFields().add(
        //        new MineField(FieldEnum.CARBO_TOP_NAME, this,
        //               MineField.FIELD_PRIORITY_LOW));
        carbos.getMineFields().add(
                new MineField(FieldEnum.RICE_TYPE_USE, this,
                        MineField.FIELD_PRIORITY_LOW));    
        carbos.getMineFields().add(
                new MineField(FieldEnum.BREAD_WRAPS_CHIPS, this,
                        MineField.FIELD_PRIORITY_LOW));
        carbos.getMineFields().add(
                new MineField(FieldEnum.ETHNIC_BREAD_TYPE, this,
                        MineField.FIELD_PRIORITY_LOW));
        carbos.getMineFields().add(
                new MineField(FieldEnum.POTATO_TYPE_USE, this,
                        MineField.FIELD_PRIORITY_LOW));
        
        getMineGroups().add(carbos);
    
        MineGroup meatProtein = new MineGroup("Meat - Protein");
        meatProtein.setImage("img/ingredient-component.gif");
        meatProtein.setBgcolor("#6699FF");
        meatProtein.setCssClass("headerBGFlavor");        
        
        meatProtein.getMineFields().add(
                new MineField(FieldEnum.BASIC_PROTEIN, this,
                        MineField.FIELD_PRIORITY_LOW));
        meatProtein.getMineFields().add(
                new MineField(FieldEnum.PROTEIN_TYPE_CUT, this,
                        MineField.FIELD_PRIORITY_LOW));
        //meatProtein.getMineFields().add(
        //        new MineField(FieldEnum.PROTEIN_TOP_NAME, this,
        //                MineField.FIELD_PRIORITY_LOW));
        //meatProtein.getMineFields().add(
        //        new MineField(FieldEnum.PROTEIN_ACCOMP_NAME, this,
        //                MineField.FIELD_PRIORITY_LOW));
        meatProtein.getMineFields().add(
                new MineField(FieldEnum.PROTEIN_FLAVOR_APP, this,
                        MineField.FIELD_PRIORITY_LOW));
        /*
         * 2009-06-01 MJB added the 9 protein fields below.
         */
        meatProtein.getMineFields().add(
                new MineField(FieldEnum.CHICKEN_TYPE, this,
                        MineField.FIELD_PRIORITY_LOW));
        meatProtein.getMineFields().add(
                new MineField(FieldEnum.BEEF_TYPE, this,
                        MineField.FIELD_PRIORITY_LOW));
        meatProtein.getMineFields().add(
                new MineField(FieldEnum.PORK_TYPE, this,
                        MineField.FIELD_PRIORITY_LOW));
        meatProtein.getMineFields().add(
                new MineField(FieldEnum.FISH_TYPE, this,
                        MineField.FIELD_PRIORITY_LOW));
        meatProtein.getMineFields().add(
                new MineField(FieldEnum.SEAFOOD_TYPE, this,
                        MineField.FIELD_PRIORITY_LOW));
        meatProtein.getMineFields().add(
                new MineField(FieldEnum.LAMB_TYPE, this,
                        MineField.FIELD_PRIORITY_LOW));
        meatProtein.getMineFields().add(
                new MineField(FieldEnum.TURKEY_TYPE, this,
                        MineField.FIELD_PRIORITY_LOW));
        meatProtein.getMineFields().add(
                new MineField(FieldEnum.OTHER_PROTEIN_TYPE, this,
                        MineField.FIELD_PRIORITY_LOW));
        meatProtein.getMineFields().add(
                new MineField(FieldEnum.SHRIMP_TYPE, this,
                        MineField.FIELD_PRIORITY_LOW));

        /*
         * 2006-01-17 RSC
         */
        meatProtein.getMineFields().add(
                new MineField(FieldEnum.PROTEIN_FISH_SHRIMP_SEAFOOD, this,
                        MineField.FIELD_PRIORITY_LOW));   
        
        getMineGroups().add(meatProtein);

        MineGroup veggies = new MineGroup("Veggies");
        veggies.setImage("img/ingredient-component.gif");
        veggies.setBgcolor("#6699FF");
        veggies.setCssClass("headerBGFlavor"); 

        veggies.setForceExtraColumn(true);
        
        //veggies.getMineFields().add(
        //        new MineField(FieldEnum.ALL_VEG_CARB_FRUIT, this,
        //                MineField.FIELD_PRIORITY_LOW));
        veggies.getMineFields().add(
                new MineField(FieldEnum.VEGGIE_ALL, this,
                        MineField.FIELD_PRIORITY_LOW));
        veggies.getMineFields().add(
                new MineField(FieldEnum.VEGGIE_FRUIT_TYPE, this,
                        MineField.FIELD_PRIORITY_LOW));
        veggies.getMineFields().add(
                new MineField(FieldEnum.VEG_ACCOMP_NAME, this,
                        MineField.FIELD_PRIORITY_LOW));
        veggies.getMineFields().add(
                new MineField(FieldEnum.VEG_TOP_NAME, this,
                        MineField.FIELD_PRIORITY_LOW));
        veggies.getMineFields().add(
                new MineField(FieldEnum.GREEN_VEG_NAME, this,
                        MineField.FIELD_PRIORITY_LOW));        
        veggies.getMineFields().add(
                new MineField(FieldEnum.TOMATO_TYPE, this,
                        MineField.FIELD_PRIORITY_LOW));
        veggies.getMineFields().add(
                new MineField(FieldEnum.ONION_SCALLION_LEEK, this,
                        MineField.FIELD_PRIORITY_LOW));
        veggies.getMineFields().add(
                new MineField(FieldEnum.MUSHROOM_TYPE, this,
                        MineField.FIELD_PRIORITY_LOW));
        veggies.getMineFields().add(
                new MineField(FieldEnum.SALSA_TYPE, this,
                        MineField.FIELD_PRIORITY_LOW));        
        veggies.getMineFields().add(
                new MineField(FieldEnum.FRUIT_TYPE, this,
                        MineField.FIELD_PRIORITY_LOW));
        getMineGroups().add(veggies);

        MineGroup soup = new MineGroup("Soup");
        soup.setImage("img/ingredient-component.gif");
        soup.setBgcolor("#6699FF");
        soup.setCssClass("headerBGFlavor");
        
        soup.setForceExtraColumn(true);

        soup.getMineFields().add(
                new MineField(FieldEnum.FLAVOR_SOUP, this,
                        MineField.FIELD_PRIORITY_MEDIUM));
        
        soup.getMineFields().add(
                new MineField(FieldEnum.SOUP_WITH, this,
                        MineField.FIELD_PRIORITY_MEDIUM));
        
        soup.getMineFields().add(
                new MineField(FieldEnum.SOUP_BASE_BROTH, this,
                        MineField.FIELD_PRIORITY_MEDIUM));
        
        getMineGroups().add(soup);
        
        MineGroup cuisine = new MineGroup("Cuisine of Item");
        cuisine.setImage("img/ingredient-component.gif");
        cuisine.setBgcolor("#6699FF");
        cuisine.setCssClass("headerBGFlavor");        
       
        cuisine.getMineFields().add(
                new MineField(FieldEnum.CUISINE, this,
                        MineField.FIELD_PRIORITY_LOW));

        cuisine.getMineFields().add(
                new MineField(FieldEnum.CUISINE_FAMILY, this,
                        MineField.FIELD_PRIORITY_LOW));
        
        cuisine.getMineFields().add(
                new MineField(FieldEnum.CUISINE_VERY_SPECIFIC, this,
                        MineField.FIELD_PRIORITY_LOW));
        
        getMineGroups().add(cuisine);        
        
        MineGroup ingredientComponent = new MineGroup("Ingredient - Component");
        ingredientComponent.setImage("img/ingredient-component.gif");
        ingredientComponent.setBgcolor("#6699FF");
        ingredientComponent.setCssClass("headerBGFlavor");

        //2006-11-07 probably don't need
//        ingredientComponent.setForceNewColumn(true);
        
        ingredientComponent.getMineFields().add(
                new MineField(FieldEnum.OIL_TYPE_USE, this,
                        MineField.FIELD_PRIORITY_MEDIUM));
        //ingredientComponent.getMineFields().add(
        //        new MineField(FieldEnum.OTHER_TOPPINGS, this,
        //                MineField.FIELD_PRIORITY_LOW));
        ingredientComponent.getMineFields().add(
                new MineField(FieldEnum.OTHER_INGREDIENT, this,
                        MineField.FIELD_PRIORITY_LOW));
        //ingredientComponent.getMineFields().add(
        //        new MineField(FieldEnum.OTHER_TOP_INGREDIENT, this,
        //                MineField.FIELD_PRIORITY_LOW));
        //ingredientComponent.getMineFields().add(
        //        new MineField(FieldEnum.OTHER_ACCOMPANIMENTS, this,
        //                MineField.FIELD_PRIORITY_LOW));
        
        getMineGroups().add(ingredientComponent);



        
        MineGroup position = new MineGroup("Position");
        position.setImage("img/menumine-position.gif");
        position.setBgcolor("#3399FF");
        position.setCssClass("headerBGProduct");
        position.getMineFields().add(
                new MineField(FieldEnum.MENU_PART, this, MineField.FIELD_PRIORITY_LOW));
        position.getMineFields().add(
                new MineField(FieldEnum.MENU_ITEM_CLASS, this,
                        MineField.FIELD_PRIORITY_LOW));
        position.getMineFields().add(
                new MineField(FieldEnum.ITEM_TYPE, this,
                        MineField.FIELD_PRIORITY_LOW));
        position.getMineFields().add(
                new MineField(FieldEnum.MENU_ITEM_NAME, this,
                        MineField.FIELD_PRIORITY_LOW));
        position.getMineFields().add(
                new MineField(FieldEnum.DESCRIPTION, this,
                        MineField.FIELD_PRIORITY_LOW));
        position.getMineFields().add(
                new MineField(FieldEnum.MENU_STATUS, this,
                        MineField.FIELD_PRIORITY_LOW));        
        
        position.getMineFields().add(
                new MineField(FieldEnum.KEYWORDS, this,
                        MineField.FIELD_PRIORITY_LOW));  

        getMineGroups().add(position);


        MineGroup other = new MineGroup("Other");

        other.getMineFields().add(
                new MineField(FieldEnum.HEALTHY_SYMBOL, this,
                        MineField.FIELD_PRIORITY_LOW));

        other.getMineFields().add(
                new MineField(FieldEnum.HEALTHY_TERM, this,
                        MineField.FIELD_PRIORITY_LOW));

        other.getMineFields().add(
                new MineField(FieldEnum.HEALTHY_FLAG, this,
                        MineField.FIELD_PRIORITY_LOW));

        this.getMineGroups().add(other);

        MineGroup depreciated = new MineGroup("Depreciated Fields");

        depreciated.getMineFields().add(
                new MineField(FieldEnum.TOPPING_FILLED_INGRED, this,
                MineField.FIELD_PRIORITY_LOW));
        depreciated.getMineFields().add(
                new MineField(FieldEnum.CARBO_TOP_NAME, this,
                MineField.FIELD_PRIORITY_LOW));
        depreciated.getMineFields().add(
                new MineField(FieldEnum.PROTEIN_TOP_NAME, this,
                MineField.FIELD_PRIORITY_LOW));
        depreciated.getMineFields().add(
                new MineField(FieldEnum.PROTEIN_ACCOMP_NAME, this,
                MineField.FIELD_PRIORITY_LOW));
        depreciated.getMineFields().add(
                new MineField(FieldEnum.ALL_VEG_CARB_FRUIT, this,
                MineField.FIELD_PRIORITY_LOW));
        depreciated.getMineFields().add(
                new MineField(FieldEnum.OTHER_TOPPINGS, this,
                MineField.FIELD_PRIORITY_LOW));
        depreciated.getMineFields().add(
                new MineField(FieldEnum.OTHER_TOP_INGREDIENT, this,
                MineField.FIELD_PRIORITY_LOW));
        depreciated.getMineFields().add(
                new MineField(FieldEnum.OTHER_ACCOMPANIMENTS, this,
                MineField.FIELD_PRIORITY_LOW));

        depreciated.setForceNewColumn(true);


        this.getMineGroups().add(depreciated);



        this.getMineGroups().add(this.getPricesGroup());

        this.getMineGroups().add(this.getPlacesGroup());
    }

    public void applyHiddenParams(
            MasterFoodFilterParameters masterFoodFilterParameters) {

        super.applyHiddenParams(masterFoodFilterParameters);

        if (!masterFoodFilterParameters.getDayPartCategory().getNotValues()
                .contains("Dessert")) {
            masterFoodFilterParameters.getDayPartCategory().getNotValues().add(
                    "Dessert");
        }
        if (!masterFoodFilterParameters.getDayPartCategory().getNotValues()
                .contains("Beverage")) {

            masterFoodFilterParameters.getDayPartCategory().getNotValues().add(
                    "Beverage");
        }

    }

    public Collection getPrimaryFields() {
        Collection ret = new ArrayList();
        ret.add(new MineField(FieldEnum.DESSERT_MENU_PART, this,
                MineField.FIELD_PRIORITY_LOW));

        return ret;

    }

    public String getMineType() {

        return MineFieldsFactory.MINE_TYPE_INGREDIENT;

    }

    /*
     * It is a member of ingredient mine if DayPartCategory is not Dessert or
     * Beverage.
     * 
     * (non-Javadoc)
     * 
     * @see com.fsrin.menumine.core.minefields.MineFields#isMemberOfMine(com.fsrin.menumine.core.menumine.masterfood.MasterFood)
     */
    public boolean isMemberOfMine(MasterFood masterFood) {

        if (masterFood == null) {
            return false;
        } else if (masterFood.getDayPartCategory().indexOf("Dessert") < 0
                && masterFood.getDayPartCategory().indexOf("Beverage") < 0) {
            return true;
        }

        return false;
    }

}
