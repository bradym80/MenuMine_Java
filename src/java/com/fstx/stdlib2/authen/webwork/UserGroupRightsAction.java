/*
 * Created on Aug 12, 2004
 *

 */
package com.fstx.stdlib2.authen.webwork;

import java.util.Collection;

import com.fstx.stdlib2.authen.users.UserGroup;
import com.fstx.stdlib2.authen.users.UserGroupServiceDelegate;

/**
 * @author Nick
 *  
 */
public class UserGroupRightsAction extends AbstractUserModifyContextAwareAction {

    private UserGroupServiceDelegate userGroupServiceDelegate;

//    private MenuMineSessionContextWrapper menuMineSessionContextWrapper;

    private Long target;

    /**
     * @return Returns the target.
     */
    public Long getTarget() {
        return target;
    }

    /**
     * @param target
     *            The target to set.
     */
    public void setTarget(Long target) {
        this.target = target;
    }

//    public UserModifyContext getUserModifyContext() {
//        UserModifyContext context = UserModifyContext.factory.getContext();
//        return context;
//    }

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

    /*
     * (non-Javadoc)
     * 
     * @see com.opensymphony.xwork.Action#execute()
     */
    public String execute() throws Exception {

        if (this.getTarget() != null) {
            UserGroup userGroup = this.getUserGroupServiceDelegate().find(
                    this.getTarget());
            this.getUserModifyContext().setUserGroup(userGroup);
            return INPUT;
        }

        return INPUT;
    }

    public Collection getRights() {
        return this.getUserModifyContext().getUserGroupBusinessObject().getRights();
    }

    public Collection getNonRights() {
        return this.getUserModifyContext().getUserGroupBusinessObject().getNonRights();
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