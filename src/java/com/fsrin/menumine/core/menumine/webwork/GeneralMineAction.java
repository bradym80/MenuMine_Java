/*
 * Created on 2005-1-18
 *
 */
package com.fsrin.menumine.core.menumine.webwork;

import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fsrin.menumine.core.menumine.FieldsToDisplayBean;
import com.fsrin.menumine.core.menumine.FieldsToDisplayBeanBuilder;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParametersDecorator;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParametersImpl;
import com.fsrin.menumine.core.menumine.masterfood.DistinctQueryBuilder;
import com.fsrin.menumine.core.menumine.masterfood.MasterFoodServiceDelegate;
import com.fsrin.menumine.core.menumine.savedquery.SavedQuery;
import com.fsrin.menumine.core.menumine.savedquery.SavedQueryServiceDelegate;
import com.fsrin.menumine.core.minefields.MineFields;
import com.fsrin.menumine.users.UserPreferenceKeys;
import com.fsrin.menumine.users.UserPreferenceServiceDelegateFactory;

/**
 * @author Nick
 * @version 1
 */

public class GeneralMineAction extends AbstractQueryHistorySupportAction {

    private static final Log log = LogFactory.getLog(GeneralMineAction.class);

    public static final String SPRING_BEAN_NAME = "menuMineAction";

    // private MenuMineSessionContextWrapper menuMineSessionContextWrapper;

    /*
     * Query related fields. These guys recieve request params.
     */
    private FieldsToDisplayBean fieldsToDisplay = new FieldsToDisplayBean();

    private MasterFoodFilterParametersWrapper masterFoodFilterParameters = new MasterFoodFilterParametersWrapperImpl();

    /*
     * Delegates
     */
    // private UserGroupServiceDelegate userGroupServiceDelegate;
    private MasterFoodServiceDelegate masterFoodServiceDelegate;

    private SavedQueryServiceDelegate savedQueryServiceDelegate;

    /*
     * Display fields
     */
    private MenuMineDisplayOptions menuMineDisplayOptions = new MenuMineDisplayOptions();

    private MenuMineGraphOptions menuMineGraphOptions = new MenuMineGraphOptions();

    private MenuMineCrossTabulationOptions menuMineCrossTabulationOptions = new MenuMineCrossTabulationOptions();

    /*
     * History/ Save filters
     */
    private String selectHistory;

    private String spreadsheetName;

    private QueryValidator queryValidator = new MenuMineBasicQueryValidator();

    /*
     * This is used to populate the form.
     */
    private DistinctQueryBuilder distinctQueryBuilder;

    private String submit;

    private String reset;

    private boolean run = false;
    
    private String postAction = "menumine.action";

    public String execute() throws Exception {
        // log.debug("starting general mine action");
        // TimerUtil gen = TimerUtil.getInstanceAndStart("GeneralMineAction");
        String ret = this.handleExecute();
        // gen.stop();
        // log.debug("completed");
        return ret;

    }

    public String handleExecute() throws Exception {
        if (this.isResetSubmit()) {
            this.handleReset();
            return INPUT;
        }

        /*
         * If we have yet to submit anything, just go to SUCCESS.
         */
        if ((this.getSubmit() != null && this.getSubmit().equals("Login"))
                && !this.getMenuMineSessionContextWrapper().isFirstQuerySent()
                && this.getSelectHistory() == null) {

            return SUCCESS;
        }

        /*
         * nick 2005-1-25 If we don't have a view selected. We don't need to
         * validate.
         * 
         */

        if (this.getSubmit() != null
                && (this.getSubmit().equals("Load Saved Query") || this
                        .getSubmit().equals("Save Current Query"))) {
            this.masterFoodFilterParameters = this
                    .getMenuMineSessionContextWrapper().getLastFilterWrapper();
            this.fieldsToDisplay = this.getMenuMineSessionContextWrapper()
                    .getLastFieldsToDisplay();
        } else if (this.getSubmit() != null
                && !this.getSubmit().equals("Search")) {
            this.getMenuMineSessionContextWrapper().setFirstQuerySent(true);

            /*
             * This is a new query so forget about the old one.
             */
            this.getMenuMineSessionContextWrapper().setLastQueryResultTicket(
                    null);

            boolean valid = this.getQueryValidator().validate(
                    this.getMasterFoodFilterParameters()
                            .getMasterFoodFilterParameters(),
                    this.getFieldsToDisplay());

            if (!valid) {
                this.getMenuMineDisplayOptions().setDisplayType("Error");
            }

            this.getMenuMineSessionContextWrapper().setLastFieldsToDisplay(
                    this.fieldsToDisplay);

            this.getMenuMineSessionContextWrapper().setLastFilterWrapper(
                    this.masterFoodFilterParameters);

            /*
             * here's where we need to update preferences
             */
            String key = UserPreferenceKeys.FAVORITE_FIELDS_PREFIX
                    + this.getMenuMineSessionContextWrapper().getMineFields()
                            .getMineType();

            StringBuffer value = new StringBuffer();

            Collection selected = this.getMenuMineSessionContextWrapper()
                    .getLastFieldsToDisplay().getSelectedOgnlNames();

            for (Iterator iter = selected.iterator(); iter.hasNext();) {
                String element = (String) iter.next();

                /*
                 * 2006-04-19 RSC
                 * need to make sure we're not exceding the field length.
                 */
                if (value.length() + element.length() + 1 > 250) {
                    break;
                }
                
                if (value.length() > 0) {
                    value.append(",");
                }
                value.append(element);
            }

            log.debug("Selected fields are now " + value.toString());

            UserPreferenceServiceDelegateFactory.build().updateUserPreference(
                    this.getMenuMineSessionContextWrapper()
                            .getAuthenticatedUser().getUsername(), key,
                    value.toString());

            this.updateHistory();
        } else {
            this.masterFoodFilterParameters = this
                    .getMenuMineSessionContextWrapper().getLastFilterWrapper();
            this.fieldsToDisplay = this.getMenuMineSessionContextWrapper()
                    .getLastFieldsToDisplay();
        }
        this.getMenuMineSessionContextWrapper().setFirstQuerySent(true);
        return SUCCESS;

    }

