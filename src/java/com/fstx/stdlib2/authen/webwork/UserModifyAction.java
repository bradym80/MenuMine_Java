/*
 * Created on Aug 12, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.fstx.stdlib2.authen.webwork;

import java.util.Collection;

import com.fsrin.menumine.common.delete.DeleteCommand;
import com.fsrin.menumine.common.delete.DeleteContext;
import com.fsrin.menumine.common.webwork.GlobalForwardStatics;
import com.fsrin.menumine.users.UserPreferenceServiceDelegateFactory;
import com.fstx.stdlib2.authen.LoginHistoryBDFactory;
import com.fstx.stdlib2.authen.users.User;
import com.fstx.stdlib2.authen.users.UserGroupServiceDelegate;
import com.fstx.stdlib2.authen.users.UserRole;
import com.fstx.stdlib2.authen.users.UserServiceDelegate;

/**
 * @author Nick
 * 
 */
public class UserModifyAction extends AbstractUserModifyContextAwareAction {

    // private MenuMineSessionContextWrapper menuMineSessionContextWrapper;

    private UserServiceDelegate userServiceDelegate;

    private Long target;

    private String delete;

    private String cancel;

    private String submit;

    private UserDeleteCommand userDeleteCommand;

    private UserParameters userParameters;

    private Collection userGroups;

    private Collection userPreferences;

    private Collection userLoginHistory;

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

    /*
     * (non-Javadoc)
     * 
     * @see com.opensymphony.xwork.Action#execute()
     */
    public String execute() throws Exception {
        // throw new RuntimeException(
        // "We should only be using the list bases editing.");
        if (this.getCancel() != null) {
            this.getUserModifyContext().setUser(null);
            return SUCCESS;
        }

        if (this.getDelete() != null) {

            UserDeleteCommand deleteCommand = (UserDeleteCommand) this
                    .getUserDeleteCommand();
            if (deleteCommand == null) {
                this.addActionError("Error deleting"
                        + this.getUserModifyContext().getUser().toString());
                return GlobalForwardStatics.GLOBAL_ERROR;
            }
            deleteCommand.setTargetUser(this.getUserModifyContext().getUser());

            DeleteContext deleteContext = DeleteContext.factory
                    .build(deleteCommand);
            deleteContext.setSuccessOverride("global-delete-user-success");

            this.getMenuMineSessionContextWrapper().setDeleteContext(
                    deleteContext);

            this.getUserModifyContext().setUser(null);

            return GlobalForwardStatics.GLOBAL_COMMON_DELETE;
        }

        if (this.getTarget() != null) {
            User user = this.getUserServiceDelegate().find(this.getTarget());
            this.getUserModifyContext().setUser(user);

            /*
             * 2006-04-19 RSC setup the recent login history
             */
            Collection hist = LoginHistoryBDFactory.factory.build()
                    .listForUser(user.getUsername());
            this.setUserLoginHistory(hist);

            /*
             * 2006-04-19 RSC setup preference information
             */
            Collection prefs = UserPreferenceServiceDelegateFactory.build()
                    .getUserPreferences(user.getUsername());
            this.setUserPreferences(prefs);

            return INPUT;
        }
        /*
         * If we didn't get a target, and haven't already selected as User, we
         * need a new one.
         */
        if (this.getUserModifyContext().getUser() == null) {
            this.getUserModifyContext().setUser(new User());
            return INPUT;
        }

        if (this.getSubmit() == null) {
            return INPUT;
        }

        UserParameters params = this.getUserParameters();
        if (!params.isValid()) {
            this.addFieldError("userParameters.password",
                    "Passwords do not match.");
            return INPUT;
        }

        if (params.getExpirationDate() == null) {
            this.addFieldError("userParameters.expirationDate",
                    "You must enter an expiration date.  (MM/DD/YYYY)");

            return INPUT;
        }
        User user = params.getUser();

        User testUser = this.getUserServiceDelegate().getByUsername(
                params.getUsername());
        if (testUser != null
                && (user.getId() == null || testUser.getId().longValue() != user
                        .getId().longValue())) {
            this.addFieldError("userParameters.username",
                    "Username already taken.");
            return INPUT;
        }
        testUser = this.getUserServiceDelegate().getUserByEmail(
                params.getEmail());
        if (testUser != null
                && (user.getId() == null || testUser.getId().longValue() != user
                        .getId().longValue())) {
            this.addFieldError("userParameters.email",
                    "A user with this e-mail is already in the system.");
            return INPUT;
        }

        this.getUserServiceDelegate().save(user);

        /*
         * We are done with this user.
         */
        this.getUserModifyContext().setUser(null);

        return SUCCESS;
    }

    public UserParameters getUserParameters() {
        if (userParameters == null) {
            userParameters = new UserParameters();
            userParameters.setUser(this.getUserModifyContext().getUser());
            userParameters.setPasswordConfirm(this.getUserModifyContext()
                    .getUser().getPassword());
        }
        return userParameters;
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

    public DeleteCommand getDeleteCommand() {
        return this.getUserDeleteCommand();
    }

    // public MenuMineSessionContextWrapper getMenuMineSessionContextWrapper() {
    // return menuMineSessionContextWrapper;
    // }
    //
    // public void setMenuMineSessionContextWrapper(
    // MenuMineSessionContextWrapper menuMineSessionContextWrapper) {
    // this.menuMineSessionContextWrapper = menuMineSessionContextWrapper;
    // }

    public UserDeleteCommand getUserDeleteCommand() {
        return userDeleteCommand;
    }

    public void setUserDeleteCommand(UserDeleteCommand userDeleteCommand) {
        this.userDeleteCommand = userDeleteCommand;
    }

    public Collection getUserRoles() {
        return UserRole.getAll();
    }

    public String getSubmit() {
        return submit;
    }

    public void setSubmit(String submit) {
        this.submit = submit;
    }

    public Collection getUserGroups() {
        if (userGroups == null) {
            this.setUserGroups(UserGroupServiceDelegate.factory.build()
                    .getAll());
        }
        return userGroups;
    }

    public void setUserGroups(Collection userGroups) {
        this.userGroups = userGroups;
    }

    public Collection getUserLoginHistory() {
        return userLoginHistory;
    }

    public void setUserLoginHistory(Collection userLoginHistory) {
        this.userLoginHistory = userLoginHistory;
    }

    public Collection getUserPreferences() {
        return userPreferences;
    }

    public void setUserPreferences(Collection userPreferences) {
        this.userPreferences = userPreferences;
    }
}