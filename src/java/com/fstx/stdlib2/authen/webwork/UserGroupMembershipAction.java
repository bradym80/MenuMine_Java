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
public class UserGroupMembershipAction extends
        AbstractUserModifyContextAwareAction {

    // private MenuMineSessionContextWrapper menuMineSessionContextWrapper;

    public static final String SPRING_BEAN_NAME = "wwUserGroupMembership";

    private UserGroupServiceDelegate userGroupServiceDelegate;

//    private UserModifyContext userModifyContext;

    private Long target;

    private Collection members;

    private Collection nonmembers;

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

//    public UserModifyContext getContext() {
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

    public Collection getMembers() {
        return this.getUserModifyContext().getUserGroupBusinessObject().getMembers();
    }

    public Collection getNonMembers() {
        return this.getUserModifyContext().getUserGroupBusinessObject().getNonMembers();
    }

//    public UserModifyContext getUserModifyContext() {
//        return userModifyContext;
//    }
//
//    public void setUserModifyContext(UserModifyContext userModifyContext) {
//        this.userModifyContext = userModifyContext;
//    }

    // public MenuMineSessionContextWrapper getMenuMineSessionContextWrapper() {
    // return menuMineSessionContextWrapper;
    // }
    //
    // public void setMenuMineSessionContextWrapper(
    // MenuMineSessionContextWrapper menuMineSessionContextWrapper) {
    // this.menuMineSessionContextWrapper = menuMineSessionContextWrapper;
    // }
}