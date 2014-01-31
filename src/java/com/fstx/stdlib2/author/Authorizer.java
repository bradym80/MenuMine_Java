/*
 * Created on May 27, 2004
 *
 */
package com.fstx.stdlib2.author;

import java.io.Serializable;

import com.fstx.stdlib2.authen.AuthenticatedUser;

/**
 * <p>
 * Converted from standard Authorizer.
 * 
 * @author Reid
 *  
 */
public interface Authorizer extends Serializable {

    public static final AuthorizerImpl singleton = new AuthorizerImpl();

    // No to be used for security checks.
    public abstract boolean isAuthorized(String user, String action);

    public abstract boolean isAuthorized(String user, SystemRights right);

    public abstract boolean isAuthorized(AuthenticatedUser user,
            SystemRights right);

    public abstract boolean isAuthorizedForAny(AuthenticatedUser user,
            SystemRights[] rights);

    public abstract boolean isAuthorized(AuthenticatedUser user, String action);

    public abstract AuthorizedUser authorize(AuthenticatedUser user,
            SecuredAction action) throws AuthorizerFailedException;

    public abstract AuthorizedUser authorize(AuthenticatedUser user,
            Authorizeable serviceDelegate) throws AuthorizerFailedException;
}