/*
 * Created on Mar 15, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.savedquery.xwork;

import java.util.Iterator;

import com.fsrin.menumine.common.util.MiscellaneousNotificationAlert;
import com.fsrin.menumine.core.menumine.savedquery.SavedQuery;
import com.fsrin.menumine.core.menumine.savedquery.SavedQueryServiceDelegate;
import com.fsrin.menumine.core.menumine.savedquery.SavedQueryServiceDelegateException;
import com.fsrin.menumine.core.menumine.webwork.AbstractQueryHistorySupportAction;
import com.fsrin.menumine.core.menumine.webwork.MasterFoodFilterParametersWrapperImpl;
import com.fsrin.menumine.core.minefields.MineFields;

/**
 * 2006-03-15
 * 
 * @author Reid
 */
public class LoadQueryAction extends AbstractQueryHistorySupportAction {

    public static final String SPRING_BEAN_NAME = "loadQueryAction";

    public String execute() throws Exception {

        if (this.getSelectHistory() != null) {
            try {
                pullFromHistory();
            } catch (Exception e) {
                this
                        .getMenuMineSessionContextWrapper()
                        .getErrorContext()
                        .addError(
                                "Unable to load that query.  You'll need to delete it in query manager.  FSRIN has been notified.");
                new MiscellaneousNotificationAlert().sendAlert(
                        "failed to load query " + this.getSelectHistory(), this
                                .getMenuMineSessionContextWrapper()
                                .getMenuMineSessionContext());
            }
        }

        return SUCCESS;
    }

    private void pullFromHistory() {
        // 2006-02-06 RSC Replaced with a more basic lookup.

        SavedQuery savedQuery = null;

        for (Iterator iter = this.getHistory().iterator(); iter.hasNext();) {
            // QueryHistoryEntry element = (QueryHistoryEntry) iter.next();
            SavedQuery element = (SavedQuery) iter.next();
            if (element.getName() != null
                    && element.getName().equals(this.getSelectHistory())) {

                savedQuery = element;

                break;
            }
        }

        /*
         * check to see if we need to get it from the database.
         */
        if (savedQuery == null || savedQuery.isSimple()) {

            try {
                savedQuery = SavedQueryServiceDelegate.factory.build()
                        .getByUser(
                                this.getMenuMineSessionContextWrapper()
                                        .getMenuMineSessionContext()
                                        .getAuthenticatedUser().getUsername(),
                                this.getSelectHistory());

            } catch (SavedQueryServiceDelegateException e) {
                throw new RuntimeException("failed to pull from history.", e);
            }
        }

        if (savedQuery != null) {

            this.getMenuMineSessionContextWrapper().setLastFieldsToDisplay(
                    savedQuery.getFieldsToDisplayBean());

            this.getMenuMineSessionContextWrapper().setLastFilterWrapper(
                    new MasterFoodFilterParametersWrapperImpl(savedQuery
                            .getMasterFoodFilterParameters()));

            this.getMenuMineSessionContextWrapper().setMineFields(
                    MineFields.factory.getByKey(savedQuery.getMineType()));

            // this.getMenuMineSessionContextWrapper().setSavedQuery(savedQuery);

        } else {

            this.getMenuMineSessionContextWrapper().getErrorContext().addError(
                    "Unable to load that saved query.");
        }
    }
}
