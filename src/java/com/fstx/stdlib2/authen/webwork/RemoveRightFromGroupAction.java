/*
 * Created on Aug 12, 2004
 *

 */
package com.fstx.stdlib2.authen.webwork;

import com.fstx.stdlib2.authen.users.GroupRight;
import com.fstx.stdlib2.authen.users.GroupRightServiceDelegate;
import com.fstx.stdlib2.author.AuthorizationManager;

/**
 * @author Nick
 *  
 */
public class RemoveRightFromGroupAction extends AbstractUserModifyContextAwareAction {

    private GroupRightServiceDelegate groupRightServiceDelegate;

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

        GroupRight gr = this.getGroupRightServiceDelegate().find(
                this.getRemoveTarget());
        this.getGroupRightServiceDelegate().delete(gr);

        AuthorizationManager.singleton.recycleAllPermissions();
        return SUCCESS;
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

    public GroupRightServiceDelegate getGroupRightServiceDelegate() {
        return groupRightServiceDelegate;
    }

    public void setGroupRightServiceDelegate(
            GroupRightServiceDelegate groupRightServiceDelegate) {
        this.groupRightServiceDelegate = groupRightServiceDelegate;
    }
}