    private void handleReset() throws Exception {

        log.debug("resetting");

        this.menuMineDisplayOptions
                .setDisplayType(MenuMineDisplayOptions.DISPLAY_RESET);

        this.getMenuMineSessionContextWrapper().setLastFilterWrapper(
                new MasterFoodFilterParametersWrapperImpl(
                        new MasterFoodFilterParametersImpl()));

        new MasterFoodFilterParametersDecorator().decorateWithFieldSet(this
                .getMenuMineSessionContextWrapper().getLastFilterWrapper()
                .getMasterFoodFilterParameters(), this
                .getMenuMineSessionContextWrapper().getAuthenticatedUser()
                .getUsername(), this.getMenuMineSessionContextWrapper()
                .getMineFields().getMineType());
        

        this.getMenuMineSessionContextWrapper().setLastFieldsToDisplay(
                new FieldsToDisplayBeanBuilder()
                        .build(this.getMenuMineSessionContextWrapper()
                                .getLastFilterWrapper()
                                .getMasterFoodFilterParameters()));

        this.masterFoodFilterParameters = this
                .getMenuMineSessionContextWrapper().getLastFilterWrapper();

        this.fieldsToDisplay = this.getMenuMineSessionContextWrapper()
                .getLastFieldsToDisplay();

        this.getMenuMineSessionContextWrapper().setShareTableMap(null);
        /*
         * 2006-04-08 RSC Reset should require his.
         */
        
        this.getMenuMineSessionContextWrapper().setLastGraphOptions(new MenuMineGraphOptions());
        this.menuMineGraphOptions = this.getMenuMineSessionContextWrapper().getLastGraphOptions();
        
        this.getMenuMineSessionContextWrapper().setFirstQuerySent(false);
        
        

    }

    private void applyMasterFoodFilterParameters(SavedQuery savedQuery) {
        savedQuery.setFieldsToDisplayBean(this
                .getMenuMineSessionContextWrapper().getLastFieldsToDisplay());

    }

    /*
     * Figure out if the last query needs to be added to the history
     */
    private void updateHistory() {

        if (this.getSubmit() != null
                && this.getSubmit().equals("Submit Query")
                && (this.getSelectHistory() == null || this.getSelectHistory()
                        .equals(""))) {



            QueryHistoryEntry entry = new QueryHistoryEntry();

            entry.setFieldsToDisplayBean(this.getFieldsToDisplay());
            entry.setMasterFoodFilterParameters(this
                    .getMasterFoodFilterParameters()
                    .getMasterFoodFilterParameters());

            entry.setMineType(this.getMineFields().getMineType());
            if (this.getSpreadsheetName() != null
                    && !this.getSpreadsheetName().equals("")) {
                entry.setName(this.getSpreadsheetName()
                        + (this.getHistory().size() + 1));
            } else {
                entry
                        .setName("Query History "
                                + (this.getHistory().size() + 1));
            }
            this.getMenuMineSessionContextWrapper().getMenuMineSessionContext()
                    .getHistory().add(entry);

            /*
             * Since we changed this list we should force it to be rebuilt.
             */
            this.historyList = null;

        }
    }

//    public String getPostAction() {
//        return "menumine.action";
//    }

    public boolean isQueryExists() {
        return this.getMenuMineSessionContextWrapper().isFirstQuerySent();
        // return this.getMenuMineSessionContextWrapper().getLastFilterWrapper()
        // != null;
    }

