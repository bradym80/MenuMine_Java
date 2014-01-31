/*
 * Created on Mar 15, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.savedquery.xwork;

import com.fsrin.menumine.context.webwork.AbstractMenuMineSessionContextAwareAction;
import com.fsrin.menumine.core.menumine.savedquery.SavedQuery;
import com.fsrin.menumine.core.menumine.savedquery.SavedQueryServiceDelegate;
import com.fsrin.menumine.core.menumine.webwork.MasterFoodFilterParametersWrapperImpl;
import com.fsrin.menumine.core.minefields.MineFields;

/**
 * 2006-09-06 adapted from Load Query Action.
 * 
 * @author Reid
 */
public class LoadCustomTemplateAction extends
        AbstractMenuMineSessionContextAwareAction {

    private Long target;

    public String execute() throws Exception {

        SavedQueryServiceDelegate sqsd = SavedQueryServiceDelegate.factory
                .build();

        SavedQuery savedQuery = null;

        if (this.getTarget() != null) {

            try {
                savedQuery = sqsd.getById(this.getTarget());

                // clear out any database id's

                savedQuery.getFieldsToDisplayBean().setId(null);
                savedQuery.getMasterFoodFilterParameters().setId(null);

                // set up the session context
                
                this.getMenuMineSessionContextWrapper().setLastFieldsToDisplay(
                        savedQuery.getFieldsToDisplayBean());

                this.getMenuMineSessionContextWrapper().setLastFilterWrapper(
                        new MasterFoodFilterParametersWrapperImpl(savedQuery
                                .getMasterFoodFilterParameters()));

                this.getMenuMineSessionContextWrapper().setMineFields(
                        MineFields.factory.getByKey(savedQuery.getMineType()));

            } catch (Exception e) {
                this.getMenuMineSessionContextWrapper().getErrorContext()
                        .addError("Unable to load that query template.");
            }

        }

        return SUCCESS;
    }

    public Long getTarget() {
        return target;
    }

    public void setTarget(Long target) {
        this.target = target;
    }
}
