/*
 * Created on May 27, 2004
 *
 */
package com.fstx.stdlib2.author;

import java.util.Collection;

import com.fstx.stdlib2.authen.AuthenticatedUser;

/**
 * @author Reid
 *  
 */
public interface AuthorizedUser {

    public static final AuthorizedUserFactory factory = new AuthorizedUserFactory();

    public AuthenticatedUser getAuthenticatedUser();

    public Collection getAuthorizedActions();

}