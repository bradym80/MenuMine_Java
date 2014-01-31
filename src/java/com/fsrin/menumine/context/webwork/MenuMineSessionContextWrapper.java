/*
 * Created on 2005-1-14
 *
 */
package com.fsrin.menumine.context.webwork;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fsrin.menumine.authorization.AuthorizationBean;
import com.fsrin.menumine.common.SpringBeanBroker;
import com.fsrin.menumine.common.crud.xwork.ErrorContext;
import com.fsrin.menumine.common.delete.DeleteContext;
import com.fsrin.menumine.common.util.KeyValueVO;
import com.fsrin.menumine.context.MenuMineApplicationContext;
import com.fsrin.menumine.context.MenuMineSessionContext;
import com.fsrin.menumine.context.MenuMineSessionProperties;
import com.fsrin.menumine.core.chainstat.ChainStatFilterParameters;
import com.fsrin.menumine.core.menubook.xwork.MenuBookContext;
import com.fsrin.menumine.core.menumine.FieldEnum;
import com.fsrin.menumine.core.menumine.FieldsToDisplayBean;
import com.fsrin.menumine.core.menumine.rollup.RollUpOptions;
import com.fsrin.menumine.core.menumine.savedquery.SavedQuery;
import com.fsrin.menumine.core.menumine.savedquery.SavedQueryServiceDelegate;
import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableIF;
import com.fsrin.menumine.core.menumine.webwork.MasterFoodFilterParametersWrapper;
import com.fsrin.menumine.core.menumine.webwork.MasterFoodFilterParametersWrapperImpl;
import com.fsrin.menumine.core.menumine.webwork.MenuMineCrossTabulationOptions;
import com.fsrin.menumine.core.menumine.webwork.MenuMineDisplayOptions;
import com.fsrin.menumine.core.menumine.webwork.MenuMineGraphOptions;
import com.fsrin.menumine.core.minefields.MenuMineFields;
import com.fsrin.menumine.core.minefields.MineFields;
import com.fstx.stdlib2.authen.AuthenticatedUser;
import com.fstx.stdlib2.authen.users.UserGroup;
import com.fstx.stdlib2.authen.users.UserRole;
import com.fstx.stdlib2.author.Authorizer;

/**
 * @author Nick
 * 
 */
public class MenuMineSessionContextWrapper implements Serializable {

    private static final Log log = LogFactory
            .getLog(MenuMineSessionContextWrapper.class);

    private ErrorContext errorContext = new ErrorContext();

    private MenuMineSessionContext menuMineSessionContext;

    private MenuBookContext menuBookContext = new MenuBookContext();

    private StatisticalTableIF lastShareTable;

    private AuthorizationBean authorizationBean;

    /*
     * This is the key we use to pick up the results for the last query we ran.
     * 
     */
    private Long lastQueryResultTicket;

    /*
     * What fields should we be showing? MenuMine, DessertMine, CustomeMine,
     * Ingred Mine???
     */
    private MineFields mineFields = new MenuMineFields();

    /*
     * This holds the last values selected. The graph and Excel sheet need that
     * so we don't have to pass the params multiple times.
     * 
     * We may replace this with a more sophisticated history and/or saves
     * querys.
     */
    // private MasterFoodFilterParameters lastFilter;
    /*
     * 2006-03-16 RSC Reactivated.
     */
    private MasterFoodFilterParametersWrapper lastFilterWrapper = new MasterFoodFilterParametersWrapperImpl();

    /*
     * 2006-03-21 RSC Reactivated.
     */
    private FieldsToDisplayBean lastFieldsToDisplay = new FieldsToDisplayBean();

//    private SavedQuery savedQuery = new SavedQuery();

    /*
     * This is a flag, to test if we have sent a query yet, so was can short cut
     * to INPUT.
     */
    private boolean firstQuerySent = false;

    private MenuMineGraphOptions lastGraphOptions = new MenuMineGraphOptions();

    private MenuMineCrossTabulationOptions lastCrossTabulationOptions = new MenuMineCrossTabulationOptions();

    private ChainStatFilterParameters lastChainStatFilterParameters;

    private DeleteContext deleteContext;

    private MenuMineDisplayOptions menuMineDisplayOptions;

    private RollUpOptions rollUpOptions;

    private UserGroup userGroup;

    private Map shareTableMap;

    public Map getShareTableMap() {
        if (shareTableMap == null) {
            shareTableMap = new HashMap();
        }
        return shareTableMap;
    }

    public void setShareTableMap(Map shareTableMap) {
        this.shareTableMap = shareTableMap;
    }

