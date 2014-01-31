/*
 * Created on Nov 2, 2004
 *
 * 
 */
package com.fstx.stdlib2.authen.webwork;

import com.fsrin.menumine.common.ServiceDelegateException;
import com.fsrin.menumine.common.delete.DeleteCommand;
import com.fsrin.menumine.common.delete.DeleteCommandFailedException;
import com.fsrin.menumine.context.MenuMineSessionContext;
import com.fstx.stdlib2.authen.users.UserGroup;
import com.fstx.stdlib2.authen.users.UserGroupServiceDelegate;

/**
 * @author Nick
 * 
 *  
 */
public class UserGroupDeleteCommand extends DeleteCommand {

    private UserGroup target;

    private UserGroupServiceDelegate userGroupServiceDelegate;

    protected void handleDelete(MenuMineSessionContext cmmsSessionessionContext)
            throws DeleteCommandFailedException {
        // this.getUserServiceDelegate().setCmmsSessionContext(cmmsSessionessionContext);

        try {
            this.getUserGroupServiceDelegate()
                    .delete(this.getTargetUserGroup());
        } catch (ServiceDelegateException e) {
            throw new DeleteCommandFailedException(e);
        }

    }

    public String getTargetDescription() throws DeleteCommandFailedException {

        return this.getTargetUserGroup().getName();
    }

    public String getEffectDescription() throws DeleteCommandFailedException {

        return "This will permanently remove this  entry.";
    }

    public String getXWorkSuccess() throws DeleteCommandFailedException {

        return "success";
    }

    public UserGroup getTargetUserGroup() {
        return target;
    }

    public void setTargetUserGroup(UserGroup target) {
        this.target = target;
    }

    public UserGroupServiceDelegate getUserGroupServiceDelegate() {
        return userGroupServiceDelegate;
    }

    public void setUserGroupServiceDelegate(
            UserGroupServiceDelegate userGroupServiceDelegate) {
        this.userGroupServiceDelegate = userGroupServiceDelegate;
    }
}