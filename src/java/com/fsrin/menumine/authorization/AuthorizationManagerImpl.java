/*
 * Created on Jun 14, 2005
 *
 * 
 */
package com.fsrin.menumine.authorization;

import java.util.Collection;

import com.fstx.stdlib2.authen.users.GroupRight;
import com.fstx.stdlib2.authen.users.GroupRightServiceDelegate;
import com.fstx.stdlib2.authen.users.GroupRightServiceDelegateException;
import com.fstx.stdlib2.authen.users.UserGroup;
import com.fstx.stdlib2.author.SecuredAction;

/**
 * @author Nick
 * 
 *  
 */
public class AuthorizationManagerImpl implements AuthorizationManager {

    // private GroupAuthorizationTokenServiceDelegate
    // groupAuthorizationTokenServiceDelegate;
    private GroupRightServiceDelegate groupRightServiceDelegate;

    public AuthorizationManagerImpl() {
        super();

    }

    public void authorize(UserGroup userGroup, SecuredAction authorizationToken)
            throws AuthorizationManagerException {
        /*
         * Make sure the user is not already authorized.
         */
        if (this.isAuthorized(userGroup, authorizationToken)) {
            return;
        }

        try {
            this.getGroupRightServiceDelegate().add(authorizationToken,
                    userGroup);
        } catch (GroupRightServiceDelegateException e) {

            throw new AuthorizationManagerException(e);
        }

    }

    public boolean isAuthorized(UserGroup userGroup,
            SecuredAction authorizationToken) {

        GroupRight token = this.getGroupRightServiceDelegate().find(userGroup,
                authorizationToken);
        return token != null;

    }

    public void deauthorize(UserGroup userGroup,
            SecuredAction authorizationToken) {

        /*
         * Find the token.
         */
        GroupRight token = this.getGroupRightServiceDelegate().find(userGroup,
                authorizationToken);

        /*
         * If it is null we are not authorized anyway.
         */
        if (token == null) {
            return;
        }

        this.getGroupRightServiceDelegate().delete(token);

    }

    public AuthorizationBean prepareAuthorizationBean(UserGroup userGroup) {

        Collection tokens = this.getGroupRightServiceDelegate().getByGroup(
                userGroup);

        AuthorizationBean bean = new AuthorizationBean(tokens);
        return bean;

    }

    //    public GroupAuthorizationTokenServiceDelegate
    // getGroupAuthorizationTokenServiceDelegate() {
    //        return groupAuthorizationTokenServiceDelegate;
    //    }
    //
    //    public void setGroupAuthorizationTokenServiceDelegate(
    //            GroupAuthorizationTokenServiceDelegate
    // groupAuthorizationTokenServiceDelegate) {
    //        this.groupAuthorizationTokenServiceDelegate =
    // groupAuthorizationTokenServiceDelegate;
    //    }

    public GroupRightServiceDelegate getGroupRightServiceDelegate() {
        return groupRightServiceDelegate;
    }

    public void setGroupRightServiceDelegate(
            GroupRightServiceDelegate groupRightServiceDelegate) {
        this.groupRightServiceDelegate = groupRightServiceDelegate;
    }
}