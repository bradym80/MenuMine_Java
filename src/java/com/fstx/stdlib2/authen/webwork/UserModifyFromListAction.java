/*
 * Created on Aug 12, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.fstx.stdlib2.authen.webwork;

import java.util.Collection;

import com.fsrin.menumine.common.delete.DeleteCommand;
import com.fstx.stdlib2.authen.users.User;
import com.fstx.stdlib2.authen.users.UserRole;
import com.fstx.stdlib2.authen.users.UserServiceDelegate;

/**
 * @author Nick
 *  
 */
public class UserModifyFromListAction extends AbstractUserModifyContextAwareAction {

//    private MenuMineSessionContextWrapper menuMineSessionContextWrapper;

    private UserServiceDelegate userServiceDelegate;

    private Long target;

    private String delete;

    private String cancel;

    private String submit;

    private UserDeleteCommand userDeleteCommand;

    private UserParameters userParameters;

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

        //        if (this.getCancel() != null) {
        //            this.getContext().setUser(null);
        //            return SUCCESS;
        //        }
        //
        //        if (this.getDelete() != null) {
        //
        //            UserDeleteCommand deleteCommand = (UserDeleteCommand) this
        //                    .getUserDeleteCommand();
        //            if (deleteCommand == null) {
        //                this.addActionError("Error deleting"
        //                        + this.getContext().getUser().toString());
        //                return GlobalForwardStatics.GLOBAL_ERROR;
        //            }
        //            deleteCommand.setTargetUser(this.getContext().getUser());
        //
        //            DeleteContext deleteContext = DeleteContext.factory
        //                    .build(deleteCommand);
        //            deleteContext.setSuccessOverride("global-delete-user-success");
        //            this.getMenuMineSessionContextWrapper().setDeleteContext(
        //                    deleteContext);
        //
        //            this.getContext().setUser(null);
        //
        //            return GlobalForwardStatics.GLOBAL_COMMON_DELETE;
        //        }
        if (this.getSubmit() == null) {
            return INPUT;
        }

        //        User user;
        //        if (this.getUserParameters().getId() != null) {
        //            user = this.getUserServiceDelegate().find(this.getTarget());
        //            // this.getContext().setUser(user);
        //        }else{
        //            user = new User();
        //        }

        UserParameters params = this.getUserParameters();
        //        if (!params.isValid()) {
        //            this.addFieldError("userParameters.password",
        //                    "Passwords do not match.");
        //            return INPUT;
        //        }

        String pw = params.getPassword();
        int l = pw.length();

        if (pw == null || l < 6) {
            //            this.addFieldError("userParameters.password",
            //                    "The password must be at leasst 6 characters long");
            this
                    .addActionError("The password must be at least 6 characters long");

            return INPUT;
        }
        User testUser = this.getUserServiceDelegate().getByUsername(
                params.getUsername());
        if (testUser != null
                && (params.getId() == null || testUser.getId().longValue() != params
                        .getId().longValue())) {
            //            this.addFieldError("userParameters.username",
            //                    "Username already taken.");
            this.addActionError("Username already taken.");
            return INPUT;
        }
        testUser = this.getUserServiceDelegate().getUserByEmail(
                params.getEmail());
        if (testUser != null
                && (params.getId() == null || testUser.getId().longValue() != params
                        .getId().longValue())) {
            //            this.addFieldError("userParameters.email",
            //                    "A user with this e-mail is already in the system.");
            this
                    .addActionError("A user with this e-mail is already in the system.");

            return INPUT;
        }

        params.setPasswordConfirm(params.getPassword());
        User user = params.getUser();

        this.getUserServiceDelegate().save(user);

        return SUCCESS;
    }

    public UserParameters getUserParameters() {
        if (userParameters == null) {
            userParameters = new UserParameters();
            userParameters.setUser(new User());
            //            userParameters.setPasswordConfirm(this.getContext().getUser()
            //                    .getPassword());
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

//    public MenuMineSessionContextWrapper getMenuMineSessionContextWrapper() {
//        return menuMineSessionContextWrapper;
//    }
//
//    public void setMenuMineSessionContextWrapper(
//            MenuMineSessionContextWrapper menuMineSessionContextWrapper) {
//        this.menuMineSessionContextWrapper = menuMineSessionContextWrapper;
//    }

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
}