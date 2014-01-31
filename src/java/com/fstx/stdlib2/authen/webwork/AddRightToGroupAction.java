/*
 * Created on Aug 12, 2004
 *

 */
package com.fstx.stdlib2.authen.webwork;

import com.fstx.stdlib2.authen.users.GroupRightServiceDelegate;
import com.fstx.stdlib2.author.AuthorizationManager;
import com.fstx.stdlib2.author.SecuredAction;
import com.fstx.stdlib2.author.SecuredActionEnum;

/**
 * @author Nick
 *  
 */
public class AddRightToGroupAction extends AbstractUserModifyContextAwareAction {

    private GroupRightServiceDelegate groupRightServiceDelegate;

    private String addTarget;

    public String execute() throws Exception {

        if (this.getAddTarget() == null) {
            return SUCCESS;
        }

        SecuredAction sa = SecuredActionEnum.getByName(this.getAddTarget());

        this.getGroupRightServiceDelegate().add(sa,
                this.getUserModifyContext().getUserGroup());

        AuthorizationManager.singleton.recycleAllPermissions();
        return SUCCESS;
    }

    /**
     * @return Returns the target.
     */
    public String getAddTarget() {
        return addTarget;
    }

    /**
     * @param target
     *            The target to set.
     */
    public void setAddTarget(String target) {
        this.addTarget = target;
    }

//    public UserModifyContext getUserModifyContext() {
//        UserModifyContext context = UserModifyContext.factory.getContext();
//        return context;
//    }

    public GroupRightServiceDelegate getGroupRightServiceDelegate() {
        return groupRightServiceDelegate;
    }

    public void setGroupRightServiceDelegate(
            GroupRightServiceDelegate groupRightServiceDelegate) {
        this.groupRightServiceDelegate = groupRightServiceDelegate;
    }
}