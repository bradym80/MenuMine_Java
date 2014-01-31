/*
 * Created on 2005-1-18
 *
 */
package com.fsrin.menumine.core.menumine.rollup.xwork;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fsrin.menumine.context.webwork.AbstractMenuMineSessionContextAwareAction;
import com.fsrin.menumine.core.menumine.rollup.RollUpServiceDelegate;
import com.fsrin.menumine.core.menumine.rollup.RollUpServiceDelegateException;

/**
 * @author Nick
 * @version 1
 */

public class ListSavedRollUpsAction extends AbstractMenuMineSessionContextAwareAction {

    private RollUpServiceDelegate rollUpServiceDelegate;

    Log log = LogFactory.getLog(ListSavedRollUpsAction.class.getName());
    
    private Collection savedRollUp;
    
//    private MenuMineSessionContextWrapper menuMineSessionContextWrapper;

    public String execute() throws Exception {
        return SUCCESS;
    }

    

    public Collection getSavedRollUps() {
        if (savedRollUp == null) {
            /*
             * 2006-02-06 RSC Changed to get simple.
             */
            try {
                savedRollUp = this.getRollUpServiceDelegate().getSimpleByUser(
                        this.getMenuMineSessionContextWrapper()
                                .getMenuMineSessionContext()
                                .getAuthenticatedUser().getUsername());
            } catch (RollUpServiceDelegateException e) {
                this.addActionError("Error retrieving saved roll ups");
                e.printStackTrace();
            }
        }

        return savedRollUp;
    }

    

    public RollUpServiceDelegate getRollUpServiceDelegate() {
        return rollUpServiceDelegate;
    }

    public void setRollUpServiceDelegate(
            RollUpServiceDelegate rollUpServiceDelegate) {
        this.rollUpServiceDelegate = rollUpServiceDelegate;
    }

//    public MenuMineSessionContextWrapper getMenuMineSessionContextWrapper() {
//        return menuMineSessionContextWrapper;
//    }
//
//    public void setMenuMineSessionContextWrapper(
//            MenuMineSessionContextWrapper menuMineSessionContextWrapper) {
//        this.menuMineSessionContextWrapper = menuMineSessionContextWrapper;
//    }
}