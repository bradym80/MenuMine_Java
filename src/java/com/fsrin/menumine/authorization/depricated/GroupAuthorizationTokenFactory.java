/*
 * Created on Jun 14, 2005
 *
 * 
 */
package com.fsrin.menumine.authorization.depricated;

import com.fstx.stdlib2.authen.users.UserGroup;

/**
 * @author Nick
 * 
 *  
 */
public class GroupAuthorizationTokenFactory {

    public static final GroupAuthorizationTokenFactory singleton = new GroupAuthorizationTokenFactory();

    private GroupAuthorizationTokenFactory() {
        super();

    }

    public GroupAuthorizationToken build(UserGroup userGroup,
            AuthorizationTokenEnum authorizationToken) {
        GroupAuthorizationToken token = new GroupAuthorizationToken(userGroup,
                authorizationToken);

        return token;
    }

}