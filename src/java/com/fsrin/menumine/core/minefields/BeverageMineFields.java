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
public class BeverageMineFields extends MineFields {
    //private MineType mineType = MineType.MENUMINE;;

    public BeverageMineFields() {

//        MineGroup position = new MineGroup("Position");
//        position.setImage("img/menumine-position.gif");
//        position.setBgcolor("#3399FF");
//        position.setCssClass("headerBGProduct");
//
//        position.getMineFields().add(
//                new MineField(FieldEnum.DAY_PART_CATEGORY, this,
//                        MineField.FIELD_PRIORITY_LOW));
//        position.getMineFields().add(
//                new MineField(FieldEnum.BEVERAGE_MENU_PART, this,
//                        MineField.FIELD_PRIORITY_LOW));
//
//        position.getMineFields().add(
//                new MineField(FieldEnum.CUISINE, this,
//                        MineField.FIELD_PRIORITY_LOW));
//
//        position.getMineFields().add(
//                new MineField(FieldEnum.CUISINE_FAMILY, this,
//                        MineField.FIELD_PRIORITY_LOW));
//        position.getMineFields().add(
//                new MineField(FieldEnum.ITEM_TYPE, this,
//                        MineField.FIELD_PRIORITY_LOW));
//        position.getMineFields().add(
//                new MineField(FieldEnum.MENU_ITEM_NAME, this,
//                        MineField.FIELD_PRIORITY_LOW));
//        position.getMineFields().add(
//                new MineField(FieldEnum.DESCRIPTION, this,
//                        MineField.FIELD_PRIORITY_LOW));
//        position.getMineFields().add(
//                new MineField(FieldEnum.MENU_ITEM_CLASS, this,
//                        MineField.FIELD_PRIORITY_LOW));
//        position.getMineFields().add(
//                new MineField(FieldEnum.MENU_STATUS, this,
//                        MineField.FIELD_PRIORITY_LOW));

        getMineGroups().add(this.getPositionGroup(FieldEnum.BEVERAGE_MENU_PART));

        MineGroup flavors = new MineGroup("Flavor");
        flavors.setImage("img/menumine-flavor.gif");
        flavors.setBgcolor("#6699FF");
        flavors.setCssClass("headerBGFlavor");

        flavors.getMineFields().add(
                new MineField(FieldEnum.PRIMARY_FLAVOR, this,
                        MineField.FIELD_PRIORITY_LOW));

        flavors.getMineFields().add(
                new MineField(FieldEnum.TASTE_FLAVOR_WORDS, this,
                        MineField.FIELD_PRIORITY_LOW));
        flavors.getMineFields().add(
                new MineField(FieldEnum.SYRUP_TOPPING, this,
                        MineField.FIELD_PRIORITY_LOW));

        flavors.getMineFields().add(
                new MineField(FieldEnum.FRUIT_OR_FRUIT_FILLING_INGRED, this,
                        MineField.FIELD_PRIORITY_LOW));

        flavors.getMineFields().add(
                new MineField(FieldEnum.WHIPPED_TOPPING_INGRED, this,
                        MineField.FIELD_PRIORITY_LOW));

        this.getMineGroups().add(flavors);

        MineGroup brand = new MineGroup("Brand");
        brand.setImage("img/brand.gif");
        brand.setBgcolor("#6699FF");
        brand.setCssClass("headerBGFlavor");

        brand.getMineFields().add(
                new MineField(FieldEnum.BEV_SIZE, this,
                        MineField.FIELD_PRIORITY_HIGH));

        brand.getMineFields().add(
                new MineField(FieldEnum.BRAND, this,
                        MineField.FIELD_PRIORITY_LOW));
        brand.getMineFields().add(
                new MineField(FieldEnum.LOGO_IMAGE_STYLE, this,
                        MineField.FIELD_PRIORITY_LOW));

        this.getMineGroups().add(brand);



        this.getMineGroups().add(this.getPlacesGroup());

        this.getMineGroups().add(this.getPricesGroup());
    }

    public void applyHiddenParams(
            MasterFoodFilterParameters masterFoodFilterParameters) {

        super.applyHiddenParams(masterFoodFilterParameters);

        if (!masterFoodFilterParameters.getDayPartCategory().getAndValues()
                .contains("Beverage")) {
            masterFoodFilterParameters.getDayPartCategory().getAndValues().add(
                    "Beverage");
        }

    }

    public boolean isMemberOfMine(MasterFood masterFood) {

        if (masterFood == null) {
            return false;
        } else if (masterFood.getDayPartCategory().indexOf("Beverage") > -1) {
            return true;
        }

        return false;
    }

    public Collection getPrimaryFields() {
        Collection ret = new ArrayList();
        ret.add(new MineField(FieldEnum.PRIMARY_FLAVOR, this,
                MineField.FIELD_PRIORITY_LOW));

        return ret;

    }

    public String getMineType() {

        return MineFieldsFactory.MINE_TYPE_BEVERAGE;
    }

}