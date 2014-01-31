package com.fsrin.menumine.core.menumine.webwork;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fsrin.menumine.context.webwork.AbstractMenuMineSessionContextAwareAction;
import com.fsrin.menumine.core.menumine.FieldsToDisplayBean;
import com.fsrin.menumine.core.menumine.FieldsToDisplayBeanBuilder;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;
import com.fsrin.menumine.core.menumine.chain.ChainFilterParameters;
import com.fsrin.menumine.core.menumine.chain.ChainServiceDelegate;
import com.fsrin.menumine.core.menumine.masterfood.MasterFoodSearchException;
import com.fsrin.menumine.core.menumine.masterfood.MasterFoodServiceDelegate;
import com.fsrin.menumine.core.menumine.rollup.RollUpOptions;
import com.fsrin.menumine.core.menumine.rollup.RollUpServiceDelegate;
import com.fsrin.menumine.core.menumine.rollup.RollUpServiceDelegateException;
import com.fsrin.menumine.core.minefields.MineFields;

/**
 * 2006-02-06 RSC Renamed.  Never called directly.
 * 
 * Note: do not make abstract as Spring needs to instantiate this.
 * 
 * @author Reid
 * @author Nick
 * @version 1
 */

public class AbstractMenuMineDisplayAction extends
        AbstractMenuMineSessionContextAwareAction {

    
    private static final String ASC = "ASC";
    
    protected static final String SPECIAL_NATIONAL_ACCOUNT_BENCHMARK = "NATLACCT";
    
    protected static final String SPECIAL_ROLLUP = "ROLLUP";
    
    
    private long COUNT_LIMIT = 25000;

//    private CompletedQueryManagerImpl completedQueryManager;

    private Collection savedRollUp;

    private RollUpServiceDelegate rollUpServiceDelegate;

    // private MenuMineSessionContextWrapper menuMineSessionContextWrapper;

    /*
     * Delegates
     */
    private MasterFoodServiceDelegate masterFoodServiceDelegate;

    private ChainServiceDelegate chainServiceDelegate;

    // private SavedQueryServiceDelegateImpl savedQueryServiceDelegate;

    /*
     * Display fields
     */
    private MenuMineDisplayOptions menuMineDisplayOptions = new MenuMineDisplayOptions();

    private MenuMineGraphOptions menuMineGraphOptions = new MenuMineGraphOptions();

    private MenuMineCrossTabulationOptions menuMineCrossTabulationOptions = new MenuMineCrossTabulationOptions();

    private String spreadsheetName;

    private String submitOptions;

    private Collection results = null;

    private int progress;

    /*
     * 2006-03-10 RSC This is to help with menuing.
     */
    private String specialFunction;
    /*
     * nick 3-31-04 when we submit we want to remember which tab we were in.
     * This allows us to set the postAction param in the xwork so that we submit
     * to the correct tab. We default to menumine.action.
     */
    private String postAction = "menumine.action";

    private Long count;

    
    private static Log log = LogFactory.getLog(AbstractMenuMineDisplayAction.class
            .getName());

    public String getTimestamp() {
        return new Date().toString();
    }

    public String execute() throws Exception {

//        TimerUtil abstractTimer = TimerUtil.getInstanceAndStart("AbstractMenuMineDisplay");
        /*
         * 2005-9-29 By just useing the options in the session directly we can
         * save a lot of swaping between local and in session copy. This will
         * eliminate potential confusion and errors.
         * 
         */
        // if (this.getSubmitOptions() == null
        // && this.getMenuMineSessionContextWrapper()
        // .getLastGraphOptions() != null) {
        // this.setMenuMineGraphOptions(this
        // .getMenuMineSessionContextWrapper().getLastGraphOptions());
        // }
        // if (this.getSubmitOptions() == null
        // && this.getMenuMineSessionContextWrapper()
        // .getLastCrossTabulationOptions() != null) {
        //         
        // this.setMenuMineCrossTabulationOptions(this
        // .getMenuMineSessionContextWrapper()
        // .getLastCrossTabulationOptions());
        // }
        if (this.getSubmitOptions() == null
                && this.getMenuMineSessionContextWrapper()
                        .getLastDisplayOptions() != null) {
            this
                    .setMenuMineDisplayOptions(this
                            .getMenuMineSessionContextWrapper()
                            .getLastDisplayOptions());
        }
        
        if (this.getSubmitOptions() == null
                && this.getMenuMineSessionContextWrapper()
                        .getLastGraphOptions() != null) {
            this
                    .setMenuMineGraphOptions(this
                            .getMenuMineSessionContextWrapper()
                            .getLastGraphOptions());
        }

        // this.getResults();

        /*
         * If they requested to change the roll Up, lets do it!
         */
        String rollUpName = this.getMenuMineGraphOptions()
                .getRollUpToLoadName();
        if (rollUpName != null && rollUpName.equals("--")) {
            this.getMenuMineSessionContextWrapper().resetRollUpOptions();
            /*
             * We don't want to reset on every request, so we need to reset the
             * name.
             */
            this.getMenuMineGraphOptions().setRollUpToLoadName(null);
        } else {

            RollUpOptions currentRollUp = this
                    .getMenuMineSessionContextWrapper().getRollUpOptions();
            if (rollUpName != null && rollUpName.length() > 0) {
                if (currentRollUp == null || currentRollUp.getName() == null
                        || !currentRollUp.getName().equals(rollUpName)) {
                    for (Iterator iter = this.getSavedRollUps().iterator(); iter
                            .hasNext();) {
                        RollUpOptions element = (RollUpOptions) iter.next();
                        if (element.getName() != null
                                && element.getName().equals(rollUpName)) {
                            this.getMenuMineSessionContextWrapper()
                                    .setRollUpOptions(element);
                        }
                    }
                }
            }
        }

        /*
         * Make sure if we changed the options, it gets saved.
         */
        this.getMenuMineSessionContextWrapper().setLastDisplayOptions(
                this.getMenuMineDisplayOptions());

//        abstractTimer.stop();
        
        return SUCCESS;
    }

    public int getProgress() {
        return progress;
    }

    // public Collection getLastQuerySummary() {
    // return this.getMasterFoodFilterParameters()
    // .getMasterFoodFilterParameters().getSummary();
    // }

    public String getPostAction() {
        return postAction;
    }

    public void setPostAction(String postAction) {
        this.postAction = postAction;
    }

    public Long getCount() {

        log.debug("getting count (current: ) " + count);
        
        if (count == null) {
            try {

                MasterFoodFilterParameters filterParams = this
                        .getLastMasterFoodFilterParameters()
                        .getMasterFoodFilterParameters();
                MineFields currentMineFields = this
                        .getMenuMineSessionContextWrapper().getMineFields();

                currentMineFields.applyHiddenParams(filterParams);

                count = this.getMasterFoodServiceDelegate().getCount(
                        filterParams);

            } catch (MasterFoodSearchException e) {
                this.addActionError("Error finding count.");
                e.printStackTrace();
                return new Long(0);
            }
        }

        log.debug("count is retreived. (" + count + ")");
        
        return count;

    }

    /*
     * We check the actual results to see if it is larger then the limit. We
     * also check to see if we will be forcing a limit.
     * 
     * 2006-03-21 RSC Removing a limit.
     */
//    public boolean isBelowCountLimit() {
//        if (this.getCount() != null
//                && this.getCount().doubleValue() > this.COUNT_LIMIT
//                && (this.getLastMasterFoodFilterParameters().getLimit() == null || this
//                        .getLastMasterFoodFilterParameters().getLimit()
//                        .longValue() > COUNT_LIMIT)) {
//            return false;
//        }
//        return true;
//    }

    public Collection getResults() {

        if (this.results == null)
            this.results = generateResults();

        return this.results;

    }

    private Collection generateResults() {

        log.debug("starting the generate raw results");
        
        Collection ret = null;

        if (this.getMenuMineDisplayOptions().getDisplayType().equals(
                "Display Spreadsheet")) {
            this.getLastMasterFoodFilterParameters().setLimit(new Long(500));
        }
        /*
         * We do not want to ever attempt to get results over this limit, unless
         * we are imposing an artificial limit.
         * 
         * 2006-03-21 RSC Removing the limit for all actions per Joe.
         */
//        if (!this.isBelowCountLimit()) {
//            return null;
//        }

        /*
         * Check to see if we have one cached. If not resuts will remain null.
         * 
         * 2006-02-06 RSC Getting rid of query caching.
         * 
         */
//        if (this.getCompletedQueryManager() != null
//                && this.getMenuMineSessionContextWrapper()
//                        .getLastQueryResultTicket() != null) {
//            ret = this.getCompletedQueryManager().getCachedQueryResults(
//                    this.getMenuMineSessionContextWrapper()
//                            .getLastQueryResultTicket());
//        }

        /*
         * NAH Since we may endup with the query being modified internaly, the
         * cached results may not represent the query so we check it against the
         * expected count. The count is always found with the current query.
         * 
         * 
         */
        if (ret == null || ret.size() != this.getCount().intValue()) {
            // long timeStart = System.currentTimeMillis();
            try {
                /*
                 * TODO this should be moved to the Spreadsheet action
                 */

                MasterFoodFilterParameters filterParams = this
                        .getLastMasterFoodFilterParameters()
                        .getMasterFoodFilterParameters();

                MineFields currentMineFields = this
                        .getMenuMineSessionContextWrapper().getMineFields();
                currentMineFields.applyHiddenParams(filterParams);

                /*
                 * make sure all of the fields we need to display are selected.
                 */
                new FieldsToDisplayBeanBuilder().decorateParams(this
                        .getMenuMineSessionContextWrapper()
                        .getLastFieldsToDisplay(), filterParams);

                /*
                 * handle the sorting
                 */
                filterParams.setOrderBy(this.getMenuMineDisplayOptions()
                        .getSortBy());
                
                if (ASC
                        .equals(this.getMenuMineDisplayOptions().getSortType()))
                    filterParams.setSortAsc(true);
                else
                    filterParams.setSortAsc(false);

                /*
                 * 2006-01-24 RSC Builds the query.
                 */
                // results =
                // this.getMasterFoodServiceDelegate().searchMasterFood(filterParams);
                ret = this.getMasterFoodServiceDelegate()
                        .searchMasterFoodByHQLConjunction(filterParams);

                if (this.getMenuMineDisplayOptions().getDisplayType().equals(
                        "Display Spreadsheet")) {
                    this.getLastMasterFoodFilterParameters().setLimit(null);
                }

                // long timeEnd = System.currentTimeMillis();
                // log.info("Retrieved results in: " + (timeEnd - timeStart));
            } catch (MasterFoodSearchException e) {
                e.printStackTrace();
                this.addActionError("Unknown error encountered during query."
                        + e.getMessage());
                ret = null;
            }


        }

        
        log.info("completed generating results");
        
        return ret;
    }

    protected void dumpResults() {
        this.results = null;
    }

    protected MasterFoodFilterParametersWrapper getLastMasterFoodFilterParameters() {
        return this.getMenuMineSessionContextWrapper().getLastFilterWrapper();
    }

    public MasterFoodServiceDelegate getMasterFoodServiceDelegate() {
        return masterFoodServiceDelegate;
    }

    public void setMasterFoodServiceDelegate(
            MasterFoodServiceDelegate masterFoodServiceDelegate) {
        this.masterFoodServiceDelegate = masterFoodServiceDelegate;
    }

    protected FieldsToDisplayBean getLastFieldsToDisplay() {
        return this.getMenuMineSessionContextWrapper().getLastFieldsToDisplay();
    }

    public MenuMineDisplayOptions getMenuMineDisplayOptions() {
        return menuMineDisplayOptions;
    }

    public void setMenuMineDisplayOptions(
            MenuMineDisplayOptions menuMineDisplayOptions) {
        this.menuMineDisplayOptions = menuMineDisplayOptions;
    }

    public MenuMineGraphOptions getMenuMineGraphOptions() {
        // return menuMineGraphOptions;
        return this.getMenuMineSessionContextWrapper().getLastGraphOptions();
    }

    public void setMenuMineGraphOptions(
            MenuMineGraphOptions menuMineGraphOptions) {
        this.menuMineGraphOptions = menuMineGraphOptions;
    }

    public String getSpreadsheetName() {
         return spreadsheetName;
//        return this.getMenuMineSessionContextWrapper().getSavedQuery()
//                .getName();
    }

    public void setSpreadsheetName(String spreadsheetName) {
        this.spreadsheetName = spreadsheetName;

    }

    // public void setSavedQueryServiceDelegate(
    // SavedQueryServiceDelegateImpl savedQueryServiceDelegate) {
    // this.savedQueryServiceDelegate = savedQueryServiceDelegate;
    // }
    //
    // private SavedQueryServiceDelegate getSavedQueryServiceDelegate() {
    // return savedQueryServiceDelegate;
    // }

    public MenuMineCrossTabulationOptions getMenuMineCrossTabulationOptions() {
        // return menuMineCrossTabulationOptions;
        return this.getMenuMineSessionContextWrapper()
                .getLastCrossTabulationOptions();
    }

    public void setMenuMineCrossTabulationOptions(
            MenuMineCrossTabulationOptions menuMineCrossTabulationOptions) {
        this.menuMineCrossTabulationOptions = menuMineCrossTabulationOptions;
    }

    public String getSubmitOptions() {
        return submitOptions;
    }

    public void setSubmitOptions(String submitOptions) {
        this.submitOptions = submitOptions;
    }

    public long getReportSizeLimit() {
        return COUNT_LIMIT;
    }

    public Collection getSavedRollUps() {

        log.debug("Getting saved roll ups " + savedRollUp);
        
        if (savedRollUp == null && this.getRollUpServiceDelegate() != null) {
            try {
                /*
                 * 2006-02-06 RSC Really all I need on this is the name and
                 * possible the id.
                 */
//                savedRollUp = this.getRollUpServiceDelegate()
//                        .getByUserAndGroup(
//                                this.getMenuMineSessionContextWrapper()
//                                        .getMenuMineSessionContext()
//                                        .getAuthenticatedUser().getUser());

                savedRollUp = this.getRollUpServiceDelegate().getByUser(
                        this.getMenuMineSessionContextWrapper()
                                .getMenuMineSessionContext()
                                .getAuthenticatedUser().getUsername());

            } catch (RollUpServiceDelegateException e) {
                this.addActionError("Error retrieving saved roll ups");
                e.printStackTrace();
            }
        }

        /*
         * If we have not saved the current roll Up we want to include it in tge
         * current list, so we don't kick it out when we select ---No RollUp---
         */

        RollUpOptions currentRollUp = this.getMenuMineSessionContextWrapper()
                .getRollUpOptions();

        /*
         * 2006-05-04 RSC doesn't always initialize properly.  This is a failsafe.
         */
        if (savedRollUp == null) {
            savedRollUp = new ArrayList();
        }
        
        if (currentRollUp.getId() == null) {
            savedRollUp.add(currentRollUp);
        }
        
        log.debug("completed getting saved roll ups");
        
        return savedRollUp;
    }

    public Collection getAllChainList() {
        log.debug("getting the chain list.");
        return this.getChainServiceDelegate().search(
                new ChainFilterParameters());
    }

    public RollUpServiceDelegate getRollUpServiceDelegate() {
        return rollUpServiceDelegate;
    }

    public void setRollUpServiceDelegate(
            RollUpServiceDelegate rollUpServiceDelegate) {
        this.rollUpServiceDelegate = rollUpServiceDelegate;
    }

    /*
     * 2006-02-06 RSC
     */
//    public CompletedQueryManagerImpl getCompletedQueryManager() {
//        return completedQueryManager;
//    }
//
//    public void setCompletedQueryManager(
//            CompletedQueryManagerImpl completedQueryManager) {
//        this.completedQueryManager = completedQueryManager;
//    }

    public ChainServiceDelegate getChainServiceDelegate() {
        return chainServiceDelegate;
    }

    public void setChainServiceDelegate(
            ChainServiceDelegate chainServiceDelegate) {
        this.chainServiceDelegate = chainServiceDelegate;
    }

    public String getSpecialFunction() {
        return specialFunction;
    }

    public void setSpecialFunction(String specialFunction) {
        this.specialFunction = specialFunction;
    }

    protected long getQueryRecordLimit() {
        return COUNT_LIMIT;
    }



}