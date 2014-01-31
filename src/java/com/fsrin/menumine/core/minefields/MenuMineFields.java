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
 * This build the fields to use with dessert mine
 * 
 * @author Nick 2005-6-7
 * 
 *  
 */
public class MenuMineFields extends MineFields {
    //private MineType mineType = MineType.MENUMINE;;

    public MenuMineFields() {

        this.getMineGroups().add(this.getPositionGroup(FieldEnum.MENU_PART));

        MineGroup foods = new MineGroup("Foods");
        foods.setImage("img/menumine-ingredients.gif");
        foods.setBgcolor("#66CCFF");
        foods.setCssClass("headerBGIngred");
        foods.getMineFields().add(
                new MineField(FieldEnum.BASIC_PROTEIN, this,
                        MineField.FIELD_PRIORITY_MEDIUM));
        foods.getMineFields().add(
                new MineField(FieldEnum.PROTEIN_TYPE_CUT, this,
                        MineField.FIELD_PRIORITY_LOW));
        
        foods.getMineFields().add(
                new MineField(FieldEnum.PROTEIN_FLAVOR_APP, this,
                        MineField.FIELD_PRIORITY_LOW));
        
        //2006-01-17 RSC
        foods.getMineFields().add(
                new MineField(FieldEnum.PROTEIN_FISH_SHRIMP_SEAFOOD, this,
                        MineField.FIELD_PRIORITY_LOW));
        

        foods.getMineFields().add(
                new MineField(FieldEnum.VEGGIE_FRUIT_MM, this,
                        MineField.FIELD_PRIORITY_LOW));
        foods.getMineFields().add(
                new MineField(FieldEnum.CARBO_MM, this,
                        MineField.FIELD_PRIORITY_LOW));
        foods.getMineFields().add(
                new MineField(FieldEnum.SIDE_OR_ACCOMP, this,
                        MineField.FIELD_PRIORITY_LOW));
        foods.getMineFields().add(
                new MineField(FieldEnum.EGG_ITEM_USE, this,
                        MineField.FIELD_PRIORITY_LOW));
        foods.getMineFields().add(
                new MineField(FieldEnum.EGG_TYPE, this,
                        MineField.FIELD_PRIORITY_LOW));

        foods.getMineFields().add(
                new MineField(FieldEnum.BREAD_BAKED_GOOD, this,
                        MineField.FIELD_PRIORITY_LOW));

        foods.getMineFields().add(
                new MineField(FieldEnum.BREAD_USE, this,
                        MineField.FIELD_PRIORITY_LOW));

        foods.getMineFields().add(
                new MineField(FieldEnum.HEALTHY_TERM, this,
                        MineField.FIELD_PRIORITY_LOW));
        
        
        foods.getMineFields().add(
                new MineField(FieldEnum.OIL_TYPE_USE, this,
                        MineField.FIELD_PRIORITY_LOW));

        this.getMineGroups().add(foods);

        MineGroup flavors = new MineGroup("Flavor");
        flavors.setImage("img/menumine-flavor.gif");
        flavors.setBgcolor("#6699FF");
        flavors.setCssClass("headerBGFlavor");
        flavors.getMineFields().add(
                new MineField(FieldEnum.SAUCE_OR_CONDIMENT, this,
                        MineField.FIELD_PRIORITY_LOW));
        flavors.getMineFields().add(
                new MineField(FieldEnum.FLAV_APPLICATION, this,
                        MineField.FIELD_PRIORITY_LOW));

        flavors.getMineFields().add(
                new MineField(FieldEnum.SEASONING_BREADING, this,
                        MineField.FIELD_PRIORITY_LOW));
        flavors.getMineFields().add(
                new MineField(FieldEnum.TOPPING_FILLED_INGRED, this,
                        MineField.FIELD_PRIORITY_LOW));
        flavors.getMineFields().add(
                new MineField(FieldEnum.CHEESE, this,
                        MineField.FIELD_PRIORITY_LOW));
        flavors.getMineFields().add(
                new MineField(FieldEnum.CHEESE_FORM, this,
                        MineField.FIELD_PRIORITY_LOW));
        flavors.getMineFields().add(
                new MineField(FieldEnum.CHEESE_SAUCE_FILLING_TYPE, this,
                        MineField.FIELD_PRIORITY_LOW));
        flavors.getMineFields().add(
                new MineField(FieldEnum.CHEESE_ROLL_UP, this,
                        MineField.FIELD_PRIORITY_LOW));        
        flavors.getMineFields().add(
                new MineField(FieldEnum.FLAVOR_SOUP, this,
                        MineField.FIELD_PRIORITY_LOW));

        //        flavors.getMineFields().add(
        //                new MineField(FieldEnum.GEN_COOKING_METHOD,
        // this,MineField.FIELD_PRIORITY_LOW, "SmallFont"));
        flavors.getMineFields().add(
                new MineField(FieldEnum.GEN_COOKING_METHOD, this,
                        MineField.FIELD_PRIORITY_LOW));

        flavors.getMineFields().add(
                new MineField(FieldEnum.COOKING_METHOD, this,
                        MineField.FIELD_PRIORITY_LOW));

        flavors.getMineFields().add(
                new MineField(FieldEnum.BRAND, this,
                        MineField.FIELD_PRIORITY_LOW));
        this.getMineGroups().add(flavors);
//
//        MineGroup places = new MineGroup("Places");
//        places.setImage("img/menumine-business.gif");
//        places.setBgcolor("#99CCFF");
//        places.setCssClass("headerBGProductBiz");
//        places.getMineFields().add(
//                new MineField(FieldEnum.OPERATION_NAME, this,
//                        MineField.FIELD_PRIORITY_LOW));
//        places.getMineFields().add(
//                new MineField(FieldEnum.MARKET_SECTOR, this,
//                        MineField.FIELD_PRIORITY_LOW));
//        places.getMineFields().add(
//                new MineField(FieldEnum.MARKET_SEGMENT, this,
//                        MineField.FIELD_PRIORITY_LOW));
//        places.getMineFields().add(
//                new MineField(FieldEnum.HEADQUARTERS_STATE, this,
//                        MineField.FIELD_PRIORITY_LOW));
//        places.getMineFields().add(
//                new MineField(FieldEnum.HEADQUARTERS_REGION, this,
//                        MineField.FIELD_PRIORITY_LOW));
//        places.getMineFields().add(
//                new MineField(FieldEnum.OPERATOR_TYPE, this,
//                        MineField.FIELD_PRIORITY_LOW));
//
//        this.getMineGroups().add(places);
        
        this.getMineGroups().add(this.getPlacesGroup());

        this.getMineGroups().add(this.getPricesGroup());
        
        //this.getMineGroups().add(this.getTypesAndUsesGroup());

    }

