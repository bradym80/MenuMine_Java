/*
 * Created on Aug 12, 2004
 *

 */
package com.fstx.stdlib2.authen.webwork;

import java.util.Collection;

import com.fstx.stdlib2.authen.users.User;
import com.fstx.stdlib2.authen.users.UserGroupServiceDelegate;
import com.fstx.stdlib2.authen.users.UserServiceDelegate;

/**
 * @author Nick
 *  
 */
public class RemoveFromGroupAction extends AbstractUserModifyContextAwareAction {

    private UserGroupServiceDelegate userGroupServiceDelegate;

    private UserServiceDelegate userServiceDelegate;

    private Long removeTarget;

    /*
     * (non-Javadoc)
     * 
     * @see com.opensymphony.xwork.Action#execute()
     */
    public String execute() throws Exception {

        if (this.getRemoveTarget() == null) {
            return SUCCESS;
        }

        User user = this.getUserServiceDelegate().find(this.getRemoveTarget());

        this.getUserGroupServiceDelegate().leave(user,
                this.getUserModifyContext().getUserGroup());

        return SUCCESS;
    }

    public Collection getMembers() {
        return this.getUserModifyContext().getUserGroupBusinessObject().getMembers();
    }

    public Collection getNonMembers() {
        return this.getUserModifyContext().getUserGroupBusinessObject().getNonMembers();
    }

    public UserServiceDelegate getUserServiceDelegate() {
        return userServiceDelegate;
    }

    public void setUserGroupServiceDelegate(
            UserGroupServiceDelegate userGroupServiceDelegate) {
        this.userGroupServiceDelegate = userGroupServiceDelegate;
    }

    public void setUserServiceDelegate(UserServiceDelegate userServiceDelegate) {
        this.userServiceDelegate = userServiceDelegate;
    }

    public UserGroupServiceDelegate getUserGroupServiceDelegate() {
        return userGroupServiceDelegate;
    }

    public Long getRemoveTarget() {
        return this.removeTarget;
    }

    public void setRemoveTarget(Long target) {
        this.removeTarget = target;
    }

//    public UserModifyContext getUserModifyContext() {
//        UserModifyContext context = UserModifyContext.factory.getContext();
//        return context;
//    }

}