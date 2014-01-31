/*
 * Created on June 2, 2005
 *

 */
package com.fstx.stdlib2.authen.webwork;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.fsrin.menumine.context.webwork.MenuMineSessionContextWrapper;
import com.fsrin.menumine.context.webwork.MenuMineSessionContextWrapperAware;
import com.fstx.stdlib2.authen.LoginHistory;
import com.fstx.stdlib2.authen.LoginHistoryBD;
import com.fstx.stdlib2.authen.LoginHistoryBusinessObject;
import com.fstx.stdlib2.authen.LoginHistoryException;
import com.opensymphony.xwork.ActionSupport;

/**
 * @author Nick
 *  
 */
public class LoginHistoryListAction extends ActionSupport implements
        MenuMineSessionContextWrapperAware {

    private MenuMineSessionContextWrapper menuMineSessionContextWrapper;

    private LoginHistoryBD loginHistoryBD;

    public Collection getLoginHistory() {
        Collection list = null;
        try {

            list = this.getLoginHistoryBD().list();
        } catch (LoginHistoryException e) {
            e.printStackTrace();
            return null;
        }

        Collection wrappedList = new ArrayList();

        for (Iterator iter = list.iterator(); iter.hasNext();) {
            LoginHistory element = (LoginHistory) iter.next();
            LoginHistoryBusinessObject bo = new LoginHistoryBusinessObject(
                    element);
            wrappedList.add(bo);

        }

        return wrappedList;
    }

    public MenuMineSessionContextWrapper getMenuMineSessionContextWrapper() {
        return menuMineSessionContextWrapper;
    }

    public void setMenuMineSessionContextWrapper(
            MenuMineSessionContextWrapper menuMineSessionContextWrapper) {
        this.menuMineSessionContextWrapper = menuMineSessionContextWrapper;
    }

    public LoginHistoryBD getLoginHistoryBD() {
        return loginHistoryBD;
    }

    public void setLoginHistoryBD(LoginHistoryBD loginHistoryBD) {
        this.loginHistoryBD = loginHistoryBD;
    }
}