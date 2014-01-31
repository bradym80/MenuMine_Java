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
public class DessertMineFields extends MineFields {
    //private MineType mineType = MineType.MENUMINE;;

    public DessertMineFields() {
//        MineGroup position = new MineGroup("Position");
//        position.setImage("img/menumine-position.gif");
//        position.setBgcolor("#3399FF");
//        position.setCssClass("headerBGProduct");
//        position.getMineFields().add(
//                new MineField(FieldEnum.DESSERT_MENU_PART, this,
//                        MineField.FIELD_PRIORITY_LOW));
//        position.getMineFields().add(
//                new MineField(FieldEnum.DESSERT_MENU_ITEM_CLASS, this,
//                        MineField.FIELD_PRIORITY_LOW));
//        position.getMineFields().add(
//                new MineField(FieldEnum.ITEM_TYPE, this,
//                        MineField.FIELD_PRIORITY_LOW));
//        position.getMineFields().add(
//                new MineField(FieldEnum.MENU_ITEM_NAME, this,
//                        MineField.FIELD_PRIORITY_LOW));
//        position.getMineFields().add(
//                new MineField(FieldEnum.DESSERT_MENU_STATUS, this,
//                        MineField.FIELD_PRIORITY_LOW));
//        position.getMineFields().add(
//                new MineField(FieldEnum.DESCRIPTION, this,
//                        MineField.FIELD_PRIORITY_LOW));
//        position.getMineFields().add(
//                new MineField(FieldEnum.DESSERT_CUISINE, this,
//                        MineField.FIELD_PRIORITY_LOW));

        getMineGroups().add(this.getPositionGroup(FieldEnum.DESSERT_MENU_PART));

        MineGroup foods = new MineGroup("Platform");
        foods.setImage("img/menumine-platform.gif");//Needs to be platform
        foods.setBgcolor("#66CCFF");
        foods.setCssClass("headerBGIngred");
        foods.getMineFields().add(
                new MineField(FieldEnum.CAKE_INGREDIENT, this,
                        MineField.FIELD_PRIORITY_LOW));
        foods.getMineFields().add(
                new MineField(FieldEnum.CAKE_USE, this,
                        MineField.FIELD_PRIORITY_HIGH));
        foods.getMineFields().add(
                new MineField(FieldEnum.COOKIE_INGREDIENT, this,
                        MineField.FIELD_PRIORITY_LOW));
        foods.getMineFields().add(
                new MineField(FieldEnum.COOKIE_USE, this,
                        MineField.FIELD_PRIORITY_HIGH));
        foods.getMineFields().add(
                new MineField(FieldEnum.DESSERT_DOUGH_CRUST_INGRED, this,
                        MineField.FIELD_PRIORITY_HIGH));
        foods.getMineFields().add(
                new MineField(FieldEnum.ICE_CREAM_INGREDIENT, this,
                        MineField.FIELD_PRIORITY_HIGH, "SmallFont"));

        getMineGroups().add(foods);

        MineGroup flavors = new MineGroup("Flavor");
        flavors.setImage("img/menumine-flavor.gif");
        flavors.setBgcolor("#6699FF");
        flavors.setCssClass("headerBGFlavor");
        flavors.getMineFields().add(
                new MineField(FieldEnum.SYRUP_TOPPING, this,
                        MineField.FIELD_PRIORITY_LOW));
        flavors.getMineFields().add(
                new MineField(FieldEnum.NUT_INGREDIENT, this,
                        MineField.FIELD_PRIORITY_LOW));
        flavors.getMineFields().add(
                new MineField(FieldEnum.FRUIT_OR_FRUIT_FILLING_INGRED, this,
                        MineField.FIELD_PRIORITY_LOW));
        
        // MK Deleting field based on ticket #17
        /*flavors.getMineFields().add(
                new MineField(FieldEnum.WHIPPED_TOPPING_INGRED, this,
                        MineField.FIELD_PRIORITY_LOW));*/
        
        // MK adding field based on ticket #17
        flavors.getMineFields().add(
                new MineField(FieldEnum.CREAMY_FILLING, this,
                        MineField.FIELD_PRIORITY_LOW));
        
        // MK adding field based on ticket #17
        flavors.getMineFields().add(
                new MineField(FieldEnum.CREAMY_TOP, this,
                        MineField.FIELD_PRIORITY_LOW));
        
        // MK adding field based on ticket #17
        flavors.getMineFields().add(
                new MineField(FieldEnum.TEXTURE_ATTRIB, this,
                        MineField.FIELD_PRIORITY_LOW));
        
        // MK adding field based on ticket #17
        // Does not work yet
        flavors.getMineFields().add(
                new MineField(FieldEnum.QUALITY_STYLE, this,
                        MineField.FIELD_PRIORITY_HIGH));
        
        flavors.getMineFields().add(
                new MineField(FieldEnum.CANDY_INGREDIENT, this,
                        MineField.FIELD_PRIORITY_HIGH));
        flavors.getMineFields().add(
                new MineField(FieldEnum.PRIMARY_FLAVOR, this,
                        MineField.FIELD_PRIORITY_LOW));
        flavors.getMineFields().add(
                new MineField(FieldEnum.TASTE_FLAVOR_WORDS, this,
                        MineField.FIELD_PRIORITY_LOW));
        flavors.getMineFields().add(
                new MineField(FieldEnum.BRAND, this,
                        MineField.FIELD_PRIORITY_LOW));
        flavors.getMineFields().add(
                new MineField(FieldEnum.COOKIE_LOOK_ALIKE_DESSERT, this,
                        MineField.FIELD_PRIORITY_LOW));
        getMineGroups().add(flavors);

//        MineGroup places = new MineGroup("places");
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
//        getMineGroups().add(places);

        this.getMineGroups().add(this.getPlacesGroup());
        
        this.getMineGroups().add(this.getPricesGroup());

    }

    public void applyHiddenParams(
            MasterFoodFilterParameters masterFoodFilterParameters) {

        super.applyHiddenParams(masterFoodFilterParameters);

        if (!masterFoodFilterParameters.getDayPartCategory().getAndValues()
                .contains("Dessert")) {
            masterFoodFilterParameters.getDayPartCategory().getAndValues().add(
                    "Dessert");
        }

    }

    public Collection getPrimaryFields() {
        Collection ret = new ArrayList();
        ret.add(new MineField(FieldEnum.DESSERT_MENU_PART, this,
                MineField.FIELD_PRIORITY_LOW));
        ret.add(new MineField(FieldEnum.DESSERT_CUISINE, this,
                MineField.FIELD_PRIORITY_LOW));
        ret.add(new MineField(FieldEnum.CAKE_INGREDIENT, this,
                MineField.FIELD_PRIORITY_LOW));
        ret.add(new MineField(FieldEnum.SYRUP_TOPPING, this,
                MineField.FIELD_PRIORITY_LOW));
        ret.add(new MineField(FieldEnum.PRIMARY_FLAVOR, this,
                MineField.FIELD_PRIORITY_LOW));
        return ret;

    }

    public String getMineType() {

        return MineFieldsFactory.MINE_TYPE_DESSERT;
    }

    public boolean isMemberOfMine(MasterFood masterFood) {

        if (masterFood == null) {
            return false;
        } else if (masterFood.getDayPartCategory().indexOf("Dessert") > -1) {
            return true;
        }

        return false;
    }

}