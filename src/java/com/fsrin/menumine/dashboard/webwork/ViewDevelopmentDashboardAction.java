/*
 * Created on 2005-1-14 Nick
 */
package com.fsrin.menumine.dashboard.webwork;

import java.util.Collection;

import com.fsrin.menumine.context.webwork.AbstractMenuMineSessionContextAwareAction;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParametersImpl;
import com.fsrin.menumine.core.menumine.masterfood.MasterFoodServiceDelegateFactory;
import com.fsrin.menumine.core.menumine.savedquery.SavedQueryManager;

public class ViewDevelopmentDashboardAction extends AbstractMenuMineSessionContextAwareAction {

//    private MenuMineSessionContextWrapper menuMineSessionContextWrapper;

    private SavedQueryManager savedQueryManager;
    
    private Collection brag;

    public String execute() throws Exception {

        Collection brag = null;
        
        MasterFoodFilterParameters p = new MasterFoodFilterParametersImpl();
        p.getNewItemBrag().setEmpty(Boolean.FALSE);
        p.getMenuItem().setSelect(Boolean.TRUE);
        p.getItemDescription().setSelect(Boolean.TRUE);
        p.getOperationName().setSelect(Boolean.TRUE);
        p.getPrice2009().setSelect(Boolean.TRUE);
        //JDL 10-5-07
      //  p.getPrice2006().setSelect(Boolean.TRUE);
        
        brag = MasterFoodServiceDelegateFactory.factory.build().searchMasterFoodByHQLConjunction(p);
        
        this.setBrag(brag);
        
        return SUCCESS;
    }



    public Collection getUserQueries() {

        return this.getSavedQueryManager().getUserQueries(
                this.getMenuMineSessionContextWrapper().getAuthenticatedUser());

    }

    public Collection getGroupQueries() {

        return this.getSavedQueryManager().getGroupQueries(
                this.getMenuMineSessionContextWrapper().getAuthenticatedUser());
    }

    public SavedQueryManager getSavedQueryManager() {
        return savedQueryManager;
    }

    public void setSavedQueryManager(SavedQueryManager savedQueryManager) {
        this.savedQueryManager = savedQueryManager;
    }



    /**
     * @return Returns the brag.
     */
    public Collection getBrag() {
        return brag;
    }



    /**
     * @param brag The brag to set.
     */
    public void setBrag(Collection brag) {
        this.brag = brag;
    }
}