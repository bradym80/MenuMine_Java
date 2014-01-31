/*
 * Created on 2005-1-18
 *
 */

package com.fsrin.menumine.core.dessertmine.xwork;

import com.fsrin.menumine.context.webwork.AbstractMenuMineSessionContextAwareAction;
import com.fsrin.menumine.core.menumine.FieldsToDisplayBean;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParametersImpl;
import com.fsrin.menumine.core.menumine.rollup.RollUpOptions;
import com.fsrin.menumine.core.menumine.webwork.MasterFoodFilterParametersWrapperImpl;
import com.fsrin.menumine.core.menumine.webwork.MenuMineGraphOptions;
import com.fsrin.menumine.core.minefields.DessertMineFields;
import com.fsrin.menumine.core.minefields.MineFields;

/**
 * @author Nick
 * @version 1
 */

public class DessertMineAction extends
        AbstractMenuMineSessionContextAwareAction {

    // private MenuMineSessionContextWrapper menuMineSessionContextWrapper;

    public String execute() throws Exception {
        /*
         * Dessert Mine should only show results where day part has Dessert in
         * it.
         */

        if (!(this.getMenuMineSessionContextWrapper().getMineFields() 
                instanceof DessertMineFields)) {

//            this.getMenuMineSessionContextWrapper().setSavedQuery(
//                    new SavedQuery());

            this.getMenuMineSessionContextWrapper().setLastFilterWrapper(
                    new MasterFoodFilterParametersWrapperImpl(
                            new MasterFoodFilterParametersImpl()));

            this.getMenuMineSessionContextWrapper().setLastGraphOptions(
                    new MenuMineGraphOptions());
            this.getMenuMineSessionContextWrapper().setRollUpOptions(
                    new RollUpOptions());

            // this.getMenuMineSessionContextWrapper().getLastFilterWrapper()
            // .getDayPartCategory().setAndValues("Dessert");
            this.getMenuMineSessionContextWrapper().setLastFieldsToDisplay(
                    new FieldsToDisplayBean());
            MineFields fields = new DessertMineFields();
            fields.applyHiddenParams(this.getMenuMineSessionContextWrapper()
                    .getLastFilterWrapper());
            this.getMenuMineSessionContextWrapper().setMineFields(fields);

            this.getMenuMineSessionContextWrapper().setFirstQuerySent(false);
        }
        return SUCCESS;

    }

    // public MenuMineSessionContextWrapper getMenuMineSessionContextWrapper() {
    // return menuMineSessionContextWrapper;
    // }
    //
    // public void setMenuMineSessionContextWrapper(
    // MenuMineSessionContextWrapper menuMineSessionContextWrapper) {
    // this.menuMineSessionContextWrapper = menuMineSessionContextWrapper;
    // }
}