/*
 * Created on May 27, 2004
 *
 */
package com.fstx.stdlib2.author;

import java.util.Collection;
import java.util.TreeSet;

import com.fstx.stdlib2.authen.AuthenticatedUser;

/**
 * @author Reid
 *  
 */
public class AuthorizedUserFactory {

    public AuthorizedUser build(AuthenticatedUser authenticatedUser,
            SecuredAction securedAction) {
        Collection actions = new TreeSet();
        actions.add(securedAction);
        return build(authenticatedUser, actions);

    }

    public AuthorizedUser build(AuthenticatedUser authenticatedUser,
            Collection authorizedActions) {
        AuthorizedUserImpl ret = new AuthorizedUserImpl();

        ret.setAuthenticatedUser(authenticatedUser);
        ret.setAuthorizedActions(authorizedActions);

        return ret;
    }
}