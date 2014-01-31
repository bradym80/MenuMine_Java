/*
 * Created on Jul 13, 2005
 *
 * 
 */
package com.fsrin.menumine.core.minefields;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Nick
 * 
 *  
 */
public class MineFieldsFactory {

    public static String MINE_TYPE_MENU = "menu.mine";

    public static String MINE_TYPE_DESSERT = "dessert.mine";

    public static String MINE_TYPE_INGREDIENT = "ingredient.mine";

    public static String MINE_TYPE_BREAKFAST = "breakfast.mine";

    public static String MINE_TYPE_BEVERAGE = "beverage.mine";

    public MineFieldsFactory() {
        super();

    }

    public MineFields getByKey(String mineType) {

        if (mineType == null) {
            return null;
        }

        if (mineType.equals(MINE_TYPE_MENU)) {
            return new MenuMineFields();
        }

        if (mineType.equals(MINE_TYPE_DESSERT)) {
            return new DessertMineFields();
        }

        if (mineType.equals(MINE_TYPE_INGREDIENT)) {
            return new IngredientMineFields();
        }

        if (mineType.equals(MINE_TYPE_BEVERAGE)) {
            return new BeverageMineFields();
        }

        if (mineType.equals(MINE_TYPE_BREAKFAST)) {
            return new BreakfastMineFields();
        }
        return null;
    }

    public Collection getAll() {
        Collection all = new ArrayList();
        all.add(new MenuMineFields());
        all.add(new DessertMineFields());
        all.add(new IngredientMineFields());
        all.add(new BeverageMineFields());
        all.add(new BreakfastMineFields());
        return all;
    }
}