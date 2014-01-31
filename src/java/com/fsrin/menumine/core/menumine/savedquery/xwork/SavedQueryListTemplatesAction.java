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
public class SavedQueryListTemplatesAction extends
        AbstractMenuMineSessionContextAwareAction {

    // private MenuMineSessionContextWrapper menuMineSessionContextWrapper;

    private SavedQueryServiceDelegateImpl savedQueryServiceDelegate;

    private Collection savedQueries = null;
    
    private String submit;

    public String execute() throws Exception {


        try {

            savedQueries = this.getSavedQueryServiceDelegate().getSimpleTemplates();
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