/*
 * Created on 2005-1-18
 *
 */

package com.fsrin.menumine.core.ingredient.xwork;

import com.fsrin.menumine.context.webwork.AbstractMenuMineSessionContextAwareAction;
import com.fsrin.menumine.core.menumine.FieldsToDisplayBean;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParametersImpl;
import com.fsrin.menumine.core.menumine.rollup.RollUpOptions;
import com.fsrin.menumine.core.menumine.webwork.MasterFoodFilterParametersWrapperImpl;
import com.fsrin.menumine.core.menumine.webwork.MenuMineGraphOptions;
import com.fsrin.menumine.core.minefields.IngredientMineFields;

/**
 * @author Nick
 * @version 1
 */

public class IngredientMineAction extends AbstractMenuMineSessionContextAwareAction {

//    private MenuMineSessionContextWrapper menuMineSessionContextWrapper;

    public String execute() throws Exception {
        /*
         * Ingredient Mine should only show results where day part has
         * Ingredient in it.
         */

        if (!(this.getMenuMineSessionContextWrapper().getMineFields() instanceof IngredientMineFields)) {

//            this.getMenuMineSessionContextWrapper().setSavedQuery(
//                    new SavedQuery());

            this.getMenuMineSessionContextWrapper().setLastFilterWrapper(
                    new MasterFoodFilterParametersWrapperImpl(
                            new MasterFoodFilterParametersImpl()));

            this.getMenuMineSessionContextWrapper().setLastGraphOptions(
                    new MenuMineGraphOptions());
            this.getMenuMineSessionContextWrapper().setRollUpOptions(
                    new RollUpOptions());

            this.getMenuMineSessionContextWrapper().setLastFieldsToDisplay(
                    new FieldsToDisplayBean());
            IngredientMineFields fields = new IngredientMineFields();
            fields.applyHiddenParams(this.getMenuMineSessionContextWrapper()
                    .getLastFilterWrapper());
            this.getMenuMineSessionContextWrapper().setMineFields(fields);

            this.getMenuMineSessionContextWrapper().setFirstQuerySent(false);
        }
        return SUCCESS;

    }

//    public MenuMineSessionContextWrapper getMenuMineSessionContextWrapper() {
//        return menuMineSessionContextWrapper;
//    }
//
//    public void setMenuMineSessionContextWrapper(
//            MenuMineSessionContextWrapper menuMineSessionContextWrapper) {
//        this.menuMineSessionContextWrapper = menuMineSessionContextWrapper;
//    }
}