/*
 * Created on Jul 12, 2005
 *
 * 
 */
package com.fsrin.menumine.context.webwork;

import com.opensymphony.xwork.ActionSupport;

/**
 * 2006-01-12 declared as abstract, updated name, started propaging throughout code.
 * 
 * @author Reid
 * @author Nick
 * 
 *  
 */
public abstract class AbstractMenuMineSessionContextAwareAction extends ActionSupport implements
        MenuMineSessionContextWrapperAware {

    private MenuMineSessionContextWrapper menuMineSessionContextWrapper;

    public MenuMineSessionContextWrapper getMenuMineSessionContextWrapper() {
        return menuMineSessionContextWrapper;
    }

    public void setMenuMineSessionContextWrapper(
            MenuMineSessionContextWrapper menuMineSessionContextWrapper) {
        this.menuMineSessionContextWrapper = menuMineSessionContextWrapper;
    }

}