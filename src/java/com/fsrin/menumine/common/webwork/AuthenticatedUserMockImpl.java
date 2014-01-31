/*
 * Created on Jun 2, 2005
 *
 * 
 */
package com.fsrin.menumine.common.webwork;

import com.fstx.stdlib2.authen.AuthenticatedUser;
import com.fstx.stdlib2.authen.users.User;

/**
 * @author Nick
 * 
 *  
 */
public class AuthenticatedUserMockImpl implements AuthenticatedUser {

    public AuthenticatedUserMockImpl() {
        super();

    }

    public String getEmail() {

        return null;
    }

    public Long getId() {

        return null;
    }

    public String getUsername() {

        return "Mock";
    }

    public User getUser() {

        return null;
    }

}