    public boolean isFieldsAreSelected() {
        return this.getFieldsToDisplay().countTotalSelected() > 0;
    }

    public Collection getLastQuerySummary() {
        return this.getMasterFoodFilterParameters()
                .getMasterFoodFilterParameters().getSummary(
                        this.getMineFields());
    }

    public MasterFoodFilterParametersWrapper getMasterFoodFilterParameters() {

        return this.masterFoodFilterParameters;
    }

    /*
     * Nick This is here to help the word clickable pages require less text.
     */
    public MasterFoodFilterParametersWrapper getMp() {
        return getMasterFoodFilterParameters();
    }

    public MasterFoodServiceDelegate getMasterFoodServiceDelegate() {
        return masterFoodServiceDelegate;
    }

    public void setMasterFoodServiceDelegate(
            MasterFoodServiceDelegate masterFoodServiceDelegate) {
        this.masterFoodServiceDelegate = masterFoodServiceDelegate;
    }

    public DistinctQueryBuilder getDistinctQueryBuilder() {
        return distinctQueryBuilder;

    }

    public void setDistinctQueryBuilder(
            DistinctQueryBuilder distinctQueryBuilder) {
        this.distinctQueryBuilder = distinctQueryBuilder;
    }

    // public boolean isReset() {
    // if (this.getSubmit() != null && this.getSubmit().equals("RESET")) {
    // return true;
    // }
    // return false;
    // }

    public String getSubmit() {
        return submit;
    }

    public void setSubmit(String submit) {
        this.submit = submit;
    }

    public FieldsToDisplayBean getFieldsToDisplay() {

        // return
        // this.getMenuMineSessionContextWrapper().getLastFieldsToDisplay();
        return this.fieldsToDisplay;
    }

    // public void setFieldsToDisplay(FieldsToDisplayBean fieldsToDisplay) {
    // this.fieldsToDisplay = fieldsToDisplay;
    // }

    public MenuMineDisplayOptions getMenuMineDisplayOptions() {
        return menuMineDisplayOptions;
    }

    public void setMenuMineDisplayOptions(
            MenuMineDisplayOptions menuMineDisplayOptions) {
        this.menuMineDisplayOptions = menuMineDisplayOptions;
    }

    public MenuMineGraphOptions getMenuMineGraphOptions() {
        return menuMineGraphOptions;
    }

    public void setMenuMineGraphOptions(
            MenuMineGraphOptions menuMineGraphOptions) {
        this.menuMineGraphOptions = menuMineGraphOptions;
    }

    public QueryValidator getQueryValidator() {
        return queryValidator;
    }

    public void setQueryValidator(QueryValidator queryValidator) {
        this.queryValidator = queryValidator;
    }

    public String getSelectHistory() {
        return selectHistory;
    }

    public void setSelectHistory(String selectHistory) {
        this.selectHistory = selectHistory;
    }

    public String getSpreadsheetName() {

        return spreadsheetName;

    }

    public void setSpreadsheetName(String spreadsheetName) {
        this.spreadsheetName = spreadsheetName;
    }

    public void setSavedQueryServiceDelegate(
            SavedQueryServiceDelegate savedQueryServiceDelegate) {
        this.savedQueryServiceDelegate = savedQueryServiceDelegate;
    }

    public SavedQueryServiceDelegate getSavedQueryServiceDelegate() {
        return savedQueryServiceDelegate;
    }

    public MenuMineCrossTabulationOptions getMenuMineCrossTabulationOptions() {
        return menuMineCrossTabulationOptions;
    }

    public void setMenuMineCrossTabulationOptions(
            MenuMineCrossTabulationOptions menuMineCrossTabulationOptions) {
        this.menuMineCrossTabulationOptions = menuMineCrossTabulationOptions;
    }

    public Collection getFieldOptions() {

        log.debug("getting field options.");

        return FieldListBuilder.singleton.buildFieldList(this.getMineFields());

    }

    public MineFields getMineFields() {

        log.debug("getting mine fields");

        this.getMenuMineSessionContextWrapper().getMineFields()
                .setFieldsToDisplayBean(this.getFieldsToDisplay());

        this.getMenuMineSessionContextWrapper().getMineFields()
                .setMasterFoodFilterParameters(
                        this.getMasterFoodFilterParameters());

        this.getMenuMineSessionContextWrapper().getMineFields()
                .setDistinctQueryBuilder(this.getDistinctQueryBuilder());

        return this.getMenuMineSessionContextWrapper().getMineFields();
    }

    public boolean isResetSubmit() {
        return this.getReset() != null && this.getReset().equals("RESET");
    }

    public String getReset() {
        return reset;
    }

    public void setReset(String reset) {
        this.reset = reset;
    }

    public String getPostAction() {
        return postAction;
    }

    public void setPostAction(String postAction) {
        this.postAction = postAction;
    }

}