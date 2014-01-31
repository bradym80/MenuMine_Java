/*
 * Created on Mar 15, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.savedquery.xwork;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fsrin.menumine.common.ServiceDelegateException;
import com.fsrin.menumine.common.util.ExceptionUtilities;
import com.fsrin.menumine.common.util.MiscellaneousNotificationAlert;
import com.fsrin.menumine.context.webwork.AbstractMenuMineSessionContextAwareAction;
import com.fsrin.menumine.core.menumine.FieldsToDisplayBean;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;
import com.fsrin.menumine.core.menumine.savedquery.SavedQuery;
import com.fsrin.menumine.core.menumine.savedquery.SavedQueryManager;
import com.fsrin.menumine.core.menumine.savedquery.SavedQueryServiceDelegate;
import com.fsrin.menumine.core.menumine.savedquery.SavedQueryServiceDelegateException;
import com.fstx.stdlib2.authen.users.User;
import com.fstx.stdlib2.authen.users.UserGroup;
import com.fstx.stdlib2.authen.users.UserGroupServiceDelegate;

public class SaveAsNewQueryAction extends
        AbstractMenuMineSessionContextAwareAction {

    public static final String SPRING_BEAN_NAME = "saveQueryAction";

    private Log log = LogFactory.getLog(SaveAsNewQueryAction.class);
    
    private String spreadsheetName;

    private SavedQueryManager savedQueryManager;

    private SavedQueryServiceDelegate savedQueryServiceDelegate;

    private UserGroupServiceDelegate userGroupServiceDelegate;

    private SavedQuery result;

    public String execute() throws Exception {

        if (this.getSpreadsheetName() != null) {

            validateQuery();

            if (!this.getMenuMineSessionContextWrapper().getErrorContext()
                    .hasErrors()) {
                try {
                    this.handleQuerySave();
                } catch (Exception e) {
                    
                    e.printStackTrace();
                    
                    this.getMenuMineSessionContextWrapper().getErrorContext()
                            .addError(
                                    "Attempted to save this query but failed.");
                    new MiscellaneousNotificationAlert().sendAlert(
                            "failed to save a query, exited gracefully. \n\n" + ExceptionUtilities.getExceptionStackTrace(e), this
                                    .getMenuMineSessionContextWrapper()
                                    .getMenuMineSessionContext());
                }
            }
        }

        return SUCCESS;

    }

    /*
     * basically need to be sure that name doesn't already exist.
     */

    private void validateQuery() throws Exception {

        /*
         * 2006-08-17 reid@fivesticks.com causes occassional save errors
         */
//        FieldsToDisplayBean fields = new FieldsToDisplayBeanBuilder()
//                .build(this.getMenuMineSessionContextWrapper()
//                        .getLastFilterWrapper().getMasterFoodFilterParameters());
        FieldsToDisplayBean fields = this.getMenuMineSessionContextWrapper().getLastFieldsToDisplay();
        
        
        log.info("Fields selected " + fields.countTotalSelected());
        
        /*
         * 2006-08-17 reid - do we need this anymore?
         */
        if (fields.countTotalSelected() == 0) {
            this
                    .getMenuMineSessionContextWrapper()
                    .getErrorContext()
                    .addError(
                            "You must have at least one field selected to save a query.");
        }

        if (!validateName()) {
            this.getMenuMineSessionContextWrapper().getErrorContext().addError(
                    "You already have a query with that name.");
        }
    }

    private boolean validateName() throws Exception {

        Collection c = this.getSavedQueryServiceDelegate().getByUserAndName(
                this.getMenuMineSessionContextWrapper().getAuthenticatedUser()
                        .getUsername(), this.getSpreadsheetName());

        boolean ret = c.size() == 0;

        return ret;

    }

    private void handleQuerySave() throws SavedQueryServiceDelegateException {

        SavedQuery savedQuery = new SavedQuery();

        MasterFoodFilterParameters params = this
                .getMenuMineSessionContextWrapper().getLastFilterWrapper()
                .getMasterFoodFilterParameters();

        if (params.getId() != null) {
            params = params.clone();
        }

        savedQuery.setMasterFoodFilterParameters(params);

        /*
         * 2006-08-17 reid@fivesticks.com 
         * this should be the other way round.
         */
//        savedQuery.setFieldsToDisplayBean(new FieldsToDisplayBeanBuilder()
//                .build(params));
        savedQuery.setFieldsToDisplayBean(this.getMenuMineSessionContextWrapper().getLastFieldsToDisplay());

        /*
         * 2006-11-08 reid make sure we're saving a new one.
         */
        savedQuery.getFieldsToDisplayBean().setId(null);
        
        savedQuery.setUserName(this.getMenuMineSessionContextWrapper()
                .getAuthenticatedUser().getUsername());

        String group = getGroupName(this.getMenuMineSessionContextWrapper()
                .getAuthenticatedUser().getUser());

        savedQuery.setMineType(this.getMenuMineSessionContextWrapper()
                .getMineFields().getMineType());

        savedQuery.setGroupName(group);

        savedQuery.setName(this.getSpreadsheetName());

        savedQuery.setPermission(SavedQuery.USER_QUERY_PERMISSION.intValue());

        if (savedQuery.getFieldsToDisplayBean().countTotalSelected() == 0) {
            throw new RuntimeException("Attempting to save an empty query. (selected field count is 0)");
        }

        this.getSavedQueryServiceDelegate().saveNew(savedQuery);

        this.setResult(savedQuery);

        /*
         * 2006-03-16 RSC This was being used instead of the
         * lastFilterParameters.
         */
        // this.getMenuMineSessionContextWrapper().setSavedQuery(savedQuery);
    }

    public SavedQueryManager getSavedQueryManager() {
        return savedQueryManager;
    }

    public void setSavedQueryManager(SavedQueryManager savedQueryManager) {
        this.savedQueryManager = savedQueryManager;
    }

    public SavedQueryServiceDelegate getSavedQueryServiceDelegate() {
        return savedQueryServiceDelegate;
    }

    public void setSavedQueryServiceDelegate(
            SavedQueryServiceDelegate savedQueryServiceDelegate) {
        this.savedQueryServiceDelegate = savedQueryServiceDelegate;
    }

    public String getSpreadsheetName() {
        return spreadsheetName;
    }

    public void setSpreadsheetName(String spreadSheetName) {
        this.spreadsheetName = spreadSheetName;
    }

    private String getGroupName(User user) {

        Collection groups = null;
        try {
            groups = this.getUserGroupServiceDelegate().getGroupsByUser(user);
        } catch (ServiceDelegateException e) {
            return "";
        }

        if (groups.size() > 0) {

            return ((UserGroup) groups.toArray()[0]).getName();
        }
        return null;
    }

    public UserGroupServiceDelegate getUserGroupServiceDelegate() {
        return userGroupServiceDelegate;
    }

    public void setUserGroupServiceDelegate(
            UserGroupServiceDelegate userGroupServiceDelegate) {
        this.userGroupServiceDelegate = userGroupServiceDelegate;
    }

    public SavedQuery getResult() {
        return result;
    }

    public void setResult(SavedQuery result) {
        this.result = result;
    }
}
