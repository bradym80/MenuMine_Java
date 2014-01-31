/*
 * Created on Aug 12, 2004
 *
 * 
 */
package com.fstx.stdlib2.authen.users;

/**
 * @author Nick
 * 
 *  
 */
public class UserGroupBusinessObjectFactory {

    public UserGroupBusinessObject build(UserGroup userGroup) {
        UserGroupBusinessObject userGroupBusinessObject = new UserGroupBusinessObject();
        userGroupBusinessObject.setUserGroup(userGroup);
        return userGroupBusinessObject;
    }

}