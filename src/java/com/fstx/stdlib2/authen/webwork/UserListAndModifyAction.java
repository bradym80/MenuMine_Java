/*
 * Created on Aug 12, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.fstx.stdlib2.authen.webwork;

import java.util.Collection;

import com.fsrin.menumine.context.webwork.MenuMineSessionContextWrapper;
import com.fsrin.menumine.context.webwork.MenuMineSessionContextWrapperAware;
import com.fstx.stdlib2.authen.users.UserServiceDelegate;
import com.fstx.stdlib2.authen.users.UserServiceDelegateException;
import com.opensymphony.xwork.ActionSupport;

/**
 * @author Nick
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public class UserListAndModifyAction extends ActionSupport implements
        MenuMineSessionContextWrapperAware {

    private MenuMineSessionContextWrapper menuMineSessionContextWrapper;

    private UserServiceDelegate userServiceDelegate;

    public Collection getUsers() {
        try {
            return userServiceDelegate.getAll();
        } catch (UserServiceDelegateException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @return Returns the userServiceDelegate.
     */
    public UserServiceDelegate getUserServiceDelegate() {
        return userServiceDelegate;
    }

    /**
     * @param userServiceDelegate
     *            The userServiceDelegate to set.
     */
    public void setUserServiceDelegate(UserServiceDelegate userServiceDelegate) {
        this.userServiceDelegate = userServiceDelegate;
    }

    public MenuMineSessionContextWrapper getMenuMineSessionContextWrapper() {
        return menuMineSessionContextWrapper;
    }

    public void setMenuMineSessionContextWrapper(
            MenuMineSessionContextWrapper menuMineSessionContextWrapper) {
        this.menuMineSessionContextWrapper = menuMineSessionContextWrapper;
    }
}