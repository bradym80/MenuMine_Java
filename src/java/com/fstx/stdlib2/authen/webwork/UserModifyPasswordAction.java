/*
 * Created on Aug 12, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.fstx.stdlib2.authen.webwork;

import java.util.Collection;

import com.fstx.stdlib2.authen.users.User;
import com.fstx.stdlib2.authen.users.UserRole;
import com.fstx.stdlib2.authen.users.UserServiceDelegate;

/**
 * @author Nick
 *  
 */
public class UserModifyPasswordAction extends AbstractUserModifyContextAwareAction {

//    private MenuMineSessionContextWrapper menuMineSessionContextWrapper;

    private UserServiceDelegate userServiceDelegate;

    private Long target;

    private String delete;

    private String cancel;

    private String submit;

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

        if (this.getCancel() != null) {
            this.getUserModifyContext().setUser(null);
            return SUCCESS;
        }

        if (this.getTarget() != null) {
            User user = this.getUserServiceDelegate().find(this.getTarget());
            this.getUserModifyContext().setUser(user);
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

        User user = params.getUser();

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
            userParameters.setPasswordConfirm(this.getUserModifyContext().getUser()
                    .getPassword());
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

//    public MenuMineSessionContextWrapper getMenuMineSessionContextWrapper() {
//        return menuMineSessionContextWrapper;
//    }
//
//    public void setMenuMineSessionContextWrapper(
//            MenuMineSessionContextWrapper menuMineSessionContextWrapper) {
//        this.menuMineSessionContextWrapper = menuMineSessionContextWrapper;
//    }

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