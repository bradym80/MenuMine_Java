/*
 * Created on 2005-1-18
 *
 */
package com.fsrin.menumine.core.menumine.webwork.legacy;

import com.fsrin.menumine.context.webwork.AbstractMenuMineSessionContextAwareAction;
import com.fsrin.menumine.core.menumine.FieldsToDisplayBean;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParametersImpl;
import com.fsrin.menumine.core.menumine.SavedQuery;
import com.fsrin.menumine.core.menumine.webwork.MasterFoodFilterParametersWrapperImpl;
import com.fsrin.menumine.core.menumine.webwork.MenuMineGraphOptions;
import com.fsrin.menumine.core.minefields.MenuMineFields;

/**
 * @author Nick
 * @version 1
 */

public class MenuMineAction extends AbstractMenuMineSessionContextAwareAction {

//    private MenuMineSessionContextWrapper menuMineSessionContextWrapper;

    public String execute() throws Exception {
        /*
         * Menu Mine should only show results where day part does not have
         * Dessert in it.
         */
        if (!(this.getMenuMineSessionContextWrapper().getMineFields() instanceof MenuMineFields)) {

            this.getMenuMineSessionContextWrapper().setSavedQuery(
                    new SavedQuery());

            this.getMenuMineSessionContextWrapper().setLastFilterWrapper(
                    new MasterFoodFilterParametersWrapperImpl(
                            new MasterFoodFilterParametersImpl()));
            
            this.getMenuMineSessionContextWrapper().setLastFieldsToDisplay(
                    new FieldsToDisplayBean());
            
            this.getMenuMineSessionContextWrapper().setLastGraphOptions(
                    new MenuMineGraphOptions());
            
            //            this.getMenuMineSessionContextWrapper().setRollUpOptions(
            //                    new RollUpOptions());
            this.getMenuMineSessionContextWrapper().resetRollUpOptions();
            
            MenuMineFields fields = new MenuMineFields();
            
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