    /*
     * 2006-01-30 RSC OK to remove per Matt
     */
    // private ForumContext forumContext;
    // private String rollUpFilter;
    public MenuMineSessionContextWrapper() {
        this.menuMineSessionContext = (MenuMineSessionContext) SpringBeanBroker
                .getBeanFactory().getBean(
                        MenuMineSessionContext.SPRING_BEAN_NAME);
    }

    public MenuMineSessionContextWrapper(
            MenuMineSessionContext menuMineSessionContext) {
        this.menuMineSessionContext = menuMineSessionContext;
    }

    /*
     * nick 2005-1-31 We need to test if a user has admin rights. This we
     * created for the Dashboard so we can give admin users the Administration
     * option.
     * 
     */
    public boolean isAdminRights() {
        if (this.getAuthenticatedUser() != null
                && this.getAuthenticatedUser().getUser() != null) {
            return this.getAuthenticatedUser().getUser().getRoleName().equals(
                    UserRole.ADMIN.getName());
        }
        return false;
    }

    /**
     * @return
     */
    public AuthenticatedUser getAuthenticatedUser() {
        return menuMineSessionContext.getAuthenticatedUser();
    }

    /**
     * @return
     */
    public Authorizer getAuthorizer() {
        return menuMineSessionContext.getAuthorizer();
    }

    /**
     * @return
     */
    public MenuMineApplicationContext getMenuMineApplicationContext() {
        return menuMineSessionContext.getMenuMineApplicationContext();
    }

    /**
     * @return
     */
    public MenuMineSessionProperties getSessionProperties() {
        return menuMineSessionContext.getSessionProperties();
    }

    /**
     * @param authorizer
     */
    public void setAuthorizer(Authorizer authorizer) {
        menuMineSessionContext.setAuthorizer(authorizer);
    }

    /**
     * @param authenticatedUser
     */
    public void setAuthenticatedUser(AuthenticatedUser authenticatedUser) {
        menuMineSessionContext.setAuthenticatedUser(authenticatedUser);
    }

    /**
     * @return
     */
    public boolean isValid() {
        return menuMineSessionContext.isValid();
    }

    /**
     * @return
     */
    public MenuMineSessionContext getMenuMineSessionContext() {
        return menuMineSessionContext;
    }

    public MenuMineGraphOptions getLastGraphOptions() {
        return lastGraphOptions;
    }

    public void setLastGraphOptions(MenuMineGraphOptions lastGraphOptions) {
        this.lastGraphOptions = lastGraphOptions;
    }

    public FieldsToDisplayBean getLastFieldsToDisplay() {

        log.debug("looking for last fields to display");
        return lastFieldsToDisplay;
        // return this.getSavedQuery().getFieldsToDisplayBean();
    }

    public void setLastFieldsToDisplay(FieldsToDisplayBean lastFieldsToDisplay) {
        this.lastFieldsToDisplay = lastFieldsToDisplay;
        // this.getSavedQuery().setFieldsToDisplayBean(lastFieldsToDisplay);
    }

    public ChainStatFilterParameters getLastChainStatFilterParameters() {
        return lastChainStatFilterParameters;
    }

    public void setLastChainStatFilterParameters(
            ChainStatFilterParameters lastChainStatFilterParameters) {
        this.lastChainStatFilterParameters = lastChainStatFilterParameters;
    }

    public MasterFoodFilterParametersWrapper getLastFilterWrapper() {
        return lastFilterWrapper;

        /*
         * 2006-03-16 RSC Saved query was doing all of the work. Switched back
         * to the lastFilterWrapper, which had been commented out.
         */
        // log.debug("getting the last filter wrapper");
        // return new MasterFoodFilterParametersWrapperImpl(this.getSavedQuery()
        // .getMasterFoodFilterParameters());
    }

    public void setLastFilterWrapper(
            MasterFoodFilterParametersWrapper lastFilterWrapper) {
        this.lastFilterWrapper = lastFilterWrapper;
        /*
         * 2006-03-16 RSC
         */
        // this.getSavedQuery().setMasterFoodFilterParameters(
        // lastFilterWrapper.getMasterFoodFilterParameters());
    }

    public MenuMineCrossTabulationOptions getLastCrossTabulationOptions() {
        return lastCrossTabulationOptions;
    }

    public void setLastCrossTabulationOptions(
            MenuMineCrossTabulationOptions lastCrossTabulationOptions) {
        this.lastCrossTabulationOptions = lastCrossTabulationOptions;
    }

    public MenuMineDisplayOptions getLastDisplayOptions() {

        return menuMineDisplayOptions;
    }

