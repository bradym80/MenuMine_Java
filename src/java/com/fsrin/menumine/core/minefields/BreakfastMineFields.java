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
public class BreakfastMineFields extends MineFields {

    public BreakfastMineFields() {


        MineGroup position = this.getPositionGroup(FieldEnum.BREAKFAST_MENU_PART, false);
        
        position.getMineFields().add(new MineField(FieldEnum.BREAKFAST_TO_GO, this, MineField.FIELD_PRIORITY_LOW));
        
        position.getMineFields().add(
                new MineField(FieldEnum.KEYWORDS, this,
                        MineField.FIELD_PRIORITY_LOW));
        
        getMineGroups().add(position);
        

        MineGroup foods = new MineGroup("Foods");
        foods.setImage("img/menumine-ingredients.gif");
        foods.setBgcolor("#66CCFF");
        foods.setCssClass("headerBGIngred");
        foods.getMineFields().add(
                new MineField(FieldEnum.BASIC_PROTEIN, this,
                        MineField.FIELD_PRIORITY_LOW));
        foods.getMineFields().add(
                new MineField(FieldEnum.PROTEIN_TYPE_CUT, this,
                        MineField.FIELD_PRIORITY_LOW));

        foods.getMineFields().add(
                new MineField(FieldEnum.VEGGIE_FRUIT_TYPE, this,
                        MineField.FIELD_PRIORITY_LOW));
        foods.getMineFields().add(
                new MineField(FieldEnum.CARBO_TYPE, this,
                        MineField.FIELD_PRIORITY_LOW));
        foods.getMineFields().add(
                new MineField(FieldEnum.SIDE_OR_ACCOMP, this,
                        MineField.FIELD_PRIORITY_LOW));

        foods.getMineFields().add(
                new MineField(FieldEnum.HEALTHY_TERM, this,
                        MineField.FIELD_PRIORITY_LOW));

        foods.getMineFields().add(
                new MineField(FieldEnum.EGG_TYPE, this,
                        MineField.FIELD_PRIORITY_HIGH));

        foods.getMineFields().add(
                new MineField(FieldEnum.FRUIT_TYPE, this,
                        MineField.FIELD_PRIORITY_LOW));
        foods.getMineFields().add(
                new MineField(FieldEnum.HOT_COLD_CEREAL, this,
                        MineField.FIELD_PRIORITY_HIGH));

        this.getMineGroups().add(foods);

        MineGroup flavors = new MineGroup("Flavor");
        flavors.setImage("img/menumine-flavor.gif");
        flavors.setBgcolor("#6699FF");
        flavors.setCssClass("headerBGFlavor");

        flavors.getMineFields().add(
                new MineField(FieldEnum.SAUCE_OR_CONDIMENT, this,
                        MineField.FIELD_PRIORITY_LOW));

        flavors.getMineFields().add(
                new MineField(FieldEnum.SYRUP_TOPPING, this,
                        MineField.FIELD_PRIORITY_MEDIUM));
        flavors.getMineFields().add(
                new MineField(FieldEnum.SPREAD_TYPE, this,
                        MineField.FIELD_PRIORITY_LOW));

        flavors.getMineFields().add(
                new MineField(FieldEnum.CHEESE, this,
                        MineField.FIELD_PRIORITY_LOW));

        flavors.getMineFields().add(
                new MineField(FieldEnum.PRIMARY_FLAVOR, this,
                        MineField.FIELD_PRIORITY_LOW));
        
        flavors.getMineFields().add(
                new MineField(FieldEnum.TOPPING_FILLED_INGRED, this,
                        MineField.FIELD_PRIORITY_LOW));

        this.getMineGroups().add(flavors);

        MineGroup bread = new MineGroup("Bread");
        bread.setImage("img/bread.gif");
        bread.setBgcolor("#6699FF");
        bread.setCssClass("headerBGFlavor");

        bread.getMineFields().add(
                new MineField(FieldEnum.BREAK_CAKE_WAFFLE, this,
                        MineField.FIELD_PRIORITY_HIGH));

        bread.getMineFields().add(
                new MineField(FieldEnum.BREAKFAST_PASTRY, this,
                        MineField.FIELD_PRIORITY_HIGH));
        bread.getMineFields().add(
                new MineField(FieldEnum.BREAD_USE, this,
                        MineField.FIELD_PRIORITY_LOW));

        bread.getMineFields().add(
                new MineField(FieldEnum.COOKING_METHOD, this,
                        MineField.FIELD_PRIORITY_LOW));

        bread.getMineFields().add(
                new MineField(FieldEnum.BRAND, this,
                        MineField.FIELD_PRIORITY_LOW));

        bread.setForceExtraColumn(true);
        
        this.getMineGroups().add(bread);

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
//
//        places.getMineFields().add(
//                new MineField(FieldEnum.HEADQUARTERS_REGION, this,
//                        MineField.FIELD_PRIORITY_LOW));
//
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

        if (!masterFoodFilterParameters.getDayPartCategory().getNotValues()
                .contains("Breakfast")) {

            masterFoodFilterParameters.getDayPartCategory().getAndValues().add(
                    "Breakfast");

        }

    }

    public Collection getPrimaryFields() {
        Collection ret = new ArrayList();
        ret.add(new MineField(FieldEnum.BREAKFAST_PASTRY, this,
                MineField.FIELD_PRIORITY_LOW));

        return ret;

    }

    public String getMineType() {

        return MineFieldsFactory.MINE_TYPE_BREAKFAST;
    }

    public boolean isMemberOfMine(MasterFood masterFood) {

        if (masterFood == null) {
            return false;
        } else if (masterFood.getDayPartCategory().indexOf("Breakfast") > -1) {
            return true;
        }

        return false;
    }

}