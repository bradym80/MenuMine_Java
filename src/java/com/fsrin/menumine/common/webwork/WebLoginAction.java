/*
 * Created on 2005-1-14
 *
 */
package com.fsrin.menumine.common.webwork;

import java.util.Collection;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.fsrin.menumine.common.ServiceDelegateException;
import com.fsrin.menumine.common.util.PromoNotificationAlert;
import com.fsrin.menumine.context.webwork.AbstractMenuMineSessionContextAwareAction;
import com.fstx.stdlib2.authen.AuthenticatedUser;
import com.fstx.stdlib2.authen.Authenticator;
import com.fstx.stdlib2.authen.UnableToAuthenticateException;
import com.fstx.stdlib2.authen.users.UserGroup;
import com.fstx.stdlib2.authen.users.UserGroupServiceDelegate;
import com.fstx.stdlib2.authen.users.UserRole;

/**
 * @author Nick
 * 
 */
public class WebLoginAction extends AbstractMenuMineSessionContextAwareAction
        implements ApplicationContextAware {

    private Log log = LogFactory.getLog(WebLoginAction.class);

    public static final String SUCCESS_ADMIN = "admin";

    private String username;

    private String password;

    private String submit;

    // private MenuMineSessionContextWrapper menuMineSessionContextWrapper;

    public static final String SPRING_BEAN_NAME = "webLoginAction";

    public String execute() throws Exception {
        if (this.getSubmit() == null) {

            return INPUT;
        }

        if (this.getUsername() == null
                || this.getUsername().trim().length() == 0) {
            this.addFieldError("username", "Username is required.");
        }

        if (this.getPassword() == null
                || this.getPassword().trim().length() == 0) {
            this.addFieldError("password", "Password is required.");
        }

        if (this.hasErrors())
            return INPUT;

        AuthenticatedUser auser = null;

        try {
            auser = Authenticator.singleton.authenticate(getUsername(),
                    getPassword());

            // this.getSessionContext().setUser(auser);
        } catch (UnableToAuthenticateException e) {

            this
                    .addActionError("Could not authenticate that username and password.");
            return INPUT;
        }

        if (auser.getUser().isInactive()) {
            this.addActionError("Could not authenticate: User is inactive.");
            return INPUT;
        }

        if (auser.getUser().getExpirationDate() != null
                && auser.getUser().getExpirationDate().before(new Date())) {
            this
                    .addActionError("Could not authenticate: User account has expired.");
            return INPUT;
        }

        // ComponentManager cm = (ComponentManager) ActionContext.getContext()
        // .getSession().get("DefaultComponentManager");
        //
        // MenuMineSessionContextWrapper sc = (MenuMineSessionContextWrapper) cm
        // .getComponent(MenuMineSessionContextWrapperAware.class);

        this.getMenuMineSessionContextWrapper().setAuthenticatedUser(auser);
        UserGroup group = this.getUserGroup(auser);

        this.getMenuMineSessionContextWrapper().setUserGroup(group);

        UserLoginEvent event = new UserLoginEvent(this);
        event.setAuthenticatedUser(auser);
        this.getApplicationContext().publishEvent(event);

        if (auser.getUser().getRoleName().equals(UserRole.PROMO.getName())) {

            new PromoNotificationAlert().sendAlert("Promo user has logged in.",
                    this.getMenuMineSessionContextWrapper()
                            .getMenuMineSessionContext());

        }

        if (auser.getUser().getRoleName().equals(UserRole.ADMIN.getName())) {
            return WebLoginAction.SUCCESS_ADMIN;
        } else {
            return SUCCESS;
        }

    }

    private UserGroup getUserGroup(AuthenticatedUser auser)
            throws ServiceDelegateException {

        /*
         * In menumine a user can only be in one group.
         */
        Collection col = UserGroupServiceDelegate.factory.build()
                .getGroupsByUser(auser.getUser());

        if (col.size() > 0) {
            return (UserGroup) col.toArray()[0];
        }
        return null;
    }

    /**
     * @return
     */
    public String getSubmit() {
        return submit;
    }

    /**
     * @param string
     */
    public void setSubmit(String string) {
        submit = string;
    }

    // /**
    // * @return
    // */
    // public MenuMineSessionContextWrapper getMenuMineSessionContextWrapper() {
    // return menuMineSessionContextWrapper;
    // }
    //
    // /**
    // * @param wrapper
    // */
    // public void setMenuMineSessionContextWrapper(
    // MenuMineSessionContextWrapper wrapper) {
    // menuMineSessionContextWrapper = wrapper;
    // }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext arg0)
            throws BeansException {
        applicationContext = arg0;
    }

    protected ApplicationContext getApplicationContext() {
        return applicationContext;
    }
}