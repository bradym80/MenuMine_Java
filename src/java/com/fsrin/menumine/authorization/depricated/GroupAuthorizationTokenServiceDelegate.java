/*
 * Created on Jun 14, 2005
 *
 * 
 */
package com.fsrin.menumine.authorization.depricated;

import java.util.Collection;

import com.fstx.stdlib2.authen.users.UserGroup;

/**
 * @author Nick
 * 
 *  
 */
public interface GroupAuthorizationTokenServiceDelegate {

    public void save(GroupAuthorizationToken token);

    public GroupAuthorizationToken find(UserGroup userGroup,
            AuthorizationTokenEnum authorizationToken);

    public void delete(GroupAuthorizationToken token);

    public Collection find(UserGroup userGroup);

}