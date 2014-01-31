/*
 * Created on Aug 12, 2004
 *

 */
package com.fstx.stdlib2.authen.webwork;

import com.fsrin.menumine.common.delete.DeleteContext;
import com.fsrin.menumine.common.webwork.GlobalForwardStatics;
import com.fstx.stdlib2.authen.users.UserGroup;
import com.fstx.stdlib2.authen.users.UserGroupServiceDelegate;
import com.opensymphony.xwork.Action;

/**
 * @author Nick
 * 
 */
public class UserGroupModifyAction extends AbstractUserModifyContextAwareAction {

    // private MenuMineSessionContextWrapper menuMineSessionContextWrapper;

    private UserGroupServiceDelegate userGroupServiceDelegate;

    private Long target;

    /*
     * Nick 2005.6.27 We specify a code we expect to be returned on delete. This
     * increases the liklyhood the user saw and clicked on the java script
     * confirm. Using the context we could make the code dynamic which would be
     * a bit better.
     */
    private String deleteConfCode = "DeleteGroup";

    private String deleteConfCodeReturned;

    private UserGroup userGroupParameters;

    private String delete;

    private String cancel;

    private UserGroupDeleteCommand deleteCommand;

    /*
     * (non-Javadoc)
     * 
     * @see com.opensymphony.xwork.Action#execute()
     */
    public String execute() throws Exception {

        if (this.getCancel() != null) {
            return SUCCESS;
        }

        /*
         * We depend on java script for confirmation.
         */
        if (this.getDelete() != null) {

            // if (!this.getDeleteConfCodeReturned().equals(
            // this.getDeleteConfCode())) {
            // this.addActionError("Delete Confirmation mismatch");
            // return ERROR;
            // }
            UserGroupDeleteCommand deleteCommand = (UserGroupDeleteCommand) this
                    .getDeleteCommand();
            if (deleteCommand == null) {
                this.addActionError("Error deleting"
                        + this.getUserModifyContext().getUser().toString());
                return GlobalForwardStatics.GLOBAL_ERROR;
            }
            deleteCommand.setTargetUserGroup(this.getUserModifyContext().getUserGroup());

            DeleteContext deleteContext = DeleteContext.factory
                    .build(deleteCommand);
            deleteContext.setSuccessOverride("groups");
            this.getMenuMineSessionContextWrapper().setDeleteContext(
                    deleteContext);

            // this.getUserGroupServiceDelegate().delete(
            // this.getUserModifyContext().getUserGroup());
            // this.getUserModifyContext().setUserGroup(null);

            return GlobalForwardStatics.GLOBAL_COMMON_DELETE;
            // return SUCCESS;
        }

        if (this.getTarget() != null) {
            UserGroup userGroup = this.getUserGroupServiceDelegate().find(
                    this.getTarget());
            this.getUserModifyContext().setUserGroup(userGroup);

            return INPUT;
        }
        /*
         * If we didn't get a target, and haven't already selected as User, we
         * need a new one.
         */

        if (this.getUserModifyContext().getUserGroup() == null) {
            this.getUserModifyContext().setUserGroup(new UserGroup());

        }
        if (this.getUserModifyContext().getUserGroup().getName() == null) {
            return INPUT;
        }

        UserGroup userGroup = this.getUserGroupParameters();

        UserGroup t = this.getUserGroupServiceDelegate().find(
                userGroup.getName());

        if (t != null && !t.getId().equals(userGroup.getId())) {
            this.addFieldError("userGroupParameters.name", "Name is already in use.");
            return Action.INPUT;
        }

        this.getUserGroupServiceDelegate().save(userGroup);

        /*
         * We are done with this user.
         */
        this.getUserModifyContext().setUserGroup(null);

        return SUCCESS;
    }

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

    // public UserModifyContext getUserModifyContext() {
    // UserModifyContext context = UserModifyContext.factory.getContext();
    // return context;
    // }

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

    public UserGroup getUserGroupParameters() {
        if (userGroupParameters == null) {
            userGroupParameters = this.getUserModifyContext().getUserGroup();
        }
        return userGroupParameters;
    }

    public String getCancel() {
        return cancel;
    }

    public void setCancel(String cancel) {
        this.cancel = cancel;
    }

    public String getDelete() {
        return delete;
    }

    public void setDelete(String delete) {
        this.delete = delete;
    }

    public UserGroupDeleteCommand getDeleteCommand() {
        return deleteCommand;
    }

    public void setUserGroupDeleteCommand(UserGroupDeleteCommand deleteCommand) {
        this.deleteCommand = deleteCommand;
    }

    public String getDeleteConfCode() {
        return deleteConfCode;
    }

    public void setDeleteConfCode(String deleteConfCode) {
        this.deleteConfCode = deleteConfCode;
    }

    public String getDeleteConfCodeReturned() {
        return deleteConfCodeReturned;
    }

    public void setDeleteConfCodeReturned(String deleteConfCodeReturned) {
        this.deleteConfCodeReturned = deleteConfCodeReturned;
    }
}