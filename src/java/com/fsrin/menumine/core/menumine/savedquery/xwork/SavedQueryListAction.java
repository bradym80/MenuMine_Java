/*
 * Created on Jan 20, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.savedquery.xwork;

import java.util.Collection;

import com.fsrin.menumine.context.webwork.AbstractMenuMineSessionContextAwareAction;
import com.fsrin.menumine.core.menumine.savedquery.SavedQueryServiceDelegateException;
import com.fsrin.menumine.core.menumine.savedquery.SavedQueryServiceDelegateImpl;
import com.opensymphony.xwork.Action;

/**
 * @author Nick
 * 
 * 
 */
public class SavedQueryListAction extends
        AbstractMenuMineSessionContextAwareAction {

    // private MenuMineSessionContextWrapper menuMineSessionContextWrapper;

    private SavedQueryServiceDelegateImpl savedQueryServiceDelegate;

    private Collection savedQueries = null;

    Collection delete;
    
    private String submit;

    public String execute() throws Exception {

        try {

            savedQueries = this.getSavedQueryServiceDelegate().getSimpleByUser(
                    this.getMenuMineSessionContextWrapper()
                            .getAuthenticatedUser().getUsername());
        } catch (SavedQueryServiceDelegateException e) {
            e.printStackTrace();
        }

        return Action.SUCCESS;
    }



    public Collection getSavedQueries() {


        return savedQueries;
    }





    



    public SavedQueryServiceDelegateImpl getSavedQueryServiceDelegate() {
        return savedQueryServiceDelegate;
    }

    public void setSavedQueryServiceDelegate(
            SavedQueryServiceDelegateImpl savedQueryServiceDelegate) {
        this.savedQueryServiceDelegate = savedQueryServiceDelegate;
    }

    public String getSubmit() {
        return submit;
    }

    public void setSubmit(String submit) {
        this.submit = submit;
    }
}