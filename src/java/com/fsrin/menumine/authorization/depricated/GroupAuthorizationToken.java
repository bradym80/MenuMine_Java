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
public class GroupAuthorizationToken {

    private Long id;

    private UserGroup userGroup;

    private AuthorizationTokenEnum authorizationToken;

    protected GroupAuthorizationToken() {
        super();

    }

    public GroupAuthorizationToken(UserGroup userGroup,
            AuthorizationTokenEnum authorizationToken) {
        this.userGroup = userGroup;
        this.authorizationToken = authorizationToken;

    }

    public AuthorizationTokenEnum getAuthorizationToken() {
        return authorizationToken;
    }

    public void setAuthorizationToken(AuthorizationTokenEnum authorizationToken) {
        this.authorizationToken = authorizationToken;
    }

    public UserGroup getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(UserGroup userGroup) {
        this.userGroup = userGroup;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}