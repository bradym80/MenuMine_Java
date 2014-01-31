/*
 * Created on Aug 12, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.fstx.stdlib2.authen.webwork;

import com.fstx.stdlib2.authen.users.User;
import com.fstx.stdlib2.authen.users.UserGroup;
import com.fstx.stdlib2.authen.users.UserGroupBusinessObject;

/**
 * @author Nick
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public class UserModifyContext {

    public static UserModifyContextFactory factory = new UserModifyContextFactory();

    public static final String KEY = "user.modify.context";

    private User user;

    private UserGroup userGroup;

    /**
     * @return Returns the user.
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user
     *            The user to set.
     */
    public void setUser(User user) {
        this.user = user;
    }

    public UserGroup getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(UserGroup userGroup) {
        this.userGroup = userGroup;
    }

    public UserGroupBusinessObject getUserGroupBusinessObject() {

        UserGroupBusinessObject ugbo = UserGroupBusinessObject.factory
                .build(this.getUserGroup());

        return ugbo;
    }
}