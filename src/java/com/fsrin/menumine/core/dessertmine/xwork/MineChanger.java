/*
 * Created on Aug 18, 2005
 *
 * 
 */
package com.fsrin.menumine.core.dessertmine.xwork;

import com.fsrin.menumine.context.webwork.MenuMineSessionContextWrapper;
import com.fsrin.menumine.core.menumine.FieldsToDisplayBean;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParametersImpl;
import com.fsrin.menumine.core.menumine.rollup.RollUpOptions;
import com.fsrin.menumine.core.menumine.webwork.MasterFoodFilterParametersWrapperImpl;
import com.fsrin.menumine.core.menumine.webwork.MenuMineGraphOptions;
import com.fsrin.menumine.core.minefields.MineFields;

/**
 * @author Nick
 * 
 * This is a utility that allows us to change the mine active in the users
 * session.
 * 
 * We need this so we can change our mine in the express query.
 */
public class MineChanger {


    public void changeMine(
            MenuMineSessionContextWrapper menuMineSessionContextWrapper,
            MineFields fields) {
        if (!(menuMineSessionContextWrapper.getMineFields().getMineType()
                .equals(fields.getMineType()))) {

//            menuMineSessionContextWrapper.setSavedQuery(new SavedQuery());

            menuMineSessionContextWrapper
                    .setLastFilterWrapper(new MasterFoodFilterParametersWrapperImpl(
                            new MasterFoodFilterParametersImpl()));

            menuMineSessionContextWrapper
                    .setLastGraphOptions(new MenuMineGraphOptions());
            menuMineSessionContextWrapper.setRollUpOptions(new RollUpOptions());

            //            this.getMenuMineSessionContextWrapper().getLastFilterWrapper()
            //                    .getDayPartCategory().setAndValues("Dessert");
            menuMineSessionContextWrapper
                    .setLastFieldsToDisplay(new FieldsToDisplayBean());

            fields.applyHiddenParams(menuMineSessionContextWrapper
                    .getLastFilterWrapper());
            menuMineSessionContextWrapper.setMineFields(fields);

            menuMineSessionContextWrapper.setFirstQuerySent(false);
        }

    }

}