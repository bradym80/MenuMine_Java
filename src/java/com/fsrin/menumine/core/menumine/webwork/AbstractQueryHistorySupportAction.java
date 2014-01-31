/*
 * Created on Mar 15, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.webwork;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.fsrin.menumine.context.webwork.AbstractMenuMineSessionContextAwareAction;
import com.fsrin.menumine.core.menumine.savedquery.SavedQuery;
import com.fsrin.menumine.core.menumine.savedquery.SavedQueryManager;

public abstract class AbstractQueryHistorySupportAction extends
        AbstractMenuMineSessionContextAwareAction {

    private String selectHistory;
    
    private SavedQueryManager savedQueryManager;

    protected Collection historyList;

    /*
     * This will return a history list specific to the current mine. We build a
     * full list, then filter for the current mine.
     */
    public Collection getHistory() {

        if (historyList == null) {

            historyList = new ArrayList();

            QueryHistoryEntry entryMock1 = new QueryHistoryEntry();
            entryMock1.setName("-----Session Saves-----");
            historyList.add(entryMock1);

            Collection history = this.getMenuMineSessionContextWrapper()
                    .getMenuMineSessionContext().getHistory();

            historyList.addAll(history);

            QueryHistoryEntry entryMock = new QueryHistoryEntry();
            entryMock.setName("-----Permanent Saves-----");
            historyList.add(entryMock);

            // QueryHistoryEntry temp = new QueryHistoryEntry();
            // temp.setName("Temporarily Under Construction");
            // historyList.add(temp);

            Collection saved = new ArrayList();

            Collection userSave = null;

            // Collection groupSave = null;

            if (this.getSavedQueryManager() != null) {
                userSave = this.getSavedQueryManager().getUserQueries(
                        this.getMenuMineSessionContextWrapper()
                                .getAuthenticatedUser());
                /*
                 * 2006-02-06 RSC Removing
                 */
                // groupSave = this.getSavedQueryManager().getGroupQueries(
                // this.getMenuMineSessionContextWrapper()
                // .getAuthenticatedUser());
            }

            // if (userSave == null || groupSave == null) {
            if (userSave == null) {
                QueryHistoryEntry entryInit = new QueryHistoryEntry();
                entryInit.setName("----INITIALIZING SAVES----");
                historyList.add(entryInit);
            } else {

                // saved.addAll(groupSave);

                saved.addAll(userSave);
                historyList.addAll(saved);
                /*
                 * Add the saved querys to this list.
                 */
                // for (Iterator iter = saved.iterator(); iter.hasNext();) {
                // SavedQuery element = (SavedQuery) iter.next();
                //                    
                // QueryHistoryEntry entry = new QueryHistoryEntry();
                // entry.setFieldsToDisplayBean(element
                // .getFieldsToDisplayBean());
                // MasterFoodFilterParametersWrapper wrapper = new
                // MasterFoodFilterParametersWrapperImpl(
                // element.getMasterFoodFilterParameters());
                //
                // entry.setParameters(wrapper);
                //
                // entry.setName(element.getName());
                // historyList.add(element);
                // }
            }
        }

        /*
         * We now need to filter the list for the current mine.
         */
        Collection filtered = new ArrayList();

        for (Iterator iter = historyList.iterator(); iter.hasNext();) {
            SavedQuery element = (SavedQuery) iter.next();
            String mineType = null;
            if (element.getMineType() != null
                    && element.getMineType().length() > 0) {
                mineType = element.getMineType();
            }
            if (mineType == null) {
                filtered.add(element);
            } else if (mineType.equals(this.getMenuMineSessionContextWrapper()
                    .getMineFields().getMineType())) {
                filtered.add(element);
            }

        }

        return filtered;
    }

    public Collection getHistoryList() {
        return historyList;
    }

    public void setHistoryList(Collection historyList) {
        this.historyList = historyList;
    }

    public String getSelectHistory() {
        return selectHistory;
    }

    public void setSelectHistory(String selectHistory) {
        this.selectHistory = selectHistory;
    }
    
    public SavedQueryManager getSavedQueryManager() {
        return savedQueryManager;
    }

    public void setSavedQueryManager(SavedQueryManager savedQueryManager) {
        this.savedQueryManager = savedQueryManager;
    }

}
