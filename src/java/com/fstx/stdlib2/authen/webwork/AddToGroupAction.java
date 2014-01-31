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
public class AddToGroupAction extends AbstractUserModifyContextAwareAction {

    private UserServiceDelegate userServiceDelegate;

    private UserGroupServiceDelegate userGroupServiceDelegate;

    private Long addTarget;

    public String execute() throws Exception {

        if (this.getAddTarget() == null) {
            return SUCCESS;
        }

        User user = this.getUserServiceDelegate().find(this.getAddTarget());

        this.getUserGroupServiceDelegate().join(user,
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

    public void setUserServiceDelegate(UserServiceDelegate userServiceDelegate) {
        this.userServiceDelegate = userServiceDelegate;
    }

    /**
     * @return Returns the target.
     */
    public Long getAddTarget() {
        return addTarget;
    }

    /**
     * @param target
     *            The target to set.
     */
    public void setAddTarget(Long target) {
        this.addTarget = target;
    }

//    public UserModifyContext getUserModifyContext() {
//        UserModifyContext context = UserModifyContext.factory.getContext();
//        return context;
//    }

    public UserGroupServiceDelegate getUserGroupServiceDelegate() {
        return userGroupServiceDelegate;
    }

    public void setUserGroupServiceDelegate(
            UserGroupServiceDelegate userGroupServiceDelegate) {
        this.userGroupServiceDelegate = userGroupServiceDelegate;
    }
}