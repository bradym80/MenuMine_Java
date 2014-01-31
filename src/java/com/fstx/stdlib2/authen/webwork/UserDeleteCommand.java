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
import com.fstx.stdlib2.authen.users.User;
import com.fstx.stdlib2.authen.users.UserServiceDelegate;

/**
 * @author Nick
 * 
 *  
 */
public class UserDeleteCommand extends DeleteCommand {

    private User target;

    private UserServiceDelegate userServiceDelegate;

    protected void handleDelete(MenuMineSessionContext cmmsSessionessionContext)
            throws DeleteCommandFailedException {
        // this.getUserServiceDelegate().setCmmsSessionContext(cmmsSessionessionContext);

        try {
            this.getUserServiceDelegate().delete(this.getTargetUser());
        } catch (ServiceDelegateException e) {
            throw new DeleteCommandFailedException(e);
        }

    }

    public String getTargetDescription() throws DeleteCommandFailedException {

        return this.getTargetUser().getUsername();
    }

    public String getEffectDescription() throws DeleteCommandFailedException {

        return "This will permanently remove this  entry.";
    }

    public String getXWorkSuccess() throws DeleteCommandFailedException {

        return "success.users";
    }

    public User getTargetUser() {
        return target;
    }

    public void setTargetUser(User target) {
        this.target = target;
    }

    public UserServiceDelegate getUserServiceDelegate() {
        return userServiceDelegate;
    }

    public void setUserServiceDelegate(UserServiceDelegate userServiceDelegate) {
        this.userServiceDelegate = userServiceDelegate;
    }
}