    public void setLastDisplayOptions(
            MenuMineDisplayOptions menuMineDisplayOptions) {

        this.menuMineDisplayOptions = menuMineDisplayOptions;
    }

    public MenuBookContext getMenuBookContext() {
        return menuBookContext;
    }

    public void setMenuBookContext(MenuBookContext menuBookContext) {
        this.menuBookContext = menuBookContext;
    }


    public StatisticalTableIF getLastShareTable() {
        return lastShareTable;
    }

    public void setLastShareTable(StatisticalTableIF lastShareTable) {
        this.lastShareTable = lastShareTable;
    }

    // public String getRollUpFilter() {
    // return rollUpFilter;
    // }
    //
    // public void setRollUpFilter(String rollUpFilter) {
    // this.rollUpFilter = rollUpFilter;
    // }
    
    public RollUpOptions getRollUpOptions() {
        log.debug("attempting to get roll up options");
        if (this.rollUpOptions == null) {
            this.resetRollUpOptions();
        } else {
            /*
             * 2006-02-17 RCS shouldn't linger if they're on a different group
             * by.
             */
            
            FieldEnum rollUpTarget = this.rollUpOptions.getTargetField();
            
            FieldEnum graphByField = this.lastGraphOptions.getGraphByFieldEnum();

                
                if (rollUpTarget != null && graphByField != null && !rollUpTarget.getOgnlName().equals(graphByField.getOgnlName())) {
                    this.resetRollUpOptions();
                }
                

        }

        return rollUpOptions;
    }

    public void setRollUpOptions(RollUpOptions rollUpOptions) {
        this.rollUpOptions = rollUpOptions;
    }

    public UserGroup getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(UserGroup userGroup) {
        this.userGroup = userGroup;
    }

    // public ForumContext getForumContext() {
    // if (forumContext == null) {
    // forumContext = new ForumContext();
    // }
    // return forumContext;
    // }
    //
    // public void setForumContext(ForumContext forumContext) {
    // this.forumContext = forumContext;
    // }

    public MineFields getMineFields() {
        return mineFields;
    }

    public void setMineFields(MineFields mineFields) {
        this.mineFields = mineFields;
    }

    public boolean isFirstQuerySent() {
        return firstQuerySent;
    }

    public void setFirstQuerySent(boolean firstQuerySent) {
        this.firstQuerySent = firstQuerySent;
    }

    public void resetRollUpOptions() {

        RollUpOptions roll = new RollUpOptions();
        if (this.getUserGroup() != null) {
            roll.setGroupName(this.getUserGroup().getName());
        }

        roll.setUserName(this.getAuthenticatedUser().getUsername());

        if (this.getLastGraphOptions() != null) {
            roll.setTargetFieldName(this.getLastGraphOptions()
                    .getGraphByField());
        }

        this.setRollUpOptions(roll);
    }

    public AuthorizationBean getAuthorizationBean() {
        return authorizationBean;
    }

    public void setAuthorizationBean(AuthorizationBean authorizationBean) {
        this.authorizationBean = authorizationBean;
    }

    public ErrorContext getErrorContext() {
        return errorContext;
    }

    public void setErrorContext(ErrorContext errorContext) {
        this.errorContext = errorContext;
    }


    public Long getLastQueryResultTicket() {
        return lastQueryResultTicket;
    }

    public void setLastQueryResultTicket(Long lastQueryResultTicket) {
        this.lastQueryResultTicket = lastQueryResultTicket;
    }

    public DeleteContext getDeleteContext() {
        return deleteContext;
    }

    public void setDeleteContext(DeleteContext deleteContext) {
        this.deleteContext = deleteContext;
    }
    
    public Collection getCategoryTemplates() throws Exception {
        
        
        SavedQueryServiceDelegate sqsd = SavedQueryServiceDelegate.factory.build();
        
        Collection queries = sqsd.getSimpleTemplates();
        
        Collection ret = new ArrayList();
        
        String currentHeader = "";
        
        for (Iterator iter = queries.iterator(); iter.hasNext();) {
            SavedQuery element = (SavedQuery) iter.next();
            
            if (!"".equals(element.getTemplateGroup())) {
                currentHeader = element.getTemplateGroup();
                ret.add(new KeyValueVO(new Long(0), currentHeader ));
            }
            
            ret.add(new KeyValueVO(element.getId(), element.getName()));
            
            
        }
        
        
        return ret;
    }
    
   /* private boolean Excel=false;
    
    public boolean getExcel(){
    	return this.Excel;
    }
    public void setExcel(boolean excel) {
    	this.Excel = excel;
    }*/
}