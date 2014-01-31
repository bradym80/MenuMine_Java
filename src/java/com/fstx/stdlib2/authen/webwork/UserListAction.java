/*
 * Created on Aug 12, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.fstx.stdlib2.authen.webwork;

import java.util.Collection;

import com.fsrin.menumine.context.webwork.AbstractMenuMineSessionContextAwareAction;
import com.fstx.stdlib2.authen.users.UserFilterParameters;
import com.fstx.stdlib2.authen.users.UserRole;
import com.fstx.stdlib2.authen.users.UserServiceDelegate;
import com.opensymphony.xwork.Action;

/**
 * @author Nick
 * 
 */
public class UserListAction extends AbstractMenuMineSessionContextAwareAction implements UserListContextAware {

//    private MenuMineSessionContextWrapper menuMineSessionContextWrapper;

    private UserServiceDelegate userServiceDelegate;

    private UserListContext userListContext;
    
    private Collection users;
    
    public String execute() throws Exception {
        
        if (this.getUserListContext().getParams() == null) {
            this.getUserListContext().setParams(new UserFilterParameters());
            this.getUserListContext().getParams().setUserStatus("current");
        }
        
        
        this.setUsers(this.getUserServiceDelegate().find(this.getUserListContext().getParams()));
        
        
        return Action.SUCCESS;
    }
//    public Collection getUsers() {
//        try {
//            //return userServiceDelegate.getAll();
//            return userServiceDelegate.getAllCurrentUsers();
//        } catch (UserServiceDelegateException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    public Collection getExpiredUsers() {
//        try {
//            //return userServiceDelegate.getAll();
//            return userServiceDelegate.getAllExpiredUsers();
//        } catch (UserServiceDelegateException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
    
    public Collection getUserRoles() {
        return UserRole.getAll();
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

//    public MenuMineSessionContextWrapper getMenuMineSessionContextWrapper() {
//        return menuMineSessionContextWrapper;
//    }
//
//    public void setMenuMineSessionContextWrapper(
//            MenuMineSessionContextWrapper menuMineSessionContextWrapper) {
//        this.menuMineSessionContextWrapper = menuMineSessionContextWrapper;
//    }

    public UserListContext getUserListContext() {
        return userListContext;
    }

    public void setUserListContext(UserListContext userListContext) {
        this.userListContext = userListContext;
    }
    public Collection getUsers() {
        return users;
    }
    public void setUsers(Collection users) {
        this.users = users;
    }
}