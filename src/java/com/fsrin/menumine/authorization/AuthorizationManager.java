/*
 * Created on Jun 14, 2005
 *
 * 
 */
package com.fsrin.menumine.authorization;

import com.fstx.stdlib2.authen.users.UserGroup;
import com.fstx.stdlib2.author.SecuredAction;

/**
 * @author Nick
 * 
 *  
 */
public interface AuthorizationManager {
    
    public static final String SPRING_BEAN_NAME="authorizationManager";

    public void authorize(UserGroup userGroup, SecuredAction authorizationToken)
            throws AuthorizationManagerException;

    public boolean isAuthorized(UserGroup userGroup,
            SecuredAction authorizationToken);

    public void deauthorize(UserGroup userGroup,
            SecuredAction authorizationToken);

    public AuthorizationBean prepareAuthorizationBean(UserGroup userGroup);

}