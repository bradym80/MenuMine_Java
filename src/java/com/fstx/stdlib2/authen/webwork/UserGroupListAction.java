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
import com.fstx.stdlib2.authen.users.UserGroupServiceDelegate;
import com.opensymphony.xwork.ActionSupport;

/**
 * @author Nick
 * 
 */
public class UserGroupListAction extends ActionSupport implements
        MenuMineSessionContextWrapperAware {

    private MenuMineSessionContextWrapper menuMineSessionContextWrapper;

    private UserGroupServiceDelegate userGroupServiceDelegate;

    public Collection getGroups() {
        /*
         * 2006-04-04 RSC Don't need these since we're sorting via SQL.
         */
        //TreeSet sorted = new TreeSet(new MMSorter().getAscending("name", "id"));

        Collection raw = userGroupServiceDelegate.getAll();

        //sorted.addAll(raw);

        return raw;
    }

    /**
     * @return Returns the userServiceDelegate.
     */
    public UserGroupServiceDelegate getUserGroupServiceDelegate() {
        return userGroupServiceDelegate;
    }

    /**
     * @param userServiceDelegate
     *            The userServiceDelegate to set.
     */
    public void setUserGroupServiceDelegate(
            UserGroupServiceDelegate userGroupServiceDelegate) {
        this.userGroupServiceDelegate = userGroupServiceDelegate;
    }

    public MenuMineSessionContextWrapper getMenuMineSessionContextWrapper() {
        return menuMineSessionContextWrapper;
    }

    public void setMenuMineSessionContextWrapper(
            MenuMineSessionContextWrapper menuMineSessionContextWrapper) {
        this.menuMineSessionContextWrapper = menuMineSessionContextWrapper;
    }
}