    public Collection getPrimaryFields() {
        Collection ret = new ArrayList();
        ret.add(new MineField(FieldEnum.MENU_PART, this,
                MineField.FIELD_PRIORITY_LOW));
        ret.add(new MineField(FieldEnum.CUISINE, this,
                MineField.FIELD_PRIORITY_LOW));
        ret.add(new MineField(FieldEnum.BASIC_PROTEIN, this,
                MineField.FIELD_PRIORITY_LOW));
        ret.add(new MineField(FieldEnum.GEN_COOKING_METHOD, this,
                MineField.FIELD_PRIORITY_LOW));
        ret.add(new MineField(FieldEnum.SIDE_OR_ACCOMP, this,
                MineField.FIELD_PRIORITY_LOW));
        ret.add(new MineField(FieldEnum.SAUCE_OR_CONDIMENT, this,
                MineField.FIELD_PRIORITY_LOW));
        ret.add(new MineField(FieldEnum.SEASONING_BREADING, this,
                MineField.FIELD_PRIORITY_LOW));
        
        return ret;
    }

    public String getMineType() {

        return MineFieldsFactory.MINE_TYPE_MENU;
    }

    public void applyHiddenParams(
            MasterFoodFilterParameters masterFoodFilterParameters) {

        super.applyHiddenParams(masterFoodFilterParameters);
        /*
         * 2005-7-17 we want to exclude items that are in dessert menumine.
         */
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

       

        //        masterFoodFilterParameters.getChain().getCountryLoc().getAndValues()
        //                .add("USA");

    } /*
       * It is a member of menu mine if DayPartCategory is not Dessert or
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