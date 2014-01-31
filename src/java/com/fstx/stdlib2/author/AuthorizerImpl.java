/*
 * Created on Aug 18, 2003
 *
 */
package com.fstx.stdlib2.author;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fstx.stdlib2.authen.AuthenticatedUser;

/**
 * <p>
 * Added the authorized user return section.
 * 
 * @version 2004-05-27
 * @author Reid
 * @author Nick
 *  
 */
public class AuthorizerImpl implements Authorizer {

    public AuthorizerImpl() {
        super();
    }

    public boolean isAuthorized(AuthenticatedUser user, SystemRights right) {

        return isAuthorized(user, right.getName());
    }

    public boolean isAuthorizedForAny(AuthenticatedUser user,
            SystemRights[] rights) {
        boolean ret = false;

        for (int i = 0; i < rights.length; i++) {
            if (rights[i] != null && isAuthorized(user, rights[i])) {
                ret = true;
                break;
            }
        }

        return ret;
    }

    public boolean isAuthorized(AuthenticatedUser user, String action) {
        AuthorizationBean ab = null;
        if (user == null || action == null) {
            return false;
        }
        try {
            ab = AuthorizationManager.singleton.getAuthorizationBean(user
                    .getUsername());
            if (ab == null) {
                throw new AuthorizationException();
            }
        } catch (AuthorizationException e) {
            log.error("Unable to retrieve auth list for:  "
                    + user.getUsername());
            return false;
        }
        //Check if user is authorized to use action
        return ab.isAuthorized(action);
    }

    public boolean isAuthorized(String user, SystemRights right) {
        return isAuthorized(user, right.getName());
    }

    // No to be used for security checks.
    public boolean isAuthorized(String user, String action) {
        AuthorizationBean ab = null;
        if (user == null || action == null) {
            return false;
        }
        try {
            ab = AuthorizationManager.singleton.getAuthorizationBean(user);
            if (ab == null) {
                throw new AuthorizationException();
            }
        } catch (AuthorizationException e) {
            log.error("Unable to retrieve auth list for:  " + user);
            return false;
        }
        //Check if user is authorized to use action
        return ab.isAuthorized(action);
    }

    static Log log = LogFactory.getLog(AuthorizerImpl.class.getName());

    /*
     * (non-Javadoc)
     * 
     * @see com.fstx.stdlib2.author.Authorizer#authorize(com.fstx.stdlib2.authen.AuthenticatedUser,
     *      com.fstx.stdlib2.author.SecuredAction)
     */
    public AuthorizedUser authorize(AuthenticatedUser user, SecuredAction action)
            throws AuthorizerFailedException {

        if (user == null) {
            throw new AuthorizerFailedException("No User Specified");
        }
        if (action == null) {
            throw new AuthorizerFailedException("No Secure Action Specified");
        }
        if (!isAuthorized(user, action.getActionName())) {
            throw new AuthorizerFailedException();
        }

        AuthorizedUser ret = AuthorizedUser.factory.build(user, action);

        return ret;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.fstx.stdlib2.author.Authorizer#authorize(com.fstx.stdlib2.authen.AuthenticatedUser,
     *      com.fstx.stdlib2.author.Authorizeable)
     */
    public AuthorizedUser authorize(AuthenticatedUser user,
            Authorizeable serviceDelegate) throws AuthorizerFailedException {
        return authorize(user, serviceDelegate.getSecuredAction());
    }
}