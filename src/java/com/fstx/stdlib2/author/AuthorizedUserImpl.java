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
class AuthorizedUserImpl implements AuthorizedUser {

    private AuthenticatedUser authenticatedUser;

    private Collection authorizedActions;

    /*
     * (non-Javadoc)
     * 
     * @see com.fstx.stdlib2.author.AuthorizedUser#getAuthenticatedUser()
     */
    public AuthenticatedUser getAuthenticatedUser() {
        return this.authenticatedUser;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.fstx.stdlib2.author.AuthorizedUser#getAuthorizedAction()
     */
    public Collection getAuthorizedActions() {
        return this.authorizedActions;
    }

    /**
     * @param user
     */
    public void setAuthenticatedUser(AuthenticatedUser user) {
        authenticatedUser = user;
    }

    /**
     * @param collection
     */
    public void setAuthorizedActions(Collection collection) {
        authorizedActions = collection;
    }

}