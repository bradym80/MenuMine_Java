/*
 * Created on Sep 10, 2004 by Reid
 */
package com.fsrin.menumine.authorization.xwork;

import com.fsrin.menumine.context.webwork.AbstractMenuMineSessionContextAwareAction;

/**
 * @author Reid
 */
public class AuthorizeAction extends AbstractMenuMineSessionContextAwareAction {

//    private MenuMineSessionContextWrapper menuMineSessionContextWrapper;

    public String execute() throws Exception {

        return SUCCESS;

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